package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Elevator_Manual extends Command {

    public Elevator_Manual() {
        requires(Robot.elevator);
    }

    protected void initialize() {}

    protected void execute() {
        Robot.elevator.manual(Robot.oi.parabolic(Robot.oi.leftY(RobotMap.opCont)));
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {
        end();
    }
}
