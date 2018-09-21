
/**
 * An abstract Results class that
 * holds common properties between 
 * MassStartResult and SkiingResult
 * 
 * @author Gabe Aponte
 */
abstract public class AbsResult implements IEvent{
	int finalPosition;
	double laptime1;
	double laptime2;
	double laptime3;
	double laptime4;
	double laptime5;

	public AbsResult (int finalPosition, double laptime1, double laptime2, double laptime3, double laptime4, double laptime5){
		this.finalPosition = finalPosition;
		this.laptime1 = laptime1;
		this.laptime2 = laptime2;
		this.laptime3 = laptime3;
		this.laptime4 = laptime4;
		this.laptime5 = laptime5;	
	}
}