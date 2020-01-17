/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import java.util.function.DoubleSupplier;

public class DriveTrain extends SubsystemBase {
  /**
   * Drive Train.
   */

  
    TalonFX m_leftMotor;
    TalonFX m_leftMotor_1;
    TalonFX m_rightMotor;
    TalonFX m_rightMotor_1;
    DifferentialDrive m_drive;
    
  public DriveTrain() {
    
    super();


    m_leftMotor = new TalonFX(1);
    m_leftMotor_1 = new TalonFX(3);

    m_rightMotor = new TalonFX(2);
    m_rightMotor_1 = new TalonFX(4);
    

    m_leftMotor.set(ControlMode.PercentOutput,1);
    m_leftMotor_1.set(ControlMode.PercentOutput,3);
    m_leftMotor_1.follow(m_leftMotor);

    m_rightMotor.set(ControlMode.PercentOutput,2);
    m_rightMotor_1.set(ControlMode.PercentOutput,4); 
    m_rightMotor_1.follow(m_rightMotor);

  }
  public void drive(double left, double right){
    if(m_drive != null){

    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}