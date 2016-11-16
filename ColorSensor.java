/**
 * @author : IRAGUHA VALENS 
 **/

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorSensor {
	
	private static EV3ColorSensor CSensor;
	
	public static void main(String[] args) throws InterruptedException {
		CSensor = new EV3ColorSensor(SensorPort.S2); 
		CSensor.setFloodlight(2); 
		LCD.clear();
		
		while (!Button.ESCAPE.isDown()) {	
			LCD.clear();
			switch (CSensor.getColorID()) {  
				case -1: 
					LCD.drawString("Aucune couleur ", 0,0);	 
					break;
				case 0 : 
					LCD.drawString("ROUGE", 0,0);
					break;
				case 1 : 
					LCD.drawString("VERT", 0,0);
					break;
				case 2 : 
					LCD.drawString("BLEU", 0,0);
					break;
				case 3 : 
					LCD.drawString("JAUNE", 0,0);
					break;
				case 6 : 
					LCD.drawString("BLANC", 0,0);
					break;
				case 7 : 
					LCD.drawString("NOIR", 0,0);
					break;
				case 13 : 
					LCD.drawString("MARRON", 0,0);
					break;
			}
			Thread.sleep(100);
	    }
		
		CSensor.setFloodlight(-1);
		LCD.clear();
		Sound.beepSequence();
	}
}
