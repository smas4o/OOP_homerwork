package warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supplier implements Runnable{
	
	private static final int HOW_MUCH_TO_SUPPLY = 25;
	private IShoppingCenter warehouse;
	
	Supplier(IShoppingCenter warehouse){
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		while(true){
			List<Product> products = warehouse.getQuantityIsLow();
			if(products.size() > 0){
				for(Product product : products){
					try{
						System.out.println("Zarejdam produkti v sklada.");
						warehouse.addProduct(product, HOW_MUCH_TO_SUPPLY);
						synchronized(warehouse){
							System.out.println("Zaredih produktite.");
							warehouse.notifyAll();
						}
					}catch(WareHouseException e){
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("Shte chakam da mi zvunnete da zaredq.");
				try {
					synchronized(warehouse){
						warehouse.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}