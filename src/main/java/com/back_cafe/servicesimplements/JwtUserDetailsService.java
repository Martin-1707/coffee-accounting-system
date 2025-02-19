package com.back_cafe.servicesimplements;


import com.back_cafe.entities.Usuario;
import com.back_cafe.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = uR.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no encontrado con el nombre de usuario: ", username));
        }

//        // Como el usuario solo tiene un rol, lo convertimos en una autoridad de Spring Security
//        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre_rol());

        // Convertimos el rol único del usuario en una lista de autoridades
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre_rol()));

        // Creamos y retornamos un objeto UserDetails con los datos del usuario
        UserDetails ud = new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(), // Si está habilitado
                true, // Cuenta no expirada
                true, // Credenciales no expiradas
                true, // Cuenta no bloqueada
                roles // Lista de roles (solo uno en este caso)
        );

        return ud;
    }

}
