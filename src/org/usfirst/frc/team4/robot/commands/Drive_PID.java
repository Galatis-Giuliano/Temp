package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_PID extends Command {

    double 
    	angleSetPoint      = 0,
    	driveSetPoint      = 0,
    	angle              = 0,
    	distance           = 0;
    
    boolean manualSpeed = false;
    
    public Drive_PID() {
        requires(Robot.chassis);
        manualSpeed = true;
    }
    
    public Drive_PID(double distance) {
        requires(Robot.chassis);
        this.distance = distance;
    }
    public Drive_PID(double angle, double distance) {
        requires(Robot.chassis);
        this.angle = angle;
        this.distance = distance;
    }

    protected void initialize() {

        angleSetPoint = Robot.chassis.gyroGet() + angle;
        driveSetPoint = Robot.chassis.leftDistance() + distance;
    }

    protected void execute() {
    	if (manualSpeed){
    		Robot.chassis.arcade(
    				Robot.oi.leftY(RobotMap.driveCont),
    				Robot.chassis.pidAngle(Robot.chassis.gyroGet(), angleSetPoint)
    				);
    	} else {
    		Robot.chassis.arcade(
    				Robot.chassis.AutonSpeedLimit(Robot.chassis.pidDrive(Robot.chassis.leftDistance(), driveSetPoint)),
    				Robot.chassis.pidAngle(Robot.chassis.gyroGet(), angleSetPoint)
    				);
    	}
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
