package model;

import util.ValidadorDatos;


public class Persona {
    private String nombre;
    private String telefono;
    private String correo;
    private Direccion direccion;


    public Persona(String nombre, String telefono, String correo,
                   String calle, String numero, String comuna, String region) {
        setNombre(nombre);
        setTelefono(telefono);
        setCorreo(correo);
        this.direccion = new Direccion(calle, numero, comuna, region);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        ValidadorDatos.validarTexto(nombre, "nombre");
        this.nombre = nombre;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        ValidadorDatos.validarTelefono(telefono);
        this.telefono = telefono;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        ValidadorDatos.validarCorreo(correo);
        this.correo = correo;
    }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException("La direccion es obligatoria.");
        }
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion=" + direccion;
    }
}
