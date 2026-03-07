import java.util.Date;

/**
 * Clase abstracta que representa a un trabajador genérico de la fábrica de vehículos.
 * Contiene los datos personales y laborales comunes a todos los perfiles de empleado.
 *
 * @author Jorge Martín Torrubia
 * @version 1.0
 */
public abstract class Trabajador {
    private String nombre;
    private String apellidos;
    private String DNI;
    private String direccion;
    private String numSeguridadSocial;
    private String puesto;
    private double salario;
    private Date fechaIngreso;

    /**
     * Constructor de Trabajador.
     *
     * @param nombre              Nombre del trabajador.
     * @param apellidos           Apellidos del trabajador.
     * @param DNI                 Documento Nacional de Identidad.
     * @param direccion           Dirección postal del trabajador.
     * @param numSeguridadSocial  Número de afiliación a la Seguridad Social.
     * @param puesto              Puesto de trabajo en la empresa.
     * @param salario             Salario mensual bruto en euros.
     * @param fechaIngreso        Fecha de incorporación a la empresa.
     */
    public Trabajador(String nombre, String apellidos, String DNI, String direccion,
                      String numSeguridadSocial, String puesto, double salario, Date fechaIngreso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.numSeguridadSocial = numSeguridadSocial;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene el nombre del trabajador.
     *
     * @return Nombre del trabajador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del trabajador.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del trabajador.
     *
     * @return Apellidos del trabajador.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del trabajador.
     *
     * @param apellidos Nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el DNI del trabajador.
     *
     * @return DNI del trabajador.
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Establece el DNI del trabajador.
     *
     * @param DNI Nuevo DNI.
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene la dirección del trabajador.
     *
     * @return Dirección postal.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del trabajador.
     *
     * @param direccion Nueva dirección postal.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de Seguridad Social del trabajador.
     *
     * @return Número de Seguridad Social.
     */
    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    /**
     * Establece el número de Seguridad Social del trabajador.
     *
     * @param numSeguridadSocial Nuevo número de Seguridad Social.
     */
    public void setNumSeguridadSocial(String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }

    /**
     * Obtiene el puesto del trabajador.
     *
     * @return Puesto de trabajo.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del trabajador.
     *
     * @param puesto Nuevo puesto de trabajo.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el salario mensual bruto del trabajador.
     *
     * @return Salario en euros.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario mensual bruto del trabajador.
     *
     * @param salario Nuevo salario en euros.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtiene la fecha de incorporación del trabajador a la empresa.
     *
     * @return Fecha de ingreso.
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de incorporación del trabajador.
     *
     * @param fechaIngreso Nueva fecha de ingreso.
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
