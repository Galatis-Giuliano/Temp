package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pneumatics_Stop extends Command {

    public Pneumatics_Stop() {}

    protected void initialize() {
        Robot.pneumatics.compStop();
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
