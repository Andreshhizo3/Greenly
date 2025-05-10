package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.entities.CampañaFavorita;
import pe.edu.upc.greenly.repositories.CampañaFavoritaRepository;
import pe.edu.upc.greenly.service.CampañaFavoritaService;

import java.util.List;

@Service
public class CampañaFavoritaServiceImpl implements CampañaFavoritaService {

    @Autowired
    private CampañaFavoritaRepository cfR;

    @Override
    public void insert(CampañaFavorita campañaFavorita) {
        cfR.save(campañaFavorita);
    }

    @Override
    public List<CampañaFavorita> list() {
        return cfR.findAll();
    }

    @Override
    public void delete(Long id) {
        cfR.deleteById(id);
    }
}
