package introduction;

import java.util.*;
import java.util.Scanner;

public class Model1a {
	public static void main(String[] args) {
		Scanner userImput  = new Scanner(System.in);
		System.out.println("How much continous energy do you use? (please do this in kWh)");
		double continuouskWh = userImput.nextDouble();
		
		System.out.println("How much instantaneous energy do you use? (please do this in kWh)");
		double instantaneouskWh = userImput.nextDouble();
		
		System.out.println("What power output do your solar pannels have? (please do this in kWh)");
		double solarPanelPower = userImput.nextDouble();

		System.out.println("What climate zone are you in?");
		System.out.println("climate zone: ");
		double climate = userImput.nextDouble();
		
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
		double CDSkwhPerCycle = 1.18;
		double CDScyclePerLife = 1000;
		double CDScostReplacement = 3375;
		double CDSbaseCost = 433;
		double CDStotalCycles = continuouskWh / CDSkwhPerCycle;
		double CDSnumReplaced = CDStotalCycles / CDScyclePerLife;
		double CDSreplacementCost = CDScostReplacement*CDSnumReplaced;
		double CDSbatteryOneUnRound = Math.round((CDSbaseCost+CDSreplacementCost)*100);
		double CDSbatteryOne = CDSbatteryOneUnRound/100;
		
		//figuring out the equation for the Trojan
		double CTkwhPerCycle = 2.5;
		double CTcyclePerLife = 500;
		double CTcostReplacement = 3300;
		double CTbaseCost = 1042;
		double CTtotalCycles = continuouskWh / CTkwhPerCycle;
		double CTnumReplaced = CTtotalCycles / CTcyclePerLife;
		double CTreplacementCost = CTcostReplacement*CTnumReplaced;
		double CTbatteryOneUnRound = Math.round((CTbaseCost+CTreplacementCost)*100);
		double CTbatteryOne = CTbatteryOneUnRound/100;
		
		//figuring out the equation for the Discover
		double CDkwhPerCycle = 7.4;
		double CDcyclePerLife = 7100;
		double CDcostReplacement = 6503;
		double CDbaseCost = 6503;
		double CDtotalCycles = continuouskWh / CDkwhPerCycle;
		double CDnumReplaced = CDtotalCycles / CDcyclePerLife;
		double CDreplacementCost = CDcostReplacement*CDnumReplaced;
		double CDbatteryOneUnRound = Math.round((CDbaseCost+CDreplacementCost)*100);
		double CDbatteryOne = CDbatteryOneUnRound/100;
		
		//figuring out the equation for the Electriq
		double CEkwhPerCycle = 10;
		double CEcyclePerLife = 71000;
		double CEcostReplacement = 13025;
		double CEbaseCost = 13025;
		double CEtotalCycles = continuouskWh / CEkwhPerCycle;
		double CEnumReplaced = CEtotalCycles / CEcyclePerLife;
		double CEreplacementCost = CEcostReplacement*CEnumReplaced;
		double CEbatteryOneUnRound = Math.round((CEbaseCost+CEreplacementCost)*100);
		double CEbatteryOne = CEbatteryOneUnRound/100;
		
		//figuring out the equation for the Powerwall+ *check cycles per life*
		double CPkwhPerCycle = 13.5;
		double CPcyclePerLife = 10000000;
		double CPcostReplacement = 13500;
		double CPbaseCost = 13500;
		double CPtotalCycles = continuouskWh / CPkwhPerCycle;
		double CPnumReplaced = CPtotalCycles / CPcyclePerLife;
		double CPreplacementCost = CPcostReplacement*CPnumReplaced;
		double CPbatteryOneUnRound = Math.round((CPbaseCost+CPreplacementCost)*100);
		double CPbatteryOne = CPbatteryOneUnRound/100;
		
		//if able to charge		
		if (DSTimeToCharge <= hoursOfCharge || TTimeToCharge <= hoursOfCharge || DTimeToCharge <= hoursOfCharge || ETimeToCharge <= hoursOfCharge || PTimeToCharge <= hoursOfCharge) {
			
		if (CDSbatteryOne<CTbatteryOne && CDSbatteryOne<CDbatteryOne && CDSbatteryOne<CEbatteryOne && CDSbatteryOne<CPbatteryOne) {
			System.out.println("the best continous battery for you is the: Deka Solar 8GCC2 6V 198");
		}
		else if (CTbatteryOne<CDSbatteryOne && CTbatteryOne<CDbatteryOne && CTbatteryOne<CEbatteryOne && CTbatteryOne<CPbatteryOne) {
		System.out.println("the best continous battery for you is the: Trojan L-16 -SPRE 6V 415");
		}
		else if (CDbatteryOne<CDSbatteryOne && CDbatteryOne<CTbatteryOne && CDbatteryOne<CEbatteryOne && CDbatteryOne<CPbatteryOne) {
		System.out.println("the best continous battery for you is the: Discover AES 7.4 kWh");
		}
		else if (CEbatteryOne<CDSbatteryOne && CEbatteryOne<CTbatteryOne && CEbatteryOne<CDbatteryOne && CEbatteryOne<CPbatteryOne) {
			System.out.println("the best continous battery for you is the: Electriq PowerPod 2");
		}
		else if (CPbatteryOne<CDSbatteryOne && CPbatteryOne<CTbatteryOne && CPbatteryOne<CDbatteryOne && CPbatteryOne<CEbatteryOne) {
			System.out.println("the best continous battery for you is the: Tesla Powerwall+");
		}
		double[] findMin = {CDSbatteryOne, CTbatteryOne, CDbatteryOne, CEbatteryOne, CPbatteryOne};
			Arrays.sort(findMin);
			System.out.println("your expected price will be: $" + findMin[0]);
	}

		// initializing variables
		double IhoursOfCharge = 0;

		// hours of sun for each climate zone
		if (climate == 1) {
			hoursOfCharge = 2927.0;
		} else if (climate == 2) {
			hoursOfCharge = 2626.0;
		} else if (climate == 3) {
			hoursOfCharge = 2928.9;
		} else if (climate == 4) {
			hoursOfCharge = 2682.2;
		} else if (climate == 5) {
			hoursOfCharge = 3524.3;
		} else if (climate == 6) {
			hoursOfCharge = 2677.2;
		} else if (climate == 7) {
			hoursOfCharge = 2722.7;
		}


		// figuring out equation for the Deka Solar
		double IDSkwhPerCycle = 1.18;
		double IDScyclePerLife = 1000;
		double IDScostReplacement = 3375;
		double IDSbaseCost = 433;
		double IDStotalCycles = instantaneouskWh / IDSkwhPerCycle;
		double IDSnumReplaced = IDStotalCycles / IDScyclePerLife;
		double IDSreplacementCost = IDScostReplacement * IDSnumReplaced;
		double IDSbatteryOneUnRound = Math.round((IDSbaseCost + IDSreplacementCost) * 100);
		double IDSbatteryOne = IDSbatteryOneUnRound / 100;

		// figuring out the equation for the Trojan
		double ITkwhPerCycle = 2.5;
		double ITcyclePerLife = 500;
		double ITcostReplacement = 3300;
		double ITbaseCost = 1042;
		double ITtotalCycles = instantaneouskWh / ITkwhPerCycle;
		double ITnumReplaced = ITtotalCycles / ITcyclePerLife;
		double ITreplacementCost = ITcostReplacement * ITnumReplaced;
		double ITbatteryOneUnRound = Math.round((ITbaseCost + ITreplacementCost) * 100);
		double ITbatteryOne = ITbatteryOneUnRound / 100;

		// figuring out the equation for the Discover
		double IDkwhPerCycle = 7.4;
		double IDcyclePerLife = 7100;
		double IDcostReplacement = 0;
		double IDbaseCost = 6503;
		double IDtotalCycles = instantaneouskWh / IDkwhPerCycle;
		double IDnumReplaced = IDtotalCycles / IDcyclePerLife;
		double IDreplacementCost = IDcostReplacement * IDnumReplaced;
		double IDbatteryOneUnRound = Math.round((IDbaseCost + IDreplacementCost) * 100);
		double IDbatteryOne = IDbatteryOneUnRound / 100;

		// figuring out the equation for the Electriq
		double IEkwhPerCycle = 10;
		double IEcyclePerLife = 71000;
		double IEcostReplacement = 0;
		double IEbaseCost = 13025;
		double IEtotalCycles = instantaneouskWh / IEkwhPerCycle;
		double IEnumReplaced = IEtotalCycles / IEcyclePerLife;
		double IEreplacementCost = IEcostReplacement * IEnumReplaced;
		double IEbatteryOneUnRound = Math.round((IEbaseCost + IEreplacementCost) * 100);
		double IEbatteryOne = IEbatteryOneUnRound / 100;

		// figuring out the equation for the Powerwall+ *check cycles per life*
		double IPkwhPerCycle = 13.5;
		double IPcyclePerLife = 10000000;
		double IPcostReplacement = 0;
		double IPbaseCost = 13500;
		double IPtotalCycles = instantaneouskWh / IPkwhPerCycle;
		double IPnumReplaced = IPtotalCycles / IPcyclePerLife;
		double IPreplacementCost = IPcostReplacement * IPnumReplaced;
		double IPbatteryOneUnRound = Math.round((IPbaseCost + IPreplacementCost) * 100);
		double IPbatteryOne = IPbatteryOneUnRound / 100;

		// if able to charge
		if (DTimeToCharge <= hoursOfCharge || ETimeToCharge <= hoursOfCharge || PTimeToCharge <= hoursOfCharge) {
			
			 if (IDbatteryOne < IEbatteryOne && IDbatteryOne < IPbatteryOne) {
				System.out.println("the best instantaneous battery for you is the: Discover AES 7.4 kWh");
			} else if (IEbatteryOne < IDbatteryOne && IEbatteryOne < IPbatteryOne) {
				System.out.println("the best instantaneous battery for you is the: Electriq PowerPod 2");
			} else if (IPbatteryOne < IDbatteryOne && IPbatteryOne < IEbatteryOne) {
				System.out.println("the best instantaneous battery for you is the: Tesla Powerwall+");
			}
			 
			 double[] findMin = {IDbatteryOne, IEbatteryOne, IPbatteryOne };
			Arrays.sort(findMin);
			System.out.println("your expected price will be: $" + findMin[0]);
	}
	}
}