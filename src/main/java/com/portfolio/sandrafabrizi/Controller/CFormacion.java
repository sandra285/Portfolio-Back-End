package com.portfolio.sandrafabrizi.Controller;

import com.portfolio.sandrafabrizi.Dto.dtoFormacion;
import com.portfolio.sandrafabrizi.Entity.Formacion;
import com.portfolio.sandrafabrizi.Security.Controller.Mensaje;
import com.portfolio.sandrafabrizi.Service.SFormacion;
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
@RequestMapping("formacion")
// Local
// @CrossOrigin(origins = "http://localhost:4200")
// Producción
@CrossOrigin(origins = "https://portfoliosf-frontend.web.app/")

public class CFormacion {
    
    @Autowired
    SFormacion sFormacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> list(){
        List<Formacion> list = sFormacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Formacion> getById(@PathVariable("id") int id){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("La educación solicitada no existe"), HttpStatus.NOT_FOUND);
        Formacion formacion = sFormacion.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoform){
        if(StringUtils.isBlank(dtoform.getNombreF()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if(sFormacion.existsByNombreF(dtoform.getNombreF()))
            return new ResponseEntity(new Mensaje("La educacion ya existe."), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = new Formacion(dtoform.getNombreF(),dtoform.getTituloF(), dtoform.getMesInicioF(), dtoform.getAnioInicioF(),
                                            dtoform.getMesFinF(), dtoform.getAnioFinF());
        
        sFormacion.save(formacion);
        
        return new ResponseEntity(new Mensaje("Educación guardada exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFormacion dtoform){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe."), HttpStatus.BAD_REQUEST);
        if(sFormacion.existsByNombreF(dtoform.getNombreF()) && sFormacion.getByNombreF(dtoform.getNombreF()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La educación ingresada ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoform.getNombreF()))
            return new ResponseEntity(new Mensaje("Por favor complete el nombre."), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = sFormacion.getOne(id).get();
        formacion.setNombreF(dtoform.getNombreF());
        formacion.setTituloF(dtoform.getTituloF());
        formacion.setMesInicioF(dtoform.getMesInicioF());
        formacion.setAnioInicioF(dtoform.getAnioInicioF());
        formacion.setMesFinF(dtoform.getMesFinF());
        formacion.setAnioFinF(dtoform.getAnioFinF());
        
        sFormacion.save(formacion);
        return new ResponseEntity(new Mensaje("La educación fue actualizada exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        
        sFormacion.delete(id);
        
        return new ResponseEntity(new Mensaje("La educación fue eliminada exitosamente!"), HttpStatus.OK);   
    }
}
