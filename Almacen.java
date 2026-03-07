
/**
 * Write a description of class Almacen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Almacen implements IAlmacen {
    private ArrayList<Motor> motores;
    private ArrayList<Tapiceria> tapicerias;
    private ArrayList<Rueda> ruedas;
    private ArrayList<Vehiculo> vehiculos;

    public Almacen() {
        motores = new ArrayList<>();
        tapicerias = new ArrayList<>();
        ruedas = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    @Override
    public void añadir(Object elemento) {
        // TODO: Nivel 2
    }

    @Override
    public Object consultar(String tipo) {
        // TODO: Nivel 2
        return null;
    }

    @Override
    public void actualizar(Object elemento) {
        // TODO: Nivel 2
    }

    public ArrayList<Motor> getMotores() {
        return motores;
    }

    public void setMotores(ArrayList<Motor> motores) {
        this.motores = motores;
    }

    public ArrayList<Tapiceria> getTapicerias() {
        return tapicerias;
    }

    public void setTapicerias(ArrayList<Tapiceria> tapicerias) {
        this.tapicerias = tapicerias;
    }

    public ArrayList<Rueda> getRuedas() {
        return ruedas;
    }

    public void setRuedas(ArrayList<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}