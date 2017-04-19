package studentOrganizer;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SemesterMaker implements ActionListener {
User user;
JFrame mainScreen;
JPanel panel;
@SuppressWarnings("rawtypes")
JComboBox timeOfYear;
@SuppressWarnings("rawtypes")
JComboBox year;
JButton btn;
	public SemesterMaker(User user) 
	{
		this.user = user;
		 mainScreen = new JFrame();
	   	  mainScreen.setSize(200, 200);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Make Semester");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JPanel makePanel() {
		panel = new JPanel();
		
		ArrayList<String> seasons = new ArrayList<String>();
		seasons.add(" ");
		seasons.add("Spring");
		seasons.add("Fall");
		String[] season = seasons.toArray(new String[seasons.size()]);
		timeOfYear = new JComboBox(season);
		ArrayList<String>  dates = new ArrayList<String>();
		dates.add(" ");
		        for (int i=2000;i<3000;i++)
		{
			dates.add("" +i);
		}
	     String[] date = dates.toArray(new String[dates.size()]);
		year = new JComboBox(date);
		
		btn = new JButton("Enter");
		btn.setSize(50,50);
		btn.setLocation(75,75);
		btn.addActionListener(this);
		panel.add(timeOfYear);
		panel.add(year);
		panel.add(btn);
		// TODO Auto-generated method stub
		return panel;
	}
	


   
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btn)
	{
		String season = (String) timeOfYear.getSelectedItem();
		String year = (String) this.year.getSelectedItem();
		Semester semester = new Semester("" + season + " " + year);
		user.newSemester(semester);
	 
		user.write();
		new ClassMaker(user, semester);
	}
	// TODO Auto-generated method stub
	
}
}