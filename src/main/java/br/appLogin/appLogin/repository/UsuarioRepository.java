package br.appLogin.appLogin.repository;

import br.appLogin.appLogin.model.Usuario;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository  extends CrudRepository<Usuario, String> {


    Usuario findById(Long id);
    Usuario findByEmail(String email);
    Usuario findByLogin(String login);
    Usuario findBySenha(String senha);



}
