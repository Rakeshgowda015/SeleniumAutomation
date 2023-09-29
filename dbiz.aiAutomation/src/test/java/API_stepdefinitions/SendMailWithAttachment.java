package api_stepdefinitions;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.*;
public class SendMailWithAttachment {

	public static void main(String[] args) throws IOException {
		//authentication info
				final String username = "rakesh.dbizai@gmail.com";
				final String password = "Dell#549";
				String fromEmail = "rakesh.dbizai@gmail.com";
				String toEmail = "rakegowda015@gmail.com";
				
				Properties properties = new Properties();
		        properties.put("mail.smtp.auth", true);
		        properties.put("mail.smtp.starttls.enable", true);
		        properties.put("mail.smtp.port", "587");
		      

		    

				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});
				//Start our mail message
				MimeMessage msg = new MimeMessage(session);
				try {
					msg.setFrom(new InternetAddress(fromEmail));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
					msg.setSubject("Subject Line");
					
					Multipart emailContent = new MimeMultipart();
					
					//Text body part
					MimeBodyPart textBodyPart = new MimeBodyPart();
					textBodyPart.setText("My multipart text");
					
					//Attachment body part.
					MimeBodyPart pdfAttachment = new MimeBodyPart();
					pdfAttachment.attachFile("C:\\dbizrepo\\dbiz.aiAutomation\\log4j.log");
					
					//Attach body parts
					emailContent.addBodyPart(textBodyPart);
					emailContent.addBodyPart(pdfAttachment);
					
					//Attach multipart to message
					msg.setContent(emailContent);
					
					Transport.send(msg);
					System.out.println("Sent message");
				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
