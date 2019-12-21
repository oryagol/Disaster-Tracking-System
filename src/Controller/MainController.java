package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;

import Model.Finder;
import Model.LostPerson;
import Model.Searcher;
import Model.SysData;

public class MainController {

	private ArrayList<Searcher> searchers = new ArrayList<>();
	

	// a method that do a loop on the imported list and checks if there is a match in the missing list and counts matches
	public int syncLists() {
		for(LostPerson lp : SysData.getInstance().getMissingSearched()) {
			lp.setMatchPercent(0.0);
		}
		for(LostPerson found : SysData.getInstance().getImportedmissing()) {
			findMatch(found);
			if(found.getMatchPercent() > 100.0)
				found.setMatchPercent(100.0);
			if(found.getFoundedBy() != null)
				sendEmail(found.getFoundedBy());
				if(searchers.size() == 1) {
					found.setSearchBy(searchers.get(0));
					sendEmail(searchers.get(0));
				}
				else if(searchers.size() > 1) {
					for(Searcher s : searchers) {
						sendEmail(s);
					}
				}
		}
		return searchers.size();
	}
	// a method to find a match of a person from the missing list to a person from the found list
	public void findMatch(LostPerson found) {
		found.setMatchPercent(0.0);
		matchById(found);
		matchByName(found);
		//matchByVisual(found);
	}
	/** unsolved feature, maybe in next version.
	public void matchByVisual(LostPerson found) {
		for(LostPerson lp : SysData.getInstance().getMissingSearched()) {
			if(lp.getColor().equals(found.getColor()) && (found.getHeight()-5 <= lp.getHeight()) &&
					(lp.getHeight()	<= found.getHeight()+5) && (found.getWeight()-5 <= lp.getWeight()) &&
					(lp.getWeight() <= found.getWeight()+5)) {
				lp.setDateFound(Calendar.getInstance());
				lp.setFoundedBy(found.getFoundedBy());
				lp.setMatchPercent(lp.getMatchPercent()+30);
				found.setMatchPercent(found.getMatchPercent()+30);
				searchers.add(lp.getSearchBy());
			}
		}
	}
	*/

	public void matchByName(LostPerson found) {
		if(SysData.getInstance().getFindByName().get(found.getName()) != null)
		{
			System.out.println(found);
			SysData.getInstance().getFindByName().get(found.getName()).setDateFound(Calendar.getInstance());
			SysData.getInstance().getFindByName().get(found.getName()).setFoundedBy(found.getFoundedBy());
			SysData.getInstance().getFindByName().get(found.getName()).setMatchPercent(SysData.getInstance().getFindByName()
					.get(found.getName()).getMatchPercent()+50);
			found.setMatchPercent(found.getMatchPercent()+50);
			found.setSearchBy(SysData.getInstance().getFindByName().get(found.getName()).getSearchBy());
			searchers.add(SysData.getInstance().getFindByName().get(found.getName()).getSearchBy());
		}
	}

	public void matchById(LostPerson found) {
		if(SysData.getInstance().getFindById().get(found.getId()) != null)
		{
			SysData.getInstance().getFindById().get(found.getId()).setDateFound(Calendar.getInstance());
			SysData.getInstance().getFindById().get(found.getId()).setFoundedBy(found.getFoundedBy());
			SysData.getInstance().getFindById().get(found.getId()).setMatchPercent(SysData.getInstance().getFindById()
					.get(found.getId()).getMatchPercent()+50);
			found.setMatchPercent(found.getMatchPercent()+50);
			found.setSearchBy(SysData.getInstance().getFindById().get(found.getId()).getSearchBy());
			searchers.add(SysData.getInstance().getFindById().get(found.getId()).getSearchBy());
		}
	}
	// a method that inform the finder/searcher that we found a match
	public boolean sendEmail(Object obj) {
		Searcher s;
		Finder f;
		if(obj instanceof Searcher) {
			s = (Searcher) obj;
			// Recipient's email ID needs to be mentioned.
			String to = s.getEmail();

			// Sender's email ID needs to be mentioned
			String from = "flipcoinappteam@gmail.com";

			// Get system properties
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// Get the default Session object.

			//Session session = Session.getDefaultInstance(props);

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("flipcoinappteam@gmail.com","MPADproject");
				}
			});

			try{
				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				System.out.println(s);
				// Set Subject: header field
				message.setSubject("We Maybe Found A Match Of The Person You Searched!");
				System.out.println();
				String mes = "Dear "+s.getName()+", We Are Glad To Tell You That We Have Found A Match Of " +s.getSearchPerson().getMatchPercent()
						+"% To Your Missing Person." + " He Is Located At "+s.getSearchPerson().getFoundedBy().getLocation() +" You Can" +
						" Contact His Finder "+ s.getSearchPerson().getFoundedBy().getName() + " By His Phone Number " +
						s.getSearchPerson().getFoundedBy().getPhone() + ".";
				mes+= "\n\nYours Dearly, MPAD System For Finding Missing People.";
				// Now set the actual message
				message.setText(mes);

				Transport.send(message);
				System.out.println("Sent message successfully....");

			}catch (MessagingException mex) {
				mex.printStackTrace();
			}
			catch (NoClassDefFoundError e1) {
				e1.printStackTrace();
			}
			return true;
		}
		else if(obj instanceof Finder) {
			f = (Finder) obj;
			// Recipient's email ID needs to be mentioned.
			String to = f.getEmail();

			// Sender's email ID needs to be mentioned
			String from = "flipcoinappteam@gmail.com";

			// Get system properties
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// Get the default Session object.

			//Session session = Session.getDefaultInstance(props);

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("flipcoinappteam@gmail.com","MPADproject");
				}
			});

			try{
				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				System.out.println(f);
				// Set Subject: header field
				message.setSubject("We Maybe Found A Match Of The Person You Have Found!");
				String mesManySearch = "Dear "+f.getName()+", We Are Glad To Tell You That We Have Found A Match Of " +
						f.getFoundPerson().getMatchPercent()
						+"% To The Missing Person You Have Found, " + "Check The Details In The App.";
				String mes;
				if(f.getFoundPerson().getSearchBy() == null)
					mes = mesManySearch;
				else
					mes = "Dear "+f.getName()+", We Are Glad To Tell You That We Have Found A Match Of " +f.getFoundPerson().getMatchPercent()
					+"% To The Missing Person You Have Found And The Name Of His Searcher Is "+f.getFoundPerson().getSearchBy().getName()+
					". You Can Contact Him By His Phone " + f.getFoundPerson().getSearchBy().getPhone()+".";
				mes+= "\n\nYours Dearly, MPAD System For Finding Missing People.";
				// Now set the actual message
				message.setText(mes);

				Transport.send(message);
				System.out.println("Sent message successfully....");

			}catch (MessagingException mex) {
				mex.printStackTrace();
			}
			catch (NoClassDefFoundError e1) {
				e1.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
