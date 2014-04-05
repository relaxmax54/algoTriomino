import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.BorderUIResource.*;

// The QButton class 'emulates' a JButton for this project.  This was created so
// we could use some larger values of 'N' since JButton take up so much space

public class QButton {
	Color b;
	Color f;
	JButton button;
	String s;
	boolean real;
	
	QButton (boolean _) {
		real = _;
		if (real) {
			button = new JButton();
			button.setFont(new java.awt.Font("Dialog", 0, 10));
		}
	}	
	public void setForeground(Color _) {
		f = _;
		if (real) button.setForeground(_);
	}
	public void setBackground(Color _) {
		b = _;
		if (real) button.setBackground(_);
	}
	public void setLocation(Point _) {
		if (real) button.setLocation(_);
	}
	public void setSize(Dimension _) {
		if (real) button.setSize(_);
	}
	public void setBorder(LineBorder _) {
		if (real) button.setBorder(_);
	}
	public void setVisible(boolean _) {
		if (real) button.setVisible(_);
	}
	public void setText(String _) {
		s = _;
		if (real) button.setText(_);
	}
	public Color getForeground() { return f; };
	public Color getBackground() { return b; };
	public String getText() { return s; };		
}
