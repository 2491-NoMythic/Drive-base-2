// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private WPI_TalonFX driveLeftMotor1,driveRightMotor1;

  

 // private SpeedControllerGroup left = new SpeedControllerGroup(driveLeftMotor1);

  private ParcelIntake m_parcelIntake;
  private Elevator m_Elevator;
  private CarrierIntake m_CarrierIntake;

 private DifferentialDrive m_robotDrive;
  
  public final static Joystick PS4 = new Joystick(1);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void robotInit() {

    super.robotInit();

    m_parcelIntake = ParcelIntake.getInstance();
    m_Elevator = Elevator.getInstance();
    
    m_CarrierIntake = CarrierIntake.getInstance();

    driveLeftMotor1 = new WPI_TalonFX(Constants.DriveTrain.RightMotor_ID);
    driveRightMotor1 = new WPI_TalonFX(Constants.DriveTrain.LeftMotor_ID);

    driveRightMotor1.setInverted(InvertType.InvertMotorOutput);

    m_robotDrive = new DifferentialDrive(driveLeftMotor1, driveRightMotor1);
    m_robotDrive.setDeadband(0.04);
    m_robotDrive.setRightSideInverted(false);
    
  }

  @Override
  public void teleopInit() {
    // TODO Auto-generated method stub
    super.teleopInit();
    driveRightMotor1.setNeutralMode(NeutralMode.Brake);
    driveLeftMotor1.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    double m_SpeedManager = 1-(m_stick.getRawAxis(3)+1)/+2;
    m_parcelIntake.runIntake();
    m_Elevator.runElevator();
    m_CarrierIntake.RunIntake();

    SmartDashboard.putNumber("Slider", m_SpeedManager);

    m_robotDrive.curvatureDrive(m_stick.getY()*m_SpeedManager, m_stick.getZ()*m_SpeedManager, m_stick.getRawButton(1));
  }

  @Override
  public void disabledInit() {
    // TODO Auto-generated method stub
    super.disabledInit();
    driveRightMotor1.setNeutralMode(NeutralMode.Coast);
    driveLeftMotor1.setNeutralMode(NeutralMode.Coast);
  }
}
