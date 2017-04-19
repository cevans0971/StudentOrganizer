package studentOrganizer;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class RunUser {
 private static ArrayList<User> students;
public static void main (String[] args)
{
      
	BufferedReader br = null;
	students = new ArrayList<User>();
	try
	{
			String sCurrentLine;
            User user = null;
            Semester semester = null;
            Class course = null;
            Professor prof = null;
            Textbook textbook = null;
            Assignment assignment = null;
        	ArrayList<Semester> semesters = new ArrayList<Semester>();
			br = new BufferedReader(new FileReader("grades.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
			     
				StringTokenizer tokenizer = new StringTokenizer(sCurrentLine, ":");
				String tag = tokenizer.nextToken();
			    String value = tokenizer.nextToken();
			   
				switch(tag)
				{
				
				case "Username":
				       user = new User(value);
				 
				       students.add(user);
				        break;
				case "Password":
					   user.setPassword(value);
				 
					   break;
		       case "Semester":
					 semester = new Semester(value);
				
					user.setSemesters(semesters);
					semesters.add(semester);
					break;
				case "Final Average":
					semester.setSemesterGrade(Double.parseDouble(value));
					System.out.println(value);
					break;
				case "The class name is":
				     course = new Class(value);
						semester.addClass(course);
					break;
				case "Professor":
					  prof = new Professor(value);
					course.setProfessorInfo(prof);
					break;
				case "E-Mail":
					prof.setEmail(value);
					break;
				case "Phone number":
					prof.setPhone(value);
					break;
				case "Office":
					prof.setOffice(value);
					break;
				case "Office Hours":
					prof.setOfficeHrs(value);
					break;
                  case "Publisher Info":
					  textbook = new Textbook(value);
					course.setTextbookInfo(textbook);
					break;
				case "Title":
					textbook.setTitle(value);
					break;
				case "Credits":
					course.setCredits(Integer.parseInt(value));
					break;
			   case "Assignment":
				   assignment = new Assignment(value);
					course.newAssignment(assignment);
				break;
			   case "Date Assigned":
					assignment.setAssignedDate(value);
					break;
				case "Due Date":
					assignment.setDueDate(value);
					break;
				case "Type of assignment":
					assignment.setType(value);
					break;
				case "Grade":
					assignment.setAssignmentGrade(Double.parseDouble(value));
					break;
				case "Final Grade":
					course.setTotalGrade(Integer.parseInt(value));
			
					break;
				}
				
			}
	 
		} 
	        catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
 }
			

	LogInWindow logIn = new LogInWindow(students);
	
	
	
	
}

}
}

