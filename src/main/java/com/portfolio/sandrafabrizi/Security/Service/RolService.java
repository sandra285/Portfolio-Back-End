package com.portfolio.sandrafabrizi.Security.Service;

import com.portfolio.sandrafabrizi.Security.Entity.Rol;
import com.portfolio.sandrafabrizi.Security.Enums.RolNombre;
import com.portfolio.sandrafabrizi.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
