package person_student_employee;

public class Employee extends Person{
	
	private double daySalary;
	private double overTime;
	
	void setDaySalary(double daySalary){
		if(daySalary >= 0){
			this.daySalary = daySalary;
		}
	}
	
	public double getDaySalary(){
		return daySalary;
	}
	
	public Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		setDaySalary(daySalary);
	}

	void showEmployeeInfo(){
		System.out.println(this.getName() + " is " + this.getAge() 
		+ " years old and is  male: " + this.getIsMale() 
		+ " and has day salary: " + this.getDaySalary() + ".");
	}
	
	String calculateOvertime(double hours){
		if(this.getAge() < 18){
			this.overTime = 0;
		}else{
			this.overTime = hours * (this.getDaySalary()/8) * 1.5;
		}
		return "Amount of money owed for work after hours to worker " + this.getName() + " is " + overTime + ".";
	}
	
}
