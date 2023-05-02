package com.portfolio.sandrafabrizi.Repository;

import com.portfolio.sandrafabrizi.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidades extends JpaRepository<Habilidades, Integer>{
    
    Optional<Habilidades> findByNombreH(String nombreH);
    
    public boolean existsByNombreH(String nombreH);
}    

