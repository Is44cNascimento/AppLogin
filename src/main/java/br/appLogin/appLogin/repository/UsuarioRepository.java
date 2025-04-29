package br.appLogin.appLogin.repository;

import br.appLogin.appLogin.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findByEmail(String email);
    Usuario findByNome(String nome);
    Usuario findBySenha(String senha);


}
