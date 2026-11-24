package app;

import model.Colaborador;
import service.GestorColaboradores;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorColaboradores gestor = new GestorColaboradores();

        try {
            gestor.cargarDesdeArchivo("resources/colaboradores.txt");

            System.out.println("TODOS LOS COLABORADORES VALIDOS");
            for (Colaborador colaborador : gestor.getColaboradores()) {
                System.out.println(colaborador);
            }

            System.out.println();
            System.out.println("BUSQUEDA POR NOMBRE: Paula");
            ArrayList<Colaborador> encontrados = gestor.buscarPorNombre("Paula");
            for (Colaborador colaborador : encontrados) {
                System.out.println(colaborador);
            }

            System.out.println();
            System.out.println("FILTRO POR ROL: Proveedor");
            ArrayList<Colaborador> proveedores = gestor.filtrarPorRol("Proveedor");
            for (Colaborador colaborador : proveedores) {
                System.out.println(colaborador);
            }

            System.out.println();
            System.out.println("Total de colaboradores validos: "
                    + gestor.getColaboradores().size());
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
