package threads_part_5_practice_shtaiga;

public class Demo {

	public static void main(String[] args) {
		IShtaiga markovaShtaigaAMG63BiTurbo = new Shtaiga();
		for (int i = 1; i <= 2; i++) {
			Thread sel = new Thread(new Selyanin(markovaShtaigaAMG63BiTurbo));
			sel.start();
			new Thread(new Shemadjiq(markovaShtaigaAMG63BiTurbo, sel)).start();
		}
	}
}
