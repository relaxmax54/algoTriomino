/**
 * triomino.java
 *
 * Description:	    Interactive Triomino Solving Applet
 * @author			Bryan Berns
 * @version			1.0 Beta
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.BorderUIResource.*;


// The Applet!
public class triomino extends JApplet {

	int Space = -1;
	int I = -1;
	int J = -1;
	boolean Selected = false;
	boolean Solved = false;
	JButton SideButton[][];
	QButton Button[][];
	int N;
	int Number = -1;
	int SideSpace = -1;
	int GridThick = 1;
	int SidePanelSize = 8;
	SolutionThread SolutionThread = null;
	int ORDER = 1;
	int SLEEP_TIME = 750;
	int SIZE_THRESHOLD = 6;

	static Color GRAY     = Color.LIGHT_GRAY;
	static Color BLACK    = Color.BLACK;
	static Color RED      = Color.RED;
	static Color GREEN    = Color.GREEN;
	static Color BLUE     = Color.BLUE;
	static Color YELLOW   = Color.YELLOW;


// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
	// member declarations
	javax.swing.JTextPane Text_Number = new javax.swing.JTextPane();
	javax.swing.JLabel Label = new javax.swing.JLabel();
	javax.swing.JButton Button_Generate = new javax.swing.JButton();
	javax.swing.JLabel Label_SizeParam = new javax.swing.JLabel();
	javax.swing.JPanel HighLight = new javax.swing.JPanel();
	javax.swing.JPanel Button_Panel = new javax.swing.JPanel();
	javax.swing.JPanel Side_Panel = new javax.swing.JPanel();
	javax.swing.JButton Button_Solve = new javax.swing.JButton();
	javax.swing.JScrollBar Scroll = new javax.swing.JScrollBar();
	javax.swing.JLabel Label_Speed = new javax.swing.JLabel();
	javax.swing.JCheckBox CheckBox_Grid = new javax.swing.JCheckBox();
	javax.swing.JLabel Label_Message = new javax.swing.JLabel();
	javax.swing.JScrollPane Scroller = new javax.swing.JScrollPane();
	javax.swing.JTextArea Messages = new javax.swing.JTextArea();
	javax.swing.JTextPane TextY = new javax.swing.JTextPane();
	javax.swing.JTextPane TextX = new javax.swing.JTextPane();
	javax.swing.JLabel Label_Defective = new javax.swing.JLabel();
// END GENERATED CODE

	boolean isStandalone = false;

	public triomino() {
	}

	// Initialize the applet
	public void init() {
		try {
			initComponents();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initComponents() throws Exception {
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
		// the following code sets the frame's initial state
		Text_Number.setAutoscrolls(false);
		Text_Number.setBorder(new javax.swing.border.LineBorder(java.awt.Color.black, 1, false));
		Text_Number.setLocation(new java.awt.Point(180, 10));
		Text_Number.setSize(new java.awt.Dimension(28, 19));
		Text_Number.setText("4");
		Text_Number.setVisible(true);
		Label.setLocation(new java.awt.Point(10, 30));
		Label.setSize(new java.awt.Dimension(270, 20));
		Label.setText("Note: Number of Squares is (2^N x 2^N)");
		Label.setVisible(true);
		Button_Generate.setFocusPainted(false);
		Button_Generate.setLocation(new java.awt.Point(230, 10));
		Button_Generate.setSize(new java.awt.Dimension(90, 20));
		Button_Generate.setText("Generate");
		Button_Generate.setVisible(true);
		Label_SizeParam.setLocation(new java.awt.Point(13, 10));
		Label_SizeParam.setSize(new java.awt.Dimension(157, 20));
		Label_SizeParam.setText("Enter Size Parameter N:");
		Label_SizeParam.setVisible(true);
		HighLight.setBackground(null);
		HighLight.setBorder(new javax.swing.border.LineBorder(java.awt.Color.magenta, 4, false));
		HighLight.setForeground(null);
		HighLight.setLayout(null);
		HighLight.setLocation(new java.awt.Point(130, 70));
		HighLight.setOpaque(false);
		HighLight.setSize(new java.awt.Dimension(150, 150));
		HighLight.setVisible(false);
		Button_Panel.setBorder(new javax.swing.plaf.BorderUIResource.EmptyBorderUIResource(new java.awt.Insets(0, 0, 0, 0)));
		Button_Panel.setLayout(null);
		Button_Panel.setLocation(new java.awt.Point(20, 60));
		Button_Panel.setSize(new java.awt.Dimension(400, 400));
		Button_Panel.setVisible(true);
		Side_Panel.setBorder(new javax.swing.plaf.BorderUIResource.EmptyBorderUIResource(new java.awt.Insets(0, 0, 0, 0)));
		Side_Panel.setLayout(null);
		Side_Panel.setLocation(new java.awt.Point(440, 60));
		Side_Panel.setSize(new java.awt.Dimension(250, 250));
		Side_Panel.setVisible(true);
		Button_Solve.setEnabled(false);
		Button_Solve.setFocusPainted(false);
		Button_Solve.setLocation(new java.awt.Point(330, 10));
		Button_Solve.setSize(new java.awt.Dimension(90, 20));
		Button_Solve.setText("Solve");
		Button_Solve.setVisible(true);
		Scroll.setLocation(new java.awt.Point(540, 440));
		Scroll.setMaximum(1500);
		Scroll.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
		Scroll.setSize(new java.awt.Dimension(160, 20));
		Scroll.setValue(750);
		Scroll.setVisible(true);
		Label_Speed.setLocation(new java.awt.Point(430, 440));
		Label_Speed.setSize(new java.awt.Dimension(100, 20));
		Label_Speed.setText("Solving Speed: ");
		Label_Speed.setVisible(true);
		CheckBox_Grid.setEnabled(false);
		CheckBox_Grid.setLocation(new java.awt.Point(480, 10));
		CheckBox_Grid.setSize(new java.awt.Dimension(120, 20));
		CheckBox_Grid.setText("Remove Grid");
		CheckBox_Grid.setVisible(true);
		Label_Message.setLocation(new java.awt.Point(430, 320));
		Label_Message.setSize(new java.awt.Dimension(60, 20));
		Label_Message.setText("Status: ");
		Label_Message.setVisible(true);
		Scroller.setLocation(new java.awt.Point(430, 350));
		Scroller.setSize(new java.awt.Dimension(270, 80));
		Scroller.setVisible(true);
		Messages.setBorder(new javax.swing.plaf.BorderUIResource.EtchedBorderUIResource(1, java.awt.Color.white, new java.awt.Color(178, 178, 178)));
		Messages.setEditable(false);
		Messages.setFont(new java.awt.Font("Dialog", 0, 10));
		Messages.setVisible(true);
		TextY.setAutoscrolls(false);
		TextY.setBorder(new javax.swing.border.LineBorder(java.awt.Color.black, 1, false));
		TextY.setLocation(new java.awt.Point(640, 10));
		TextY.setSize(new java.awt.Dimension(30, 20));
		TextY.setText("0");
		TextY.setVisible(false);
		TextX.setAutoscrolls(false);
		TextX.setBorder(new javax.swing.border.LineBorder(java.awt.Color.black, 1, false));
		TextX.setLocation(new java.awt.Point(600, 10));
		TextX.setSize(new java.awt.Dimension(30, 20));
		TextX.setText("0");
		TextX.setVisible(false);
		Label_Defective.setLocation(new java.awt.Point(470, 10));
		Label_Defective.setSize(new java.awt.Dimension(110, 20));
		Label_Defective.setText("Coordinate:");
		Label_Defective.setVisible(false);
		getContentPane().setLayout(null);
		setLocation(new java.awt.Point(0, 0));

		Scroller.getViewport().add(Messages);
		getContentPane().add(Text_Number);
		getContentPane().add(Label);
		getContentPane().add(Button_Generate);
		getContentPane().add(Label_SizeParam);
		getContentPane().add(HighLight);
		getContentPane().add(Button_Panel);
		getContentPane().add(Side_Panel);
		getContentPane().add(Button_Solve);
		getContentPane().add(Scroll);
		getContentPane().add(Label_Speed);
		getContentPane().add(CheckBox_Grid);
		getContentPane().add(Label_Message);
		getContentPane().add(Scroller);
		getContentPane().add(TextY);
		getContentPane().add(TextX);
		getContentPane().add(Label_Defective);

		setSize(new java.awt.Dimension(709, 470));

		// event handling
		Button_Generate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Button_DoActionPerformed(e);
			}
		});
		Button_Solve.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Button_SolveActionPerformed(e);
			}
		});
		Scroll.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
			public void adjustmentValueChanged(java.awt.event.AdjustmentEvent e) {
				ScrollAdjustmentValueChanged(e);
			}
		});
		CheckBox_Grid.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent e) {
				CheckBox_GridStateChanged(e);
			}
		});

// END GENERATED CODE

		// My portion of the Initialization function.
		SideButton = new JButton[SidePanelSize][SidePanelSize];
		SideSpace = 250 / SidePanelSize;
		for (int i = 0; i < SidePanelSize; i++) {
			for (int j = 0; j < SidePanelSize; j++) {
				SideButton[i][j] = new JButton();
				Side_Panel.add(SideButton[i][j]);
				SideButton[i][j].setBackground(Color.white);
				SideButton[i][j].setLocation(new Point(i * SideSpace,j * SideSpace));
				SideButton[i][j].setSize(new Dimension(SideSpace,SideSpace));
				SideButton[i][j].setBorder(new LineBorder(Color.black, 1, false));
				SideButton[i][j].setVisible(true);
				SideButton[i][j].setFont(new java.awt.Font("Dialog", 0, 10));
			}
		}
		Button_DoActionPerformed(null);
	}

	// Occurs when user presses 'Generate'
	public void Button_DoActionPerformed(ActionEvent e) {
		Solved = false;
		Button = null;
		System.gc();
		HighLight.setVisible(false);
		CheckBox_Grid.setEnabled(true);
		Button_Panel.removeAll();
		Button_Panel.repaint();
		try { N = (new Integer(Text_Number.getText())).intValue(); }
		catch (Exception a) {
			AddLine("Invalid input.  Try Again.");
			return;		
		}
		if (N > 10) { AddLine("Warning: On common machines, N values larger than 10 can cause java memory errors. Aborting..."); return;}		
		Number = 1;
		for (int i = 0; i < N; i++) Number *= 2;
		Button = new QButton[Number][Number];
		Space = 400 / Number;
		Side_Panel.setVisible(Number > SidePanelSize);
		Button_Panel.add(HighLight);
		for (int i = 0; i < Number; i++) {
			for (int j = 0; j < Number; j++) {
				Button[i][j] = new QButton(N <= SIZE_THRESHOLD);
				if (N <= SIZE_THRESHOLD) {
					Button_Panel.add(Button[i][j].button);
					Button[i][j].button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ButtonSelectSquare(e);
					}
					});
				}
				Button[i][j].setBackground(Color.white);
				Button[i][j].setLocation(new Point(i * Space,j * Space));
				Button[i][j].setSize(new Dimension(Space,Space));
				Button[i][j].setBorder(new LineBorder(Color.black, GridThick, false));
				Button[i][j].setVisible(true);
			}
		}
		Selected = (N > SIZE_THRESHOLD);
		Button_Solve.setEnabled(N > SIZE_THRESHOLD);
		Button_Solve.setText("Solve");
		Label_Defective.setVisible(N > SIZE_THRESHOLD);
		CheckBox_Grid.setVisible(N <= SIZE_THRESHOLD);
		TextX.setVisible(N > SIZE_THRESHOLD);
		TextY.setVisible(N > SIZE_THRESHOLD);
		if (N > SIZE_THRESHOLD) AddLine("Please enter a defective coordinate and press solve");
		else AddLine("Please click the square to be defective.");
	}

	// Reterns the inverse of a color
	public Color Invert(Color i) {
		return new Color(255 - i.getRed(),255 - i.getGreen(),255 - i.getBlue());
	}

	// The N <= THRESHOLD defective square handler
	public void	ButtonSelectSquare(ActionEvent e) {
		JButton ButtonSquare = (JButton) e.getSource();
		HighLight.setVisible(Number > SidePanelSize);
		for (int i = 0; i < Number; i++) for (int j = 0; j < Number; j++) {
			if (Button[i][j].button == ButtonSquare) {
				if (!Selected) {
					I = i;
					J = j;
					Selected = true;
					Button[i][j].setBackground(BLACK);
					Button[i][j].setForeground(Invert(BLACK));
					Button[i][j].setText("X");
					Button_Solve.setEnabled(true);
				}
				MoveHighlight(i,j);
				break;
			}
		}
	}

	// The N > THRESHOLD defective square handler
	public void	ButtonSelectSquareMan(int is,int js) {
		I = is;
		J = js;
		Selected = true;
		Button[I][J].setBackground(BLACK);
		Button[I][J].setForeground(Invert(BLACK));
		Button[I][J].setText("X");
		MoveHighlight(I,J);
	}

	// Just a shortened sleep function
	public void SLEEP(long m) { try { Thread.sleep(m); } catch (Exception e) {};}

	// Seperate thread to solve the problem in order, (Allows UI to update)
	public class SolutionThread extends Thread {
        int MI; int MJ; int MS; int MM; int MN;
        public SolutionThread(int i, int j, int s, int m, int n) {
               MI = i; MJ = j; MS = s; MM = m; MN = n;
        };
        public void run() {
	        if (N > SIZE_THRESHOLD) {
	        	try { 
        			int x = (new Integer(TextX.getText())).intValue();
	        		int y = (new Integer(TextY.getText())).intValue();
    	    		if (x >= Number || y >= Number) AddLine("Invalid defective coordinate");
        			else ButtonSelectSquareMan(x,y);
				} catch (Exception e) {
					AddLine("Invalid input. Not a valid number");
				}
			}
	        Button_Solve.setEnabled(false);
	        Button_Generate.setEnabled(false);
	        ORDER = 1;
        	Recurse(MI,MJ,MS,MM,MN);
        	Button_Generate.setEnabled(true);
        	Solved = true;
        	if (N > SIZE_THRESHOLD) Button_Solve.setText("View");
        	Button_Solve.setEnabled(N > SIZE_THRESHOLD);
        	AddLine("Done Solving");
        }
    }

	// Occurs when user presses the 'Solve' button
	public void Button_SolveActionPerformed(ActionEvent e) {
		if (Solved && N > SIZE_THRESHOLD) {
			try {
	       		int x = (new Integer(TextX.getText())).intValue();
    	   		int y = (new Integer(TextY.getText())).intValue();  	
    	   		//AddLine((new Integer(Number)).toString());
    	   		if (x >= Number || y >= Number) AddLine("Invalid coordinate");
    	   		else MoveHighlight(x,y);
    	   	} catch (Exception a) {
    	   		AddLine("Invalid input. Try Again.");
    	   	}
    	   	return;
		}
		SolutionThread = new SolutionThread(0,0,Number,I,J);
		AddLine("Solving...");
		SolutionThread.start();
	}

	// Moves the highlighted square / updates the size square
	public void MoveHighlight(int i, int j) {
		if (Number <= SidePanelSize) return;
		int SI = BC(i,SidePanelSize);
		int SJ = BC(j,SidePanelSize);
		for (int di = 0; di < SidePanelSize; di ++) for (int dj= 0; dj< SidePanelSize; dj++) {
			SideButton[di][dj].setBackground(Button[di + SI][dj + SJ].getBackground());
			SideButton[di][dj].setText(Button[di + SI][dj + SJ].getText());
			SideButton[di][dj].setForeground(Button[di + SI][dj + SJ].getForeground());
		}
		if (N <= SIZE_THRESHOLD) {
			HighLight.setSize(Space * SidePanelSize,Space * SidePanelSize);
			HighLight.setLocation(SI * Space,SJ * Space);
		}
	}

	// Finds the nearest base
	public int BC(int i, int s) { return s * (int) (i / s); }

	// Recursely solves the triomino problems
	public void Recurse(int i, int j, int size, int m, int n) {
		if (size == 1) {
        	AddLine("Invalid Input.");
        	return;
		} else if (size == 2) {
			boolean hasYellow = false;
			boolean hasRed = false;
			boolean hasGreen = false;
			boolean hasBlue = false;
			if (N <= SIZE_THRESHOLD) AddLine("Added a triomino.");
			for (int ci = i - 1; ci < i + 4; ci++) {
				for (int cj = j - 1; cj < j + 4; cj++) {
					try {
					hasYellow = Button[ci][cj].getBackground() == YELLOW | hasYellow;
					hasBlue   = Button[ci][cj].getBackground() == BLUE   | hasBlue;
					hasGreen  = Button[ci][cj].getBackground() == GREEN  | hasGreen;
					hasRed    = Button[ci][cj].getBackground() == RED    | hasRed;
					} catch (Exception e) {};
				}
			}
			for (int di = i; di < i + 2; di++)
			for (int dj = j; dj < j + 2; dj++) {
				if (m != di || n != dj) {
					if (!hasYellow) Button[di][dj].setBackground(YELLOW);
					else if (!hasRed) Button[di][dj].setBackground(RED);
					else if (!hasBlue) Button[di][dj].setBackground(BLUE);
					else if (!hasGreen) Button[di][dj].setBackground(GREEN);
					else Button[di][dj].setBackground(YELLOW);
					Button[di][dj].setText((new Integer(ORDER)).toString());
					Button[di][dj].setForeground(Invert(Button[di][dj].getBackground()));
 				}
			}
			MoveHighlight(i,j);
			SLEEP(SLEEP_TIME);
			ORDER++;
			return;
		}

		int ns = size / 2;
		int SI = BC(m,ns);
		int SJ = BC(n,ns);
		int DI = i + ns;
		int DJ = j + ns;
		int SS[][] = new int[4][2];
		SS[0][0] = DI;     SS[0][1] = DJ - 1;
		SS[1][0] = DI;     SS[1][1] = DJ;
		SS[2][0] = DI - 1; SS[2][1] = DJ;
		SS[3][0] = DI - 1; SS[3][1] = DJ - 1;
		int o = 0;
		if (N <= SIZE_THRESHOLD) AddLine("Solving Subsquare of Size: " + (new Integer(ns)).toString());
		for (int s = 0; s < 4; s++) {
			if (SI != BC(SS[s][0],ns) || SJ != BC(SS[s][1],ns)) {
	        	if (N <= SIZE_THRESHOLD) AddLine("Added a placeholder triomino.");
				Button[SS[s][0]][SS[s][1]].setBackground(GRAY);
				Button[SS[s][0]][SS[s][1]].setText((new Integer(ORDER)).toString());
			}
			else o = s;
		}
		ORDER++;
		SS[o][0] = m; SS[o][1] = n;
		for (int s = 0; s < 4; s++) {
			MoveHighlight(SS[s][0],SS[s][1]);
			SLEEP(SLEEP_TIME);
			Recurse(BC(SS[s][0],ns),
					BC(SS[s][1],ns),
					ns,
					SS[s][0],
					SS[s][1]);
		}
	}

	// Control for the speed
	public void ScrollAdjustmentValueChanged(AdjustmentEvent e) {
		SLEEP_TIME = 1500 - Scroll.getValue();
	}

	// Just add a line to the message box
	public void AddLine(String s) {
		Messages.setText(Messages.getText() + s + "\n");
		Messages.selectAll();
		int x = Messages.getSelectionEnd();
		Messages.select(x,x);

	}

	// Will remove the grid if user clicks the checkbox
	public void CheckBox_GridStateChanged(javax.swing.event.ChangeEvent e) {
		GridThick = (CheckBox_Grid.isSelected()) ? 0 : 1;
		if (GridThick == 0) CheckBox_Grid.setText("Add Grid");
		else CheckBox_Grid.setText("Remove Grid");
		for (int i = 0; i < Number; i++)
			for (int j = 0; j < Number; j++)
				Button[i][j].setBorder(new LineBorder(Color.black, GridThick, false));
	}
}
