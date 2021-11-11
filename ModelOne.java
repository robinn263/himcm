package introduction;

public class ModelOne {
	public static void main (String[] args) {
		
		//climate is a UI
		double climate = 5;
		
		double hoursOfCharge=-1;
		double batteryCollect=10;
		double energyNeed = 50;
		double batteryType = 0;
		//sunlight per climate zone
		if (climate==5) {
			hoursOfCharge=10;
		}
		//find available energy based on amount of time with sunlight
		double energyCollected = batteryCollect * hoursOfCharge;
		
		//energy usage
		double energyUsedNeeded = energyCollected/energyNeed;
		
		if (energyUsedNeeded>1) {
			System.out.println("instant");
			batteryType = 1;
		}
		else {
			System.out.println("continuous");
			batteryType = 2;
		}
		
		//find amount of cycles, add to the battery equations
		//convert into years
		double energyUsed=1000;
		double baseCost = 425;
		double cyclePerLife = 100;
		double kwh = 100;
		double kwhPerHour=100;
		double totalCycle = kwh/kwhPerHour;

		double numReplaced = totalCycle/cyclePerLife;
		double costReplace = 100;
		
		double costTotal = baseCost + (costReplace*numReplaced);
		

		System.out.println(costTotal);
		if (batteryType == 1) {
			
			
		}
		
		else if (batteryType == 2) {
			
		}
		
		
		//charge time per battery (add in later)
		
		//hours used is a UI
		
		
	}
}
