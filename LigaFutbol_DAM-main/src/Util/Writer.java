package Util;

import Model.Jugador;

import java.io.*;

public class Writer {

    public static void EscribirJugadores(Jugador jugador){
        String nombreArchivo = jugador.getNombre();
        try {
            FileWriter writer = new FileWriter("jugadores.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(jugador.getEquipo().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(jugador.getNombre() + " "+jugador.getApellidos() + " Edad: " + jugador.getEdad());
            bufferedWriter.newLine();
            bufferedWriter.write(jugador.getPosicion()+ " " +jugador.getCategoria());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (
                IOException e){
            e.printStackTrace();
        }
    }

}
