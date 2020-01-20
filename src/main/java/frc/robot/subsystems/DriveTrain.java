/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.*;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain extends SubsystemBase {
  /**
   * Drive Train.
   */

  
    TalonFX m_leftMotor;
    TalonFX m_leftMotor_1;
    TalonFX m_rightMotor;
    TalonFX m_rightMotor_1;
    DifferentialDrive m_drive;
    Joystick stick;
    
  public DriveTrain() {
    
    super();

    stick = new Joystick(0);

    m_leftMotor = new TalonFX(1);
    m_leftMotor_1 = new TalonFX(3);
    m_leftMotor.setInverted(false);
    m_leftMotor_1.setInverted(false);
    
    m_rightMotor = new TalonFX(2);
    m_rightMotor_1 = new TalonFX(4);
    m_rightMotor.setInverted(true);
    m_rightMotor_1.setInverted(true);

    m_leftMotor.set(ControlMode.PercentOutput,1);
    m_leftMotor_1.set(ControlMode.PercentOutput,3);
    m_leftMotor_1.follow(m_leftMotor);

    m_rightMotor.set(ControlMode.PercentOutput,2);
    m_rightMotor_1.set(ControlMode.PercentOutput,4); 
    m_rightMotor_1.follow(m_rightMotor);

    //m_drive = new DifferentialDrive(m_rightMotor, m_leftMotor);

    /*
    m_leftMotor.set(ControlMode.PercentOutput,3);
    m_leftMotor_1.set(ControlMode.PercentOutput,1);
    m_leftMotor_1.follow(m_leftMotor);

    m_rightMotor.set(ControlMode.PercentOutput,4);
    m_rightMotor_1.set(ControlMode.PercentOutput,2); 
    m_rightMotor_1.follow(m_rightMotor);
    */
  }
  public void drive(double left, double right){
    if(m_drive != null){
      right = -(stick.getRawAxis(2) - stick.getRawAxis((3)));
      left = (stick.getRawAxis(2) + stick.getRawAxis((3)));

      m_drive.arcadeDrive(0-right, 0-left);
    }
  }
  public void driveAround() {
    // Update motor speed to passed in value
    double forward = 1 * stick.getRawAxis(2);
    double turn = stick.getRawAxis(3);

    forward = Deadband(forward);
    turn = Deadband(turn);
    m_leftMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn*.55);
    m_rightMotor_1.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn*.55);
    m_drive.arcadeDrive(-forward, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  double Deadband(double value) {
    /* Upper deadband */
    if (value >= +0.35) 
        return value;
    
    /* Lower deadband */
    if (value <= -0.35)
        return value;
    
    /* Outside deadband */
    return 0;
  }
}