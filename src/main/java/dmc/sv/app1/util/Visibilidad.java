package dmc.sv.app1.util;

public interface Visibilidad {

    public static final String DOS_PUNTOS_STR = ":";

    default void mostrarError (String contenido, Exception error){
        System.err.println(contenido + DOS_PUNTOS_STR + error);
    }

    default void mostrarError (String contenido){
        System.err.println(contenido);
    }

    default void mostrar (String contenido){
        System.out.println(contenido);
    }
}
