package oldgui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
public class DialogConnect extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogConnectShell;
	private Label labelServer;
	private Label labelNick;
	private Button buttonConnectConnect;
	private Button buttonConnectCancle;
	private Text textNick;
	private Text textServer;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			DialogConnect inst = new DialogConnect(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogConnect(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogConnectShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogConnectShell.setLayout(new FormLayout());
			dialogConnectShell.setText("Connect to ...");
			{
				labelServer = new Label(dialogConnectShell, SWT.NONE);
				labelServer.setText("Server name");
				FormData labelServerLData = new FormData();
				labelServerLData.width = 61;
				labelServerLData.height = 13;
				labelServerLData.left =  new FormAttachment(0, 1000, 19);
				labelServerLData.top =  new FormAttachment(0, 1000, 24);
				labelServer.setLayoutData(labelServerLData);
				labelServer.setBounds(19, 24, 61, 13);
			}
			{
				textServer = new Text(dialogConnectShell, SWT.NONE);
				textServer.setText("[Server name]");
				FormData textServerLData = new FormData();
				textServerLData.width = 90;
				textServerLData.height = 19;
				textServerLData.left =  new FormAttachment(0, 1000, 18);
				textServerLData.top =  new FormAttachment(0, 1000, 48);
				textServer.setLayoutData(textServerLData);
				textServer.setBounds(18, 48, 96, 19);
			}
			{
				labelNick = new Label(dialogConnectShell, SWT.NONE);
				labelNick.setText("Your game nickname");
				FormData labelNickLData = new FormData();
				labelNickLData.width = 109;
				labelNickLData.height = 18;
				labelNickLData.left =  new FormAttachment(0, 1000, 18);
				labelNickLData.top =  new FormAttachment(0, 1000, 73);
				labelNick.setLayoutData(labelNickLData);
				labelNick.setBounds(18, 73, 109, 18);
			}
			{
				textNick = new Text(dialogConnectShell, SWT.NONE);
				textNick.setText("Player1");
				FormData textNickLData = new FormData();
				textNickLData.width = 90;
				textNickLData.height = 19;
				textNickLData.left =  new FormAttachment(0, 1000, 18);
				textNickLData.top =  new FormAttachment(0, 1000, 97);
				textNick.setLayoutData(textNickLData);
				textNick.setBounds(18, 97, 96, 19);
			}
			{
				buttonConnectConnect = new Button(dialogConnectShell, SWT.PUSH | SWT.CENTER);
				buttonConnectConnect.setText("Connect");
				FormData buttonConnectConnectLData = new FormData();
				buttonConnectConnectLData.width = 60;
				buttonConnectConnectLData.height = 22;
				buttonConnectConnectLData.left =  new FormAttachment(0, 1000, 18);
				buttonConnectConnectLData.top =  new FormAttachment(0, 1000, 128);
				buttonConnectConnect.setLayoutData(buttonConnectConnectLData);
				buttonConnectConnect.setBounds(18, 128, 60, 22);
				buttonConnectConnect.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						System.out.println("buttonConnectConnect.widgetSelected, event="+evt);
						//TODO add your code for buttonConnectConnect.widgetSelected
					}
				});
			}
			{
				buttonConnectCancle = new Button(dialogConnectShell, SWT.PUSH | SWT.CENTER);
				buttonConnectCancle.setText("Cancle");
				FormData buttonConnectCancleLData = new FormData();
				buttonConnectCancleLData.width = 61;
				buttonConnectCancleLData.height = 22;
				buttonConnectCancleLData.left =  new FormAttachment(0, 1000, 84);
				buttonConnectCancleLData.top =  new FormAttachment(0, 1000, 128);
				buttonConnectCancle.setLayoutData(buttonConnectCancleLData);
				buttonConnectCancle.setBounds(84, 128, 61, 22);
				buttonConnectCancle.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogConnectShell.dispose();
					}
				});
			}
			dialogConnectShell.layout();
			dialogConnectShell.pack();			
			dialogConnectShell.setSize(183, 250);
			
			dialogConnectShell.setLocation(getParent().toDisplay(100, 100));
			dialogConnectShell.open();
			Display display = dialogConnectShell.getDisplay();
			while (!dialogConnectShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void buttonConnectConnectWidgetSelected(SelectionEvent evt) {
		System.out.println("buttonConnectConnect.widgetSelected, event="+evt);
		//TODO add your code for buttonConnectConnect.widgetSelected
	}

}
