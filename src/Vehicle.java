public class Vehicle {
    private String make;
    private String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return make + " " + model;
    }

    public void travel() {
        System.out.println("The " + getDescription() + "travels.");
    }
}

class Car extends Vehicle {

    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void travel() {
        System.out.println("The " + getDescription() + " travels by land.");
    }

}

class Boat extends Vehicle {

    public Boat(String make, String model) {
        super(make, model);
    }

    @Override
    public void travel() {
        System.out.println("The " + getDescription() + " travels by sea.");
    }
}

class Plane extends Vehicle {

    public Plane(String make, String model) {
        super(make, model);
    }

    @Override
    public void travel() {
        System.out.println("The " + getDescription() + " travels by air.");
    }

    public void barrelRoll() {
        System.out.println("The " + getDescription() + " does a barrel roll!");
    }
}