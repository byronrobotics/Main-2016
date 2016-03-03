package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.autonomous.DriveStraightGyro;
import org.usfirst.frc.team4859.robot.autonomous.PivotUpTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Portcullis extends CommandGroup {

	public Portcullis() {
		
		addParallel(new PivotUpTime(5));
		addSequential(new DriveStraightGyro(1, 1.5));
		addSequential(new PivotDown());
	}
}