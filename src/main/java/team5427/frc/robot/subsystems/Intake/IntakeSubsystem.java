package team5427.frc.robot.subsystems.Intake;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;
import team5427.frc.robot.subsystems.Intake.io.IntakeIO;
import team5427.frc.robot.subsystems.Intake.io.IntakeIOInputsAutoLogged;
import team5427.frc.robot.subsystems.Intake.io.IntakeIOKraken;

public class IntakeSubsystem extends SubsystemBase {
  private IntakeIO intake;
  private IntakeIOInputsAutoLogged inputsAutoLogged;

  private Angle targetAngle = Degrees.of(0);
  private LinearVelocity targetSpeeds = MetersPerSecond.of(0);

  public IntakeSubsystem() {
    intake = new IntakeIOKraken();
  }

  @Override
  public void periodic() {
    intake.updateInputs(inputsAutoLogged);
    intake.setPosition(targetAngle);
    intake.setSpeeds(targetSpeeds);
    Logger.processInputs("IntakeInputsAutologged", inputsAutoLogged);
  }

  public void setTargetAngle(Angle targetAngle) {
    this.targetAngle = targetAngle;
  }

  public void setTargetSpeeds(LinearVelocity targetSpeeds) {
    this.targetSpeeds = targetSpeeds;
  }

  public boolean pivotAtTarget() {
    return Math.abs(targetAngle.in(Degrees) - inputsAutoLogged.pivotPosition.in(Degrees)) <= 3;
  }
}
