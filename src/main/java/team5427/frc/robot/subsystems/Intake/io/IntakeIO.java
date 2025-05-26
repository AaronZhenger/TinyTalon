package team5427.frc.robot.subsystems.Intake.io;

import org.littletonrobotics.junction.AutoLog;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;

public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public Angle pivotPosition = Angle.ofBaseUnits(0, Degrees);
        public AngularVelocity pivotVelocity = AngularVelocity.ofBaseUnits(0, RadiansPerSecond);
        public AngularAcceleration pivotAcceleration = AngularAcceleration.ofBaseUnits(0, RadiansPerSecondPerSecond);
        public Current pivotCurrent = Current.ofBaseUnits(0, Amps);
        public Voltage pivotVoltage = Voltage.ofBaseUnits(0, Volts);

        public AngularVelocity flywheelVelocity = AngularVelocity.ofBaseUnits(0, RadiansPerSecond);
        public AngularAcceleration flywheelAcceleration = AngularAcceleration.ofBaseUnits(0, RadiansPerSecondPerSecond);
        public Current flywheelCurrent = Current.ofBaseUnits(0, Amps);
        public Voltage flywheelVoltage = Voltage.ofBaseUnits(0, Volts);
    }

    public void updateInputs(IntakeIOInputsAutoLogged inputs);

    public void setSpeeds(AngularVelocity velocity);

    public void setPosition(Angle angle);
}