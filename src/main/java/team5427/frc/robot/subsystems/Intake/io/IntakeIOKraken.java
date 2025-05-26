package team5427.frc.robot.subsystems.Intake.io;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.ParentDevice;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import team5427.frc.robot.Constants.IntakeConstants;
import team5427.lib.motors.SteelTalonFX;

public class IntakeIOKraken implements IntakeIO {
    private SteelTalonFX pivot;
    private SteelTalonFX flywheel;

    private StatusSignal<Angle> pivotPosition;
    private StatusSignal<AngularVelocity> pivotVelocity;
    private StatusSignal<AngularAcceleration> pivotAcceleration;
    private StatusSignal<Current> pivotCurrent;
    private StatusSignal<Voltage> pivotVoltage;

    private StatusSignal<AngularVelocity> flywheelVelocity;
    private StatusSignal<AngularAcceleration> flywheelAcceleration;
    private StatusSignal<Current> flywheelCurrent;
    private StatusSignal<Voltage> flywheelVoltage;

    public IntakeIOKraken() {
        pivot = new SteelTalonFX(IntakeConstants.kPivotID);
        flywheel = new SteelTalonFX(IntakeConstants.kFlywheelID);
        pivot.apply(IntakeConstants.pivotConfig);
        flywheel.apply(IntakeConstants.flywheelConfig);

        //SS
        pivotPosition = pivot.getTalonFX().getPosition();
        pivotVelocity = pivot.getTalonFX().getVelocity();
        pivotAcceleration = pivot.getTalonFX().getAcceleration();
        pivotCurrent = pivot.getTalonFX().getStatorCurrent();
        pivotVoltage = pivot.getTalonFX().getMotorVoltage();

        flywheelVelocity = flywheel.getTalonFX().getVelocity();
        flywheelAcceleration = flywheel.getTalonFX().getAcceleration();
        flywheelCurrent = flywheel.getTalonFX().getStatorCurrent();
        flywheelVoltage = flywheel.getTalonFX().getMotorVoltage();

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0,
            pivotPosition,
            pivotVelocity,
            pivotAcceleration,
            pivotCurrent,
            pivotVoltage
        );

        BaseStatusSignal.setUpdateFrequencyForAll(
            50.0,
            flywheelVelocity,
            flywheelAcceleration,
            flywheelCurrent,
            flywheelVoltage
        );

        ParentDevice.optimizeBusUtilizationForAll(
            pivot.getTalonFX(), flywheel.getTalonFX()
        );
    }

    @Override
    public void updateInputs(IntakeIOInputsAutoLogged inputs) {
        inputs.pivotPosition = pivotPosition.getValue();
        inputs.pivotVelocity = pivotVelocity.getValue();
        inputs.pivotAcceleration = pivotAcceleration.getValue();
        inputs.pivotCurrent = pivotCurrent.getValue();
        inputs.pivotVoltage = pivotVoltage.getValue();

        inputs.flywheelVelocity = flywheelVelocity.getValue();
        inputs.flywheelAcceleration = flywheelAcceleration.getValue();
        inputs.flywheelCurrent = flywheelCurrent.getValue();
        inputs.flywheelVoltage = flywheelVoltage.getValue();
    }

    @Override
    public void setSpeeds(AngularVelocity velocity) {
        flywheel.setSetpoint(velocity);
    }

    @Override
    public void setPosition(Angle angle) {
        pivot.setSetpoint(angle);
    }
}
