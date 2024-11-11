import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    private static List<Car> carList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Rental> rentalList = new ArrayList<>();
    private static List<Invoice> invoiceList = new ArrayList<>();
    private static List<Category> categorieList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static Customer  clientLogin = null;
    private static User  staffLogin = null;

    public static void main(String[] args) {

        customerList.add(new Customer(1, "Ahmet", "Yıldırım", "aky@gmail.com", "123", 1234567890, true, "kağıthane", LocalDate.of(2024, 10, 22), "zero"));
        customerList.add(new Customer(1, "Ahmet", "Yıldırım", "abc", "123", 1234567890, true, "kağıthane", LocalDate.of(2024, 10, 22), "zero"));
        customerList.add(new Customer(2, "kağan", "Akgün", "akgün@gmail.com", "654321", 1098765432, true, "taksim", LocalDate.of(2024, 9, 20), "zero"));
        carList.add(new Car(1, "opel", "corsa", 2022, 1400, true, 52000, "gasoline", "manual", "black", "Hecbek", "34AKY58"));
        carList.add(new Car(2, "bmw", "x3", 2020, 2500, true, 32000, "diesel", "automatic", "white", "Suv", "58AKY1905"));
        userList.add(new User(1, "Kağan", "Yıldırım", "staff@gmail.com", "123abc", true));
        userList.add(new User(2, "berkay", "yarar", "beko@gmail.com", "beko123", true));

        mainLogin();
    }

    public static void mainLogin(){
        while (true) {
            System.out.println("1. Müşteri girişi");
            System.out.println("2. Yetkili girişi");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int vote = scanner.nextInt();

            switch (vote) {
                case 1:
                    customerLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("geçersiz seçim");
            }
        }
    }

    private static void customerLogin(){
        scanner.nextLine();
        System.out.println("E-posta");
        String email = scanner.nextLine();
        System.out.println("Şifre");
        String password = scanner.nextLine();

        for (Customer customer : customerList){

            if (email.contains("@") && customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                clientLogin = customer;
                System.out.println("Müşteri girişi Başarılı");
                customerMenu();
                return;
            }
        }
        System.out.println("E-posta yada şifre hatalı");

    }

    private static void customerMenu(){
        while (true){
            System.out.println("1. Araçları Listele");
            System.out.println("2. Araç Kirala");
            System.out.println("3. Faturaları görüntüle");
            System.out.println("4. Kiralama geçmişi");
            System.out.println("5. Bilgilerimi Güncelle");
            System.out.println("6. Kullanıcımı Sil");
            System.out.println("7. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int vote = scanner.nextInt();
            switch (vote){
                case 1:
                    listCar();
                    break;
                case 2:
                    rentCar();
                    break;
                case 3:
                    viewInvoices();
                    break;
                case 4:
                    rentalHistory();
                    break;
                case 5:
                    customerUpdate();
                    break;
                case 6:
                    customerDelete();
                    break;
                case 7 :
                    mainLogin();
                    break;
                default:
                    System.out.println("geçersiz");

            }


        }
    }

    private static void userLogin(){
        scanner.nextLine();
        System.out.println("E-posta");
        String email = scanner.nextLine();
        System.out.println("Şifre");
        String password = scanner.nextLine();

        for (User user : userList){
            if (email.contains("@") && user.getEmail().equals(email) && user.getPassword().equals(password)){
                staffLogin = user;
                System.out.println("Yetkili girişi başarılı");
                staffMenu();
                return;
            }
        }
        System.out.println("E-posta veya şifre hatalı ");
    }

    private static void staffMenu(){
        while (true) {
            System.out.println("1. Araçları Listele");
            System.out.println("2. Araç Sil");
            System.out.println("3. Araç Güncelle");
            System.out.println("4. Araç Ekle");
            System.out.println("5. Müşteri Ekleme");
            System.out.println("6. Müşterileri Listele ");
            System.out.println("7. Müşteri Sil");
            System.out.println("8. Müşteri Bilgilerini Güncelle");
            System.out.println("9. Çıkış ");
            System.out.print("Seçiminizi yapın: ");

            int vote = scanner.nextInt();

            switch (vote){
                case 1:
                    adminListCar();
                    break;
                case 2 :
                    deleteCar();
                    break;
                case 3 :
                    updateCar();
                    break;
                case 4 :
                    addCar();
                    break;
                case 5 :
                   addCustomer();
                   break;
                case 6:
                    adminCustomerList();
                    break;
                case 7:
                    deleteCustomer();
                    break;
                case 8:
                    staffUpdateCustomer();
                    break;
                case 9:
                    mainLogin();
                    break;
                default:
                    System.out.println("geçersiz");
            }
        }

    }

    private static void listCar(){
        System.out.println("Hangi araç kategorisine bakmak istersiniz");
        System.out.println("1= Suv");
        System.out.println("2= Sedan");
        System.out.println("3= Heçbek");
        int vote = scanner.nextInt();

            switch (vote){
                case 1:
                    suvList();
                    break;
                case 2:
                    sedanList();
                    break;
                case 3:
                    hecbekList();
                    break;
                default:
                    System.out.println("geçersiz");
            }
    }

    private static void rentCar(){
        System.out.println("Kiralamak istediğiniz araç türünü seçin");

        System.out.println("1= Suv");
        System.out.println("2= Sedan");
        System.out.println("3= Heçbek");
        int vote = scanner.nextInt();

        for (Car car :carList){
        switch (vote){
            case 1:
                rentSuvList();
                break;
            case 2:
                rentSedanList();
                break;
            case 3:
                rentHecbekList();
                break;
        }
        }
    }

    private static void adminListCar(){
        System.out.println("Hangi araç kategorisine bakmak istersiniz");
        System.out.println("1= Suv");
        System.out.println("2= Sedan");
        System.out.println("3= Heçbek");
        int vote = scanner.nextInt();

        for (Car car :carList){
            switch (vote){
                case 1:
                    staffSuvList();
                    break;
                case 2:
                    staffSedanList();
                    break;
                case 3:
                    staffHecbekList();
                    break;
                default:
                    System.out.println("geçersiz");
            }
        }
    }

    private static void staffSuvList(){
        int suvSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Suv")){
                System.out.println(car);
                suvSum++;
            }
        }
        if (suvSum<1){
            System.out.println("Bu kategoride aracımız yok");
            staffMenu();
        }
    }
    private static void staffSedanList(){
        int sedanSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Sedan")){
                System.out.println(car);
            }
        }
        if (sedanSum<1){
            System.out.println("Bu kategoride aracımız yok");
            staffMenu();
        }
    }
    private static void staffHecbekList() {
        int hecbekSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Hecbek")){
                System.out.println(car);
            }
        }
        if (hecbekSum<1){
            System.out.println("Bu kategoride aracımız yok");
            staffMenu();
        }
    }

    private static void suvList(){
        int suvSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Suv")){
                System.out.println(car);
                suvSum++;
            }
        }
        if (suvSum<1){
            System.out.println("Bu kategoride başka aracımız yok");
            customerMenu();
        }
    }
    private static void sedanList(){
        int sedanSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Sedan")){
                System.out.println(car);
            }
        }
        if (sedanSum<1){
            System.out.println("Bu kategoride başka aracımız yok");
            customerMenu();
        }
    }
    private static void hecbekList() {
        int hecbekSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Hecbek")){
                System.out.println(car);
            }
        }
        if (hecbekSum<1){
            System.out.println("Bu kategoride başka aracımız yok");
            customerMenu();
        }
    }

    private static void rentSuvList(){
        int suvSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Suv") && car.getAvailable()){
                System.out.println(car);
                suvSum++;
            }
        }
        if (suvSum<1){
            System.out.println("Bu kategoride kiralanabilir başka aracımız yok");
            customerMenu();
        }


        System.out.println("kiralamak istediğiniz aracın id si ");
        int carId = scanner.nextInt();
        System.out.println("kaç gün kiralamak istersiniz");
        int rentCarDay = scanner.nextInt();

        Car car = carList.get(carId - 1);
        double priceWithoutVat = car.getDailyRentalPrice()* rentCarDay;
        double kdv = priceWithoutVat*0.2;
        double totalprice = priceWithoutVat + kdv;
        System.out.println("Kiralıyacağınız aracın vergisi "+kdv+"Toplam kiralama ücreti "+totalprice);
        System.out.println("1-Evet");
        System.out.println("2-Hayır");
        int yesNo = scanner.nextInt();
        if (yesNo == 1){
            Customer customer = clientLogin;
            System.out.println("Aracı kiraladınız");
            car.setAvailable(false);
            customer.setRentalStatus(true);

        }
        customerMenu();
    }
    private static void rentSedanList(){
        int suvSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Sedan") && car.getAvailable()){
                System.out.println(car);
                suvSum++;
            }
        }
        if (suvSum<1){
            System.out.println("Bu kategoride kiralanabilir başka aracımız yok");
            customerMenu();
        }


        System.out.println("kiralamak istediğiniz aracın id si ");
        int carId = scanner.nextInt();
        System.out.println("kaç gün kiralamak istersiniz");
        int rentCarDay = scanner.nextInt();

        Car car = carList.get(carId - 1);
        double priceWithoutVat = car.getDailyRentalPrice()* rentCarDay;
        double kdv = priceWithoutVat*0.2;
        double totalprice = priceWithoutVat + kdv;
        System.out.println("Kiralıyacağınız aracın vergisi "+kdv+"Toplam kiralama ücreti "+totalprice);
        System.out.println("1-Evet");
        System.out.println("2-Hayır");
        int yesNo = scanner.nextInt();
        if (yesNo == 1){
            Customer customer = clientLogin;
            System.out.println("Aracı kiraladınız");
            car.setAvailable(false);
            customer.setRentalStatus(true);
        }
        customerMenu();
    }
    private static void rentHecbekList(){
        int suvSum = 0;
        for (Car car : carList){
            if (car.getCategory().equals("Hecbek") && car.getAvailable()){
                System.out.println(car);
                suvSum++;
            }
        }
        if (suvSum<1){
            System.out.println("Bu kategoride kiralanabilir başka aracımız yok");
            customerMenu();
        }

        System.out.println("kiralamak istediğiniz aracın id si ");
        int carId = scanner.nextInt();
        System.out.println("kaç gün kiralamak istersiniz");
        int rentCarDay = scanner.nextInt();

        Car car = carList.get(carId - 1);
        double priceWithoutVat = car.getDailyRentalPrice()* rentCarDay;
        double kdv = priceWithoutVat*0.2;
        double totalprice = priceWithoutVat + kdv;
        System.out.println("Kiralıyacağınız aracın vergisi "+kdv+"Toplam kiralama ücreti "+totalprice);
        System.out.println("1-Evet");
        System.out.println("2-Hayır");
        int yesNo = scanner.nextInt();
        if (yesNo == 1){
            Customer customer = clientLogin;
            System.out.println("Aracı kiraladınız");
            car.setAvailable(false);
            customer.setRentalStatus(true);
        }
        customerMenu();
    }

    private static void  viewInvoices(){
        if (rentalList.isEmpty()){
            System.out.println("Güncel Faturanız Bulunmamakta");
            return;

        }

        boolean invoiceExists = false;

        for (Rental rental : rentalList){
            Invoice invoice = rental.getInvoice();

            if (invoice != null){
                invoiceExists = true;
                Customer customer = rental.getCustomer();

                System.out.println("Müşteri Adı"+ customer.getName());
            }
        }

    }
    private static void rentalHistory(){
        Customer customer = clientLogin;
    }

    private static void customerUpdate(){

        if (clientLogin != null){
            Customer customer = clientLogin;
            System.out.println("Aşağıdaki bilgilerinizi Güncel Bir Şekilde Doldurunuz");
            scanner.nextLine();
            System.out.println("İsminiz");
            String _name = scanner.nextLine();
            if (!_name.isEmpty()){
                customer.setName(_name);
                System.out.println("İsminiz başarıyla Güncellendi");
            }else{
                System.out.println("Bu Alan Boş Bırakılamaz");
                customerUpdate();
            }

            System.out.println("Soyadınız");
            String _surname = scanner.nextLine();
            if (!_surname.isEmpty()){
                customer.setSurname(_surname);
                System.out.println("Soyadınız Güncellendi");
            }else {
                System.out.println("Bu Alan Boş Bırakılamaz");
                customerUpdate();
            }

            System.out.println("E-mail");
            String _email = scanner.nextLine();
            if (!_email.isEmpty() && _email.contains("@")){
                customer.setEmail(_email);
                System.out.println("E-mail Güncellendi");
            }else{
                System.out.println("Bu Alan Boş Bırakılamaz");
                customerUpdate();
            }

            System.out.println("Şifre");
            String _password = scanner.nextLine();
            if (!_password.isEmpty()){
                customer.setPassword(_password);
                System.out.println("Şifreniz Güncellendi");
            }else{
                System.out.println("Bu Alan Boş Bırakılamaz");
                customerUpdate();
            }

            System.out.println("Telefon numaranız");
            long _phoneNumber = scanner.nextLong();
            if (_phoneNumber>999999999){
                customer.setPhoneNumber(_phoneNumber);
                System.out.println("Telefon Numaranız Güncellendi");
            }else{
                System.out.println("Eksik Telefon Numarası Tuşladınız");
                customerUpdate();
            }


            System.out.println("Adresiniz");
            String _address = scanner.nextLine();
            if (_address.isEmpty()){
                customer.setAddress(_address);
                System.out.println("Adresiniz Başarıyla Güncellendi");
            }else{
                System.out.println("Bu Alan Boş Bırakılamaz");
                customerUpdate();
            }

        }
    }

    public static void customerDelete(){
        if (clientLogin != null){
            Customer customer = clientLogin;
            System.out.println("Hesabınızı Silmek Mi İstiyorsunuz 1-Evet 2-Hayır");
            int yesNo = scanner.nextInt();
            int sum =+ yesNo ;
            if (customer.getRentalStatus()==false && sum==1 ){
                customerList.remove(customer);
                System.out.println("Hesabınız silindi ");
                mainLogin();
            } else{
                System.out.println("Hesap Silme İşlemi Başarısız");
                customerMenu();
            }
        }
    }



    private static void deleteCar(){
        adminListCar();

        System.out.println("Silmek istediğiniz aracın id si");
        int carId =  scanner.nextInt();
        int sum = 0;
        Car car = carList.get(carId - 1);
        System.out.println("Aracı silmek istediğinize emin misiniz");
        System.out.println("1- Evet");
        System.out.println("2- Hayır");
        int yesNo = scanner.nextInt();
        sum =+ yesNo;
        if (sum == 1 && car.getAvailable()){
            carList.remove(car);
            System.out.println("Araç Silindi");
        }else {
            System.out.println("Araç Silinemedi");
            staffMenu();
        }

    }
    public static void updateCar(){
        adminListCar();
        System.out.println("Hangi aracı güncellemek istersiniz");
        int carId = scanner.nextInt();

        Car car =carList.get(carId - 1);

        System.out.println("Aracın Yeni Günlük Fiyatı");
        double _dailyRentalPrice = scanner.nextDouble();
        if (_dailyRentalPrice > 0){
            car.setDailyRentalPrice(_dailyRentalPrice);
            System.out.println("Aracın fiyatı güncellendi");
        }else {
            System.out.println("Geçersiz Eleman");
            staffMenu();
        }

        System.out.println("Aracın Yeni Kilometresi");
        double _mileage = scanner.nextDouble();
        if (_mileage >=0){
            car.setMileage(_mileage);
            System.out.println("Aracın Kilometresi Güncellendi");
        }else {
            System.out.println("Geçersiz Eleman");
            staffMenu();
        }

        scanner.nextLine();
        System.out.println("Aracın Yeni rengi");
        String _color = scanner.nextLine();
        if (!_color.isEmpty()){
            car.setColor(_color);
            System.out.println("Aracın Rengi Güncellendi");
        }else {
            System.out.println("Geçersiz Eleman");
            staffMenu();
        }

        System.out.println("Aracın yeni plakası");
        String _licensePlate = scanner.nextLine();
        if (!_licensePlate.isEmpty()){
            car.setLicensePlate(_licensePlate);
            System.out.println("Aracın plakası Güncellendi");
        }else {
            System.out.println("Geçersiz Eleman");
            staffMenu();
        }
        System.out.println("Araç Güncellendi");
    }
    public static void addCar(){
        scanner.nextLine();
        System.out.println("Araç Id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Aracın Markası");
        String brand = scanner.nextLine();
        System.out.println("Aracın Modeli");
        String model = scanner.nextLine();
        System.out.println("Aracın Yılı");
        int productionYear = scanner.nextInt();
        System.out.println("Günlük Kiralama Ücreti");
        double dailyRentalPrice = scanner.nextDouble();
        System.out.println("Aracın aktiflik durumu 1=Aktif 2=Pasif");
        int available = scanner.nextInt();

        boolean isAvailable;

        if (available ==1 ){
            isAvailable = true;
        }else {
            isAvailable = false;
        }

        System.out.println("Aracın Kilometresi");
        double mileage = scanner.nextInt();
        System.out.println("Yakıt Tipi ");
        String fuelType = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Şanzıman Türü");
        String transmissionType = scanner.nextLine();
        System.out.println("Aracın Rengi");
        String color = scanner.nextLine();
        System.out.println("Araç Kategorisi Suv-Sedan-Heçbek");
        String category = scanner.nextLine();
        System.out.println("Aracın Plakası");
        String licensePlate = scanner.nextLine();

        Car car = new Car(carList.size(), brand, model, productionYear, dailyRentalPrice,
                           isAvailable, mileage, fuelType, transmissionType, color, category, licensePlate);
        carList.add(car);
        System.out.println("Araç eklendi");


    }

    public static void addCustomer(){

        System.out.println("Müşteri Id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Müşteri Adı");
        String name = scanner.nextLine();
        System.out.println("Müşterinin Soyadı");
        String surname = scanner.nextLine();
        System.out.println("Müşteri E-mail");
        String email = scanner.nextLine();
        System.out.println("Müşteri şifresi");
        String password = scanner.nextLine();
        System.out.println("Müşteri Telefon Numarası Başında 0 Olmadan");
        long phoneNumber = scanner.nextLong();
        System.out.println("Kiralama durumu 1= Aktif 2= Pasif");

        int rental = scanner.nextInt();

        boolean rentalStatus;

        if (rental ==1 ){
            rentalStatus = true;
        }else {
            rentalStatus = false;
        }
        scanner.nextLine();
        System.out.println("Müşterinin adresi");
        String address = scanner.nextLine();
        System.out.println("Kayıt Tarihi Şu anın Tarihi Girildi");
        LocalDate registrationDate = LocalDate.now();
        System.out.println("Kiralama geçmişi");
        String rentalHistory = scanner.nextLine();

        System.out.println("Müşteri Başarıyla eklendi");



    }
    public static void adminCustomerList(){

        for (Customer customer : customerList){
            System.out.println(customer);
        }

    }
    public static void deleteCustomer(){
        adminCustomerList();
        System.out.println("Silmek istediğiniz müşterinin id si");
        int customerId = scanner.nextInt();
        int sum = 0;
        Customer customer = customerList.get(customerId - 1);
        System.out.println("Müşteriyi silmek istediğinize emin misiniz ");
        System.out.println("1- Evet");
        System.out.println("2- Hayır");
        int yesNo = scanner.nextInt();
        sum =+yesNo;
        if (sum ==1){
            customerList.remove(customer);
            System.out.println("Müşteri silindi");
        }else {
            System.out.println("Müşteri silinemedi");
            staffMenu();
        }
    }
    public static void staffUpdateCustomer(){
        adminCustomerList();
        System.out.println("Hangi kullanıcıyı güncellemek istersiniz");
        int customerId = scanner.nextInt();
        Customer customer =customerList.get(customerId - 1);
        scanner.nextLine();
        System.out.println("Kullanıcının Yeni İsmi");
        String _name = scanner.nextLine();
        if (!_name.isEmpty()){
            customer.setName(_name);
            System.out.println("Kullanıcı Adı Güncellendi");
        }else{
            System.out.println("Bu Alan Boş Bırakılamaz");
            staffUpdateCustomer();
        }
        System.out.println("Kullanıcının Yeni Soyismi");
        String _surname = scanner.nextLine();
        if (!_surname.isEmpty()){
            customer.setSurname(_surname);
            System.out.println("Kullanıcının Soyadı Güncellendi");
        }else{
            System.out.println("Bu Alan Boş Bırakılamaz");
            staffUpdateCustomer();
        }
        System.out.println("Kullanıcının E-postası");
        String _email = scanner.nextLine();
        if (!_email.isEmpty() && _email.contains("@")){
            customer.setEmail(_email);
            System.out.println("E-Mail Başarıyla Güncellendi");
        }else {
            System.out.println("Hatalı E posta");
            staffUpdateCustomer();
        }
        System.out.println("Kullanıcının Yeni Şifresi");
        String _password = scanner.nextLine();
        if (!_password.isEmpty()){
            customer.setPassword(_password);
            System.out.println("Şifre başarıyla Güncellendi");
        }else{
            System.out.println("Bu Alan Boş Bırakılamaz");
            staffUpdateCustomer();
        }
        System.out.println("Kullanıcının Yeni Telefon Numarası Başında 0 Olmadan Giriniz");
        long _phoneNumber = scanner.nextLong();
        if (_phoneNumber>999999999){
            customer.setPhoneNumber(_phoneNumber);
            System.out.println("Kullanıcı Numarası Başarıyla Güncellendi");
        }else{
            System.out.println("Telefon Numarasını Eksik Girdiniz");
            staffUpdateCustomer();
        }

        System.out.println("Kiralama Durumu 1=Aktif 2=Pasif");
        int available = scanner.nextInt();

        boolean rentalStatus;

        if (available ==1 ){
            rentalStatus = true;
        }else {
            rentalStatus = false;
        }
        scanner.nextLine();
        System.out.println("Kullanıcının Yeni Adresi");
        String _address = scanner.nextLine();
        if (!_address.isEmpty()){
            customer.setAddress(_address);
            System.out.println("Kullanıcının Adresi Başarıyla Güncellendi");
        }else{
            System.out.println("Bu alan Boş bırakılamaz");
            staffUpdateCustomer();
        }
        System.out.println("Kullanıcı bilgileri Güncellendi");
    }






    }