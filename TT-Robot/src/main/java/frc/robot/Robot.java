// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private WPI_TalonFX driveLeftMotor1,driveRightMotor1;

  

 // private SpeedControllerGroup left = new SpeedControllerGroup(driveLeftMotor1);

  private ParcelIntake m_parcelIntake;

 private DifferentialDrive m_robotDrive;
  
  public final static Joystick PS4 = new Joystick(2491);
  private final Joystick m_stick = new Joystick(2491);

  @Override
  public void robotInit() {

    super.robotInit();

    m_parcelIntake = ParcelIntake.getInstance();

    driveLeftMotor1 = new WPI_TalonFX(Constants.RightMotor_ID);
    driveRightMotor1 = new WPI_TalonFX(Constants.LeftMotor_ID);

    m_robotDrive = new DifferentialDrive(driveLeftMotor1, driveRightMotor1);

    
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_parcelIntake.RunIntake();

    m_robotDrive.curvatureDrive(m_stick.getY(), m_stick.getX(), false);
  }
}
