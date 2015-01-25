package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;

//The class that handles input from the Joystick and returns JAG set values
public class JAGValue {
	DriveMaster roboDrive = new DriveMaster(1);
	
	
	public double setSpeed(int Index) {
		double Speed = 0;
		double x = roboDrive.getXAxis();
		double y = roboDrive.getYAxis();
		double z = roboDrive.getZAxis();
		double damp = getPrecisionMode();
		
		double a = (y - z - x) * damp;
		double b = (y + z + x) * damp;
		double c = (y + z - x) * damp;
		double d = (y - z + x) * damp;
		
		double overflow = getOverflow(a, b, c, d);
		
		
		if (Index == 3) {
			Speed = (y - z - x) * damp * overflow;
		}if (Index == 4) {
			Speed = -(y + z + x) * damp * overflow;
		}if (Index == 5) {
			Speed = -(y + z - x) * damp * overflow;
		}if (Index == 6) {
			Speed = (y - z + x) * damp * overflow;
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
		if(roboDrive.getProfile() == 1){
			damp = (-roboDrive.getSlider() + 1) * .35 + .3;
		}
		//for xbox360 r trigger damp
		else{
			damp = 1-roboDrive.getSlider() * .7;
		}
		
		
		//for single button damp
		/**
		
		if(roboDrive.getButton(3) == true){
			damp = .3;
		}**/
		
		
		return damp;
	}
	
	
	//this class checks if any joystick inputs are greater than one, and if they
	//are, it returns a fraction to keep the jags running at the same ratio
	
	public double getOverflow(double a, double b, double c, double d){
		a = Math.abs(a);
		b = Math.abs(b);
		c = Math.abs(c);
		d = Math.abs(d);
		
		double max = 0;
		double reciprocal = 1;
		if(a>=b && b>=c && c>= d) max = a;
		else if (b>=c && c>=d) max = b;
		else if (c>=d) max = c;
		else max = d;
		
		if (max >= 1){
			reciprocal = 1/max;
		}
		
		
		
		return reciprocal;
	}
}
