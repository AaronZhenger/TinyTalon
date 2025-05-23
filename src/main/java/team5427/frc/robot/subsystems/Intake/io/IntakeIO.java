package team5427.frc.robot.subsystems.Intake.io;

import org.littletonrobotics.junction.AutoLog;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;

public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public Angle pivotPosition = Angle.ofBaseUnits(0, Degrees);
        public AngularVelocity pivotSpeed = AngularVelocity.ofBaseUnits(0, RadiansPerSecond);
        public AngularAcceleration pivotAcceleration = AngularAcceleration.ofBaseUnits(0, RadiansPerSecondPerSecond);

        public AngularVelocity intakeSpeed = AngularVelocity.ofBaseUnits(0, RadiansPerSecond);
        public AngularAcceleration intakeAcceleration = AngularAcceleration.ofBaseUnits(0, RadiansPerSecondPerSecond);
    }

    public void updateInputs(IntakeIOInputsAutoLogged inputs);

    public void setSpeeds(AngularVelocity velocity);

    public void setPosition(Angle angle);
}