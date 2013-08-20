package com.lok.model;

import org.springframework.stereotype.Component;

@Component
public class MailData {
	
	public String fromId;
	public String password;
	public String toId;
	public String subject;
	public String mailBody;
	
	public String getFromId() {
		return fromId;
	}
	
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToId() {
		return toId;
	}
	
	public void setToId(String toId) {
		this.toId = toId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	
}
