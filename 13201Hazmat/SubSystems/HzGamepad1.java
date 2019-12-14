package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Defenition of the HzGamepad Class
 *
 * HzGamepad consists of system provided gamepad(s) and adds functionality to the selection 
 * made on gamepads
 * 
 * For Hazmat Skystone, only one Gamepad is used (gamepad1)
 *
 * The controls are as follows:
 *      Left Stick for pan motion (gamepad1.left_stick_x and gamepad1.left_stick_y)
 *      Right Stick for turn motion (only uses the x direction : gamepad1.right_stick_y)
 *      Right Bumper for increasing level of arm by 1 block (gamepad1.right_bumper)
 *      Left Bumper for decreasing level of arm by 1 block (gamepad1.left_bumper)
 *      Right Trigger for increasing speed to double (gamepad1.right_trigger)
 *      Left Trigger for automatic placement of block at level (gamepad1.left_trigger)
 *      Button A to close / pull back linear actuator Intake-Grp (gamepad1.a)
 *      Button Y to open / extend linear actuator Intake-Grip (gamepad1.y)
 *      Button X to move Arm to place block at level (gamepad1.x)
 *      Button B to move Arm to lift after block placement (gamepad1.b)
 *      Button Dpad_up to open wrist (gamepad1.dpad_up)
 *      Button Dpad_down to close wrist (gamepad1.dpad_down)
 */

public class HzGamepad1 {

    //Create gamepad object reference to connect to gamepad1
    public Gamepad gpGamepad1;

    //Records last button press to deal with single button presses doing a certain methods
    boolean buttonALast = false;
    boolean buttonBLast = false;
    boolean buttonXLast = false;
    boolean buttonYLast = false;
    boolean rightBumperLast = false;
    boolean leftBumperLast = false;
    boolean dpad_upLast = false;
    boolean dpad_downLast = false;

    /**
     * Constructor for HzGamepad1 class that extends gamepad
     * Assign the gamepad1 given in OpMode to the gamepad used here.
     *
     * @param gamepadPassedfromOpMode from OpMode. In the case of Hazmat Skystone, this is gamepad1
     */
    public HzGamepad1(Gamepad gamepadPassedfromOpMode) {
        gpGamepad1 = gamepadPassedfromOpMode;
    }

    /**
     * Methods to get the value of gamepad Left stick X for Pan motion X direction
     * This is the method to apply any directional modifiers to match to the X plane of robot.
     * No modifier needed for Hazmat Skystone Robot
     *
     * @return gpGamepad1.left_stick_x
     */
    public double getLeftStickX() {
        return gpGamepad1.left_stick_x;
    }

    /**
     * Methods to get the value of gamepad Left stick Y for Pan motion Y direction
     * This is the method to apply any directional modifiers to match to the Y plane of robot.
     * For Hazmat Skystone Robot, Y direction needs to be inverted.
     *
     * @return gpGamepad1.left_stick_y * (-1)
     */
    public double getLeftStickY() {
        return gpGamepad1.left_stick_y * (-1);
    }

    /**
     * Methods to get the value of gamepad Right stick X to keep turning
     * This is the method to apply any directional modifiers to match to the turn direction robot.
     * No modifier needed for Hazmat Skystone Robot
     *
     * @return gpGamepad1.right_stick_x
     */
    public double getRightStickX() {
        return gpGamepad1.right_stick_x;
    }

    /**
     * Methods to get the value of gamepad Right Trigger for turbo mode (max speed)
     * This is the method to apply any modifiers to match to action of turbo mode for each driver preference
     * For Hazmat Skystone Right Trigger pressed means turbo mode on.
     *
     * @return gpGamepad1.right_trigger
     */
    public double getRightTrigger() {
        return gpGamepad1.right_trigger;
    }

    /**
     * Methods to get the value of gamepad Left Trigger for Automatic Placement of block at level
     *
     * @return gpGamepad1.right_trigger
     */
    public double getLeftTrigger() {
        return gpGamepad1.left_trigger;
    }

