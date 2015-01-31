package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class InfraredSlave 
{
	InfraredMaster infrared = new InfraredMaster();
	public void infraredDash()
	{
		SmartDashboard.putNumber(   "Infrared Front",   infrared.getDistanceFront());
		SmartDashboard.putNumber(   "Infrared Left",   infrared.getDistanceLeft());
		SmartDashboard.putNumber(   "Infrared Right",   infrared.getDistanceRight());
		SmartDashboard.putNumber(   "Infrared Back",   infrared.getDistanceBack());
	}
	public boolean SensorForward()
	{
		if(infrared.getDistanceFront()>800)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean SensorLeft()
	{
		if(infrared.getDistanceLeft()>800)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean SensorRight()
	{
		if(infrared.getDistanceRight()>800)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean SensorBack()
	{
		if(infrared.getDistanceBack()>800)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
