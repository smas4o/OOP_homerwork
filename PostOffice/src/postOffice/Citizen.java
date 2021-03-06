package postOffice;

import java.util.ArrayList;
import java.util.List;

public class Citizen implements Runnable{
	
	private static final int FIRST_MAILBOX = 1;
	private static final int MAX_MAILBOXES = 25;
	private static final int NUMBER_OF_ITEMS = 30;
	private String firstName;
	private String lastName;
	private String address;
	private static PostOffice postOffice;
	
	private static List<Mailbox> mailboxes = new ArrayList<Mailbox>();

	static{
		for(int mailbox = FIRST_MAILBOX; mailbox <= MAX_MAILBOXES; mailbox++){
			mailboxes.add(new Mailbox());
		}
		postOffice = new PostOffice();
	}

	public Citizen(String firstName, String lastName, String address) {
		this.setFirstName(firstName);
		this.setAddress(address);
		this.setLastName(lastName);
	}

	@Override
	public String toString() {
		return "Citizen [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

	public static List<Mailbox> getMailboxes() {
		return mailboxes;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static PostOffice getPostOffice() {
		return postOffice;
	}

	@Override
	public void run() {
		for(int numberOfLetters = 1; numberOfLetters < NUMBER_OF_ITEMS; numberOfLetters++){
			try {
				System.out.println("Sending a mail " + numberOfLetters);
				sendRandomMailObject();
				System.out.println("Sended.");
			} catch (MailboxException e) {
				e.printStackTrace();
			}
		}
	}

	private MailObject sendRandomMailObject() throws MailboxException {
		MailObject result;
		if(Math.random() > 0.5){
			result = new Letter(this, new Citizen("Pesho", "Peshev", "kv.Levski-G blok 9 vh.G"));
			int randomIndex = (int) (Math.random() * this.mailboxes.size());
			System.out.println("I will put it in here: " + randomIndex);
			Mailbox mailbox = this.mailboxes.get(randomIndex);
			if(Math.random() > 0.5){
				mailbox.addLetter((Letter) result);
				System.out.println("I will put it in the mailbox.");
			}else{
				postOffice.addMailObject(result);
				System.out.println("I will put it in the postoffice.");
			}
		}else{
			System.out.println("I will put a parcel in the postoffice.");
			result = new Parcel(this, new Citizen("Pesho", "Peshev", "kv.Levski-G blok 9 vh.G"), generateRandomSize(), 
					generateRandomSize(),  generateRandomSize(), Math.random() > 0.5);
			postOffice.addMailObject(result);
		}
		return result;
	}

	private int generateRandomSize() {
		return (int)Math.random() * 100;
	}
	
	
	
}