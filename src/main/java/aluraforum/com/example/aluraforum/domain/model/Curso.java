package aluraforum.com.example.aluraforum.domain.model;

import aluraforum.com.example.aluraforum.domain.dto.UpdateCurso;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Getter
    private String categoria;

    @Getter
    private Boolean ativo;

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ativo=" + ativo +
                '}';
    }

    public void delete() {
        System.out.println("Curso deletado!");
    }

    public void update(UpdateCurso updateData) {
        this.name = updateData.nome();
        this.categoria = updateData.categoria();
        this.ativo = updateData.ativo();
    }

    public Long id() {
        return null;
    }

    public String getNome() {
        return name;
    }

}
