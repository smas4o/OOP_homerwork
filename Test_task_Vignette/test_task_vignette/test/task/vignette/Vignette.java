package test.task.vignette;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Vignette {
	
	private static final int PRICE_FOR_YEAR = 60;
	private static final int PRICE_FOR_MONTH = 10;
	private static final int[] PRICE_FOR_WEEK = {5, 7, 9};
	private Date dateOfIssue;
	private Date expiryDate;
	private String color;
	private int validity;
	private int price;
	
	//konstruktor s parametri
	Vignette(String color){
		this.setColor(color);
	}
	
	//zadavane na cenata na vinetkata chrez cveta
	public int getPrice() {
		return price;
	}
	public void setPrice() {
		String venchile;
		if(this.color.equalsIgnoreCase("car")){
			venchile = "car";
			findTheExactPrice(venchile);
		}else if(this.color.equalsIgnoreCase("truck")){
			venchile = "truck";
			findTheExactPrice(venchile);
		}else if(this.color.equalsIgnoreCase("autobus")){
			venchile = "autobus";
			findTheExactPrice(venchile);
		}
	}
	
	//zadavane na tochnata cena chrez podavanoto prevozno sredstvo implementira se v po-gornia metod
	private void findTheExactPrice(String venchile) {
		int index = 0;
		if(venchile.equals("car")){
			index = 0;
		}else if(venchile.equals("truck")){
			index = 1;
		}else if(venchile.equals("autobus")){
			index = 2;
		}
		if(this.validity == 1){
			this.price = PRICE_FOR_WEEK[index];
		}else if(this.validity == 31){
			this.price = PRICE_FOR_MONTH*PRICE_FOR_WEEK[index];
		}else if(this.validity == 365){
			this.price = PRICE_FOR_YEAR*PRICE_FOR_WEEK[index];
		}
	}

	//zadavane na cveta
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(color.equalsIgnoreCase("car")){
			this.color = color;
		}else if(color.equalsIgnoreCase("truck")){
			this.color = color;
		}else if(color.contentEquals("autobus")){
			this.color = color;
		}
	}
	
	//zadavane na duljinata na validnost v dni
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		if(validity == 1 || validity == 31 || validity == 365){
			this.validity = validity;
		}
	}
	
	//printirane za kolko vreme se postavq vinetkata
	public void setOnWindshield(Venchile venchile){
		if(venchile != null){
			Class<? extends Venchile> c = venchile.getClass();
			if(c.equals(Car.class)){
				System.out.println("Set on the glass for 5 seconds on the " + ((Car) venchile).getModel() + "'s windshield.");
			}else if(c.equals(Truck.class)){
				System.out.println("Set on the glass for 10 seconds on the " + ((Truck) venchile).getModel() + "'s windshield.");
			}else if(c.equals(Autobus.class)){
				System.out.println("Set on the glass for 20 seconds on the " + ((Autobus) venchile).getModel() + "'s windshield.");
			}
		}	
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) throws ParseException{
		this.expiryDate = expiryDate;
	}
	
}