package com.example.JEEWeb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<Car>();

    CarRepository carRepository;
    @Autowired
    public CarRentalService(CarRepository carRepository){
        //System.out.println(carRepository);
        this.carRepository = carRepository;

//        carRepository.save(new Car("11AA22", "NIO", 110000));
//        carRepository.save(new Car("33BB44", "Tesla", 45222));
//        carRepository.save(new Car("32DD66", "Toyota", 4900));
//        carRepository.save(new Car("77SS88", "Peugeot", 12000));
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Car not found")  // 404
    @ExceptionHandler(Exception.class)
    public void erreur() {
        System.out.println("erreur page non trouve");
    }

    @GetMapping("/cars")
    public Iterable<Car> getListOfCars(){
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) throws Exception {
        carRepository.save(car);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCar(@PathVariable(value = "plateNumber") String immatriculation) throws Exception {
        System.out.println(immatriculation);
        // parcourir avec une boucle le tableau des voitures à la recherche de la voiture qui a la plaque immatriculation
        for(Car car: carRepository.findAll()){
            if(car.getPlateNumber().equals(immatriculation)){
                return car;
            }
        }
        throw new Exception();
    }

    /**
     *
     * @param {plateNumber}
     */

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable(value = "plateNumber") String immatriculation) throws Exception {

        System.out.println("the car immatriculated "+ immatriculation +" has been deleted");
        for(Car car: carRepository.findAll()){
            if(car.getPlateNumber().equals(immatriculation)){
                return;
            }
            throw new Exception();
        }
    }

//    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{
//    }
//    @RequestMapping(value = "/voiture/{plateNumber}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
//                   @RequestParam(value="rent", required = true)boolean rent) throws Exception{
//    }
//    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
//    public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent",
//            required = true)boolean rent, @RequestBody Dates dates){
//    }


}