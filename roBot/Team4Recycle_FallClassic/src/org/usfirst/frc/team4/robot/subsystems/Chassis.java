package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Drive_Mid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
    public final double driveKp = 2.0;
    public final double driveKd = 0.0;
    
    public final double angleKp = 0.05;
    public final double angleKd = 0;
    
    public final double underdrive = 0.50;
    public final double middrive   = 0.75;
    public final double overdrive  = 1.00;
    
    private double leftSpeed  = 0;
    private double rightSpeed = 0;
    
    private double changeMax = 0.021;
    private double changeMin = 0.100;
    
    private double previousPDrive = 0;
    private double previousPAngle = 0;
    
    private final double encoderFeetConstant = Math.PI/256;
    
    private VictorSP leftFwd  = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTFRONT);
    private VictorSP leftRwd  = new VictorSP(RobotMap.CHASSIS_MOTOR_LEFTREAR);

    private VictorSP rightFwd = new VictorSP(RobotMap.CHASSIS_MOTOR_RIGHTFRONT);
    private VictorSP rightRwd = new VictorSP(RobotMap.CHASSIS_MOTOR_RIGHTREAR);

    private Gyro gyro = new Gyro(RobotMap.CHASSIS_GYRO);
    
    private Encoder leftEn = new Encoder(RobotMap.CHASSIS_ENCODER_LEFT_A, RobotMap.CHASSIS_ENCODER_LEFT_B);
    private Encoder rightEn = new Encoder(RobotMap.CHASSIS_ENCODER_RIGHT_A, RobotMap.CHASSIS_ENCODER_RIGHT_B);

    public void initDefaultCommand() {
        setDefaultCommand(new Drive_Mid());
    }
    
    public double pidAngle (double currentAngle, double setPoint) {
        double
            processVariable = currentAngle,
            PID_P = (setPoint - processVariable),
            PID_D = -(PID_P - previousPAngle);
        
        previousPAngle = processVariable;
        
        return (PID_P * angleKp) + (PID_D * angleKd);
    }
    
    public double pidDrive (double currentDistance, double setPoint) {
        double
            processVariable = currentDistance,
            PID_P = (setPoint - processVariable),
            PID_D = -(PID_P - previousPDrive);
        
        previousPDrive = processVariable;
        
        return (PID_P * driveKp) + (PID_D * driveKd);
    }
    
    public double pidAngle (double setPoint) {
        double
            processVariable = gyroGet(),
            PID_P = (setPoint - processVariable),
            PID_D = -(PID_P - previousPAngle);
        
        previousPAngle = processVariable;
        
        return (PID_P * angleKp) + (PID_D * angleKd);
    }

    public double pidDrive (double setPoint) {
        double
            processVariable = leftDistance(),
            PID_P = (setPoint - processVariable),
            PID_D = -(PID_P - previousPDrive);
        
        previousPDrive = processVariable;
        
        return (PID_P * driveKp) + (PID_D * driveKd);
    }
    
    public void tankTest(double l, double r) {
        arcadeTest(l+r, -l+r);
    }
    
    public void arcadeTest(double speed, double turn) {
        arcade(speed, turn);
    }
    
    public void arcade(double speed, double turn) {
        tank(speed-turn, speed+turn);
    }
    public void arcadeFiltered(double speed, double turn) {
        tankFiltered(speed-turn, speed+turn);
    }
    
    

    public void tankFiltered(double left, double right) {

        left  = pwmLimit(left);
        right = pwmLimit(right);

//        SmartDashboard.putNumber("left drive speed", left);
//        SmartDashboard.putNumber("right drive speed", right);
        
        left = leftDriveFilter(left);
        right = rightDriveFilter(right);

        System.out.println("l: "+ leftDistance());
        System.out.println("r: "+ rightDistance());
        System.out.println("g: "+ gyroGet());
        
        tank(left, right);
    }

    public void stop() {
        tank(0, 0);
    }

    public double gyroGet() {
        return gyro.getAngle();
    }

    public void gyroReset() {
        gyro.reset();
    }

    public double pwmLimit(double number) {
        if(number > 1)        {number =  1;}
        else if (number < -1) {number = -1;}

        return number;
    }
    
    public double AutonSpeedLimit(double number) {
        return pwmLimit(number)/2;
    }
    
    private double leftDriveFilter (double left) {
        left = driveFilter(left, leftSpeed);
        leftSpeed = left;
        return left;
    }
    private double rightDriveFilter (double right) {
        right = driveFilter(right, rightSpeed);
        rightSpeed = right;
        return right;
    }
    
    private double driveFilter(double input, double lastSpeed) {
        
        int sign = getSign(input);
        
        input = Math.abs(input);
        lastSpeed = Math.abs(lastSpeed);
        if (input > .1) {
            if (input > lastSpeed + changeMax) {
                input = lastSpeed + changeMax;
            } else if (input < lastSpeed - changeMin) {
                input = lastSpeed - changeMin;
            }
        }
        
        return input * sign;
    }
    
    private int getSign (double number) {
        int sign = 1;
        if (number < 0) {
            sign = -1;
        }
        
        return sign;
    }
    
    private void tank (double left, double right) {
        leftFwd .set(left);
        leftRwd .set(left);

        rightFwd.set(-right);
        rightRwd.set(-right);
    }
    
    public double leftDistance () {
        return leftEn.getDistance() * encoderFeetConstant;
    }
    
    public double rightDistance () {
        return -rightEn.getDistance();
    }
}
