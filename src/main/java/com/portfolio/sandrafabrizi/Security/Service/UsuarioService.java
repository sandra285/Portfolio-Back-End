package com.portfolio.sandrafabrizi.Security.Service;

import com.portfolio.sandrafabrizi.Security.Entity.Usuario;
import com.portfolio.sandrafabrizi.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}

