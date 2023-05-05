package com.portfolio.sandrafabrizi.Controller;

import com.portfolio.sandrafabrizi.Dto.dtoHabilidades;
import com.portfolio.sandrafabrizi.Entity.Habilidades;
import com.portfolio.sandrafabrizi.Security.Controller.Mensaje;
import com.portfolio.sandrafabrizi.Service.SHabilidades;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidades {
    
    @Autowired
    SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list(){
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad solicitada no existe"), HttpStatus.NOT_FOUND);
        Habilidades habilidad = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohab){
        if(StringUtils.isBlank(dtohab.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre de la habilidad es obligatorio."), HttpStatus.BAD_REQUEST);
        if(sHabilidades.existsByNombreH(dtohab.getNombreH()))
            return new ResponseEntity(new Mensaje("La habilidad ya existe."), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidad = new Habilidades(dtohab.getNombreH(),dtohab.getPorcentajeH());
        
        sHabilidades.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad guardada exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohab){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe."), HttpStatus.BAD_REQUEST);
        if(sHabilidades.existsByNombreH(dtohab.getNombreH()) && sHabilidades.getByNombreH(dtohab.getNombreH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La habilidad ingresada ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohab.getNombreH()))
            return new ResponseEntity(new Mensaje("Por favor complete el nombre de la habilidad."), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidad = sHabilidades.getOne(id).get();
        habilidad.setNombreH(dtohab.getNombreH());
        habilidad.setPorcentajeH(dtohab.getPorcentajeH());
      
        sHabilidades.save(habilidad);
        return new ResponseEntity(new Mensaje("La habilidad fue actualizada exitosamente!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        
        sHabilidades.delete(id);
        
        return new ResponseEntity(new Mensaje("La habilidad fue eliminada exitosamente!"), HttpStatus.OK);   
    }
}
