import java.time.LocalDate;

public class Customer  {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private long phoneNumber;
    private Boolean rentalStatus;
    private String address;
    private LocalDate registrationDate;
    private String rentalHistory;

    public Customer(int id, String name, String surname, String email, String password,
                    long phoneNumber, boolean rentalStatus, String address, LocalDate registrationDate, String rentalHistory) {

        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setRentalStatus(false);
        this.setAddress(address);
        this.setRegistrationDate(registrationDate);
        this.setRentalHistory(rentalHistory);

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", İsim='" + name + '\'' +
                ", Soyisim='" + surname + '\'' +
                ", E-mail='" + email + '\'' +
                ", Şifre='" + password + '\'' +
                ", Telefon Numarası=" + phoneNumber +
                ", Kiralama durumu ="+ rentalStatus +
                ", Kiralama Durumu=" + rentalStatus +
                ", Müşterinin Adresi='" + address + '\'' +
                ", Kayır Tarihi=" + registrationDate +
                ", Kiralama Geçmişi='" + rentalHistory + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(Boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(String rentalHistory) {
        this.rentalHistory = rentalHistory;
    }
}
