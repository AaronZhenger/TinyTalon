package team5427.frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RPM;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team5427.frc.robot.subsystems.Intake.io.IntakeIO;
import team5427.frc.robot.subsystems.Intake.io.IntakeIOInputsAutoLogged;
import team5427.frc.robot.subsystems.Intake.io.IntakeIOKraken;

public class IntakeSubsystem extends SubsystemBase {
    private IntakeIO intake;
    private IntakeIOInputsAutoLogged inputs;

    private Angle targetAngle = Degrees.of(0);
    private AngularVelocity targetSpeeds = RPM.of(0);

    public IntakeSubsystem() {
        intake = new IntakeIOKraken();
    }

    @Override
    public void periodic() {
        intake.updateInputs(inputs);
        intake.setPosition(targetAngle);
        intake.setSpeeds(targetSpeeds);
        log();
    }

    public void intake() {
        targetSpeeds = RPM.of(500);
    }

    public void stop() {
        targetSpeeds = RPM.of(0);
    }

    public void retract() {
        targetAngle = Degrees.of(0);
    }

    public void extrude() {
        targetAngle = Degrees.of(90);
    }

    public boolean pivotAtTarget() {
        return Math.abs(targetAngle.in(Degrees)-inputs.pivotPosition.in(Degrees))<=3;
    }

    private void log() {
        Logger.recordOutput("Pivot Setpoint", targetAngle);
        Logger.recordOutput("Flywheel Setpoint", targetAngle);

        Logger.recordOutput("Pivot Velocity", inputs.pivotVelocity);
        Logger.recordOutput("Pivot Acceleration", inputs.pivotAcceleration);
        Logger.recordOutput("Pivot Position", inputs.pivotPosition);
        Logger.recordOutput("Pivot Current", inputs.pivotCurrent);
        Logger.recordOutput("Pivot Voltage", inputs.pivotVoltage);

        Logger.recordOutput("Flywheel Velocity", inputs.flywheelVelocity);
        Logger.recordOutput("Flywheel Acceleration", inputs.flywheelAcceleration);
        Logger.recordOutput("Flywheel Current", inputs.flywheelCurrent);
        Logger.recordOutput("Flywheel Voltage", inputs.flywheelVoltage);
    }
}
