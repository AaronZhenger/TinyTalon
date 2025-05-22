package team5427.frc.robot.subsystems.Intake.io;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import team5427.frc.robot.Constants.IntakeConstants;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.MotorConfiguration;
import team5427.lib.motors.SteelTalonFX;
import team5427.lib.motors.MotorConfiguration.MotorMode;

public class IntakeIOKraken implements IntakeIO {
    private SteelTalonFX pivot;
    private SteelTalonFX flywheel;

    private MotorConfiguration pivotConfig;
    private MotorConfiguration flywheelConfig;

    public IntakeIOKraken() {
        pivot = new SteelTalonFX(IntakeConstants.kPivotID);
        flywheel = new SteelTalonFX(IntakeConstants.kFlywheelID);

        //Configs
        pivotConfig.mode = MotorMode.kServo;
        pivotConfig.currentLimit = 40;
        pivotConfig.idleState = MotorConfiguration.IdleState.kBrake;
        pivotConfig.gearRatio = new ComplexGearRatio(1.0/8.0);
        pivotConfig.kP = 0.0;
        pivotConfig.kI = 0.0;
        pivotConfig.kD = 0.0;
        pivotConfig.isArm = true;
        pivotConfig.maxVelocity = 5;
        pivotConfig.maxAcceleration = 5;

        flywheelConfig.mode = MotorMode.kFlywheel;
        flywheelConfig.currentLimit = 40;
        flywheelConfig.idleState = MotorConfiguration.IdleState.kCoast;
        flywheelConfig.gearRatio = new ComplexGearRatio(1.0/8.0);
        flywheelConfig.kP = 0.0;
        flywheelConfig.kI = 0.0;
        flywheelConfig.kD = 0.0;
        flywheelConfig.isArm = false;
        flywheelConfig.maxVelocity = 5;
        flywheelConfig.maxAcceleration = 5;

        pivot.apply(pivotConfig);
        flywheel.apply(flywheelConfig);
    }

    @Override
    public void setSpeeds(AngularVelocity velocity) {
        flywheel.setSetpoint(velocity);
    }

    @Override
    public void setPosition(Angle angle) {
        pivot.setSetpoint(angle);
    }

    @Override
    public void updateInputs(IntakeIOInputsAutoLogged inputs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInputs'");
    }
}
