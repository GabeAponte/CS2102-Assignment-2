
/**
 * A class that holds the properties
 * and methods for the competition object
 * 
 * @author Gabe Aponte
 */
import java.util.LinkedList;
class Competition {
	int numOfShootingRounds;
	LinkedList<Athlete> theAthletes;

	Competition(int numOfShootingRounds, LinkedList<Athlete> theAthletes){
		this.numOfShootingRounds = numOfShootingRounds;
		this.theAthletes = theAthletes;
	}

	/**
	 * this is the shootingDNF method. 
	 * It produces a list of athletes who didn't finish
	 * all the shooting rounds by comparing their rounds 
	 * to the total amount of rounds in the competition
	 * 
	 * @return LinkedList<String>  a linked list of the athletes who dnf'd
	 */
	LinkedList<String> shootingDNF(){
		LinkedList<String> listOfNames = new LinkedList <String>();
		for(Athlete a : theAthletes) {
			if (a.finalRes.shootRes.theRounds.size() < numOfShootingRounds) {
				listOfNames.add(a.name);
			}
		}
		return listOfNames;
	}

	/**
	 * the finalScoreForAthlete takes in the name of an athlete
	 * and produces the final score for the athlete with that name
	 * 
	 * @param name  the name of the athlete
	 * @return double  a double representing the final score for the athlete 
	 */
	double finalScoreForAthlete(String name){
		Athlete desiredName = null;
		for (Athlete a : theAthletes){
			if (a.name.equals(name)) {
				desiredName = a;
			}
		}
		return desiredName.finalRes.finalScore();
	}

	/**
	 * the anyImprovement method consumes a given competition and 
	 * compares it to another competition and sees if an athlete had 
	 * any improvement 
	 *  
	 * @param anothComp  the given competition used to compare to another competition
	 * @return true or false  a boolean value indicating if the athlete had any improvement
	 */
	
	boolean anyImprovement(Competition anothComp) {
		for (Athlete a : theAthletes) {
			for (Athlete a2 : anothComp.theAthletes) {
				if (a.name.equals(a2.name) && (a.finalRes.finalScore() < a2.finalRes.finalScore())) {
					return true;
				}
			}
		}
		return false;
	}
}

/*
 * If we were to make changes to the code to be more simpler and efficient, we could add 
 * a helper method for looking up a name of one of the competitors. Also, the nested for loop 
 * could be replaced and simplified by a helper function.
 */