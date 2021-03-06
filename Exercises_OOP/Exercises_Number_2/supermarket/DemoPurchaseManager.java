package supermarket;

public class DemoPurchaseManager {
	
	public static void main(String[] args){
		
		//buying food
		FoodProduct chipsLays = new FoodProduct("Lays", 2.20, 200, 0, 14);
		Customer spas = new Customer("Spas", 24, 20);
		
		chipsLays.checkExpiredate();
		System.out.println(chipsLays.getPrice());
		
		purchaseFood(chipsLays, spas, 1);
		
		System.out.println(spas.getBalance());
		System.out.println(spas.getProduct().getName());
		System.out.println(chipsLays.getQuantity());
		
		System.out.println();
		//buying computer
		Computer asusg551jm = new Computer("Asus G551JM-CN013D", 1885, 5, 18, 24);
		Customer todor = new Customer("Todor",  29, 2000);
		
		asusg551jm.returnPrice(asusg551jm.getQuantity());
		System.out.println(asusg551jm.getPrice());
		
		purchaseElectronicsProduct(asusg551jm, todor, 1);
		
		System.out.println(todor.getBalance());
		System.out.println(todor.getProduct().getName());
		System.out.println(asusg551jm.getQuantity());
		
		System.out.println();
		//buying washing machine
		Appliance beatsmixr = new Appliance("BEATS MIXR GREEN", 499, 51, 18, 6);
		Customer acho = new Customer("Angel", 24, 600);
		
		beatsmixr.returnPrice(beatsmixr.getQuantity());
		System.out.println(beatsmixr.getPrice());
		
		purchaseElectronicsProduct(beatsmixr, acho, 1);
		
		System.out.println(acho.getBalance());
		System.out.println(acho.getProduct().getName());
		System.out.println(beatsmixr.getQuantity());
	}
	
	
	public static void purchaseFood(FoodProduct product, Customer customer, int quantity){
		if(quantity > 0){
			if(product.getQuantity() > 0){
				if(product.getPrice() <= customer.getBalance()){
					if(product.getExpirationDate() > 0){
						customer.setBalance(customer.getBalance() - product.getPrice());
						product.setQuantity(product.getQuantity() - quantity);
						customer.setProduct(product);
						System.out.println(customer.getName() + " has bought " + customer.getProduct().getName() + ".");
					}else{
						System.out.println("You can't buy that cause its expiry date has expired.");
					}
				}else{
					System.out.println("You can't afford to buy that product.");
				}
			}else{
				System.out.println("There is no more units of this product.");
			}
		}else{
			System.out.println("Choose a real count of this product.");
		}
	}
	
	public static void purchaseElectronicsProduct(ElectronicsProduct product, Customer customer, int quantity){
		if(quantity > 0){
			if(product.getQuantity() > 0){
				if(product.getPrice() <= customer.getBalance()){
					if(product.getAgeRestriction() <= customer.getAge()){
						customer.setBalance(customer.getBalance() - product.getPrice());
						product.setQuantity(product.getQuantity() - quantity);
						customer.setProduct(product);
						System.out.println(customer.getName() + " has bought " + customer.getProduct().getName() + ".");
					}else{
						System.out.println("You can't buy that product due age restriction");
					}
				}else{
					System.out.println("You can't afford to buy that product.");
				}
			}else{
				System.out.println("There is no more units of this product.");
			}
		}else{
			System.out.println("Choose a real count of this product.");
		}
	}
}
