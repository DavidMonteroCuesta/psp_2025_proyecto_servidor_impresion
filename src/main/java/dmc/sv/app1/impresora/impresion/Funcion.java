package dmc.sv.app1.impresora.impresion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import dmc.sv.app1.util.Visibilidad;

public class Funcion implements Runnable, Visibilidad{

    private Socket cliente;
    private Impresora impresora;    

    private final String OK = "OK";
    private final String KO = "KO";
    private static final String EXCEPTION_AL_CERRAR_EL_CLIENTE = "Exception al cerrar el cliente";
    private static final String EXCEPTION_AL_EJECUTAR_LO_REUERIDO_POR_EL_CLIENTE = "Exception al ejecutar lo reuerido por el cliente";


    public Funcion(Socket cliente, Impresora impresora) {
        this.cliente = cliente;
        this.impresora = impresora;
    }

    @Override
    public void run(){
        try {
            int folios = readInt();
            
            if (impresora.getFolios() >= folios) {
                impresora.imprimir(folios);
                send(OK);
            } else send(KO);
        
        } catch (IOException e) {
            mostrarError(EXCEPTION_AL_EJECUTAR_LO_REUERIDO_POR_EL_CLIENTE, e);
        } finally {
            cerrar();
        }
    }

    private int readInt() throws IOException{
        DataInputStream input = new DataInputStream(cliente.getInputStream());
        return input.readInt();
    }

    private void send(String msg) throws IOException{
        DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
        output.writeUTF(msg);
    }

    private void cerrar (){
        try {
            this.cliente.close();
        } catch (IOException e) {
            System.err.println(EXCEPTION_AL_CERRAR_EL_CLIENTE + e);
        }
    }
    public Socket getCliente() {
        return cliente;
    }
    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public Impresora getImpresora() {
        return impresora;
    }
    public void setImpresora(Impresora impresora) {
        this.impresora = impresora;
    }
}
