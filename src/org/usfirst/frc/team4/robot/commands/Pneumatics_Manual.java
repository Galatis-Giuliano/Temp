package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pneumatics_Manual extends Command {

    public Pneumatics_Manual() {
        requires(Robot.pneumatics);
    }

    protected void initialize() {}

    protected void execute() {
        if (Robot.oi.POV(RobotMap.opCont)==0) {
            Robot.pneumatics.leftArmOpen();
            Robot.pneumatics.rightArmOpen();
        } else if (Robot.oi.POV(RobotMap.opCont)==90) {
            Robot.pneumatics.leftArmClose();
            Robot.pneumatics.rightArmOpen();
        } else if (Robot.oi.POV(RobotMap.opCont)==180) {
            Robot.pneumatics.leftArmClose();
            Robot.pneumatics.rightArmClose();
        } else if (Robot.oi.POV(RobotMap.opCont)==270) {
            Robot.pneumatics.leftArmOpen();
            Robot.pneumatics.rightArmClose();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {
        end();
    }
}
