package org.usfirst.frc.team1891.robot;
//************************************
//This class controls the the true false switch
//The constructor brings in a DigitalInput on PWM 0
//************************************
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
	//This method returns true or false and outputs to the smartdashboard.
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
