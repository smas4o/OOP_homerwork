package postOffice;

public class Demo {

	public static void main(String[] args) {
		
		for(int i = 1; i < 10; i++){
			new Thread(new Citizen("Dayan", "Dimitrov", "Banishora 7")).start();
			new Thread(new Postman("Ivan", "Vasev", "Levski-V")).start();
			new Thread(new Collector("Blagovest", "Chalukov", "Velichkovo")).start();
		}
		
	}

}
