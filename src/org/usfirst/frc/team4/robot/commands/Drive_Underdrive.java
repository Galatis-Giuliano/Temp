package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Underdrive extends Command {

    public Drive_Underdrive() {
        requires(Robot.chassis);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.chassis.tankFiltered(
    		Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont))*Robot.chassis.underdrive, 
    		Robot.oi.parabolic(Robot.oi.rightY(RobotMap.driveCont))*Robot.chassis.underdrive);
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
