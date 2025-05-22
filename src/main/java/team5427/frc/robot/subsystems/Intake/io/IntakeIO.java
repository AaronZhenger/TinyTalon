package team5427.frc.robot.subsystems.Intake.io;

import org.littletonrobotics.junction.AutoLog;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface IntakeIO {
    @AutoLog
    public static class IntakeIOInputs {
        public Angle pivotPosition = Angle.ofBaseUnits(0, Degrees);
        public AngularVelocity pivotSpeed = AngularVelocity.ofBaseUnits(0, RadiansPerSecond);
    }

    public void updateInputs(IntakeIOInputsAutoLogged inputs);

    public void setSpeeds(AngularVelocity velocity);

    public void setPosition(Angle angle);
}