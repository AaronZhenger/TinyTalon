package team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOKraken;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.ParentDevice;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import team5427.frc.robot.subsystems.Shooter.ShooterConstants;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIO;
import team5427.frc.robot.subsystems.Shooter.ShooterIO.ShooterIOInputsAutoLogged;
import team5427.lib.motors.SteelTalonFX;

public class ShooterIOKraken implements ShooterIO {
    private SteelTalonFX drivingFlywheel;
    private SteelTalonFX turretPivot;
    private SteelTalonFX topFlywheel;
    private SteelTalonFX bottomFlywheel;

    private StatusSignal<AngularVelocity> drivingFlywheelAngularVelocity;
    private StatusSignal<AngularAcceleration> drivingFlywheelAngularAcceleration;
    private StatusSignal<Current> drivingFlywheelCurrent;
    private StatusSignal<Voltage> drivingFlywheelVoltage;
    private StatusSignal<Temperature> drivingFlywheelTemperature;

    private StatusSignal<Angle> turretPosition;
    private StatusSignal<AngularVelocity> turretAngularVelocity;
    private StatusSignal<AngularAcceleration> turretAngularAcceleration;
    private StatusSignal<Current> turretCurrent;
    private StatusSignal<Voltage> turretVoltage;
    private StatusSignal<Temperature> turretTemperature;
    
    private StatusSignal<AngularVelocity> topFlywheelAngularVelocity;
    private StatusSignal<AngularAcceleration> topFlywheelAngularAcceleration;
    private StatusSignal<Current> topFlywheelCurrent;
    private StatusSignal<Voltage> topFlywheelVoltage;
    private StatusSignal<Temperature> topFlywheelTemperature;

    private StatusSignal<AngularVelocity> bottomFlywheelAngularVelocity;
    private StatusSignal<AngularAcceleration> bottomFlywheelAngularAcceleration;
    private StatusSignal<Current> bottomFlywheelCurrent;
    private StatusSignal<Voltage> bottomFlywheelVoltage;
    private StatusSignal<Temperature> bottomFlywheelTemperature;

