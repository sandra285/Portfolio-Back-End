package com.portfolio.sandrafabrizi.Security.Repository;

import com.portfolio.sandrafabrizi.Security.Entity.Rol;
import com.portfolio.sandrafabrizi.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
