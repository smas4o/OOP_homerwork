package postOffice;

import java.util.List;

public class Postman extends Citizen {

	
	protected static final int MINIMUM_OF_LETTER = 50;
	private int processedMailObjects = 1;
	
	public Postman(String firstName, String lastName, String address) {
		super(firstName, lastName, address);
		getPostOffice().registerPostman(this);
	}
	
	@Override
	public void run(){
		while(true){
			while(getPostOffice().getNumberOfMailObjects() <= MINIMUM_OF_LETTER){
				synchronized(getPostOffice()){
					try {
						System.out.println("Waiting for mails to be collected");
						getPostOffice().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
			
			System.out.println("I am taking letters");
			
			int numberOfPostmen = Thread.currentThread().getThreadGroup().activeCount();
			int numberOfMailsToGet = getPostOffice().getNumberOfMailObjects() / numberOfPostmen;
			
			try {
				List<MailObject> mails = getPostOffice().takeMails(numberOfMailsToGet);
				for(MailObject mo : mails){
					Thread.sleep((long) mo.getTimeToDeliver());
					System.out.println("I deliver that mail: " + mo);
				}
				this.processedMailObjects += mails.size();
				synchronized(getPostOffice()){
					getPostOffice().notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public int getProcessedMailObjects() {
		return processedMailObjects;
	}

}
