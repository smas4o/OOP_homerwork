package threads_part_4_more_on_threads;

public class Demo {

	private static final int NUMBER_OF_PESHOS = 500;

	public static void main(String[] args) {
		Account acc = new Account(30);
		
		for (int pesho=1; pesho <= NUMBER_OF_PESHOS; pesho++){
			new Thread(new PeshoHackera(acc)).start();
		}
	}

}
