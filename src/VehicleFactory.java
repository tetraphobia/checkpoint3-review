public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String make, String model);
}

class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String make, String model) {
        return new Car(make, model);
    }

}

class BoatFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String make, String model) {
        return new Boat(make, model);
    }

}

class PlaneFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String make, String model) {
        return new Plane(make, model);
    }

}
