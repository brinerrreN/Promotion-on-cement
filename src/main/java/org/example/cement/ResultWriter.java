package org.example.cement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultWriter {
    public void write(String filePath, Map<String, Double> results) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<String, Double> entry : results.entrySet()) {
            String line = entry.getKey() + " - " + Math.round(entry.getValue());
            lines.add(line);
        }
        Files.write(Paths.get(filePath), lines);
    }
}
