package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class GameBoard extends Canvas  {
	public static final int width= 600;
	public static final int height = 800;
	

	GameBoard(Composite composite){
		super(composite,SWT.BACKGROUND);
		this.setSize(GameBoard.width, GameBoard.height);
		this.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
	}

}
