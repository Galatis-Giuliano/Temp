package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pneumatics_RightArmClose extends Command {

    public Pneumatics_RightArmClose() {}
    
    protected void initialize() {
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
