package model;

import util.ValidadorDatos;


public class Direccion {
    private String calle;
    private String numero;
    private String comuna;
    private String region;


    public Direccion(String calle, String numero, String comuna, String region) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
        setRegion(region);
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) {
        ValidadorDatos.validarTexto(calle, "calle");
        this.calle = calle;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) {
        ValidadorDatos.validarTexto(numero, "numero");
        this.numero = numero;
    }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) {
        ValidadorDatos.validarTexto(comuna, "comuna");
        this.comuna = comuna;
    }

    public String getRegion() { return region; }
    public void setRegion(String region) {
        ValidadorDatos.validarTexto(region, "region");
        this.region = region;
    }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna + ", " + region;
    }
}
