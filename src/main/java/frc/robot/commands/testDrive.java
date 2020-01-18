/*----------------------------------------------------------------------------*/




/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import java.util.function.DoubleSupplier;

import com.ctre.phoenix.CANifier.PWMChannel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;;
/**
 * Have the robot drive tank style.
 */
public class testDrive extends CommandBase {
    
    private Joystick stick;
    
    private Double sliderAxis;
    private Spark sparkMotor;
  public testDrive() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    sparkMotor = new Spark(1);
    sliderAxis = stick.getRawAxis(3);
    sparkMotor.setSpeed(sliderAxis);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false; // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {

}
}