/**
 * this the the Examples class that
 * holds all the test cases for the program
 * 
 * @author Gabe Aponte
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import org.junit.Test;

public class Examples {
	
	public Examples() {}

	MassStartResult testMass = new MassStartResult (1, 2, 20.0, 19.0, 18.0, 17.0, 16.0);
	
	ShootingRound five = new ShootingRound(5, true);
	ShootingRound four = new ShootingRound(4, false);
	ShootingRound four2 = new ShootingRound(4, false);
	ShootingRound three = new ShootingRound(3, true);
	ShootingRound three2 = new ShootingRound(3, true);
	ShootingRound two = new ShootingRound(2, false);
	ShootingRound one = new ShootingRound(1, true);
	
	LinkedList <ShootingRound> ShootList = new LinkedList <ShootingRound> ();
	LinkedList <ShootingRound> ShootList2 = new LinkedList <ShootingRound> ();
	ShootingResult shootRes1 = new ShootingResult (ShootList);
	ShootingResult shootRes2 = new ShootingResult (ShootList2);
	
	SkiingResult firstSki = new SkiingResult (1, 20.0, 19.0, 18.0, 17.0, 16.0);
	SkiingResult secondSki = new SkiingResult (2, 30.0, 29.0, 28.0, 27.0, 26.0);
	SkiingResult thirdSki = new SkiingResult (3, 45.0, 44.0, 43.0, 37.0, 36.0);
	SkiingResult lastSki = new SkiingResult (6, 50.0, 49.0, 48.0, 47.0, 46.0);
	
	SkiingResult bestSki = new SkiingResult (1, 10.0, 9.0, 8.0, 7.0, 6.0);
	SkiingResult worstSki = new SkiingResult (8, 100.0, 90.0, 80.0, 70.0, 60.0);
	
	FinalResult First = new FinalResult (shootRes1, firstSki);
	FinalResult Second = new FinalResult (shootRes1, lastSki);
	FinalResult Third = new FinalResult (shootRes2, secondSki);
	FinalResult Last = new FinalResult (shootRes2, thirdSki);
	
	FinalResult Best = new FinalResult (shootRes1, bestSki);
	FinalResult Worst = new FinalResult (shootRes2, worstSki);
	
	//team roster 1
	Athlete Joe = new Athlete (First, "Joe");
	Athlete Bob = new Athlete (First, "Bob");
	Athlete Sam = new Athlete (Second, "Sam");
	Athlete Ken = new Athlete (Second, "Ken");
	
	Athlete Brian = new Athlete (Best, "Brian");
	
	//team roster 2
	Athlete Joe2 = new Athlete (Third, "Joe");
	Athlete Bob2 = new Athlete (Third, "Bob");
	Athlete Sam2 = new Athlete (Last, "Sam");
	Athlete Ken2 = new Athlete (Last, "Ken");
	
	Athlete Brian2 = new Athlete (Worst, "Brian");
	
	LinkedList <Athlete> listOfAth = new LinkedList <Athlete>();
	LinkedList <Athlete> listOfAth2 = new LinkedList <Athlete>();
	
	
	Competition tester = new Competition (4, listOfAth);
	Competition tester2 = new Competition (4, listOfAth2);
	
	LinkedList <String> listOfString = new LinkedList <String> ();
	
	@Test
	//makes sure the pointsEarned method for MassStartResult sums the lap times correctly
	public void pointsEarnedMassStartTest() {
		assertEquals(testMass.pointsEarned(), 90, .1); 
	}
	
	@Test
	//makes sure the pointsEarned method for ShootResult sums the targets hit correctly 
	public void pointsEarnedShootingTest() {
		ShootList.add(five);
		ShootList.add(one);
		ShootList.add(two);
		assertEquals(shootRes1.pointsEarned(), 8, .1);
	}
	
	@Test
	//makes sure the pointsEarned method for ShootResult returns zero for an empty list
	public void pointsEarnedShootingTest2() {
		assertEquals(shootRes1.pointsEarned(), 0, .1);
	}
	
	@Test
	//makes sure the pointsEarned method for SkiingResult sums the lap times of the list correctly
	public void pointsEarnedSkiingTest() {
		assertEquals(secondSki.pointsEarned(), 140, .1); 
	}
	
	@Test
	//makes sure the method produces the round with the highest targets hit while standing
	public void bestRoundStandingTest() {
		ShootList.add(five);
		ShootList.add(four);
		ShootList.add(three);
		assertEquals(shootRes1.bestRoundByType(true), five);
	}
	
	@Test
	//makes sure the method produces the right response when there are two of the best rounds while standing
	public void bestRoundStaningTest2() {
		ShootList.add(three);
		ShootList.add(three2);
		ShootList.add(two);
		assertEquals(shootRes1.bestRoundByType(true), three);
	}
	
	@Test
	//makes sure the method produces the right response when there are no rounds standing in the list
	public void bestRoundStaningTest3() {
		ShootList.add(four);
		ShootList.add(four2);
		ShootList.add(two);
		assertEquals(shootRes1.bestRoundByType(true), null);
	}
	
	@Test
	//makes sure the method produces the round with the highest targets hit while prone
	public void bestRoundProneTest() {
		ShootList.add(five);
		ShootList.add(four);
		ShootList.add(two);
		assertEquals(shootRes1.bestRoundByType(false), four);
	}
	
	@Test
	//makes sure the method produces the right response when there are two of the best rounds while prone
	public void bestRoundProneTest2() {
		ShootList.add(two);
		ShootList.add(four);
		ShootList.add(four2);
		assertEquals(shootRes1.bestRoundByType(false), four);
	}
	
	@Test
	//makes sure the method produces the right response when there are no prone rounds in the list
	public void bestRoundProneTest3() {
		ShootList.add(five);
		ShootList.add(three);
		ShootList.add(one);
		assertEquals(shootRes1.bestRoundByType(false), null);
	}
	
	@Test
	//makes sure the method produces the right response when the list is empty 
	public void bestRoundEmptyTest() {
		assertEquals(shootRes1.bestRoundByType(false), null);
	}
	
	//tests to make sure the calculations are done correctly 
	@Test
	public void getShootingPenaltiesTest() {
		ShootList.add(five);
		ShootList.add(three);
		ShootList.add(one);
		ShootList.add(two);
		assertEquals(First.getShootingPenalties(shootRes1), 540, .1);
	}
	
	//tests to make sure the finalScore method produces the correct calculations
	@Test
	public void finalScoreTest() {
		ShootList.add(three);
		ShootList.add(one);
		ShootList.add(five);
		ShootList.add(two);
		assertEquals(Second.finalScore(), 780, .1); 
	}

	@Test
	//tests to make sure the method produces a list in the right order of athletes who dnf'd a shooting round
	public void shootingDNFTest() {
		ShootList.add(three);
		ShootList.add(two);
		ShootList.add(four);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfString.add("Joe");
		listOfString.add("Bob");
		listOfString.add("Sam");
		listOfString.add("Ken");
		assertEquals(tester.shootingDNF(), listOfString);
	}
	
	@Test
	//tests to make sure the method produces an empty list if none of the athletes dnf'd a shooting round
	public void shootingDNFTest2() {
		ShootList.add(three);
		ShootList.add(two);
		ShootList.add(two);
		ShootList.add(five);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		assertEquals(tester.shootingDNF(), listOfString);
	}
	
	@Test
	//tests to make sure the method produces the final points earned for the desired athlete
	public void finalScoreForAthleteTest() {
		ShootList.add(five);
		ShootList.add(four);
		ShootList.add(four);
		ShootList.add(three);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		assertEquals(tester.finalScoreForAthlete("Joe"), 320, .1);
	}
	
	@Test
	//tests to make sure the method produces true if at least one athlete had a better final score in another competition
	public void anyImprovmentTest() {
		ShootList2.add(five);
		ShootList2.add(five);
		ShootList2.add(five);
		ShootList2.add(five);
		ShootList.add(five);
		ShootList.add(four);
		ShootList.add(five);
		ShootList.add(five);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfAth.add(Brian);
		listOfAth2.add(Joe2);
		listOfAth2.add(Bob2);
		listOfAth2.add(Sam2);
		listOfAth2.add(Ken2);
		listOfAth2.add(Brian2);
		assertEquals (tester.anyImprovement(tester2), true);
	}
	
	@Test
	//tests to make sure the method produces true if all the athletes had a better final score in another competition
	public void anyImprovmentTest2() {
		ShootList.add(five);
		ShootList.add(five);
		ShootList.add(five);
		ShootList.add(five);
		ShootList2.add(one);
		ShootList2.add(one);
		ShootList2.add(one);
		ShootList2.add(one);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfAth2.add(Joe2);
		listOfAth2.add(Bob2);
		listOfAth2.add(Sam2);
		listOfAth2.add(Ken2);
		assertEquals(tester.anyImprovement(tester2), true);
	}
	
	@Test
	//tests to make sure the method produces false if the athletes had the same final score in each competition
	public void anyImprovementTest3() {
		ShootList.add(five);
		ShootList.add(four);
		ShootList.add(four);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfAth2.add(Joe);
		listOfAth2.add(Bob);
		listOfAth2.add(Sam);
		listOfAth2.add(Ken);
		assertEquals (tester.anyImprovement(tester2), false);
	}
	
	@Test
	//tests to make sure the method produces false if none of the athletes improved
	public void anyImprovementTest4() {
		ShootList.add(five);
		ShootList.add(five);
		ShootList.add(five);
		ShootList.add(five);
		ShootList2.add(one);
		ShootList2.add(one);
		ShootList2.add(one);
		ShootList2.add(one);
		listOfAth.add(Joe2);
		listOfAth.add(Bob2);
		listOfAth.add(Sam2);
		listOfAth.add(Ken2);
		listOfAth2.add(Joe);
		listOfAth2.add(Bob);
		listOfAth2.add(Sam);
		listOfAth2.add(Ken);
		assertEquals (tester.anyImprovement(tester2), false);
	}
}
