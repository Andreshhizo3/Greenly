package pe.edu.upc.greenly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.edu.upc.greenly.controllers.TipoDonacionController;
import pe.edu.upc.greenly.entities.*;
import pe.edu.upc.greenly.repositories.*;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class GreenlyApplication {

    public static void main(String[] args) {SpringApplication.run(GreenlyApplication.class, args);}
    @Bean
    public CommandLineRunner startConfiguration(
        OngRepository ongRespository,
        UsuarioRepository usuarioRepository,
        Ubicacion_CampañaRepository ubicacionCampañaRepository,
        CampañaRepository campañaRepository,
        PostRepository postRepository,
        DonanteRepository donanteRepository,
        ComentarioRepository comentarioRepository,
        CampañaFavoritaRepository campaFavoritaRepository,
        TipoDonacionRepository tipoDonacionRepository,
        EstadoDonacionRepository estadoDonacionRepository,
        DonacionRepository donacionRepository,

        CampañaFavoritaRepository campañaFavoritaRepository){
        return args->{
            Usuario usuario1 = new Usuario(null,"Juan Valdez","1234",null,null);
            usuario1 = usuarioRepository.save(usuario1);
            Ong ong1 = new Ong(null, "ONG Lima", "Primera Ong", "onglima@gmail.com", "Av.Primavera 1234", "995183885",null );
            ong1 = ongRespository.save(ong1);
            Ong ong2 = new Ong(null, "ONG Cusco", "Segunda Ong", "ongcusco@gmail.com", "Av.Zarate 1234", "995283885",null );
            ong2 = ongRespository.save(ong2);
            //Ubi Campañas
            Ubicacion_Campaña ubicacion_campaña1 = new Ubicacion_Campaña(null,"Lima","Miraflores","Av. Pradera 2345",null);
            ubicacion_campaña1 = ubicacionCampañaRepository.save(ubicacion_campaña1);
            Ubicacion_Campaña ubicacion_campaña2 = new Ubicacion_Campaña(null,"Lima","Surco","Av. Marcapaso 4533",null);
            ubicacion_campaña2 = ubicacionCampañaRepository.save(ubicacion_campaña2);
            Ubicacion_Campaña ubicacion_campaña3 = new Ubicacion_Campaña(null,"Lima","San Borja","Av. Angamos 2366",null);
            ubicacion_campaña3 = ubicacionCampañaRepository.save(ubicacion_campaña3);
            Ubicacion_Campaña ubicacion_campaña4 = new Ubicacion_Campaña(null,"Lima","Chorrillos","Av. Guardia Civil 455",null);
            ubicacion_campaña4 = ubicacionCampañaRepository.save(ubicacion_campaña4);
            Ubicacion_Campaña ubicacion_campaña5 = new Ubicacion_Campaña(null,"Cusco","San Sebastian","Jr. Arequipa 45",null);
            ubicacion_campaña5 = ubicacionCampañaRepository.save(ubicacion_campaña5);
            Ubicacion_Campaña ubicacion_campaña6 = new Ubicacion_Campaña(null,"Cusco","Poroy","Calle Tandapata 89",null);
            ubicacion_campaña6 = ubicacionCampañaRepository.save(ubicacion_campaña6);
            Ubicacion_Campaña ubicacion_campaña7 = new Ubicacion_Campaña(null,"Cusco","Santiago","Av. La Cultura 123",null);
            ubicacion_campaña7 = ubicacionCampañaRepository.save(ubicacion_campaña7);

            //Campañas
            Campaña campaña1a =new Campaña(null, "Recoleccion de Frazadas", "Se recolecta todo tipo de manta",LocalDate.of(2024,5,13), LocalDate.of(2024,7,15),ong1,ubicacion_campaña1, null,null);
            campaña1a = campañaRepository.save(campaña1a);
            Campaña campaña1b =new Campaña(null, "Un Hogar Después de la Tormenta", "Brindamos refugio temporal a familias damnificadas.",LocalDate.of(2024,7,20), LocalDate.of(2024,9,22),ong1,ubicacion_campaña2, null,null);
            campaña1b = campañaRepository.save(campaña1b);

            Campaña campaña1c =new Campaña(null, "Renacer Juntos", "Ayuda integral para reconstruir vidas tras un desastre",LocalDate.of(2024,9,27), LocalDate.of(2024,11,29),ong1,ubicacion_campaña3, null,null);
            campaña1c = campañaRepository.save(campaña1c);
            Campaña campaña1d =new Campaña(null, "Actúa por Ellos", "Asistencia inmediata para zonas afectadas",LocalDate.of(2025,1,3), LocalDate.of(2025,3,5),ong1,ubicacion_campaña4, null,null);
            campaña1d = campañaRepository.save(campaña1d);

            Usuario usuario2=new Usuario(null,"Luis Mendoza","1111",null,null);
            usuario2=usuarioRepository.save(usuario2);
            /*JrProject jrProject2a = new JrProject(null, "Campaña Medica Rural",jrNgo2,LocalDate.of(2025,4,15),"Atencion medica gratuita","15000","Terminado" );
            jrProject2a = jrProjectRepository.save(jrProject2a);
            JrProject jrProject2b = new JrProject(null, "Nutricion Infantil",jrNgo2,LocalDate.of(2025,4,20),"Educacion Nutricional","8000","Terminado" );
            jrProject2b = jrProjectRepository.save(jrProject2b);*/

            Usuario usuario3=new Usuario(null,"Pedro Vera","2222",null,null);
            usuario3=usuarioRepository.save(usuario3);

            Usuario usuario4=new Usuario(null,"Hugo Lezama","3333",null,null);
            usuario4=usuarioRepository.save(usuario4);

            Usuario usuario5=new Usuario(null,"Diego Huaycaya","4444",null,null);
            usuario5=usuarioRepository.save(usuario5);


            //Post
            byte[] imagenVacia1 = new byte[0];
            Post post1a=new Post(null,"Fuerza a todos",imagenVacia1,LocalDate.of(2024,2,10),campaña1d);
            post1a=postRepository.save(post1a);

            byte[] imagenVacia2 = new byte[0];
            Post post1b=new Post(null,"Seguimos Luchando",imagenVacia2,LocalDate.of(2024,3,11),campaña1d);
            post1b=postRepository.save(post1b);

            byte[] imagenVacia3 = new byte[0];
            Post post1c=new Post(null,"Nunca es suficiente",imagenVacia3,LocalDate.of(2024,4,12),campaña1d);
            post1c=postRepository.save(post1c);

            byte[] imagenVacia4 = new byte[0];
            Post post1d=new Post(null,"Estamos juntos",imagenVacia4,LocalDate.of(2024,5,13),campaña1d);
            post1d=postRepository.save(post1d);

            //Donante
            Donante donante1 = new Donante(null,"Juan Perez","09716678","juan@gmail.com","998276975","Av. Mendiola 2654", LocalDate.of(1999,4,24),usuario3,null,null, null );
            donante1 = donanteRepository.save(donante1);
            Donante donante2 = new Donante(null,"Leandro Chavez","09735578","leandro@gmail.com","998232775","Av. Pacaz 3654", LocalDate.of(1995,6,14),usuario4,null,null,null );
            donante2 = donanteRepository.save(donante2);
            Donante donante3 = new Donante(null,"Jesus Villegas","09568879","jesus@gmail.com","998564775","Av. Real 4244", LocalDate.of(1989,5,22),usuario5,null,null,null );
            donante3 = donanteRepository.save(donante3);


            //Comentario
            Comentario comentario1 = new Comentario(null,"Muy buen trabaajo chicos", LocalDate.of(2025,5,5),null,null );
            comentario1 = comentarioRepository.save(comentario1);

            Comentario comentario2 = new Comentario(null,"Sigan asi!", LocalDate.of(2025,4,14),null,null );
            comentario2 = comentarioRepository.save(comentario2);

            Comentario comentario3 = new Comentario(null,"Gracias por ayudarlos", LocalDate.of(2025,3,5),null,null );
            comentario3 = comentarioRepository.save(comentario3);

            Comentario comentario4 = new Comentario(null,"Gracias por ayudarlos", LocalDate.of(2025,3,15),post1a,donante1 );
            comentario4 = comentarioRepository.save(comentario4);

            //CampañaFavorita
            CampañaFavorita campañaFavorita1 = new CampañaFavorita(null,null, null);
            campañaFavorita1 = campaFavoritaRepository.save(campañaFavorita1);
            CampañaFavorita campañaFavorita2 = new CampañaFavorita(null,null, null);
            campañaFavorita2 = campaFavoritaRepository.save(campañaFavorita2);
            CampañaFavorita campañaFavorita3 = new CampañaFavorita(null,null, null);
            campañaFavorita3 = campaFavoritaRepository.save(campañaFavorita3);
            CampañaFavorita campañaFavorita4 = new CampañaFavorita(null,null, null);
            campañaFavorita4 = campaFavoritaRepository.save(campañaFavorita4);

            //Tipo Donacion
            TipoDonacion tipodonacion1 = new TipoDonacion(null,"Monetario",null);
            tipodonacion1 = tipoDonacionRepository.save(tipodonacion1);
            TipoDonacion tipodonacion2 = new TipoDonacion(null,"Especie",null);
            tipodonacion2 = tipoDonacionRepository.save(tipodonacion2);
            TipoDonacion tipodonacion3 = new TipoDonacion(null,"Voluntariado",null);
            tipodonacion3 = tipoDonacionRepository.save(tipodonacion3);
            TipoDonacion tipodonacion4 = new TipoDonacion(null,"ServicioProfesional",null);
            tipodonacion4 = tipoDonacionRepository.save(tipodonacion4);

            //Estado Donancion
            EstadoDonacion estadoDonacion1 = new EstadoDonacion(null,"Pendiente",LocalDate.of(2025,05,10),null);
            estadoDonacion1 = estadoDonacionRepository.save(estadoDonacion1);
            //Estado Donancion
            EstadoDonacion estadoDonacion2 = new EstadoDonacion(null,"Completado",LocalDate.of(2025,05,12),null);
            estadoDonacion2 = estadoDonacionRepository.save(estadoDonacion2);

            //Donacion
            Donacion donacion1 = new Donacion(null, "Donacion de alimentos","Caja con viveres basicos para familiares",1500.00,"Presencial",LocalDate.of(2025,05,12),donante1,campaña1a,tipodonacion1,estadoDonacion1);
            donacion1 = donacionRepository.save(donacion1);
            Donacion donacion2 = new Donacion(null, "Donacion de abrigo","Abrigos, frazadas y ropa de invierno",200.00,"Presencial",LocalDate.of(2025,05,10),donante1,campaña1a,tipodonacion2,estadoDonacion1);
            donacion2 = donacionRepository.save(donacion2);
            Donacion donacion3 = new Donacion(null, "Donación en efectivo","Apoyo financiero para damnificados",500.00,"Transferencia",LocalDate.of(2025,04,20),donante1,campaña1a,tipodonacion1,estadoDonacion2);
            donacion3 = donacionRepository.save(donacion3);
            Donacion donacion4 = new Donacion(null, "Medicamentos básicos","Alcohol, vendas, paracetamol",300.00,"Courier",LocalDate.of(2025,04,15),donante1,campaña1a,tipodonacion1,estadoDonacion2);
            donacion4 = donacionRepository.save(donacion4);
            Donacion donacion5 = new Donacion(null, "Bidones de agua potable","4 bidones de 20L para familias afectadas",500.00,"Presencial",LocalDate.of(2025,03,7),donante1,campaña1a,tipodonacion1,estadoDonacion2);
            donacion5 = donacionRepository.save(donacion5);

        };

    }

}
