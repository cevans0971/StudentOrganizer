package studentOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SemesterView implements ActionListener {
	User user;
	JFrame mainScreen;
	JPanel panel;
	@SuppressWarnings("rawtypes")
	JComboBox chooser;
	boolean isClicked;
	JLabel header;
	public SemesterView(User user)
	{
		isClicked = false;
		this.user = user;
		 mainScreen = new JFrame();
	   	  mainScreen.setSize(800, 800);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Student Database");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
	}
	public SemesterView(User user, boolean isTrue)
	{
		isClicked = isTrue;
		this.user = user;
		 mainScreen = new JFrame();
	   	  mainScreen.setSize(800, 800);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Semester View");
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
             
           String [] times = names.toArray(new String[names.size()]);
            chooser = new JComboBox(times);
            chooser.setLocation(400,50);
            chooser.setSize(100, 25);
             chooser.addActionListener(this);
           
    	     panel.add(chooser);	
    	    panel.add(header);	  	    
    	   	
    	   		
		return panel; 

}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("rawtypes")
		JComboBox cs = (JComboBox) e.getSource();
        String chosen = (String) cs.getSelectedItem();
		if(isClicked == false)
		{
			 
		 new ClassView(chosen,user);
	}
		else 
		{
			new ClassDeleter(chosen,user);
		}
		// TODO Auto-generated method stub
		
	}
}
