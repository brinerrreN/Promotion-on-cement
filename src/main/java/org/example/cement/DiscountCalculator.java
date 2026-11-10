package org.example.cement;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiscountCalculator {
    private final double basePrice;
    private final double startDiscount;
    private final double stepDiscount;

    public DiscountCalculator(double basePrice, double startDiscount, double stepDiscount) {
        this.basePrice = basePrice;
        this.startDiscount = startDiscount;
        this.stepDiscount = stepDiscount;
    }

    public Map<String,Double> calculate(List<Order> sortedOrders) {
        Map<String,Double> result = new TreeMap<>();

        double currentDiscount = startDiscount;

    for(Order order : sortedOrders) {
        double price = order.getQuantity() * basePrice * (1 - currentDiscount);
        result.merge(order.getCompany(), price, Double::sum);
        currentDiscount = Math.max(0, currentDiscount - stepDiscount);
        }
    return result;
    }
    }

