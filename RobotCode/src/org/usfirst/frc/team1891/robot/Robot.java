
package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.omg.CORBA.portable.UnknownException;
import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;

public class Robot extends IterativeRobot 
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	//Brings in DriveMaster
	Command autonomousCommand;
	//Instantiates jags with appropriate ID's
    CANJaguar jag3;
    CANJaguar jag4;
    CANJaguar jag5;
    CANJaguar jag6;
    AutonomousMaster auto;
    JAGValue jagMaster= new JAGValue();
	//Initiates all instances of all classes
    public void robotInit()
    {
    	oi = new OI();
		jag3 = new CANJaguar(3);
		jag4 = new CANJaguar(4);
		jag5 = new CANJaguar(5);
		jag6 = new CANJaguar(6);
		auto= new AutonomousMaster(0.3, 0.2, 0.2);
		auto.enable();
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
    	jag3.enableControl();
    	jag3.set(auto.getSetpoint());
        Scheduler.getInstance().run();
        
        
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
    }


    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
