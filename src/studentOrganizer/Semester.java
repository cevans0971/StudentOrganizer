package studentOrganizer;

import java.util.ArrayList;
/**
 * This class represents a semester with a number of classes being taken by the particular student, a list of the courses being taken,a grade for the semester. and a string showing when the semester is taking place
 * @author cevans0971
 *
 */
public class Semester {
private int numberOfClasses;
private ArrayList<Class>  courseList = new ArrayList<Class>();
private double semsterGrade;
private String semesterTime;
public Semester(ArrayList<Class> Courses,String time)
{
	semesterTime = time;
	courseList = Courses;
	numberOfClasses = Courses.size();
}
public Semester(String string) {
	semesterTime = string;
	// TODO Auto-generated constructor stub
}
/**
 * 
 * @return the number of courses taken during the semester
 */
public int getNumberOfClasses() {
	return numberOfClasses;
	//number of elements in arraylist is the same as the number of classes in semester
}
/**
 * 
 * @param numberOfClasses is the number of classes being taken during the semester 
 */
 
public void setNumberOfClasses(int numberOfClasses) {
	if(numberOfClasses > 0)
	this.numberOfClasses = numberOfClasses;
}
/**
 * 
 * @return the list of courses being taken during the semester
 */
public ArrayList<Class> getCourses()
{
	return courseList;
}

/**
 * 
 * @param course is a new course that is being taken during the semester
 */
public void addClass(Class course)
{
 
	 courseList.add(course);//adds a new class to the semester 
	  numberOfClasses++;
	 
	 
}
/**
 * 
 * @param course is a course being taken during the semester that is being removed 
 */
public void removeCourse(Class course)
{
	for(int i=0;i<this.getCourses().size();i++)
	{
		if (course == this.getCourses().get(i))
				{
			         courseList.remove(course);
			     numberOfClasses--;
				}
	}
	
}
/**
 * 
 * @return the final gpa for the semester 
 */
public double getSemesterGrade()
{
	double GradePointEquivalent = 0.0;
	double total = 0.0;
	double totalCredits = 0.0;
	for (int i = 0; i < courseList.size(); i++ )//goes through each class of the semester
	{
		if (courseList.get(i).getFinalGrade() != 0)
		{
		if(courseList.get(i).calculateTotalGrade() > 93)//if grade is A+
			GradePointEquivalent = 4.0;
		if((courseList.get(i).calculateTotalGrade() > 89) && (courseList.get(i).calculateTotalGrade() < 94))//if grade is a A-
			GradePointEquivalent = 3.67;
		if ((courseList.get(i).calculateTotalGrade() > 86) && (courseList.get(i).calculateTotalGrade() < 90))//if grade is B+
			GradePointEquivalent = 3.33;
		if ((courseList.get(i).calculateTotalGrade() > 83) && (courseList.get(i).calculateTotalGrade() < 87))//if grade is B
		   GradePointEquivalent = 3.00;
		if ((courseList.get(i).calculateTotalGrade() > 79) && (courseList.get(i).calculateTotalGrade() < 84))//if grade is B-
		   GradePointEquivalent = 2.67;
		if ((courseList.get(i).calculateTotalGrade() > 76) && (courseList.get(i).calculateTotalGrade() < 80))//if grade is C+
			GradePointEquivalent = 2.33;
		if ((courseList.get(i).calculateTotalGrade() > 69) && (courseList.get(i).calculateTotalGrade() < 77))//if grade is C
		    GradePointEquivalent = 2.00;
		if ((courseList.get(i).calculateTotalGrade() > 59) && (courseList.get(i).calculateTotalGrade() < 70))//if grade is D
			GradePointEquivalent = 1.00;
		if ((courseList.get(i).calculateTotalGrade() < 60))//if grade is F
				GradePointEquivalent = 0.00;
		total += GradePointEquivalent;//adds up the grade point equivalents for each class
		totalCredits += courseList.get(i).getCredits();//adds up the credits of each class of the semester
	}
	}
		semsterGrade =  (total/totalCredits);//formula for calculating grade point average. converts to int since the grade must be a whole number
		return semsterGrade; 
	}
/**
 * 
 * @param grade is the final gpa for the semester
 */
public void setSemesterGrade(double grade)
{
	this.semsterGrade = grade;
}
/**
 * 
 * @return the string that gives all of the information for the semester
 */
public String  print()
{
	String string = ("\nSemester:"+ semesterTime);
	string+=("\nFinal Average:" + semsterGrade);
	for(int i=0; i<courseList.size(); i++)
	{
		string+=courseList.get(i).print();
	}
	return string;
}
/**
 * 
 * @return when the semester is taking place
 */
public String getSemesterTime() {
	return semesterTime;
}
/**
 * 
 * @param semesterTime is when the semester is taking place 
 */
public void setSemesterTime(String semesterTime) {
	this.semesterTime = semesterTime;
}

}

 
