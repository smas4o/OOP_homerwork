package class_exercises;

public class Human {

	private String name;
	private String surname;
	
	public Human(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null){
			this.name = name;
		}else{
			this.name = "";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(surname != null){
			this.surname = surname;
		}else{
			this.surname = "";
		}
	}
	
}