    /**
     * Method to track if Left Bumper was pressed to trigger arm to go down a level.
     * To ensure that the continuous holding of the left bumper does not cause a continual fall,
     * the state of the bumper is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing hold or release of button should not trigger action.
     *
     * @return isPressedLeftBumper| = true if prev state is not pressed and current is pressed.
     */
    public boolean getLeftBumperPress() {
        boolean isPressedLeftBumper = false;
        if (!leftBumperLast && gpGamepad1.left_bumper) {
            isPressedLeftBumper = true;
        }
        leftBumperLast = gpGamepad1.left_bumper;
        return isPressedLeftBumper;
    }

    /**
     * Method to track if Right Bumper was pressed to trigger arm to go up a level.
     * To ensure that the continuous holding of the right bumper does not cause a continual rise,
     * the state of the bumper is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedRightBumper = true if prev state is not pressed and current is pressed.
     */
    public boolean getRightBumperPress() {
        boolean isPressedRightBumper = false;
        if (!rightBumperLast && gpGamepad1.right_bumper) {
            isPressedRightBumper = true;
        }
        rightBumperLast = gpGamepad1.right_bumper;
        return isPressedRightBumper;
    }

    /**
     * Method to track if Button A was pressed to close grip (pull back linear actuator).
     * To ensure that the continuous holding of Button A does not send continual triggers to
     * servo motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedButton A = true if prev state is not pressed and current is pressed.
     */
    public boolean getButtonAPress() {
        boolean isPressedButtonA = false;
        if (!buttonALast && gpGamepad1.a) {
            isPressedButtonA = true;
        }
        buttonALast = gpGamepad1.a;
        return isPressedButtonA;
    }

    /**
     * Method to track if Button Y was pressed to open grip (extend linear actuator).
     * To ensure that the continuous holding of Button Y does not send continual triggers to
     * servo motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedButtonY = true if prev state is not pressed and current is pressed.
     */
    public boolean getButtonYPress() {
        boolean isPressedButtonY = false;
        if (!buttonYLast && gpGamepad1.y) {
            isPressedButtonY = true;
        }
        buttonYLast = gpGamepad1.y;
        return isPressedButtonY;
    }

    /**
     * Method to track if Button X was pressed to move Arm to place block at level.
     * To ensure that the continuous holding of Button X does not send continual triggers to
     * motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedButtonX = true if prev state is not pressed and current is pressed.
     */
    public boolean getButtonXPress() {
        boolean isPressedButtonX = false;
        if (!buttonXLast && gpGamepad1.x) {
            isPressedButtonX = true;
        }
        buttonXLast = gpGamepad1.x;
        return isPressedButtonX;
    }

    /**
     * Method to track if Button B was pressed to move Arm to lift after block placement.
     * To ensure that the continuous holding of Button Y does not send continual triggers to
     * motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedButtonB = true if prev state is not pressed and current is pressed.
     */
    public boolean getButtonBPress() {
        boolean isPressedButtonB = false;
        if (!buttonBLast && gpGamepad1.b) {
            isPressedButtonB = true;
        }
        buttonBLast = gpGamepad1.b;
        return isPressedButtonB;
    }

    /**
     * Method to track if Dpad_up was pressed to open wrist.
     * To ensure that the continuous holding of Dpad_up does not send continual triggers to
     * motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedDpad_up = true if prev state is not pressed and current is pressed.
     */
    public boolean getDpad_upPress() {
        boolean isPressedDpad_up = false;
        if (!dpad_upLast && gpGamepad1.dpad_up) {
            isPressedDpad_up = true;
        }
        dpad_upLast = gpGamepad1.dpad_up;
        return isPressedDpad_up;

    }

