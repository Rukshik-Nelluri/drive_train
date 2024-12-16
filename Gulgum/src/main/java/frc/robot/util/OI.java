package frc.robot.util;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.StartIntake;
import frc.robot.commands.StopFlywheel;
import frc.robot.commands.StopIntake;
import frc.robot.commands.OpenFlywheelGate;
import frc.robot.commands.ReverseIntake;
import frc.robot.commands.StartFlywheel;


public class OI {
    private PS4Controller controller;
    private static OI instance;

    public OI() {
        controller = new PS4Controller(0);

        Trigger xButton = new JoystickButton(controller, PS4Controller.Button.kCross.value);
        xButton.onTrue(new StartIntake());
        
        Trigger triangleButton = new JoystickButton(controller, PS4Controller.Button.kTriangle.value);
        triangleButton.onTrue(new StopIntake());

        Trigger squareButton = new JoystickButton(controller, PS4Controller.Button.kSquare.value);
        squareButton.onTrue(new ReverseIntake());

        Trigger circleButton = new JoystickButton(controller, PS4Controller.Button.kCircle.value);
        circleButton.onTrue(new OpenFlywheelGate());

        Trigger touchpadButton = new JoystickButton(controller, PS4Controller.Button.kTouchpad.value);
        touchpadButton.onTrue(new StopFlywheel());

        Trigger r1Button = new JoystickButton(controller, PS4Controller.Button.kR1.value);
        r1Button.whileTrue(new StartFlywheel());
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
