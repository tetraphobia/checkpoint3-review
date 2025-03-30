import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        Garage myGarage = new Garage(5);
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to the garage!\n");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Examine the garage");
            System.out.println("3. Quit\n");

            System.out.print("> ");

            int choice = -1;

            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Try again.");
                continue;
            } finally {
                scan.nextLine();
            }

            if (choice == 1) { // 1. Add a new vehicle
                System.out.println("What kind of vehicle is this?\n");
                System.out.println("1. Car");
                System.out.println("2. Boat");
                System.out.println("3. Plane\n");

                System.out.print("> ");

                int kind = -1;
                String make = null;
                String model = null;

                try {
                    kind = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Try again.");
                    continue;
                } finally {
                    scan.nextLine();
                }

                if (kind < 1 || kind > 3) {
                    System.err.println(kind + " is not a valid kind of vehicle. Try again.");
                    continue;
                }

                try {
                    System.out.print("Enter the make: ");
                    make = scan.nextLine();
                    System.out.print("Enter the model: ");
                    model = scan.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Try again.");
                    continue;
                }

                switch (kind) {
                    case 1:
                        myGarage.addVehicle(new Car(make, model));
                        break;
                    case 2:
                        myGarage.addVehicle(new Boat(make, model));
                        break;
                    case 3:
                        myGarage.addVehicle(new Plane(make, model));
                        break;
                    default:
                        System.out.println("Something has gone horribly wrong!");
                        break;
                }

            }
            else if (choice == 2) { // 2. Examine the garage
                myGarage.examine();
            }
            else if (choice == 3) { // 3. Quit
                break;
            }
        }
        scan.close();
        System.out.println("See ya!");
    }
}
