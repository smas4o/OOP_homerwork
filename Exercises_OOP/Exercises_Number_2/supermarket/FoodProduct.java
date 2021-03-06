package supermarket;

public class FoodProduct extends Product implements Expirable{
	
	int expirationDate;
	
	FoodProduct(String name, double price, int quantity, int ageRestrciction, int expirationDate) {
		super(name, price, quantity, ageRestrciction);
		this.expirationDate = expirationDate;
	}


	public int getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(int expirationDate) {
		if(expirationDate <= 0){
			this.expirationDate = 1;
		}else{
			this.expirationDate = expirationDate;
		}
	}


	@Override
	public void checkExpiredate() {
		if(this.expirationDate < 15){
			this.setPrice(this.getPrice() * 0.75);
		}
	}
	
}
