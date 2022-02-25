import java.util.Scanner;

public class Examen {

	//************* Alumnos ************//

	public static void mostrarAlumno(Centro centro) {//Primer ejercicio. 1 Punto
		Alumno[] alumnos= centro.getAlumnos();

		//*************** Inicio Código ***************//
		// Está hecho, para que lo toméis como ejemplo
		if (alumnos!=null) {
			generarListado(alumnos);
			System.out.println("Escoge un Alumno:");
			int numeroAlumnos = alumnos.length;
			int opcion = MenuView.leerNumero() -1;
			if (opcion<numeroAlumnos) {
				Alumno alumno = alumnos[opcion];
				System.out.println(alumno.detail());
			}else {
				System.out.println("Ese alumno no existe.");
			}
		}else {
			System.out.println("No hay alumnos");
		}

		//**************** Fin Código ****************//
		MenuView.pressEnter();


	}

	public static void asignarCursoAlumno(Centro centro) {//Cuarto Ejercicio. 1 Punto

		//Generamos Listado y escogemos alumno

		Alumno[] alumnos= centro.getAlumnos();
		if (alumnos!=null) {
			generarListado(alumnos);
			int numeroAlumnos;
			int alumnoSeleccionado;
			int numeroCursos;
			int cursoSeleccionado;
			Curso[] cursos;
			System.out.println("Escoge un Alumno:");
			numeroAlumnos = alumnos.length;
			alumnoSeleccionado = MenuView.leerNumero() -1;
			// Generamos Listado y escogemos curso
			cursos = centro.getCursos();
			if (cursos!=null) {//Si hay curso lo seleccionamos
				generarListado(cursos);
				System.out.println("Escoge un Curso:");
				numeroCursos= cursos.length;
				cursoSeleccionado = MenuView.leerNumero() -1;

				if (alumnoSeleccionado<numeroAlumnos && cursoSeleccionado<numeroCursos) {//Si ambos estan
					//Este es el caso ideal, que tengamos alumnos y cursos. 
					//*************** Inicio Código ***************//

					//Voy a crear un alumno y voy a crear un curso y luego a añadirle el curso
					Alumno alumno = alumnos[alumnoSeleccionado];

					Curso curso = cursos[cursoSeleccionado];

					alumno.addCurso(curso);

					System.out.println("Curso añadido --> "+alumno.detail());

					//**************** Fin Código ****************//

				}else if (alumnoSeleccionado>=numeroAlumnos){// Si el alumno esta mal
					System.out.println("Ese alumno no existe.");
				}else {// Si el curso esta mal
					System.out.println("Ese curso no existe.");
				}
			}else {//Si no, indicamos que no hay cursos
				System.out.println("No hay cursos");
			}
		}else {// O bien no hay alumnos
			System.out.println("No hay alumnos");
		}

		MenuView.pressEnter();

	}

	public static void anadirAlumno(Centro centro) {// Sexto Ejercicio. 1 Punto
		System.out.println("Introduzca los datos del alumno:");

		Alumno alumno = new Alumno();
		Scanner sc = new Scanner (System.in);
		System.out.println("Nombre: ");
		alumno.setNombre(sc.nextLine());
		System.out.println("Apellidos: ");
		alumno.setApellidos(sc.nextLine());
		System.out.println("DNI/NIE: ");
		alumno.setDniNie(sc.nextLine());
		//No olvides considerar la posibilidad de que la lista de alumnos sea null

		//*************** Inicio Código ***************//
		Alumno[] alumnos1=centro.getAlumnos();
		int longitud = alumnos1.length;

		if (alumnos1!= null){

			//creo una lista que no esta vacia con una casilla mas +1
			Alumno [] listaAlumnos = new Alumno[longitud+1];

			for (int i = 0; i < longitud; i++) {
				listaAlumnos[i]=alumnos1[i];

			}
			listaAlumnos[longitud]=alumno;
			centro.setAlumnos(listaAlumnos);
		}


		//**************** Fin Código ****************//

		System.out.println("Alumno: "+alumno.toString()+" añadido");// Esto sale siempre. Compruebalo en el menu 1!!!
		MenuView.pressEnter();

	}


