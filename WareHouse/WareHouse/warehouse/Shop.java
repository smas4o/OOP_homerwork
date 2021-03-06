package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Shop implements IShoppingCenter{
	
	private static final int HOW_MUCH_TO_REFILL = 15;
	private static final int MIN_QUANTITY = 5;
	
	private IShoppingCenter warehouse;
	
	private Map<Product, Integer> products = new ConcurrentHashMap<Product, Integer>();
	
	Shop(IShoppingCenter warehouse){
		this.warehouse = warehouse;
	}
	
	public IShoppingCenter getWarehouse(){
		return warehouse;
	}
	
	public void addProduct(Product product, int quantity) throws ShopException{
		if(product != null && quantity > 0 && products.containsKey(product)){
			int newQuantity = products.get(product);
			newQuantity += quantity;
			products.put(product, newQuantity);
		}else{
			throw new ShopException("Can't accept that product.");
		}
	}
	
	public void sellProduct(Product product, int quantity) throws ShopException, WareHouseException{
		this.addProduct(product, -quantity);
		this.checkProductsQuantity();
	}
	
	public List<Product> getQuantityIsLow(){
		List<Product> lowQuantityProducts = new ArrayList<Product>();
		for(Product product :products.keySet()){
			if(products.get(product) < MIN_QUANTITY){
				lowQuantityProducts.add(product);
			}
		}
		return lowQuantityProducts;
	}
	
	public boolean needNewSupplies(){
		return !getQuantityIsLow().isEmpty();
	}
	
	public void checkProductsQuantity() throws WareHouseException, ShopException {
		List<Product> products = this.getQuantityIsLow();
		if(products.size() > 0){
			for(Product product : products){
				warehouse.sellProduct(product, HOW_MUCH_TO_REFILL);
				this.addProduct(product, HOW_MUCH_TO_REFILL);
			}
		}else{
			System.out.println("Nqma nujda ot zarejdane na magazina.");
		}
	}	
}
