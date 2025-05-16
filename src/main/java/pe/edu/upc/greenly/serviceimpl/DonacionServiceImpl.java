package pe.edu.upc.greenly.serviceimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.DonacionDTO;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.repositories.*;
import pe.edu.upc.greenly.service.DonacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service


public class DonacionServiceImpl implements DonacionService {

    @Autowired
    DonacionRepository donacionRepository;

    @Autowired
    DonanteRepository donanteRepository;

    @Autowired
    CampañaRepository campañaRepository;

    @Autowired
    TipoDonacionRepository tipoDonacionRepository;

    @Autowired
    EstadoDonacionRepository estadoDonacionRepository;

    @Override
    public DonacionDTO addDonacionDTO(DonacionDTO donacionDTO) {
        if (donacionDTO.getName() == null || donacionDTO.getName().isEmpty()) {
            return null; // mensaje de error: "El nombre de la donación no puede estar vacio"
        }

        if (donacionDTO.getDescripcion() == null || donacionDTO.getDescripcion().isEmpty()) {
            return null; // mensaje de error: "La descripción de la donación no puede estar vacio"
        }

        if (donacionDTO.getMontoDonado() < 0.0) {
            return null; // mensaje de error: "El monto donado de la donación no puede ser menor a 0"
        }

        if (donacionDTO.getMetodoEntrega() == null || donacionDTO.getMetodoEntrega().isEmpty()) {
            return null;
        }
        Donante donante = donanteRepository.findById(donacionDTO.getIdDonante())
                .orElseThrow(() -> new RuntimeException("Donante no encontrado"));

        Campaña campaña = campañaRepository.findById(donacionDTO.getIdCampaña())
                .orElseThrow(() -> new RuntimeException("Campaña no encontrada"));

        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(donacionDTO.getIdTipoDonacion())
                .orElseThrow(() -> new RuntimeException("Tipo de donación no encontrado"));

        EstadoDonacion estadoDonacion = estadoDonacionRepository.findById(donacionDTO.getIdEstadoDonacion())
                .orElseThrow(() -> new RuntimeException("Estado de donación no encontrado"));

        /*
        Donante donante = donanteRepository.findById(donacionDTO.getIdDonante());
        Campaña campaña = campañaRepository.findById(donacionDTO.getIdCampaña());
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(donacionDTO.getIdTipoDonacion());
        EstadoDonacion estadoDonacion = estadoDonacionRepository.findById(donacionDTO.getIdEstadoDonacion());
        */

        //Donacion donacion = new Donacion(0L, donacionDTO.getName(), donacionDTO.getDescripcion(), donacionDTO.getMontoDonado(), donacionDTO.getMetodoEntrega(), donacionDTO.getFechaDonacion(), null, null, null, null);
        Donacion donacion = new Donacion();
        donacion.setName(donacionDTO.getName());
        donacion.setDescripcion(donacionDTO.getDescripcion());
        donacion.setMontoDonado(donacionDTO.getMontoDonado());
        donacion.setMetodoEntrega(donacionDTO.getMetodoEntrega());
        donacion.setFechaDonacion(donacionDTO.getFechaDonacion());
        //return null;
        donacion.setDonante(donante);
        donacion.setCampaña(campaña);
        donacion.setTipoDonacion(tipoDonacion);
        donacion.setEstadoDonacion(estadoDonacion);
        Donacion savedDonacion = donacionRepository.save(donacion);
        System.out.println("ID generado: " + savedDonacion.getId());
        if(savedDonacion.getId()==null){
            System.out.println("No se puede agregar la donacion");
        }
        else {
            System.out.println("se puede agregar la donacion");
        }
        return new DonacionDTO(
                savedDonacion.getId(),
                savedDonacion.getName(),
                savedDonacion.getDescripcion(),
                savedDonacion.getMontoDonado(),
                savedDonacion.getMetodoEntrega(),
                savedDonacion.getFechaDonacion(),
                savedDonacion.getDonante().getId(),
                savedDonacion.getCampaña().getId(),
                savedDonacion.getTipoDonacion().getId(),
                savedDonacion.getEstadoDonacion().getId()

        );
    }

    /*@Override
    public void deleteDonacion(Long id) {
        Donacion donacionEncontrado = donacionRepository.findById(id).orElse(null);
        if (donacionEncontrado != null) {
            donacionRepository.delete(donacionEncontrado);
        }
    }*/

    @Override
    public void deleteDonacion(Long id) {
        donacionRepository.deleteById(id);
        /*try {
            donacionRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar donación con ID " + id);
            e.printStackTrace();
        }*/
    }
    /*@Override
    public void deleteDonacion(Long id) {
        Optional<Donacion> donacion = donacionRepository.findById(id);
        if (donacion.isPresent()) {
            donacionRepository.delete(donacion.get());
            entityManager.flush(); // 👈 fuerza la sincronización con la BD
            System.out.println(">>> Eliminado y flush ejecutado");
        } else {
            System.out.println(">>> No se encontró la donación");
        }
    }*/

    /*@Override
    public DonacionDTO findById(Long id) {
        return donacionRepository.findById(id).orElse(null);
    }*/

