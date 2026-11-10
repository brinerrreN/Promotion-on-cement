package org.example.cement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HashOrderReader implements OrderReader {
    @Override
    public List<Order> read(String filePath) throws IOException {
        List<Order> orders = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            if (line.isBlank()) continue;
            String[] parts = line.split("#");
            LocalDateTime time = LocalDateTime.parse(parts[0]);
            String company = parts[1];
            double quantity = Double.parseDouble(parts[2]);
            orders.add(new Order(time, company, quantity));
        }
        return orders;
    }
}
