package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.*;
import edu.ktu.ds.lab2.utils.Set;

import javax.swing.tree.TreeNode;
import java.util.*;

/*
 * Aibės testavimas be Gui
 * Dirbant su Intellij ir norint konsoleje matyti gražų pasuktą medį,
 * reikia File -> Settings -> Editor -> File Encodings -> Global encoding pakeisti į UTF-8
 *
 */
public class ManualTest {

    static Car[] cars;
    static ParsableSortedSet<Car> cSeries = new ParsableBstSet<>(Car::new, Car.byPrice);

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
        //executeTest();
        l2Tests();
    }

    public static void l2Tests() throws CloneNotSupportedException {
        Car c1 = new Car("Renault", "Laguna", 2007, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2011, 20000, 3500);
        Car c3 = new Car("Honda", "Civic", 2017, 30004, 850.3);
        Car c4 = new Car("Toyota", "Corolla", 2015, 150000, 2000);
        Car c5 = new Car("Mazda", "3", 2010, 75000, 3200);
        Car c6 = new Car("Renault", "Megane", 2005, 365100, 9500);
        Car c7 = new Car("Ford", "Focus", 2014, 60000, 11500);
        Car c8 = new Car("Chevrolet", "Malibu", 2016, 45000, 21000);
        Car c9 = new Car("Nissan", "Altima", 2018, 30000, 22000);
        Car c10 = new Car("Subaru", "Outback", 2015, 70000, 19500);
        Car c11 = new Car("Volkswagen", "Golf", 2013, 80000, 12000);
        Car c12 = new Car("Kia", "Optima", 2019, 25000, 23000);
        Car c13 = new Car("Hyundai", "Sonata", 2012, 90000, 13000);
        Car c14 = new Car("BMW", "3 Series", 2017, 35000, 28000);
        Car c15 = new Car("Mercedes-Benz", "C-Class", 2016, 40000, 32000);

        // Initialize main test set
        ParsableSortedSet<Car> carsSet = new ParsableBstSet<>(Car::new);
        carsSet.add(c1);
        carsSet.add(c2);
        carsSet.add(c3);
        carsSet.add(c4);

        Ks.oun("Initial Car Set:");
        Ks.oun(carsSet.toVisualizedString(""));

        // Test `remove` and `removeRecursive`
        Ks.oun("Testing remove(E element) and removeRecursive(E element, BstNode<E> node):");
        carsSet.remove(c2);
        Ks.oun("Removed car: " + c2);
        Ks.oun("Updated Car Set after removing: " + c2);
        Ks.oun(carsSet.toVisualizedString(""));

        // Test iterator remove
        Ks.oun("Testing iterator remove() method:");
        Iterator<Car> iterator = carsSet.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.equals(c3)) {
                iterator.remove();
                Ks.oun("Removed via iterator: " + car);
            }
        }
        Ks.oun("Updated Car Set after iterator remove:");
        Ks.oun(carsSet.toVisualizedString(""));

        // Test addAll(Set<E> set)
        ParsableSortedSet<Car> additionalCars = new ParsableBstSet<>(Car::new);
        additionalCars.add(c4); // Duplicate
        additionalCars.add(c5);
        additionalCars.add(c6);
        Ks.oun("Testing addAll(Set<E> set):");
        carsSet.addAll(additionalCars);
        Ks.oun("Added cars: " + additionalCars);
        Ks.oun("Updated Car Set after addAll:");
        Ks.oun(carsSet.toVisualizedString(""));

        // Test containsAll(Set<E> set)
        ParsableSortedSet<Car> checkCars = new ParsableBstSet<>(Car::new);
        checkCars.add(c1);
        checkCars.add(c4);
        checkCars.add(c6);
        Ks.oun("Testing containsAll(Set<E> set):");
        boolean allExist = carsSet.containsAll(checkCars);
        Ks.oun("Does the set contain all elements in " + checkCars + "? " + allExist);

        // Test retainAll(Set<E> set)
        ParsableSortedSet<Car> retainCars = new ParsableBstSet<>(Car::new);
        retainCars.add(c1);
        retainCars.add(c5);
        Ks.oun("Testing retainAll(Set<E> set):");
        carsSet.retainAll(retainCars);
        Ks.oun("Retained only cars: " + retainCars);
        Ks.oun("Updated Car Set after retainAll:");
        Ks.oun(carsSet.toVisualizedString(""));

        ParsableSortedSet<Car> allSetTests = new ParsableBstSet<>(Car::new);
        allSetTests.add(c5); // Mazda 3
        allSetTests.add(c1); // Renault Laguna
        allSetTests.add(c3); // Honda Civic
        allSetTests.add(c7); // Ford Focus
        allSetTests.add(c8); // Chevrolet Malibu
        allSetTests.add(c4); // Toyota Corolla
        allSetTests.add(c6); // Renault Megane (2005)
        allSetTests.add(c2); // Renault Megane (2011)
        allSetTests.add(c9); // Nissan Altima
        allSetTests.add(c10); // Subaru Outback
        allSetTests.add(c11); // Volkswagen Golf
        allSetTests.add(c12); // Kia Optima
        allSetTests.add(c13); // Hyundai Sonata
        allSetTests.add(c14); // BMW 3 Series
        allSetTests.add(c15); // Mercedes-Benz C-Class

        Ks.oun("Initial allSetTests:");
        Ks.oun(allSetTests.toVisualizedString(""));

        // Test headSet(E element)
        Ks.oun("Testing headSet(E element):");
        Set<Car> headSetCars = allSetTests.headSet(c5);
        Ks.oun("Head Set (up to " + c5 + "):");
        Ks.oun(headSetCars.toVisualizedString(""));

        // Test subSet(E element1, E element2);
        Ks.oun("Testing subSet(E element1, E element2):");
        Set<Car> subSetCars = allSetTests.subSet(c6, c10);
        Ks.oun("Sub Set (from " + c6 + " to " + c10 + "):");
        Ks.oun(subSetCars.toVisualizedString(""));

        // Test tailSet(E element)
        Ks.oun("Testing tailSet(E element):");
        Set<Car> tailSetCars = allSetTests.tailSet(c8);
        Ks.oun("Tail Set (from " + c8 + " onward):");
        Ks.oun(tailSetCars.toVisualizedString(""));


        // Test Avl tree remove(E element);
        Car[] carsArray = {c9, c7, c8, c5, c1, c6};
        Ks.oun("");
        Ks.oun("Automobilių aibė AVL-medyje:");
        ParsableSortedSet<Car> carsSetAvl = new ParsableAvlSet<>(Car::new);
        for (Car c : carsArray) {
            carsSetAvl.add(c);
        }
        Ks.ounn(carsSetAvl.toVisualizedString(""));

        Ks.oun("Testing Avl remove(E element):");
        carsSetAvl.remove(c5);
        Ks.oun("Removed car: " + c5);
        Ks.oun("Updated Car Set after removing: " + c5);
        Ks.oun(carsSetAvl.toVisualizedString(""));


        //Testing balanceCheck(int k);
        BstSet<Integer> balanceCheck = new BstSet<>();
        balanceCheck.add(10);
        balanceCheck.add(5);
        balanceCheck.add(15);
        balanceCheck.add(3);
        balanceCheck.add(4);
        balanceCheck.add(6);
        balanceCheck.add(20);
        balanceCheck.add(25);
        balanceCheck.add(30);
        Ks.oun("Initial balanceCheck Set:");
        Ks.oun(balanceCheck.toVisualizedString(""));
        int k = 2;
        boolean isBalanced = balanceCheck.isBalanced(k);
        Ks.oun("Is the tree balanced with k = " + k + "? " + isBalanced);
    }


    public static void executeTest() throws CloneNotSupportedException {
        Car c1 = new Car("Renault", "Laguna", 2007, 50000, 1700);
        Car c2 = new Car.Builder()
                .make("Renault")
                .model("Megane")
                .year(2011)
                .mileage(20000)
                .price(3500)
                .build();
        Car c3 = new Car.Builder().buildRandom();
        Car c4 = new Car("Renault Laguna 2011 115900 700");
        Car c5 = new Car("Renault Megane 2005 365100 9500");
        Car c6 = new Car("Honda   Civic  2011 300000 280.3");
        Car c7 = new Car("Renault Laguna 2011 115900 7500");
        Car c8 = new Car("Renault Megane 2006 365100 950");
        Car c9 = new Car("Honda   Civic  2017 30004 850.3");

        Car[] carsArray = {c9, c7, c8, c5, c1, c6};

        Ks.oun("Auto Aibė:");
        ParsableSortedSet<Car> carsSet = new ParsableBstSet<>(Car::new);

        for (Car c : carsArray) {
            carsSet.add(c);
            Ks.oun("Aibė papildoma: " + c + ". Jos dydis: " + carsSet.size());
        }
        Ks.oun("");
        Ks.oun(carsSet.toVisualizedString(""));

        ParsableSortedSet<Car> carsSetCopy = (ParsableSortedSet<Car>) carsSet.clone();

        carsSetCopy.add(c2);
        carsSetCopy.add(c3);
        carsSetCopy.add(c4);
        Ks.oun("Papildyta autoaibės kopija:");
        Ks.oun(carsSetCopy.toVisualizedString(""));

        c9.setMileage(10000);

        Ks.oun("Originalas:");
        Ks.ounn(carsSet.toVisualizedString(""));

        Ks.oun("Ar elementai egzistuoja aibėje?");
        for (Car c : carsArray) {
            Ks.oun(c + ": " + carsSet.contains(c));
        }
        Ks.oun(c2 + ": " + carsSet.contains(c2));
        Ks.oun(c3 + ": " + carsSet.contains(c3));
        Ks.oun(c4 + ": " + carsSet.contains(c4));
        Ks.oun("");

        Ks.oun("Ar elementai egzistuoja aibės kopijoje?");
        for (Car c : carsArray) {
            Ks.oun(c + ": " + carsSetCopy.contains(c));
        }
        Ks.oun(c2 + ": " + carsSetCopy.contains(c2));
        Ks.oun(c3 + ": " + carsSetCopy.contains(c3));
        Ks.oun(c4 + ": " + carsSetCopy.contains(c4));
        Ks.oun("");

        Ks.oun("Automobilių aibė su iteratoriumi:");
        Ks.oun("");
        for (Car c : carsSet) {
            Ks.oun(c);
        }
        Ks.oun("");
        Ks.oun("Automobilių aibė AVL-medyje:");
        ParsableSortedSet<Car> carsSetAvl = new ParsableAvlSet<>(Car::new);
        for (Car c : carsArray) {
            carsSetAvl.add(c);
        }
        Ks.ounn(carsSetAvl.toVisualizedString(""));

        Ks.oun("Automobilių aibė su iteratoriumi:");
        Ks.oun("");
        for (Car c : carsSetAvl) {
            Ks.oun(c);
        }

        Ks.oun("");
        Ks.oun("Automobilių aibė su atvirkštiniu iteratoriumi:");
        Ks.oun("");
        Iterator<Car> iter = carsSetAvl.descendingIterator();
        while (iter.hasNext()) {
            Ks.oun(iter.next());
        }

        Ks.oun("");
        Ks.oun("Automobilių aibės toString() metodas:");
        Ks.ounn(carsSetAvl);

        // Išvalome ir suformuojame aibes skaitydami iš failo
        carsSet.clear();
        carsSetAvl.clear();

        Ks.oun("");
        Ks.oun("Automobilių aibė DP-medyje:");
        carsSet.load("data\\ban.txt");
        Ks.ounn(carsSet.toVisualizedString(""));
        Ks.oun("Išsiaiškinkite, kodėl medis augo tik į vieną pusę.");

        Ks.oun("");
        Ks.oun("Automobilių aibė AVL-medyje:");
        carsSetAvl.load("data\\ban.txt");
        Ks.ounn(carsSetAvl.toVisualizedString(""));

        Set<String> carsSet4 = CarMarket.duplicateCarMakes(carsArray);
        Ks.oun("Pasikartojančios automobilių markės:\n" + carsSet4);

        Set<String> carsSet5 = CarMarket.uniqueCarModels(carsArray);
        Ks.oun("Unikalūs automobilių modeliai:\n" + carsSet5);
        Set<String> carsSet6 = CarMarket.uniqueCarModelsLambdaStyle(carsArray);
        Ks.oun("Unikalūs automobilių modeliai (lambda):\n" + carsSet6);
    }

    static ParsableSortedSet<Car> generateSet(int kiekis, int generN) {
        cars = new Car[generN];
        for (int i = 0; i < generN; i++) {
            cars[i] = new Car.Builder().buildRandom();
        }
        Collections.shuffle(Arrays.asList(cars));

        cSeries.clear();
        Arrays.stream(cars).limit(kiekis).forEach(cSeries::add);
        return cSeries;
    }
}
