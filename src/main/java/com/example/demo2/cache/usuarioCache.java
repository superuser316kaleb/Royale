package com.example.demo2.cache;

public class usuarioCache {
    private static String nombreUsuario,tarjetaterminacion,tipoTarjeta;

    public static String getNombreUsuario() {
        return nombreUsuario;
    }
    public static String getTarjetaterminacion() {
        return tarjetaterminacion;
    }
    public static String getTipoTarjeta() {
        return tipoTarjeta;
    }


    public static void setNombreUsuario(String nombreUsuario) {
        usuarioCache.nombreUsuario = nombreUsuario;
    }
    public static void setTarjetaterminacion(String tarjetaterminacion) {
        usuarioCache.tarjetaterminacion = tarjetaterminacion;
    }
    public static void setTipoTarjeta(String tipoTarjeta) {
        usuarioCache.tipoTarjeta = tipoTarjeta;
    }
}
