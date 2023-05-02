package com.portfolio.sandrafabrizi.Repository;

import com.portfolio.sandrafabrizi.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos  extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombreP(String nombreP);
    
    public boolean existsByNombreP(String nombreP);
}
