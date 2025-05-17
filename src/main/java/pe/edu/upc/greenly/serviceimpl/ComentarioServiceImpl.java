package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.CampañaDTO;
import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.dtos.ComentarioCampañaDTO;
import pe.edu.upc.greenly.dtos.ComentarioDTO;
import pe.edu.upc.greenly.entities.Comentario;
import pe.edu.upc.greenly.entities.Donante;
import pe.edu.upc.greenly.entities.Post;
import pe.edu.upc.greenly.repositories.ComentarioRepository;
import pe.edu.upc.greenly.repositories.DonanteRepository;
import pe.edu.upc.greenly.repositories.PostRepository;
import pe.edu.upc.greenly.service.ComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository cR;
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DonanteRepository donanteRepository;

    @Override
    public void insert(Comentario comentario) {
        cR.save(comentario);
    }

    @Override
    public ComentarioDTO addComentario(ComentarioDTO dto) {
        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrada con ID: " + dto.getPostId()));

        Donante donante = donanteRepository.findById(dto.getDonanteId())
                .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + dto.getDonanteId()));


        Comentario comentario = new Comentario();
        comentario.setContenido(dto.getContenido());
        comentario.setFechaComentario(dto.getFechaComentario());
        comentario.setPost(post);
        comentario.setDonante(donante);

        Comentario saved = comentarioRepository.save(comentario);


        return new ComentarioDTO(
                saved.getIdComentario(),
                saved.getContenido(),
                saved.getFechaComentario(),
                saved.getPost().getIdPosts(),
                saved.getDonante().getId()
        );
    }

    /*@Override
    public List<Comentario> list() {
        return cR.findAll();
    }*/

    @Override
    public List<ComentarioDTO> listAll() {
        return comentarioRepository.findAll().stream()
                .map(c -> new ComentarioDTO(
                        c.getIdComentario(),
                        c.getContenido(),
                        c.getFechaComentario(),
                        //c.getPost().getIdPosts(),
                        //c.getDonante().getId()
                        c.getPost() != null ? c.getPost().getIdPosts() : null,
                        c.getDonante() != null ? c.getDonante().getId() : null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        cR.deleteById(id);
    }

    @Override
    public ComentarioDTO findById(Long id) {
        return comentarioRepository.findById(id)
                .map(c -> new ComentarioDTO(

                        c.getIdComentario(),
                        c.getContenido(),
                        c.getFechaComentario(),
                        //c.getPost().getIdPosts(),
                        //c.getDonante().getId()
                        c.getPost() != null ? c.getPost().getIdPosts() : null,
                        c.getDonante() != null ? c.getDonante().getId() : null
                ))
                .orElse(null);
    }

    /*@Override
    public ComentarioDTO updateComentario(Long id, ComentarioDTO dto) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrada con ID: " + id));

        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrada con ID: " + dto.getPostId()));

        Donante donante = donanteRepository.findById(dto.getDonanteId())
                .orElseThrow(() -> new RuntimeException("Donante no encontrada con ID: " + dto.getDonanteId()));


        //comentario.setContenido((dto.getContenido() != null) ? dto.getContenido() : null);
        comentario.setContenido(dto.getContenido());
        comentario.setFechaComentario(dto.getFechaComentario());
        comentario.setPost(post);
        comentario.setDonante(donante);

        Comentario updated = comentarioRepository.save(comentario);

        return new ComentarioDTO(
                updated.getIdComentario(),
                updated.getContenido(),
                updated.getFechaComentario(),
                updated.getPost().getIdPosts(),
                updated.getDonante().getId()
        );
    }*/

    @Override
    public ComentarioDTO updateComentario(Long id, ComentarioDTO dto) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con ID: " + id));

        // Actualiza el contenido si no es null
        if (dto.getContenido() != null) {
            comentario.setContenido(dto.getContenido());
        }

        // Actualiza la fecha si no es null
        if (dto.getFechaComentario() != null) {
            comentario.setFechaComentario(dto.getFechaComentario());
        }

        // Solo actualiza el post si se envió un postId no nulo
        if (dto.getPostId() != null) {
            Post post = postRepository.findById(dto.getPostId())
                    .orElseThrow(() -> new RuntimeException("Post no encontrado con ID: " + dto.getPostId()));
            comentario.setPost(post);
        }

        // Solo actualiza el donante si se envió un donanteId no nulo
        if (dto.getDonanteId() != null) {
            Donante donante = donanteRepository.findById(dto.getDonanteId())
                    .orElseThrow(() -> new RuntimeException("Donante no encontrado con ID: " + dto.getDonanteId()));
            comentario.setDonante(donante);
        }

        Comentario updated = comentarioRepository.save(comentario);

        return new ComentarioDTO(
                updated.getIdComentario(),
                updated.getContenido(),
                updated.getFechaComentario(),
                updated.getPost() != null ? updated.getPost().getIdPosts() : null,
                updated.getDonante() != null ? updated.getDonante().getId() : null
        );
    }


    //4. JPQL  TODOS LOS COMENTARIOS POR CAMPAÑA

    public List<ComentarioCampañaDTO> obtenerComentariosPorCampaña(Long campañaId) {
        return comentarioRepository.findComentariosPorCampaña(campañaId);
    }

}
