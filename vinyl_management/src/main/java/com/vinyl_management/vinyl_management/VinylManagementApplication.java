package com.vinyl_management.vinyl_management;

import com.vinyl_management.vinyl_management.dao.VinylDAO;
import com.vinyl_management.vinyl_management.model.Vinyl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VinylManagementApplication {

    public static void main(String[] args) {

        VinylDAO dao = new VinylDAO();

        Vinyl v = new Vinyl(0, "Thriller", "Michael Jackson",
                "Pop", 1982, "VG+", 25.99);

        dao.addVinyl(v);

        System.out.println("All vinyls in DB:");
        dao.getAll().forEach(System.out::println);
    }
}
