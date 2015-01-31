package org.usfirst.frc.team1891.robot;

import src.com.kauailabs.nav6.frc.IMU;
import src.com.kauailabs.nav6.frc.IMUAdvanced;
import edu.wpi.first.wpilibj.AnalogInput;

public class InfraredMaster
{
	AnalogInput infraredFront;
	AnalogInput infraredLeft;
	AnalogInput infraredRight;
	AnalogInput infraredBack;
	int distanceFront;
	int distanceLeft;
	int distanceRight;
	int distanceBack;
	public InfraredMaster()
	{
		infraredFront= new AnalogInput(4);
		infraredLeft= new AnalogInput(3);
		infraredRight= new AnalogInput(1);
		infraredBack= new AnalogInput(2);
	}
	public int getDistanceFront()
	{
		distanceFront=infraredFront.getValue();
		return distanceFront;
	}
	public int getDistanceLeft()
	{
		distanceLeft=infraredLeft.getValue();
		return distanceLeft;
	}
	public int getDistanceRight()
	{
		distanceRight=infraredRight.getValue();
		return distanceRight;
	}
	public int getDistanceBack()
	{
		distanceBack=infraredBack.getValue();
		return distanceBack;
	}
	
	
}
