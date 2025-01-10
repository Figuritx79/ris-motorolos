package mx.edu.utez.rismotorolos.facture.service;

import mx.edu.utez.rismotorolos.facture.model.Facture;
import mx.edu.utez.rismotorolos.facture.model.FactureDto;
import mx.edu.utez.rismotorolos.facture.model.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> findAll() {
        return factureRepository.findAll();
    }

    public Optional<Facture> findById(Long id) {
        return factureRepository.findById(id);
    }

    public Facture save(FactureDto factureDto) {
        return factureRepository.save(factureDto.toEntity());
    }

    public Optional<Facture> update(Long id, FactureDto factureDto) {
        if (factureRepository.existsById(id)) {
            Facture facture = factureDto.toEntity();
            facture.setId(id);
            return Optional.of(factureRepository.save(facture));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (factureRepository.existsById(id)) {
            factureRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
