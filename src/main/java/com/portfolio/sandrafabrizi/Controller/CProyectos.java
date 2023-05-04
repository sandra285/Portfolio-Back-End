package com.portfolio.sandrafabrizi.Controller;

import com.portfolio.sandrafabrizi.Dto.dtoProyectos;
import com.portfolio.sandrafabrizi.Entity.Proyectos;
import com.portfolio.sandrafabrizi.Security.Controller.Mensaje;
import com.portfolio.sandrafabrizi.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectos")
// Local
// @CrossOrigin(origins = "http://localhost:4200")
// Producción
@CrossOrigin(origins = "https://portfoliosf-frontend.web.app/")

public class CProyectos {
    
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyecto = sProyectos.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy){
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreP(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El proyecto ya existe."), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto =  new Proyectos(dtoproy.getNombreP(), dtoproy.getDescripcionP(), dtoproy.getMesInicioP(), dtoproy.getAnioInicioP(), dtoproy.getMesFinP(), dtoproy.getAnioFinP(), dtoproy.getVerP(), dtoproy.getRepoP());
        sProyectos.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto creado correctamente."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy){
        //Validamos si existe el id
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        //Se comparan los nombres de las experiencias
        if(sProyectos.existsByNombreP(dtoproy.getNombreP()) && sProyectos.getByNombreP(dtoproy.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //Valida que el campo no esté vacío
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("Por favor complete el nombre del proyecto"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto = sProyectos.getOne(id).get();
        proyecto.setNombreP(dtoproy.getNombreP());
        proyecto.setDescripcionP(dtoproy.getDescripcionP());
        proyecto.setMesInicioP(dtoproy.getMesInicioP());
        proyecto.setAnioInicioP(dtoproy.getAnioInicioP());
        proyecto.setMesFinP(dtoproy.getMesFinP());
        proyecto.setAnioFinP(dtoproy.getAnioFinP());
        proyecto.setVerP(dtoproy.getVerP());
        proyecto.setRepoP(dtoproy.getRepoP());
        
        sProyectos.save(proyecto);
        return new ResponseEntity(new Mensaje("El proyecto fue actualizado exitosamente!"), HttpStatus.OK);   
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        
        sProyectos.delete(id);
        
        return new ResponseEntity(new Mensaje("El proyecto fue eliminado exitosamente!"), HttpStatus.OK);   
    }

}
