package warehouse;

public class Demo {

	public static void main(String[] args) throws ProductException {
		
		IWareHouse sklad = new WareHouse();
		for (int i = 1; i <= 5; i++) {
			Thread banan = new Thread(new Fruit("banan", sklad));
			banan.start();
		}
		
		sklad.printStorage();

	}

}