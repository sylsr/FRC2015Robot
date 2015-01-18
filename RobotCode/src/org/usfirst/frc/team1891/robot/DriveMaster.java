package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;

public class DriveMaster
{
	//Instantiates joystick
	Joystick joyRight;
	// sets DEADZONE around all axis
	public final double DEADZONE=0.2;
	//constructor for DriveMaster
	public DriveMaster(int joyPort) {
		joyRight= new Joystick(joyPort);
	}
	//returns DEADZONE
	public double getDEADZONE() {
		return DEADZONE;
	}
	//gets the modified y axis from the joystick that tests against deadzone
	
	public double getYAxis() {
		return getDead(joyRight.getY());
			
	}
	//gets the modified x axis from the joystick that tests against deadzone
	public double getXAxis() {
		return getDead(-joyRight.getX());
		
	}
	//gets the modified z axis from the joystick that tests against deadzone
	public double getZAxis() {
		return getDead(-joyRight.getZ());
		
	}

	public double getDead(double a) {
		
		if(Math.abs(a) > DEADZONE) {
			return a;
		}return 0;
	}

}
