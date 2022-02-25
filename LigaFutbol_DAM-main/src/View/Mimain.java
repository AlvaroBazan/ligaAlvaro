package View;

import Model.DatosClasificacion;

import java.util.Arrays;

public class Mimain {
    public static void main(String[] args) {
        int[] listaDeNumeros = {1, 4, 5, 6, 8, 7, 50, 12, 1000};

        System.out.println(Arrays.toString(ordenarNumeros(listaDeNumeros)));
    }

    public static int[] ordenarNumeros(int[] listaOrdenada) {


        int n = listaOrdenada.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (criteriosClasificacion(listaOrdenada[j - 1], listaOrdenada[j])) {
                    temp = listaOrdenada[j - 1];
                    listaOrdenada[j - 1] = listaOrdenada[j];
                    listaOrdenada[j] = temp;
                }
            }
        }
        return listaOrdenada;

    }

    private static boolean criteriosClasificacion(int numero1, int numero2) {
        if (numero1 > numero2) {
            return true;
        } else
            return false;


        }

    }



