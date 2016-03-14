package test3;

import java.util.List;

public class CourierToMainOffice extends Staff{
	
	protected static final int NUMBER_OF_MIN_PACKAGES = 5;
	private static MainOffice mainOffice;
	
	public CourierToMainOffice(String name, String gsm, long number, String address, CityOffice cityOffice, MainOffice mainOffice) throws ClientException {
		super(name, gsm, number, address, cityOffice);
		this.mainOffice = mainOffice;
	}
	
	public static MainOffice getMainOffice() {
		return mainOffice;
	}

	@Override
	public void run(){
//		while(true){
			while(getCityOffice().getNumberOfPackages() > NUMBER_OF_MIN_PACKAGES){
				synchronized(mainOffice){
					try{
						System.out.println("Chakam za pratki.");
						mainOffice.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
			
			System.out.println("Shte vzema pratkite ot ofisa.");
			
			List<Pratka> pratkiZaCentralen = getCityOffice().getAll();
			System.out.println("Karam gi v centralnia ofis - Turnovo.");
			mainOffice.addPratka(pratkiZaCentralen);
			synchronized(mainOffice){
				mainOffice.notifyAll();
			}
//		}
	}
}
