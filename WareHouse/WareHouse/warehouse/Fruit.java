package warehouse;

public class Fruit extends Product{
	
	private static final int KOLKO_DA_ZAREDI = 25;
	
	public Fruit(String name, IWareHouse sklad) throws ProductException{
		super(name, sklad);
		
	}

	@Override
	public void run() {
		
		for(int count = 1; count <= KOLKO_DA_ZAREDI && !Thread.currentThread().isInterrupted();){
			while(sklad.isFull()){
				System.out.println("Zarejdane na polodve - " + this.getProductName());
				try{
					synchronized(sklad){
						sklad.wait();
					}
				}catch(InterruptedException e){
					e.printStackTrace();
					return;
				}
			}
			
			for(int i = 1; i <= 10; i++){
				try{
					sklad.checkStorage(new Fruit("banan", sklad));
					count++;
					synchronized(sklad){
						if(sklad.isAboveMinimal()){
							sklad.notifyAll();
						}
					}
				}catch (ProductException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}