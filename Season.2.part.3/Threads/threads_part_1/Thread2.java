package threads_part_1;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Runs in parallel:");
		for (int i = 1; i <= 100; i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + " : " + i);
//			if (i > 56) {
//				i /= 0;
//			}
		}
	}
}
