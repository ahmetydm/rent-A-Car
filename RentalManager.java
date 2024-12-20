import Car.*;
import Classrooms.Customer;
import Classrooms.Invoice;
import Classrooms.Rental;
import Classrooms.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManager {

    public void add(ArrayList<Rental> rentals, ArrayList<Car> cars, int logedUser) {
        CarManager carManager = new CarManager();
        Validator validator = new Validator();
        RentalManager rentalMAnager = new RentalManager();
        InvoiceManager invoiceManager = new InvoiceManager();
        Scanner scanner = new Scanner(System.in);

        int rentalDay;
        int carId;

        System.out.println("Kiralanabilir olan hangi aracımızı kiralamak istersiniz");
        carManager.availabileCars(cars);
        carId = Integer.parseInt(scanner.nextLine());

        System.out.println("Kaç gün kiralamak istiyorsunuz");
        rentalDay = Integer.parseInt(scanner.nextLine());
        boolean carValid = validator.carValid(carId);

        if (carValid) {
            rentalMAnager.addRental(rentals, cars, carId, rentalDay, logedUser);
        }
        int sum = 0;

        int lastRentalId = rentals.getLast().getRentalId();
        Double lastRentalPrice = rentals.getLast().getTotalPrice();
        System.out.println("Kiralama ücretinizin vergisi: " + lastRentalPrice * 0.20);
        System.out.println("Kiralama üvretinizin vergi dahil ücreti: " + lastRentalPrice);
        System.out.println("Ücreti ödemek istiyor musunuz 1=EVET/2=HAYIR");
        int sum_ = scanner.nextInt();
        sum = +sum_;
        if (sum == 1) {
            invoiceManager.Add(lastRentalId, logedUser, -1, lastRentalPrice, "ödendi");
            System.out.println("ödendi");
        } else {
            invoiceManager.Add(lastRentalId, logedUser, -1, lastRentalPrice, "ödenmedi");
            System.out.println("ödenmedi");
        }


    }

    public void addRental(ArrayList<Rental> rentals, ArrayList<Car> cars, int carId, int day, int rentedPerson) {

        Car selectedCar;
        double totalPrice = 0;
        for (Car carSelect : cars) {
            if (carSelect.getCarId() == carId) {
                carSelect.setAvailable(false);
                selectedCar = carSelect;
                totalPrice = carSelect.getDailyRentalPrice() * day;
            }
        }
        if (Main.permission == 0 || Main.permission == 1) {

            rentals.add(new Rental(rentals.size() + 1, -1, carId, rentedPerson,
                    LocalDate.now(), LocalDate.now().plusDays(day), totalPrice));
        }

    }

    public void leasedVehicles(ArrayList<Rental> rentals, ArrayList<Car> cars, ArrayList<Customer> customers, ArrayList<User> users) {

        for (Rental rental : rentals) {
            if ((rental.getRentalStartDate().isBefore(LocalDate.now()) || rental.getRentalStartDate().isEqual(LocalDate.now())) &&
                    (rental.getRentalEndDate().isAfter(LocalDate.now()) || rental.getRentalEndDate().isEqual(LocalDate.now()))) {

                if (rental.getCustomer() != -1) {
                    System.out.print(GetCustomerName(customers, rental.getCustomer()) + " ");
                }
                if (rental.getUser() != -1) {
                    System.out.print(GetUserName(users, rental.getUser()) + " ");
                }
                System.out.print(GetCarLicansePlate(cars, rental.getCar()));
                System.out.println(rental.getRentalStartDate() + "-" + rental.getRentalEndDate() + "-" + rental.getTotalPrice());
            }
        }
    }

    private String GetCarLicansePlate(ArrayList<Car> cars, int id) {
        for (Car car : cars) {
            if (car.getCarId() == id)
                return car.getLicensePlate();
        }
        return "Bulunamadı";
    }

    private String GetCustomerName(ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getPersonID() == id)
                return customer.getName();
        }
        return "Bulunamadı";
    }

    private String GetUserName(ArrayList<User> users, int id) {
        for (User user : users) {
            if (user.getPersonID() == id)
                return user.getName();
        }
        return "Bulunamadı";
    }

    public void listWithId(ArrayList<Rental> rentals, ArrayList<Car> cars, ArrayList<Customer> customers, int id) {

        for (Rental rental : rentals) {
            if (rental.getCustomer() == id) {
                System.out.println(GetCustomerName(customers, id) + " ");
                System.out.println(GetCarLicansePlate(cars, rental.getCar()) + " ");
                System.out.println(rental.getRentalStartDate() + " ");
                System.out.println(rental.getRentalEndDate() + " ");
                System.out.println(rental.getTotalPrice() + " ");
            }
        }
    }

    public void list(ArrayList<Rental> rentals, ArrayList<Invoice> invoices, ArrayList<Customer> customers, ArrayList<User> users) {
        for (Rental rental : rentals) {
            if (invoices.get(rental.getRentalId()).getInvoiceStatus().equals("ödendi")) {

                System.out.println("Kiralama no "+rental.getRentalId());
                if (rental.getCustomer()!=-1){
                    System.out.println("Kiralayan adı"+GetCustomerName(customers , rental.getCustomer()));
                }else {
                    System.out.println(GetUserName(users , rental.getUser())+" ");
                }
                System.out.println("Kiralama başlangıç tarihi "+rental.getRentalStartDate());
                System.out.println("Kiralama bitiş tarihi"+ rental.getRentalEndDate());
                System.out.println("Toplam kiralama ücreti"+rental.getTotalPrice());
                System.out.println("Vergi ücreti"+rental.getTotalPrice()*0.20);
            }
        }
    }
}
