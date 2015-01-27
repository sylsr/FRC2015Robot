package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class ServoMaster
{
	DriveMaster joy2= new DriveMaster(3);
	Servo serv1;
	public ServoMaster()
	{
		serv1= new Servo(0);
		
	}
	public void start()
	{
		serv1.set(joy2.getXAxis());
	}
}
