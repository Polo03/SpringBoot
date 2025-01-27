package org.example.casademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casa")
public class CasaController {

    @Autowired
    Casa casa;

    @GetMapping
    public ResponseEntity<Casa> getCasa() {
        casa.setDueño("mi casa");
        casa.setMaterial("material prueba");
        return ResponseEntity.ok(casa);
    }


}
