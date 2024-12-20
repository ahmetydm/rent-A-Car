import Classrooms.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {

    public void customerList(ArrayList<Customer> customers) {
        int logId = -1;
        for (Customer customer : customers) {
            System.out.println(customer.getPersonID() + " " + customer.getName() + " " + customer.getSurname() + " " + customer.getEmail() + " " +
                    customer.getPhoneNumber() + " " + customer.getAddress() + " " + customer.getRentalStatus() + " " + customer.getRegistrationDate());

        }

    }

    public void add(ArrayList<Customer> customers) {

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        String name;
        while (true) {
            name = getInput("Müşterinin ismini giriniz", scanner);
            if (!name.isEmpty()) break;
            System.out.println("Müşteri adı boş bırakılamaz");
        }

        String surname;
        while (true) {
            surname = getInput("Müşteri soyadını giriniz", scanner);
            if (!surname.isEmpty()) break;
            System.out.println("Müşteri soyadı boş bırakılamaz");
        }

        String password;
        while (true) {
            password = getInput("Mişteri şifresini giriniz", scanner);
            if (!password.isEmpty() && password.length() > 6) break;
            System.out.println("Müşteri şifresi boş bırakılamaz ve en az 7 karakterden oluşmalı");
        }

        String email;
        while (true) {
            email = getInput("müşteri emailini giriniz", scanner);
            if (!email.isEmpty() && email.contains("@")) break;
            System.out.println("Müşteri emaili boş bırakılamaz");
        }


        String phoneNumber;
        while (true) {
        phoneNumber = getInput("Müşterinin telefon numarasını giriniz", scanner);
        try {
            long number = Long.parseLong(phoneNumber);
            if (!phoneNumber.isEmpty() && number > 999999999) break;
            System.out.println("Müşteri telefon numarası boş bırakılamaz veya yanlış telefon numarası girdiniz");
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz telefon numarası. Lütfen sayısal bir değer giriniz.");
        }
    }
        String address;
        while (true) {
            address = getInput("Müşterinin adresini giriniz", scanner);
            if (!address.isEmpty() && address.length()>19)break;
                System.out.println("Müşteri adresi boş bırakılamaz ve en az 20 karakterden oluşmalı");
        }

        boolean emailValid = validator.emailValid(email);
        if (emailValid) {
            System.out.println("Girdiğiniz email ile zaten kayıt yapılmış.");
        } else {
            customers.add(new Customer(customers.size() + 1, name, surname, password, email,
                    phoneNumber, false, address, LocalDate.now(), 0));
            System.out.println("Müşteri başarıyla eklendi");
        }
    }

    public String getInput(String message, Scanner scanner) {
        System.out.println(message);
        String value = scanner.nextLine();
        return value;
    }

    public void removeCustomer(ArrayList<Customer> customers) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        customerList(customers);
        System.out.println("Silmek istediğiniz müşteri ıd si giriniz");
        int customerId = scanner.nextInt();
        Customer customer = customers.get(customerId - 1);
        System.out.println("Müşteriyi silmek istediğinize emin misiniz 1=EVET/2=HAYIR");
        int customerSum = scanner.nextInt();
        sum = customerSum;
        if (sum == 1) {
            customers.remove(customer);
            System.out.println("Müşteri başarıyla silindi");
        } else {
            System.out.println("Müşteri silinemedi ");
        }
    }

    public void updateCustomer(ArrayList<Customer> customers) {

        Scanner scanner = new Scanner(System.in);
        customerList(customers);

        System.out.println("Bilgilerini güncellemek istediğiniz müşteri id si");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers.get(customerId - 1);

        String name;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz ismi");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                customer.setName(name);
                System.out.println("Müşterinin adı güncellendi");
                break;
            }else {
                System.out.println("Müşterinin adı boş bırakılamaz");
            }
        }

        scanner.nextLine();
        String surname;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz soyadı");
            surname = scanner.nextLine();
            if (!surname.isEmpty()) {
                customer.setSurname(surname);
                System.out.println("Müşterinin soyadı güncellendi");
                break;
            }else {
                System.out.println("Müşterinin soyadı boş bırakılamaz");
            }
        }

        scanner.nextLine();

        String email;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz emaili");
            email = scanner.nextLine();
            if (!email.isEmpty() && email.contains("@")) {
                customer.setEmail(email);
                System.out.println("Müşterinin emaili güncellendi");
                break;
            } else {
                System.out.println("Müşterinin emaili boş bırakılamaz");
            }
        }

        scanner.nextLine();

        String address;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz adresi");
            address = scanner.nextLine();
            if (!address.isEmpty() && address.length()>19) {
                customer.setAddress(address);
                System.out.println("Müşterinin adresi güncellendi");
                break;
            } else {
                System.out.println("Müşterinin adresi boş bırakılamaz ve en az 20 karakterden oluşmalı");
            }
        }

        scanner.nextLine();

        String phoneNumber;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz numarası");
            phoneNumber = scanner.nextLine();
            long number = Long.parseLong(phoneNumber);
            if (!phoneNumber.isEmpty() && number > 999999999) {
                customer.setPhoneNumber(phoneNumber);
                System.out.println("Müşterinin telefon numarası güncellendi");
                break;
            } else {
                System.out.println("Müşterinin telefon numarası boş bırakılamaz");
            }
        }
        scanner.nextLine();

        String password;
        while (true) {
            System.out.println("Müşterinni güncellemek istediğiniz şifresi");
            password = scanner.nextLine();
            if (!password.isEmpty() && password.length() > 6) {
                customer.setPassword(password);
                System.out.println("Müşterinin şifresi güncellendi");
                break;
            } else {
                System.out.println("Müşterinin şifresi boş bırakılamaz ve en az 7 karakterden oluşmalı");
            }
        }
    }

    public void updateSelf(ArrayList<Customer> customers, int id, Scanner scanner) {
        int sum = 0;
        int updateCustomerIndex = getCustomerIndex(id, customers);
        System.out.println("Bilgileriniz güncellemek ister misiniz 1=EVET/2=HAYIR");



    }

    public void updateCustomerSelf(ArrayList<Customer> customers , int id , Scanner scanner) {

        int updateId = getCustomerIndex(id,customers);
        customerList(customers);


        System.out.println("Bilgilerini güncellemek istediğiniz müşteri id si");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers.get(customerId - 1);

        String name;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz ismi");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                customer.setName(name);
                System.out.println("Müşterinin adı güncellendi");
                break;
            } else {
                System.out.println("Müşterinin adı boş bırakılamaz");
            }
        }


        String surname;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz soyadı");
            surname = scanner.nextLine();
            if (!surname.isEmpty()) {
                customer.setSurname(surname);
                System.out.println("Müşterinin soyadı güncellendi");
                break;
            } else {
                System.out.println("Müşterinin soyadı boş bırakılamaz");
            }
        }


        String email;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz emaili");
            email = scanner.nextLine();
            if (!email.isEmpty() && email.contains("@")) {
                customer.setEmail(email);
                System.out.println("Müşterinin emaili güncellendi");
                break;
            } else {
                System.out.println("Müşterinin emaili boş bırakılamaz");
            }
        }


        String address;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz adresi");
            address = scanner.nextLine();
            if (!address.isEmpty() && address.length()>19) {
                customer.setAddress(address);
                System.out.println("Müşterinin adresi güncellendi");
                break;
            } else {
                System.out.println("Müşterinin adresi boş bırakılamaz ve en az 20 karakterden oluşmalı");
            }
        }

        String phoneNumber;
        while (true) {
            System.out.println("Müşterinin güncellemek istediğiniz numarası");
            phoneNumber = scanner.nextLine();
            long number = Long.parseLong(phoneNumber);
            if (!phoneNumber.isEmpty() && number > 999999999) {
                customer.setPhoneNumber(phoneNumber);
                System.out.println("Müşterinin telefon numarası güncellendi");
                break;
            } else {
                System.out.println("Müşterinin telefon numarası boş bırakılamaz");
            }
        }


        String password;
        while (true) {
            System.out.println("Müşterinni güncellemek istediğiniz şifresi");
            password = scanner.nextLine();
            if (!password.isEmpty() && password.length() > 6) {
                customer.setPassword(password);
                System.out.println("Müşterinin şifresi güncellendi");
                break;
            } else {
                System.out.println("Müşterinin şifresi boş bırakılamaz ve en az 7 karakterden oluşmalı");
            }
        }
    }

    public int getCustomerIndex(int customerId, ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPersonID() == customerId) {
                return i;
            }
        }
        return -1;
    }

    public void listWithId(ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getPersonID() == id) {
                System.out.println(customer.getPersonID() + " " + customer.getName() + " " + customer.getSurname() + " " + customer.getEmail() + " " +
                        customer.getAddress() + " " + customer.getRentalStatus() + " " + customer.getAddress() + " " + customer.getRentalHistory());
                break;
            }
        }
    }

}


