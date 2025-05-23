// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team5427.frc.robot;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.math.util.Units;
import team5427.lib.drivers.CANDeviceId;
import team5427.lib.drivers.ComplexGearRatio;

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
    public static final ComplexGearRatio kPivotGearRatio = new ComplexGearRatio(1.0/8.0);
    public static final double kPivotP = 0.0;
    public static final double kPivotI = 0.0;
    public static final double kPivotD = 0.0;
    public static final double kPivotS = 0.0;
    public static final double kPivotG = 0.0;
    public static final double kPivotV = 0.0;
    public static final double kPivotA = 0.0;

    //Intake
    public static final ComplexGearRatio kIntakeGearRatio = new ComplexGearRatio(1.0/8.0);
    public static final double kIntakeP = 0.0;
    public static final double kIntakeI = 0.0;
    public static final double kIntakeD = 0.0;
    public static final double kIntakeS = 0.0;
    public static final double kIntakeG = 0.0;
    public static final double kIntakeV = 0.0;
    public static final double kIntakeA = 0.0;
  }
}
