package com.gestionestudiantil;

public class Estudiante {
  private int legajo;
  private String nombre;
  private String carrera;
  private double promedio;

  public Estudiante(int legajo, String nombre, String carrera, double promedio){
    this.legajo = legajo;
    this.nombre = nombre;
    this.carrera = carrera;
    this.promedio = promedio;
  }
  public int getLegajo(){
    return legajo;
  }
  public String getNombre(){
    return nombre;
  }
  public String getCarrera(){
    return carrera;
  }
  public double getPromedio(){
    return promedio;
  }

  public void setCarrera(String carrera) {
   this.carrera = carrera;
  }


    @Override
    public String toString(){
      return "Estudiante {" +
          "legajo: "+ legajo +
          ", Nombre: "+ nombre +
          ", Carrera: "+ carrera +
          ", Promedio: " + promedio +
          "}";
    }

}
