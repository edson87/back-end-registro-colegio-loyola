package com.registros.formularios.com.registros.formularios.auth;

import com.registros.formularios.com.registros.formularios.models.entity.Usuario;
import com.registros.formularios.com.registros.formularios.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfAdicionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String,Object> inf = new HashMap<>();
        Usuario usuario = usuarioService.findByUsername(oAuth2Authentication.getName());

        inf.put("info_adicional","Hola Usuario ".concat(usuario.getUsername()));
        inf.put("nombre", usuario.getNombre());
        inf.put("apellido", usuario.getApellido());
        inf.put("email", usuario.getEmail());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(inf);

        return oAuth2AccessToken;
    }
}
