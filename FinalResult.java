
/**
 * A class that holds the properties 
 * and methods for the FinalReult object
 * 
 * @author Gabe Aponte
 */
class FinalResult {
	ShootingResult shootRes;
	SkiingResult skiiRes;

	FinalResult (ShootingResult shootRes, SkiingResult skiiRes){
		this.shootRes = shootRes;
		this.skiiRes = skiiRes;
	}

	/**
	 * this is the getShootingPenalties method. It takes in a ShootingResult
	 * object and adds 60 seconds to each target (out of five) missed during each round. 
	 * 
	 * @param shootRes  a ShootingResult object used to get the amount of targets hit for calculations
	 * @return double  a double representing the shooting penalties 
	 */
	public double getShootingPenalties(ShootingResult shootRes){
		return (60 * (20 - shootRes.pointsEarned()));
	}

	/**
	 * this is the finalScore method. It sets the local variable time equal to a new time which takes 
	 * into account penalties and adds it to the points earned while skiing. It then edits the 
	 * time based on which position the athlete came in for skiing and therefore produces the final score 
	 * 
	 * @return double  a double representing the final score
	 */
	public double finalScore() {
		double time = (this.skiiRes.pointsEarned() + this.getShootingPenalties(this.shootRes));
		if(this.skiiRes.finalPosition == 1) {
			time = time-10;
		}
		if(this.skiiRes.finalPosition == 2) {
			time = time-7;
		}
		if(this.skiiRes.finalPosition == 3) {
			time = time-3;
		}
		return time;
	}
}