    @Override
    public DonacionDTO findById(Long id) {
        return donacionRepository.findById(id)
                .map(c -> new DonacionDTO(
                        c.getId(),
                        c.getName(),
                        c.getDescripcion(),
                        c.getMontoDonado(),
                        c.getMetodoEntrega(),
                        c.getFechaDonacion(),
                        c.getDonante().getId(),
                        c.getCampaña().getId(),
                        c.getTipoDonacion().getId(),
                        c.getEstadoDonacion().getId()
                ))
                .orElse(null);
    }

    @Override
    public List<DonacionDTO> listAll() {
        return donacionRepository.findAll().stream()
                .map(c -> new DonacionDTO(
                        c.getId(),
                        c.getName(),
                        c.getDescripcion(),
                        c.getMontoDonado(),
                        c.getMetodoEntrega(),
                        c.getFechaDonacion(),
                        c.getDonante().getId(),
                        c.getCampaña().getId(),
                        c.getTipoDonacion().getId(),
                        c.getEstadoDonacion().getId()
                ))
                .collect(Collectors.toList());
    }

    /*@Override
    public List<Donacion> listAll() {
        return donacionRepository.findAll();
    }*/

    /*@Override
    public Donacion editDonacion(Donacion donacion) {
        Donacion donacionEncontrado = findById(donacion.getId());

        if (donacion.getName() != null || !donacion.getName().isEmpty()) {
            donacionEncontrado.setName(donacion.getName());
        }
        if (donacion.getDescripcion() != null || !donacion.getDescripcion().isEmpty()) {
            donacionEncontrado.setDescripcion(donacion.getDescripcion());
        }
        if (donacion.getMontoDonado() != null) {
            donacionEncontrado.setMontoDonado(donacion.getMontoDonado());
        }
        if (donacion.getMetodoEntrega() != null || !donacion.getMetodoEntrega().isEmpty()) {
            donacionEncontrado.setMetodoEntrega(donacion.getMetodoEntrega());
        }
        if (donacion.getFechaDonacion() != null) {
            donacionEncontrado.setFechaDonacion(donacion.getFechaDonacion());
        }

        return donacionRepository.save(donacionEncontrado);
    }*/

    @Override
    public DonacionDTO updateDonacion(Long id, DonacionDTO dto) {
        Donacion donacionExistente = donacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donacion no encontrada con ID: " + id));

        // Actualizar nombre si no es null
        if (dto.getName() != null) {
            donacionExistente.setName(dto.getName());
        }

        // Actualizar descripción si no es null
        if (dto.getDescripcion() != null) {
            donacionExistente.setDescripcion(dto.getDescripcion());
        }

        // Actualizar MontoDonado si no es null
        if (dto.getMontoDonado() != null) {
            donacionExistente.setMontoDonado(dto.getMontoDonado());
        }

        // Actualizar MetodoEntraga si no es null
        if (dto.getMetodoEntrega() != null) {
            donacionExistente.setMetodoEntrega(dto.getMetodoEntrega());
        }

        // Actualizar FechaDonacion si no es null
        if (dto.getFechaDonacion() != null) {
            donacionExistente.setFechaDonacion(dto.getFechaDonacion());
        }

        // Actualizar Donante si ongId no es null
        if (dto.getIdDonante() != null) {
            Donante donante = donanteRepository.findById(dto.getIdDonante())
                    .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + dto.getIdDonante()));
            donacionExistente.setDonante(donante);
        }

        // Actualizar Campaña si CampañaId no es null
        if (dto.getIdCampaña() != null) {
            Campaña campaña = campañaRepository.findById(dto.getIdCampaña())
                    .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + dto.getIdCampaña()));
            donacionExistente.setCampaña(campaña);
        }

        // Actualizar TipoDonacion si TipoDonacionId no es null
        if (dto.getIdTipoDonacion() != null) {
            TipoDonacion tipoDonacion = tipoDonacionRepository.findById(dto.getIdTipoDonacion())
                    .orElseThrow(() -> new RuntimeException("TipoDonacion no encontrada con ID: " + dto.getIdTipoDonacion()));
            donacionExistente.setTipoDonacion(tipoDonacion);
        }

        // Actualizar EstadoDonacion si EstadoDonacionId no es null
        if (dto.getIdEstadoDonacion() != null) {
            EstadoDonacion estadoDonacion = estadoDonacionRepository.findById(dto.getIdEstadoDonacion())
                    .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + dto.getIdEstadoDonacion()));
            donacionExistente.setEstadoDonacion(estadoDonacion);
        }

        Donacion updated = donacionRepository.save(donacionExistente);

        return new DonacionDTO(
                updated.getId(),
                updated.getName(),
                updated.getDescripcion(),
                updated.getMontoDonado(),
                updated.getMetodoEntrega(),
                updated.getFechaDonacion(),
                updated.getDonante() != null ? updated.getDonante().getId() : null,
                updated.getCampaña() != null ? updated.getCampaña().getId() : null,
                updated.getTipoDonacion() != null ? updated.getTipoDonacion().getId() : null,
                updated.getEstadoDonacion() != null ? updated.getEstadoDonacion().getId() : null
        );
    }

    @Override
    public List<DonacionDTO> obtenerDonacionesMasAntiguas() {
        return donacionRepository.donacionesMasAntiguas();
    }

    @Override
    public List<DonacionDTO> obtenerDonacionesRecientes() {
        return donacionRepository.donacionesRecientes();
    }
}
