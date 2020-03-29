package horstmann2chapter.car;

public class Car {
    private double fuel = 0.0;
    private double tank;
    private double fuelConsumption;
    private double x = 0.0;
    private double mileage = 0.0;

    public Car(double fuelConsumption, double tank) {
        this.fuelConsumption = fuelConsumption;
        this.tank = tank;
    }

    public double getMileage() {
        return mileage;
    }

    public double getX() {
        return x;
    }

    public double getFuel() {
        return fuel;
    }

    //x == 1 == 1 kilometer
    public boolean drive(double deltaX) {
        if((fuel * fuelConsumption - deltaX) < 0.001) {
            return false;
        }
        else {
            fuel -=deltaX / fuelConsumption;
            x += deltaX;
            mileage += Math.abs(deltaX);
            return true;
        }
    }

    public boolean tankUp(double liter) {
        if((tank - (liter + fuel)) < 0.001) {
            return false;
        }
        else {
            fuel += liter;
            return true;
        }
    }

    public double tankFull() {
        double res = tank - fuel;
        fuel = tank;
        return res;
    }
}
