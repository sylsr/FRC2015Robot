package org.usfirst.frc.team1891.robot;
//Makes the servo move on a seperate joystick

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class ServoMaster
{
	//Assigns the servo to the second joystick with the id number 3
	DriveMaster joy2= new DriveMaster(3);
	//Calls out the servo as serv1
	Servo serv1;
	public ServoMaster() //Instantiates the servo on port 0
	{
		serv1= new Servo(0);
		
	}
	public void start() //Assigns the servo to the x axis of joystick 2
	{
		serv1.set(joy2.getXAxis());
	}
}
