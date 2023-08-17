package A14ExerciseObjectsAndClasses.Exercise.P05VehicleCatalogue;

public class Vehicle {

    private String typeOfVehicle;

    private String model;

    private String color;

    private int horsePower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsePower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }


}
