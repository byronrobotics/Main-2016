package org.usfirst.frc.team4859.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistanceMedian extends Command {
	
	public double[] last_fifty = {1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0};
	public double[] copied;
	
	private double distance;
	private boolean ultra;
	
    public DistanceMedian(double distance, boolean ultra) {
		this.distance = distance;
		this.ultra = ultra;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double val = 0.0;
		
		if (ultra)
			val = Robot.ultra.getVoltage()*8.8365*12;
		else 
			val = Robot.ultra2.g()*8.8365*12;
		
		for (int i = 0; i < 49; i++) {                
			this.last_fifty[i+1] = this.last_fifty[i];
		}
		
		this.last_fifty[0] = val;
		
		double[] copied = Arrays.copyOf(this.last_fifty, 50);
		Arrays.sort(copied);
		
		copied = Arrays.copyOf(last_fifty, 50);
		Arrays.sort(copied);
		
		this.median = copied[25];
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pivot.AngleStop();
    	//Robot.pivot.motorLauncherAngle.setPosition(RobotMap.upPosition);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
       	Robot.pivot.AngleStop();
    }
}