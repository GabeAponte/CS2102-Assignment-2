
/**
 * A class that holds the properties 
 * and methods for the shooting result object
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;
class ShootingResult implements IEvent {
	LinkedList<ShootingRound> theRounds;

	ShootingResult (LinkedList <ShootingRound> theRounds){
		this.theRounds = theRounds;
	}

	/**
	 * This is the pointsEarned method which
	 * produces the sum of all the targets hit 
	 * in the list
	 * 
	 * @return counter   a local variable that holds the sum of hit targets
	 */
	@Override
	public double pointsEarned() {
		int counter = 0;
		for (ShootingRound r : theRounds) {
			counter = r.targhit + counter;
		}
		return counter;
	}

	/**
	 * This is the bestRoundByType method
	 * it produces the round from the list with the most targets hit 
	 * depending on if the user wants the best round while standing
	 * or prone
	 * 
	 * @param isStanding   a boolean value that indicates whether the user wants standing or prone
	 * @return ShootingRound   returns the round of standing or prone that is best
	 * @return null   returns null if the list is empty or doesn't have the round type that is requested
	 */
	ShootingRound bestRoundByType(boolean isStanding) {
		ShootingRound bestRoundStanding = new ShootingRound(0, true);
		ShootingRound bestRoundProne = new ShootingRound(0, false);

		boolean hasBestStanding = false;
		boolean hasBestProne = false;

		if(isStanding == true && theRounds.size() != 0) {
			for(ShootingRound r : theRounds) {
				if(r.targhit > bestRoundStanding.targhit && r.isStanding == true) {
					bestRoundStanding = r;
					hasBestStanding = true;
				}
			}
			if(!hasBestStanding) {
				return null;
			}
			return bestRoundStanding;

		} else if (isStanding == false && theRounds.size() != 0) {
			for(ShootingRound r : theRounds) {
				if(r.targhit > bestRoundProne.targhit && r.isStanding == false) {
					bestRoundProne = r;
					hasBestProne = true;
				}
			}
			if(!hasBestProne) {
				return null;
			}
			return bestRoundProne;

		} else {
			return null;
		}
	}
}
