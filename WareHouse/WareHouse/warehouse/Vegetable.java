package warehouse;

public class Vegetable extends Product{
	
	private static final int KOLKO_DA_ZAREDI = 25;
//	private IWareHouse sklad;
//	private String name;
	
	public Vegetable(String name, IWareHouse sklad) throws ProductException{
//		this.setProductName(name);
//		this.sklad = sklad;
		super(name, sklad);
	}
	
	@Override
	public void run(){
		
		
	}
	
	
//	public void setProductName(String name) throws FruitException{
//		if(name == null && name.equals("") && (!name.equals("banan") || !name.equals("orange") || !name.equals("apple"))){
//			throw new FruitException("Nqma takuv zelenchuk.");
//		}else{
//			this.name = name;
//		}
//	}
//	
//	public String getProductName(){
//		return this.name;
//	}
//	
//	public int getTimeToProduce() {
//		return 100;
//	}
}