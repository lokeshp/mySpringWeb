package com.lok.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.lok.model.MailData;

@Service
public class MailServiceImpl implements MailService {

	@Override
	public Properties getProperties() {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.debug", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.starttls.enable", "true");
		return props;
	}

	@Override
	public boolean sendMail(MailData mailData) {

		final String user = mailData.getFromId() + "@gmail.com";
		final String host = "smtp.gmail.com";
		Properties props = this.getProperties();
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(false);

		try {
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(user));
			InternetAddress[] address = { new InternetAddress(mailData.getToId()) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(mailData.getSubject());
			msg.setContent(mailData.getMailBody(), "text/html");

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, mailData.getPassword());

			System.out.println("Sending mail.....");
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Mail sent!!!");
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return false;
		}
		return true;
	}
}
