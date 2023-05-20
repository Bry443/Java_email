import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;


public class SendEmail
{

public static void main(String [] args)
{
	// Edit these accordingly
	String recipient = "recieve@gmail.com";
	String sender = "send@gmail.com";
	// Use your host ip
	String host = "127.0.0.1";

	// Get system properties from local system
	Properties properties = System.getProperties();

	// Start server to send
	properties.setProperty("mail.smtp.host", host);

	// creating session object to get properties
	Session session = Session.getDefaultInstance(properties);

	try
	{
		// MimeMessage object.
		MimeMessage letter = new MimeMessage(session);

		// Set From Field: adding senders email to from field.
		letter.setFrom(new InternetAddress(sender));
		// Set To Field: adding recipient's email to from field.
		letter.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

		// Name subject of the email
		letter.setSubject("Sending email");

		// Set the body of the email to:
		letter.setText("I sent this email!");

		// Send email item to server.
		Transport.send(letter);
		System.out.println("Mail successfully sent!");
	}
	catch (MessagingException mex)
	{
		mex.printStackTrace();
		System.out.println("Mail failed to send. Nooo!)");
	}
}
}
