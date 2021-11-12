

import java.util.*;

public class Model1a {
	public static void main(String[] args) {
		continous();
	}

	public static void continous () {
		//this is where kWh would go for continuous (100 is a place holder)
		double continuouskWh = 448.19*365;
		double solarPanelPower = 2.5;
		
		//initializing variables
		double hoursOfCharge = 0;

		//ask user their climate, for now we will just say 5
		double climate = 5;
		//hours of sun for each climate
		
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
		
		//how long each battery will take to charge fully 
				double DSTimeToCharge = 1.18 / (solarPanelPower*hoursOfCharge) * 2;
				double TTimeToCharge = 2.5 / (solarPanelPower*hoursOfCharge) * 2;
				double DTimeToCharge = 7.4 / (solarPanelPower*hoursOfCharge) * 2;
				double ETimeToCharge = 10 / (solarPanelPower*hoursOfCharge) * 2;
				double PTimeToCharge = 13.5 / (solarPanelPower*hoursOfCharge) * 2;
		
		//figuring out equation for the Deka Solar
		double DSkwhPerCycle = 1.18;
		double DScyclePerLife = 1000;
		double DScostReplacement = 3375;
		double DSbaseCost = 433;
		double DStotalCycles = continuouskWh / DSkwhPerCycle;
		double DSnumReplaced = DStotalCycles / DScyclePerLife;
		double DSreplacementCost = DScostReplacement*DSnumReplaced;
		double DSbatteryOneUnRound = Math.round((DSbaseCost+DSreplacementCost)*100);
		double DSbatteryOne = DSbatteryOneUnRound/100;
		
		//figuring out the equation for the Trojan
		double TkwhPerCycle = 2.5;
		double TcyclePerLife = 500;
		double TcostReplacement = 3300;
		double TbaseCost = 1042;
		double TtotalCycles = continuouskWh / TkwhPerCycle;
		double TnumReplaced = TtotalCycles / TcyclePerLife;
		double TreplacementCost = TcostReplacement*TnumReplaced;
		double TbatteryOneUnRound = Math.round((TbaseCost+TreplacementCost)*100);
		double TbatteryOne = TbatteryOneUnRound/100;
		
		//figuring out the equation for the Discover
		double DkwhPerCycle = 7.4;
		double DcyclePerLife = 7100;
		double DcostReplacement = 0;
		double DbaseCost = 6503;
		double DtotalCycles = continuouskWh / DkwhPerCycle;
		double DnumReplaced = DtotalCycles / DcyclePerLife;
		double DreplacementCost = DcostReplacement*DnumReplaced;
		double DbatteryOneUnRound = Math.round((DbaseCost+DreplacementCost)*100);
		double DbatteryOne = DbatteryOneUnRound/100;
		
		//figuring out the equation for the Electriq
		double EkwhPerCycle = 10;
		double EcyclePerLife = 71000;
		double EcostReplacement = 0;
		double EbaseCost = 13025;
		double EtotalCycles = continuouskWh / EkwhPerCycle;
		double EnumReplaced = EtotalCycles / EcyclePerLife;
		double EreplacementCost = EcostReplacement*EnumReplaced;
		double EbatteryOneUnRound = Math.round((EbaseCost+EreplacementCost)*100);
		double EbatteryOne = EbatteryOneUnRound/100;
		
		//figuring out the equation for the Powerwall+ *check cycles per life*
		double PkwhPerCycle = 13.5;
		double PcyclePerLife = 10000000;
		double PcostReplacement = 0;
		double PbaseCost = 13500;
		double PtotalCycles = continuouskWh / PkwhPerCycle;
		double PnumReplaced = PtotalCycles / PcyclePerLife;
		double PreplacementCost = PcostReplacement*PnumReplaced;
		double PbatteryOneUnRound = Math.round((PbaseCost+PreplacementCost)*100);
		double PbatteryOne = PbatteryOneUnRound/100;
		
		//if able to charge
		System.out.println(DSbatteryOne + ", " + TbatteryOne + ", " + DbatteryOne + ", " + EbatteryOne + ", " + PbatteryOne);
		
		
		if (DSTimeToCharge <= hoursOfCharge || TTimeToCharge <= hoursOfCharge || DTimeToCharge <= hoursOfCharge || ETimeToCharge <= hoursOfCharge || PTimeToCharge <= hoursOfCharge) {
			double[] findMin = {DSbatteryOne, TbatteryOne, DbatteryOne, EbatteryOne, PbatteryOne};
			Arrays.sort(findMin);
			System.out.println("minimum: " + findMin[0]);
			if (DSbatteryOne<TbatteryOne && DSbatteryOne<DbatteryOne && DSbatteryOne<EbatteryOne && DSbatteryOne<PbatteryOne) {
			System.out.println("Deka Solar 8GCC2 6V 198");
		}
		else if (TbatteryOne<DSbatteryOne && TbatteryOne<DbatteryOne && TbatteryOne<EbatteryOne && TbatteryOne<PbatteryOne) {
		System.out.println("Trojan L-16 -SPRE 6V 415");
		}
		else if (DbatteryOne<DSbatteryOne && DbatteryOne<TbatteryOne && DbatteryOne<EbatteryOne && DbatteryOne<PbatteryOne) {
		System.out.println("Discover AES 7.4 kWh");
		}
		else if (EbatteryOne<DSbatteryOne && EbatteryOne<TbatteryOne && EbatteryOne<DbatteryOne && EbatteryOne<PbatteryOne) {
			System.out.println("Electriq PowerPod 2");
		}
		else if (PbatteryOne<DSbatteryOne && PbatteryOne<TbatteryOne && PbatteryOne<DbatteryOne && PbatteryOne<EbatteryOne) {
			System.out.println("Tesla Powerwall+");
		}
	}
	}
	
}
