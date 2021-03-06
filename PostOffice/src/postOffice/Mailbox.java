package postOffice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mailbox {
	
	private List<Letter> contents = new LinkedList<Letter>();
	
	public void addLetter(Letter letter) throws MailboxException {
		if(letter == null){
			throw new MailboxException("You can't send that letter!!");
		}
		synchronized(contents){
			contents.add(letter);
		}
	}
	
	public List<Letter> getAll(){
		List<Letter> result = new LinkedList<Letter>();
		synchronized(contents){
			Collections.addAll(contents);
			contents.clear();
		}
		return result;
	}
}