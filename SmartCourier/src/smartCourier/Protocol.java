package smartCourier;

public class Protocol {

	private Citizen sender;
	private Citizen reciever;

	public Protocol(Citizen sender, Citizen reciever) {
		this.sender = sender;
		this.reciever = reciever;

	}

	public Citizen getSender() {
		return sender;
	}

	public void setSender(Citizen sender) {
		this.sender = sender;
	}

	public Citizen getReciever() {
		return reciever;
	}

	public void setReciever(Citizen reciever) {
		this.reciever = reciever;
	}

}
