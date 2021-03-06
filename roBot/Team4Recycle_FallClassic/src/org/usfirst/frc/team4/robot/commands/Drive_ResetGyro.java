package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_ResetGyro extends Command {

    public Drive_ResetGyro() {}
    
    protected void initialize() {
        Robot.chassis.gyroReset();
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
