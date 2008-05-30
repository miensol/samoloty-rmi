package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/***
 * 
 * @author Navi
 * sterowanie za pomoca w s a d
 * nie wiem czemu nie dziala cofanie sie 
 * ale ty zapewne bedziesz wiedzial;d
 * 
 */
public class kwadrat {
	static int X=10;
	static int Y=10;
  public static void main(String[] args) {
    final Display display = new Display();
     Shell shell = new Shell(display);
     final Canvas canvas = new Canvas(shell, SWT.NULL);
     Listener listener = new Listener() { 	 
      public void handleEvent(Event e) {
  
	        switch (e.keyCode) {
	        case 97:
	        	--X;
	        case 100:
	        	++X;
	        case 119:
	        	--Y;
	        case 115:
	        	++Y;
	        }
	        System.out.print(e.keyCode);
	  	    canvas.setSize(10, 10);
	  	    canvas.setLocation(X, Y);
	  	    canvas.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
	      }
    	  
    };
    shell.addListener(SWT.KeyDown, listener);
    shell.addListener(SWT.KeyUp, listener);
    shell.setSize(200, 200);
    
    shell.setText("Zajebisty kwadracik");
    
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}