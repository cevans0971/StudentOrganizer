package studentOrganizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 

public class StartUpWindow implements ActionListener {
	JFrame mainScreen;
	JButton btn;
	JButton btnTwo;
	JButton btnThree;
	JButton btnFour;
	User user;
	JLabel label;
	 
	public StartUpWindow(User user)
	{
		this.user = user;
		 mainScreen = new JFrame();
	   	  mainScreen.setSize(800, 800);
	   	mainScreen.setContentPane(makePanel());
	   	  mainScreen.setTitle("Student Database");
	   	  mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     	mainScreen.setVisible(true);
	}
	public JPanel makePanel()
    {
  	  JPanel panel = new JPanel();
  	  panel.setLayout(null);
  	  panel.setOpaque(true);
  	 
  	  JLabel header = new JLabel();
  	  header.setText("What do you want to do?");
  	  header.setLocation(400,0);
  	  header.setSize(200,50);
  	  label = new JLabel();
  	  label.setLocation(0,500);
  	  label.setSize(200,50);
  	  label.setText("total GPA" + user.calculatetTotalGPA());
  	  for(int i=0;i<user.getSemesters().size();i++)
  	  {
  		  JLabel label2 = new JLabel();
  	       label2.setSize(200,50);
  	       label2.setLocation(0,50*i+50);
  	       label2.setText(user.getSemesters().get(i).getSemesterTime() + " " + user.getSemesters().get(i).getSemesterGrade());
  	       panel.add(label2);
  	  }
  	   btn = new JButton("Create");
  	  btn.setLocation(400, 100);
  	  btn.setSize(100, 50);
  	  btn.addActionListener(this);
  	 
  	  btnTwo = new JButton("Read");
  	  btnTwo.setLocation(400,300);
  	  btnTwo.setSize(100,50);
  	  btnTwo.addActionListener(this);
  	  
  	 btnThree = new JButton("Update");
  	 btnThree.setLocation(400,500);
  	 btnThree.setSize(100,50);
  	 btnThree.addActionListener(this);
  	  
  	 btnFour = new JButton("Delete");
  	 btnFour.setLocation(400,700);
  	 btnFour.setSize(100,50);
  	 btnFour.addActionListener(this);
  	 
  	 panel.add(header);
  	  panel.add(btn);
  	  panel.add(btnTwo);
  	  panel.add(btnThree);
  	  panel.add(btnFour);
  	  panel.add(label);
  	  return panel;
    }
 
 

public void actionPerformed(ActionEvent e) {
 
	 if(e.getSource() == btn)
	 {
		 new SemesterWindow(user);
	 }
	 if(e.getSource() == btnTwo)
	 {
		 new UserReader(user);
		 //read the file
	 }
	 if(e.getSource() == btnThree)
	 {
		 new SemesterView(user);
	 
	 }
	 if(e.getSource() == btnFour)
	 {
		 boolean isTrue = true;
		 new SemesterView(user,isTrue);
	 }
	// TODO Auto-generated method stub
	
	// TODO Auto-generated method stub
	
}
 
 
}