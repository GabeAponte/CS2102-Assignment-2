
/**
 * A class that holds the properties 
 * and methods for the MassStartResult object
 * 
 * @author Gabe Aponte
 */
class MassStartResult extends AbsResult {
	int startPosition;

	MassStartResult(int startPosition, int finalPosition, double laptime1, double laptime2, double laptime3, double laptime4, double laptime5){
		super(finalPosition, laptime1, laptime2, laptime3, laptime4, laptime5);
		this.startPosition = startPosition;
	}

	/**
	 * this is the pointsEarned method. It produces the amount of points earned
	 * during the mass start event by adding the lap times together
	 * 
	 * @return double  a double representing the points earned during mass start
	 */
	@Override
	public double pointsEarned() {
		return (this.laptime1 + this.laptime2 + this.laptime3 + this.laptime4 + this.laptime5);
	}
}