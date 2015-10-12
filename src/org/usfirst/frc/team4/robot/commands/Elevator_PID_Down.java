package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_PID_Down extends Command {

    public Elevator_PID_Down() {}

    protected void initialize() {
    	if (Robot.elevator.position > Robot.elevator.positionMin) {
    		Robot.elevator.position--;
    	}
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
