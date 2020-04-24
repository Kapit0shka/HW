package com.application.bean;

public class Car {

    private IEngine engine;
    private String vin;

    public Car(){
    }

    public Car(IEngine engine, String vin) {
        this.engine = engine;
        this.vin = vin;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public IEngine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", vin='" + vin + '\'' +
                '}';
    }
}
