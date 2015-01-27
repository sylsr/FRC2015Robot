package org.usfirst.frc.team1891.robot;

import src.com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccelMaster 
{
	SerialPort serial_port;
	//IMU imu;  // Alternatively, use IMUAdvanced for advanced features
	IMUAdvanced imu;
	boolean first_iteration;
	public AccelMaster()
	{
		try
		{
	    	serial_port = new SerialPort(57600,SerialPort.Port.kMXP);
			
			// You can add a second parameter to modify the 
			// update rate (in hz) from 4 to 100.  The default is 100.
			// If you need to minimize CPU load, you can set it to a
			// lower value, as shown here, depending upon your needs.
			
			// You can also use the IMUAdvanced class for advanced
			// features.
			
			byte update_rate_hz = 50;
			//imu = new IMU(serial_port,update_rate_hz);
			imu = new IMUAdvanced(serial_port,update_rate_hz);
	    } 
		catch( Exception ex )
		{
	    		
	    }
	        if ( imu != null )
	        {
	            LiveWindow.addSensor("IMU", "Gyro", imu);
	        }
	        first_iteration = true;
	}
	public void startDash()
	{
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

}
