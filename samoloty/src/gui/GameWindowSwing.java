package gui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridLayout;
import javax.swing.SwingUtilities;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
public class GameWindowSwing extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JButton jConnectButtonCancle;
	private AbstractAction quitGameWindow;
	private JMenuItem jAbout;
	private AbstractAction openAboutDialog;
	private AbstractAction openConnectDialog;
	private JLabel jConnectLabelNick;
	private JLabel jConnectLabelServer;
	private AbstractAction closeConnectDialog;
	private JTextField jConnectNick;
	private JButton jConnectButtonConnect;
	private JEditorPane jConnectGame;
	private JDialog jConnectDialog;
	private JTextPane jText;
	private JMenu jHelp;
	private AbstractAction closeAboutDialog;
	private JButton jAboutButtonOk;
	private JDialog jAboutDialog;
	private JSeparator jSeparator1;
	private JMenuItem quit;
	private JMenuItem disconnect;
	private JMenuItem connect;
	private JMenu jGame;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameWindowSwing inst = new GameWindowSwing();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GameWindowSwing() {
		super();
		initSwtAwtGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jGame = new JMenu();
					jMenuBar1.add(jGame);
					jGame.setText("Game");
					{
						connect = new JMenuItem();
						jGame.add(connect);
						connect.setText("connect");
						connect.setAction(getOpenConnectDialog());
					}
					{
						disconnect = new JMenuItem();
						jGame.add(disconnect);
						disconnect.setText("disconnect");
						disconnect.setEnabled(false);
					}
					{
						jSeparator1 = new JSeparator();
						jGame.add(jSeparator1);
					}
					{
						quit = new JMenuItem();
						jGame.add(quit);
						quit.setText("quit");
						quit.setAction(getQuitGameWindow());
					}
				}
				{
					jHelp = new JMenu();
					jMenuBar1.add(jHelp);
					jHelp.setText("Help");
					jHelp.add(getJAbout());
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JDialog getJAboutDialog() {
		if(jAboutDialog == null) {
			jAboutDialog = new JDialog(this);
			GroupLayout jDialog1Layout = new GroupLayout((JComponent)jAboutDialog.getContentPane());
			jAboutDialog.setLayout(jDialog1Layout);
			{
				jAboutButtonOk = new JButton();
				jAboutButtonOk.setText("OK");
				jAboutButtonOk.setAction(getCloseAboutDialog());
			}
			jAboutDialog.setSize(359, 268);
			jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
				    .addComponent(getJText(), GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(21, 21))
				.addGroup(GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
				    .addGap(275)
				    .addComponent(jAboutButtonOk, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				    .addContainerGap(21, 21)));
			jDialog1Layout.setVerticalGroup(jDialog1Layout.createSequentialGroup()
				.addComponent(getJText(), 0, 190, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jAboutButtonOk, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(18, 18));
		}
		return jAboutDialog;
	}
	
	private AbstractAction getCloseAboutDialog() {
		if(closeAboutDialog == null) {
			closeAboutDialog = new AbstractAction("OK", null) {
				public void actionPerformed(ActionEvent evt) {
				jAboutDialog.dispose();
				}
			};
		}
		return closeAboutDialog;
	}
	
	private JMenuItem getJAbout() {
		if(jAbout == null) {
			jAbout = new JMenuItem();
			jAbout.setText("About");
			jAbout.setAction(getOpenAboutDialog());
		}
		return jAbout;
	}
	
	private AbstractAction getOpenAboutDialog() {
		if(openAboutDialog == null) {
			openAboutDialog = new AbstractAction("about", null) {
				public void actionPerformed(ActionEvent evt) {
					getJAboutDialog().pack();
					getJAboutDialog().setLocationRelativeTo(null);
					getJAboutDialog().setVisible(true);
				}
			};
		}
		return openAboutDialog;
	}
	
	private JTextPane getJText() {
		if(jText == null) {
			jText = new JTextPane();
			jText.setText("Autorzy: Piotrek Mionskowski, Tomasz Kwiecien");
		}
		return jText;
	}
	
	private JDialog getJConnectDialog() {
		if(jConnectDialog == null) {
			jConnectDialog = new JDialog(this);
			GroupLayout jConnectDialogLayout = new GroupLayout((JComponent)jConnectDialog.getContentPane());
			jConnectDialog.getContentPane().setLayout(jConnectDialogLayout);
			jConnectDialog.setPreferredSize(new java.awt.Dimension(291, 269));
			jConnectDialog.setSize(291, 269);
			jConnectDialogLayout.setHorizontalGroup(jConnectDialogLayout.createSequentialGroup()
				.addContainerGap(55, 55)
				.addGroup(jConnectDialogLayout.createParallelGroup()
				    .addComponent(getJConnectNick(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectLabelNick(), GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addGap(36))
				    .addComponent(getJConnectGame(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectLabelServer(), GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addGap(36))
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectButtonConnect(), GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(getJConnectButtonCancle(), GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(18, 18));
			jConnectDialogLayout.setVerticalGroup(jConnectDialogLayout.createSequentialGroup()
				.addContainerGap(34, 34)
				.addComponent(getJConnectLabelServer(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJConnectGame(), GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJConnectLabelNick(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJConnectNick(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(21)
				.addGroup(jConnectDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJConnectButtonConnect(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJConnectButtonCancle(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(69, 69));
		}
		return jConnectDialog;
	}
	
	private JEditorPane getJConnectGame() {
		if(jConnectGame == null) {
			jConnectGame = new JEditorPane();
			jConnectGame.setText("[game name]");
		}
		return jConnectGame;
	}
	
	private JTextField getJConnectNick() {
		if(jConnectNick == null) {
			jConnectNick = new JTextField();
			jConnectNick.setText("Player1");
		}
		return jConnectNick;
	}
	
	private JButton getJConnectButtonConnect() {
		if(jConnectButtonConnect == null) {
			jConnectButtonConnect = new JButton();
			jConnectButtonConnect.setText("Connect");
		}
		return jConnectButtonConnect;
	}

	private JLabel getJConnectLabelServer() {
		if(jConnectLabelServer == null) {
			jConnectLabelServer = new JLabel();
			jConnectLabelServer.setText("Server name");
		}
		return jConnectLabelServer;
	}
	
	private JLabel getJConnectLabelNick() {
		if(jConnectLabelNick == null) {
			jConnectLabelNick = new JLabel();
			jConnectLabelNick.setText("Your game nick:");
		}
		return jConnectLabelNick;
	}
	
	private AbstractAction getOpenConnectDialog() {
		if(openConnectDialog == null) {
			openConnectDialog = new AbstractAction("connect", null) {
				public void actionPerformed(ActionEvent evt) {
					getJConnectDialog().pack();
					getJConnectDialog().setLocationRelativeTo(null);
					getJConnectDialog().setVisible(true);
				}
			};
		}
		return openConnectDialog;
	}
	
	private AbstractAction getCloseConnectDialog() {
		if(closeConnectDialog == null) {
			closeConnectDialog = new AbstractAction("cancle", null) {
				public void actionPerformed(ActionEvent evt) {
					jConnectDialog.dispose();
				}
			};
		}
		return closeConnectDialog;
	}
	
	private JButton getJConnectButtonCancle() {
		if(jConnectButtonCancle == null) {
			jConnectButtonCancle = new JButton();
			jConnectButtonCancle.setText("Cancle");
			jConnectButtonCancle.setAction(getCloseConnectDialog());
		}
		return jConnectButtonCancle;
	}
	
	private AbstractAction getQuitGameWindow() {
		if(quitGameWindow == null) {
			quitGameWindow = new AbstractAction("quit", null) {
				public void actionPerformed(ActionEvent evt) {

				}
			};
		}
		return quitGameWindow;
	}

	//$protect>>$
	//===== start of SWT_AWT special handler code =============

	/**
	 * This method should be called instead of initGUI to initialize
	 * and make visible this GUI, since it handles all the threading
	 * and other "quirks" of embedding SWT objects inside AWT ones.
	 */
	public void initSwtAwtGUI() {
		new DisplayThread().start();
	}
		
	/**
	 * This class makes sure that the SWT controls will be created
	 * and behave correctly
	 */
	private class DisplayThread extends Thread {

		public void run() {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					//make sure the GUI is created inside the SWT display thread
					//otherwise you will get invalid-thread-access errors, and
					//make sure it is visible before calling the SWT_AWT.new_Shell
					//method, otherwise a "No handles" error will be thrown.
					setVisible(true);
					initGUI();
				}
			});
			
			//"wiggling" the size is one way to make sure that the
			//SWT controls are displayed correctly
			java.awt.Dimension sz = getSize();
			int w = sz.width;
			int h = sz.height;
			setSize(w+1, h);
			validate();
			setSize(w, h);
			validate();
			
			swtEventLoop();
		}

		/**
		 * Listen for and dispatch SWT events
		 */
		private void swtEventLoop() {
			Display display = Display.getDefault();
			while (true) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}

	}

	//===== end of SWT_AWT special handler code =============
	//$protect<<$
	

}
