package org.example.cochedemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coches")
public class CocheController {

    @GetMapping()
    public ResponseEntity<Coche> getCoche() {
        return ResponseEntity.ok(new Coche("toyota","utilitario","rojo",123, 1000.45F,"diesel"));
    }

    @PostMapping()
    public ResponseEntity<Coche> insertCoche(@RequestBody Coche coche) {
        System.out.println(coche);
        return ResponseEntity.ok(coche);
    }

    @PutMapping()
    public ResponseEntity<Coche> updateCoche(@RequestBody Coche coche) {
        System.out.println(coche);
        return ResponseEntity.ok(coche);
    }

    @DeleteMapping()
    public ResponseEntity<Coche> deleteCoche(@RequestBody Coche coche) {
        System.out.println(coche);
        return ResponseEntity.ok(coche);
    }



}
