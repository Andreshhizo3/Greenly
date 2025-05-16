package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.CampañaFavoritaDTO;
import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.repositories.CampañaFavoritaRepository;
import pe.edu.upc.greenly.repositories.CampañaRepository;
import pe.edu.upc.greenly.repositories.DonanteRepository;
import pe.edu.upc.greenly.service.CampañaFavoritaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampañaFavoritaServiceImpl implements CampañaFavoritaService {

    @Autowired
    private CampañaFavoritaRepository cfR;
    @Autowired
    private CampañaFavoritaRepository campañaFavoritaRepository;
    @Autowired
    CampañaRepository campañaRepository;
    @Autowired
    DonanteRepository donanteRepository;

   /* @Override
    public void insert(CampañaFavorita campañaFavorita) {
        cfR.save(campañaFavorita);
    }*/

    @Override
    public CampañaFavoritaDTO addCampañaFavorito(CampañaFavoritaDTO dto) {
        Campaña campaña = campañaRepository.findById(dto.getCampañaId())
                .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + dto.getCampañaId()));

        Donante donante = donanteRepository.findById(dto.getDonanteId())
                .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + dto.getDonanteId()));


        CampañaFavorita campañaFavorita = new CampañaFavorita();

        campañaFavorita.setCampaña(campaña);
        campañaFavorita.setDonante(donante);

        CampañaFavorita saved = campañaFavoritaRepository.save(campañaFavorita);


        return new CampañaFavoritaDTO(

                saved.getIdCampañaFav(),
                saved.getCampaña().getId(),
                saved.getDonante().getId()
        );
    }


    @Override
    public CampañaFavoritaDTO findById(Long id) {
        CampañaFavorita campañaFavorita = campañaFavoritaRepository.findById(id).orElse(null);
        //if (ong == null || ong.getUsuario() == null) {
        if (campañaFavorita == null) {
            return null;
        }

        return new CampañaFavoritaDTO(
                //campañaFavorita.getCampaña().getId()
                campañaFavorita.getIdCampañaFav(),
                campañaFavorita.getCampaña() !=null ? campañaFavorita.getCampaña().getId() : null,
                campañaFavorita.getDonante() !=null ? campañaFavorita.getDonante().getId() : null
        );
    }

    /*@Override
    public List<CampañaFavorita> list() {
        return cfR.findAll();
    }*/

    @Override
    public List<CampañaFavoritaDTO> listAll() {
        return campañaFavoritaRepository.findAll().stream()
                .map(c -> new CampañaFavoritaDTO(
                        c.getIdCampañaFav(),
                        //c.getCampaña().getId(),
                        //c.getDonante().getId()
                        c.getCampaña() != null ? c.getCampaña().getId() : null,
                        c.getDonante() != null ? c.getDonante().getId() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        cfR.deleteById(id);
    }

    @Override
    public CampañaFavoritaDTO updateCampañaFavorita(Long id, CampañaFavoritaDTO dto) {
        CampañaFavorita campañaFavoritaExistente = campañaFavoritaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CampañaFavorita no encontrada con ID: " + id));

        // Actualizar Campaña si CamapañaId no es null
        if (dto.getCampañaId() != null) {
            Campaña campaña = campañaRepository.findById(dto.getCampañaId())
                    .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + dto.getCampañaId()));
            campañaFavoritaExistente.setCampaña(campaña);
        }

        // Actualizar Donante si DonanteId no es null
        if (dto.getDonanteId() != null) {
            Donante donante = donanteRepository.findById(dto.getDonanteId())
                    .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + dto.getDonanteId()));
            campañaFavoritaExistente.setDonante(donante);
        }

        CampañaFavorita updated = campañaFavoritaRepository.save(campañaFavoritaExistente);

        return new CampañaFavoritaDTO(
                updated.getIdCampañaFav(),
                updated.getCampaña() != null ? updated.getCampaña().getId() : null,
                updated.getDonante() != null ? updated.getDonante().getId() : null
        );
    }

}
