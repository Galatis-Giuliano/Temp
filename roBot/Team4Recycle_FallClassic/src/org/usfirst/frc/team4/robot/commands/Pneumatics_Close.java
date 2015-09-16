package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pneumatics_Close extends Command {

    public Pneumatics_Close() {}

    protected void initialize() {
        Robot.pneumatics.leftArmClose();
        Robot.pneumatics.rightArmClose();
    }

    protected void execute() {}
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {
        end();
    }
}
