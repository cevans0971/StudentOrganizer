package studentOrganizer;

 import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssignmentMaker implements ActionListener{
	User user;
	 Class course;
	JButton btn;
	  JFrame main;
     JPanel panel;
    JLabel label1;
     JLabel label2;
     JLabel label3;
      JLabel label4;
      JLabel label5;
      JTextField j1;
     JTextField j2;
       JTextField j3;
      JTextField j4;
     @SuppressWarnings("rawtypes")
	JComboBox types;
	 Semester semester;
	public AssignmentMaker(Class course, User user, Semester semester)
	{
		this.semester = semester;
		this.user = user;
		this.course = course;
		main = new JFrame();
		main.setTitle("Make new assignment");
  		 main.setSize(500,500);
  		 main.setContentPane(makePanel());
  		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		 main.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JPanel makePanel() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setLayout(new GridLayout(11,2));
		label1 = new JLabel();
		label1.setText("Assignemnt Name");
		j1 = new JTextField(3);
		label2 = new JLabel();
		label2.setText("Date Assigned");
		j2 = new JTextField(3);
		label3 = new JLabel();
		label3.setText("Due Date");
		j3 = new JTextField(3);
		label4 = new JLabel();
		label4.setText("Assignment Grade");
		j4 = new JTextField(3);
		label5 = new JLabel();
		label5.setText("Type of assignment");
		ArrayList<String> words = new ArrayList<String>();
		words.add("homework");
		words.add("exam");
		words.add("in class");
		 String [] options = words.toArray(new String[words.size()]);
		types = new JComboBox(options);
		btn = new JButton("Enter");
		btn.addActionListener(this);
		panel.add(label1);
		panel.add(j1);
		panel.add(label2);
		panel.add(j2);
		panel.add(label3);
		panel.add(j3);
		panel.add(label4);
		panel.add(j4);
		panel.add(label5);
	 panel.add(types);
		panel.add(btn);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn)
		{
			  
			Assignment assignment = new Assignment(j1.getText(),j2.getText(),j3.getText(),Double.parseDouble(j4.getText()),(String) types.getSelectedItem());
			course.newAssignment(assignment);
	       user.write();
	       course.calculateTotalGrade();
	       semester.getSemesterGrade();
	       user.calculatetTotalGPA();
	       new StartUpWindow(user);
			//user.write();
		}
	}
	

}
