// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team5427.frc.robot;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.math.util.Units;
import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.MotorConfiguration.MotorMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final String kCanivoreBusName = "canivore_bus_name";
  public static final double kOdometryFrequency =
      new CANBus(Constants.kCanivoreBusName).isNetworkFD() ? 250.0 : 100.0;

  public static Mode currentMode = Mode.REAL;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static final double kLoopSpeed = Units.millisecondsToSeconds(20);

  public static final boolean kIsTuningMode = false;

  public static class DriverConstants {
    public static final int kDriverJoystickPort = 0;
    public static final int kOperatorJoystickPort = 1;
    public static final double kDriverControllerJoystickDeadzone = 0.0;
  }

  public static class IntakeConstants {
    public static final CANDeviceId kPivotID = new CANDeviceId(5);
    public static final CANDeviceId kFlywheelID = new CANDeviceId(6);

    //Pivot
    public static final ComplexGearRatio kPivotGearRatio = new ComplexGearRatio((30.0/30.0), (18.0/52.0), (18.0/52.0), (18.0/36.0));
    public static final double kPivotMaxRPM = 5800.0;
    public static final int kPivotMaxCurrent = 40;
    public static final double kPivotP = 0.0;
    public static final double kPivotI = 0.0;
    public static final double kPivotD = 0.0;
    public static final double kPivotG = 0.29;
    public static final double kPivotV = 0.33;
    public static final double kPivotA = 0.02;

    //Flywheel
    public static final ComplexGearRatio kFlywheelGearRatio = new ComplexGearRatio((18.0/36.0));
    public static final double kFlywheelMaxRPM = 7530.0;
    public static final int kFlywheelMaxCurrent = 40;
    public static final double kFlywheelP = 0.0;
    public static final double kFlywheelI = 0.0;
    public static final double kFlywheelD = 0.0;
    public static final double kFlywheelV = 1.20;
    public static final double kFlywheelA = 0.03;

    //Configs
    public static final MotorConfiguration pivotConfig = new MotorConfiguration();
    public static final MotorConfiguration flywheelConfig = new MotorConfiguration();
    
    static {
      pivotConfig.mode = MotorMode.kServo;
      pivotConfig.currentLimit = kPivotMaxCurrent;
      pivotConfig.idleState = MotorConfiguration.IdleState.kBrake;
      pivotConfig.gearRatio = kPivotGearRatio;
      pivotConfig.kP = kPivotP;
      pivotConfig.kI = kPivotI;
      pivotConfig.kD = kPivotD;
      pivotConfig.kG = kPivotG;
      pivotConfig.kV = kPivotV;
      pivotConfig.kA = kPivotA;
      pivotConfig.isArm = true;
      pivotConfig.withFOC = true;
      pivotConfig.isInverted = true;
      pivotConfig.maxVelocity = pivotConfig.getStandardMaxVelocity(kPivotMaxRPM);
      pivotConfig.maxAcceleration = pivotConfig.maxVelocity/2;

      flywheelConfig.mode = MotorMode.kFlywheel;
      flywheelConfig.currentLimit = kFlywheelMaxCurrent;
      flywheelConfig.idleState = MotorConfiguration.IdleState.kCoast;
      flywheelConfig.gearRatio = kFlywheelGearRatio;
      flywheelConfig.kP = kFlywheelP;
      flywheelConfig.kI = kFlywheelI;
      flywheelConfig.kD = kFlywheelD;
      flywheelConfig.kV = kFlywheelV;
      flywheelConfig.kA = kFlywheelA;
      flywheelConfig.isArm = false;
      flywheelConfig.withFOC = true;
      pivotConfig.isInverted = false;
      flywheelConfig.maxVelocity = flywheelConfig.getStandardMaxVelocity(kFlywheelMaxRPM);
      flywheelConfig.maxAcceleration = flywheelConfig.maxVelocity/2;
    }
  }
}
