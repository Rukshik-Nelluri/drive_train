package frc.robot.utils;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Target;
import frc.robot.subsystems.Superstructure;
import frc.robot.subsystems.Superstructure.SuperstructureState;


public class OI {
    private PS4Controller controller;
    private static OI instance;
    private Superstructure superstructure;

    public OI() {
        controller = new PS4Controller(0);
        superstructure = new Superstructure();

        Trigger xButton = new JoystickButton(controller, PS4Controller.Button.kCross.value);
        xButton.onTrue(new InstantCommand(() -> superstructure.requestState(SuperstructureState.STOW)));
        
        Trigger triangleButton = new JoystickButton(controller, PS4Controller.Button.kTriangle.value);
        triangleButton.whileTrue(new InstantCommand(() -> superstructure.requestState(SuperstructureState.INTAKE)));

        Trigger squareButton = new JoystickButton(controller, PS4Controller.Button.kSquare.value);
        squareButton.onTrue(new InstantCommand(() -> superstructure.requestState(SuperstructureState.SHOOT)));

        Trigger circleButton = new JoystickButton(controller, PS4Controller.Button.kCircle.value);
        circleButton.onTrue(new InstantCommand(() -> superstructure.requestState(SuperstructureState.STOP_SHOOT)));

        Trigger touchpadButton = new JoystickButton(controller, PS4Controller.Button.kTouchpad.value);
        touchpadButton.whileTrue(new Target());
    }

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }              

    public double getSpeed() {
        return controller.getRawAxis(1);
    }

    public double getRotation() {
        return controller.getRawAxis(2) * -1;
    }
}
