package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class Board extends Canvas  {
	public static final int width= 800;
	public static final int height = 800;
	Board(Composite composite){
		super(composite,SWT.NULL);
		this.setSize(Board.width, Board.height);
		this.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_BLUE));
	}

}
