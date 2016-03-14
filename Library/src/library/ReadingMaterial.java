package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ReadingMaterial {

	private static int currentID = 1;
	private int id;
	private String name;
	private String publisher;
	private List<History> history;
	private boolean isTaken;
	
	public ReadingMaterial(String name, String publisher){
		this.id = currentID++;
		this.name = name;
		this.publisher = publisher;
		this.history = new ArrayList<History>();
	}
	
	public abstract Comparator getComparator();
	
	public abstract int getSecondsForTake() throws LibraryException;
	
	public static int getCurrentID() {
		return currentID;
	}

	public static void setCurrentID(int currentID) {
		ReadingMaterial.currentID = currentID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void takeIt(boolean isTaken) {
		this.isTaken = isTaken;
		if(isTaken){
			this.history.add(new History(LocalDateTime.now()));
		}else{
			History lastHistory = this.history.get(this.history.size() - 1);
			lastHistory.setDateReturned(LocalDateTime.now());
		}
	}
	
	public LocalDateTime getTimeTaken(){
		return this.history.get(this.history.size() - 1).getDateTaken();
	}

	public boolean canBeTaken() {
		return true;
	}

	@Override
	public String toString() {
		return "ReadingMaterial [id=" + id + ", name=" + name + ", publisher=" + publisher + ", history=" + history
				+ ", isTaken=" + isTaken + "]";
	}

	public abstract Double getPrice() throws LibraryException;
	
}
