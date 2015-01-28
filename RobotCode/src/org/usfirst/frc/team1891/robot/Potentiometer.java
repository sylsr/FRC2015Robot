package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Potentiometer
{
	//Brings in porentometer and named it pot
	AnalogPotentiometer pot; 
	//Instantiates current as a double
	double current;
	public Potentiometer() //Adds the potentiometer to the SmartDashboard
	{
		pot= new AnalogPotentiometer(0, 270); //Instantiates pot as a part of the AnaogPotentiometer at port 0 with 270 degree of rotation
		LiveWindow.addSensor("Potentiometer", 0, pot); //Adds the potentiometer to the smartdashboard
	}
	public double returnAngle() //Returns the angle of the potentiometer
	{
		current=pot.get(); 
		return current; //returns the angle
	}
}
