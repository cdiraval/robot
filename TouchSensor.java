/**
 * @author : IRAGUHA VALENS 
 **/

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

public class TouchSensor {	

	private static EV3TouchSensor BoutonTemps;
	private static SimpleTouch BoutonTS;
	
	public static void main(String	[] args) throws InterruptedException { 
		BoutonTemps = new EV3TouchSensor(SensorPort.S1); 
		BoutonTS = new SimpleTouch(BoutonTemps); 
		LCD.clear();
			
		while (!Button.ESCAPE.isDown()) { 
			boolean a = BoutonTS.isPressed(); 
		    LCD.drawString("TS: " + a, 0, 0); 
			Thread.sleep(100); 
		}

		LCD.clear(); 
		Sound.beepSequence(); 
	}
}
