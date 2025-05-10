package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.DonacionDTO;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.repositories.*;
import pe.edu.upc.greenly.service.DonacionService;

import java.util.List;

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

    @Override
    public void deleteDonacion(Long id) {
        Donacion donacionEncontrado = donacionRepository.findById(id).orElse(null);
        if (donacionEncontrado != null) {
            donacionRepository.delete(donacionEncontrado);
        }
    }

    @Override
    public Donacion findById(Long id) {
        return donacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Donacion> listAll() {
        return donacionRepository.findAll();
    }

    @Override
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
    }
}
