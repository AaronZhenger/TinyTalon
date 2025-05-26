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

    private Angle targetAngle = Angle.ofBaseUnits(0, Degrees);
    private AngularVelocity targetSpeeds = AngularVelocity.ofBaseUnits(0, RPM);

    public IntakeSubsystem() {
        intake = new IntakeIOKraken();
    }

    @Override
    public void periodic() {
        intake.updateInputs(inputs);
        intake.setPosition(targetAngle);
        intake.setSpeeds(targetSpeeds);
        Logger.recordOutput("Pivot Setpoint", targetAngle);
        Logger.recordOutput("Flywheel Setpoint", targetAngle);

        Logger.recordOutput("Pivot Velocity", inputs.pivotVelocity);
        Logger.recordOutput("Pivot Acceleration", inputs.pivotAcceleration);
        Logger.recordOutput("Pivot Position", inputs.pivotPosition);
        Logger.recordOutput("Pivot Current", inputs.pivotCurrent);
        Logger.recordOutput("Pivot Voltage", inputs.pivotVoltage);

        Logger.recordOutput("Flywheel Velocity", inputs.pivotVelocity);
        Logger.recordOutput("Flywheel Acceleration", inputs.pivotAcceleration);
        Logger.recordOutput("Flywheel Current", inputs.pivotCurrent);
        Logger.recordOutput("Flywheel Voltage", inputs.pivotVoltage);
    }

    public void intake() {
        targetSpeeds = AngularVelocity.ofBaseUnits(500, RPM);
    }

    public void stop() {
        targetSpeeds = AngularVelocity.ofBaseUnits(0, RPM);
    }

    public void retract() {
        targetAngle = Angle.ofBaseUnits(0, Degrees);
    }

    public void extrude() {
        targetAngle = Angle.ofBaseUnits(90, Degrees);
    }

    public boolean pivotAtTarget() {
        return Math.abs(targetAngle.in(Degrees)-inputs.pivotPosition.in(Degrees))<=3;
    }
}
