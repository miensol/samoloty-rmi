package gui;

import game.Game;

import java.rmi.Naming;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;


import common.Gaming;


public class Plain {

	public static Display display;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display disp) {
		display = disp;
	}
	static int X = 0;
	 static int Y = 0;
	 static int X2 = 0;
	 static int Y2 = 0;
	public Listener player1(final Canvas canvas){
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				
				switch (e.keyCode) {
				case 97: {
					X=X-1;
					break;
				}
				case 100: {
					++X;
					break;
				}
				case 119: {
					Y=Y-1;
					break;
				}
				case 115: {
					++Y;
					break;
				}
				}
				System.out.print(X + " " +Y + "\n");
				canvas.setLocation(X, Y);
			}
		};
		
		return listener;
		
	}
	
	//reakcja na klawisze i k j l
	public Listener player2(final Canvas canvas){
		
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				
				switch (e.keyCode) {
				case 106: {
					X2=X2-1;
					break;
				}
				case 108: {
					++X2;
					break;
				}
				case 105: {
					Y2=Y2-1;
					break;
				}
				case 107: {
					++Y2;
					break;
				}
				}
				System.out.print(X2 + " " +Y2 + "\n");
				canvas.setLocation(X2, Y2);
			}
		};
		
		return listener;
		
	}
	 
	public void run() {
		setDisplay(Display.getDefault());
		
		final Shell shell = new Shell(display,SWT.SHELL_TRIM | SWT.NO_BACKGROUND);
		/*
		final Canvas plain = createPlain(shell);
		
		final Canvas plain2 = createPlain(shell);		
		plain.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
	
		Listener wsad = player1(plain);
		Listener ikjl = player2(plain2);
		
		shell.addListener(SWT.KeyDown, player1(plain));
		shell.addListener(SWT.KeyUp, wsad);
		shell.addListener(SWT.KeyDown, ikjl);
		shell.addListener(SWT.KeyUp, ikjl);
		*/
		Gaming gra;
		try{
			gra = (Gaming)Naming.lookup(Game.URL_BASE+"/PlaneGame");
			gra.join("Tomek");
			gra.join("Piotr");
			gra.start();
		
		
		Canvas plain = new PlaneImage(shell,"img/samolocik.gif","Tomek");
		Canvas plain2 = new PlaneImage(shell,"img/samolocik2.gif","Piotr");
		Canvas board = new GameBoard(shell,Game.URL_BASE+"/PlaneGame");
		plain.setLocation(100, 100);
		plain2.setLocation(100, 400);
		
		Listener wsad = player1(plain);
		Listener ikjl = player2(plain2);
		
		shell.addListener(SWT.KeyDown, wsad);
		shell.addListener(SWT.KeyUp, wsad);
		shell.addListener(SWT.KeyDown, ikjl);
		shell.addListener(SWT.KeyUp, ikjl);
		shell.setSize(800, 610);
		
		shell.setText("Zajebiste samoloty");
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		display.dispose();
		gra.removePlayer("Piotr");
		gra.removePlayer("Tomek");
		gra.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wyswietlenie samolotu
	public Canvas createPlain(Shell shell) {
		
		Canvas canvas = new Canvas(shell, SWT.NULL);
		canvas.setSize(48, 47);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent p) {
				Image image = new Image(display, Plain.class.getResourceAsStream("img/samolocik.jpg"));
				p.gc.drawImage(image, 0, 0);
				image.dispose();

			}
		});
		return canvas;
	}
	
	public Canvas moveCanvas(Canvas canvas){
		
		return canvas;
	}

	/**
	 * The application entry point
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new Plain().run();
	}
}
