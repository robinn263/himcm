package introduction;

import java.util.*;
import java.util.Scanner;

public class Model1a {
	public static void main(String[] args) {
		Scanner userInput  = new Scanner(System.in);
		System.out.println("How much continous energy do you use? (please do this in kWh)");
		double continuouskWh = userInput.nextDouble();
		
		System.out.println("How much instantaneous energy do you use? (please do this in kWh)");
		double instantaneouskWh = userInput.nextDouble();
		
		System.out.println("What power output do your solar pannels have? (please do this in kWh)");
		double solarPanelPower = userInput.nextDouble();

		System.out.println("What climate zone are you in?");
		System.out.println("climate zone: ");
		double climate = userInput.nextDouble();
		
		userInput.close();
		
		//initializing variables
		double hoursOfCharge = 0;

		//hours of sun for each climate zone
		if (climate==1) {
			hoursOfCharge = 2927.0;
		}
		else if (climate==2) {
			hoursOfCharge = 2626.0;
		}
		else if (climate==3) {
			hoursOfCharge = 2928.9;
		}
		else if (climate==4) {
			hoursOfCharge =2682.2;
		}
		else if (climate==5) {
			hoursOfCharge = 3524.3;
		}
		else if (climate==6) {
			hoursOfCharge = 2677.2;
		}
		else if (climate==7) {
			hoursOfCharge =2722.7;
		}
		
		//how long each battery will take to charge fully (10 is a place holder)
				double DSTimeToCharge = 1.18 / (solarPanelPower*hoursOfCharge) * 2;
				double TTimeToCharge = 2.5 / (solarPanelPower*hoursOfCharge) * 2;
				double DTimeToCharge = 7.4 / (solarPanelPower*hoursOfCharge) * 2;
				double ETimeToCharge = 10 / (solarPanelPower*hoursOfCharge) * 2;
				double PTimeToCharge = 13.5 / (solarPanelPower*hoursOfCharge) * 2;
		
		//figuring out equation for the Deka Solar
		double CDSkwhPerCycle = 0.049*24;
		double CDScyclePerLife = 1000;
		double CDScostReplacement = 3375;
		double CDSbaseCost = 433;
		double CDStotalCycles = continuouskWh / CDSkwhPerCycle;
		double CDSnumReplaced = CDStotalCycles / CDScyclePerLife;
		double CDSreplacementCost = CDScostReplacement*CDSnumReplaced;
		double CDSbatteryCostUnRound = Math.round((CDSbaseCost+CDSreplacementCost)*100);
		double CDSbatteryCost = CDSbatteryCostUnRound/100;
		double CDSbatteryTotal = continuouskWh/CDSkwhPerCycle;
		double CDSbatteryTotalCostUnRound=Math.round(CDSbatteryTotal*CDSbatteryCost*100);
		double CDSbatteryTotalCost=CDSbatteryTotalCostUnRound/100;
		double CDSbatteryNumUnRound =Math.round(CDSbatteryTotalCost/CDSbatteryCost);
		double CDSbatteryNum =CDSbatteryNumUnRound; 
		double CDSbatteryTotalCostFinal=CDSbatteryNum * CDSbatteryCost;
		
		//figuring out the equation for the Trojan
		double CTkwhPerCycle = 0.19*24;
		double CTcyclePerLife = 500;
		double CTcostReplacement = 3300;
		double CTbaseCost = 1042;
		double CTtotalCycles = continuouskWh / CTkwhPerCycle;
		double CTnumReplaced = CTtotalCycles / CTcyclePerLife;
		double CTreplacementCost = CTcostReplacement*CTnumReplaced;
		double CTbatteryCostUnRound = Math.round((CTbaseCost+CTreplacementCost)*100);
		double CTbatteryCost = CTbatteryCostUnRound/100;
		double CTbatteryTotal = continuouskWh/CDSkwhPerCycle;
		double CTbatteryTotalCostUnRound=Math.round(CTbatteryTotal*CTbatteryCost*100);
		double CTbatteryTotalCost=CTbatteryTotalCostUnRound/100;
		double CTbatteryNumUnRound =Math.round(CTbatteryTotalCost/CTbatteryCost);
		double CTbatteryNum =CTbatteryNumUnRound; 
		double CTbatteryTotalCostFinal=CTbatteryNum * CTbatteryCost;
		
		//figuring out the equation for the Discover
		double CDkwhPerCycle = 6.65*24;
		double CDcyclePerLife = 7100;
		double CDcostReplacement = 6503;
		double CDbaseCost = 6503;
		double CDtotalCycles = continuouskWh / CDkwhPerCycle;
		double CDnumReplaced = CDtotalCycles / CDcyclePerLife;
		double CDreplacementCost = CDcostReplacement*CDnumReplaced;
		double CDbatteryCostUnRound = Math.round((CDbaseCost+CDreplacementCost)*100);
		double CDbatteryCost = CDbatteryCostUnRound/100;
		double CDbatteryTotal = continuouskWh/CDkwhPerCycle;
		double CDbatteryTotalCostUnRound=Math.round(CDbatteryTotal*CDbatteryCost*100);
		double CDbatteryTotalCost=CDbatteryTotalCostUnRound/100;
		double CDbatteryNumUnRound =Math.round(CDbatteryTotalCost/CDbatteryCost);
		double CDbatteryNum =CDbatteryNumUnRound; 
		double CDbatteryTotalCostFinal=CDbatteryNum * CDbatteryCost;
		
		//figuring out the equation for the Electriq
		double CEkwhPerCycle = 7.6*24;
		double CEcyclePerLife = 71000;
		double CEcostReplacement = 13025;
		double CEbaseCost = 13025;
		double CEtotalCycles = continuouskWh / CEkwhPerCycle;
		double CEnumReplaced = CEtotalCycles / CEcyclePerLife;
		double CEreplacementCost = CEcostReplacement*CEnumReplaced;
		double CEbatteryCostUnRound = Math.round((CEbaseCost+CEreplacementCost)*100);
		double CEbatteryCost = CEbatteryCostUnRound/100;
		double CEbatteryTotal = continuouskWh/CEkwhPerCycle;
		double CEbatteryTotalCostUnRound=Math.round(CEbatteryTotal*CEbatteryCost*100);
		double CEbatteryTotalCost=CEbatteryTotalCostUnRound/100;
		double CEbatteryNumUnRound =Math.round(CEbatteryTotalCost/CEbatteryCost);
		double CEbatteryNum =CEbatteryNumUnRound; 
		double CEbatteryTotalCostFinal=CEbatteryNum * CEbatteryCost;
		
		//figuring out the equation for the Powerwall+ *check cycles per life*
		double CPkwhPerCycle = 7*24;
		double CPcyclePerLife = 10000000;
		double CPcostReplacement = 13500;
		double CPbaseCost = 13500;
		double CPtotalCycles = continuouskWh / CPkwhPerCycle;
		double CPnumReplaced = CPtotalCycles / CPcyclePerLife;
		double CPreplacementCost = CPcostReplacement*CPnumReplaced;
		double CPbatteryCostUnRound = Math.round((CPbaseCost+CPreplacementCost)*100);
		double CPbatteryCost = CPbatteryCostUnRound/100;
		double CPbatteryTotal = continuouskWh/CPkwhPerCycle;
		double CPbatteryTotalCostUnRound=Math.round(CPbatteryTotal*CPbatteryCost*100);
		double CPbatteryTotalCost=CPbatteryTotalCostUnRound/100;
		double CPbatteryNumUnRound =Math.round(CPbatteryTotalCost/CPbatteryCost);
		double CPbatteryNum =CPbatteryNumUnRound;
		double CPbatteryTotalCostFinal=CPbatteryNum * CPbatteryCost;
		
		//if able to charge
		if (DSTimeToCharge <= hoursOfCharge || TTimeToCharge <= hoursOfCharge || DTimeToCharge <= hoursOfCharge || ETimeToCharge <= hoursOfCharge || PTimeToCharge <= hoursOfCharge) {
			
		if (CDSbatteryTotalCost<CTbatteryTotalCost && CDSbatteryTotalCost<CDbatteryTotalCost && CDSbatteryTotalCost<CEbatteryTotalCost && CDSbatteryTotalCost<CPbatteryTotalCost) {
			System.out.println("the best continous battery for you is the: Deka Solar 8GCC2 6V 198");
			System.out.println("You would have to buy: " + CDSbatteryNum + " batteries.");
		}
		else if (CTbatteryTotalCost<CDSbatteryTotalCost && CTbatteryTotalCost<CDbatteryTotalCost && CTbatteryTotalCost<CEbatteryTotalCost && CTbatteryTotalCost<CPbatteryTotalCost) {
			System.out.println("the best continous battery for you is the: Trojan L-16 -SPRE 6V 415");
			System.out.println("You would have to buy: " + CTbatteryNum + " batteries.");
		}
		else if (CDbatteryTotalCost<CDSbatteryTotalCost && CDbatteryTotalCost<CTbatteryTotalCost && CDbatteryTotalCost<CEbatteryTotalCost && CDbatteryTotalCost<CPbatteryTotalCost) {
			System.out.println("the best continous battery for you is the: Discover AES 7.4 kWh");
			System.out.println("You would have to buy: " + CDbatteryNum + " batteries.");
		}
		else if (CEbatteryTotalCost<CDSbatteryTotalCost && CEbatteryTotalCost<CTbatteryTotalCost && CEbatteryTotalCost<CDbatteryTotalCost && CEbatteryTotalCost<CPbatteryTotalCost) {
			System.out.println("the best continous battery for you is the: Electriq PowerPod 2");
			System.out.println("You would have to buy: " + CEbatteryNum + " batteries.");
		}
		else if (CPbatteryTotalCost<CDSbatteryTotalCost && CPbatteryTotalCost<CTbatteryTotalCost && CPbatteryTotalCost<CDbatteryTotalCost && CPbatteryTotalCost<CEbatteryTotalCost) {
			System.out.println("the best continous battery for you is the: Tesla Powerwall+");
			System.out.println("You would have to buy: " + CPbatteryNum + " batteries.");
		}
		double[] findMin = {CDSbatteryTotalCostFinal, CTbatteryTotalCostFinal, CDbatteryTotalCostFinal, CEbatteryTotalCostFinal, CPbatteryTotalCostFinal};
			Arrays.sort(findMin);
			System.out.println("your expected price will be: $" + findMin[0] +
					" ");
	}

	

		// figuring out the equation for the Discover
		double IDkwhPerCycle = 14.4*24;
		double IDcyclePerLife = 7100;
		double IDcostReplacement = 0;
		double IDbaseCost = 6503;
		double IDtotalCycles = instantaneouskWh / IDkwhPerCycle;
		double IDnumReplaced = IDtotalCycles / IDcyclePerLife;
		double IDreplacementCost = IDcostReplacement * IDnumReplaced;
		double IDbatteryCostUnRound = Math.round((IDbaseCost+IDreplacementCost)*100);
		double IDbatteryCost = IDbatteryCostUnRound/100;
		double IDbatteryTotal = continuouskWh/IDkwhPerCycle;
		double IDbatteryTotalCostUnRound=Math.round(IDbatteryTotal*IDbatteryCost*100);
		double IDbatteryTotalCost=IDbatteryTotalCostUnRound/100;
		double IDbatteryNumUnRound =Math.round(IDbatteryTotalCost/IDbatteryCost);
		double IDbatteryNum =IDbatteryNumUnRound;
		double IDbatteryTotalCostFinal=IDbatteryNum * IDbatteryCost;

		// figuring out the equation for the Electriq
		double IEkwhPerCycle = 9*24;
		double IEcyclePerLife = 71000;
		double IEcostReplacement = 0;
		double IEbaseCost = 13025;
		double IEtotalCycles = instantaneouskWh / IEkwhPerCycle;
		double IEnumReplaced = IEtotalCycles / IEcyclePerLife;
		double IEreplacementCost = IEcostReplacement * IEnumReplaced;
		double IEbatteryCostUnRound = Math.round((IEbaseCost+IEreplacementCost)*100);
		double IEbatteryCost = IEbatteryCostUnRound/100;
		double IEbatteryTotal = continuouskWh/IEkwhPerCycle;
		double IEbatteryTotalCostUnRound=Math.round(IEbatteryTotal*IEbatteryCost*100);
		double IEbatteryTotalCost=IEbatteryTotalCostUnRound/100;
		double IEbatteryNumUnRound =Math.round(IEbatteryTotalCost/IEbatteryCost);
		double IEbatteryNum =IEbatteryNumUnRound;
		double IEbatteryTotalCostFinal=IEbatteryNum * IEbatteryCost;

		// figuring out the equation for the Powerwall+ *check cycles per life*
		double IPkwhPerCycle = 10*24;
		double IPcyclePerLife = 10000000;
		double IPcostReplacement = 0;
		double IPbaseCost = 13500;
		double IPtotalCycles = instantaneouskWh / IPkwhPerCycle;
		double IPnumReplaced = IPtotalCycles / IPcyclePerLife;
		double IPreplacementCost = IPcostReplacement * IPnumReplaced;
		double IPbatteryCostUnRound = Math.round((IPbaseCost+IPreplacementCost)*100);
		double IPbatteryCost = IPbatteryCostUnRound/100;
		double IPbatteryTotal = continuouskWh/IPkwhPerCycle;
		double IPbatteryTotalCostUnRound=Math.round(IPbatteryTotal*IPbatteryCost*100);
		double IPbatteryTotalCost=IPbatteryTotalCostUnRound/100;
		double IPbatteryNumUnRound =Math.round(IPbatteryTotalCost/IPbatteryCost);
		double IPbatteryNum =IPbatteryNumUnRound;
		double IPbatteryTotalCostFinal=IPbatteryNum * IPbatteryCost;
		
		// if able to charge
		if (DTimeToCharge <= hoursOfCharge || ETimeToCharge <= hoursOfCharge || PTimeToCharge <= hoursOfCharge) {
			
			 if (IDbatteryTotalCost < IEbatteryTotalCost && IDbatteryTotalCost < IPbatteryTotalCost) {
				System.out.println("the best instantaneous battery for you is the: Discover AES 7.4 kWh");
				System.out.println("You would have to buy: " + IDbatteryNum + " batteries.");
				
			} else if (IEbatteryTotalCost < IDbatteryTotalCost && IEbatteryTotalCost < IPbatteryTotalCost) {
				System.out.println("the best instantaneous battery for you is the: Electriq PowerPod 2");
				System.out.println("You would have to buy: " + IEbatteryNum + " batteries.");
				
			} else if (IPbatteryTotalCost < IDbatteryTotalCost && IPbatteryTotalCost < IEbatteryTotalCost) {
				System.out.println("the best instantaneous battery for you is the: Tesla Powerwall+");
				System.out.println("You would have to buy: " + IPbatteryNum + " batteries.");
				
			}
			 
			 double[] findMin = {IDbatteryTotalCostFinal,IEbatteryTotalCostFinal, IPbatteryTotalCostFinal};
			Arrays.sort(findMin);
			
			System.out.println("your expected price will be: $" + findMin[0] +
					" ");
	}
		//System.out.println(CDSbatteryTotalCost + "," + CTbatteryTotalCost + "," + CDbatteryTotalCost + "," + CEbatteryTotalCost + "," + CPbatteryTotalCost);
		//System.out.println(IDbatteryTotalCost + "," + IEbatteryTotalCost + "," + IPbatteryTotalCost);
	
	}
	
	
}