package test.task.vignette;

public class Driver {
	
	private final int MAX_VENCHILES_OWNED = 10;
	private int freePlacesForTasks = 10;
	private String name;
	private double money;
	private Venchile[] venchiles = new Venchile[MAX_VENCHILES_OWNED];
	private GasStation gasStation;
	
	Driver(){
	}
	Driver(String name, double money, GasStation gasStation){
		this();
		this.setName(name);
		this.setMoney(money);
		this.gasStation = gasStation;
	}
	
	
	public void buyVignette(int index, int days){
		gasStation.sellVignette(venchiles[index], days);
		
	}
	
	
	public void printVenchiles(){
		for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
			System.out.println(this.venchiles[i]);
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.equals(null) && !name.equals("")){
			this.name = name;
		}
	}
	
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		if(money > 5){
			this.money = money;
		}
	}
	
	public void addVenchiles(Venchile venchile){
		int i = MAX_VENCHILES_OWNED - freePlacesForTasks;
		if(freePlacesForTasks > 0 && venchiles[i] == null){
			venchiles[i] = venchile;
			freePlacesForTasks -= 1;
		}else{
			System.out.println("There is no free places for venchiles.");
		}
	}
	
	public void displayVenchiles(){
		for(int i = 0; i < MAX_VENCHILES_OWNED; i++){
			System.out.println(this.getName() + " " + this.getMoney() + " " + this.venchiles[i].getModel() + " " + this.venchiles[i].getYear());
		}
	}
	
}
