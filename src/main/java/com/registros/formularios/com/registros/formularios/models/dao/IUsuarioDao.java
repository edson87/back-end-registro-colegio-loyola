package com.registros.formularios.com.registros.formularios.models.dao;

import com.registros.formularios.com.registros.formularios.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsernameQuery(String username);
}
