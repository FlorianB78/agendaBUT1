package tests;

import junit.framework.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import src.java.com.modele.*;

public class TestAjout extends TestCase {

	@Test
	public void TestParReservInvalide() throws ExceptionPlanning {
				
		try{
			PlanningCollection plan = new PlanningCollection();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 1582), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
    	}
    	catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur]);
    	}
	}
	
	@Test
	public void TestToutValide() throws ExceptionPlanning {
		try{
			PlanningCollection plan = new PlanningCollection();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(10, 15), new Horaire(11, 0)), "testBis", "testNiveauBis"));
		}
		catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur]);
    	}
    }
    
    @Test
	public void TestReservIncompatible() throws ExceptionPlanning {
		try{
			PlanningCollection plan = new PlanningCollection();
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(8, 15), new Horaire(9, 30)), "test", "testNiveau"));
			plan.ajout(new Reservation(new DateCalendrier(30, 12, 2024), new PlageHoraire(new Horaire(9, 15), new Horaire(11, 0)), "testBis", "testNiveauBis"));
		}
		catch(ExceptionPlanning e){
    		System.out.println(ConstantesErreur.ERREURS_PLANNING[e.getCodeErreur]);
    	}
    }
}
