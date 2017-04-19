package studentOrganizer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * This class represents a student that has a username, password, a list of the semesters, and a total gpa across all the semesters
 */

public class User {

private String username;
private String password;
private ArrayList<Semester> semesters = new ArrayList<Semester>();
private double totalGPA;
public User(String username,String password)
{
	this.username = username;
	this.password = password;
}
public User(String value) {
	username = value;
	// TODO Auto-generated constructor stub
}
/**
 * 
 * @return the user's password
 */

public String getPassword() {
	return password;
}
/**
 * 
 * @param password is the users password
 */

public void setPassword(String password) {
	this.password = password;
}/**
 * 
 * @return the list of the user's semesters
 */

public ArrayList<Semester> getSemesters() {
	return semesters;
}/**
 * 
 * @param semesters is the list of the user's semesters
 */

public void setSemesters(ArrayList<Semester> semesters) {
	this.semesters = semesters;
}/**
 * 
 * @param newSemester is a new semester for the user
 */

public void newSemester(Semester newSemester)
{
	semesters.add(newSemester);
	
}/**
 * 
 * @return the total gpa across semesters
 */

public double calculatetTotalGPA() {
	 int i = 0;
	 double total = 0.0;
	 while(i < semesters.size())
	{
		 if(semesters.get(i).getSemesterGrade()!= 0)
		 {
		total += semesters.get(i).getSemesterGrade();//adds each semester GPA
		i++;
	}
	}
   totalGPA = total/semesters.size();//divides the sum of each semester GPA by the number of semesters
  return totalGPA;
}/**
 * 
 * @return the user's username
 */

public String getUsername() {
	return username;
}/**
 * 
 * @param username is the user's username
 */

public void setUsername(String username) {
	this.username = username;
}/**
 * 
 * @return the students GPA across all semesters
 */

public double getTotalGPA()
{
	return totalGPA;
}/**
 * 
 * @return all of the user's information
 */

public String print() {
	String string = "";
	for (int i =0;i<semesters.size(); i++)
	{
		string+=semesters.get(i).print();
	}
	return string;
	// TODO Auto-generated method stub
	
}/**
 * writes all of the information about the user to a text file
 */

public void write()  
{
	String string = ("Username:"+ username);

	string+=("\nPassword:"+ password);
 
	for (int i =0;i<semesters.size(); i++)
	{
        string+=semesters.get(i).print();
	 
	}
	try {
		 
		

		FileWriter fw = new FileWriter("grades.txt",false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(string);
		bw.close();

	 

	} catch (IOException e) {
		e.printStackTrace();
	}

}
/**
 * 
 * @param semester is a semester to be removed from the students records
 */
public void removeSemester(Semester semester) {
	semesters.remove(semester);
	// TODO Auto-generated method stub
	
}


}
