package com.softtek.servicio.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

//Servicio que concede los permisos de las funciones del CRUD
@Service
public class AuthServiceImp {
    public boolean tieneAcceso(String path) {
        boolean rpta = false;
        String metodoRol = "";
        switch (path) {
        case "listar":
            metodoRol = "ADMIN";
            break;
        case "listarId":
            metodoRol = "ADMIN,USER,DBA";
            break;
        }
        String metodoRoles[] = metodoRol.split(",");
        
        //Recoge el usuario que se está usando en ese momento
        Authentication usuarioLogeado = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(usuarioLogeado.getName());
        for (GrantedAuthority auth : usuarioLogeado.getAuthorities()) {
            String rolUser = auth.getAuthority();
            System.out.println(rolUser);
            for (String rolMet : metodoRoles) {
                if (rolUser.equalsIgnoreCase(rolMet)) {
                    rpta = true;
                }
            }
        }
        return rpta;
    }
}