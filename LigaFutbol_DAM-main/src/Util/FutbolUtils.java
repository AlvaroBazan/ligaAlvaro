package Util;

import Model.Entrenador;
import Model.Equipo;

import java.io.*;

public class FutbolUtils {

    public static void guardarEquipo(String nombreArchivo, Equipo equipo) {

        //Este método recibe un equipo y un nombre de archivo y guarda el equipo en un archivo con ese nombre

        try {
            FileWriter writer = new FileWriter(nombreArchivo+".txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(equipo.toString());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(equipo.getEntrenador()));
            bufferedWriter.newLine();
            for (int i = 0; i < equipo.getJugadores().length; i++) {
                bufferedWriter.write(equipo.getJugadores()[i].toString());
            }

            bufferedWriter.close();
        } catch (
                IOException e){
            e.printStackTrace();
        }

    }



    public static Equipo cargarEquipo (String nombreArchivo) {

        Equipo equipo = new Equipo();

        //Este método recibe un nombre de Archivo y devuelve un equipo
        try{
            FileReader reader = new FileReader(nombreArchivo+".txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null){
               // System.out.println(line);
                if (line.contains("Equipo: ")){
                    int ind = line.indexOf(":");
                    equipo.setNombre(line.substring(ind));
                }

                else if (line.contains(("Club: "))){
                    int ind = line.indexOf(":");
                    equipo.setClub(line.substring(ind));
                }

                else if (line.contains("Entrenador: ")) {
                    int nombre = line.indexOf(":");
                    int edad = line.indexOf("Edad:");
                    int licencia = line.indexOf("Licencia:");
                    Entrenador entrenador = new Entrenador();
                    entrenador.setNombre(line.substring(nombre));
                    //entrenador.setEdad(Integer.parseInt((line.substring(edad))));
                    //entrenador.setNumeroLicencia(Integer.parseInt(line.substring(licencia)));
                    equipo.setEntrenador(entrenador);
                }
            }
            bufferedReader.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        return equipo;
    }



    public Equipo ordenarEquipo (Equipo equipo) {

        //Este método recibe un Equipo y ordena sus jugadores por apellidos y en

        //caso de igualdad de apellidos por nombre

        return null;
    }



    //Añade las clases que consideres necesarias


}
