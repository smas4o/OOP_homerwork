package test.task.vignette;

public class Venchile {
	
	private String model;
	private Vignette vignette;
	private int year;
	
	
	public Venchile(String model, int year) {
		this.setModel(model);
		this.setYear(year);
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(!model.equals(null) && !model.equals("")){
			this.model = model;
		}
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >= 1970 && year <= 2015){
			this.year = year;
		}
	}
	
	
	public void setVignette(Vignette vignette){
		if(!vignette.equals(null)){
			if(vignette.setOnGlass(this) == true){
				vignette.setOnFrontGlass(this);
				this.vignette = vignette;
			}
		}
	}
	public void getVignette(){
		System.out.println(vignette.getColor());
	}
}