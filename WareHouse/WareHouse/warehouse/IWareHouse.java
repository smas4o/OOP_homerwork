package warehouse;

import java.util.Stack;

public interface IWareHouse {
	
	void checkStorage(Product product);

	Product sellProduct() throws ProductException;

	boolean isFull();

	boolean isAboveMinimal();
	
	void printStorage();
	
}