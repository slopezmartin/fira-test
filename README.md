SEED SERVICE
====================================

Responsable de la aplicación: David Hidalgo (dhidalgo@firabarcelona.com) 

Documentación (confluence): 
Backoffice: https://firabcn.atlassian.net/l/c/PNzbQtBL 

En caso de no tener acceso, solicitar acceso a la documentación o solicitar el documento pdf al área de Oficina Técnica.

Descripción Funcional
---------------------
La aplicación seed es un proyecto con 1 módulo:

- seed-service-apicore2 


El  proyecto debe ser descargado desde github solicitando acceso al área de Oficina Técnica.

El proyecto seed-service-apicore2 se ha creado para alojar un API Rest con lo mínimo necesario
 para desarrollar aplicaciones spring boot para Fira de Barcelona.


Objetivo
========
Este fichero sirve para instalar y arrancar el seed-service-apicore2 en nuestros equipos locales.

INSTALACIÓN DE SOFTWARE EXTERNO
===============================
Para realizar la instalación de los proyectos será necesario instalar el siguiente software:

Gradle
------
El proyecto seed-service-apicore2 tiene añadido el gradle wrapper, por lo que no es necesario descargarse manualmente la versión de gradle.

Intellij
--------
Para el desarrollo utilizamos Intellij por lo que el manual se basará en este IDE, si se desea cambiar de IDE se deberán hacer ajustes por vuestra parte.

Entornos
========
Hay 2 entornos en la aplicación.
- default
- local


Proyecto seed-service-apicore2
=============================

Previo al arranque
------------------
Para arrancar en local debemos estar conectados a la VPN de FIRA ya que la conexión con algunos servicios.

Arranque en local
-----------------
La aplicación de seed-service-apicore2 es SpringBoot por lo que bastará con hacer un bootRun para que la aplicación arranque.

Deberemos utilizar el profile : local

gradlew bootRun -Dspring.profiles.active=local

Versionado
----------
Para realizar un versionado se deberán subir los cambios a la rama master y modificar el fichero gradle.properties cambiando las siguientes propiedades:

serviceVersion -> Cambiar a la nueva versión
firaApiCoreVersion ->  Cambiar a la nueva versión (dependencia del framework de FIRA)

Después de realizar el merge de la rama con los cambios en la rama master y versionar se podrá abrir el SAU correspondiente para realizar la subida a producción.

Ficheros properties
-------------------
Existen 2 ficheros de properties que son muy importantes en la aplicación.

- application.properties
- application-local.properties

Cada fichero se utiliza en los entornos correspondientes siendo application-local.properties el utilizado en local.

La base de datos no debe exponerse nunca en los ficheros application.properties, application-development, application-staging y application-production, para cualquier modificación en el datasource se deberá hablar con sistemas.


