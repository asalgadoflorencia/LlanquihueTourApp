# LlanquihueTourApp

Aplicacion Java para registrar y consultar colaboradores de una agencia de turismo. Lee los registros desde un archivo de texto, valida sus datos, evita correos duplicados y permite buscar por nombre y filtrar por rol.

## Estructura del proyecto

```text
LlanquihueTourApp/
├── resources/
│   └── colaboradores.txt
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── model/
│   │   ├── Colaborador.java
│   │   ├── Direccion.java
│   │   └── Persona.java
│   ├── service/
│   │   └── GestorColaboradores.java
│   └── util/
│       └── ValidadorDatos.java
├── dist/
│   └── LlanquihueTourApp.jar
├── .gitignore
└── README.md
```

## Clases y paquetes

- `model.Persona`: guarda los datos comunes de una persona y contiene su direccion.
- `model.Direccion`: representa calle, numero, comuna y region.
- `model.Colaborador`: extiende `Persona` y agrega el rol de guia, operador o proveedor.
- `util.ValidadorDatos`: valida textos, telefonos, correos y roles permitidos.
- `service.GestorColaboradores`: lee el archivo, crea objetos, guarda los colaboradores en un `ArrayList`, omite datos invalidos o correos duplicados y permite buscar por nombre o filtrar por rol.
- `app.Main`: ejecuta la carga, muestra los registros y prueba busqueda y filtro.

## Archivo de datos

El archivo `resources/colaboradores.txt` contiene una persona por linea, con ocho campos separados por punto y coma:

```text
rol;nombre;telefono;correo;calle;numero;comuna;region
```

Los roles admitidos son `Guia`, `Operador` y `Proveedor`. Cada telefono debe tener entre 8 y 12 digitos. El correo se revisa con una validacion basica de formato. Si una fila no es valida o repite un correo, se informa y se omite; la lectura continua con las filas siguientes.

## Ejecutar desde IntelliJ IDEA

Abre la carpeta del proyecto, marca `src` como carpeta de fuentes si IntelliJ no lo hizo automaticamente y ejecuta `app.Main`. El directorio de trabajo debe ser la carpeta principal del proyecto, donde se encuentra `resources`.

## Compilar y ejecutar desde PowerShell

Ejecuta estos comandos desde la carpeta principal del proyecto:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -encoding UTF-8 -d out src\model\Direccion.java src\model\Persona.java src\model\Colaborador.java src\util\ValidadorDatos.java src\service\GestorColaboradores.java src\app\Main.java
java -cp out app.Main
```

## Crear y ejecutar el JAR

Despues de compilar, desde la carpeta principal del proyecto ejecuta:

```powershell
New-Item -ItemType Directory -Force dist | Out-Null
jar cfe dist\LlanquihueTourApp.jar app.Main -C out .
java -jar dist\LlanquihueTourApp.jar
```

El JAR usa `resources/colaboradores.txt` como archivo externo. Para ejecutarlo, manten la carpeta `resources` junto al proyecto y lanza el comando desde la carpeta principal.
