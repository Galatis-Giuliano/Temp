package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Set extends Command {

    public Elevator_Set() {
        requires(Robot.elevator);
    }

    protected void initialize() {}

    protected void execute() {
        Robot.elevator.down();
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
