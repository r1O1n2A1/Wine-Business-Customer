package fr.afcepf.atod.business.customer.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class JavaMail  {

	private JavaMail() {
	}


	public static void sendMail(String mail){

		final String username = "webwinemania@gmail.com";
		final String password = "Webwinemania2016";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("webwinemania@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail));
			message.setSubject("Bienvenue chez Wine Mania");
			message.setText("Bonjour,"
					+ "\n\n Nous avons le plaisir de vous confirmer votre abonnement à la Newsletter Wine Mania !"
					+ "\n\n Toute l’équipe vous remercie de votre confiance et vous souhaite la bienvenue."
					+ "\n\n Désormais, vous recevrez régulièrement et en avant-première :"
					+ "\n\n > Nos offres exclusives"
					+ "\n\n > Nos informations sur nos nouveaux produits et promotions en cours"
					+ "\n\n > Un accès VIP à nos ventes privées réservées aux abonnés,"
					+ "\n\n + la chance de GAGNER UN MAGNUM chaque semaine !");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
