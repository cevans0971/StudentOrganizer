package studentOrganizer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class UserReader {
User user;
JFrame main;
public UserReader(User user1)
{
	this.user = user1; 
	main = new JFrame();
	main.setTitle("Read user info");
		 main.setSize(500,500);
		 
		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 main.setVisible(true);
		 JTextArea text = new JTextArea(user.print());
		 main.add(text);
}
}
