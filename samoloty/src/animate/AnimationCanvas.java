package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.Gaming;
import common.Piloting;
import common.Playing;

public class AnimationCanvas extends JLabel implements Runnable {
	  Thread thread;
	  private JButton[] playersB;
		private JTextField[] scores;
	  Image image;
	  Image bullet ;
	  Vector<String>imagesOwners;
	  public int errorCount = 0;
	  BufferedImage bi;
	  public Map<String,Playing> players;
	  public Map<String,Piloting> planes;
	  double x, y, xi, yi;
	  Dimension d;
	  int rotate;

	  double scale;

	  int UP = 0;
	  int width = 10;
	  int height = 10;
	  int DOWN = 1;
	  URL url;
	  int scaleDirection;
	  public MediaTracker mt;
	  public Gaming game;
	  AffineTransform at;
	  Graphics2D big;
	  public AnimationCanvas() {
	    setBackground(Color.blue);
	    setSize(800, 600);
	    url = getClass().getResource("samolocik.gif");
	    image = getToolkit().getImage(url);
	    url = getClass().getResource("bullet.gif");
	    bullet = getToolkit().getImage(url);
	    
	    mt = new MediaTracker(this);
	    mt.addImage(image, 1);
	    mt.addImage(bullet, 2);
	    d  = new Dimension(800,600);
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
	    width = image.getWidth(this)/2;
	    height = image.getHeight(this)/2;
	    rotate = (int) 0;
	    at = new AffineTransform();

	  }
	  public void setGame(Gaming game){
		  this.game = game;
	  }
	  public void setPlayersB(JButton[] pl){
		  this.playersB = pl;
	  }
	  public void setScores(JTextField[] sc){
		  this.scores = sc;
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	     
	    //System.out.println("Wymair d = "+d.getHeight()+ "x"+ d.getWidth());
	    int index = 0;
	    for(index = 0;index<imagesOwners.size();++index){
	    	if(imagesOwners.get(index) == null)
	    		continue;
	    	String nick = imagesOwners.get(index);
	    	
	    	//System.out.println("Rysuje gracza "+s);
	    	
	    	try{
	    		
	    		Piloting plane = planes.get(nick);
	    		x = plane.getX();
	    		y = plane.getY();
	    		//rotate = plane.getAngle();
	    		Integer score = players.get(nick).getScore();
	    	scores[index].setText(score.toString());
	    	
	    	//g.translate((int)Math.round(x),(int)Math.round( y));
	    	
    		bi = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
    	
    		big = bi.createGraphics();

	    	at.setToIdentity();	  
	    	
	    	at.translate(26 , 30 );
	    	at.rotate(plane.getAngle());
	    	at.translate(-26, -30);
	    //at.scale(scale, scale);
	    
	    	big.drawImage(image, at, this);

	    	Graphics2D g2D = (Graphics2D) g;
	    	g2D.drawImage(bi, (int)Math.round(x) - 26,(int)Math.round( y) -30 , null);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		++errorCount;
		    	if(errorCount > 5)
		    		this.stop();
		    	imagesOwners.set(index, null);
		    	playersB[index].setEnabled(false);

	    	}

	    	big.dispose();
	    }
	    Vector<Point> vb = null;
	    try{
	    	vb = game.getBulletsCoords();
	    }catch(RemoteException e){
	    	e.printStackTrace();
	    	++errorCount;
	    }catch(Exception e){
	    	++errorCount;	    	
	    } finally{
	    	if(errorCount > 5)
	    		this.stop();	    	
	    }
	    if(vb!=null){
		    for(Point p:vb){
		    	bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		    	Graphics2D big = bi.createGraphics();
		    	//System.out.println("Rysuje gracza "+s);
		    	//step(d.width, d.height);
		    	x  = p.x;
		    	y  = p.y;
		    	
		    	 at.setToIdentity();
		    	//at.translate(x , y );    	
		    	
		    	big.drawImage(bullet, at, this);

		    	Graphics2D g2D = (Graphics2D) g;
		    	g2D.drawImage(bi, (int)Math.round(x),(int) Math.round(y), null);
		    	

		    	big.dispose();
		   		    	
		    }
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
	    while (thread == me && errorCount<5) {
	    	addImages();	
	    	repaint();
	    	try{
	    		Thread.sleep(30);	    		
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
				  int i = 0;
				  for(Map.Entry<String, Playing> el:players.entrySet()){				
					  imagesOwners.add(el.getKey());		
					  planes.put(el.getKey(), el.getValue().getPlane());
					  playersB[i].setText(el.getKey());
					  playersB[i].setEnabled(true);
					  scores[i].setText("0");
					  scores[i].setEnabled(true);
					  ++i;
				  }
				  
			  }
		  }catch(RemoteException e){
			  e.printStackTrace();
			  errorCount++;
		  }
	  }
}