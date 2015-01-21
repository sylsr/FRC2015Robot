package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;

//The class that handles input from the Joystick and returns JAG set values
public class JAGValue {
	DriveMaster roboDrive = new DriveMaster(0);
	
	
	public double setSpeed(int Index) {
		double Speed = 0;
		if (Index == 3) {
			Speed = getPrecisionMode() * (roboDrive.getYAxis() - roboDrive.getZAxis() - roboDrive.getXAxis());
		}if (Index == 4) {
			Speed = getPrecisionMode() * -(roboDrive.getYAxis() + roboDrive.getZAxis() + roboDrive.getXAxis());
		}if (Index == 5) {
			Speed = getPrecisionMode() *  -(roboDrive.getYAxis() + roboDrive.getZAxis() - roboDrive.getXAxis());
		}if (Index == 6) {
			Speed = getPrecisionMode() *  (roboDrive.getYAxis() - roboDrive.getZAxis() + roboDrive.getXAxis());
		}
		
		/**
		FrontLeft (jag 4) = Y + Z + X
		RearLeft(jag 5) = Y + Z - X
		FrontRight(jag 3) = Y - Z - X
		RearRight(jag 6) = Y - Z + X
		**/
		
		
		return Speed;
	}
	
	public double getPrecisionMode(){
		double damp = 1;
		
		//for slider on joystick damp
		
		//damp = (-roboDrive.getSlider() + 1) * .35 + .3;
		
		//for xbox360 r trigger damp
		
		damp = 1-roboDrive.getSlider() * .7;
		
		//for single button damp
		/**
		
		if(roboDrive.getButton(3) == true){
			damp = .3;
		}**/
		
		
		return damp;
	}
}
