package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Elevator_Manual;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class Elevator extends Subsystem {
    
    public static final double elevatorKp = 0;
    public static final double elevatorKd = 0;
    public final int positionMax = 7;
    public final int positionMin = 0;
    
    public int position = 0;
    
    private double previousPAngle = 0;
    
    private VictorSP EleVictor = new VictorSP(RobotMap.ELEVATOR_MOTOR);
    
    private AnalogInput ElevatorPOT = new AnalogInput(RobotMap.ELEVATOR_POTENTIOMETER);
    
    public void initDefaultCommand() {
//        setDefaultCommand(new Elevator_PID());
    	setDefaultCommand(new Elevator_Manual());
    }

    public void up() {
        manual(-1);
    }
    
    public void down() {
        manual(1);
    }
    
    public void manual(double speed) {
        EleVictor.set(speed);
    }
    
    public void stop() {
        EleVictor.set(0);
    }
    
    public double POTget() {
        return ElevatorPOT.getValue();
    }
    
    public void setPosition (double setPoint) {
        double
            processVariable = POTget(),
            PID_P = (setPoint - processVariable),
            PID_D = -(PID_P - previousPAngle);
        
        previousPAngle = processVariable;
        
        manual((PID_P * elevatorKp) + (PID_D * elevatorKd));
    }
}
