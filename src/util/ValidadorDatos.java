package util;

/**
 * Reune validaciones sencillas que se pueden reutilizar en las clases del modelo.
 */
public final class ValidadorDatos {
    private ValidadorDatos() {
        // Esta clase solo ofrece metodos estaticos; no se crean objetos de ella.
    }

    /** Comprueba que un texto tenga contenido. */
    public static void validarTexto(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + nombreCampo + " es obligatorio.");
        }
    }

    /** Comprueba que un telefono contenga entre 8 y 12 digitos. */
    public static void validarTelefono(String telefono) {
        validarTexto(telefono, "telefono");
        String soloDigitos = telefono.replace(" ", "").replace("+", "");
        if (soloDigitos.length() < 8 || soloDigitos.length() > 12) {
            throw new IllegalArgumentException("El telefono debe tener entre 8 y 12 digitos.");
        }
        for (int i = 0; i < soloDigitos.length(); i++) {
            if (!Character.isDigit(soloDigitos.charAt(i))) {
                throw new IllegalArgumentException("El telefono solo puede contener digitos, espacios o +.");
            }
        }
    }

    /** Comprueba de forma basica que un correo tenga texto antes y despues de @ y un punto. */
    public static void validarCorreo(String correo) {
        validarTexto(correo, "correo");
        int arroba = correo.indexOf('@');
        int punto = correo.lastIndexOf('.');
        if (arroba <= 0 || punto <= arroba + 1 || punto == correo.length() - 1) {
            throw new IllegalArgumentException("El correo no tiene un formato valido.");
        }
    }

    /** Comprueba que el rol corresponda a uno de los colaboradores admitidos. */
    public static void validarRol(String rol) {
        validarTexto(rol, "rol");
        if (!rol.equalsIgnoreCase("Guia")
                && !rol.equalsIgnoreCase("Operador")
                && !rol.equalsIgnoreCase("Proveedor")) {
            throw new IllegalArgumentException("El rol debe ser Guia, Operador o Proveedor.");
        }
    }
}
