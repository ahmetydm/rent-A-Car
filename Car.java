package Car;

public class Car {

    private int carId;
    private String brand;
    private String model;
    private String productionYear;
    private double dailyRentalPrice;
    private Boolean isAvailable;
    private double mileage;
    private String fuelType;
    private String transmissionType;
    private String color;
    private String category;
    private String licensePlate;

    public Car(int carId , String brand , String model , String productionYear , double dailyRentalPrice , boolean isAvailable,
               double mileage , String fuelType , String transmissionType , String color , String category , String licensePlate) {

        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.dailyRentalPrice = dailyRentalPrice;
        this.isAvailable = isAvailable;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.color = color;
        this.category = category;
        this.licensePlate = licensePlate;


    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
