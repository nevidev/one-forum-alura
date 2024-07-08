package aluraforum.com.example.aluraforum.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    List<Usuario> findAllByAtivoTrue(Usuario user);

    @Query("SELECT COUNT(c) " +
            "FROM Usuario c " +
            "WHERE c.perfil.id = 1")
    Long countAdministrators();
}