	//************* Profesores ************//

	public static void mostrarProfesor(Centro centro) {//Segundo Ejercicio. 1 Punto
		Profesor [] profesores = centro.getProfesores();

		//*************** Inicio Código ***************//
		if (profesores!=null) {
			generarListado(profesores);
			System.out.println("Escoge un Profesor:");
			int numeroProfesores = profesores.length;
			int opcion = MenuView.leerNumero() -1;
			if (opcion<numeroProfesores) {
				Profesor profesor = profesores[opcion];
				System.out.println(profesor.detail());
			}else {
				System.out.println("Ese profesor no existe.");
			}
		}else {
			System.out.println("No hay profesores");
		}

		//**************** Fin Código ****************//


		MenuView.pressEnter();

	}

	public static void anadirProfesor(Centro centro) {//Quinto Ejercicio. 1 Punto
		System.out.println("Introduzca los datos del profesor:");

		Profesor profesor = new Profesor();
		Scanner sc = new Scanner (System.in);
		System.out.println("Nombre: ");
		profesor.setNombre(sc.nextLine());
		System.out.println("Apellidos: ");
		profesor.setApellidos(sc.nextLine());
		System.out.println("DNI/NIE: ");
		profesor.setDniNie(sc.nextLine());
		//*************** Inicio Código ***************//

		// Me creo un array de profesores , aqui voy a guardar tods los profesores
		Profesor[] profesores=centro.getProfesores();
		int longitud = profesores.length;

		if (profesores!= null){

			//creo una lista que no esta vacia con una casilla mas +1
			Profesor [] listaProfesores = new Profesor[longitud+1];

			for (int i = 0; i < longitud; i++) {
				listaProfesores[i]=profesores[i];

			}
			listaProfesores[longitud]=profesor;
			centro.setProfesores(listaProfesores);
		}



		//**************** Fin Código ****************//

		System.out.println("Profesor: "+profesor.toString()+" añadido");// Esto sale siempre. Compruebalo en el menu 1!!!
		MenuView.pressEnter();


	}

	public static void asignarProfesorAsignatura(Centro centro) {//Octavo Ejercicio. 1 Punto
		//Generamos Listado y escogemos Profesor
		Profesor[] profesores= centro.getProfesores();
		if (profesores!=null) {//Si hay gente en la lista de profesores
			generarListado(profesores);
			System.out.println("Escoge un Profesor:");
			int numeroProfesores = profesores.length;
			int profesorSeleccionado = MenuView.leerNumero() -1;
			// Generamos Listado y escogemos curso
			Curso[] cursos = centro.getCursos();
			if (cursos!=null) {//Si hay cursos
				generarListado(cursos);
				System.out.println("Escoge un Curso:");
				int numeroCursos= cursos.length;
				int cursoSeleccionado = MenuView.leerNumero() -1;
				if (cursoSeleccionado<numeroCursos && profesorSeleccionado<numeroProfesores) {
					Curso curso = cursos[cursoSeleccionado];
					Profesor profesor = profesores[profesorSeleccionado];
					Asignatura[] asignaturas = curso.getAsignaturas();
					if (asignaturas!=null) {//Si esos cursos tienen asignaturas, entonces

						//*************** Inicio Código ***************//
						generarListado(asignaturas);
						System.out.println("Escoja una asignatura: ");
						int listaAsignaturas=asignaturas.length;
						int opcion=MenuView.leerNumero() -1;
						if (opcion > -1 && opcion < listaAsignaturas) {
							Asignatura asignatura = asignaturas[opcion];
							profesor.addAsignatura(asignatura);
							System.out.println(profesor.detail());

						}else if(opcion>=listaAsignaturas){
							System.out.println("La opcion selecionada no esta en la lista.");
						}



						//**************** Fin Código ****************//
					}else {
						System.out.println("Este curso no tiene asignaturas.");
					}

				}else if (cursoSeleccionado>=numeroCursos) {
					System.out.println("Curso Incorrecto.");
				}else {
					System.out.println("Profesor Incorrecto.");
				}
			}else {
				System.out.println("No hay cursos.");
			}
		}else {
			System.out.println("No hay profesores.");
		}

		MenuView.pressEnter();

	}


