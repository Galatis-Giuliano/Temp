package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Intake_Manual;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    public VictorSP leftSP  = new VictorSP(RobotMap.INTAKE_LEFT );
    public VictorSP rightSP = new VictorSP(RobotMap.INTAKE_RIGHT);

    public void initDefaultCommand() {
        setDefaultCommand(new Intake_Manual());
    }
    
    private void speed(double l, double r) {
        leftSP .set(l); //practice bot
        rightSP.set(-r);
    }

    public void turn(double speed, double turn) {
        speed(speed-turn, speed+turn);
    }
    
    public void speed(double speed) {
        speed(speed, speed);
    }
    
//    public void intakeTote() {
//        speed( 1,  1);
//    }
//
//    public void intakeBin() {
//        speed( 1,  1); //probably going to be the same thing as IntakeTote
//    }
//
//    public void rotateCounterClockwise() {
//        speed( 1, -1);
//    }
//    public void rotateClockwise() {
//        speed(-1,  1);
//    }
//
//    public void reject() {
//        speed(-1, -1);
//    }

    public void stop() {
        speed( 0,  0);
    }
}

