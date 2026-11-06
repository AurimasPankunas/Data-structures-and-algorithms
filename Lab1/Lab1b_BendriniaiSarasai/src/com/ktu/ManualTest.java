/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 23
 *
 * Tai yra demonstracinė automobilių sąrašo bandymų klasė, kuri skirta tiesiog
 * veiksmų su sąrašais išbandymui.
 *************************************************************************** */
package com.ktu;

import util.Ks;
import util.LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ManualTest {

    CarList cars = new CarList();

    void execute() {
        createCars();
        createCarList();
        countRenault();
        appendCarList();
        checkCarMarketFilters();
        checkCarMarketSorting();
    }

    void createCars() {
        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car();
        Car c5 = new Car();
        Car c6 = new Car();
        c4.parse("Renault Laguna 2001 115900 7500");
        c5.parse("Renault Megane 1995 365100 9500");
        c6.parse("Honda   Civic  2007  36400 8500,3");

        Ks.oun(c1);
        Ks.oun(c2);
        Ks.oun(c3);
        Ks.oun("Pirmų 3 auto ridos vidurkis= "
                + (c1.getMileage() + c2.getMileage() + c3.getMileage()) / 3);
        Ks.oun(c4);
        Ks.oun(c5);
        Ks.oun(c6);
        Ks.oun("Kitų 3 auto kainų suma= "
                + (c4.getPrice() + c5.getPrice() + c6.getPrice()));
    }

    void createCarList() {
        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.println("Pirmi 3 auto");
        cars.add("Renault Laguna 2001 115900 7500");
        cars.add("Renault Megane 1995 365100 9500");
        cars.add("Honda   Civic  2007  36400 8500,3");

        cars.println("Visi 6 auto");
        cars.forEach(System.out::println);
        Ks.oun("Pirmų 3 auto ridos vidurkis= "
                + (cars.get(0).getMileage() + cars.get(1).getMileage()
                + cars.get(2).getMileage()) / 3);

        Ks.oun("Kitų 3 auto kainų suma= "
                + (cars.get(3).getPrice() + cars.get(4).getPrice()
                + cars.get(5).getPrice()));
        // palaipsniui atidenkite sekančias eilutes ir išbandykite
        cars.add(0, new Car("Mazda","6",2007,50000,27000));
        cars.add(6, new Car("Hyundai","Lantra",1998,9500,777));
        cars.set(4, c3);
        cars.println("Po įterpimų");
        cars.remove(7);
        cars.remove(0);
        cars.println("Po išmetimų");
        cars.remove(0); cars.remove(0); cars.remove(0);
        cars.remove(0); cars.remove(0); cars.remove(0);
        cars.println("Po visų išmetimų");
        //cars.remove(0);
        //cars.println("Po visų išmetimų");
    }

    void countRenault() {
        int sk = 0;
        for (Car c : cars) {
            if (c.getMake().compareTo("Renault") == 0) {
                sk++;
            }
        }
        Ks.oun("Renault automobilių yra = " + sk);
    }

    void appendCarList() {
        for (int i = 0; i < 8; i++) {
            cars.add(new Car("Ford", "Focus",
                    2009 - i, 40000 + i * 10000, 36000 - i * 2000));
        }
        cars.add("Ford Mondeo  2009 37000 36000,0");
        cars.add("Fiat Bravo   2008 27000 32500,0");
        cars.add("Ford Fiesta  2009 37000 16000,0");
        cars.add("Audi A6      2006 87000 36000,0");
        cars.println("Testuojamų automobilių sąrašas");
        cars.save("ban.txt");
    }
    
    void checkCarMarketFilters() {
        CarMarket market = new CarMarket();

        market.allCars.load("ban.txt");
        market.allCars.println("Bandomasis rinkinys");

        cars = market.getNewerCars(2001);
        cars.println("Pradedant nuo 2001");

        cars = market.getByPrice(3000, 10000);
        cars.println("Kaina tarp 3000 ir 10000");

        cars = market.getHighestMileageCars();
        cars.println("Daugiausiai nuvažiavę");

        cars = market.getByMakeAndModel("F");
        cars.println("Turi būti tik Fiatai ir Fordai");

        cars = market.getByMakeAndModel("Ford M");

        cars.println("Turi būti tik Ford Mondeo");
        int n = 0;
        for (Car c : cars) {
            n++;    // testuojame ciklo veikimą
        }
        Ks.oun("Ford Mondeo kiekis = " + n);
    }

    void checkCarMarketSorting() {
        CarMarket market = new CarMarket();

        market.allCars.load("ban.txt");
        Ks.oun("========" + market.allCars.get(0));
        market.allCars.println("Bandomasis rinkinys");
        market.allCars.sortBuble(Car.byMakeAndModel);
        market.allCars.println("Rūšiavimas pagal Markę ir Modelį");
        market.allCars.sortBuble(Car.byPrice);
        market.allCars.println("Rūšiavimas pagal kainą");
        market.allCars.sortBuble(Car.byYearAndPrice);
        market.allCars.println("Rūšiavimas pagal Metus ir Kainą");
        market.allCars.sortBuble(byMileage);
        market.allCars.sortBuble(Comparator.comparingInt(Car::getMileage));
        market.allCars.println("Rūšiavimas pagal Ridą");
        market.allCars.sortBuble();
        market.allCars.println("Rūšiavimas pagal compareTo - Kainą");
    }

    static Comparator<Car> byMileage = (car1, car2) -> {
        int m1 = car1.getMileage();
        int m2 = car2.getMileage();
        // rida atvirkščia mažėjančia tvarka, pradedant nuo didžiausios
        if (m1 < m2) {
            return 1;
        }
        if (m1 > m2) {
            return -1;
        }
        return 0;
    };

    void stacktest() {
        Stack<Integer> stack = new LinkedListStack<Integer>();
        System.out.println("Steko testas:");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }

    void arraystacktest() {
        Stack<Integer> stack = new ArrayStack<Integer>();
        System.out.println("Array steko testas:");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }

    void arrayqueuetest() {
        Queue<Integer> queue = new ArrayQueue<>();
        System.out.println("Queue array testas:");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peak());
        queue.dequeue();
        System.out.println(queue.peak());
        queue.dequeue();
        System.out.println(queue.peak());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }

    void linkedlistqueuetest() {
        Queue<Integer> queue = new LinkedListQueue<>();
        System.out.println("Queue linkedlist testas:");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peak());
        queue.dequeue();
        System.out.println(queue.peak());
        queue.dequeue();
        System.out.println(queue.peak());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
    }

    public static boolean ld1_1(String input) {
        Stack<Character> stack = new LinkedListStack<>();
        System.out.println(input);
        for(char symbol : input.toCharArray()) {
            if(symbol == '{' || symbol == '[' || symbol == '(') {
                stack.push(symbol);
            } else if(symbol == '}' || symbol == ']' || symbol == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                char first = stack.pop();
                if((symbol == '}' && first != '{')
                        || (symbol == ']' && first != '[')
                        || (symbol == ')' && first != '(')) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String... args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        new ManualTest().execute();
        new ManualTest().stacktest();
        new ManualTest().arraystacktest();
        new ManualTest().arrayqueuetest();
        new ManualTest().linkedlistqueuetest();

        System.out.println("Ld1_1 uzduotis:");
        System.out.println(ld1_1("}"));
        System.out.println(ld1_1("{()}{[]}"));
        System.out.println(ld1_1("[{}}"));
        System.out.println(ld1_1("{()[{}]}{}"));
        System.out.println(ld1_1("{(})"));
        System.out.println(ld1_1("([(]{)})"));
        System.out.println(ld1_1(""));
        System.out.println(ld1_1("({[}])"));
        System.out.println(ld1_1("{{[[(())]]}}"));


        LinkedList<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.removeRange(0,5);
        for(int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
    }
}
