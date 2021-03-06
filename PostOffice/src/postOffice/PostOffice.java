package postOffice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PostOffice {
	
	private Map<LocalDate, List<MailObject>> archive = new TreeMap<LocalDate, List<MailObject>>();
	private List<MailObject> repository = new ArrayList<MailObject>();
	
	private Set<Postman> staff = new HashSet<Postman>();
	
	void registerPostman(Postman postman){
		staff.add(postman);
	}
	//dobavi
	public void addMailObject(MailObject mail) {
		this.addMailObject(Arrays.asList(mail));
	}
	
	public int getNumberOfMailObjects(){
		return repository.size();
	}
	
	//dobavi v arhiv i repo
	public void addMailObject(List<? extends MailObject> mailobjects) {
		if(mailobjects != null){
			synchronized(repository){
				repository.addAll(mailobjects);
			}
			synchronized(archive){
				if(!archive.containsKey(LocalDate.now())){
					archive.put(LocalDate.now(), new LinkedList<MailObject>());
				}else{
					archive.get(LocalDate.now()).addAll(mailobjects);
				}
			}
		}
	}
	
	//vzemane na poshtata
	public List<MailObject> takeMails(int number){
		synchronized(repository){
			if(number > repository.size()){
				number = repository.size();
			}
			List<MailObject> result = repository.subList(0, number);
			repository.removeAll(result);
			return result;
		}
	}
	
	class PostOfficeQueryManager{
		
		private static final double PERCENT = 100.00;

		List<MailObject> getAllMailObjectsByDate(LocalDate date) throws MailboxException{
			if(archive.containsKey(date)){
				return archive.get(date);
			}
			throw new MailboxException("There are no mails on that date. Good day!");
		}
		
		public double getPercentOfLetters(){
			List<MailObject> lettersForToday = archive.get(LocalDate.now());
			int numberOfLetters = 0;
			for(MailObject mo : lettersForToday){
				if(mo instanceof Letter){
					numberOfLetters++;
				}
			}
			return ((double)numberOfLetters / (double)lettersForToday.size()) * PERCENT;
		}
		
		public double getPercentOfProcessedFragileParcels(){
			int numberOfPFP = 0;
			int total = 0;
			for(LocalDate date : archive.keySet()){
				for(MailObject mo : archive.get(date)){
					if(mo instanceof Parcel){ 
						if(((Parcel)mo).isFragile() && !repository.contains(mo)){
							numberOfPFP++;
						}
						total++;
					}
				}
			}
			return ((double)numberOfPFP / (double)total) * PERCENT;
		}
		
		public void printIfnoPostman(){
			ArrayList<Postman> list = new ArrayList<Postman>(staff);
			Collections.sort(list, (p1,p2) -> p1.getProcessedMailObjects() - p2.getProcessedMailObjects());
			for(Postman p : list){
				System.out.println(p.getFirstName() + " processed " + p.getProcessedMailObjects() + " for today.");
			}
		}
	}
}