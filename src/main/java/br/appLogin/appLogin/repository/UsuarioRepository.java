package br.appLogin.appLogin.repository;

import br.appLogin.appLogin.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository  extends CrudRepository <Usuario, String> {


    Usuario findById(Long id);
    Usuario findByEmail(String email);
    Usuario findByNome(String nome);
    Usuario findBySenha(String senha);


    String nome(@NotEmpty String nome);
}
