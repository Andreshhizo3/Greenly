package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.entities.CampañaFavorita;
import java.util.List;

public interface CampañaFavoritaService {
    public void insert(CampañaFavorita campañaFavorita);
    public List<CampañaFavorita> list();
    public void delete(Long id);
}
