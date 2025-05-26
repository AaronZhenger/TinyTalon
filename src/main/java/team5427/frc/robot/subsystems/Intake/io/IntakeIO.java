package team5427.frc.robot.subsystems.Intake.io;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
  @AutoLog
  public static class IntakeIOInputs {
    public Angle pivotPosition = Degrees.of(0);
    public AngularVelocity pivotVelocity = RPM.of(0);
    public AngularAcceleration pivotAcceleration = RadiansPerSecondPerSecond.of(0);
    public Current pivotCurrent = Amps.of(0);
    public Voltage pivotVoltage = Volts.of(0);
    public Temperature pivotTemperature = Celsius.of(0);

    public AngularVelocity flywheelVelocity = pivotVelocity = RPM.of(0);
    public AngularAcceleration flywheelAcceleration = RadiansPerSecondPerSecond.of(0);
    public Current flywheelCurrent = Amps.of(0);
    public Voltage flywheelVoltage = Volts.of(0);
    public Temperature flywheelTemperature = Celsius.of(0);
  }

  public void updateInputs(IntakeIOInputsAutoLogged inputs);

  public void setSpeeds(AngularVelocity velocity);

  public void setPosition(Angle angle);
}
