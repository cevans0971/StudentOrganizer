package studentOrganizer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassView implements ActionListener {
	User user;
	JPanel panel;
    JFrame mainScreen;
    Semester semester;
    @SuppressWarnings("rawtypes")
	JComboBox classChooser;
	public ClassView(String text, User user1) {
		this.user = user1;
		for(int i=0;i<user.getSemesters().size();i++)
{
           if (text == user.getSemesters().get(i).getSemesterTime())
{
            semester = user.getSemesters().get(i);
}

}
	
		
		mainScreen = new JFrame();
	   	  mainScreen.setSize(800, 800);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Class View");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public JPanel makePanel() {
		// TODO Auto-generated method stub
		ArrayList<String> courseNames = new ArrayList<String>();
	      panel = new JPanel();
	      courseNames.add(" ");
	         
	           for(int i=0;i < semester.getCourses().size();i++)
	           {
	        	   courseNames.add(semester.getCourses().get(i).getCourseName());
	           }
	      String [] courses = courseNames.toArray(new String[courseNames.size()]);
	      classChooser = new JComboBox(courses);
	      classChooser.setSize(100,50);
	      classChooser.setLocation(100,100);
	      classChooser.addActionListener(this);
	       panel.add(classChooser);
				
				return panel;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(user.print());
		JComboBox cc =  (JComboBox) e.getSource();
		 
		ClassMaker classMaker = new ClassMaker(user, semester);
		 
		classMaker.addText((String) cc.getSelectedItem());
	 
	}
		// TODO Auto-generated method stub
		
	}
