package studentOrganizer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SemesterWindow implements ActionListener {
	User user;
	JFrame mainScreen;
	JPanel panel;
	JButton btn2;
      @SuppressWarnings("rawtypes")
	JComboBox chooser;
      JLabel header;
	public SemesterWindow(User user)
	{

		this.user = user;
		 mainScreen = new JFrame();
	   	  mainScreen.setSize(800, 800);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Semester Window");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
	}
      @SuppressWarnings({ "rawtypes", "unchecked" })
	public JPanel makePanel() {
    	  panel = new JPanel();
  	    panel.setLayout(null);
  	    header= new JLabel();
  	    header.setText(user.getUsername() + ":Semesters");
  	    header.setLocation(400,0);
  	    header.setSize(200,50);
          ArrayList<String> names = new ArrayList<String>();
          names.add(" ");
  	    for(int i=0; i<user.getSemesters().size();i++)
  	    {
          
  	    	String semesterName = user.getSemesters().get(i).getSemesterTime();
           names.add(semesterName);
       }
           names.add("Add new semester");
         String [] times = names.toArray(new String[names.size()]);
          chooser = new JComboBox(times);
          chooser.setLocation(400,50);
          chooser.setSize(100, 25);
           chooser.addActionListener(this);
         
  	     panel.add(chooser);	
  	    panel.add(header);	  	    
  	   	
  	   		return panel;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cs = (JComboBox) e.getSource();
           String chosen = (String) cs.getSelectedItem();
		if(chosen == "Add new semester")
		{
			new SemesterMaker(user);
			
			
		}
		
		else 
{
			new ClassWindow(chosen,user);
		
		// TODO Auto-generated method stub
			}
	}

}