	//************* Cursos y Asignaturas ************//


	public static void mostrarAsignatura(Centro centro) {//Tercer Ejercicio. 1 Punto
		Curso[] cursos = centro.getCursos();
		//*************** Inicio Código ***************//
		if (cursos != null){
			generarListado(cursos);
			System.out.println("Escoge un curso");
			int numeroCursos = cursos.length;
			int opcion = MenuView.leerNumero() -1;
			if (opcion < numeroCursos){
				Curso curso = cursos[opcion];
				System.out.println(curso.detail());
			} else {
				System.out.println("Ese curso no existe");
			}
		} else {
			System.out.println("No hay cursos");
		}





		//**************** Fin Código ****************//
		MenuView.pressEnter();

	}

	public static void anadirCurso(Centro centro) {//Séptimo Ejercicio. 1 Punto

		Scanner sc = new Scanner(System.in);
		Curso curso = new Curso();
		System.out.println("Introduce el nombre del curso: ");
		String nombre = sc.nextLine();
		//*************** Inicio Código ***************//
			curso.setNombre(nombre);
			Curso[] cursos=centro.getCursos();
			int longitud = cursos.length;

			if (cursos!= null){

				Curso [] listaCursos = new Curso[longitud+1];

				for (int i = 0; i < longitud; i++) {
					listaCursos[i]=cursos[i];

				}
				listaCursos[longitud]=curso;
				centro.setCursos(listaCursos);
			}


		//**************** Fin Código ****************//
		generarListado(centro.getCursos());
		MenuView.pressEnter();

	}

	public static void anadirAsignatura(Centro centro) {//Noveno Ejercicio. 1 Punto

		//Metemos por teclado nombre de asignatura y la asignamos a un objeto
		System.out.println("Introduzca el nombre de la asignatura: ");
		Scanner sc =  new Scanner(System.in);
		String nombreAsignatura =  sc.nextLine();
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre(nombreAsignatura);


		// Generamos Listado y escogemos curso
		Curso[] cursos = centro.getCursos();
		if (cursos!=null) {//Si hay cursos
			generarListado(centro.getCursos());
			System.out.println("Escoge un Curso:");
			int numeroCursos= cursos.length;
			int cursoSeleccionado = MenuView.leerNumero() -1;

			//*************** Inicio Código ***************//










			//**************** Fin Código ****************//
		}else {//Si no hay cursos no se pueden añadir asignaturas
			System.out.println("No hay cursos, no se pueden añadir asignaturas");
		}
		MenuView.pressEnter();
	}

	public static void modificarAsignatura(Centro centro) {//Décimo Ejercicio. 1 Punto
		// Generamos Listado y escogemos curso
		Curso[] cursos = centro.getCursos();
		if (cursos!=null) {//Si hay cursos, entonces procedemos
			generarListado(centro.getCursos());
			System.out.println("Escoge un Curso:");
			int numeroCursos= cursos.length;
			int cursoSeleccionado = MenuView.leerNumero() -1;		

			//*************** Inicio Código ***************//
			
			
			
			
			
			
			
			
			

			//**************** Fin Código ****************//
		}else {//Si no hay cursos
			System.out.println("No hay cursos. No se pueden modificar asignaturas.");
		}
		MenuView.pressEnter();

	}


	//*************************** FUNCIONES INTERNAS ****************************	
	private static void generarListado(Object[] objects) {//Pasale un array de lo que quieras y te lo imprime
		int cont=1;
		for (Object o: objects) {
			String output = "-"+cont+"- "+o.toString();
			System.out.println(output);
			cont++;
		}

	}

}
