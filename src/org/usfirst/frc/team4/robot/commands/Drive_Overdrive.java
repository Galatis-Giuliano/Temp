package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Overdrive extends Command {

    public Drive_Overdrive() {
        requires(Robot.chassis);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.chassis.tankFiltered(
    		Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont))*Robot.chassis.overdrive, 
    		Robot.oi.parabolic(Robot.oi.rightY(RobotMap.driveCont))*Robot.chassis.overdrive);
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
