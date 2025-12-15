package com.vinyl_management.vinyl_management;

import com.vinyl_management.vinyl_management.controller.ConsoleController;
import com.vinyl_management.vinyl_management.dao.VinylDAO;
import com.vinyl_management.vinyl_management.service.VinylService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VinylManagementApplication {

    public static void main(String[] args) {

        VinylDAO dao = new VinylDAO();
        VinylService service = new VinylService(dao);
        ConsoleController controller = new ConsoleController(service);

        controller.start();
    }
}
