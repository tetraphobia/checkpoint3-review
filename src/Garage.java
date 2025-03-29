import java.util.ArrayList;

public class Garage {
    private int maxVehicles;
    private ArrayList<Vehicle> vehicles;

    public Garage(int maxVehicles) {
        this.maxVehicles = maxVehicles;
        this.vehicles = new ArrayList<>();
    }

    public int getMaxVehicles() {
        return maxVehicles;
    }

    public void setMaxVehicles(int maxVehicles) {
        this.maxVehicles = maxVehicles;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle v) {
        if (vehicles.size() == maxVehicles) {
            System.out.println("There are too many vehicles in the garage!");
            return;
        }

        this.vehicles.add(v);
    }

    public void removeVehicle(Vehicle v) {
        this.vehicles.remove(v);
    }

    public void examine() {
        System.out.println("You look into the garage... You find:\n");
        for (Vehicle v : this.vehicles) {
            System.out.println("a " + v.getDescription());
            v.travel();

            if (v instanceof Plane) {
                Plane p = (Plane) v;
                p.barrelRoll();
            }
        }
    }

    public static void main(String[] args) {
        Garage a = new Garage(5);

        ArrayList<VehicleFactory> factories = new ArrayList<>();

        factories.add(new CarFactory());
        factories.add(new PlaneFactory());
        factories.add(new BoatFactory());

        // { CarFactory, PlaneFactory, BoatFactory }

        for (VehicleFactory v : factories) {
            a.addVehicle(v.createVehicle("Mystery", "Mystery"));
        }

        a.examine();

    }
}
