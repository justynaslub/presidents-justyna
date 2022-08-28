package com.presidents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresidentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresidentsApplication.class, args);
    }

//    Napisać aplikację, która wystawi API będące katalogiem prezydentów USA
//1. Aplikacja ma na starcie swojego działania przechowywać obiekt reprezentujący pierwszego prezydenta USA
//2. Musi istnieć możliwość pobrania listy wszystkich prezydentów przechowywanych w aplikacji
//3. Musi istnieć możliwość dodania nowego prezydenta do statycznej listy prezydentów
//4. Musi istnieć możliwość edytowania obiektu reprezentującego prezydenta metodą PUT
//5.  Musi istnieć możliwość częściowego edytowania obiektu reprezentującego prezydenta metodą PATCH
//6. Musi istnieć możliwość usunięcia dowolnego obiektu reprezentującego prezydenta po indeksie w statycznej liście
}
