package team5427.frc.robot.subsystems.Shooter;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIO;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOInputsAutoLogged;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOKraken.ShooterIOKraken;

public class ShooterSubsystem extends SubsystemBase {
    private ShooterIO io;
    private ShooterIOInputsAutoLogged inputsAutoLogged;

    private LinearVelocity processVelocity;
    private Rotation2d turretSetpoint;
    //* private Rotation2d shooterPitchSetpoint

    public ShooterSubsystem() {
        io = new ShooterIOKraken();
        inputsAutoLogged = new ShooterIOInputsAutoLogged();
    }

    @Override
    public void periodic() {
        io.setDrivingFlywheelSpeed(processVelocity);
        io.setTurretAngle(turretSetpoint);
        //! io.setTopFlywheelSpeed(null);
        //! io.setBottomFlywheelSpeed(null);
        io.updateInputs(inputsAutoLogged);
        Logger.processInputs("ShooterInputsAutoLogged", inputsAutoLogged);
    }

    public void setProcessVelocity(LinearVelocity processVelocity) {
        this.processVelocity = processVelocity;
    }

    public void setTurretSetpoint(Rotation2d turretSetpoint) {
        this.turretSetpoint = turretSetpoint;
    }
}
