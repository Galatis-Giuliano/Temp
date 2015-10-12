package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;
import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Straight extends Command {

    double
        set             = 0.00,
        setPoint        = 0.00,
        speed           = 0.00;
    
    boolean automaticspeed = true;
    
    public Drive_Straight() {
        requires(Robot.chassis);
        automaticspeed = false;

        setPoint = Robot.chassis.gyroGet();
    }
    
    public Drive_Straight(double driveSpeed) {
        requires(Robot.chassis);
        speed    = driveSpeed;
        setPoint = Robot.chassis.gyroGet();
    }
    
    public Drive_Straight(double driveSpeed, double rotate) {
        requires(Robot.chassis);
        speed     = driveSpeed;
        
        setPoint = rotate + Robot.chassis.gyroGet();
    }

    protected void initialize() {
        set = Robot.chassis.gyroGet();
    }

    protected void execute() {
        if(automaticspeed){ //there is probably an extremely better way to do exactly this
            Robot.chassis.arcade(speed, Robot.chassis.pidAngle(Robot.chassis.gyroGet(), setPoint));
        } else {        //manual override
            Robot.chassis.arcade(Robot.oi.leftY(RobotMap.driveCont), Robot.chassis.pidAngle(Robot.chassis.gyroGet(), setPoint));
        }
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
