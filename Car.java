
public class Car {
    private Customer customer;
    private int id;
    private String brand;
    private String model;
    private int productionYear;
    private double dailyRentalPrice;
    private Boolean isAvailable;
    private double mileage;
    private String fuelType;
    private String transmissionType;
    private String color;
    private String category;
    private String licensePlate;

    public Car(int id, String brand, String model, int productionYear, double dailyRentalPrice, boolean isAvailable, double mileage,
               String fuelType, String transmissionType, String color, String category, String licensePlate) {

        this.setId(id);
        this.setBrand(brand);
        this.setModel(model);
        this.setProductionYear(productionYear);
        this.setDailyRentalPrice(dailyRentalPrice);
        this.setAvailable(isAvailable);
        this.setMileage(mileage);
        this.setFuelType(fuelType);
        this.setTransmissionType(transmissionType);
        this.setColor(color);
        this.setCategoryId(category);
        this.setLicensePlate(licensePlate);

    }

    @Override
    public String toString() {
        return          " aracın id si " +id+
                        " Marka= " + brand +
                        " model= " + model +
                        " Aracın üretim yılı= " + productionYear +
                        " Aracın günlük kirası= " + dailyRentalPrice +
                        " isAvailable= " + isAvailable +
                        " Aracın şu anki kilometresi= " + mileage +
                        " Yakıt türü= " + fuelType +
                        " Şanzıman türü= " + transmissionType +
                        " Aracın rengi= " + color +
                        " Aracın kategorisi "+category +
                        " Aracın plakası= " + licensePlate
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
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

    public void setCategoryId(String categoryId) {
        this.category = categoryId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
