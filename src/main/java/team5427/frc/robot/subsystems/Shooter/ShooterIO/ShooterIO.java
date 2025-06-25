package team5427.frc.robot.subsystems.Shooter.ShooterIO;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;

public interface ShooterIO {
    @AutoLog
    public static class ShooterIOInputs {
        public AngularVelocity drivingFlywheelAngularVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration drivingFlywheelAngularAcceleration = RadiansPerSecondPerSecond.of(0);
        public Current drivingFlywheelCurrent = Amps.of(0);
        public Voltage drivingFlywheelVoltage = Volts.of(0);
        public Temperature drivingFlywheelTemperature = Celsius.of(0);

        public Rotation2d turretAngle = new Rotation2d();
        public AngularVelocity turretAngularVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration turretAngularAcceleration = RadiansPerSecondPerSecond.of(0);
        public Current turretCurrent = Amps.of(0);
        public Voltage turretVoltage = Volts.of(0);
        public Temperature turretTemperature = Celsius.of(0);

        public AngularVelocity topFlywheelAngularVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration topFlywheelAngularAcceleration = RadiansPerSecondPerSecond.of(0);
        public Current topFlywheelCurrent = Amps.of(0);
        public Voltage topFlywheelVoltage = Volts.of(0);
        public Temperature topFlywheelTemperature = Celsius.of(0);

        public AngularVelocity bottomFlywheelAngularVelocity = RadiansPerSecond.of(0);
        public AngularAcceleration bottomFlywheelAngularAcceleration = RadiansPerSecondPerSecond.of(0);
        public Current bottomFlywheelCurrent = Amps.of(0);
        public Voltage bottomFlywheelVoltage = Volts.of(0);
        public Temperature bottomFlywheelTemperature = Celsius.of(0);
    }

    public void updateInputs(ShooterIOInputsAutoLogged inputs);

    public void setDrivingFlywheelSpeed(LinearVelocity velocity);

    public void setTurretAngle(Rotation2d angle);

    public void setTopFlywheelSpeed(LinearVelocity velocity);

    public void setBottomFlywheelSpeed(LinearVelocity velocity);
}
