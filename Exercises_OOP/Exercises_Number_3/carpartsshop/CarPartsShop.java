package carpartsshop;

public class CarPartsShop implements IBuySellMakeParts,IRelationshipCarPartsShopCustomer{
	
	private static final int MAX_PLACES_FOR_PARTS = 3;
	private int freePlacesForParts = 3;
	private String name;
	private CarParts[] carparts = new CarParts[MAX_PLACES_FOR_PARTS];
	private double money;
	private String phoneNumber;
	
	public CarPartsShop(String name, double money) {
		this.name = name;
		this.money = money;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equalsIgnoreCase("") && !name.equalsIgnoreCase(null)){
			this.name = name;
		}
	}


	public void printCarparts() {
		for(int i = 0; i < carparts.length; i++){
			if(carparts[i] == null){
				break;
			}else{
				System.out.println(this.getName() + " has parts " + this.carparts[i].getPartName() + " with this quantity - " + this.carparts[i].getQuantity());
			}
		}
	}
	
	@Override
	public void addCarParts(CarParts carpart){
		int i = MAX_PLACES_FOR_PARTS - freePlacesForParts;
		if(freePlacesForParts > 0 && carparts[i] == null){
			carparts[i] = carpart;
			freePlacesForParts -= 1;
		}else{
			System.out.println("You can't buy more carparts.");
		}
	}
	

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		if(money > 100000){
			this.money = money;
		}else{
			this.money = 0;
		}
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(!phoneNumber.equalsIgnoreCase("") && !phoneNumber.equalsIgnoreCase(null)){
			if(phoneNumber.length() == 10 && phoneNumber.startsWith("08")){
				this.phoneNumber = phoneNumber;
			}
		}
	}
	
	@Override
	public void buyParts(Company company, int quantity){
		for(int i = 0; i < carparts.length; i++){
			if(carparts[i] != null){
				if(carparts[i].getPartName().equalsIgnoreCase(company.getCarparts().getPartName()) 
						&& carparts[i].getPartCode().equalsIgnoreCase(company.getCarparts().getPartCode())){
					if(company.getCarparts().getPriceSell()*quantity <= this.getMoney()){
						this.setMoney(this.getMoney() - (company.getCarparts().getPriceSell()*quantity));
						this.carparts[i].setQuantity(quantity);
						this.carparts[i].setPriceSell(company.getCarparts().getPriceSell() * 1.1);
						company.sellParts(quantity);
						System.out.println(this.getName() + " is buying " + this.carparts[i].getPartName() + " from " + company.getName());
						break;
					}
				}
			}
		}
	}
	
}
