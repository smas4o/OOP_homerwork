package threads_part_4_more_on_threads;

public class Pyrjola {
	final String vkus;
	final int dyljinaNaKokala;
	final int kolkoEIzpechena;
	
	public Pyrjola(String vkus, int dyljinaNaKokala, int kolkoEIzpechena) {
		this.vkus = vkus;
		this.dyljinaNaKokala = dyljinaNaKokala;
		this.kolkoEIzpechena = kolkoEIzpechena;
	}
	
	Pyrjola changeVkus(String newVkus) {
		return new Pyrjola(newVkus, dyljinaNaKokala, kolkoEIzpechena);
	}

	@Override
	public String toString() {
		return "Pyrjola [vkus=" + vkus + ", dyljinaNaKokala=" + dyljinaNaKokala + ", kolkoEIzpechena=" + kolkoEIzpechena
				+ "]";
	}
}
