package gui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GameWindow extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogGameShell;
	private Menu menuMain;
	private MenuItem menuMainGame;
	private Menu menuHelp;
	private MenuItem menuGameQuit;
	private MenuItem menuGameSeparator;
	private MenuItem menuGameDisconnect;
	private MenuItem menuGameConnect;
	private MenuItem menuHelpAbout;
	private MenuItem menuMainHelp;
	private Menu menuGame;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			GameWindow inst = new GameWindow(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GameWindow(Shell parent, int style) {
		super(parent, style);
	}

	/**
	 * 
	 */
	public void open() {
		try {
			Shell parent = getParent();
			dialogGameShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			FormLayout dialogGameShellLayout = new FormLayout();
			dialogGameShell.setLayout(dialogGameShellLayout);
			dialogGameShellLayout.marginTop = 40;
			dialogGameShellLayout.marginLeft = 40;
			dialogGameShell.setText("Planes Game");
			{
				menuMain = new Menu(dialogGameShell, SWT.BAR);
				dialogGameShell.setMenuBar(menuMain);
				{
					menuMainGame = new MenuItem(menuMain, SWT.CASCADE);
					menuMainGame.setText("Game");
					{
						menuGame = new Menu(menuMainGame);
						menuMainGame.setMenu(menuGame);
						{
							menuGameConnect = new MenuItem(menuGame, SWT.PUSH);
							menuGameConnect.setText("Connect");
							menuGameConnect.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									DialogConnect connect = new DialogConnect(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM);
									connect.open();
								}
							});
							
							//TODO
							//jezeli sie powiodlo to:
							//menuGameDisconnect.setEnabled(true);
							//menuGameConnect.setEnabled(false);
						}
						{
							menuGameDisconnect = new MenuItem(menuGame, SWT.PUSH);
							menuGameDisconnect.setText("Disconnect");
							menuGameDisconnect.setEnabled(false);
							menuGameDisconnect.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									//TODO akcja na przycisk rozlaczenia
								}
							});
							
						}
						{
							menuGameSeparator = new MenuItem(menuGame, SWT.SEPARATOR);
							menuGameSeparator.setText("Separator");
						}
						{
							menuGameQuit = new MenuItem(menuGame, SWT.PUSH);
							menuGameQuit.setText("Quit");
							menuGameQuit.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									dialogGameShell.dispose();
								}
							});
						}
					}
				}
				{
					menuMainHelp = new MenuItem(menuMain, SWT.CASCADE);
					menuMainHelp.setText("Help");
					{
						menuHelp = new Menu(menuMainHelp);
						menuMainHelp.setMenu(menuHelp);
						{
							menuHelpAbout = new MenuItem(menuHelp, SWT.PUSH);
							menuHelpAbout.setText("About");	
							menuHelpAbout.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									DialogAbout about = new DialogAbout(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM);
									about.open();
								}
							});
						}
					}
				}
			}
			dialogGameShell.layout();
			dialogGameShell.pack();			
			dialogGameShell.setSize(800, 610);
			dialogGameShell.setLocation(getParent().toDisplay(100, 100));
			dialogGameShell.open();
			Display display = dialogGameShell.getDisplay();
			while (!dialogGameShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
