package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
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

        if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorGroundID)){

            if(motor.getSelectedSensorPosition() <= Constants.Elevator.ground){
                //Go up to ground from the depths
            }
            else{
                //Go down to ground from the other 3
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
