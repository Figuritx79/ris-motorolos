package mx.edu.utez.rismotorolos.facture.controller;

import mx.edu.utez.rismotorolos.facture.model.Facture;
import mx.edu.utez.rismotorolos.facture.model.FactureDto;
import mx.edu.utez.rismotorolos.facture.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public List<Facture> getAll() {
        return factureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getById(@PathVariable Long id) {
        Optional<Facture> facture = factureService.findById(id);
        return facture.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Facture> save(@RequestBody FactureDto factureDto) {
        Facture createdFacture = factureService.save(factureDto);
        return ResponseEntity.ok(createdFacture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facture> update(@PathVariable Long id, @RequestBody FactureDto factureDto) {
        Optional<Facture> updatedFacture = factureService.update(id, factureDto);
        return updatedFacture.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (factureService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
