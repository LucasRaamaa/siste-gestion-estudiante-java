package com.gestionestudiantil;
import java.util.Scanner;

public class InputUtils {

  // Método para leer un número entero
  public static int leerEntero(Scanner sc, String mensaje) {
    while (true) {
      System.out.print(mensaje); // uso print para que quede en la misma línea
      String entrada = sc.nextLine();
      try {
        return Integer.parseInt(entrada); // si funciona, retorna el número
      } catch (NumberFormatException e) {
        System.out.println("Debe ingresar un número válido.");
      }
    }
  }

  // Método para leer un número decimal (double)
  public static double leerDouble(Scanner sc, String mensaje) {
    while (true) {
      System.out.print(mensaje);
      String entrada = sc.nextLine();
      try {
        return Double.parseDouble(entrada);
      } catch (NumberFormatException e) {
        System.out.println("Debe ingresar un número válido.");
      }
    }
  }

  // Método para leer un String no vacío
  public static String leerStringNoVacio(Scanner sc, String mensaje) {
    String texto;
    do {
      System.out.print(mensaje);
      texto = sc.nextLine().trim();
      if (texto.isEmpty()) {
        System.out.println("El texto no puede estar vacío.");
      }
    } while (texto.isEmpty());
    return texto;
  }
}
