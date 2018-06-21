Para ejecutar la aplicación se utilizo Eclipse se puede descargar desde: http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/oxygen/3a/eclipse-java-oxygen-3a-win32-x86_64.zip

-El proyecto no contiene archivos de configuración de proyectos. Ni para el IDE Eclipse ni para el IDE IntelliJ IDEA.
Si se desea abrir el proyecto en alguno de estos Entornos de desarrollo Integrado, se puede realizar:
Una importación de "Proyecto Gradle"
Especificando la ubicación de la carpeta del proyecto y si es necesario, del archivo build.gradle presente en la raíz del proyecto

Descripcion Package y clases de la App

conmutadortrenes.app:Contiene la clase que ejecuta la  aplicacion.

conmutadortrenes.excepcion: Contiene las excepciones de la aplicacion.

conmutadortrenes.filtros: Contiene filtros par la busqueda de rutas entre ciudades. Existe un filtro para cada criterio de busqueda identificado en el ingreso de los datos.

conmutadortrenes.grafos: Contiene el modelamiento de la solucion mediante el uso de grafos. Dentro existen clases como Grafo, Arista, Vertice,GrafoDirigido.

conmutadortrenes.ingreso: Contiene clases que representan instrucciones a ejecutarse. Estas instrucciones se las construye de acuerdo a las entradas del usuario en el archivo de texto. Existen instrucciones para construir el grafo (Red Vial), buscar distancia mas corta, buscar posibles caminos, etc.

conmutadortrenes.servicio: Contiene una representacion del commutador de trenes de Kiwiland. Esta representacion es como una fachada que se apoya de los demas componentes y los engrana para asÃ­ concentrar todas las posibles opciones de procesamiento de la aplicaciÃ³n.


Ejemplo Archivo de Entrada
datos.txt

Grafo: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
The distance of the route A-B-C
The distance of the route A-D
The distance of the route A-D-C
The distance of the route A-E-B-C-D
The distance of the route A-E-D
The number of trips starting at C and ending at C with a maximum of 3 stops
The number of trips starting at A and ending at C with exactly 4 stops
The length of the shortest route (in terms of distance to travel) from A to C
The length of the shortest route (in terms of distance to travel) from B to B
The number of different routes from C to C with a distance of less than 30

EJEMPLO DE ARCHIVO DE SALIDA

9
5
13
22
NO SUCH ROUTE
2
3
9
9
7

