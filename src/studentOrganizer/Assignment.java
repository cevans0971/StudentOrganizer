package studentOrganizer;
/**
 * This class creates an assignment that has a name, a date that it is assigned, the date its due, the percent of the grade its worth, the grade the assignment gets, and the type of assignment it is
 */

public class Assignment {
	private String assignmentName;
	private String assignedDate;
	private String dueDate;
	private int percentOfGrade;
	private double assignmentGrade;
	private String type;
	public Assignment(String assignmentName, String assignedDate, String dueDate, String type)
	{
		this.assignmentName = assignmentName;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.type = type;
		if(this.type == "homework")
			this.percentOfGrade = 40;
		if(this.type == "exam")
			this.percentOfGrade = 50;
		if(this.type == "in class")
			this.percentOfGrade = 10;
	}
	public Assignment(String assignmentName, String assignedDate,  String dueDate, double assignmentGrade, String type)
	{
		this.assignmentName = assignmentName;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.assignmentGrade = assignmentGrade;
		this.type = type;
		if(this.type == "homework")
			this.percentOfGrade = 40;
		if(this.type == "exam")
			this.percentOfGrade = 50;
		if(this.type == "in class")
			this.percentOfGrade = 10;
	}
	/**
	 * 
	 * @param value is the string that is set as the name of the assignment
	 */

	public Assignment(String value) {
		assignmentName = value;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return the date the assignment was given
	 */

	public String getAssignedDate() {
		return assignedDate;
	}
	/**
	 * 
	 * @param assignedDate becomes the date that the assignment is assigned
     **/
	public void setAssignedDate(String assignedDate) {
		if( assignedDate !=null)
		   this.assignedDate = assignedDate;
	}
	/**
	 * 
	 * @return the date the assignment is due
	 */

	public String getDueDate() {
		return dueDate;
	}
	/**
	 * 
	 * @param dueDate becomes the date that the assignment is due
	 */

	public void setDueDate(String dueDate) {
		if (dueDate !=null)
		this.dueDate = dueDate;
	}
	/**
	 * 
	 * @return how much the assignment is worth
	 */

	public int getPercentOfGrade() {
		return percentOfGrade;
	}
 
	/**
	 * 
	 * @return the type of assignment
	 */

	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param type is the type of the assignment
	 */
	public void setType(String type) {
		if(type !=null)
		this.type = type;
		if(type == "homework")
			this.percentOfGrade = 40;
		if(type == "exam")
			this.percentOfGrade = 50;
		if(type == "in class")
			this.percentOfGrade = 10;
	}
	/**
	 * 
	 * @return the name of the assignment
	 */


	public String getAssignmentName() {
		return assignmentName;
	}
	/**
	 * 
	 * @param assignmentName is the name of the assignment
	 */

	public void setAssignmentName(String assignmentName) {
		if(assignmentName !=null)
		this.assignmentName = assignmentName;
	}
	/**
	 * 
	 * @return the grade the assignment gets
	 */

	public double getAssignmentGrade() {
		return assignmentGrade;
	}
	/**
	 * 
	 * @param assignmentGrade is the grade the assignment gets 
	 */

	public void setAssignmentGrade(double assignmentGrade) {
		if(assignmentGrade >= 0.0)
		this.assignmentGrade = assignmentGrade;
	}
	/**
	 * 
	 * @return a string that contains all of the information about the assignment
	 */

	public String print()
	{
		String string = ("\nAssignment:" +assignmentName);
		string+=("\nDate Assigned:" +assignedDate);
		string+=("\nDue Date:" +dueDate);
		string+=("\nType of assignment:" +type);
		string+=("\nGrade:" + assignmentGrade);
	       return string;
	}
	
}
