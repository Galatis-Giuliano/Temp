package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Manual extends Command {

    public Drive_Manual() {
        requires(Robot.chassis);
    }
    
    protected void initialize() {}
    
    protected void execute() {
        Robot.chassis.arcade(Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont)), Robot.oi.parabolic(Robot.oi.rightX(RobotMap.driveCont)));
//    	  Robot.chassis.tank(
//    		  Robot.oi.parabolic(Robot.oi.leftY(RobotMap.driveCont)), 
//    		  Robot.oi.parabolic(Robot.oi.rightY(RobotMap.driveCont)));
//        System.out.println("l: "+Robot.chassis.leftDistance());
//        System.out.println("r: "+Robot.chassis.rightDistance());
//        System.out.println("g: "+Robot.chassis.gyroGet());
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
