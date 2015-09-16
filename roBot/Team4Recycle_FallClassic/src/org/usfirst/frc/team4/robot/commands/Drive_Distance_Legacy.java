package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Distance_Legacy extends Command {
	public static double
		driveKp,
		driveKd,
		drivePreviousP,
		
		angleKp,
		angleKd,
		anglePreviousP;
	public double 
		driveSet,
		angleSet;
	
    public Drive_Distance_Legacy() {
        requires(Robot.chassis);
    }

	
	protected void initialize() {
		driveKp = Robot.chassis.driveKp;
		driveKd = Robot.chassis.driveKd; //Percent
		
		angleKp = Robot.chassis.angleKp;
		angleKd = Robot.chassis.angleKd;

		driveSet = Robot.chassis.leftDistance() + 100;
		angleSet = Robot.chassis.gyroGet();
	}
	protected void execute() {
		double
			driveSetPoint = driveSet,
			driveProcessVariable = Robot.chassis.leftDistance(),
			drivePID_P = (driveSetPoint - driveProcessVariable),
			drivePID_D = -(drivePID_P - drivePreviousP),
			drivePID = (drivePID_P * driveKp) + (drivePID_D * driveKd),
			
			angleSetPoint = angleSet,
			angleProcessVariable = Robot.chassis.gyroGet(),
			anglePID_P = (angleSetPoint - angleProcessVariable),
			anglePID_D = -(anglePID_P - anglePreviousP),
			anglePID = (anglePID_P * angleKp) + (anglePID_D * angleKd);
		
			Robot.chassis.arcade(drivePID, anglePID);
	
		anglePreviousP = angleProcessVariable;
		drivePreviousP = driveProcessVariable;
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.chassis.stop();
	}
	protected void interrupted() {
		end();
	}
}