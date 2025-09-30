#Sistema de Gestión de Estudiantes en Java

Proyecto en **Java** para gestionar estudiantes desde consola.  
Incluye persistencia en archivo y generación de reportes.

#Funcionalidades
- Agregar estudiante (legajo, nombre, carrera, promedio).
- Listar todos los estudiantes.
- Buscar estudiante por legajo.
- Eliminar estudiante.
- Reportes:
  - Promedio general.
  - Estudiante con mayor promedio.
  - Estudiante con menor promedio.
  - Exportación de reportes a archivo `.txt`.

#Tecnologías
- Java 17+
- Programación Orientada a Objetos (POO)
- Manejo de archivos (`FileWriter`, `BufferedReader`)
- Validaciones de entrada con `InputUtils`

#Ejecución
Compilar:
```bash
javac src/com/gestionestudiantil/*.java
