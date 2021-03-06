package homework_abstraction;

public class Employee {
	
	private String name;
	private Task currentTask;
	private int hoursLeftForToday;
	private static AllWork allWork;
	
	
	public Employee(String name){
		setName(name);
	}
	
	
	public void work(){
		
		if(this.currentTask == null || this.currentTask.getWorkingHoursToFinishTheTask() == 0){
			this.setCurrentTask(allWork.getNextTask());
			if(this.currentTask == null){
				System.out.println("There are no free tasks for employee " + this.getName() + ".");
			}else{
				this.currentTask.freeTask = false;
				getToWork();
			}
		}
		
		else if(this.currentTask != null && this.currentTask.getWorkingHoursToFinishTheTask() != 0){
			getToWork();
		}
		
		else if(this.currentTask != null && this.currentTask.getWorkingHoursToFinishTheTask() == 0){
			this.setCurrentTask(allWork.getNextTask());
			this.currentTask.freeTask = false;
			getToWork();
		}
		
		else if(this.currentTask == null && this.getHoursLeftForToday() > 0){
			this.setCurrentTask(allWork.getNextTask());
			if(this.currentTask == null){
				System.out.println("Nqma svobodni zadachi.");
			}else{
				this.currentTask.freeTask = false;
				getToWork();
			}
		}
		
		
	}
	
	
	private void getToWork() {
		System.out.println("Employee " + this.getName() + " is working on task " + this.currentTask.getName());
		if(this.hoursLeftForToday < this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			this.getCurrentTask().setWorkingHoursToFinishTheTask(this.getCurrentTask().getWorkingHoursToFinishTheTask() - this.hoursLeftForToday);
			
			System.out.println("Hours left until finish the task: " + this.getCurrentTask().getWorkingHoursToFinishTheTask());
			return;
		}
		if(this.hoursLeftForToday > this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			this.setHoursLeftForToday(this.hoursLeftForToday - this.getCurrentTask().getWorkingHoursToFinishTheTask());
			this.getCurrentTask().setWorkingHoursToFinishTheTask(0);
			
			System.out.println("Hours left until finish the task: " + this.getCurrentTask().getWorkingHoursToFinishTheTask());
			this.setCurrentTask(null);
			return;
		}
		if(this.hoursLeftForToday == this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			this.getCurrentTask().setWorkingHoursToFinishTheTask(0);
			
			System.out.println("Hours left until finish the task: " + this.getCurrentTask().getWorkingHoursToFinishTheTask());
			this.setCurrentTask(null);
			return;
		}
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Task getCurrentTask() {
		return currentTask;
	}
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	
	public int getHoursLeftForToday() {
		return hoursLeftForToday;
	}
	public void setHoursLeftForToday(int hoursLeft) {
		hoursLeftForToday = hoursLeft;
	}
	
	
	public AllWork getAllWork(){
		return allWork;
	}
	public static void setAllWork(AllWork allwork){
		allWork = allwork;
	}
	
	
}
