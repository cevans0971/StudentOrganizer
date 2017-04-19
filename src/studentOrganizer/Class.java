package studentOrganizer;


import java.util.ArrayList;
/**
 * This class represents a course that has a name, a list of assignments, a total grade, a textbook, a professor, a set number of credits, a number of exams, a number of homework assignments, a number of in class assignments, a total of the exam grades added up, a total of the homework grades added up, and a total of in class grades added up
 * @author cevans0971
 *
 */


public class Class {
private String courseName;
private ArrayList<Assignment>  assignmentGrades = new ArrayList<Assignment>();//keeps a list of all the assignments in the course, with the name of the assignment and the grade given
private int totalGrade;// gives the total grade of the course
private Textbook textbookInfo;// gives all the information about the textbook used in class
private Professor professorInfo;//gives all the important information about the professor teaching the course
private int credits;//how many credits the course is worth
private int numberOfExams;//keeps track of the number of exams in the class
private int numberOfHW;//keeps track of the number of hw assignments in the class
private int numberOfInClass;//keeps track of the number of in class assignemnts in the class
private int totalExamGrades;//keeps track of the exam grades added up
private int totalInClass;//keeps track of the in class assignment grades added up
private int totalHw;//keeps track of the homework assignment grades added up
 public Class(String courseName,ArrayList<Assignment> grades, Textbook textbookInfo, Professor professorInfo, int credits )
{
	this.courseName = courseName;
	this.assignmentGrades = grades;
 
	this.textbookInfo = textbookInfo;
	this.professorInfo = professorInfo;
	this.setCredits(credits);
	totalGrade=0;
	numberOfHW = 0;
	numberOfInClass = 0;
	numberOfExams = 0;
	totalExamGrades = 0;
	totalInClass = 0;
	totalHw = 0;
}
public Class(String value) {
	courseName = value;
	totalGrade=0;
	numberOfHW = 0;
	numberOfInClass = 0;
	numberOfExams = 0;
	totalExamGrades = 0;
	totalInClass = 0;
	totalHw = 0;
	
	// TODO Auto-generated constructor stub
}
public Class(String text, Textbook text2, Professor prof, int i) {
	courseName = text;
	textbookInfo = text2;
	professorInfo = prof;
	credits = i;
	totalGrade=0;
	numberOfHW = 0;
	numberOfInClass = 0;
	numberOfExams = 0;
	totalExamGrades = 0;
	totalInClass = 0;
	totalHw = 0;
	// TODO Auto-generated constructor stub
}
/**
 * 
 * @return the name of the course
 */

public String getCourseName()
{
	return courseName;
}
/**
 * 
 * @param courseName is the name of the course
 */

public void setCourseName(String courseName)
{
	if(courseName!=null)
		this.courseName = courseName;
}
/**
 * 
 * @return the list of assignments for the course
 */

public ArrayList<Assignment> getAssignmentGrades() {
	return assignmentGrades;
}
/**
 * 
 * @param assignmentGrades is the list of assignments for the course
 */

public void setAssignmentGrades(ArrayList<Assignment> assignmentGrades) {
	this.assignmentGrades = assignmentGrades;
}
/**
 * 
 * @return the total grade for the course
 */

public int calculateTotalGrade() {
	if((numberOfExams != 0) && (numberOfInClass!=0) && (numberOfHW !=0))
	{
	totalGrade = (int) (((totalExamGrades/numberOfExams)*.50) + ((totalInClass/numberOfInClass)* .1) + ((totalHw/numberOfHW)*.4)*100);
	}
	else if((numberOfExams != 0) && (numberOfInClass!=0) && (numberOfHW == 0))
	{
	totalGrade = (int) ((((totalExamGrades/numberOfExams)*.50) + ((totalInClass/numberOfInClass)*.1)/.6)*100);
	}
	else if((numberOfExams != 0) && (numberOfHW !=0) && (numberOfInClass == 0))
	{
	totalGrade = (int) ((((totalExamGrades/numberOfExams)*.50) + ((totalHw/numberOfHW)*.4)/.9)*100);
	}
	else if((numberOfExams != 0) && (numberOfInClass ==0) && (numberOfHW ==0))
	{
	totalGrade = (int) ((totalExamGrades/numberOfExams)*100);
	}
	else if((numberOfHW != 0) && (numberOfInClass!=0) && (numberOfExams == 0))
	{
	totalGrade = (int) ((((totalHw/numberOfHW)*.40) + ((totalInClass/numberOfInClass)*.1)/.5)*100);
	}
	else if((numberOfExams == 0) && (numberOfInClass ==0) && (numberOfHW !=0))
	{
	totalGrade = (int) ((totalExamGrades/numberOfHW)*100);
	}
	else if((numberOfExams == 0) && (numberOfInClass !=0) && (numberOfHW ==0))
	{
	totalGrade = (int) ((totalInClass/numberOfInClass)*100);
	}
	else totalGrade = 0;

 
    return totalGrade; 
}
/**
 * 
 * @return the textbook being used for the course
 */

public Textbook getTextbookInfo() {
	return textbookInfo;
}
/**
 * 
 * @param textbookInfo is the textbook for the course
 */

public void setTextbookInfo(Textbook textbookInfo) {
	if(textbookInfo !=null)
	this.textbookInfo = textbookInfo;
}
/**
 * 
 * @return the professor teaching the course
 */

public Professor getProfessorInfo() {
	return professorInfo;
}
/**
 * 
 * @param professorInfo is the professor teaching the course
 */

public void setProfessorInfo(Professor professorInfo) {
	if(professorInfo !=null)
	this.professorInfo = professorInfo;
}
/**
 * 
 * @return the number of credits the course is worth
 */

public int getCredits() {
	return credits;
}
/**
 * 
 * @param credits is the number of credits the course is worth
 */

public void setCredits(int credits) {
	if(credits >= 0)
	this.credits = credits;
}
/**
 * 
 * @param newwAssignment is a new assignment that is added to the course
 */

public void newAssignment(Assignment newwAssignment)
 
{
	 if(newwAssignment != null)
{
	assignmentGrades.add(newwAssignment);
	//adds the name and grade of the assignment to the list keeping track of the course's assignments
	if(newwAssignment.getType() == "homework")
	{
		numberOfHW += 1;
	totalHw += newwAssignment.getAssignmentGrade();
	}
	//if the assignment is a homework assignment, it increases the number of homework assignments by 1, and the total homework grades by the grade of the assignment
	if(newwAssignment.getType() == "exam")
	{
		numberOfExams += 1;
	totalExamGrades += newwAssignment.getAssignmentGrade();
	}
	//if the assignment is an exam, it increases the number of exams by 1. and the total exam grades by the grade for the exam
    if(newwAssignment.getType() == "in class")
    {
    	numberOfInClass += 1;
        totalInClass += newwAssignment.getAssignmentGrade();
        //if the assignment is an in class assignment, it increases the number of in class assignments by 1 and the total in class assignment grades by the grade of the assignment/
    } 
    }
}
/**
 * 
 * @return the total of the exam grades for the course added up
 */

public int getTotalExamGrades()
{
	return totalExamGrades;
}
/**
 * 
 * @return the total of the homework grades added up
 */

public int getTotalHw()
{
	return totalHw;
}
/**
 * @return the total of in class grades added up*  */


public int getTotalInClass()
{
	return totalInClass;
}
/**
 * 
 * @return the number of in class assignments for the course
 */

public int getNumberofInClass()
{
	return numberOfInClass;
}
/**
 * 
 * @return the number of homework assignments for the course
 */

public int getNumberOfHw()
{
	return numberOfHW;
}
/**
 * 
 * @return the number of exams for the course
 */

public int getNumberOfExams()
{
	return numberOfExams;
}
/**
 * 
 * @return the final grade for the course
 */

public int getFinalGrade()
{
	return totalGrade;
}
/**
 * 
 * @return a string that gives all of the information about the course 
 */

public String print() {
	String string = ("\nThe class name is:"+ courseName);
	string+=professorInfo.print();
	string+=textbookInfo.print();
	string+=("\nCredits:" +credits);
    for (int i=0; i<assignmentGrades.size();i++)
	{
	 string+=assignmentGrades.get(i).print();
		
	}
	  string+=("\nFinal Grade:" +totalGrade);
	return string;
	// TODO Auto-generated method stub
	
}
/**
 * 
 * @param grade is the total grade for the course
 */

public void setTotalGrade(int grade) {
	// TODO Auto-generated method stub
	totalGrade = grade;
}
}
