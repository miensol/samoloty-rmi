package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;


public class Plainold {

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
	 static int R =0;
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

				//canvas.setLocation(50, 50);
				canvas.redraw();
			
				
				
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
				canvas.dispose();
			}
		};
		
		return listener;
		
	}
	 
	public void run() {
		setDisplay(new Display());
		final Shell shell = new Shell(display);
		shell.setText("Samolocik");
		final Canvas plain = createPlain(shell,0);	
	
		Listener wsad = player1(plain);
		
		shell.addListener(SWT.KeyDown, wsad);
		shell.addListener(SWT.KeyUp, wsad);
		
		shell.setSize(500, 500);

		shell.setText("Zajebiste samoloty");
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	//wyswietlenie samolotu
	public Canvas createPlain(Shell shell,final float angle) {
	
		Canvas canvas = new Canvas(shell, SWT.NULL);
		canvas.setSize(200, 200);
		//canvas.setBounds(arg0, arg1, arg2, arg3)
		canvas.setLocation(100, 100);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent p) {
				System.out.print("wszedlemf");
				Transform transform = new Transform(Display.getCurrent());
				Image image = new Image(display, Plainold.class.getResourceAsStream("img/samolocik.gif"));
				transform.rotate(X);
				p.gc.setTransform(transform);
					
				//p.gc.drawImage(image, 0, 0);
				p.gc.drawImage(image, 0, 0);
				image.dispose();
				transform.dispose();
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
		new Plainold().run();
	}
}
