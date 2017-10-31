package com.zensar.learnappservices.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

@Component
public class MailSender {
	static final private String host="javamail.cisco.com";
	static private Properties properties;
	static private Session session;	

	static {
		properties=System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		session=Session.getDefaultInstance(properties);
	}
	public boolean sendMail(String templateName,Map<String, Object> input,String subject,List<String> toList) {
		try {
			StringBuilder emailContent = new StringBuilder();
			Configuration cfg = new Configuration(new Version(2, 3, 20));
			cfg.setClassForTemplateLoading(MailSender.class, "/com/zensar/learnappservices/templates");
			cfg.setIncompatibleImprovements(new Version(2, 3, 20));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setLocale(Locale.US);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template template= cfg.getTemplate(templateName);
			Writer out = new StringWriter();
			template.process(input, out);
			String output = out.toString();
			emailContent.append(output);
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress("vanaik@cisco.com"));
			InternetAddress[] addressTo = null;
			if( toList!=null ) {
				addressTo =new InternetAddress[toList.size()];
				for (int i=0; i<toList.size(); i++) {
					String userId = (String) toList.get(i);
					addressTo[i] = new InternetAddress(userId+"@cisco.com");
				}
			}
			else{
				addressTo=new InternetAddress[1];
				addressTo[0]=new InternetAddress("vanaik");
			}
			message.addRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(subject);
			message.setContent(emailContent.toString(),"text/html");
			Transport.send(message);
			System.out.println("mail sent "+templateName+" subject "+ subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
