package Util;
import Model.DatosClasificacion;
import Model.Jugador;
public class Ordenacion {


    //---------- Bubble Sort --------//
// Ordenamos la CLASIFICACION con el bubblesort con 3 argumentos: TotalPuntos > DiferenciaGoles > PartidosGanados
    public static DatosClasificacion[] ordenarClasificacion(DatosClasificacion[] datosClasificacion) {
        int n = datosClasificacion.length;
        DatosClasificacion temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (criteriosClasificacion(datosClasificacion[j - 1], datosClasificacion[j])) {
                    temp = datosClasificacion[j - 1];
                    datosClasificacion[j - 1] = datosClasificacion[j];
                    datosClasificacion[j] = temp;
                }
            }
        }
        return datosClasificacion;
    }

    private static boolean criteriosClasificacion(DatosClasificacion equipo1, DatosClasificacion equipo2) {
        if (equipo1.getPuntosTotales() > equipo2.getPuntosTotales()) {
            return true;
        } else if (equipo1.getPuntosTotales() < equipo2.getPuntosTotales()) {
            return false;
        } else if (equipo1.getDiferenciaGoles() < equipo2.getDiferenciaGoles()) {
            return true;
        } else if (equipo1.getDiferenciaGoles() > equipo2.getDiferenciaGoles()) {
            return false;
        } else {
            if (equipo1.getPartidosGanados() < equipo2.getPartidosGanados()) {
                return true;
            } else {
                return false;
            }
        }
    }

    //---------- Quick Sort --------//
// Ordenamos a los Porteros y Goleados con QuickSort
    public static Jugador[] ordenarJugadores(Jugador[] jugadores) {
        int izquierda = 0;
        int derecha = jugadores.length - 1;
        return recursiveQuick(jugadores, izquierda, derecha);
    }

    private static Jugador[] recursiveQuick(Jugador[] lista, int izquierda, int derecha) {
        Jugador pivote = lista[izquierda];
        int i = izquierda;
        int j = derecha;
        Jugador aux;
        while (i < j) {
            while (lista[i].getGol() >= pivote.getGol() && i < j) i++;
            while (lista[j].getGol() < pivote.getGol()) j--;
            if (i < j) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }

        }

        lista[izquierda] = lista[j];
        lista[j] = pivote;
        if (izquierda < j - 1) recursiveQuick(lista, izquierda, j - 1);
        if (j + 1 < derecha) recursiveQuick(lista, j + 1, derecha);
        return lista;
    }
    public static Jugador[] ordenarPorteros(Jugador[] jugadores) {
        int izquierda = 0;
        int derecha = jugadores.length - 1;
        return porterosQuick(jugadores, izquierda, derecha);
    }
    private static Jugador[] porterosQuick(Jugador[] lista, int izquierda, int derecha) {
        Jugador pivote = lista[izquierda];
        int i = izquierda;
        int j = derecha;
        Jugador aux;
        while (i < j) {
            while (lista[i].getParadas() >= pivote.getParadas() && i < j) i++;
            while (lista[j].getParadas() < pivote.getParadas()) j--;
            if (i < j) {
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
            }

        }

        lista[izquierda] = lista[j];
        lista[j] = pivote;
        if (izquierda < j - 1) porterosQuick(lista, izquierda, j - 1);
        if (j + 1 < derecha) porterosQuick(lista, j + 1, derecha);
        return lista;
    }


}