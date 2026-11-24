package model;

import util.ValidadorDatos;


public class Colaborador extends Persona {
    private String rol;


    public Colaborador(String nombre, String telefono, String correo,
                       String calle, String numero, String comuna, String region,
                       String rol) {
        super(nombre, telefono, correo, calle, numero, comuna, region);
        setRol(rol);
    }

    public String getRol() { return rol; }
    public void setRol(String rol) {
        ValidadorDatos.validarRol(rol);
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Colaborador{" + super.toString() +
                ", rol='" + rol + '\'' +
                '}';
    }
}
