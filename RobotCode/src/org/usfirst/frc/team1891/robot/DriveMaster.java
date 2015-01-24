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
	//gets the profile
	public int getProfile(){
		int profileIndex = 1;
		if (joyRight.getButtonCount() == 10) profileIndex = 2;
		if (joyRight.getButtonCount() == 11) profileIndex = 3;
		return profileIndex;
	}
	//gets the modified y axis from the joystick that tests against deadzone
	
	public double getYAxis() {
		return getDead(joyRight.getY());
			
	}
	//gets the modified x axis from the joystick that tests against deadzone
	public double getXAxis() {
		return getDead(-joyRight.getX());
		
	}
	//gets the modified z axis from the joystick that tests against deadzone; for joystick RawAxis index is 2, for xbox index is 4
	public double getZAxis() {
		if (getProfile() == 1||getProfile()==3){
			return getDead(-joyRight.getZ());
		}
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
