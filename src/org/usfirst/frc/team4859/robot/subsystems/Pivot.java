package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pivot extends PIDSubsystem {
	
	public CANTalon motorLauncherAngle = new CANTalon(RobotMap.talonDevIDLauncherAngle);
	public DigitalInput limitDown = new DigitalInput(0);
	public static double mult;
	
	public Pivot() {
		super("Pivot", 0.0, 0.0, 0.0);
		motorLauncherAngle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	@Override
	protected double returnPIDInput() {
		return motorLauncherAngle.getPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		motorLauncherAngle.pidWrite(output);
	} 
      
    public void LauncherAngleUp() {
    	// difference variable is the up position minus the position it's actually at
    	double diff = (Robot.start - 0.23 /*0.24 is about the max height*/) - motorLauncherAngle.getPosition();
    	mult += 0.1;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void LauncherAngleDown() {
    	// difference variable is the down position minus where it's actually at
    	double diff = Robot.start - motorLauncherAngle.getPosition();
    	mult += 0.1;
    	if (mult > 10) mult = 10;
    	motorLauncherAngle.set(mult*diff);
    }
    
    public void LauncherAngleStop() {
    	motorLauncherAngle.set(0.0);
    }
}