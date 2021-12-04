package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends TimedRobot {
    WPI_TalonSRX motor;
    private static Elevator instance = null; 

    public static Elevator getInstance()
    {
        if(instance == null)
        {
            instance = new Elevator();
        }
      return instance;  
    }

    private Elevator(){
        //use talon srx
        motor = new WPI_TalonSRX(Constants.Elevator.Motor_ID);

        motor.setNeutralMode(NeutralMode.Brake);
        motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        motor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        
       
    }

    public void runElevator() // fix 
    {
        SmartDashboard.putNumber("Elevator encoder distance", motor.getSelectedSensorPosition());

        if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorUpID)){
            //up
            rotateMotor(Constants.Elevator.UpSpeed);
        } 
        else if (Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorDownID))
        {
            //down
            rotateMotor(Constants.Elevator.DownSpeed);
        }
        else if (Robot.PS4.getRawButtonReleased(Constants.PS4.ElevatorDownID) || (Robot.PS4.getRawButtonReleased(Constants.PS4.ElevatorUpID)))
        {
            stopMotor();
        }

        
        //Ground
        if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorGroundID)){
                while (motor.getSelectedSensorPosition() <= Constants.Elevator.ground)
                {
                    rotateMotor(Constants.Elevator.UpSpeed);
                    //move up to ground
                }
                while (motor.getSelectedSensorPosition() >= Constants.Elevator.ground)
                {
                    rotateMotor(Constants.Elevator.DownSpeed);
                    //move down to ground.
                }
        }
        //DRIVE

         if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorDriveID)){
                while (motor.getSelectedSensorPosition() <= Constants.Elevator.drive)
                {
                    rotateMotor(Constants.Elevator.UpSpeed);
                    //move up to drive
                }
                while (motor.getSelectedSensorPosition() >= Constants.Elevator.drive)
                {
                    rotateMotor(Constants.Elevator.DownSpeed);
                    //move down to drive
                }
            }

        //LOW

            if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorLowShelfID)){
                while (motor.getSelectedSensorPosition() <= Constants.Elevator.low_shelf)
                {
                    rotateMotor(Constants.Elevator.UpSpeed);
                    //move up to drive
                    }
                while (motor.getSelectedSensorPosition() >= Constants.Elevator.low_shelf)
                {
                    rotateMotor(Constants.Elevator.DownSpeed);
                    //move down to drive
                }
            }

            //HIGH
            if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorHighShelfID)){
                while (motor.getSelectedSensorPosition() <= Constants.Elevator.high_shelf)
                {
                    rotateMotor(Constants.Elevator.UpSpeed);
                    //move up to drive
                }
                while (motor.getSelectedSensorPosition() >= Constants.Elevator.high_shelf)
                {
                    rotateMotor(Constants.Elevator.DownSpeed);
                  //move down to drive
                }
            }
        
    }
        



    public void rotateMotor(double speed)
    {
        motor.set(speed);
    }

    public void stopMotor() {
        motor.set(0);
      }
}
