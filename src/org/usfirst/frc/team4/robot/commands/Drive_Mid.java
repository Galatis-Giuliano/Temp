package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Mid extends Command {

    public Drive_Mid() {
        requires(Robot.chassis);
    }
    
    protected void initialize() {}
    
    protected void execute() {
        if (Robot.oi.L2(RobotMap.driveCont) > .50) {
            Robot.chassis.arcadeFiltered(0, -.50);
        } else if (Robot.oi.R2(RobotMap.driveCont) > .50) {
            Robot.chassis.arcadeFiltered(0, .50);
        } else {
    	    Robot.chassis.tankFiltered(
    		  Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont))*Robot.chassis.middrive, 
    		  Robot.oi.parabolic(Robot.oi.rightY(RobotMap.driveCont))*Robot.chassis.middrive);
        }
        
//      Robot.chassis.arcade(
//              Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont))*Robot.chassis.middrive, 
//              Robot.oi.parabolic(Robot.oi.rightX(RobotMap.driveCont))*Robot.chassis.middrive);

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
