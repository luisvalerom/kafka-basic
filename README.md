# Proyecto ejemplo para integrar *Spring Boot* con un cluster de *Kafka*

Esta es una aplicación *Spring Boot* básica para implementar la producción y el consumo de mensajes en un cluster *Kafka* utilizando la dependencia *spring-kafka*.

Para el despliegue del cluster *Kafka* nos apoyamos en el [proyecto Kafka Base](https://github.com/luisvalerom/kafka_base).

Aprovechamos la integración por defecto que posee *Spring Boot* con *Logback* para configurar nuestra generación de logs, aspecto esencial de toda aplicación.

Creamos un proyecto modular con *Maven* y nos apoyamos en *Docker* para su despliegue.

Consiste de tres módulos: *common*, *consumer* y *producer*.  

*common*: Acá ubicamos código que es común para el resto del proyecto, por ejemplo: modelo, utilidades, etc.

*consumer*: Modulo que se encarga de conectarse al cluster *Kafka* y procesar los mensajes que llegan a un *topic* en especifico.

*producer*: Se encarga de generar los mensajes y enviarlos a un *topic* del cluster *Kafka*.



## Punto de inicio
- Desplegar el cluster *Kafka* siguiendo las indicaciones dadas en el [proyecto Kafka Base](https://github.com/luisvalerom/kafka_base).
- Para construir y desplegar la aplicación ejecutamos el script *run.sh*: `./run.sh`
- Para detener la ejecución de la aplicación utilizamos el script *stop.sh*: `./stop.sh`