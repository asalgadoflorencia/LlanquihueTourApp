package service;

import model.Colaborador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorColaboradores {
    private ArrayList<Colaborador> colaboradores;

    public GestorColaboradores() {
        colaboradores = new ArrayList<>();
    }

    public void cargarDesdeArchivo(String rutaArchivo) throws IOException {
        colaboradores.clear();
        int numeroLinea = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] datos = linea.split(";");
                    if (datos.length != 8) {
                        throw new IllegalArgumentException(
                                "Se esperaban 8 datos separados por punto y coma.");
                    }

                    Colaborador colaborador = new Colaborador(
                            datos[1], datos[2], datos[3],
                            datos[4], datos[5], datos[6], datos[7], datos[0]);

                    if (correoYaRegistrado(colaborador.getCorreo())) {
                        throw new IllegalArgumentException("El correo ya esta registrado.");
                    }

                    colaboradores.add(colaborador);
                } catch (IllegalArgumentException e) {
                    System.out.println("Linea " + numeroLinea + " omitida: " + e.getMessage());
                }
            }
        }
    }

    public ArrayList<Colaborador> getColaboradores() {
        return new ArrayList<>(colaboradores);
    }

    public ArrayList<Colaborador> buscarPorNombre(String nombreBuscado) {
        ArrayList<Colaborador> resultados = new ArrayList<>();
        String texto = nombreBuscado.toLowerCase();

        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getNombre().toLowerCase().contains(texto)) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }

    public ArrayList<Colaborador> filtrarPorRol(String rolBuscado) {
        ArrayList<Colaborador> resultados = new ArrayList<>();

        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getRol().equalsIgnoreCase(rolBuscado)) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }

    private boolean correoYaRegistrado(String correo) {
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }
}
