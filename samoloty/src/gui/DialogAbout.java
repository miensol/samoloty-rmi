package gui;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DialogAbout extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Button buttonAboutOk;
	private Text textAbout;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			DialogAbout inst = new DialogAbout(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogAbout(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.setText("About...");
			{
				textAbout = new Text(dialogShell, SWT.NONE);
				textAbout.setText("Authors: Piotr Mionskowski, Tomasz Kwiecien");
				FormData textAboutLData = new FormData();
				textAboutLData.width = 406;
				textAboutLData.height = 208;
				textAboutLData.left =  new FormAttachment(0, 1000, 31);
				textAboutLData.top =  new FormAttachment(0, 1000, 12);
				textAbout.setLayoutData(textAboutLData);
			}
			{
				buttonAboutOk = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				buttonAboutOk.setText("OK");
				buttonAboutOk.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogShell.dispose();
					}
				});
				FormData buttonAboutOkLData = new FormData();
				buttonAboutOkLData.width = 48;
				buttonAboutOkLData.height = 23;
				buttonAboutOkLData.left =  new FormAttachment(0, 1000, 395);
				buttonAboutOkLData.top =  new FormAttachment(0, 1000, 237);
				
			}
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(483, 312);
			
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
