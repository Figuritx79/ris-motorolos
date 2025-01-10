package mx.edu.utez.rismotorolos.pacient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.rismotorolos.pacient.model.PacientRepository;
import mx.edu.utez.rismotorolos.utils.ResponseObject;
import mx.edu.utez.rismotorolos.utils.TypeResponse;

@Service
@Transactional
public class PacientService {

    private PacientRepository pacientRepository;

    @Autowired
    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseObject> findAll() {
        var pacients = pacientRepository.findAll();

        return new ResponseEntity<>(new ResponseObject(TypeResponse.SUCCESS, "All Pacients", pacients), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponseObject> findById(long id) {
        var pacient = pacientRepository.findById(id);

        if (pacient == null) {
            return new ResponseEntity<>(new ResponseObject(TypeResponse.WARN, "Not found pacient"),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ResponseObject(TypeResponse.SUCCESS, "Found", pacient), HttpStatus.OK);
    }
}
