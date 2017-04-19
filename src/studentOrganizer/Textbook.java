package studentOrganizer;
/**
 *This class represents a textbook with a title and a string detailing the textbook's publishing info
 */

public class Textbook {
private String publisherInfo;
private String title;
public Textbook(String newPublisherInfo, String newTitle)
{
	publisherInfo = newPublisherInfo;
	title = newTitle;
}
public Textbook(String value) {
	publisherInfo = value;
	// TODO Auto-generated constructor stub
}
/**
 * 
 * @return the textbook's title
 */

public String getTitle() {
	return title;
}
/**
 * 
 * @param title is the title of the textbook
 */

public void setTitle(String title) {
	if(title!=null)
	this.title = title;
}
/**
 * 
 * @return the publishing info for the textbook
 */

public String getPublisherInfo() {
	return publisherInfo;
}
/**
 * 
 * @param publisherInfo details the publishing info for the textbook
 */

public void setPublisherInfo(String publisherInfo) {
	if(publisherInfo!=null)
	this.publisherInfo = publisherInfo;
}/**
 * 
 * @return a string giving all the information about the textbook
 */

public String print() {
	String string = "";
			string+=("\nPublisher Info:" +publisherInfo);
           string += ("\nTitle:"+ title);
           return string;
	// TODO Auto-generated method stub
	
}
 
}
