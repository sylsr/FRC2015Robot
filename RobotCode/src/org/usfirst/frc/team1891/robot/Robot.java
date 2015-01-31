
package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SampleRobot;

import org.omg.CORBA.portable.UnknownException;
import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;

import src.com.kauailabs.nav6.frc.IMUAdvanced;

public class Robot extends IterativeRobot 
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	Command autonomousCommand;
	//Instantiates jags with appropriate ID's
    CANJaguar jag3;
    CANJaguar jag4;
    CANJaguar jag5;
    CANJaguar jag6;
    JAGValue jagMaster= new JAGValue();
    AccelMaster IMU;
    DigitalSensorMaster digitalSwitch;
    ServoMaster servo1;
    Potentiometer pot1;
    InfraredMaster infrared;
    public void robotInit()
    {
    	oi = new OI();
		jag3 = new CANJaguar(3);
		jag4 = new CANJaguar(4);
		jag5 = new CANJaguar(5);
		jag6 = new CANJaguar(6);
		IMU = new AccelMaster();
		digitalSwitch=new DigitalSensorMaster();
		servo1 = new ServoMaster();
		pot1 = new Potentiometer();
		infrared=new InfraredMaster();
    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

    public void autonomousInit()
    {

        if (autonomousCommand != null) autonomousCommand.start();
       
    }

    public void autonomousPeriodic()
    {
    	
        Scheduler.getInstance().run();
        IMU.startDash();
		SmartDashboard.putBoolean("Testing",digitalSwitch.testDigitalInput()); 
		SmartDashboard.putNumber(   "Infrared Front",   infrared.getDistanceFront());
		SmartDashboard.putNumber(   "Infrared Left",   infrared.getDistanceLeft());
		SmartDashboard.putNumber(   "Infrared Right",   infrared.getDistanceRight());
		SmartDashboard.putNumber(   "Infrared Back",   infrared.getDistanceBack());
        
    }

    public void teleopInit() 
    {
    	
        if (autonomousCommand != null)
        {
        	autonomousCommand.cancel();
        }        
     }   	
        	
    public void disabledInit() 
    {

    }

	public void teleopPeriodic() 
    {	
		Scheduler.getInstance().run();
		jag3.set(jagMaster.setSpeed(3));
		jag4.set(jagMaster.setSpeed(4));
		jag5.set(jagMaster.setSpeed(5));
		jag6.set(jagMaster.setSpeed(6));
		IMU.startDash();
		SmartDashboard.putBoolean("Testing",digitalSwitch.testDigitalInput());  
		servo1.start();
		SmartDashboard.putNumber("Potentiometer", pot1.returnAngle());
    }


    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
