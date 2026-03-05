
/**
 * Write a description of class Operario here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Operario extends Trabajador {

   public Operario(String nombre, String DNI, String dirección, String numSeguridadSocial, String puesto,
         double salario, String fechaIngreso) {
      super(nombre, DNI, dirección, numSeguridadSocial, puesto, salario, fechaIngreso);

   }

}
