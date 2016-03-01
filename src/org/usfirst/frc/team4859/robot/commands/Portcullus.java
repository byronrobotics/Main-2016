package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveStraightGyro;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Portcullus extends CommandGroup {

	public Portcullus() {
		
		addParallel(new PivotUp());
		addSequential(new DriveStraightGyro(1, 1.5));
		addSequential(new PivotDown());
		
	}

}
