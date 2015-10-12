package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {
		addSequential(new Pneumatics_ClawClose(), 1);
		addSequential(new Wait(5), 0);
		addSequential(new Elevator_Lift(), .5);
		// addSequential(new Drive_Straight(.5), .5);
		// addSequential(new Elevator_Lift(), .5);
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		// addSequential(new Drive_PID(-5), 6);
		// addSequential(new Drive_PID(0, 180), 10);
		// addSequential(new Elevator_Lift(), .5);
		// addSequential(new Wait(), 1);
		// addSequential(new Drive_PID(-6));

	}
}
