package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
/**
*
* @author James
*/
public class Drive_Straight_Legacy extends Command {
	public static double
		turn,
		Kp,
		Kd,
		botAngle,
		previousP;
	public double set;
	
	public Drive_Straight_Legacy() {
		requires(Robot.chassis);
	}
	protected void initialize() {
		Kp = Robot.chassis.angleKp;
		Kd = Robot.chassis.angleKd; //Percent
//		gyro.reset();
		set = Robot.chassis.gyroGet();
//			0;
	}
	protected void execute() {
		double
			setPoint = set,
			processVariable = Robot.chassis.gyroGet(),
			PID_P = (setPoint - processVariable),
			PID_D = -(PID_P - previousP),
			PID = (PID_P * Kp) + (PID_D * Kd);
			Robot.chassis.arcade(Robot.oi.leftY(RobotMap.driveCont), PID);
	previousP = processVariable;
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
