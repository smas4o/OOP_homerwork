package school;

public class School {
	
	private static final int MAX_CLASSES = 8;
	private String name;
	private ClassOfStudents[] classesOfStudents = new ClassOfStudents[8];
	private int freeClasses = 8;
	
	public School(String name) {
		setName(name);
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
	
	
	public void addClass(ClassOfStudents classOfStudents){
		int i = MAX_CLASSES - freeClasses;
		if(freeClasses >= 0 && classesOfStudents[i] == null){
			classesOfStudents[i] = classOfStudents;
			freeClasses -= 1;
		}else{
			System.out.println("No free classes.");
		}
	}
	
	
	public void printClasses(){
		
		for(int i = 0; i < classesOfStudents.length; i++){
			if(classesOfStudents[i] != null){
				classesOfStudents[i].printStudents();
			}
		}
		
	}
}
