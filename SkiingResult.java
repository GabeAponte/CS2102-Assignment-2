
/**
 * A class that holds the properties
 * and methods for the SkiingResult object
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;
class SkiingResult extends AbsResult implements IEvent {
	LinkedList<Double> lapTimes = new LinkedList<Double>();

	SkiingResult(int finalPosition, double laptime1, double laptime2, double laptime3, double laptime4, double laptime5){
		super(finalPosition, laptime1, laptime2, laptime3, laptime4, laptime5);
		lapTimes.add(laptime1);
		lapTimes.add(laptime2);
		lapTimes.add(laptime3);
		lapTimes.add(laptime4);
		lapTimes.add(laptime5);
	}
	/**
	 * this is the pointsEarned method. It finds the amount of points earned in the skiing event 
	 * by adding the five lap times in side the list together
	 * 
	 * @return points  a local variable containing the total points earned while skiing
	 */
	@Override
	public double pointsEarned() {
		double points = 0;

		for (double p : lapTimes) {
			points = points + p;
		}
		return points;
	}
}
