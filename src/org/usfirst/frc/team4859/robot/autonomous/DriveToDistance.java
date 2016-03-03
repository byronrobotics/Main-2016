package org.usfirst.frc.team4859.robot.autonomous;

import java.util.Arrays;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDistance extends Command {

	private double inputSpeed;
	private double distance;
	//private double[] last_fifty = {1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0};
	public double pethan;
	
	public DriveToDistance(double inputSpeed) {
		requires(Robot.chassis);
		this.inputSpeed = inputSpeed;
	}
	
	@Override
	protected void initialize() {
    	Robot.gyro.reset();
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected void execute() {
		Robot.chassis.DriveStraightGyro(inputSpeed);
	}

	@Override
	protected boolean isFinished() {

		return Robot.getMedian() <= distance;
	}

	@Override
	protected void end() {
		Robot.chassis.DriveStop();
	}

	@Override
	protected void interrupted() {
    	Robot.chassis.DriveStop();
	}
}
