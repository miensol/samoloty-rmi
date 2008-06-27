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
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;

import common.Gaming;
import common.Piloting;
import common.Playing;

public class AnimationCanvas extends JLabel implements Runnable {
	  Thread thread;

	  Image image;
	  
	  Vector<String>imagesOwners;
	   
	  BufferedImage bi;
	  public Map<String,Playing> players;
	  public Map<String,Piloting> planes;
	  double x, y, xi, yi;

	  int rotate;

	  double scale;

	  int UP = 0;

	  int DOWN = 1;
	  URL url;
	  int scaleDirection;
	  public MediaTracker mt;
	  public Gaming game;
	  
	  public AnimationCanvas() {
	    setBackground(Color.blue);
	    setSize(800, 600);
	    url = getClass().getResource("samolocik.gif");
	    image = getToolkit().getImage(url);

	    mt = new MediaTracker(this);
	    mt.addImage(image, 1);


	    imagesOwners = new Vector<String>();

	    try {
	      mt.waitForAll();
	    } catch (Exception e) {
	      System.out.println("Exception while loading image.");
	    }

	    if (image.getWidth(this) == -1) {
	      System.out.println("No gif file");
	      System.exit(0);
	    }

	    rotate = (int) 0;
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
	    Dimension d = new Dimension(800,600);
	    //System.out.println("Wymair d = "+d.getHeight()+ "x"+ d.getWidth());
	    for(String s:imagesOwners){
	    	bi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
	    	Graphics2D big = bi.createGraphics();
	    	//System.out.println("Rysuje gracza "+s);
	    	//step(d.width, d.height);
	    	try{
	    		Piloting plane = planes.get(s);
	    		x = plane.getX();
	    		y = plane.getY();
	    		//rotate = plane.getAngle();
	    	
	    	AffineTransform at = new AffineTransform();
	    	at.setToIdentity();
	    	at.translate(x, y);
	    	at.rotate(plane.getAngle());
	    //at.scale(scale, scale);
	    
	    	big.drawImage(image, at, this);

	    	Graphics2D g2D = (Graphics2D) g;
	    	g2D.drawImage(bi, 0, 0, null);
	    	}catch(RemoteException e){
	    		e.printStackTrace();
	    	}

	    	big.dispose();
	    }
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
	    	addImages();	
	    	repaint();
	    	try{
	    		Thread.sleep(20);	    		
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}
	    }
	    thread = null;
	  }
	  public void addImages(){
		  try{
			  if(imagesOwners.size()==0 && !this.game.isWaitForPlayers() ){
				  players = game.getPlayers();
				  planes = new HashMap<String, Piloting>();
				  for(Map.Entry<String, Playing> el:players.entrySet()){
					  imagesOwners.add(el.getKey());		
					  planes.put(el.getKey(), el.getValue().getPlane());
				  }
			  }
		  }catch(RemoteException e){
			  e.printStackTrace();
		  }
	  }
}