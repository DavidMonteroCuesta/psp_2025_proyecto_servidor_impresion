package dmc.sv.app1.impresora;
import java.net.ServerSocket;
import java.net.Socket;

import dmc.sv.app1.data.ServerData;
import dmc.sv.app1.impresora.impresion.Funcion;
import dmc.sv.app1.impresora.impresion.Impresora;
import dmc.sv.app1.util.Visibilidad;

public class Servidor implements ServerData, Visibilidad{
    private static final String EXCEPTION_AL_CONECTAR_CON_EL_CLIENTE = "Exception al conectar con el cliente";
    private static final String SERVIDOR_ESCUCHANDO_EN = "Servidor escuchando en ";
    private static final String CLIENTE_CONECTADO = "Cliente conectado";

    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        Visibilidad visibilidad = new Visibilidad() {};

        try (ServerSocket server = new ServerSocket(ServerData.PORT)) {
            visibilidad.mostrar(SERVIDOR_ESCUCHANDO_EN + ServerData.PORT);
            while (true) {
                Socket cliente = server.accept();
                visibilidad.mostrar(CLIENTE_CONECTADO);

                Thread thread = new Thread(new Funcion(cliente, impresora));
                thread.start();
            }
        } catch (Exception e) {
            visibilidad.mostrarError(EXCEPTION_AL_CONECTAR_CON_EL_CLIENTE, e);
        }
    }
}
