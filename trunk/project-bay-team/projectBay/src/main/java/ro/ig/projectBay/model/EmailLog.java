package ro.ig.projectBay.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity(name = "email_log")
public class EmailLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date dateSent;

	private Date update;

	@OneToMany(mappedBy = "emailReceived")
	private User userTo;
	
	@OneToMany(mappedBy = "emailSent")
	private User userFrom;
	
	private String subject;
	
	@Lob
	private String message;
	
	@Lob
	private byte[] attachment;
}
