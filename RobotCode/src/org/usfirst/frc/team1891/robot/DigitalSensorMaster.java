package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DigitalSensorMaster
{
	DigitalInput dig;
	public DigitalSensorMaster()
	{
		dig = new DigitalInput(0);
		LiveWindow.addSensor("DigitalInput", "Switch", dig);

	}
	public boolean testDigitalInput()
	{
		if(dig.get()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
