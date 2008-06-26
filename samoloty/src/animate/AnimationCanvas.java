package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Map;

import javax.swing.JLabel;

import common.Gaming;
import common.Playing;

public class AnimationCanvas extends JLabel implements Runnable {
	  Thread thread;

	  Image image;
	  Image image2;

	  BufferedImage bi;
	  public Map<String,Playing> players;
	  double x, y, xi, yi;

	  int rotate;

	  double scale;

	  int UP = 0;

	  int DOWN = 1;

	  int scaleDirection;
	  public MediaTracker mt;
	  public Gaming game;
	  
	  public AnimationCanvas() {
	    setBackground(Color.blue);
	    setSize(800, 600);
	    URL url = getClass().getResource("samolocik.gif");
	    image = getToolkit().getImage(url);
	    image2 = getToolkit().getImage(url);
	    mt = new MediaTracker(this);
	    mt.addImage(image, 1);
	    mt.addImage(image2, 2);
	    
	    try {
	      mt.waitForAll();
	    } catch (Exception e) {
	      System.out.println("Exception while loading image.");
	    }

	    if (image.getWidth(this) == -1) {
	      System.out.println("No gif file");
	      System.exit(0);
	    }

	    rotate = (int) (Math.random() * 360);
	    scale = Math.random() * 1.5;
	    scaleDirection = DOWN;

	    xi = 50.0;
	    yi = 50.0;

	  }
	  public void setGame(Gaming game){
		  this.game = game;
	  }
	  public void step(int w, int h) {
	    x += xi;
	    y += yi;

	    if (x > w) {
	      x = w - 1;
	      xi = Math.random() * -w / 32;
	    }
	    if (x < 0) {
	      x = 2;
	      xi = Math.random() * w / 32;
	    }
	    if (y > h) {
	      y = h - 2;
	      yi = Math.random() * -h / 32;
	    }
	    if (y < 0) {
	      y = 2;
	      yi = Math.random() * h / 32;
	    }

	    if ((rotate += 5) == 360) {
	      rotate = 0;
	    }
	    if (scaleDirection == UP) {
	      if ((scale += 0.5) > 1.5) {
	        scaleDirection = DOWN;
	      }
	    } else if (scaleDirection == DOWN) {
	      if ((scale -= .05) < 0.5) {
	        scaleDirection = UP;
	      }
	    }
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();

	    bi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D big = bi.createGraphics();
	    System.out.println("Wymair d = "+d.getHeight()+ "x"+ d.getWidth());
	    step(d.width, d.height);

	    AffineTransform at = new AffineTransform();
	    at.setToIdentity();
	    at.translate(x, y);
	    at.rotate(Math.toRadians(rotate));
	    //at.scale(scale, scale);
	    
	    big.drawImage(image, at, this);

	    Graphics2D g2D = (Graphics2D) g;
	    g2D.drawImage(bi, 0, 0, null);

	    big.dispose();
	  }

	  public void start() {
	    thread = new Thread(this);
	    thread.setPriority(Thread.MIN_PRIORITY);
	    thread.start();
	  }

	  public void stop() {
	    if (thread != null)
	      thread.interrupt();
	    thread = null;
	  }

	  public void run() {
	    Thread me = Thread.currentThread();
	    while (thread == me) {
	    	/*
	    try{
	      if(!this.game.isWaitForPlayers() && this.players == null){
	    	  this.players = this.game.getPlayers();
	      }
	    }catch(RemoteException e){
	    	e.printStackTrace();
	    }
	    */
	      repaint();
	    }
	    thread = null;
	  }
}