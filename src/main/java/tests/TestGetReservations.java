package tests;

import junit.framework.*;
import java.util.*;
import modele.*;

public class TestGetReservations extends TestCase {

	public void testAucuneCorr() {
        try {
			PlanningCollections plan = new PlanningCollections();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			assertNull(plan.getReservations(new DateCalendrier(29, 12, 2024)));
		} catch (ExceptionPlanning e) {
			System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur()]);
		}

	}

	public void testUneCorr()  {
		try {
			PlanningCollections plan = new PlanningCollections();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			TreeSet<Reservation> testSet = plan.getReservations(new DateCalendrier(30, 12, 2024));
			assertEquals(1, testSet.size());
		}
		catch (ExceptionPlanning e) {
			System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur()]);
		}
    }
    
	public void testChSetVide() {
		PlanningCollections plan = new PlanningCollections();
		assertEquals(null, plan.getReservations(new DateCalendrier(29, 12, 2024)));
    }
}
