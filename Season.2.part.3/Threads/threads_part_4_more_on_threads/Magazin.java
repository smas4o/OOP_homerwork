package threads_part_4_more_on_threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magazin {

//	private List<String> products = Collections.synchronizedList(new ArrayList<String>());
	
	private List<String> products = new ArrayList<String>();
	void addProduct(String product) {
		synchronized (products) {
			products.add(product);
		}
	}

	void removeProductAtIndex(int index) {
		synchronized (products) {
			if (index >= 0 && index < products.size()) {
				products.remove(index);
			}
		}
	}
	
	//moje da e synch moje i da ne e 
	String getProductAtIndex(int index) {
		if (index >= 0 && index < products.size()) {
			return products.get(index);
		}
		
		return null;
	}
	
	int getNumberOfProducts() {
		return products.size();
	}
}
