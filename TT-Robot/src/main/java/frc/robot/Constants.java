package frc.robot;

public final class Constants {
   // public static final int ParcelIntake_ID = 2491;

    public final class PS4{        
        public static final int parcelIntakeID = 1;
        public static final int parcelOuttakeID = 2; 

        public static final int CarrierIntakeID = 3;
        public static final int CarrierOuttakeID = 4;

        public static final int ElevatorUpID = 5;
        public static final int ElevatorDownID = 6;

        public static final int ElevatorGroundID = 7;
        public static final int ElevatorDriveID = 8;
        public static final int ElevatorLowShelfID = 9;
        public static final int ElevatorHighShelfID = 10;
     //   public static final int CarrierOutttakeSpeedID= 2491; 
    }

    public final class CarrierIntake{
        public static final double IntakeSpeed = 0.5;
        public static final double OuttakeSpeed = 0.5; 
        public static final int MotorID = 2491;
    }

    public final class ParcelIntake{
        public static final double IntakeSpeed = 0.5;
        public static final double OuttakeSpeed = 0.5;
        public static final int Motor_ID = 3;
    }

    public final class DriveTrain{
        public static final int RightMotor_ID = 4;
        public static final int LeftMotor_ID = 5;
    }

    public final class Elevator{
        public static final int Motor_ID = 7;
        public static final double UpSpeed = .5;
        public static final double DownSpeed = .5;
        public static final int ground = 0;
        public static final int drive = 100;
        public static final int low_shelf = 200;
        public static final int high_shelf = 300;
      }
}
