package team5427.frc.robot.subsystems.Intake.io;

import com.ctre.phoenix6.StatusSignal;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
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

    private StatusSignal<Angle> pivotPosition;
    private StatusSignal<AngularVelocity> pivotSpeed;
    private StatusSignal<AngularAcceleration> pivotAcceleration;
    private StatusSignal<AngularVelocity> intakeSpeed;
    private StatusSignal<AngularAcceleration> intakeAcceleration;

    public IntakeIOKraken() {
        pivot = new SteelTalonFX(IntakeConstants.kPivotID);
        flywheel = new SteelTalonFX(IntakeConstants.kFlywheelID);
        pivotConfig = new MotorConfiguration();
        flywheelConfig = new MotorConfiguration();

        //Configs
        pivotConfig.mode = MotorMode.kServo;
        pivotConfig.currentLimit = 40;
        pivotConfig.idleState = MotorConfiguration.IdleState.kBrake;
        pivotConfig.gearRatio = new ComplexGearRatio(1.0/8.0);
        pivotConfig.kP = IntakeConstants.kPivotP;
        pivotConfig.kI = IntakeConstants.kPivotI;
        pivotConfig.kD = IntakeConstants.kPivotD;
        pivotConfig.kS = IntakeConstants.kPivotS;
        pivotConfig.kG = IntakeConstants.kPivotG;
        pivotConfig.kV = IntakeConstants.kPivotV;
        pivotConfig.kA = IntakeConstants.kPivotA;
        pivotConfig.isArm = true;
        pivotConfig.maxVelocity = 5;
        pivotConfig.maxAcceleration = 5;

        flywheelConfig.mode = MotorMode.kFlywheel;
        flywheelConfig.currentLimit = 40;
        flywheelConfig.idleState = MotorConfiguration.IdleState.kCoast;
        flywheelConfig.gearRatio = new ComplexGearRatio(1.0/8.0);
        flywheelConfig.kP = IntakeConstants.kIntakeP;
        flywheelConfig.kI = IntakeConstants.kIntakeI;
        flywheelConfig.kD = IntakeConstants.kIntakeD;
        flywheelConfig.kS = IntakeConstants.kIntakeS;
        flywheelConfig.kG = IntakeConstants.kIntakeG;
        flywheelConfig.kV = IntakeConstants.kIntakeV;
        flywheelConfig.kA = IntakeConstants.kIntakeA;
        flywheelConfig.isArm = false;
        flywheelConfig.maxVelocity = 5;
        flywheelConfig.maxAcceleration = 5;

        pivot.apply(pivotConfig);
        flywheel.apply(flywheelConfig);

        //SS


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
