package Car;

import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

    public void add(ArrayList<Car> cars){
        Scanner scanner = new Scanner(System.in);


            String brand;
            while (true) {
                brand = getInput("Aracın markasını giriniz: ", scanner);
                if (!brand.isEmpty())break;
                    System.out.println("Araç markası boş bırakılamaz");
            }

            String model;
            while (true) {
                model = getInput("Aracın modelini giriniz: ", scanner);
                if (!model.isEmpty())break;
                    System.out.println("Aaç modeli boş bırakılamaz");
            }

            String productionYear;
            while (true) {
                productionYear = getInput("Aracın üretim yılını giriniz (yyyy-mm-dd): ", scanner);
                if (!productionYear.isEmpty() && productionYear.matches("\\d{4}-\\d{2}-\\d{2}")) break;
                    System.out.println("Üretim yılı boş veya geçersiz formatta");
            }

            double dailyRentalPrice;
            while (true) {
                dailyRentalPrice = Double.parseDouble(getInput("Aracın günlük kiralama ücretini giriniz: ", scanner));
                try {
                    if (dailyRentalPrice > 550) break;
                    System.out.println("Geçersiz fiyat girişi");
                }catch (NumberFormatException e){
                    System.out.println("Geçersiz fiyat girişi");
                }
            }

            double mileage;
            while (true) {
                mileage = Double.parseDouble(getInput("Aracın kilometresini giriniz: ", scanner));
                try {
                    if (mileage >-1)break;
                    System.out.println("Aracın kilometresi yanlış girdiniz yada boş boş bıraktınız");
                }catch (NumberFormatException e){
                    System.out.println("Aracın kilometresi yanlış girdiniz yada boş boş bıraktınız");
                }

            }

            String fuelType;
            while (true) {
                fuelType = getInput("Aracın yakıt tipini giriniz: ", scanner);
                if (!fuelType.isEmpty() && fuelType.length() > 4)break;
                    System.out.println("Aracın yakıt tipi boş bırakılamaz");
            }

        String transmissionType;
            while (true) {
                transmissionType = getInput("Aracın şanzıman türünü giriniz: ", scanner);
                if (!transmissionType.isEmpty() && transmissionType.length() > 5)break;
                    System.out.println("Aracın şanzıman türü boş bırakılamaz ");
            }

        String color;
            while (true) {
                color = getInput("Aracın rengini giriniz: ", scanner);
                if (!color.isEmpty())break;
                    System.out.println("Aracın rengi boş bırakılamaz");
            }

            String category;
            while (true) {
                category = getInput("Aracın kategorisini giriniz örn: Suv,sedan,heçbek: ", scanner);
                if (!category.isEmpty()) break;
                    System.out.println("Araç karegorisi boş bırakılamaz");
            }

            String licensePlate;
            while (true) {
                licensePlate = getInput("Aracın plakasını giriniz: ", scanner);
                if (!licensePlate.isEmpty() && licensePlate.length() > 6) break;
                    System.out.println("Araç plakası boş bırakılamaz");
            }

        try {
            cars.add(new Car(cars.size() +1 , brand , model , productionYear , dailyRentalPrice , true,
                    mileage , fuelType , transmissionType , color , category , licensePlate));
            System.out.println("Araç başarıyla eklendi");
        }
        catch (Exception e){
            System.out.println("Bir hata meydana geldi araç eklenemedi");
        }

        }
    public String getInput(String message, Scanner scanner) {
        System.out.println(message);
        String value= scanner.nextLine();
        return value;
    }

    public void carList(ArrayList<Car>cars){
        for (Car car : cars){
            System.out.println(car.getCarId()+" "+car.getBrand()+" "+car.getModel()+" "+car.getProductionYear()+" "+car.getDailyRentalPrice() +" "+
                    car.getMileage()+" "+car.getFuelType()+" "+car.getTransmissionType()+" "+car.getColor()+" "+car.getCategory()+" "+car.getLicensePlate());

        }
    }
    public void availabileCars(ArrayList<Car>cars){
        for (Car car : cars){
            if (car.isAvailable()){
                System.out.println(car.getCarId()+" "+car.getBrand()+" "+car.getModel()+" "+car.getProductionYear()+" "+car.getDailyRentalPrice() +" "+
                        car.getMileage()+" "+car.getFuelType()+" "+car.getTransmissionType()+" "+car.getColor()+" "+car.getCategory()+" "+car.getLicensePlate());

            }else{
                System.out.println("Kiramak için uygun araç bulunmamakta");
            }
        }
    }
    public void removeCar(ArrayList<Car>cars){

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        carList(cars);
        System.out.println("Silmek istediğiniz aracın id si");
        int carId = scanner.nextInt();
        Car car = cars.get(carId-1);
        System.out.println("Aracı silmek istediğinizden emin misiniz 1=EVET/2=İPTAL");
        int carSum = scanner.nextInt();
        sum = carSum;
        if (car.getAvailable() && sum==1){
            cars.remove(car);
            System.out.println("Araç başarıyla silindi");
        }else {
            System.out.println("Araç silinmedi yada silinmesi için uygun değil ");
        }


    }
    public void updateCar(ArrayList<Car>cars){
        carList(cars);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bilgilerini güncellemek istediğiniz aracı seçin");

        int carId = scanner.nextInt();
        scanner.nextLine();
        Car car = cars.get(carId-1);



        String dailyRentalPrice;
        while (true) {
            System.out.println("aracın yeni günlük fiyatı");
            dailyRentalPrice = scanner.nextLine();
            double dayPrice = Double.parseDouble(dailyRentalPrice);
            if (!dailyRentalPrice.isEmpty() && dayPrice > 550) {
                car.setDailyRentalPrice(dayPrice);
                System.out.println("aracın fiyatı güncellendi");
                break;
            } else {
                System.out.println("geçersiz eleman");
            }
        }

            scanner.nextLine();

        String mileage;
        while (true) {
            System.out.println("aracın yeni kilometresi");
            mileage = scanner.nextLine();
            double mileage_ = Double.parseDouble(mileage);
            if (!mileage.isEmpty() && mileage_>-1) {
                car.setMileage(mileage_);
                System.out.println("aracın kilometresi güncellendi");
                break;
            } else {
                System.out.println("geçersiz eleman");
            }
        }

            scanner.nextLine();

        String color;
        while (true) {
            System.out.println("aracın yeni rengi");
            color = scanner.nextLine();
            if (!color.isEmpty()) {
                car.setColor(color);
                System.out.println("aracın rengi güncellendi");
                break;
            } else {
                System.out.println("Aracın rengi boş bırakılamaz");
            }
        }

            scanner.nextLine();

        String licensePlate;
        while (true) {
            System.out.println("aracın yeni plakası ");
            licensePlate = scanner.nextLine();
            if (!licensePlate.isEmpty() && licensePlate.length() > 6) {
                car.setLicensePlate(licensePlate);
                System.out.println("aracın plakası güncellendi");
                break;
            } else {
                System.out.println("Aracın plakası boş bırakılamaz");
            }
        }


    }


}
