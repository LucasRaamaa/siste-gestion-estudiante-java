package com.gestionestudiantil;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SistemaEstudiantes sistema = new SistemaEstudiantes();
    int opcion;

    do {
      System.out.println("\n --- Sistema de Gestion de Estudiantes ---");
      System.out.println("1. Agregar Estudiante");
      System.out.println("2. Listar estudiante");
      System.out.println("3. Buscar estudiante por legajo");
      System.out.println("4. Eliminar estudiante");
      System.out.println("5. Reportes");
      System.out.println("6. Descargar reporte");
      System.out.println("0. Salir");

      //Leemos utils enteros para corroborar que no sean letras
      opcion = InputUtils.leerEntero(sc, "Ingrese una opcion: ");

      switch (opcion) {
        case 1:
          int legajo = InputUtils.leerEntero(sc, "ingrese legajo: ");
          // validamos que no exista el mismo legajo
          while(sistema.buscarPorLegajo(legajo)!=null){
            System.out.println("Ese numero de legajo existe. Ingrese otro");
            legajo = InputUtils.leerEntero(sc, "Ingrese lejago: ");
          }
          String nombre = InputUtils.leerStringNoVacio(sc, "Ingrese nombre: ");
          String carrera = InputUtils.leerStringNoVacio(sc, "Ingrese carrera: ");

          double promedio;
          while(true){
            promedio = InputUtils.leerDouble(sc, "Ingrese promedio (0-10): ");
            if (promedio >= 0 && promedio <= 10)
              break;
            else {
              System.out.println("el promedio debe estar entre 0 y 10");
            }
          }

          Estudiante nuevo = new Estudiante(legajo, nombre, carrera, promedio);
          sistema.agregarEstudiante(nuevo);
          break;

        case 2:
          sistema.listarEstudiantes();
          break;


        case 3:
          int buscarLegajo = InputUtils.leerEntero(sc, "Ingrese legajo a buscar: ");
          Estudiante encontrado = sistema.buscarPorLegajo(buscarLegajo);
          if(encontrado != null){
            System.out.println("Estudiante encontrado: "+ encontrado);
          }else{
            System.out.println("No existe estudiante con ese elegajo");
          }
          break;
        case 4:
          int eliminarLegajo = InputUtils.leerEntero(sc, "Ingrese legajo a eliminar: ");
          if(sistema.eliminarEstudiante(eliminarLegajo)){
            System.out.println("Estudiante eliminado.");
          }else{
            System.out.println("No se encontro el estudiante.");
          }
        case 5:
          if(sistema.cantidadEstudiantes() == 0) {
            System.out.println("No hay estudiantes cargados.");
          }else{
            System.out.println("\n --- Reportes ---");
            System.out.printf("Promedio general: %.2f\n", sistema.promedioGeneral());

            Estudiante max = sistema.maxPromedio();
            Estudiante min = sistema.minPromedio();
            System.out.println("Estudiante con mayor promedio: " + max);
            System.out.println("Estudiante con menor promedio: " + min);
          }
        case 6:

          System.out.print("\n¿Desea exportar el reporte a archivo? (S/N): ");
          String respuesta = sc.nextLine().trim().toLowerCase();
          if(respuesta.equals("s")){
            sistema.exportarReportes("Reporte_Estudiantes.txt");
          }
          break;



        case 0:
          System.out.println("Saliendo del sistema.");
          break;




        default:
          System.out.println("Opcion Invalida.");

      }
    } while (opcion != 0)
        ;
      sc.close();
    }
  }

