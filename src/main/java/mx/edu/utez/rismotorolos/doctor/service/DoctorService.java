
package mx.edu.utez.rismotorolos.doctor.service;

import mx.edu.utez.rismotorolos.doctor.model.Doctor;
import mx.edu.utez.rismotorolos.doctor.model.DoctorDto;
import mx.edu.utez.rismotorolos.doctor.model.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorDto.toEntity();
        return doctorRepository.save(doctor);
    }

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<DoctorDto> getDoctorById(Long id) {
        return doctorRepository.findById(id).map(DoctorDto::fromEntity);
    }

    public Optional<DoctorDto> updateDoctor(Long id, DoctorDto doctorDto) {
        return doctorRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setName(doctorDto.getName());
            existingDoctor.setLast_name(doctorDto.getLast_name());
            existingDoctor.setProfessional_id(doctorDto.getProfessional_id());
            existingDoctor.setPhone_number(doctorDto.getPhone_number());
            existingDoctor.setNurse(doctorDto.getNurse());
            existingDoctor.setStock(doctorDto.getStock());
            doctorRepository.save(existingDoctor);
            return DoctorDto.fromEntity(existingDoctor);
        });
    }

    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
