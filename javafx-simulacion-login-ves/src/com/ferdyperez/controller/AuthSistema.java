package com.ferdyperez.controller;

import com.ferdyperez.model.Rol;
import com.ferdyperez.model.Usuario;
import java.util.ArrayList;

public class AuthSistema {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public AuthSistema() {
        Usuario usuarioAdmin = new Usuario("admin",
                "admin",
                "admin",
                Rol.ADMIN);

        Usuario usuarioUser = new Usuario("user",
                "user",
                "user",
                Rol.USER);

        Usuario usuarioYo = new Usuario("ferdy",
                "123",
                "ferdy alejandro perez miranda",
                Rol.ADMIN);

        listaUsuarios.add(usuarioAdmin);
        listaUsuarios.add(usuarioUser);
        listaUsuarios.add(usuarioYo);

    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        AuthSistema.listaUsuarios = listaUsuarios;
    }

    public Usuario login(String nombreUsuario, String clave) {
        for (Usuario usuarioBuscado : listaUsuarios) {
            if (usuarioBuscado.getNombreUsuario().equals(nombreUsuario)
                    && usuarioBuscado.getPassword().equals(clave)) {
                return usuarioBuscado;
            }
        }

        return null;
    }

}
