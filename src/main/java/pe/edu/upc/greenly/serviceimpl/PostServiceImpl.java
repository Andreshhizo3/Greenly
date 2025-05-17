package pe.edu.upc.greenly.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greenly.dtos.OngDTO;
import pe.edu.upc.greenly.dtos.PostDTO;
import pe.edu.upc.greenly.entities.Campaña;
import pe.edu.upc.greenly.entities.Ong;
import pe.edu.upc.greenly.entities.Post;
import pe.edu.upc.greenly.entities.Usuario;
import pe.edu.upc.greenly.dtos.PostDTO;
import pe.edu.upc.greenly.entities.Campaña;
import pe.edu.upc.greenly.entities.Post;
import pe.edu.upc.greenly.repositories.CampañaRepository;
import pe.edu.upc.greenly.repositories.PostRepository;
import pe.edu.upc.greenly.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CampañaRepository campañaRepository;

    /*@Override
    public void insert(Post post) {
        pR.save(post);
    }*/
    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Campaña campaña = campañaRepository.findById(postDTO.getCampañaId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + postDTO.getIdPosts()));

        Post post = new Post();
        post.setContenido(postDTO.getContenido());
        post.setImagen(postDTO.getImagen());
        post.setFechaPublicacion(postDTO.getFechaPublicacion());
        post.setCampaña(campaña);

        Post savedPost = postRepository.save(post);

        return new PostDTO(
                savedPost.getIdPosts(),
                savedPost.getContenido(),
                savedPost.getImagen(),
                savedPost.getFechaPublicacion(),
                savedPost.getCampaña().getId()
        );
    }

    @Override
    public List<PostDTO> listAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                //.filter(ong -> ong.getUsuario() != null)
                .map(post -> new PostDTO(

                        post.getIdPosts(),
                        post.getContenido(),
                        post.getImagen(),
                        post.getFechaPublicacion(),
                        post.getCampaña() != null ? post.getCampaña().getId(): null

                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null || post.getCampaña() == null) {
            return null;
        }

        return new PostDTO(
                post.getIdPosts(),
                post.getContenido(),
                post.getImagen(),
                post.getFechaPublicacion(),
                post.getCampaña().getId()
        );
    }

    /*@Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        // Buscar la ONG por ID
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrada con ID: " + id));

        // Si el DTO incluye un usuarioId, buscar el usuario relacionado
        Campaña campaña = null;
        if (postDTO.getCampañaId() != null) {
            campaña = campañaRepository.findById(postDTO.getCampañaId())
                    .orElseThrow(() -> new RuntimeException("Campaña no encontrado con ID: " + postDTO.getCampañaId()));
        }

        // Actualizar los campos de la entidad Post

        post.setContenido(postDTO.getContenido());
        post.setImagen(postDTO.getImagen());
        post.setFechaPublicacion(postDTO.getFechaPublicacion());
        post.setCampaña(campaña); // Puede ser null si se desea desvincular

        // Guardar los cambios
        Post updatedPost = postRepository.save(post);

        // Retornar el DTO actualizado
        return new PostDTO(
                updatedPost.getIdPosts(),
                updatedPost.getContenido(),
                updatedPost.getImagen(),
                updatedPost.getFechaPublicacion(),
                updatedPost.getCampaña() != null ? updatedPost.getCampaña().getId() : null
        );
    }*/

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        // Buscar el Post por ID
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrada con ID: " + id));
        // Actualizar solo si los valores no son null
        if (postDTO.getContenido() != null) {
            post.setContenido(postDTO.getContenido());
        }
        if (postDTO.getImagen() != null) {
            post.setImagen(postDTO.getImagen());
        }
        if (postDTO.getFechaPublicacion() != null) {
            post.setFechaPublicacion(postDTO.getFechaPublicacion());
        }
        // Si el DTO incluye un campañaId, buscar la campaña relacionada
        if (postDTO.getCampañaId() != null) {
            Campaña campaña = campañaRepository.findById(postDTO.getCampañaId())
                    .orElseThrow(() -> new RuntimeException("Campaña no encontrada con ID: " + postDTO.getCampañaId()));
            post.setCampaña(campaña);
        }
        // Guardar los cambios
        Post updatedPost = postRepository.save(post);
        // Retornar el DTO actualizado
        return new PostDTO(
                updatedPost.getIdPosts(),
                updatedPost.getContenido(),
                updatedPost.getImagen(),
                updatedPost.getFechaPublicacion(),
                updatedPost.getCampaña() != null ? updatedPost.getCampaña().getId() : null
        );
    }

}