    /**
     * Method to track if Dpad_down was pressed to open wrist.
     * To ensure that the continuous holding of Dpad_up does not send continual triggers to
     * motor, the state of the button is recorded and compared against previous time.
     * Only if the previous state is unpressed and current state is pressed would
     * the function return true.
     * Continue to not press, or continuing to hold or release of button should not trigger action.
     *
     * @return isPressedDpad_down = true if prev state is not pressed and current is pressed.
     */
    public boolean getDpad_downPress() {
        boolean isPressedDpad_down = false;
        if (!dpad_downLast && gpGamepad1.dpad_down) {
            isPressedDpad_down = true;
        }
        dpad_downLast = gpGamepad1.dpad_down;
        return isPressedDpad_down;

    }

    /**
     * Method to convert linear map from gamepad1 stick input to a cubic map
     *
     * @param stickInput input value of button stick vector
     * @return Cube of the stick input reduced to 25% speed
     */
    public double limitStick(double stickInput) {
        return (stickInput * stickInput * stickInput * 0.25);
    }

    /**
     * Method to implement turbo speed mode - from reduced speed of 25% of cubic factor to
     * 100% speed, but controlled by acceleration of the force of pressing the Right Tigger.
     *
     * @param stickInput input value of button stick vector
     * @return modified value of button stick vector
     */
    public double turboMode(double stickInput) {
        double acceleration_factor;
        double rightTriggerValue = getRightTrigger();
        acceleration_factor = 1.0 + 3.0 * rightTriggerValue;
        return limitStick(stickInput) * acceleration_factor;
    }

    /**
     * Method for automatic placement of block at a particular level.
     *
     * @param apChassis Chassis object passed for autoPlace
     * @param apArm Arm object passed for autoPlace
     * @param apIntake Intake object passed for autoPlace
     */
    public void autoPlace(Chassis apChassis, Arm apArm, Intake apIntake) {
        //Assumption - Arm is holding block right at the holding height of level to place
        //Robot aligned at location to place. Goes forward and hits frontLeftBumperTouch sensor

        while ((getLeftTrigger() > 0.75) && apChassis.frontleftChassisTouchSensorIsPressed()) {
            //Move back slightly
            //#TOBEUPDATED : Need to make motion a function of apArm.currentlevel since different
            // leves have different distance to go back to.
            apChassis.runRotations(.25, -.25);
        }

        //Move Arm to place block at the level
        while (getLeftTrigger() > 0.75) {
            apArm.moveArmToPlaceBlockAtLevel();
        }

        //After block is placed, Open grip to release block on level
        while (getLeftTrigger() > 0.75) {
            apIntake.openGrip();
        }

        //Lift Arm after block is placed
        while (getLeftTrigger() > 0.75) {
            apArm.moveArmToLiftAfterBlockPlacement();
        }

        //#TOBEUPDATED : Could add a move back to ensure Arm does not hit robot
    }

    /**
     * Method to convert Gamepad commands to actions on Robot
     */
    public void runSubsystemByGamepadInput(Chassis gpChassis, Arm gpArm, Intake gpIntake) {

        /*Chassis actions :
        Convert Left Stick and Right Stick motion to power, target Angle and turn for Chassis
         */
        double leftStickX = turboMode(getLeftStickX());
        double leftStickY = turboMode(getLeftStickY());
        double rightStickX = turboMode(getRightStickX());
        double power = Math.hypot(leftStickX, leftStickY);
        double targetAngle = Math.atan2(leftStickY, leftStickX);
        double turn = rightStickX;
        gpChassis.runByGamepadCommand(targetAngle, turn, power);

        //Arm Actions :
        //If right bumper is pressed, move up a level
        if (getLeftBumperPress()) {
            gpArm.moveArm_blockLevelDown();
        }
        //If left bumper is pressed, move down a level
        if (getRightBumperPress()) {
            gpArm.moveArm_blockLevelUp();
        }
        //if Button X is pressed, move Arm to place block at level
        if (getButtonXPress()) {
            gpArm.moveArmToPlaceBlockAtLevel();
        }
        //if Button B is pressed, move Arm to lift after block placement
        if (getButtonBPress()){
            gpArm.moveArmToLiftAfterBlockPlacement();
        }

        //Intake Actions :
        //If A is pressed, close grip
        if (getButtonAPress()){
            gpIntake.closeGrip();
        }
        //If Y is pressed, open grip
        if (getButtonYPress()){
            gpIntake.openGrip();
        }
        //If Dpad_up is pressed, open wrist from close to vertical to horizontal
        if (getDpad_upPress()){
            gpIntake.moveWristUp();
        }
        //If Dpad_down is pressed, close wrist from horizontal to vertical to close
        if (getDpad_downPress()){
            gpIntake.moveWristDown();
        }

        /* Combination Auto action - Place block on level
           Activates when Left Trigger is held pressed and when Robot chassis aligns to front of
           location to place block and touch sensor on frontleft of chassis is pressed
         */

        if (getLeftTrigger()>0.75){
            if (gpChassis.frontleftChassisTouchSensorIsPressed()){
                autoPlace(gpChassis, gpArm, gpIntake);
            }

        }

    }
}


