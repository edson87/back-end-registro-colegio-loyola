package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);
}
