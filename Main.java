import Car.*;
import Classrooms.Customer;
import Classrooms.Invoice;
import Classrooms.Rental;
import Classrooms.User;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static ArrayList<Invoice> invoices = new ArrayList<>();

    static int permission = 0;
    static int logedUser = 0;

    public static void main(String[] args) {

        createCustomer();
        createUser();
        createCar();
        createRental();
        createinvoice();
        Login login = new Login();
        logedUser = login.userLogin(users, customers);
        program();
    }


    public static void program() {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        CustomerManager customerManager = new CustomerManager();
        RentalManager rentalManager = new RentalManager();
        InvoiceManager invoiceManager = new InvoiceManager();
        CarManager carManager = new CarManager();
        int vote;

        while (true) {
            if (permission == 1) {
                System.out.println("Yapmak istediğiniz işlem nedir");
                System.out.println("1-Müşteri işlemleri");
                System.out.println("2-Kullanıcı işlemleri");
                System.out.println("3-Araba işlemleri");
                System.out.println("4-Ödeme işlemleri");
                System.out.println("5-Fatura görüntüle");
                System.out.println("6-Aktif kiralamar");
                System.out.println("7-Çıkış yap");

                try {
                    vote = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    vote = 0;
                }
                clear();

                switch (vote) {
                    case 1:
                        System.out.println("1: Müşteri ekle");
                        System.out.println("2: Müşteri sil");
                        System.out.println("3: Müşteri güncelle");
                        System.out.println("4: Müşterileri listele");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");
                        try {
                            vote = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            vote = 0;
                        }
                        clear();

                        switch (vote) {
                            case 1:
                                customerManager.add(customers);
                                break;
                            case 2:
                                customerManager.removeCustomer(customers);
                                break;
                            case 3:
                                customerManager.updateCustomer(customers);
                                break;
                            case 4:
                                customerManager.customerList(customers);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1: Kullanıcı ekle");
                        System.out.println("2: Kullanıcı sil");
                        System.out.println("3: Kullanıcı güncelle");
                        System.out.println("4: Kullanıcı listele");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");

                        try {
                            vote = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            vote = 0;
                        }
                        switch (vote) {
                            case 1:
                                userManager.add(users);
                                ;
                                break;
                            case 2:
                                userManager.removeUser(users);
                                break;
                            case 3:
                                userManager.updateUser(users);
                                break;
                            case 4:
                                userManager.userList(users);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("1: Araç ekle");
                        System.out.println("2: Araç sil");
                        System.out.println("3: Araç güncelle");
                        System.out.println("4: Araç listele");
                        System.out.println("5: Araç kirala");
                        System.out.println("Geri dönmek için herhangi bir giriş yapınız.");

                        try {
                            vote = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            vote = 0;
                        }
                        switch (vote) {
                            case 1:
                                carManager.add(cars);
                                break;
                            case 2:
                                carManager.removeCar(cars);
                                break;
                            case 3:
                                carManager.updateCar(cars);
                                break;
                            case 4:
                                carManager.carList(cars);
                                break;
                            case 5:
                                rentalManager.add(rentals, cars, logedUser);
                                break;
                        }
                        break;

                    case 4:
                        rentalManager.list(rentals, invoices, customers, users);
                        System.out.println("Ödeme yapmak ister misiniz 1=EVET/2=HAYIR");
                        int sum = Integer.parseInt(scanner.nextLine());
                        if (sum == 1) {
                            System.out.println("Ödeme yapmak istediğiniz işlemin numarasını giriniz.");
                            int payid = Integer.parseInt(scanner.nextLine());
                            InvoiceManager.Pay(invoices, payid);
                        } else if (sum == 2) {
                            System.out.println("Ödeme yapmaktan vazgeçtiniz");
                        } else {
                            System.out.println("Geçersiz seçenek");
                        }
                        break;
                    case 5:
                        for (Invoice invoice : invoices) {
                            invoiceManager.Listing(invoice);
                        }
                        break;
                    case 6:
                        rentalManager.leasedVehicles(rentals, cars, customers, users);
                        break;
                    case 7:
                        Login login = new Login();
                        logedUser = login.userLogin(users, customers);
                        break;
                }
            } else {
                System.out.println("1-Bilgilerimi görmek istiyorum:");
                System.out.println("2-Araç kiralamak istiyorum.:");
                System.out.println("3-Daha önceki kiralamalarımı görmek istiyorum.");
                System.out.println("4-Kesilen faturalarımı görmek istiyorum");
                System.out.println("5-Çıkış yapmak istiyorum");
                try {
                    vote = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    vote = 0;
                }
                switch (vote) {
                    case 1:
                        customerManager.listWithId(customers , logedUser);
                        customerManager.updateCustomerSelf(customers , logedUser, scanner);
                        break;
                    case 2: {
                        rentalManager.add(rentals , cars , logedUser);
                    }
                    break;
                    case 3:
                        rentalManager.listWithId(rentals , cars , customers , logedUser);
                        break;
                    case 4:
                        for (Invoice invoice : invoices) {
                            if (invoice.getCustomer() == logedUser) {
                                invoiceManager.Listing(invoice);
                            }
                        }

                        break;
                    case 5:
                        Login login = new Login();
                        permission = login.userLogin(users, customers);
                        break;
                }
            }
            scanner.nextLine();
        }

    }
    public static void clear(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }
    public static void createCustomer() {

        customers.add(new Customer(1, "Fatih", "Terim", "terim@gmail.com", "1905",
                "19054532175", false, "seyrantepe", LocalDate.now(), 0));

        customers.add(new Customer(2, "Barış", "Yılmaz", "yılmaz@gmail.com", "852963",
                "74185296374", true, "rize çayeli", LocalDate.now(), 5));
    }
    public static void createUser() {
        users.add(new User(1, "Ali", "Rıza", "a.rıza@gmail.com",
                "12345", "12345678910", true));
        users.add(new User(2, "Ahmet", "Arsalan", "ahmet@gmail.com",
                "98765", "10987654321", true));
    }
    public static void createCar() {
        cars.add(new Car(1, "Fiat", "Egea", "2011", 1700.0,
                true, 230000, "Benzin", "Sanuel", "Beyaz", "Sedan", "34YDM58"));

        cars.add(new Car(2, "Ford", "Focus", "2024", 2500,
                true, 15000, "Benzin", "Otomatik", "Siyah", "Sedan", "34GS1907"));
    }
    public static void createinvoice() {
        invoices.add(new Invoice(1, 1, 1, -1, 1700.0, 340,
                LocalDate.now(), LocalDate.now().plusDays(7),  "ödendi"));

        invoices.add(new Invoice(2, 2, 2, -1, 5000.0, 1000.0,
                LocalDate.now(), LocalDate.now().plusDays(7),  "ödendi"));
    }
    public static void createRental() {
        rentals.add(new Rental(1, 1, -1, 2, LocalDate.of(2024, 05,
                31), LocalDate.of(2024, 12, 7), 1700.0));
    }
}