/*    double leftStickXMod = 1;
    double leftStickYMod = -1;
    double rightStickXMod = 1;
    double rightStickYMod = -1;
    boolean aMod = true;
    boolean bMod = true;
    boolean xMod = true;
    boolean yMod = true;
    boolean rightBumperMod = true;
    boolean leftBumperMod = true;
    double rightTriggerMod = 1.0;
    double leftTriggerMod = 1.0;


    //These methods return the oppisite of the button if the modifier is false and the same if it is true
    public boolean getA() {
        return aMod ? hzButtonA : !hzButtonA;
    }

    public boolean getB() {
        return bMod ? hzButtonB : !hzButtonB;
    }

    public boolean getX() {
        return xMod ? hzButtonX : !hzButtonX;
    }

    public boolean getY() {
        return yMod ? hzButtonY : !hzButtonY;
    }

    public boolean getLeftBumper() {
        return aMod ? hzLeftBumper : !hzLeftBumper;
    }

    public boolean getRightBumper() {
        return aMod ? hzRightBumper : !hzRightBumper;
    }
*/

//Declare all buttons on gamepad1. Assigned in constructor to right gamepad1 attributes.
/*    float hzLeftStickX;
    float hzLeftStickY;
    float hzRightStickX;
    float hzRightStickY;
    boolean hzDpad_Up;
    boolean hzDpad_Down;
    boolean hzDpad_Left;
    boolean hzDpad_Right;
    boolean hzButtonA;
    boolean hzButtonB;
    boolean hzButtonX;
    boolean hzButtonY;
    boolean hzStart;
    boolean hzBack;
    boolean hzLeftBumper;
    boolean hzRightBumper;
    boolean hzLeftStickButton;
    boolean hzRightStickButton;
    float hzLeftTrigger;
    float hzRightTrigger;

        //Assign all buttons on myGamepad1 to HzGamepad1 attributes
        hzLeftStickX = gpGamepad1.left_stick_x;
        //Y direction is negative in Robot plane
        hzLeftStickY = -1* myGamepad1.left_stick_y;
        hzRightStickX = myGamepad1.right_stick_x;
        hzRightStickY = myGamepad1.right_stick_y;
        hzDpad_Up = myGamepad1.dpad_up;
        hzDpad_Down = myGamepad1.dpad_down;
        hzDpad_Left = myGamepad1.dpad_left;
        hzDpad_Right = myGamepad1.dpad_right;
        hzButtonA = myGamepad1.a;
        hzButtonB = myGamepad1.b;
        hzButtonX = myGamepad1.x;
        hzButtonY = myGamepad1.y;
        hzStart = myGamepad1.start;
        hzBack = myGamepad1.back;
        hzLeftBumper = myGamepad1.left_bumper;
        hzRightBumper = myGamepad1.right_bumper;
        hzLeftStickButton = myGamepad1.left_stick_button;
        hzRightStickButton = myGamepad1.right_stick_button;
        hzLeftTrigger = myGamepad1.left_trigger;
        hzRightTrigger = myGamepad1.right_trigger;



 */
