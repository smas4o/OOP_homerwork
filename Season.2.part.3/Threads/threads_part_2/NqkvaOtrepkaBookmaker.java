package threads_part_2;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class NqkvaOtrepkaBookmaker implements Runnable {

	static ThreadGroup grupaNaKone;
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (grupaNaKone.activeCount() == 0) {
				System.out.println("Nqma kone. Trygavm si. Ae chao.");
				return;
			}
				
			System.out.println("Zapisvam si i bookmakevam i si svirukam.");
			Thread[] kone = new Thread[grupaNaKone.activeCount()];
			grupaNaKone.enumerate(kone, true);
			
			for (Thread kon : kone) {
				System.out.println("sega si zapisah do kyde e stignal " + kon.getName());
			}
		}
	} 

}