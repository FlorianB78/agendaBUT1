package tests;

import junit.framework.*;
import modele.*;

public class TestAjout extends TestCase {

	public void testParReservInvalide() {
				
		try{
			PlanningCollections plan = new PlanningCollections();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 1582), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
    	}
    	catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur()]);
    	}
	}

	public void testToutValide() {
		try{
			PlanningCollections plan = new PlanningCollections();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(10, 15), new Horaire(11, 0)), "testBis", "testNiveauBis"));
		}
		catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur()]);
    	}
    }

	public void testReservIncompatible() {
		try{
			PlanningCollections plan = new PlanningCollections();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(9, 15), new Horaire(11, 0)), "testBis", "testNiveauBis"));
		}
		catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur()]);
    	}
    }
}
