package team5427.frc.robot.subsystems.Shooter;

import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.MotorConfiguration.IdleState;
import team5427.lib.motors.MotorConfiguration.MotorMode;

public class ShooterConstants {
    public static final CANDeviceId kDrivingFlywheelID = new CANDeviceId(7);
    public static final CANDeviceId kTurretPivotID = new CANDeviceId(8);
    public static final CANDeviceId kTopFlywheelID = new CANDeviceId(9);
    public static final CANDeviceId kBottomFlywheelID = new CANDeviceId(10);

    public static final MotorConfiguration kDrivingFlywheelConfiguration = new MotorConfiguration();
    public static final MotorConfiguration kTurretPivotConfiguration = new MotorConfiguration();
    public static final MotorConfiguration kTopFlywheelConfiguration = new MotorConfiguration();
    public static final MotorConfiguration kBottomFlywheelConfiguration = new MotorConfiguration();

    static {
        kDrivingFlywheelConfiguration.currentLimit = 40;
        kDrivingFlywheelConfiguration.finalDiameterMeters = 0.2;
        kDrivingFlywheelConfiguration.gearRatio = new ComplexGearRatio((1/4));
        kDrivingFlywheelConfiguration.idleState = IdleState.kCoast;
        kDrivingFlywheelConfiguration.kP = 0.0;
        kDrivingFlywheelConfiguration.kI = 0.0;
        kDrivingFlywheelConfiguration.kD = 0.0;
        kDrivingFlywheelConfiguration.isArm = false;
        kDrivingFlywheelConfiguration.isInverted = false;
        kDrivingFlywheelConfiguration.mode = MotorMode.kFlywheel;
        kDrivingFlywheelConfiguration.maxVelocity = 6000;
        kDrivingFlywheelConfiguration.maxAcceleration = 
            kDrivingFlywheelConfiguration.maxVelocity/3;
    }
    static {
        kTurretPivotConfiguration.currentLimit = 40;
        kTurretPivotConfiguration.finalDiameterMeters = 0.2;
        kTurretPivotConfiguration.gearRatio = new ComplexGearRatio((1/4));
        kTurretPivotConfiguration.idleState = IdleState.kCoast;
        kTurretPivotConfiguration.kP = 0.0;
        kTurretPivotConfiguration.kI = 0.0;
        kTurretPivotConfiguration.kD = 0.0;
        kTurretPivotConfiguration.isArm = false;
        kTurretPivotConfiguration.isInverted = false;
        kTurretPivotConfiguration.mode = MotorMode.kServo;
        kTurretPivotConfiguration.maxVelocity = 6000;
        kTurretPivotConfiguration.maxAcceleration = 
            kTurretPivotConfiguration.maxVelocity/3;
    }
    static {
        kTopFlywheelConfiguration.currentLimit = 40;
        kTopFlywheelConfiguration.finalDiameterMeters = 0.2;
        kTopFlywheelConfiguration.gearRatio = new ComplexGearRatio((1/4));
        kTopFlywheelConfiguration.idleState = IdleState.kCoast;
        kTopFlywheelConfiguration.kP = 0.0;
        kTopFlywheelConfiguration.kI = 0.0;
        kTopFlywheelConfiguration.kD = 0.0;
        kTopFlywheelConfiguration.isArm = false;
        kTopFlywheelConfiguration.isInverted = false;
        kTopFlywheelConfiguration.mode = MotorMode.kFlywheel;
        kTopFlywheelConfiguration.maxVelocity = 6000;
        kTopFlywheelConfiguration.maxAcceleration = 
            kTopFlywheelConfiguration.maxVelocity/3;
    }
    static {
        kBottomFlywheelConfiguration.currentLimit = 40;
        kBottomFlywheelConfiguration.finalDiameterMeters = 0.2;
        kBottomFlywheelConfiguration.gearRatio = new ComplexGearRatio((1/4));
        kBottomFlywheelConfiguration.idleState = IdleState.kCoast;
        kBottomFlywheelConfiguration.kP = 0.0;
        kBottomFlywheelConfiguration.kI = 0.0;
        kBottomFlywheelConfiguration.kD = 0.0;
        kBottomFlywheelConfiguration.isArm = false;
        kBottomFlywheelConfiguration.isInverted = false;
        kBottomFlywheelConfiguration.mode = MotorMode.kFlywheel;
        kBottomFlywheelConfiguration.maxVelocity = 6000;
        kBottomFlywheelConfiguration.maxAcceleration = 
            kBottomFlywheelConfiguration.maxVelocity/3;
    }
}
