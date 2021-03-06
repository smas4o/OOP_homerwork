package warehouse;

public class Client implements Runnable{
	
	private Shop shop;
	private Thread supplier;
	
	Client(Shop shop, Thread supplier){
		this.shop = shop;
		this.supplier = supplier;
	}
	
	@Override
	public void run() {
		while(supplier.isAlive() || !shop.getWarehouse().getQuantityIsLow().isEmpty()){
			while(shop.getWarehouse().getQuantityIsLow().isEmpty()){
				System.out.println(Thread.currentThread().getName() + " Shte si kupq sega nqkakvi produkti.");
				synchronized(shop.getWarehouse()){
					try{
						shop.getWarehouse().wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
			
			try{
				Thread.sleep(5000);
				
				int quantity = (int) (Math.random()*4 - 1);
				int number = (int) (Math.random() * 9);
				Product product = null;
				switch(number){
				case 0:
					product = new Product("banan", FoodProduct.FRUITS);
					break;
				case 1:
					product = new Product("orange", FoodProduct.FRUITS);
					break;
				case 2:
					product = new Product("apple", FoodProduct.FRUITS);
					break;
				case 3:
					product = new Product("potato", FoodProduct.VEGETABLES);
					break;
				case 4:
					product = new Product("eggplant", FoodProduct.VEGETABLES);
					break;
				case 5: 
					product = new Product("cucumber", FoodProduct.VEGETABLES);
					break;
				case 6:
					product = new Product("pork", FoodProduct.MEATS);
					break;
				case 7:
					product = new Product("beef", FoodProduct.MEATS);
					break;
				case 8:
					product = new Product("chicken", FoodProduct.MEATS);
					break;
				}
				synchronized(shop.getWarehouse()){
					if(!shop.getQuantityIsLow().isEmpty()){
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + " Shte izchakam da zaredi.");
						this.shop.getWarehouse().notifyAll();
					}
					if(!shop.getWarehouse().getQuantityIsLow().isEmpty()){
						System.out.println(Thread.currentThread().getName() + " Sega shte si kupq tozi produkt " + product.getName() + " v tova kolichestvo " + quantity);
						this.shop.sellProduct(product, quantity);
					}
//					if(!shop.getQuantityIsLow().isEmpty()){
//						
//					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
