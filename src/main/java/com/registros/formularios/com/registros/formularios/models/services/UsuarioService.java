package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.controllers.EstudianteController;
import com.registros.formularios.com.registros.formularios.models.dao.IUsuarioDao;
import com.registros.formularios.com.registros.formularios.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
    @Autowired
    private IUsuarioDao usuarioDao;

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsernameQuery(username);

        if (usuario == null){
            log.error("Error en el login: no existe el usuario '"+username+"'");
            throw new UsernameNotFoundException("Error e el login: No existe el usuario '"+username);
        }
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek( authority -> log.info("Role: "+ authority.getAuthority()) )
                .collect(Collectors.toList());

        return new User(username,usuario.getPassword(),usuario.getEnabled(),true,true,true,authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
