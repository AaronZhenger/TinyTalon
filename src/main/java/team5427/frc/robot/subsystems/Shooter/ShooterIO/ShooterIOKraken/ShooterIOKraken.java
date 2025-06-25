package team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOKraken;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.LinearVelocity;
import team5427.frc.robot.subsystems.Shooter.ShooterConstants;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIO;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOInputsAutoLogged;
import team5427.lib.motors.SteelTalonFX;

public class ShooterIOKraken implements ShooterIO {
    private SteelTalonFX drivingFlywheel;
    private SteelTalonFX turretPivot;
    private SteelTalonFX topFlywheel;
    private SteelTalonFX bottomFlywheel;

    public ShooterIOKraken() {
        drivingFlywheel = new SteelTalonFX(ShooterConstants.kDrivingFlywheelID);
        turretPivot = new SteelTalonFX(ShooterConstants.kTurretPivotID);
        topFlywheel = new SteelTalonFX(ShooterConstants.kTopFlywheelID);
        bottomFlywheel = new SteelTalonFX(ShooterConstants.kBottomFlywheelID);

        drivingFlywheel.apply(ShooterConstants.kDrivingFlywheelConfiguration);
        turretPivot.apply(ShooterConstants.kTurretPivotConfiguration);
        topFlywheel.apply(ShooterConstants.kTopFlywheelConfiguration);
        bottomFlywheel.apply(ShooterConstants.kBottomFlywheelConfiguration);
    }

    @Override
    public void updateInputs(ShooterIOInputsAutoLogged inputs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInputs'");
    }

    @Override
    public void setDrivingFlywheelSpeed(LinearVelocity velocity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDrivingFlywheelSpeed'");
    }

    @Override
    public void setTurretAngle(Rotation2d angle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTurretAngle'");
    }

    @Override
    public void setTopFlywheelSpeed(LinearVelocity velocity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTopFlywheelSpeed'");
    }

    @Override
    public void setBottomFlywheelSpeed(LinearVelocity velocity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBottomFlywheelSpeed'");
    }
    
}
