import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {

    private int id;
    private Invoice invoice;
    private Customer customer;
    private Car car;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double totalPrice;


    public Rental(int id,Invoice invoice, Customer customer, Car car, LocalDate rentalStartDate, LocalDate rentalEndDate, double totalPrice) {
        long rentStartEnd = ChronoUnit.DAYS.between(rentalEndDate, rentalStartDate);
        totalPrice = totalPrice*rentStartEnd;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice(){
        return invoice;
    }

    public void  setInvoice(Invoice invoice){
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
