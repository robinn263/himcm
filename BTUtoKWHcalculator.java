import java.util.Scanner;

public class BTUtoKWHcalculator {


	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the sq ft");
		double userIn = sc.nextDouble();
		
		System.out.println("climate zone");
		double zone = sc.nextDouble();
		
		System.out.println("family size");
		double f = sc.nextDouble();
		
		double refrigeration = 0;
		double clothesWasher = 0;
		double clothesDryer = 0;
		double microwave = 0;
		double oven = 0;
		double waterHeating = f * 4000;
		
		double dishwasher = 1800 * 2;
		
		double tech = (125 * 24 * f) + (30 * 8 * f) + (4 * 8 * f);
		
		
		if (f >= 4) {
			refrigeration = 700 * 24;
			clothesWasher = 900 * 2;
			clothesDryer = 3000 * 2;
			microwave = 900 * 0.25;
			oven = 3000;
		
		
		}
		
		
		if (f < 4) {
			refrigeration = 450 * 24;
			clothesWasher = 900;
			clothesDryer = 3000;
			microwave = 900 * 0.5;
			oven = 3000 * 2;
		}
		
		double dailyKWatts = refrigeration+clothesWasher+clothesDryer+microwave+oven+waterHeating+dishwasher+tech;
		System.out.println("Yearly KWatts:"+(dailyKWatts/1000)*365);
		
		double BTUtoHeat = 30 + 5*(1-zone);
		
		//to heat for one year
		double WtoHeat = ((BTUtoHeat*0.293)*(24*zone*30))/1000;
		
		double KWtoCool = (3500 * 24 * 30 * zone)/1000;
		
		System.out.println(WtoHeat);

	}
	
}