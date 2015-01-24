
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
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SampleRobot;





import org.omg.CORBA.portable.UnknownException;
import org.usfirst.frc.team1891.robot.commands.ExampleCommand;
import org.usfirst.frc.team1891.robot.subsystems.ExampleSubsystem;

import src.com.kauailabs.nav6.frc.IMUAdvanced;

public class Robot extends IterativeRobot 
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	AnalogAccelerometer accel;

    IMUAdvanced imu;
	Command autonomousCommand;
	//Instantiates jags with appropriate ID's
    CANJaguar jag3;
    CANJaguar jag4;
    CANJaguar jag5;
    CANJaguar jag6;
    AutonomousMaster auto;
    SerialPort serial_port;
    JAGValue jagMaster= new JAGValue();
	//Initiates all instances of all classes
    public void robotInit()
    {
    	oi = new OI();
		jag3 = new CANJaguar(3);
		jag4 = new CANJaguar(4);
		jag5 = new CANJaguar(5);
		jag6 = new CANJaguar(6);
		accel= new AnalogAccelerometer(4);
		imu = new IMUAdvanced(serial_port,(byte) 10);
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
        SmartDashboard.putBoolean(  "IMU_Connected",        imu.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    imu.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              imu.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            imu.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             imu.getRoll());
        SmartDashboard.putNumber(   "IMU_CompassHeading",   imu.getCompassHeading());
        SmartDashboard.putNumber(   "IMU_Update_Count",     imu.getUpdateCount());
        SmartDashboard.putNumber(   "IMU_Byte_Count",       imu.getByteCount());

        // If you are using the IMUAdvanced class, you can also access the following
        // additional functions, at the expense of some extra processing
        // that occurs on the CRio processor
        
        SmartDashboard.putNumber(   "IMU_Accel_X",          imu.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          imu.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         imu.isMoving());
        SmartDashboard.putNumber(   "IMU_Temp_C",           imu.getTempC());
        
        Timer.delay(0.2);
        
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
		SmartDashboard.putBoolean(  "IMU_Connected",        imu.isConnected());
	    SmartDashboard.putBoolean(  "IMU_IsCalibrating",    imu.isCalibrating());
	    SmartDashboard.putNumber(   "IMU_Yaw",              imu.getYaw());
	    SmartDashboard.putNumber(   "IMU_Pitch",            imu.getPitch());
	    SmartDashboard.putNumber(   "IMU_Roll",             imu.getRoll());
	    SmartDashboard.putNumber(   "IMU_CompassHeading",   imu.getCompassHeading());
	    SmartDashboard.putNumber(   "IMU_Update_Count",     imu.getUpdateCount());
	    SmartDashboard.putNumber(   "IMU_Byte_Count",       imu.getByteCount());

	    // If you are using the IMUAdvanced class, you can also access the following
	    // additional functions, at the expense of some extra processing
	    // that occurs on the CRio processor
	        
	    SmartDashboard.putNumber(   "IMU_Accel_X",          imu.getWorldLinearAccelX());
	    SmartDashboard.putNumber(   "IMU_Accel_Y",          imu.getWorldLinearAccelY());
	    SmartDashboard.putBoolean(  "IMU_IsMoving",         imu.isMoving());
	    SmartDashboard.putNumber(   "IMU_Temp_C",           imu.getTempC());
	        
	    Timer.delay(0.2);
	        
    }


    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
