# Checkpoint 3 Review

## Step 1, Encapsulation, ArrayList Basics

Basic setup. This demonstrates the concept of encapsulation, along with some basic ArrayList methods (add/remove/size).

- Implement the following classes and their constructors:
  - `Vehicle`, a representation of a vehicle.
    - Implement the following fields: `make`, `model`. Use appropriate data types for each field.
    - Implement getters and setters for each field.
    - Implement a method called `getDescription()`. It returns a String formatted like this: `"{make} {model}"`.
    - Implement a method called `travel()`. It returns nothing and simply prints `"The {make} {model} travels."`.
  - `Garage`, a representation of a garage full of vehicles.
    - Implement the following fields: `vehicles`, `maxVehicles`. Use appropriate data types for each field.
    - Implement a means to add and remove a `Vehicle` from the `Garage`.
      - Ensure that you cannot add more vehicles than the `maxVehicles` field. Print something to tell the user the `Garage` is full.
    - Implement a method called `examine()` that prints out a description of every `Vehicle` in the `Garage`.

Example output from the `examine()` method:

```bash
// myGarage.examine() is called.
You look into the garage... You find:

a Buick Century,
a Honda Civic,
a Kia Niro
```

### Explanation

- We demonstrate **encapsulation** by restricting access to each classes fields (`make`, `model`, etc) while exposing a specific way to access and set those fields (like getter and setter methods). This allows us to have finer control over what data is assigned to those fields and lets us validate that data more easily. We don't want users of our class to put more vehicles in the garage than we allow.
- Since the garage can only hold a certain number of vehicles, we can use the `ArrayList` `size()` method to check if the number of elements in the `ArrayList` exceeds the maximum number allowed by the garage.
- There are a number of ways to remove items from an `ArrayList`. You might choose to remove it by passing an object reference, or by passing an index. Both are valid.

## Step 2, Inheritance

Here, we implement more kinds of vehicles. This demonstrates the concept of inheritence.

- Implement the following classes and their constructors:
  - `Car`, a child of `Vehicle`.
    - Override the `travel()` method of the parent class to print `"The {make} {model} travels by land."`.
  - `Boat`, a child of `Vehicle`.
    - Override the `travel()` method of the parent class to print `"The {make} {model} travels by sea."`.
  - `Plane`, a child of `Vehicle`.
    - Override the `travel()` method of the parent class to print `"The {make} {model} travels by air."`.

### Explanation

- Cars, boats, and planes are all vehicles. Vehicles are meant for travel, but some vehicles travel differently. It would not make sense to re-implement everything in the `Vehicle` class if the only variation is in the method of travel. Instead, we can just make child classes and override anything that we actually need to change while inheriting the rest.

## Step 3, Polymorphism and Abstraction

In real life, vehicles are typically made in factories. In Java, factories are a common design pattern that you might use in the future. We will use this design pattern to demonstrate the concept of polymorphism and abstraction.

- Define an abstract class called `VehicleFactory`.
  - Define a single abstract method called `createVehicle` that takes a make and model as its arguments. It returns a `Vehicle` object.
- Create three child classes of `VehicleFactory`, called `PlaneFactory`, `BoatFactory`, and `CarFactory`.
  - Each of these classes implements the `createVehicle` method and returns their respective object (the `PlaneFactory` would create and return a `Plane`, and so on.)
- Use these new factories to create and add some `Car`, `Plane`, and `Boat` objects into the `Garage`.

In the context of this Garage, everything inside is treated as a `Vehicle`. What if a `Plane` has a method that a `Vehicle` doesnt?

- Add a new method to the Plane class called `barrelRoll()`. It returns nothing and prints "The {make} {model} does a barrel roll!".
- In the `Garage.examine()` function, check if the vehicle is a `Plane`. If it is, make it do a barrel roll.

### Explanation

- Polymorphism is demonstrated by the way the child classes create and return their respective objects. The `PlaneFactory` class creates a `Plane` object, but returns it as a `Vehicle` object. This is valid, because `Plane` is a child of `Vehicle`, so it can be treated as one for the purpose of storing it in an `ArrayList` that can only hold vehicles, or calling `Vehicle` methods. If you're trying to call a method that a child class has, but the parent class doesn't, you need to type cast the object as the child class.
- Abstraction is also demonstrated here. The method `createVehicle` will always return a `Vehicle`. How the individual class implements that method, or even the kind of `Vehicle` it returns does not matter. All that matters to someone using a child of your abstract class is the method name, the arguments, and the type it returns.