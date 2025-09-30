package com.gestionestudiantil;
import java.util.ArrayList;
import java.io.*;
import javax.swing.ButtonGroup;


public class SistemaEstudiantes {

  private ArrayList<Estudiante> estudiantes;
  private final String archivo = "estudiantes.txt";


  public SistemaEstudiantes() {
    estudiantes = new ArrayList<>();
    cargarDesdeArchivo(); // lee los datos ya guardados
  }


  public void agregarEstudiante(Estudiante e) {
    estudiantes.add(e);
    guardarEnArchivo(e); // Guarda automaticamente en el archivo
    System.out.println("Estudiante agregado con exito.");
  }

  public void listarEstudiantes() {
    if (estudiantes.isEmpty()) {
      System.out.println("No hay estudiantes cargados.");
    } else {
      for (Estudiante e : estudiantes) {
        System.out.println(e);
      }
    }
  }

  public Estudiante buscarPorLegajo(int legajo) {
    for (Estudiante e : estudiantes) {
      if (e.getLegajo() == legajo) {
        return e;
      }
    }
    return null;
  }

  public boolean eliminarEstudiante(int legajo) {
    Estudiante e = buscarPorLegajo(legajo);
    if (e != null) {
      estudiantes.remove(e);
      sobrescribirArchivo(); // actualiza archivo al eliminar
      return true;
    }
    return false;
  }

  // --- presistencia en el archivo ---

  private void guardarEnArchivo(Estudiante e) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
      bw.write(e.getLegajo() + ";" + e.getNombre() + ";" + e.getCarrera() + ";" + e.getPromedio());
      bw.newLine();
    } catch (IOException ex) {
      System.out.println("Error al guardar en archivo: " + ex.getMessage());
    }
  }

  private void cargarDesdeArchivo() {
    File f = new File(archivo);
    if (!f.exists())
      return; // si no existe, no hace nada

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(";");
        if (datos.length == 4) {
          int legajo = Integer.parseInt(datos[0]);
          String nombre = datos[1];
          String carrera = datos[2];
          double promedio = Double.parseDouble(datos[3]);
          estudiantes.add(new Estudiante(legajo, nombre, carrera, promedio));
        }
      }
    } catch (IOException e) {
      System.out.println("❌ Error al leer archivo: " + e.getMessage());
    }
  }
  private void sobrescribirArchivo() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
      for (Estudiante e : estudiantes) {
        bw.write(e.getLegajo() + ";" + e.getNombre() + ";" + e.getCarrera() + ";" + e.getPromedio());
        bw.newLine();
      }
    } catch (IOException e) {
      System.out.println("❌ Error al sobrescribir archivo: " + e.getMessage());
    }
  }


  //Calculamos promedio general
public double promedioGeneral(){
    if(estudiantes.isEmpty()) return 0;
    double suma = 0;
    for(Estudiante e : estudiantes){
      suma += e.getPromedio();
    }
    return suma / estudiantes.size();
}

//estudiante con mayor promedio
  public Estudiante maxPromedio(){
    if(estudiantes.isEmpty())return null;
    Estudiante max = estudiantes.get(0);
    for(Estudiante e : estudiantes){
      if(e.getPromedio() >  max.getPromedio()){
        max = e;
      }
    }
    return max;
  }
// estudiante con menor promedio

  public Estudiante minPromedio(){
    if(estudiantes.isEmpty()) return null;
    Estudiante min = estudiantes.get(0);
    for(Estudiante e: estudiantes){
      if(e.getPromedio() < min.getPromedio()){
        min = e;
      }
    }
    return min;
  }

  public int cantidadEstudiantes(){
    return estudiantes.size();
  }

// Exportamos a un archivo
  public void exportarReportes(String nombreArchivo){
    if(estudiantes.isEmpty()){
      System.out.println("No hay estudiantes cargados para exportar.");
      return;
    }
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))){
      bw.write("====================================\n");
      bw.write("     Reporte de Estudiantes          \n");
      bw.write("====================================\n\n");

      bw.write("Total de estudiantes: "+ estudiantes.size()+ "\n");
      bw.write(String.format("Promedio general: %.2f\n\n", promedioGeneral()));

      bw.write("Estudiante con mayor promedio: \n");
      bw.write("    "+ maxPromedio() + "\n\n");

      bw.write("Estudiante con menor promedio: \n");
      bw.write("     "+ minPromedio() + "\n\n");

      bw.write("Listado completo de estudiantes: \n");
      for(Estudiante e : estudiantes){
        bw.write("    - " + e + "\n");
      }

      bw.write("\n====================================\n");
      bw.write("Fin del reporte");

      System.out.println("Reporte exportado correctamente a "+ nombreArchivo);
    }catch (IOException e){
      System.out.println("Error al exportar reporte: "+ e.getMessage());
    }
  }


}

