/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Youtube.com. 2021. How To Send Email Using Java + Netbeans. [online] Available at: <https://www.youtube.com/watch?v=6waaVUo7Zzk>.
*/
package AFS.ServiceLayer;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ransa
 */
public class AFSEmailService {
    
    private String email;
    private String upassword;
    private String recEmail;
    private String recSubject;
    private String msg;

    public AFSEmailService(String recEmail, String recSubject, String msg) {
        email = "malindurnawarathne@gmail.com";
        upassword = "indura1234";
        this.recEmail = recEmail;
        this.recSubject = recSubject;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getRecEmail() {
        return recEmail;
    }

    public String getRecSubject() {
        return recSubject;
    }
    
    public String sendMail(){

	String Msg;
    
        final String username = email;
        final String password = upassword;

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(recEmail));//ur email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recEmail));//u will send to
            message.setSubject(recSubject);
            message.setText(msg);
            Transport.send(message);
            Msg="true";
    	    return Msg;

        } catch (MessagingException e) {
            return e.toString();
        }
    }
}
