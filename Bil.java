import java.awt.*;
class Bil implements IMovable {
    double x;
    double y;
    EDirection direction = EDirection.NORTH;
    public boolean turboOn = false;
    public double trimFactor = 1;
    int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double speedFactor() {
        double turbo = 1;
        if (trimFactor != 1 && turboOn)
            return enginePower * 0.01 * turbo * trimFactor;
        else if (trimFactor != 1)
            return enginePower * 0.01 * trimFactor;
        else if (turboOn)
            return enginePower * 0.01 * turbo;
        else
            return enginePower * 0.01;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr) { color = clr; }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine() { currentSpeed = 0; }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        currentSpeed = Math.clamp(currentSpeed, 0, enginePower);
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        currentSpeed = Math.clamp(currentSpeed, 0, enginePower);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        amount = Math.clamp(amount, 0, 1);
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        amount = Math.clamp(amount, 0, 1);
        decrementSpeed(amount);
    }

    public void move(){
        if (direction == EDirection.NORTH) {
            y += currentSpeed;
        } else if (direction == EDirection.SOUTH) {
            y -= currentSpeed;
        } else if (direction == EDirection.EAST) {
            x += currentSpeed;
        } else if (direction == EDirection.WEST) {
            x -= currentSpeed;
        }
    }

    public void turnLeft() {
        if (direction == EDirection.NORTH) {
            direction = EDirection.WEST;
        }
        if (direction == EDirection.WEST) {
            direction = EDirection.SOUTH;
        }
        if (direction == EDirection.SOUTH) {
            direction = EDirection.EAST;
        }
        if (direction == EDirection.EAST) {
            direction = EDirection.NORTH;
        }
    }

    public void turnRight() {
        if (direction == EDirection.NORTH) {
            direction = EDirection.EAST;
        }
        if (direction == EDirection.EAST) {
            direction = EDirection.SOUTH;
        }
        if (direction == EDirection.SOUTH) {
            direction = EDirection.WEST;
        }
        if (direction == EDirection.WEST) {
            direction = EDirection.NORTH;
        }
    }
}
