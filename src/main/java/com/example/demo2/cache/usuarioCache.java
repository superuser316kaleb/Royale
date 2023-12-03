package com.example.demo2.cache;

public class usuarioCache {
    private static String nombreUsuario;

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        usuarioCache.nombreUsuario = nombreUsuario;
    }
}
