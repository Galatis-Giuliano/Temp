package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_PID extends Command {

    public Elevator_PID() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(Robot.elevator.position){
    		case 0:
    			Robot.elevator.setPosition(0);
    			break;
    		case 1:
    			Robot.elevator.setPosition(0);
        		break;
    		case 2:
    			Robot.elevator.setPosition(0);
        		break;
    		case 3:
    			Robot.elevator.setPosition(0);
        		break;
    		case 4:
    			Robot.elevator.setPosition(0);
        		break;
    		case 5:
    			Robot.elevator.setPosition(0);
        		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
