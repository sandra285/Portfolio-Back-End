package com.portfolio.sandrafabrizi.Controller;

import com.portfolio.sandrafabrizi.Dto.dtoPersona;
import com.portfolio.sandrafabrizi.Entity.Persona;
import com.portfolio.sandrafabrizi.Security.Controller.Mensaje;
import com.portfolio.sandrafabrizi.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://portfoliosf-frontend.web.app","http://localhost:4200"})
public class CPersona {
    
    @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre()) && StringUtils.isBlank(dtoper.getApellido()))
            return new ResponseEntity(new Mensaje("Nombre y apellido son obligatorios."), HttpStatus.BAD_REQUEST);
  
        Persona persona =  new Persona(dtoper.getNombre(), dtoper.getSegnombre(), dtoper.getApellido(), dtoper.getImg(), dtoper.getTitulo1(), dtoper.getTitulo2(),
                                        dtoper.getSobremi(), dtoper.getCiudad(), dtoper.getProvincia(), dtoper.getPais());
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona creada correctamente."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        //Validamos si existe el id
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.BAD_REQUEST);
        //Se comparan los nombres
        if(sPersona.existsByNombre(dtoper.getNombre()) && sPersona.getByNombre(dtoper.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        //Valida que el campo no esté vacío
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("Por favor complete el nombre"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setSegnombre(dtoper.getSegnombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg(dtoper.getImg());
        persona.setTitulo1(dtoper.getTitulo1());
        persona.setTitulo2(dtoper.getTitulo2());
        persona.setSobremi(dtoper.getSobremi());
        persona.setCiudad(dtoper.getCiudad());
        persona.setProvincia(dtoper.getProvincia());
        persona.setPais(dtoper.getPais());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Los datos de la persona fueron actualizados exitosamente!"), HttpStatus.OK);   
    }
    
   
}

