/*----------------------------------------------------------------------------*/




/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
/**
 * Have the robot drive tank style.
 */
public class ArcadeDrive extends CommandBase {
    private final DriveTrain m_drivetrain;
    
    private final DoubleSupplier m_left;
    private final DoubleSupplier m_right;
    private Joystick stick;
    private Double xAxis;
    private Double yAxis;
    private Double zAxis;   
  

  public ArcadeDrive(DoubleSupplier left, DoubleSupplier right, DriveTrain drivetrain) {
    m_left = left;
    m_right = right;
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_drivetrain.drive(-m_left.getAsDouble(),-m_right.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false; // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }
}