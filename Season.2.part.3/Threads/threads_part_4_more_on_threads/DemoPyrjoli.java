package threads_part_4_more_on_threads;

public class DemoPyrjoli {
	public static void main(String[] args) {
		Pyrjola vratnaSvinskaBezKostMarinovana = 
				new Pyrjola("Super qk", 0, 3);
		
		System.out.println(vratnaSvinskaBezKostMarinovana);
		
		vratnaSvinskaBezKostMarinovana= vratnaSvinskaBezKostMarinovana.changeVkus("kiselo zele s banani");
		
		System.out.println(vratnaSvinskaBezKostMarinovana);
	}
}
