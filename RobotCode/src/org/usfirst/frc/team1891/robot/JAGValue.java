package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;

//The class that handles input from the Joystick and returns JAG set values
public class JAGValue 
{
	DriveMaster roboDrive = new DriveMaster(2);
	
	
	public double setSpeed(int index)
	{
		double speed = 0;
		double dampenZSpeed=(0.85)*(roboDrive.getZAxis());
		if (index == 3) 
		{
			speed = Math.pow((roboDrive.getYAxis() - dampenZSpeed - roboDrive.getXAxis()),3);
			
		}
		if (index == 4) 
		{
			speed = Math.pow(-(roboDrive.getYAxis() + dampenZSpeed + roboDrive.getXAxis()),3);
		}
		if (index == 5)
		{
			speed = Math.pow(-(roboDrive.getYAxis() + dampenZSpeed - roboDrive.getXAxis()),3);
		}
		if (index == 6)
		{
			speed = Math.pow((roboDrive.getYAxis() - dampenZSpeed + roboDrive.getXAxis()),3);
		}
		
		/**
		FrontLeft (jag 4) = Y + Z + X
		RearLeft(jag 5) = Y + Z - X
		FrontRight(jag 3) = Y - Z - X
		RearRight(jag 6) = Y - Z + X
		**/
		
		
		return speed;
	}
}
