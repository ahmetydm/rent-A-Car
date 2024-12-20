import Car.Car;
import Classrooms.Customer;
import Classrooms.User;

import java.util.ArrayList;

public class Validator {

    public  boolean emailValid(String email){
        for (Customer customer : Main.customers){
            if (customer.getEmail().equals(email)){
                return true;
            }
        }
        for (User user : Main.users){
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return  false;
    }
    public boolean carValid(ArrayList<Car>cars , int carId_) {
        for (Car car : cars) {
            if (carId_ == car.getCarId() && car.isAvailable() == true) {
                return true;
            }
        }
        return false;
    }
    public boolean carValid(int carId){
        for (Car cars : Main.cars){
            if (carId == cars.getCarId())
            return true;
        }
        return false;
    }
}
