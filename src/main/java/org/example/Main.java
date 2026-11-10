package org.example;

import org.example.cement.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        double basePrice = 10.0;
        double startDiscount = 0.50;
        double stepDiscount = 0.05;

        OrderReader reader = new TxtOrderReader();
        List<Order> orders = reader.read("orders.txt");

        orders.sort(null);

        DiscountCalculator calculator = new DiscountCalculator(basePrice, startDiscount, stepDiscount);
        Map<String, Double> results = calculator.calculate(orders);

        ResultWriter writer = new ResultWriter();
        writer.write("result.txt", results);

        System.out.println("Готово! Результат в result.txt");
    }
    }