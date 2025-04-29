package br.appLogin.appLogin.service;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired

    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String email, String senha) {
        // Busca o usuário pelo e-mail, utilizando Optional para garantir segurança
        Optional<Usuario> usuarioOpt = Optional.ofNullable(usuarioRepository.findByEmail(email));

        // Se o usuário existir, compara a senha
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getSenha().equals(senha);
        }

        // Se o usuário não for encontrado, retorna falso
        return false;
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
