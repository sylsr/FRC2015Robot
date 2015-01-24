package org.usfirst.frc.team1891.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
public class AutonomousMaster
{
	double codesPerRev=250;
	double P;
	double I;
	double D;
	CANJaguar jag3 = new CANJaguar(3);
    //jag3.setCurrentMode(CANJaguar.kQuadEncoder, codesPerRev, P, I, D);
    
}
