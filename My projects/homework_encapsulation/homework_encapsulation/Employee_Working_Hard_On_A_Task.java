package homework_encapsulation;

import java.util.Scanner;

public class Employee_Working_Hard_On_A_Task {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Task homework = new Task("OOP homework", 15);
		
		Employee spas = new Employee("Spas");
		
		//spas shte zapochne zadachata
		spas.setCurrentTask(homework);
		
		System.out.print("Enter the length of the workday for " + spas.getNameEmployee() + ":");
		spas.setHoursLeftForToday(sc.nextInt());
		
		spas.work();
		
		spas.showReport();
		
		Employee alex = new Employee("Alexandur");
		
		//alex shte dovurshi zadachata
		alex.setCurrentTask(homework);
		
		System.out.print("Enter the length of the workday for " + alex.getNameEmployee() + ":");
		alex.setHoursLeftForToday(sc.nextInt());
		
		alex.work();
		
		alex.showReport();
		
		//dopulnitelna proverka dali raboti vsihko izrqdno
		System.out.print("Enter the length of the workday for " + spas.getNameEmployee() + ":");
		spas.setHoursLeftForToday(sc.nextInt());
		
		spas.work();
		
		spas.showReport();
		
	}
	
}
