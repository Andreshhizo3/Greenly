package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.entities.Campaña;
import pe.edu.upc.greenly.entities.Ong;
import pe.edu.upc.greenly.entities.Ubicacion_Campaña;
import pe.edu.upc.greenly.repositories.CampañaRepository;
import pe.edu.upc.greenly.repositories.OngRepository;
import pe.edu.upc.greenly.repositories.Ubicacion_CampañaRepository;
import pe.edu.upc.greenly.service.CampañaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampañaServiceImpl implements CampañaService {
    @Autowired
    private CampañaRepository campañaRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private Ubicacion_CampañaRepository ubicacionCampañaRepository;

    @Override
    public CampañaDTO addCampaña(CampañaDTO dto) {
        Ong ong = ongRepository.findById(dto.getOngId())
                .orElseThrow(() -> new RuntimeException("ONG no encontrada con ID: " + dto.getOngId()));

        Ubicacion_Campaña ubicacion = ubicacionCampañaRepository.findById(dto.getUbicacion_CampañaId())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con ID: " + dto.getUbicacion_CampañaId()));

        Campaña campaña = new Campaña();
        campaña.setTitulo(dto.getTitulo());
        campaña.setDescripcion(dto.getDescripcion());
        campaña.setFechaInicio(dto.getFechaInicio());
        campaña.setFechaFin(dto.getFechaFin());
        campaña.setOng(ong);
        campaña.setUbicacion_Campaña(ubicacion);

        Campaña saved = campañaRepository.save(campaña);

        return new CampañaDTO(
                saved.getId(),
                saved.getTitulo(),
                saved.getDescripcion(),
                saved.getFechaInicio(),
                saved.getFechaFin(),
                saved.getOng().getId(),
                saved.getUbicacion_Campaña().getId()
        );
    }

    @Override
    public void deleteCampaña(Long id) {
        campañaRepository.deleteById(id);
    }

    @Override
    public CampañaDTO findById(Long id) {
        return campañaRepository.findById(id)
                .map(c -> new CampañaDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getDescripcion(),
                        c.getFechaInicio(),
                        c.getFechaFin(),
                        c.getOng().getId(),
                        c.getUbicacion_Campaña().getId()
                ))
                .orElse(null);
    }

    @Override
    public List<CampañaDTO> listAll() {
        return campañaRepository.findAll().stream()
                .map(c -> new CampañaDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getDescripcion(),
                        c.getFechaInicio(),
                        c.getFechaFin(),
                        c.getOng().getId(),
                        c.getUbicacion_Campaña().getId()
                ))
                .collect(Collectors.toList());
    }

   /* @Override
    public CampañaDTO updateCampaña(Long id, CampañaDTO dto) {
        Campaña campañaExistente = campañaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + id));

        Ong ong = ongRepository.findById(dto.getOngId())
                .orElseThrow(() -> new RuntimeException("ONG no encontrada con ID: " + dto.getOngId()));

        Ubicacion_Campaña ubicacion = ubicacionCampañaRepository.findById(dto.getUbicacion_CampañaId())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con ID: " + dto.getUbicacion_CampañaId()));

        campañaExistente.setTitulo(dto.getTitulo());
        campañaExistente.setDescripcion(dto.getDescripcion());
        campañaExistente.setFechaInicio(dto.getFechaInicio());
        campañaExistente.setFechaFin(dto.getFechaFin());
        campañaExistente.setOng(ong);
        campañaExistente.setUbicacion_Campaña(ubicacion);

        Campaña updated = campañaRepository.save(campañaExistente);

        return new CampañaDTO(
                updated.getId(),
                updated.getTitulo(),
                updated.getDescripcion(),
                updated.getFechaInicio(),
                updated.getFechaFin(),
                updated.getOng().getId(),
                updated.getUbicacion_Campaña().getId()
        );
    }*/
   @Override
   public CampañaDTO updateCampaña(Long id, CampañaDTO dto) {
       Campaña campañaExistente = campañaRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + id));

       // Actualizar título si no es null
       if (dto.getTitulo() != null) {
           campañaExistente.setTitulo(dto.getTitulo());
       }

       // Actualizar descripción si no es null
       if (dto.getDescripcion() != null) {
           campañaExistente.setDescripcion(dto.getDescripcion());
       }

       // Actualizar fecha de inicio si no es null
       if (dto.getFechaInicio() != null) {
           campañaExistente.setFechaInicio(dto.getFechaInicio());
       }

       // Actualizar fecha de fin si no es null
       if (dto.getFechaFin() != null) {
           campañaExistente.setFechaFin(dto.getFechaFin());
       }

       // Actualizar ONG si ongId no es null
       if (dto.getOngId() != null) {
           Ong ong = ongRepository.findById(dto.getOngId())
                   .orElseThrow(() -> new RuntimeException("ONG no encontrada con ID: " + dto.getOngId()));
           campañaExistente.setOng(ong);
       }

       // Actualizar ubicación si ubicacionCampañaId no es null
       if (dto.getUbicacion_CampañaId() != null) {
           Ubicacion_Campaña ubicacion = ubicacionCampañaRepository.findById(dto.getUbicacion_CampañaId())
                   .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con ID: " + dto.getUbicacion_CampañaId()));
           campañaExistente.setUbicacion_Campaña(ubicacion);
       }

       Campaña updated = campañaRepository.save(campañaExistente);

       return new CampañaDTO(
               updated.getId(),
               updated.getTitulo(),
               updated.getDescripcion(),
               updated.getFechaInicio(),
               updated.getFechaFin(),
               updated.getOng() != null ? updated.getOng().getId() : null,
               updated.getUbicacion_Campaña() != null ? updated.getUbicacion_Campaña().getId() : null
       );
   }

    //Query Method Obtener campañas por Ong ingresado RONALD
    @jakarta.transaction.Transactional
    @Override
    public List<CampañaDTO> obtenerCampañasPorOng(Long ongId) {
        List<Campaña> campañas = campañaRepository.findByOngId(ongId);
        return campañas.stream()
                .map(c -> new CampañaDTO(c.getId(), c.getTitulo(), c.getDescripcion(), c.getFechaInicio(), c.getFechaFin(), c.getOng().getId(), c.getUbicacion_Campaña().getId()))
                .collect(Collectors.toList());
    }
   @Override
   @Transactional(readOnly = true)
   public List<Campaña> obtenerCampañasPorDescripcionYFechaInicio(String texto, LocalDate fechaInicio) {
       return campañaRepository.findByDescripcionContainingIgnoreCaseAndFechaInicioAfter(texto, fechaInicio);
   }


    @Override
    @Transactional(readOnly = true)
    public List<Campaña> obtenerCampañasPorTituloODescripcion(String texto) {
        return campañaRepository.findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCase(texto, texto);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Campaña> obtenerCampañasPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return campañaRepository.obtenerCampañasPorRangoFechas(fechaInicio, fechaFin);
    }




}
