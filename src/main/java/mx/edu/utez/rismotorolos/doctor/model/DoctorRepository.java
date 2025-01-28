package mx.edu.utez.rismotorolos.doctor.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    Optional<Doctor> findByMail(@Param("email") String email);

}
