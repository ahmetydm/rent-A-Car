import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Invoice {
    private int id;
    private Car car;
    private Rental rental;
    private Customer customer;
    private double totalPrice;
    private double taxAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean invoiceStatus;

    public Invoice(Rental rental) {



        this.setId(id);
        this.setRental(rental);
        this.setCustomer(customer);
        this.setTotalPrice(totalPrice);
        this.setTaxAmount(taxAmount);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setInvoiceStatus(invoiceStatus);

        long days = ChronoUnit.DAYS.between(endDate, startDate);
        totalPrice = days* car.getDailyRentalPrice();
        taxAmount = totalPrice*0.2;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Ara.=" + getCar() +
                ", Kiralama=" + getRental() +
                ", Müşteri=" + getCustomer() +
                ", Toplam ücret=" + getTotalPrice() +
                ", KDV=" + getTaxAmount() +
                ", Aracın veriliş tarihi=" + getStartDate() +
                ", Ödeme tarihi=" + getEndDate() +
                ", Ödeme yapılmış mı =" + isInvoiceStatus() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(boolean invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
