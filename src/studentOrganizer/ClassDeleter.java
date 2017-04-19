package studentOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassDeleter implements ActionListener {
Semester semester;
JFrame mainScreen;
User user;
JPanel panel;
@SuppressWarnings("rawtypes")
JComboBox classChooser;
	 

	public ClassDeleter(String text, User user1) {
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
	   	mainScreen.setContentPane(makePanel(semester));
	   	  mainScreen.setTitle("Delete Class");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JPanel makePanel(Semester semester) {
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
		// TODO Auto-generated constructor stub
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cc =  (JComboBox) e.getSource();
		String course = (String) cc.getSelectedItem();
		for(int i =0;i<semester.getCourses().size();i++)
		{
		  if(semester.getCourses().get(i).getCourseName() == course)
		  {
			   
			 
			  semester.removeCourse(semester.getCourses().get(i));
			  if(semester.getNumberOfClasses() ==0)
			  {
				  user.removeSemester(semester);
			  }
			  user.write();
			new StartUpWindow(user);
		  }
		
		}
		// TODO Auto-generated method stub
		
	}
	

}


