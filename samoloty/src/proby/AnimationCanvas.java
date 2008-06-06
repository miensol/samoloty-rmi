package proby;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import gui.img.*;
public class AnimationCanvas extends JLabel implements Runnable {
  Thread thread;

  Image image;
  Image[] imageTable;
  BufferedImage bi;
  BufferedImage[] imgBuf;
  Graphics2D[] graph;
  double x, y, xi, yi;

  int rotate;

  double scale;

  int UP = 0;

  int DOWN = 1;

  int scaleDirection;

  public AnimationCanvas() {
    setBackground(Color.green);
    setSize(450, 400);
    imageTable = new Image[360];
    imgBuf = new BufferedImage[360];
    graph = new Graphics2D[360];
    image = getToolkit().getImage("E:\\Documents and Settings\\Piotr\\Moje dokumenty\\piotr\\Rok 3 semestr 2\\SR\\samoloty\\src\\gui\\img\\samolocik.GIF");
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(image, 1);
    try {
      mt.waitForAll();
    } catch (Exception e) {
      System.out.println("Exception while loading image.");
    }

    if (image.getWidth(this) == -1) {
      System.out.println("No gif file");
      System.exit(0);
    }

    for(int i =0; i<360; ++i){
    	//imageTable[i] = image.getScaledInstance(-1, -1,Image.SCALE_FAST);
    	 AffineTransform at = new AffineTransform();
    	 at.setToIdentity();
    	 at.rotate(Math.toRadians(i));
    	 imgBuf[i]= new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_4BYTE_ABGR);
    	 graph[i] = imgBuf[i].createGraphics();
    	 graph[i].drawImage(image, at, this);
    	 
    }

    rotate = (int) (Math.random() * 360);
    scale = 1;
    scaleDirection = DOWN;

    xi = 50.0;
    yi = 50.0;

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
   
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Dimension d = getSize();

    bi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D big = bi.createGraphics();

    step(d.width, d.height);

    AffineTransform at = new AffineTransform();
    at.setToIdentity();
    at.translate(x, y);
    //at.rotate(Math.toRadians(rotate));
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
      repaint();
    }
    thread = null;
  }
}

