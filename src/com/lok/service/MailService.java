package com.lok.service;

import java.util.Properties;

import com.lok.model.MailData;

public interface MailService {

	public abstract Properties getProperties();
	
	public abstract boolean sendMail(MailData mailData);
	
}
