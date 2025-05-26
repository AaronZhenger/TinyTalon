package team5427.frc.robot.subsystems.Intake;

import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.MotorConfiguration.MotorMode;

public class IntakeConstants {
  public static final CANDeviceId kPivotID = new CANDeviceId(5);
  public static final CANDeviceId kFlywheelID = new CANDeviceId(6);

  // Pivot
  public static final ComplexGearRatio kPivotGearRatio =
      new ComplexGearRatio((30.0 / 30.0), (18.0 / 52.0), (18.0 / 52.0), (18.0 / 36.0));
  public static final double kPivotMaxRPM = 5800.0;
  public static final int kPivotMaxCurrent = 40;

  // Flywheel
  public static final ComplexGearRatio kFlywheelGearRatio = new ComplexGearRatio((18.0 / 36.0));
  public static final double kFlywheelMaxRPM = 7530.0;
  public static final int kFlywheelMaxCurrent = 40;

  // Configs
  public static final MotorConfiguration kPivotConfiguration = new MotorConfiguration();
  public static final MotorConfiguration kFlywheelConfiguration = new MotorConfiguration();

  static {
    kPivotConfiguration.mode = MotorMode.kServo;
    kPivotConfiguration.currentLimit = kPivotMaxCurrent;
    kPivotConfiguration.idleState = MotorConfiguration.IdleState.kBrake;
    kPivotConfiguration.gearRatio = kPivotGearRatio;
    kPivotConfiguration.kP = 0.0;
    kPivotConfiguration.kI = 0.0;
    kPivotConfiguration.kD = 0.0;
    kPivotConfiguration.kG = 0.29;
    kPivotConfiguration.kV = 0.33;
    kPivotConfiguration.kA = 0.02;
    kPivotConfiguration.isArm = true;
    kPivotConfiguration.withFOC = true;
    kPivotConfiguration.isInverted = true;
    kPivotConfiguration.maxVelocity = kPivotConfiguration.getStandardMaxVelocity(kPivotMaxRPM);
    kPivotConfiguration.maxAcceleration = kPivotConfiguration.maxVelocity / 2;
  }

  static {
    kFlywheelConfiguration.mode = MotorMode.kFlywheel;
    kFlywheelConfiguration.currentLimit = kFlywheelMaxCurrent;
    kFlywheelConfiguration.idleState = MotorConfiguration.IdleState.kCoast;
    kFlywheelConfiguration.gearRatio = kFlywheelGearRatio;
    kFlywheelConfiguration.kP = 0.0;
    ;
    kFlywheelConfiguration.kI = 0.0;
    ;
    kFlywheelConfiguration.kD = 0.0;
    ;
    kFlywheelConfiguration.kV = 1.20;
    ;
    kFlywheelConfiguration.kA = 0.02;
    ;
    kFlywheelConfiguration.isArm = false;
    kFlywheelConfiguration.withFOC = false;
    kFlywheelConfiguration.isInverted = false;
    kFlywheelConfiguration.maxVelocity =
        kFlywheelConfiguration.getStandardMaxVelocity(kFlywheelMaxRPM);
    kFlywheelConfiguration.maxAcceleration = kFlywheelConfiguration.maxVelocity / 2.0;
  }
}
