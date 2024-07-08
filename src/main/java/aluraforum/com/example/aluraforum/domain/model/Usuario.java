package aluraforum.com.example.aluraforum.domain.model;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_perfil")
    private Perfil perfil;
    private Boolean ativo;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", ativo=" + ativo +
                '}';
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
