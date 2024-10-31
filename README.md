# Proyecto de Algoritmos de Búsqueda - Spring Boot con AWS EC2
 
## Descripción
 
Este proyecto implementa dos algoritmos de búsqueda fundamentales: búsqueda lineal y búsqueda binaria. La aplicación está diseñada para ejecutarse en un entorno de microservicios en el que cada servicio de búsqueda está desplegado en instancias de EC2 de AWS. Un proxy recibe las solicitudes y las distribuye a las instancias de los servicios de búsqueda utilizando un algoritmo de round-robin.
 
## Los componentes principales del proyecto son:
 
 * Servicio de búsqueda lineal
 * Servicio de búsqueda binaria
 * Proxy para distribuir las solicitudes(Implemetado no Funcional)
 * Cliente web con HTML y JavaScript para interactuar con los servicios
 
 
## Tecnologías Utilizadas
 
* Java 8
* Spring Boot
* Maven
* HTML5 y JavaScript
* AWS EC2 para despliegue en la nube
 
 
## Estructura del Proyecto
 
![!\[alt text\](image.png)](src/main/resources/image.png)

## Configuración
 
1. Clona este repositorio en tu máquina local:

```
    git clone https://github.com/JohannBulls/ArepParcial.git
    cd ArepParcial
```
 
2. Asegúrate de tener Java 8 y Maven instalados.
 
 
3. Configura los puertos en los archivos application.properties o directamente en las clases. Los servicios de búsqueda deben ejecutarse en puertos distintos para que el proxy pueda redirigir las solicitudes adecuadamente.
 
 
4. Despliegue en AWS EC2:
 
Lanza tres instancias de EC2.
 
 
5. Ejemplo de Configuración en application.properties para el Proxy:
 ```
    http://localhost:8080/proxy/linearsearch?list=10,20,30&value=10
 ```
 
 
## Ejecución del Proyecto
 
## Ejecutar Servicios Localmente
 
1. Ejecuta el servicio de búsqueda lineal en el puerto 8081:
  ```
    mvn spring-boot:run -Dserver.port=8081
  ```
 
2. Ejecuta el servicio de búsqueda binaria en el puerto 8082:
  ```
    mvn spring-boot:run -Dserver.port=8082
  ```
 
3. Ejecuta el proxy en el puerto 8080:
  ```
    mvn spring-boot:run -Dserver.port=8080
  ```

![ !\[alt text\](image.png)](src/main/resources/image2.png)
 
##  Ejecutar en AWS EC2
 
Despliega cada servicio en una instancia de EC2, asegurándote de configurar los permisos para que las instancias puedan comunicarse entre sí.
 
Sigue los pasos de configuración en la sección de "Configuración" para ajustar las direcciones IP en el proxy.
 

## Ejemplo de Respuesta JSON
 
* Ejemplo de respuesta en caso de que el valor sea encontrado:
  ```
    {
        "operation": "linearSearch",
        "inputlist": "10,20,30",
        "value": "10",
        "output": 0
    }
  ```

* Ejemplo de respuesta en caso de que el valor no sea encontrado:

  ```
    {
        "operation": "binarySearch",
        "inputlist": "10,20,30",
        "value": "99",
        "output": -1
    } 
## Autores
 
Johann Amaya
 