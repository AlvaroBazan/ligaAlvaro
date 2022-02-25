package View;

import Model.*;
import Util.Ordenacion;
import Util.Repositorio;
import Util.Writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Principal {

	// Liga Automática
	private static final Liga ligaAutomatica = new Liga();
	private static final Equipo[] listaEquipos = ligaAutomatica.getEquipos();
	private static final Arbitro[] listaArbitros = ligaAutomatica.getArbitros();
	private static final Calendario calendario = ligaAutomatica.getCalendario();
	private static final Clasificacion clasificacion = ligaAutomatica.getClasificacion();

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
		System.out.println(Repositorio.menu);
		Scanner scanner = new Scanner(System.in);
		int entrada = scanner.nextInt();

			switch (entrada) {
				case 0:
					verClasificacion(clasificacion);
					esperaPulsacion();
					menuPrincipal();
					break;
				case 1:
					verListadoEquipos(listaEquipos);
					esperaPulsacion();
					menuPrincipal();
					break;
				case 2:
					verCalendario(calendario);
					esperaPulsacion();
					menuPrincipal();
					break;
				case 3:
					verLiga();
					esperaPulsacion();
					menuPrincipal();
					break;
				case 4:
					crearAlineacion1();
					esperaPulsacion();
					menuPrincipal();
					break;
				case 5:
					System.out.println("Estos son los máximos goleadores: ");
					verGoles(listaEquipos);
					esperaPulsacion();
					menuPrincipal();
					break;
				case 6:
					System.out.println("Ver mejores porteros");
					verMejoresPorteros(listaEquipos);
					esperaPulsacion();
					menuPrincipal();
					break;
				case 7:
					limpiarPantalla();
					esperaPulsacion();
					menuPrincipal();
					break;
				case 8:
					System.out.println("Ver la alineación de un partido de una jornada en concreto: ");
					alineacionPartido(calendario.getJornada());
					esperaPulsacion();
					menuPrincipal();
					break;
				default:
					System.out.println("***ATENCIÓN! Ese número no existe en el menú.***");
					esperaPulsacion();
					menuPrincipal();
			}
	}

	private static void verMejoresPorteros(Equipo[] listaEquipos) {
		int numeroPortero = 0;
		for (Equipo equipo: listaEquipos){
			for (Jugador jugador: equipo.getJugadores()){
				if (jugador.getPosicion().equals("Portero")) numeroPortero++;
			}
		}

		Jugador[] mejoresPortero = new Jugador[(numeroPortero)];
		int minimoPartidos = listaEquipos.length-1;

		int contador = 0;
		for (Equipo equipo : listaEquipos) {
			Jugador[] jugadores = equipo.getJugadores();
			for (Jugador jugadors : jugadores) {
				if (jugadors.getPosicion().equals("Portero")){
					mejoresPortero[contador] = jugadors;
					contador++;
				}
			}
		}



		for (Jugador j : Ordenacion.ordenarPorteros(mejoresPortero)) {
			if (j.getPartidoJugados() >= minimoPartidos){
				System.out.println("Nombre-> " + j.getNombre() + " " + j.getApellidos() + " Posicion -> "+j.getPosicion() + " ¡¡Paradas -> " + j.getParadas() +" !!" + " Equipo:" + j.getEquipo().getNombre());
			}
		}
	}

	private static void verClasificacion(Clasificacion clasificacion) {

		System.out.println(clasificacion.toString());
	}

	public static void crearAlineacion1(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("A que equipo le quiere poner la alineación\n");
		for (int i = 0; i < listaEquipos.length; i++) {
			System.out.println(" " + (i+1) + ") " + listaEquipos[i].getNombre());
		}
		System.out.println(" "+(listaEquipos.length+1) +") Salir ");

		int opcionEquipo = (scanner.nextInt()-1);

		if (opcionEquipo >= 0 && opcionEquipo < listaEquipos.length){
			System.out.println("Seleccione la alineacion que desee: ");

			for (int i = 0; i < Repositorio.formaciones.length; i++) {
				System.out.println("Opción "+(i+1)+":" + Repositorio.formaciones[i]);
			}
			System.out.println("Opcion " +(listaEquipos.length+1) + " Salir ");

			int opcion = (scanner.nextInt()-1);

			if (opcion >=0 && opcion< Repositorio.formaciones.length){

				Alineacion alineacionx = new Alineacion(listaEquipos[opcionEquipo].getJugadores(),opcion);

				System.out.println(alineacionx);
				//Fin

			} else if (opcion == listaEquipos.length){
				menuPrincipal();
				// Fin
			} else {
				limpiarPantalla();
				System.out.println("El número introducido no está en la lista.");
				System.out.println("Vuelva a introducir un numero de la lista. \n");
				crearAlineacion1();
			}
		} else if (opcionEquipo == listaEquipos.length){
			menuPrincipal();
		}else {
			limpiarPantalla();
			System.out.println("El número introducido no está en la lista.");
			System.out.println("Vuelva a introducir un numero de la lista. \n");
			crearAlineacion1();
		}

	}

	public static void esperaPulsacion() {
		Scanner sc= new Scanner(System.in);
		System.out.println();
		System.out.println("***Pulse enter para continuar en el programa. Gracias***");
		sc.nextLine();
		menuPrincipal();
	}

	private static void crearArchivos(Equipo[] listaEquipos){
		for (int i = 0; i < listaEquipos.length; i++) {
			Equipo equipo = listaEquipos[i];

			Jugador[] jugadors = equipo.getJugadores();
			for (int j = 0; j < jugadors.length; j++) {
				Jugador jugador = jugadors[j];
				Writer.EscribirJugadores(jugador);
			}
		}
	}

	private static void verGoles(Equipo[] listaEquipos) {
		int numeroGoleadores = 0;
		for (Equipo equipo: listaEquipos){
			for (Jugador jugador: equipo.getJugadores()){
				numeroGoleadores++;
			}
		}

		Jugador[] maximosGoleadores = new Jugador[(numeroGoleadores)];

		int contador = 0;
		for (Equipo equipo : listaEquipos) {
			Jugador[] jugadores = equipo.getJugadores();
			for (Jugador jugadors : jugadores) {
				maximosGoleadores[contador] = jugadors;
				contador++;
			}
		}

		for (Jugador j : Ordenacion.ordenarJugadores(maximosGoleadores)) {
			if(j.getGol() > 0) {
				System.out.println("Nombre-> " + j.getNombre() + " " + j.getApellidos() + " Goles-> " + j.getGol() + " Equipo:" + j.getEquipo().getNombre());
			}
		}
	}

	private static void verLiga(){

		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el nombre de la liga: ");
		String nombre = scanner.nextLine();
		System.out.print("Introduce el número de equipos (Entre 4-20): ");
		int numequipos= scanner.nextInt();
		System.out.print("Introduce la edad de los jugadores (Entre 4-18): ");
		int edadjug=scanner.nextInt();
		System.out.print("Introduce el número de jugadores (Entre 20-253): ");
		int numJugadores=scanner.nextInt();

		Liga liga= new Liga (nombre,numequipos,edadjug,numJugadores, (numequipos-1)*2);

		System.out.println(liga.toString());
	}

	private static void verCalendario(Calendario calendario) {
		Jornada[] jornadas = calendario.getJornada();

		System.out.println("Listado de Jornadas de la Liga \n" +
				" \n" +
				"¿Qué número de jornada quieres ver? \n");

		for (int i = 0; i < jornadas.length; i++) {
			System.out.println("    Jornada nº"+(i+1)+") "+jornadas[i].getNumeroJornada()+" "+jornadas[i].getFecha());

		}
		System.out.println("    "+(jornadas.length+1)+") Salir ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione la jornada que desea ver: ");
		System.out.print("-> ");

		int entradaJornada = (scanner.nextInt()-1);

		if (entradaJornada >=0 && entradaJornada< jornadas.length){
			limpiarPantalla();
			verJornada(jornadas[entradaJornada]);
		} else if (entradaJornada == jornadas.length){
			limpiarPantalla();
			menuPrincipal();
		} else {
			limpiarPantalla();
			System.out.println("El número introducido no está en la lista.");
			System.out.println("Vuelva a introducir un numero de la lista");
			verCalendario(calendario);
		}

	}

	private static void verListadoEquipos(Equipo[] listaEquipos) {

		System.out.println( " Listado de Equipos de la Liga \n" +
				" \n" +
				" ¿Qué equipo quieres ver de entre los "+listaEquipos.length+" que existen? \n");

		for (int i = 0; i < listaEquipos.length; i++) {
			System.out.println("    "+(i+1)+") "+listaEquipos[i].getNombre());
		}
		System.out.println("    "+(listaEquipos.length+1)+") Salir ");

		Scanner scanner = new Scanner(System.in);
		System.out.print("-> ");
		int entrada = scanner.nextInt()-1;

		if (entrada >=0 && entrada< listaEquipos.length){
			verEquipo(listaEquipos[entrada]);
		}else if (entrada == listaEquipos.length){
			menuPrincipal();
		} else {
			limpiarPantalla();
			System.out.println("El número introducido no está en la lista.");
			System.out.println("Vuelva a introducir un numero de la lista");
			verListadoEquipos(listaEquipos);

		}
	}

	private static void verJornada(Jornada jornada){
		System.out.println("Estos son los partidos de la Jornada "+jornada.getNumeroJornada() + "\n\n");
		for (int i = 0; i < jornada.getPartido().length; i++) {
			System.out.println(" "+ (i+1)+" "+ jornada.getPartido()[i]);
		}
	}

	private static void verEquipo(Equipo equipo){
		System.out.println("Estos son los jugadores del Equipo ");
		for (int i = 0; i < equipo.getJugadores().length; i++) {
			System.out.println(" "+ (i+1)+" "+ equipo.getJugadores()[i].getNombre()+" "+
					equipo.getJugadores()[i].getApellidos()+" "+ equipo.getJugadores()[i].getPosicion()+" "+ equipo.getJugadores()[i].getDorsal());
		}
	}

	private static void limpiarPantalla(){ for (int i = 0; i < 50; i++) System.out.println(""); }

	private static void pausaPantalla(){
		Scanner scanner = new Scanner(System.in);
		scanner.next();
	}

	private static void alineacionPartido(Jornada[] jornadas) {
		Partido[] partidos = new Partido[jornadas[0].getPartido().length];

		// Bucle que recorre las jornadas
		for (int i = 0; i < jornadas.length; i++) {
			System.out.println(jornadas[i].getNumeroJornada());
		}
		System.out.println((jornadas.length+1)+" Salir\n");

		System.out.println("Seleccione el número de jornada: ");
		int jornada = scanner() - 1;


		if(jornada >= 0 && jornada < jornadas.length) {
			// Bucle que recorre los partidos
			for (int i = 0; i < partidos.length; i++) {
				System.out.println("Partido numero " + (i + 1) + jornadas[jornada].getPartido()[i]);
			}
		} else if(jornada== jornadas.length+1){
				menuPrincipal();
		}else{
			limpiarPantalla();
			System.out.println("El número introducido no está en la lista.");
			System.out.println("Vuelva a introducir un numero de la lista");
			alineacionPartido(jornadas);


		}


		System.out.println("Seleccione el partido de la jornada: ");
		int partido = scanner() - 1;

		if(partido >= 0 && partido < partidos.length) {
			System.out.println("ALINEACIÓN EQUIPO LOCAL\n");
			System.out.println(jornadas[jornada].getPartido()[partido].getAlineacionLocales());
			System.out.println("\n ALINEACIÓN EQUIPO VISITANTE \n");
			System.out.println(jornadas[jornada].getPartido()[partido].getAlineacionVisitantes());
		}
	}

	private static int scanner() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
