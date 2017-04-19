package studentOrganizer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class LogInWindow implements ActionListener {
JFrame mainScreen;
TextField usernameField;
JPasswordField passwordField;
JLabel username;
JLabel password;
JButton login;
JPanel panel;
String usrname;
String passwrd;
JLabel error;
ArrayList<User> students;
	public LogInWindow()
	{
		mainScreen = new JFrame();
	   	  mainScreen.setSize(400, 200);
	   	mainScreen.setTitle("Login");
	   	mainScreen.setContentPane(makePanel());
	    mainScreen.setVisible(true);
	}

	public LogInWindow(ArrayList<User> students) {
		mainScreen = new JFrame();
	   	  mainScreen.setSize(400, 200);
	   	mainScreen.setTitle("Login");
	   	mainScreen.setContentPane(makePanel());
	    mainScreen.setVisible(true);
	    this.students = students; 
	   
		
		// TODO Auto-generated constructor stub
	}

	public JPanel makePanel() {
		 panel = new JPanel();
	   	  panel.setLayout(null);
	   	  panel.setOpaque(true);
	   	  
	   	  username = new JLabel();
	   	  username.setText("username");
	   	  username.setSize(70, 50);
	   	  username.setLocation(83,35);
	   	  
	   	  password = new JLabel();
	   	  password.setText("password");
	   	  password.setSize(70,50);
	   	  password.setLocation(83,65);
	   	 
	   	  usernameField = new TextField(20);
	   	  usernameField.setSize(100,20);
	   	  usernameField.setEditable(true);
	   	  usernameField.setLocation(150,50);
	   	  
	   	  passwordField = new JPasswordField(30);
	
	   	  passwordField.setSize(100,20);
	   	  passwordField.setLocation(150,80);
	   	  
	   	  login = new JButton("Login");
	   	  login.setSize(80,40);
	   	  login.setLocation(150,100);
	   	  login.addActionListener(this);
	   	  
	   	  panel.add(login);
	   	  panel.add(password);
	   	  panel.add(username);
		  panel.add(usernameField);
	   	  panel.add(passwordField);
		// TODO Auto-generated method stub
		return panel;
	}
    public String getUsrName()
    {
   	 return usrname;
   	 
    }
    public String getPasswrd()
    {
   	 return passwrd;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login)
		{
		 usrname  = usernameField.getText();
		 passwrd = null;
		@SuppressWarnings("deprecation")
		String password = passwordField.getText();
		passwrd = password;
		 User user = null;
			for(int i=0; i< students.size();i++)
			{
				 
				 
				  
				if((getUsrName().equals(students.get(i).getUsername())) && (getPasswrd().equals(students.get(i).getPassword())))
			 {
			     user = students.get(i);
				new StartUpWindow(user);
			}
			}
			if(user == null)
			{
				errorMessage();
			}
		// TODO Auto-generated method stub
		
	}
	}


	public void errorMessage() {
		 error = new JLabel();
		error.setText("Invalid login");
		error.setSize(90,50);
		error.setLocation(100,0);
		panel.add(error);
		// TODO Auto-generated method stub
		
	}

}

