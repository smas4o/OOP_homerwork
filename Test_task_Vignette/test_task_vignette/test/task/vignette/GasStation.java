package test.task.vignette;

public class GasStation {
	
	private String name;
	private final int MAX_SELLING_VIGNETTES = 100;
	double turnoverForToday;
	Vignette[] vignettes = new Vignette[MAX_SELLING_VIGNETTES];
	
	
	GasStation(String name){
		this.name = name;
		this.createVignettes();
	}
	
	
	public void sellVignette(Venchile venchile, int days){
		
	}
	
	
	private void createVignettes(){
		int count = 0;
		int index = 0;
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(i % 3 == 0){
				index = i;
			}
			if(i - index == 0){
				vignettes[i] = new Vignette("car");
			}else if(i - index == 1){
				vignettes[i] = new Vignette("truck");
			}else if(i - index == 2){
				vignettes[i] = new Vignette("autobus");
			}
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(count == 0){
				vignettes[i].setValidity(7);
			}else if(count == 1){
				vignettes[i].setValidity(30);
			}else if(count == 2){
				vignettes[i].setValidity(365);
			}else if(count == 3){
				vignettes[i].setValidity(365);
			}else if(count == 4){
				vignettes[i].setValidity(7);
			}else if(count == 5){
				vignettes[i].setValidity(30);
			}else if(count == 6){
				vignettes[i].setValidity(30);
			}else if(count == 7){
				vignettes[i].setValidity(365);
			}else if(count == 8){
				vignettes[i].setValidity(7);
			}
			count++;
			if(count == 9){
				count = 0;
			}
		}
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			this.vignettes[i].setPrice();
		}
	}
	
	
	public void printVignette(){
		
		for(int i = 0; i < MAX_SELLING_VIGNETTES; i++){
			if(!vignettes[i].equals(null)){
				System.out.println(this.vignettes[i].getColor() + " " 
						+ this.vignettes[i].getValidity() + " " + this.vignettes[i].getPrice());
			}
		}
	}
}
