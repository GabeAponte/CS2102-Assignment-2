
/**
 * A class that holds the properties 
 * and methods for the athlete object
 * 
 * @author Gabe Aponte
 */
class Athlete {
	FinalResult finalRes;
	String name;

	Athlete (FinalResult finalRes, String name){ 
		this.finalRes = finalRes;
		this.name = name;
	}

	/**
	 * the betterSkiier method consumes an athlete and compares it to the other athlete, 
	 *  and produces the athlete that has the lower/better skiing score
	 *  
	 * @param aAth  the given athlete that will be compared to another athlete
	 * @return athlete  returns the athlete with a better score (either this or aAth)
	 */
	Athlete betterSkiier(Athlete aAth) {
		if(this.finalRes.skiiRes.pointsEarned() < aAth.finalRes.skiiRes.pointsEarned()) {
			return this;
		} else {
			return aAth;
		}
	}

	/**
	 * the hasBeaten method takes in an athlete and produces true if (this) athlete 
	 * has either a lower skiing score than the other athlete, or a higher shooting score 
	 * than the other athlete
	 * 
	 * @param anothAth  the given athlete that will be compared to another athlete
	 * @return true or false  a boolean value representing if the given athlete beat this athlete
	 */
	boolean hasBeaten (Athlete anothAth) {
		return (this.finalRes.skiiRes.pointsEarned() < anothAth.finalRes.skiiRes.pointsEarned() || 
				this.finalRes.shootRes.pointsEarned() > anothAth.finalRes.shootRes.pointsEarned());
	}
}
