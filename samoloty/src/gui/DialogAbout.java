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
import org.eclipse.swt.custom.StyledText;
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
	private StyledText styledText1;

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
				styledText1 = new StyledText(dialogShell, SWT.NONE);
				FormData styledText1LData = new FormData();
				styledText1LData.width = 451;
				styledText1LData.height = 205;
				styledText1LData.left =  new FormAttachment(0, 1000, 12);
				styledText1LData.top =  new FormAttachment(0, 1000, 12);
				styledText1.setLayoutData(styledText1LData);
				styledText1.setText(" \n Authors: Piotr Mionskowski, Tomasz Kwiecien \n \n Game discription:");
			}
			{
				buttonAboutOk = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonAboutOkLData1 = new FormData();
				buttonAboutOkLData1.width = 105;
				buttonAboutOkLData1.height = 27;
				buttonAboutOkLData1.left =  new FormAttachment(764, 1000, 0);
				buttonAboutOkLData1.right =  new FormAttachment(988, 1000, 0);
				buttonAboutOkLData1.top =  new FormAttachment(860, 1000, 0);
				buttonAboutOkLData1.bottom =  new FormAttachment(960, 1000, 0);
				buttonAboutOk.setLayoutData(buttonAboutOkLData1);
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
			dialogShell.setSize(477, 295);

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
