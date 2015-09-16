package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake_Manual extends Command {

    public Intake_Manual() {
        requires(Robot.intake);
    }

    protected void initialize() {}

    protected void execute() {
//        Robot.intake.manual(Robot.oi.opCont);
//        Robot.intake.manualLeftStick(Robot.oi.opCont);
//        Robot.intake.turn(Robot.oi.leftY(Robot.oi.opCont), Robot.oi.leftX(Robot.oi.opCont));
    
        Robot.intake.speed(Robot.oi.R2(RobotMap.opCont) - Robot.oi.L2(RobotMap.opCont)); //right joystick control
    }

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
	Robot.intake.stop();
    }

    protected void interrupted() {
        end();
    }
}
