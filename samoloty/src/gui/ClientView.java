package gui;
import game.Game;
import game.PlaneGame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Visibility;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;

import common.Gaming;

import animate.AnimationCanvas;



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
public class ClientView extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JButton jConnectButtonCancle;
	private JTextArea jTextArea1;
	private JTextPane jTextPane1;
	private AbstractAction createServer;
	private JButton jButtonPlayer8;
	private JButton jButtonPlayer7;
	private JButton jButtonPlayer6;
	private JButton jButtonPlayer5;
	private JTextField jTextPlayer8;
	private JTextField jTextPlayer7;
	private JTextField jTextPlayer6;
	private JTextField jTextPlayer5;
	private JButton jButtonPlayer4;
	private JButton jButtonPlayer3;
	private JTextField jTextPlayer4;
	private JTextField jTextPlayer3;
	private JButton jButtonPlayer2;
	private JTextField jTextPlayer2;
	private AbstractAction joinServer;
	private ScrollPane scrollPane1;
	private JButton jConnectButtonJoin;
	private JLabel jLabelPoints;
	private JLabel jLabelPlayers;
	private JTextField jTextPlayer1;
	private JButton jButtonPlayer1;
	private JPanel jPanelRight;
	private AnimationCanvas aBoard;
	private AbstractAction quitGameWindow;
	private JMenuItem jAbout;
	private AbstractAction openAboutDialog;
	private AbstractAction openConnectDialog;
	private JLabel jConnectLabelNick;
	private JLabel jConnectLabelServer;
	private AbstractAction closeConnectDialog;
	private JTextField jConnectNick;
	private JButton jConnectButtonCreate;
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
	private AbstractAction closeConnection;
	
	private PlaneGame game;
	private Gaming gaming;
	private String myNick ;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ClientView inst = new ClientView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
			}
		});
	}
	
	public ClientView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			thisLayout.setVerticalGroup(thisLayout.createParallelGroup()
				.addComponent(getaBoard(), GroupLayout.Alignment.LEADING, 0, 575, Short.MAX_VALUE)
				.addComponent(getJPanelRight(), GroupLayout.Alignment.LEADING, 0, 575, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(getaBoard(), GroupLayout.PREFERRED_SIZE, 799, GroupLayout.PREFERRED_SIZE)
				.addComponent(getJPanelRight(), 0, 148, Short.MAX_VALUE));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setMaximumSize(new java.awt.Dimension(953, 625));
			this.setMinimumSize(new java.awt.Dimension(953, 625));
			this.setResizable(false);
			this.setTitle("Planes");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					//System.out.println("this.windowClosing, event="+evt);
					System.exit(0);
				}
			});
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
						disconnect.setAction(getCloseConnection());
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
			this.setSize(957, 701);
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
			jConnectDialog.setMinimumSize(new java.awt.Dimension(291, 269));
			jConnectDialog.setMaximumSize(new java.awt.Dimension(291, 269));
			jConnectDialog.setResizable(false);
			jConnectDialog.setSize(291, 269);
			jConnectDialogLayout.setHorizontalGroup(jConnectDialogLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jConnectDialogLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectNick(), GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
				        .addGap(8))
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectGame(), GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
				        .addGap(8))
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addGroup(jConnectDialogLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				                .addComponent(getJConnectButtonJoin(), GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(getJConnectButtonCreate(), GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				                .addComponent(getJConnectLabelServer(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				                .addGap(19)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(getJConnectButtonCancle(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, jConnectDialogLayout.createSequentialGroup()
				        .addComponent(getJConnectLabelNick(), GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				        .addGap(101)))
				.addContainerGap());
			jConnectDialogLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJConnectNick(), getJConnectGame()});
			jConnectDialogLayout.setVerticalGroup(jConnectDialogLayout.createSequentialGroup()
				.addContainerGap(33, 33)
				.addComponent(getJConnectLabelServer(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getJConnectGame(), GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJConnectLabelNick(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJConnectNick(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(21)
				.addGroup(jConnectDialogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJConnectButtonJoin(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJConnectButtonCreate(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJConnectButtonCancle(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(70, 70));
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
	
	private JButton getJConnectButtonCreate() {
		if(jConnectButtonCreate == null) {
			jConnectButtonCreate = new JButton();
			jConnectButtonCreate.setText("Create");
			jConnectButtonCreate.setAction(getCreateServer());
			jConnectButtonCreate.setSize(75, 21);
		}
		return jConnectButtonCreate;
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
			jConnectButtonCancle.setSize(55, 21);
		}
		return jConnectButtonCancle;
	}
	
	private AbstractAction getQuitGameWindow() {
		if(quitGameWindow == null) {
			quitGameWindow = new AbstractAction("quit", null) {
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}
			};
		}
		return quitGameWindow;
	}
	public AnimationCanvas getaBoard() {
		if(aBoard == null) {
			aBoard = new AnimationCanvas();
			aBoard.setSize(800, 600);
			aBoard.setBackground( java.awt.Color.white);
			aBoard.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			aBoard.setVisible(false);
		}
		return aBoard;
	}
	
	public JPanel getJPanelRight() {
		if(jPanelRight == null) {
			jPanelRight = new JPanel();
			GroupLayout jPanelRightLayout = new GroupLayout((JComponent)jPanelRight);
			jPanelRight.setLayout(jPanelRightLayout);
			jPanelRight.setBackground(new java.awt.Color(170,159,157));
			jPanelRight.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			jPanelRight.setVisible(false);
			jPanelRightLayout.setHorizontalGroup(jPanelRightLayout.createSequentialGroup()
				.addGroup(jPanelRightLayout.createParallelGroup()
				    .addGroup(jPanelRightLayout.createSequentialGroup()
				        .addGroup(jPanelRightLayout.createParallelGroup()
				            .addComponent(getJButtonPlayer8(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, jPanelRightLayout.createSequentialGroup()
				                .addComponent(getJLabelPlayers(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				            .addComponent(getJButtonPlayer7(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer6(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer5(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJButtonPlayer4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addGap(16, 16, GroupLayout.PREFERRED_SIZE)
				        .addGroup(jPanelRightLayout.createParallelGroup()
				            .addComponent(getJLabelPoints(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer8(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer7(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer6(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer5(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJTextPlayer4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				        .addGap(29))
				    .addComponent(getJTextPane1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			jPanelRightLayout.setVerticalGroup(jPanelRightLayout.createSequentialGroup()
				.addContainerGap(22, 22)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJLabelPoints(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabelPlayers(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(25)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer5(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer5(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer6(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer6(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer7(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer7(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextPlayer8(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJButtonPlayer8(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getJTextPane1(), GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
				.addGap(6));
		}
		return jPanelRight;
	}
	
	public JButton getJButtonPlayer1() {
		if(jButtonPlayer1 == null) {
			jButtonPlayer1 = new JButton();
			jButtonPlayer1.setText("Player1");
			jButtonPlayer1.setSize(50, 21);
		}
		return jButtonPlayer1;
	}
	
	public JTextField getJTextPlayer1() {
		if(jTextPlayer1 == null) {
			jTextPlayer1 = new JTextField();
			jTextPlayer1.setText("0");
			jTextPlayer1.setEditable(false);
		}
		return jTextPlayer1;
	}

	private JLabel getJLabelPlayers() {
		if(jLabelPlayers == null) {
			jLabelPlayers = new JLabel();
			jLabelPlayers.setText("Players");
		}
		return jLabelPlayers;
	}
	
	private JLabel getJLabelPoints() {
		if(jLabelPoints == null) {
			jLabelPoints = new JLabel();
			jLabelPoints.setText("Points");
		}
		return jLabelPoints;
	}

	/*private JTextField getJTextField2() {
		if(jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("0");
		}
		return jTextField2;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Player1");
		}
		return jButton2;
	}*/
	
	private JTextField getJTextPlayer2() {
		if(jTextPlayer2 == null) {
			jTextPlayer2 = new JTextField();
			jTextPlayer2.setText("0");
			jTextPlayer2.setEnabled(false);
			jTextPlayer2.setEditable(false);
		}
		return jTextPlayer2;
	}
	
	private JButton getJButtonPlayer2() {
		if(jButtonPlayer2 == null) {
			jButtonPlayer2 = new JButton();
			jButtonPlayer2.setText("Player2");
			jButtonPlayer2.setEnabled(false);
			jButtonPlayer2.setSize(50, 21);
		}
		return jButtonPlayer2;
	}
	
	private JTextField getJTextPlayer3() {
		if(jTextPlayer3 == null) {
			jTextPlayer3 = new JTextField();
			jTextPlayer3.setText("0");
			jTextPlayer3.setEnabled(false);
			jTextPlayer3.setEditable(false);
		}
		return jTextPlayer3;
	}
	
	private JTextField getJTextPlayer4() {
		if(jTextPlayer4 == null) {
			jTextPlayer4 = new JTextField();
			jTextPlayer4.setText("0");
			jTextPlayer4.setEnabled(false);
			jTextPlayer4.setEditable(false);
		}
		return jTextPlayer4;
	}
	
	private JButton getJButtonPlayer3() {
		if(jButtonPlayer3 == null) {
			jButtonPlayer3 = new JButton();
			jButtonPlayer3.setText("Player3");
			jButtonPlayer3.setEnabled(false);
			jButtonPlayer3.setSize(50, 21);
		}
		return jButtonPlayer3;
	}
	
	private JButton getJButtonPlayer4() {
		if(jButtonPlayer4 == null) {
			jButtonPlayer4 = new JButton();
			jButtonPlayer4.setText("Player4");
			jButtonPlayer4.setEnabled(false);
			jButtonPlayer4.setSize(50, 21);
		}
		return jButtonPlayer4;
	}
	
	private JTextField getJTextPlayer5() {
		if(jTextPlayer5 == null) {
			jTextPlayer5 = new JTextField();
			jTextPlayer5.setText("0");
			jTextPlayer5.setEnabled(false);
			jTextPlayer5.setEditable(false);
		}
		return jTextPlayer5;
	}
	
	private JTextField getJTextPlayer6() {
		if(jTextPlayer6 == null) {
			jTextPlayer6 = new JTextField();
			jTextPlayer6.setText("0");
			jTextPlayer6.setEnabled(false);
			jTextPlayer6.setEditable(false);
		}
		return jTextPlayer6;
	}
	
	private JTextField getJTextPlayer7() {
		if(jTextPlayer7 == null) {
			jTextPlayer7 = new JTextField();
			jTextPlayer7.setText("0");
			jTextPlayer7.setEnabled(false);
			jTextPlayer7.setEditable(false);
		}
		return jTextPlayer7;
	}
	
	private JTextField getJTextPlayer8() {
		if(jTextPlayer8 == null) {
			jTextPlayer8 = new JTextField();
			jTextPlayer8.setText("0");
			jTextPlayer8.setEnabled(false);
			jTextPlayer8.setEditable(false);
		}
		return jTextPlayer8;
	}
	
	private JButton getJButtonPlayer5() {
		if(jButtonPlayer5 == null) {
			jButtonPlayer5 = new JButton();
			jButtonPlayer5.setText("Player5");
			jButtonPlayer5.setEnabled(false);
			jButtonPlayer5.setSize(50, 21);
		}
		return jButtonPlayer5;
	}
	
	private JButton getJButtonPlayer6() {
		if(jButtonPlayer6 == null) {
			jButtonPlayer6 = new JButton();
			jButtonPlayer6.setText("Player6");
			jButtonPlayer6.setEnabled(false);
			jButtonPlayer6.setSize(50, 21);
		}
		return jButtonPlayer6;
	}
	
	private JButton getJButtonPlayer7() {
		if(jButtonPlayer7 == null) {
			jButtonPlayer7 = new JButton();
			jButtonPlayer7.setText("Player7");
			jButtonPlayer7.setEnabled(false);
			jButtonPlayer7.setSize(50, 21);
		}
		return jButtonPlayer7;
	}
	
	private JButton getJButtonPlayer8() {
		if(jButtonPlayer8 == null) {
			jButtonPlayer8 = new JButton();
			jButtonPlayer8.setText("Player8");
			jButtonPlayer8.setEnabled(false);
		}
		return jButtonPlayer8;
	}
	
	private AbstractAction getCreateServer() {
		if(createServer == null) {
			createServer = new AbstractAction("Create", null) {
				public void actionPerformed(ActionEvent evt) {
					myNick = jConnectNick.getText();			
					//TODO Create server
					//If the server was set up properly
					try{
						game = new PlaneGame(myNick);
						gaming = game;
						game.join(myNick);
						toLog("Utworzylem serwer!");
						aBoard.setGame(gaming);
						aBoard.start();
						addKeyListner();
					}catch(RemoteException e){
						toLog(e.getMessage());
						e.printStackTrace();
					}
					
					jButtonPlayer1.setText(jConnectNick.getText());
					aBoard.setVisible(true);
					jPanelRight.setVisible(true);
					jConnectDialog.dispose();
				}
			};
		}
		return createServer;
	}
	private void toLog(String s){
		jTextPane1.setText(jTextPane1.getText() + "\n"+s);
		
	}
	private void addKeyListner(){
		this.addKeyListener(new KeyAdapter() {
			//@Override
			public void keyPressed(KeyEvent e) {
				/*try{
					gaming.sendEvent(myNick, e);
				}catch(RemoteException ex){
					toLog("Blad wciskanego przycisku ");
					ex.printStackTrace();
				}*/						
			}
			//@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				/*
				try{
					gaming.sendEvent(myNick, e);
				}catch(RemoteException ex){
					toLog("Blad puszczanego przycisku ");
					ex.printStackTrace();
				}
				*/						
			}
			//@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				try{
					gaming.sendEvent(myNick, e);
				}catch(RemoteException ex){
					toLog("Blad typed przycisku ");
					ex.printStackTrace();
				}						
			}
		}
		);		
	}
	private JButton getJConnectButtonJoin() {
		if(jConnectButtonJoin == null) {
			jConnectButtonJoin = new JButton();
			jConnectButtonJoin.setText("Join");
			jConnectButtonJoin.setSize(74, 21);
			jConnectButtonJoin.setOpaque(false);
			jConnectButtonJoin.setAction(getJoinServer());
		}
		return jConnectButtonJoin;
	}
	
	private AbstractAction getJoinServer() {
		if(joinServer == null) {
			joinServer = new AbstractAction("Join", null) {
				public void actionPerformed(ActionEvent evt) {
					myNick = jConnectNick.getText();
					//If connection to server succeed
					try{
						String url = jConnectGame.getText();
						Game.HOST = url;
						url = "rmi://"+url+":"+Game.PORT+"/PlaneGame";						
						gaming = (Gaming)Naming.lookup(url);
						if(gaming.isWaitForPlayers()){
							gaming.join(myNick);
							aBoard.setGame(gaming);
							aBoard.start();
							addKeyListner();
						} else
							toLog("Musisz wybrac inny nick!");
					}catch(RemoteException e){
						toLog(e.getMessage());
						e.printStackTrace();
					}catch(MalformedURLException e){
						toLog("Podany adres serwera jest nieprawidlowy!");
						e.printStackTrace();
					}catch(NotBoundException e){
						toLog("Pod podanym adresem nie ma serwera gry!");
						e.printStackTrace();
					}
					jButtonPlayer1.setText(jConnectNick.getText());
					aBoard.setVisible(true);
					jPanelRight.setVisible(true);
					jConnectDialog.dispose();
					
					setJMenuBar(jMenuBar1);
					{
						disconnect.setEnabled(true);
						connect.setEnabled(false);
					}
					//TODO Draw game
				}
			};
		}
		return joinServer;
	}
	
	private AbstractAction getCloseConnection() {
		if(closeConnection == null) {
			closeConnection = new AbstractAction("disconnect", null) {
				public void actionPerformed(ActionEvent evt) {
					
					
					//TODO disconnect from server
					
					aBoard.setVisible(false);
					jPanelRight.setVisible(false);
					setJMenuBar(jMenuBar1);
					{
						disconnect.setEnabled(false);
						connect.setEnabled(true);
					}
				}
			};
		}
		return closeConnection;
	}
	 
	private JTextPane getJTextPane1() {
		if(jTextPane1 == null) {
			jTextPane1 = new JTextPane();
//			jTextPane1.setText("komunikaty\n sadfasdf \n sadfasfasfasf \n asdfasdf \n asdasw234 \n 23423asftrt3");
			jTextPane1.setBounds(668, 435, 128, 137);
			jTextPane1.setEditable(false);
			jTextPane1.setAutoscrolls(true);
		}
		return jTextPane1;
	}

}
