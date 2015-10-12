package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Lift extends Command {

    public Elevator_Lift() {
        requires(Robot.elevator);
    }

    protected void initialize() {}

    protected void execute() {
        Robot.elevator.up();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.elevator.stop();
    }
    
    protected void interrupted() {
        end();
    }
}

