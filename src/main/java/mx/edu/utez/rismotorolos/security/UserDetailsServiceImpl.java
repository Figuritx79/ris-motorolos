package mx.edu.utez.rismotorolos.security;
import mx.edu.utez.rismotorolos.doctor.model.Doctor;
import mx.edu.utez.rismotorolos.doctor.model.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    private final DoctorRepository doctorRepository;

    @Autowired
    public UserDetailsServiceImpl(DoctorRepository userRepository) {
        this.doctorRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Doctor user = doctorRepository.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + mail));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName())));
    }
}
