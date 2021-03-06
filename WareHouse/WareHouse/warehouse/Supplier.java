package warehouse;

import java.util.List;

public class Supplier implements Runnable{
	
	private static final int HOW_MUCH_TO_SUPPLY = 25;
	private IShoppingCenter warehouse;
	
	Supplier(IShoppingCenter warehouse){
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		while(!warehouse.getQuantityIsLow().isEmpty()){
			List<Product> products = this.warehouse.getQuantityIsLow();
			if(products.size() > 0){
				for(Product product : products){
					try{
						System.out.println(Thread.currentThread().getName() + "Zarejdam produkti v sklada.");
						warehouse.addProduct(product, HOW_MUCH_TO_SUPPLY);
						synchronized(warehouse){
							System.out.println(Thread.currentThread().getName() + "Zaredih produktite.");
							warehouse.notifyAll();
						}
					}catch(WareHouseException | ShopException e){
						e.printStackTrace();
					}
				}
			}else{
				System.out.println(Thread.currentThread().getName() + "Shte chakam da mi zvunnete da zaredq.");
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
