package team5427.frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team5427.frc.robot.subsystems.Intake.io.IntakeIO;
import team5427.frc.robot.subsystems.Intake.io.IntakeIOKraken;

public class IntakeSubsystem extends SubsystemBase {
    private IntakeIO intake;

    public IntakeSubsystem() {
        intake = new IntakeIOKraken();
    }

    @Override
    public void periodic() {
        
    }

    public void intake() {
    }

    public void stop() {
    }

    public void output() {
    }

    public void retract() {
    }

    public void extrude() {
    }
}
