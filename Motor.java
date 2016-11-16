/**
 * @author : IRAGUHA VALENS 
 **/

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;

public class motor {	

	private static RegulatedMotor moteurGauche, moteurDroite, motorCentre;
	private final static int acceleration = 2000;
	private final static int vitesse = 2000;
	private final static int angle = 450;
	
	public static void SetMoteur (RegulatedMotor a) { 
		a.setAcceleration(acceleration);
		a.setSpeed(vitesse); 
	}
	
	public static void Prendre() {  
		motorCentre.rotate(angle);
	}	
	
	public static void Poser() { 
		motorCentre.rotate(-angle);
	}
	
	public static void main(String[] args) throws InterruptedException { 
		motorCentre = Motor.A;
		moteurGauche = Motor.B;
		moteurDroite = Motor.C;	
		SetMoteur(moteurGauche);
		SetMoteur(moteurDroite);
		SetMoteur(motorCentre);

		boolean a = true;
		while (a) { 
			moteurGauche.forward(); 
			moteurDroite.forward(); 
			Prendre();  
			Poser(); 
			a = false;
	    }

		moteurDroite.stop();
		moteurGauche.stop();
		motorCentre.stop();
		LCD.clear();
		Sound.beepSequence();
	}	
}
