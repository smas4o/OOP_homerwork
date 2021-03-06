package music_shop;

public class Instrument {
	
	private String name;
	private MusicInstrument type;
	private Integer price;
	
	Instrument(String name, MusicInstrument type, int price){
		this.type = type;
		this.name = name;
		this.setPrice(price);
	}
	
	Instrument(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public MusicInstrument getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price <= 0){
			this.price = (int)(Math.random() * 10);
		}else{
			this.price = price;
		}
	}

	@Override
	public String toString() {
		return "\n Instrument: " + name + ", type: " + type + ", price: " + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
