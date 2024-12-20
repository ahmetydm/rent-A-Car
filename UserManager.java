import Classrooms.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {

    public void userList(ArrayList<User>users){

        for (User user : users){
            System.out.println(user.getPersonID()+" "+user.getName()+" "+user.getSurname()+" "+user.getEmail()+" "+user.getPhoneNumber());

        }
    }
    public void add(ArrayList<User>users) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        String name;
        while (true) {
            name = getInput("Adınızı giriniz ", scanner);
            if (!name.isEmpty())break;
                System.out.println("Adınız boş bırakılamaz");
        }

        String surname;
        while (true) {
            surname = getInput("Soyadınızı giriniz", scanner);
            if (!surname.isEmpty())break;
                System.out.println("Soyadınız boş bırakılamaz");

        }

        String email;
        while (true) {
            email = getInput("Email adresinizi giriniz", scanner);
            if (!email.isEmpty() && email.contains("@"))break;
                System.out.println("Email kısmı boş bırakılamaz");
                return;
        }

        String password;
        while (true) {
            password = getInput("Şifrenizi giriniz", scanner);
            if (!password.isEmpty() && password.length() > 6) break;
                System.out.println("şifreniz boş bırakılamaz ve en az 7 karakterden oluşmalı");
        }

        String phoneNumber;
        while (true) {
            phoneNumber = getInput("Telefon numaranızı  başında 0 olmadan giriniz ", scanner);
            long number = Long.parseLong(phoneNumber);
            if (!phoneNumber.isEmpty() && number > 999999999)break;
                System.out.println("Geçersiz eleman yada eksik telefon numarası");
        }

        boolean emailValid = validator.emailValid(email);
        if (emailValid){
            System.out.println("Girdiğiniz email ile zaten kayıt yapılmış.");
        }else{
            users.add(new User(users.size()+1 ,name , surname ,email , password ,
                    phoneNumber, false ));
            System.out.println("Yetkili başarıyla eklendi");
        }


    }
    public String getInput(String message, Scanner scanner) {
        System.out.println(message);
        String value= scanner.nextLine();
        return value;
    }


    public void removeUser(ArrayList<User>users){

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        userList(users);
        System.out.println("Silmek istediğiniz yetkili ıd si giriniz");
        int userId = scanner.nextInt();
        User user = users.get(userId-1);
        System.out.println("Müşteriyi silmek istediğinize emin misiniz 1=EVET/2=HAYIR");
        int customerSum = scanner.nextInt();
        sum=customerSum;
        if (sum==1){
            users.remove(user);
            System.out.println("Yetkili başarıyla silindi");
        }else {
            System.out.println("Yetkili silinemedi ");
        }
    }


    public int userIndex(int userId, ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPersonID() == userId) {
                return i;
            }
        }
        return -1;
    }

    public String userValue(String Message, Scanner scanner) {
        System.out.println(Message);
        return scanner.nextLine();
    }

    public void updateUser(ArrayList<User>users){

        userList(users);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bilgilerini güncellemek istediğiniz kullanıcının id si");
        int userId = scanner.nextInt();
        scanner.nextLine();
        User user = users.get(userId-1);

        String name;
        while (true) {
            System.out.println("Güncellemek istediğiniz isminiz");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                user.setName(name);
                System.out.println("İsminiz güncellendi");
                break;
            } else {
                System.out.println("İsim kısmı boş bırakılamaz");
            }
        }

        String surname;
        while (true) {
            System.out.println("Güncellemek istediğiniz soyadı");
            surname = scanner.nextLine();
            if (!surname.isEmpty()) {
                user.setSurname(surname);
                System.out.println("Soyadı güncelendi");
                break;
            } else {
                System.out.println("Soyadınız boş bırakılamaz");
            }
        }

        String email;
        while (true) {
            System.out.println("Güncellemek istediğiniz email");
            email = scanner.nextLine();
            if (!email.isEmpty() && email.contains("@")) {
                user.setEmail(email);
                System.out.println("Email başarıyla güncellendi");
                break;
            } else {
                System.out.println("Email boş bırakılamaz ");
            }
        }

        String password;
        while (true) {
            System.out.println("Güncellemek istediğiniz şifre");
            password = scanner.nextLine();
            if (!password.isEmpty() && password.length() > 6) {
                user.setPassword(password);
                System.out.println("Şifre güncellendi");
                break;
            } else {
                System.out.println("Şifreniz boş bırakılamaz ve en az 7 karakterli olmalı");
            }
        }

        String phoneNumber;
        while (true) {
            System.out.println("Güncellemek istediğiniz telefon numarası");
            phoneNumber = scanner.nextLine();
            long number2 = Long.parseLong(phoneNumber);
            if (!phoneNumber.isEmpty() && number2 > 999999999) {
                user.setPhoneNumber(phoneNumber);
                System.out.println("Telefon numarası başarıyla güncellendi ");
                break;
            } else {
                System.out.println("Telefon numarası boş bırakılamaz");
            }
        }


    }



}
