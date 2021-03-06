package test.task.vignette;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class GasStation {
	
	private String name;
	private int MAX_SELLING_VIGNETTES = 400;
	double turnoverForToday;
	private Vignette[] vignettes = new Vignette[MAX_SELLING_VIGNETTES];
	
	//construktor za benzinostancia
	GasStation(String name){
		this.turnoverForToday = 0;
		this.name = name;
		this.createVignettes();
	}
	
	//prdovane na vinetka
	public Vignette sellVignette(Venchile venchile, int days) throws ParseException{
		Vignette vignette = null;
		String color;
		Class<? extends Venchile> c = venchile.getClass();
		if(c.equals(Car.class)){
			color = "car";
			vignette = findVignette(color, days, vignette);
		}else if(c.equals(Truck.class)){
			color = "truck";
			vignette = findVignette(color, days, vignette);
		}else if(c.equals(Autobus.class)){
			color = "autobus";
			vignette = findVignette(color, days, vignette);
		}
		return vignette;
	}
	
	//namirane na tochnata vinetka
	private Vignette findVignette(String color, int days, Vignette vignette) throws ParseException {
		int index = 0;
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(this.vignettes[i].getColor().equalsIgnoreCase(color) && this.vignettes[i].getValidity() == days){
				vignettes[i].setDateOfIssue(setDateOfIssue());
				vignettes[i].setExpiryDate(setExpiryDate(vignettes[i].getDateOfIssue(), days));
				vignette =  vignettes[i];
				this.setTurnoverForToday(this.getTurnoverForToday() + vignettes[i].getPrice());
				index = i;
				break;
			}
		}
		Vignette temp = vignettes[index];
		this.vignettes[index] = vignettes[MAX_SELLING_VIGNETTES - 1];
		this.vignettes[MAX_SELLING_VIGNETTES - 1] = temp;
		this.vignettes[MAX_SELLING_VIGNETTES - 1] = null;
		MAX_SELLING_VIGNETTES -= 1;
		sortVignettes(vignettes, MAX_SELLING_VIGNETTES);
		return vignette;
	}
	
	//zadavane i printirane na oborota
	public double getTurnoverForToday() {
		return turnoverForToday;
	}
	public void setTurnoverForToday(double turnoverForToday) {
		if(turnoverForToday > 0){
			this.turnoverForToday = turnoverForToday;
		}
	}
	
	//printira imeto
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equals(null) && !name.equals("")){
			this.name = name;
		}
	}
	
	//suzdavane na vinetki
	private void createVignettes(){
		int count = 0;
		int index = 0;
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(i % 3 == 0){
				index = i;
			}
			if(i - index == 0){
				vignettes[i] = new Vignette("car");
			}else if(i - index == 1){
				vignettes[i] = new Vignette("truck");
			}else if(i - index == 2){
				vignettes[i] = new Vignette("autobus");
			}
			
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(count == 0){
				vignettes[i].setValidity(1);
			}else if(count == 1){
				vignettes[i].setValidity(31);
			}else if(count == 2){
				vignettes[i].setValidity(365);
			}else if(count == 3){
				vignettes[i].setValidity(365);
			}else if(count == 4){
				vignettes[i].setValidity(1);
			}else if(count == 5){
				vignettes[i].setValidity(31);
			}else if(count == 6){
				vignettes[i].setValidity(31);
			}else if(count == 7){
				vignettes[i].setValidity(365);
			}else if(count == 8){
				vignettes[i].setValidity(1);
			}
			count++;
			if(count == 9){
				count = 0;
			}
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			this.vignettes[i].setPrice();
		}
		sortVignettes(vignettes, MAX_SELLING_VIGNETTES);
	}
	
	//sortirane na vinetkite s bubble sort
	public Vignette[] sortVignettes(Vignette[] vignettes, int length){
		Vignette temp;
		for(int i = 0; i < length; i++){
			for(int j = 1; j < length - i; j++){
				if(vignettes[j].getPrice() < vignettes[j-1].getPrice()){
					temp = vignettes[j];
					vignettes[j] = vignettes[j-1];
					vignettes[j-1] = temp;
				}
			}
		}
		return vignettes;
	}
	
	//printirane na vinetkite
	public void printVignette(){
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(!vignettes[i].equals(null)){
				System.out.println(i + " " + this.vignettes[i].getColor() + " " 
						+ this.vignettes[i].getValidity() + " " + this.vignettes[i].getPrice());
			}
		}
	}
	
	//zadavane na datata na izdavane na random princip
	public Date setDateOfIssue() throws ParseException{
		int year = (int)(Math.random()*(2016 - 2015) + 2015);
		int month = (int)(Math.random()*(12 - 1) + 1);
		int day = 0;
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = (int)(Math.random()*(31 - 1) + 1);
			break;
		case 2: 
			day = (int)(Math.random()*(28 - 1) + 1);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = (int)(Math.random()*(30 - 1) + 1);
			break;
		}
		String string = year + "-" + month + "-" + day + " 08:34:55.705";
		Date dateOfIssue = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS").parse(string);
		return dateOfIssue;
	}
	
	@SuppressWarnings("deprecation")
	public Date setExpiryDate(Date dateOfIssue, int days) throws ParseException {
		String string2;
		Date expirationDate = null;
		int day1 = dateOfIssue.getDate();
		int month1 = dateOfIssue.getMonth();
		int year1 = dateOfIssue.getYear() + 1900;
		if(days == 1){
			day1 += 1;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS").parse(string2);
		}else if(days == 31){
			day1 += 31;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS").parse(string2);
		}else if(days == 365){
			day1 += 365;
			string2 = year1 + "-" + month1 + "-" + day1 + " 08:34:55.705";
			expirationDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS").parse(string2);
		}
		return expirationDate;
	}
}
