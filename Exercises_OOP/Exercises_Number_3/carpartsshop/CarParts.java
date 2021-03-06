package carpartsshop;

public class CarParts {
	
	private String partCode;
	private String partName;
	private double priceBuy;
	private double priceSell;
	private String categoryUse;
	private Car[] carUsedOn = new Car[3];
	private Company manufacturingCompany;
	private int quantity;
	
	
	public CarParts(String partCode, String partName,  String categoryUse, Car[] carUsedOn, Company manufacturingCompany) {
		this.setPartCode(partCode);
		this.setPartName(partName);
		this.setCategoryUse(categoryUse);
		this.carUsedOn = carUsedOn;
		this.manufacturingCompany = manufacturingCompany;
		this.priceBuy = 0;
		this.priceSell = 0;
		this.quantity = 0;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		if(!partCode.equalsIgnoreCase("") && !partCode.equalsIgnoreCase(null)){
			if(partCode.length() == 6){
				this.partCode = partCode;
			}
		}
	}
	
	
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		if(!partName.equalsIgnoreCase("") && !partName.equalsIgnoreCase(null)){
			this.partName = partName;
		}
	}
	
	
	public double getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(double priceBuy) {
		if(priceBuy > 0){
			this.priceBuy = priceBuy;
		}
	}
	
	
	public double getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(double priceSell) {
		if(priceSell > 0){
			this.priceSell = priceSell;
		}
	}
	
	
	public String getCategoryUse() {
		return categoryUse;
	}
	public void setCategoryUse(String categoryUse) {
		if(!categoryUse.equalsIgnoreCase("") && !categoryUse.equalsIgnoreCase(null)){
			this.categoryUse = categoryUse;
		}
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity > 0){
			this.quantity = quantity;
		}
	}
	
	
	public Car[] getCarUsedOn() {
		return carUsedOn;
	}
	public Company getManufacturingCompany() {
		return manufacturingCompany;
	}
	
}
