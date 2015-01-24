package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		return getDead(joyRight.getRawAxis(1));
			
	}
	//gets the modified x axis from the joystick that tests against deadzone
	public double getXAxis() {
		return getDead(-joyRight.getRawAxis(0));
		
	}
	//gets the modified z axis from the joystick that tests against deadzone; for joystick RawAxis index is 2, for xbox index is 4
	public double getZAxis() {
		return getDead(-joyRight.getRawAxis(4));
		
	}
	
	public double getDead(double a) {
		
		if(Math.abs(a) > DEADZONE) {
			return a;
		}return 0;
	}
	
	public boolean getButton(int button){
		return joyRight.getRawButton(button);
	}
	
	public double getSlider() {
		return joyRight.getRawAxis(3);
	}
}
