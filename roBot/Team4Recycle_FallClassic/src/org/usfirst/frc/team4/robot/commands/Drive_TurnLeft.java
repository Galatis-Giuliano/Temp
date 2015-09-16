package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_TurnLeft extends Command {
    
    public Drive_TurnLeft() {
        requires(Robot.chassis);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        Robot.chassis.arcadeFiltered(0, -0.5);
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
