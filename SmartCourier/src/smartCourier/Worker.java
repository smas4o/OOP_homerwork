package smartCourier;

import java.util.List;

public class Worker extends Citizen {
	
	
	public Worker(String name, String gsm, String personalNumber, Adress adress) {
		super(name, gsm, personalNumber, adress);
	}
	
	private List<Protocol> workerProtocol;
	
	public List<Protocol> getWorkerProtocol() {
		return workerProtocol;
	}

	
	
}
