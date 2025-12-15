package com.vinyl_management.vinyl_management.service;

import com.vinyl_management.vinyl_management.dao.VinylDAO;
import com.vinyl_management.vinyl_management.model.Vinyl;

import java.util.List;

public class VinylService {

    private final VinylDAO vinylDAO;

    public VinylService(VinylDAO vinylDAO) {
        this.vinylDAO = vinylDAO;
    }

    public void addVinyl(Vinyl vinyl) {
        vinylDAO.addVinyl(vinyl);
    }

    public List<Vinyl> getAll() {
        return vinylDAO.getAll();
    }

    public Vinyl getById(int id) {
        return vinylDAO.getById(id);
    }

    public void deleteById(int id) {
        vinylDAO.deleteById(id);
    }
}
