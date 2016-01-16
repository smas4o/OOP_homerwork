package class_exercises;

import java.util.Scanner;

public class School {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Teacher elka = new Teacher("Elka", "Malenkova", 700, "Physics");
		Student spas = new Student("Spas", "Malenkov");
		Student vasil = new Student("Vasil", "Petkov");
		Student ivan = new Student("Ivan", "Vasev");
		Student maria = new Student("Maria", "Zagariova");
		Student cvetelina = new Student("Cvetelina", "Cvetanova");
		Student ivelina = new Student("Ivelina", "Chalukova");
		Student georgi = new Student("Georgi", "Georgiev");
		Student dimitur = new Student("Dimitur", "Krustev");
		Student ivanst = new Student("Ivan", "Stoyanov");
		Student zhivko = new Student("Zhivko", "Vasev");
		
		Student[] students1 = {spas, vasil, ivan, maria, cvetelina, ivelina, georgi, dimitur, ivanst, zhivko};
		
		ClassOfStudents sedmiKlas = new ClassOfStudents(elka, students1);
		
		sedmiKlas.learnInClass(30);
		
		System.out.println();
		
		printStudentsKnowledge(students1);
		
		System.out.println();
		
		homeStudy(students1);
		
		System.out.println();
		
		sedmiKlas.examInClass();
		
		System.out.println();
		
		studentsMarks(students1);
	}
	
	static void printStudentsKnowledge(Student[] students){
		for(int i = 0; i < students.length; i++){
			System.out.println(students[i].getName() + " has now " + students[i].getKnowledge());
		}
	}
	
	static void homeStudy(Student[] students){
		int knowledge;
		for(int i = 0; i < students.length; i++){
			System.out.print(students[i].getName() + " is studying - ");
			knowledge = sc.nextInt();
			students[i].StudyHome(knowledge);
			System.out.println(students[i].getName() + " now have " + students[i].getKnowledge() + " knowledge.");
		}
	}
	
	static void studentsMarks(Student[] students){
		for(int i = 0; i < students.length; i++){
			System.out.println(students[i].getName() + " have " + students[i].getMark() + " on the exam on " + students[i].getSubject() + ".");
		}
	}
}
