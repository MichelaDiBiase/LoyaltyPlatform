package it.unicam.cs.ids.shoppingsite.mailbox;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {

	private List<Mail> listMail;

	public Mailbox (){
		this.listMail=new ArrayList<>();

	}

	public void sendAdvertising(String recipient,String textAdvertising) {
		Mail writeMail=new Mail(recipient,textAdvertising);

	}

	public void sendEmail(String recipient,String text) {
		Mail writeMail=new Mail(recipient,text);
	}

}