package library;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Magazine extends ReadingMaterial {
	
	private LocalDateTime date;
	private int number;
	
	public Magazine(String name, String publisher, LocalDateTime date, int number) {
		super(name, publisher);
		this.number = number;
		this.date = date;
	}
	
	@Override
	public boolean canBeTaken(){
		return false;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Magazine [date=" + date + ", number=" + number + ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}
	
	@Override
	public Comparator getComparator(){
		return new MagazineComparator();
	}

	@Override
	public int getSecondsForTake() throws LibraryException {
		throw new LibraryException("Can't take the magazine!");
	}

	@Override
	public Double getPrice() throws LibraryException {
		throw new LibraryException("Can't take that magazine.");
	}
}
