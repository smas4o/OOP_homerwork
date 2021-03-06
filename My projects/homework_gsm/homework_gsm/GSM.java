package homework_gsm;

public class GSM {
	
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;
	
	//metod za proverka na sim karata i mobilnia nomer
	void insertSimCard(String simMobileNumber){
		
		if(simMobileNumber != null){
			
			if(simMobileNumber.length() == 10 && simMobileNumber.startsWith("08")){
				
				this.simMobileNumber = simMobileNumber;
				this.hasSimCard = true;
				
			}
		}
		
	}
	
	//metod za premahvane na sim kartata
	void removeSimCard(){
		
		this.hasSimCard = false;
		this.simMobileNumber = "";
		
	}
	
	//metod za provejdane na razgovor
	void call(GSM receiver, int duration){
		
		if((receiver != null) && (receiver.hasSimCard)){
			
			if(duration > 0 && duration <= 60){
				
				if(this.hasSimCard && !this.simMobileNumber.equals(receiver.simMobileNumber)){
					
					if(this != receiver){
						
						Call newCall = new Call();
						newCall.caller = this;
						newCall.receiver = receiver;
						newCall.duration = duration;
						
						this.lastOutgoingCall = newCall;
						receiver.lastIncomingCall = newCall;
						this.outgoingCallsDuration += duration;
						
					}
				}
				
			}
		}
	}
	
	//metod za izchislenie na obshtata suma ot vsichki razgovori
	//promenih metoda ot double na string za da izvejda prilichno suobshtenie
	//neznam dali taka da se napishe e mnogo pravilno no raboti!
	String getSumForCall(){
		
		if(lastOutgoingCall == null){
			return  "Number " + this.simMobileNumber + " has " +  0.0 + " levas.";
		}
		
		return "Number " + this.simMobileNumber + " has " +  this.outgoingCallsDuration * Call.priceForAMinute + " levas for calls.";
		
	}
	
	void printInfoForCall(Call call){
		
		if(call != null){
			System.out.println("GSM model " + call.caller.model +
					" with number " + 
					call.caller.simMobileNumber + 
					" made a call to model " +
					call.receiver.model +
					" with number " +
					call.receiver.simMobileNumber + 
					" for " + 
					call.duration + " minutes.");
			
		}
		
	}
	//metod za izhodqshtite obajdania(tuk ima oshte kakvo da se izdokusorqva!)
	void printInfoForTheLastOutgoingCall(){
		
		printInfoForCall(lastOutgoingCall);
		
	}
	
	//metod za vhodqshtite obajdania
	void printInfoForTheLastIncomingCall(){
		
		printInfoForCall(lastIncomingCall);
		
	}
	
}
