package studentOrganizer;
/**
 * This class represents a professor that has a name, an email address, a phone number, an office location, and a string detailing their office hours
 */

public class Professor {
	private String name;
	private String email;
	private String phone;
	private String office;
	private String officeHrs;
	public Professor(String name, String email, String phone, String office, String officeHrs)
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.office = office;
		this.officeHrs = officeHrs;
	}
	public Professor(String value) {
		name = value;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return the name of the professor
	 */

	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name is the professors name
	 */

	public void setName(String name) {
		if(name!=null)
		this.name = name;
	}
	/**
	 * 
	 * @return the professor's phone number
	 */

	public String getPhone() {
		return phone;
	}
	/**
	 * 
	 * @param phone is the professor's phone number
	 */

	public void setPhone(String phone) {
		if(phone!=null)
		this.phone = phone;
	}
	/**
	 * 
	 * @return the location of the professor's office
	 */

	public String getOffice() {
		return office;
	}
	/**
	 * 
	 * @param office is the location of the professor's office
	 */

	public void setOffice(String office) {
		if(office!=null)
		this.office = office;
	}
	/**
	 * 
	 * @return a string detailing the professor's office hours
	 */

	public String getOfficeHrs() {
		return officeHrs;
	}
	/**
	 * 
	 * @param officeHrs details the professor's office hours
	 */

	public void setOfficeHrs(String officeHrs) {
		if(officeHrs!=null)
		this.officeHrs = officeHrs;
	}
	/**
	 * 
	 * @return the professors email address
	 */

	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email is the professors email address
	 */

	public void setEmail(String email) {
		if(email!=null)
		this.email = email;
	}
	/**
	 * 
	 * @return a string with all of the information about the professor
	 */

	public String print() {
		String string =("\nProfessor:" +name);
		string+=("\nE-Mail:"+email);
		string+=("\nPhone number:" +phone);
		string+=("\nOffice:"+ office);
		string+=("\nOffice Hours:" + officeHrs);
		return string;
	}
 
}
