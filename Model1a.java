package introduction;

public class Model1a {
	public static void main (String[] args) {
		continous();
	}
		public static void continous () {
		//this is where kWh would go for continuous (100 is a place holder)
		double continuouskWh = 100;
		
		//initializing variables
		double hoursOfCharge = 0;
		double battery1 = 0;
		//how long each battery will take to charge fully (10 is a place holder)
		double battery1TimeToCharge = 10;
		//ask user their climate, for now we will just say 5
		double climate = 5;
		//hours of sun for each climate, this needs to be done for 1-7
		if (climate==5) {
			hoursOfCharge = 10;
		}
		
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
		if (battery1TimeToCharge <= hoursOfCharge) {
			System.out.println(DSbatteryOne);
			System.out.println(TbatteryOne);
			System.out.println(DbatteryOne);
			System.out.println(EbatteryOne);
			System.out.println(PbatteryOne);
		}
	}
		
	
}