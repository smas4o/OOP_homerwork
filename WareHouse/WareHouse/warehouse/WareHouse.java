package warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WareHouse implements IWareHouse {

	private static final int MAX_CAPACITY = 100;

	private static final int MIN_STORAGE = 10;
	
	private static final String BANAN = "banan";
	private static final String ORANGE = "orange";
	private static final String APPLE = "apple";
	private static final String POTATO = "potato";
	private static final String EGGPLANT = "eggplant";
	private static final String CUCUMBER = "cucumber";
	
	Map<String, Stack<Vegetable>> vegetables = new HashMap<String, Stack<Vegetable>>();
	Map<String, Stack<Fruit>> fruits = new HashMap<String, Stack<Fruit>>();
	
	//znam che e grozno ama ne se setih za drug nachin
	Stack<Fruit> banan = new Stack<Fruit>();
	Stack<Fruit> orange = new Stack<Fruit>();
	Stack<Fruit> apple = new Stack<Fruit>();
	Stack<Vegetable> potato = new Stack<Vegetable>();
	Stack<Vegetable> eggplant = new Stack<Vegetable>();
	Stack<Vegetable> cucumber = new Stack<Vegetable>();
	private void beginingStorageFruit(Stack<Fruit> fruit, String name){
		for(int i = 1; i <= 15; i++){
			try {
				fruit.push(new Fruit(name + i, this));
			} catch (ProductException e) {
				e.printStackTrace();
			}
		}
	}
	private void beginingStorageVegetable(Stack<Vegetable> vegetable, String name){
		for(int i = 1; i <= 15; i++){
			try {
				vegetable.push(new Vegetable(name + i, this));
			} catch (ProductException e) {
				e.printStackTrace();
			}
		}
	}
	//
	
	
	WareHouse(){
		beginingStorageFruit(banan, BANAN);
		beginingStorageFruit(orange, ORANGE);
		beginingStorageFruit(apple, APPLE);
		beginingStorageVegetable(potato, POTATO);
		beginingStorageVegetable(eggplant, EGGPLANT);
		beginingStorageVegetable(cucumber, CUCUMBER);
		fruits.put(BANAN, banan);
		fruits.put(ORANGE, orange);
		fruits.put(APPLE, apple);
		vegetables.put(POTATO, potato);
		vegetables.put(EGGPLANT, eggplant);
		vegetables.put(CUCUMBER, cucumber);
	}
	
	@Override
	public void printStorage(){
		System.out.println(this.fruits.get(ORANGE).peek().getProductName() + " " + this.fruits.get(ORANGE).size());
		System.out.println(this.fruits.get(BANAN).peek().getProductName() + " " +  this.fruits.get(BANAN).size());
		System.out.println(this.fruits.get(APPLE).peek().getProductName() + " " +  this.fruits.get(APPLE).size());
		System.out.println(this.vegetables.get(POTATO).peek().getProductName() + " " +  this.vegetables.get(POTATO).size());
		System.out.println(this.vegetables.get(EGGPLANT).peek().getProductName() + " " +  this.vegetables.get(EGGPLANT).size());
		System.out.println(this.vegetables.get(CUCUMBER).peek().getProductName() + " " +  this.vegetables.get(CUCUMBER).size());
	}
	
	@Override
	public void checkStorage(Product product){
		if(product.getProductName() == null && product.getProductName().equals("")){
			System.out.println("Nqma takuv product");
		}
		synchronized(fruits){
			if(this.fruits.get(BANAN).size() <= 10){
				this.fruits.get(BANAN).push((Fruit) product);
			}
		}
	}
	
	@Override
	public Product sellProduct() throws ProductException{
		synchronized(fruits){
			if(fruits.get(BANAN).size() <= MIN_STORAGE){
				throw new ProductException("Nqma dostatuchno nalicnotst.");
			}
		}
		return fruits.get(BANAN).pop();
	}
	
	@Override
	public boolean isFull() {
		return fruits.get(BANAN).size() >= MAX_CAPACITY;
	}
	
	@Override
	public boolean isAboveMinimal(){
		return fruits.get(BANAN).size() > MIN_STORAGE;
	}
}