package dmc.sv.app1.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import dmc.sv.app1.data.ServerData;
import dmc.sv.app1.util.Visibilidad;

public class Cliente implements ServerData, Visibilidad{
    private static final String EXCEPT_ENVIAR_RECIBIR = "Exception al enviar o recibir información al servidor";
    private static final String RESPUESTA_DEL_SERVIDOR = "Respuesta del servidor: ";
    private final static String HOST = "localhost";
    public static void main(String[] args) throws Exception {
        Visibilidad visibilidad = new Visibilidad() {};

        try (Socket cliente = new Socket( HOST, ServerData.PORT )) {
            enviar(cliente, 10);
            recibir(cliente);
        } catch (Exception e) { 
            visibilidad.mostrarError(EXCEPT_ENVIAR_RECIBIR, e);
        }
    }

    private static void enviar(Socket cliente, int hojas) throws IOException {
        DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
        output.writeInt(hojas);
    }

    private static void recibir(Socket cliente) throws IOException {
        Visibilidad visibilidad = new Visibilidad() {};

        DataInputStream input = new DataInputStream(cliente.getInputStream());
        String respuesta = input.readUTF();
        visibilidad.mostrar(RESPUESTA_DEL_SERVIDOR + respuesta);
    }
}