package org.example.cement;

import java.io.IOException;
import java.util.List;

public interface OrderReader {
    List<Order> read(String filePath) throws IOException;
}
