 package studentOrganizer;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassWindow  implements ActionListener{
	User user;
	JPanel panel;
    JFrame mainScreen;
    Semester semester;
    JButton btn2;
    @SuppressWarnings("rawtypes")
	JComboBox classChooser;
	public ClassWindow(String text, User user1) {
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
	   	  mainScreen.setTitle("Class Window");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JPanel makePanel() {
		// TODO Auto-generated method stub
	ArrayList<String> courseNames = new ArrayList<String>();
      panel = new JPanel();
      courseNames.add(" ");
           courseNames.add("Add new class");
      String [] courses = courseNames.toArray(new String[courseNames.size()]);
      classChooser = new JComboBox(courses);
      classChooser.setSize(100,50);
      classChooser.setLocation(100,100);
      classChooser.addActionListener(this);
       panel.add(classChooser);
			
			return panel;
	

}
	 
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cc = (JComboBox) e.getSource();
		String chosen = (String) cc.getSelectedItem();

          if(chosen == "Add new class");
       {
			new ClassMaker(user, semester);
	
		
		// TODO Auto-generated method stub
		
	}
		

}
}
