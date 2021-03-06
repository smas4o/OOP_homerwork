package homework_abstraction;

import java.util.Scanner;

public class Employee_Working_Hard_On_A_Task {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Task task1 = new Task("task1",8);
		Task task2 = new Task("task2",15);
		Task task3 = new Task("task3",24);
		Task task4 = new Task("task4",32);
		Task task5 = new Task("task5",15);
		Task task6 = new Task("task6",24);
		Task task7 = new Task("task7",32);
		Task task8 = new Task("task8",40);
		Task task9 = new Task("task9",8);
		Task task10 = new Task("task10",16);
		
		AllWork tasks = new AllWork();
		tasks.addTask(task1);
		tasks.addTask(task2);
		tasks.addTask(task3);
		tasks.addTask(task4);
		tasks.addTask(task5);
		tasks.addTask(task6);
		tasks.addTask(task7);
		tasks.addTask(task8);
		tasks.addTask(task9);
		tasks.addTask(task10);
		
		Employee.setAllWork(tasks);
		
		Employee spas = new Employee("Spas");
		Employee vasil = new Employee("Vasil");
		Employee todor = new Employee("Todor");
		Employee vladi = new Employee("Vladimir");
		
		Employee[] employees = {spas, vasil, todor, vladi};
		
		//uspqh da opravq programata da ne grumva pri svurshvane na nezaetite zadachi,
		//NO ne uspqh da izmislq kak da teglqt nova zadacha kato prikluchat s tekushtata
		while(tasks.isAllWorkDone() == false){
			
			for(int i = 0; i < employees.length; i++){
				employees[i].setHoursLeftForToday(8);
				employees[i].work();
			}
			
			System.out.println("Is all work done: " + tasks.isAllWorkDone());
			System.out.println("End of working day.");
			System.out.println();
		}
	}
}
