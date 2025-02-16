package tests;

import junit.framework.*;
import java.util.*;
import src.java.com.modele.*;

public class TestGetReservations extends TestCase {

	@Test
	public void testAucuneCorr() {
			PlanningCollection plan = new PlanningCollection();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			assertEquals(null, plan.getReservation(new DateCalendrier(29, 12, 2024)));

	}
	
	@Test
	public void testUneCorr()  {
		PlanningCollection plan = new PlanningCollection();
		plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
		TreeSet <Reservation> testSet = plan.getReservation(new Reservation(new DateCalendrier(30, 12, 2024)));
		assertEquals(1, testSet.size());
    }
    
    @Test
	public void testChSetVide() {
		PlanningCollection plan = new PlanningCollection();
		assertEquals(null, plan.getReservation(new DateCalendrier(29, 12, 2024)));
    }
}
