package com.example.CarPoolApp;

// Extra imports
import java.util.Properties;
import javax.mail.Session;
import java.util.*;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {
	private User user;
	// Credentials of email address used for sending emails
	final String username = "carpool.isu@gmail.com";
	final String password = "IT326CarPool";

	public Email() {
	}
//	public Email(User user) {
//		this.user = user;
//	}

	public void emailReminder(User user) {
		this.user = user;

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Reminder: ISU Carpool");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>You have a carpool today!: </H2>" + "<H3>Thanks for using ISU Carpool!</H3>"
					+ "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("reminder.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Carpool reminder sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailRideCancelled(User user) {
		this.user = user;

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Ride Cancellation: ISU Carpool");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>One of your carpool's have been cancelled: </H2>" + "<H3>Thanks for using ISU Carpool!</H3>"
					+ "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("rideCancel.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println(
					"Carpool cancellation email sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailDriverPassengerRequested(User user) {
		this.user = user;

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Passenger request: ISU Carpool");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>A person has requested to be a passenger of your carpool: </H2>"
					+ "<H3>Thanks for using ISU Carpool!</H3>" + "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("reminder.png");// TODO Need to make a new one!

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Passenger request notification email sent to: \"" + user.getUserID() + "@ilstu.edu"
					+ "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailPassengerCancelled(User user) {
		this.user = user;

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Passenger Cancellation: ISU Carpool");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>A passenger has cancelled a carpool of yours!: </H2>"
					+ "<H3>Thanks for using ISU Carpool!</H3>" + "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("passCancel.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println(
					"Passenger cancellation email sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailPassengerRequest(User user) {
		this.user = user;

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Passenger Request: ISU Carpool");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>A passenger has requested a carpool: </H2>" + "<H3>Thanks for using ISU Carpool!</H3>"
					+ "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("passCancel.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println(
					"Passenger cancellation email sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailSignUp(User new_user) {
		user = new_user;
		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Welcome to ISU Carpool!");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>Thanks for your interest in ISU Carpool! </H2>"
					+ "<H2>Click the link below to complete account activation: </H2>"
					+ "<a href=\"http://localhost:8080/emailconfirmation/\">click here to verify<a/>"
					+ "<H3>Welcome to ISU Carpool!</H3>" + "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("signup.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out
					.println("Carpool signup email sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailreset(User new_user) {
		user = new_user;
		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserID() + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Password reset link!");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Hello " + user.getProfile().getfName() + ",</H1>"
					+ "<H2>Click the link below to reset password: </H2>"
					+ "<a href=\"http://localhost:8080/forgotpassword/\">click here to reset password!<a/>"
					+ "<H3>Welcome to ISU Carpool!</H3>" + "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("signup.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out
					.println("password resest email sent to: \"" + user.getUserID() + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void emailUniqueID(String id, String unique) {

		// Gmail settings
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		// TLS Authentication (security)
		prop.put("mail.smtp.starttls.enable", "true");

		// Check email credentials
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Try: Creating Message and Sending to User object's email address
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(id + "@ilstu.edu"));

			// Header/Subject of Email
			message.setSubject("Unique ID Generated | ISU CARPOOL");

			// This email has 2 parts: the body and the embedded banner image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<img src=\"cid:image\">" + "<H1>Unique ID has been generated for your carpool!</H1>"
					+ "<H1>Your ID is: " + unique + ",</H1>" + "<H2>Your next carpool is on: </H2>"
					+ "<H3>Thanks for using ISU Carpool!</H3>" + "<H3>http://illinoisstate.edu</H3>";
			messageBodyPart.setContent(htmlText, "text/html");

			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("reminder.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Carpool reminder sent to: \"" + id + "@ilstu.edu" + "\" sucessfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
