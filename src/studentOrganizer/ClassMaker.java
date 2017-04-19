package studentOrganizer;

 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClassMaker implements ActionListener {
	User user;
	Semester semester;
	JFrame main;
	JPanel panel;
	JButton btn;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;
	 ArrayList<JTextField> fields;
	 JTextField j;
	 JTextField j2;
	 JTextField j3;
	 JTextField j4;
	 JTextField j5;
	 JTextField j6;
	 JTextField j7;
	 JTextField j8;
	 JTextField j9;
	 JTextField j10;
	 JButton btn2;
	 Class course;
	public ClassMaker(User user, Semester semester) {
		this.user = user;
		this.semester = semester;
		main = new JFrame();
		main.setTitle("Make new class");
  		 main.setSize(500,500);
  		 main.setContentPane(makePanel());
  		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		 main.setVisible(true);
		// TODO Auto-generated constructor stub
	}

 

	public JPanel makePanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(11,2));
		 
			
		 
		label = new JLabel();
		label.setText("Course Name");
		  j = new JTextField(3);
		label2 = new JLabel();
		  j2 = new JTextField(3);
		label2.setText("Professor");
		label3 = new JLabel();
		  j3 = new JTextField(3);
		label3.setText("Professor E-Mail");
		label4 = new JLabel();
		  j4 = new JTextField(3);
		label4.setText("Professor's Phne Number");
	      label5 = new JLabel();
		label5.setText("Professor's Office");
		  j5 = new JTextField(3);
	     label6 = new JLabel();
		label6.setText("Office Hours");
		  j6 = new JTextField(3);
		label7 = new JLabel();
		  j7 = new JTextField(3);
		label7.setText("Textbook Publisher Info");
		label8 = new JLabel();
		label8.setText("Textbook title");
		  j8 = new JTextField(3);
		
		label9 = new JLabel();
		label9.setText("Credits");
		label10 = new JLabel();
		label10.setText("Final Grade");
		 j9 = new JTextField(3);
	          btn2 = new JButton("Add assignment");
		   fields = new ArrayList<JTextField>();
		   fields.add(j);
		   fields.add(j2);
		   fields.add(j3);
		   fields.add(j4);
		   fields.add(j5);
		   fields.add(j6);
		   fields.add(j7);
		   fields.add(j8);
		   fields.add(j9);
		   fields.add(j10);
		j10 = new JTextField(3);   
		btn = new JButton("Enter");
		btn.setSize(50,100);
		btn.setLocation(400,400);
		btn.addActionListener(this);
		// TODO Auto-generated method stub
		panel.add(label);
		panel.add(j);
		panel.add(label2);
		panel.add(j2);
		panel.add(label3);
		panel.add(j3);
		panel.add(label4);
		panel.add(j4);
		panel.add(label5);
		panel.add(j5);
		panel.add(label6);
		panel.add(j6);
		panel.add(label7);
		panel.add(j7);
		panel.add(label8);
		panel.add(j8);
		panel.add(label9);
		panel.add(j9);
		panel.add(label10);
	    panel.add(j10);
		panel.add(btn);
		btn2.addActionListener(this);
		panel.add(btn2);
		
		return panel;
	}
 


	@Override
	public void actionPerformed(ActionEvent e) {
		semester.addClass(course);
		if ( e.getSource() == btn)
		{
			Professor prof = new Professor(fields.get(1).getText(),fields.get(2).getText(),fields.get(3).getText(),fields.get(4).getText(),fields.get(5).getText());
			Textbook text = new Textbook(fields.get(6).getText(),fields.get(7).getText());
			 course = new Class(fields.get(0).getText(),text,prof,Integer.parseInt(fields.get(8).getText()));
			semester.addClass(course);
	          System.out.println(user.print());
		 
			user.write();
			new StartUpWindow(user);
		}
		if(e.getSource() == btn2)
		{  
			user.write();
		 
			new AssignmentMaker(course,user,semester);
		}
			
		// TODO Auto-generated method stub
		
	}



	public void addText(String text) {
		for(int i=0;i<semester.getCourses().size();i++)
		{
			if(semester.getCourses().get(i).getCourseName() == text)
			{
				  course = semester.getCourses().get(i);
				semester.removeCourse(course);
				j.setText(course.getCourseName());
				j2.setText(course.getProfessorInfo().getName());
				j3.setText(course.getProfessorInfo().getEmail());
				j4.setText(course.getProfessorInfo().getPhone());
				j5.setText(course.getProfessorInfo().getOffice());
				j6.setText(course.getProfessorInfo().getOfficeHrs());
				j7.setText(course.getTextbookInfo().getPublisherInfo());
				j8.setText(course.getTextbookInfo().getTitle());
				j9.setText("" + course.getCredits());
				j10.setText(("" +course.getFinalGrade()));
				if(course.getFinalGrade() !=0)
				{
				  j10.setText("" + course.getFinalGrade());
			}
				else j10.setText("N/A");
		}
		// TODO Auto-generated method stub
		
	}

}
}
