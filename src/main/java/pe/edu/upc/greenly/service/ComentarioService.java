package pe.edu.upc.greenly.service;

import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.entities.Comentario;
import java.util.List;

public interface ComentarioService {
    public void insert(Comentario comentario);
    //public List<Comentario> list();
    public void delete(Long id);
    ComentarioDTO addComentario(ComentarioDTO dto);
    List<ComentarioDTO> listAll();
    ComentarioDTO findById(Long id);
    ComentarioDTO updateComentario(Long id, ComentarioDTO dto);
}