    public ShooterIOKraken() {
        drivingFlywheel = new SteelTalonFX(ShooterConstants.kDrivingFlywheelID);
        turretPivot = new SteelTalonFX(ShooterConstants.kTurretPivotID);
        topFlywheel = new SteelTalonFX(ShooterConstants.kTopFlywheelID);
        bottomFlywheel = new SteelTalonFX(ShooterConstants.kBottomFlywheelID);

        drivingFlywheel.apply(ShooterConstants.kDrivingFlywheelConfiguration);
        turretPivot.apply(ShooterConstants.kTurretPivotConfiguration);
        topFlywheel.apply(ShooterConstants.kTopFlywheelConfiguration);
        bottomFlywheel.apply(ShooterConstants.kBottomFlywheelConfiguration);

        drivingFlywheelAngularVelocity = drivingFlywheel.getTalonFX().getVelocity();
        drivingFlywheelAngularAcceleration = drivingFlywheel.getTalonFX().getAcceleration();
        drivingFlywheelCurrent = drivingFlywheel.getTalonFX().getStatorCurrent();
        drivingFlywheelVoltage = drivingFlywheel.getTalonFX().getMotorVoltage();
        drivingFlywheelTemperature = drivingFlywheel.getTalonFX().getDeviceTemp();

        turretPosition = turretPivot.getTalonFX().getPosition();
        drivingFlywheelAngularVelocity = drivingFlywheel.getTalonFX().getVelocity();
        drivingFlywheelAngularAcceleration = drivingFlywheel.getTalonFX().getAcceleration();
        drivingFlywheelCurrent = drivingFlywheel.getTalonFX().getStatorCurrent();
        drivingFlywheelVoltage = drivingFlywheel.getTalonFX().getMotorVoltage();
        drivingFlywheelTemperature = drivingFlywheel.getTalonFX().getDeviceTemp();

        topFlywheelAngularVelocity = topFlywheel.getTalonFX().getVelocity();
        topFlywheelAngularAcceleration = topFlywheel.getTalonFX().getAcceleration();
        topFlywheelCurrent = topFlywheel.getTalonFX().getStatorCurrent();
        topFlywheelVoltage = topFlywheel.getTalonFX().getMotorVoltage();
        topFlywheelTemperature = topFlywheel.getTalonFX().getDeviceTemp();

        bottomFlywheelAngularVelocity = bottomFlywheel.getTalonFX().getVelocity();
        bottomFlywheelAngularAcceleration = bottomFlywheel.getTalonFX().getAcceleration();
        bottomFlywheelCurrent = bottomFlywheel.getTalonFX().getStatorCurrent();
        bottomFlywheelVoltage = bottomFlywheel.getTalonFX().getMotorVoltage();
        bottomFlywheelTemperature = bottomFlywheel.getTalonFX().getDeviceTemp();

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0, 
            drivingFlywheelAngularVelocity,
            drivingFlywheelAngularAcceleration,
            drivingFlywheelCurrent,
            drivingFlywheelVoltage
        );

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0, 
            turretPosition,
            turretAngularVelocity,
            turretAngularAcceleration,
            turretCurrent,
            turretVoltage
        );

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0, 
            topFlywheelAngularVelocity,
            topFlywheelAngularAcceleration,
            topFlywheelCurrent,
            topFlywheelVoltage
        );

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0, 
            bottomFlywheelAngularVelocity,
            bottomFlywheelAngularAcceleration,
            bottomFlywheelCurrent,
            bottomFlywheelVoltage
        );
        
        BaseStatusSignal.setUpdateFrequencyForAll(
            20.0, 
            drivingFlywheelTemperature,
            turretTemperature,
            topFlywheelTemperature,
            bottomFlywheelTemperature
        );

        ParentDevice.optimizeBusUtilizationForAll(
            drivingFlywheel.getTalonFX(),
            turretPivot.getTalonFX(),
            topFlywheel.getTalonFX(),
            bottomFlywheel.getTalonFX()
        );
    }

    @Override
    public void updateInputs(ShooterIOInputsAutoLogged inputs) {
        BaseStatusSignal.refreshAll(
            drivingFlywheelAngularVelocity,
            drivingFlywheelAngularAcceleration,
            drivingFlywheelCurrent,
            drivingFlywheelVoltage
        );

        BaseStatusSignal.refreshAll(
            turretPosition,
            turretAngularVelocity,
            turretAngularAcceleration,
            turretCurrent,
            turretVoltage
        );

        BaseStatusSignal.refreshAll(
            topFlywheelAngularVelocity,
            topFlywheelAngularAcceleration,
            topFlywheelCurrent,
            topFlywheelVoltage
        );

        BaseStatusSignal.refreshAll(
            bottomFlywheelAngularVelocity,
            bottomFlywheelAngularAcceleration,
            bottomFlywheelCurrent,
            bottomFlywheelVoltage
        );
        
        BaseStatusSignal.refreshAll(
            drivingFlywheelTemperature,
            turretTemperature,
            topFlywheelTemperature,
            bottomFlywheelTemperature
        );

        inputs.drivingFlywheelAngularVelocity = drivingFlywheelAngularVelocity.getValue();
        inputs.drivingFlywheelAngularAcceleration = drivingFlywheelAngularAcceleration.getValue();
        inputs.drivingFlywheelVoltage = drivingFlywheelVoltage.getValue();
        inputs.drivingFlywheelCurrent = drivingFlywheelCurrent.getValue();
        inputs.drivingFlywheelTemperature = drivingFlywheelTemperature.getValue();

        inputs.turretAngularVelocity = turretAngularVelocity.getValue();
        inputs.turretAngularAcceleration = turretAngularAcceleration.getValue();
        inputs.turretVoltage = turretVoltage.getValue();
        inputs.turretCurrent = turretCurrent.getValue();
        inputs.turretTemperature = turretTemperature.getValue();
        
        inputs.topFlywheelAngularVelocity = topFlywheelAngularVelocity.getValue();
        inputs.topFlywheelAngularAcceleration = topFlywheelAngularAcceleration.getValue();
        inputs.topFlywheelVoltage = topFlywheelVoltage.getValue();
        inputs.topFlywheelCurrent = topFlywheelCurrent.getValue();
        inputs.topFlywheelTemperature = topFlywheelTemperature.getValue();

        inputs.bottomFlywheelAngularVelocity = bottomFlywheelAngularVelocity.getValue();
        inputs.bottomFlywheelAngularAcceleration = bottomFlywheelAngularAcceleration.getValue();
        inputs.bottomFlywheelVoltage = bottomFlywheelVoltage.getValue();
        inputs.bottomFlywheelCurrent = bottomFlywheelCurrent.getValue();
        inputs.bottomFlywheelTemperature = bottomFlywheelTemperature.getValue();
    }

    @Override
    public void setDrivingFlywheelSpeed(LinearVelocity velocity) {
        drivingFlywheel.setSetpoint(velocity);
    }

    @Override
    public void setTurretAngle(Rotation2d angle) {
        turretPivot.setSetpoint(angle);
    }

    @Override
    public void setTopFlywheelSpeed(LinearVelocity velocity) {
        topFlywheel.setSetpoint(velocity);
    }

    @Override
    public void setBottomFlywheelSpeed(LinearVelocity velocity) {
        bottomFlywheel.setSetpoint(velocity);
    }
    
}
