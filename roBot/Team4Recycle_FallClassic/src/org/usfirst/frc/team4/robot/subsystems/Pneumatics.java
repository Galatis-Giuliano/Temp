package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Pneumatics_Manual;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    public boolean armOpen           = true;
    public boolean clawOpen			 = true;
    private Compressor compressor    = new Compressor();
    private DoubleSolenoid leftArm   = new DoubleSolenoid(RobotMap.PNEUMATICS_ARM_LEFT_FWD,  RobotMap.PNEUMATICS_ARM_LEFT_RWD);
    private DoubleSolenoid rightArm  = new DoubleSolenoid(RobotMap.PNEUMATICS_ARM_RIGHT_FWD, RobotMap.PNEUMATICS_ARM_RIGHT_RWD);
    private DoubleSolenoid leftClaw  = new DoubleSolenoid(RobotMap.PNEUMATICS_CLAW_LEFT_FWD, RobotMap.PNEUMATICS_CLAW_LEFT_RWD);
    private DoubleSolenoid rightClaw = new DoubleSolenoid(RobotMap.PNEUMATICS_CLAW_RIGHT_FWD, RobotMap.PNEUMATICS_CLAW_RIGHT_RWD);

    public void initDefaultCommand() {
        setDefaultCommand(new Pneumatics_Manual());
    }
    
    public void compStart() {
        compressor.start();
    }
    public void compStop() {
        compressor.stop();
    }
    
    public void armOpen() {
        leftArmOpen();
        rightArmOpen();
    }
    
    public void armClose(){
    	leftArmClose();
        rightArmClose();
    }
    
    public void clawOpen(){
    	rightClawOpen();
        leftClawOpen();
    }

    public void clawClose() {
        /* Not needed (Does the wrong function - Adam Shrager)
    	leftArmClose();
        rightArmClose();
        */
        rightClawClose();
        leftClawClose();
    }
    
    public void leftClawOpen(){
    	leftClaw.set(DoubleSolenoid.Value.kForward);
    }
    
    public void leftClawClose(){
    	leftClaw.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void rightClawOpen(){
    	rightClaw.set(DoubleSolenoid.Value.kForward);
    }
    
    public void rightClawClose(){
    	rightClaw.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void leftArmOpen() {
        leftArm.set(DoubleSolenoid.Value.kForward);
    }
    public void leftArmClose() {
        leftArm.set(DoubleSolenoid.Value.kReverse);
    }

    public void rightArmOpen() {
        rightArm.set(DoubleSolenoid.Value.kForward);
    }

    public void rightArmClose() {
        rightArm.set(DoubleSolenoid.Value.kReverse);
    }

    public void leftArmOff() {
        rightArm.set(DoubleSolenoid.Value.kOff);
    }

    public void rightArmOff() {
        rightArm.set(DoubleSolenoid.Value.kOff);
    }
}

