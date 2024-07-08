package aluraforum.com.example.aluraforum.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findAllByAtivoTrue(Topico topico);
}
