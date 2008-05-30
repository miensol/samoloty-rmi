package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/*******************************************************************************
 * 
 * @author Navi sterowanie za pomoca w s a d nie wiem czemu nie dziala cofanie
 *         sie ale ty zapewne bedziesz wiedzial;d
 * 
 */
public class kwadrat {
	static int X = 0;
	static int Y = 0;

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
	
		final Canvas canvas = new Canvas(shell, SWT.NULL);
		canvas.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		canvas.setSize(48, 47);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent p) {
				Image image = new Image(display, "C:/samolocik.jpg");
				p.gc.drawImage(image, 0, 0);
				image.dispose();

			}
		});
		Listener listener = new Listener() {
			public void handleEvent(Event e) {

				switch (e.keyCode) {
				case 97: {
					--X;
					break;
				}
				case 100: {
					++X;
					break;
				}
				case 119: {
					--Y;
					break;
				}
				case 115: {
					++Y;
					break;
				}
				}

				System.out.print(e.keyCode);
			
				canvas.setLocation(X, Y);
			
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