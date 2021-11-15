package cn.zsp.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class App {

     public static void main(String[] args) {
         ServiceLoader<Car> serviceLoader = ServiceLoader.load(Car.class);
         Iterator<Car> iterator = serviceLoader.iterator();
         while(iterator.hasNext()) {
             Car car = iterator.next();
             car.goBeijing();
         }
     }
 }