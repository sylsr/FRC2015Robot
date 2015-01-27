package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Potentiometer
{
	AnalogPotentiometer pot;
	double current;
	public Potentiometer()
	{
		pot= new AnalogPotentiometer(0, 270);
		LiveWindow.addSensor("Potentiometer", 0, pot);
	}
	public double returnAngle()
	{
		current=pot.get();
		return current;
	}
}
