package threads_part_2;

public class Thread1 extends Thread{
	
	boolean daPrikluchvamLi = false;
	
	@Override
	public void run() {
		System.err.println("Runs in parallel:");
		for (int i = 1; i <= 100 && daPrikluchvamLi == false; i++) {
//			try {
//				Thread.sleep(700);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.err.println("Thread 1 : " + i);
		}
	}

	public boolean isDaPrikluchvamLi() {
		return daPrikluchvamLi;
	}

	public void setDaPrikluchvamLi(boolean daPrikluchvamLi) {
		this.daPrikluchvamLi = daPrikluchvamLi;
	}
}
