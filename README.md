# JavaUTN

# Sistema de Reporte de Incidentes

## Descripción del Proyecto

Este repositorio alberga el código fuente de un Sistema de Reporte de Incidentes creado para una empresa de soporte operativo. La aplicación facilita la generación, seguimiento y resolución de incidentes relacionados con diversas aplicaciones (SAP, Tango) y sistemas operativos (Windows, MacOS, Linux Ubuntu).

## Tecnologías Utilizadas

- **Backend**: Desarrollado en Java con el framework Spring Boot.
- **Base de Datos**: Se utiliza MySQL para almacenar información relacionada con incidentes, técnicos, clientes, etc.
- **Frontend**: La interfaz de usuario se ha implementado con Thymeleaf, un motor de plantillas para Java.

## Funcionalidades Principales

### Ciclo de Vida de un Incidente

1. **Registro del Incidente:**
   - La mesa de ayuda ingresa los datos del cliente en el sistema.
   - El cliente elige el servicio y proporciona una descripción del problema y su tipo.
   - El sistema muestra técnicos disponibles y estima el tiempo de resolución.
   - El operador selecciona un técnico, informa al cliente sobre la entrada del incidente y la fecha probable de resolución.

2. **Notificación al Técnico:**
   - Al confirmarse el incidente, el sistema notifica al técnico sobre el nuevo incidente pendiente.

3. **Resolución del Incidente:**
   - El técnico atiende y resuelve el incidente, marcándolo como "resuelto" e indicando observaciones necesarias.
   - El sistema envía un correo electrónico al cliente informando que su incidente ha sido solucionado.

### Otros Requerimientos

- **Reportes de RRHH:**
  - El área de RRHH puede generar reportes diarios con los incidentes asignados a cada técnico y su estado.

- **Colchón de Horas Estimadas:**
  - El operador puede agregar un colchón de horas estimadas para problemas considerados "complejos".

- **Registro de Incidentes Relacionados:**
  - El sistema permite el alta de incidentes que contienen un conjunto de problemas de un mismo servicio, estando estos relacionados.

- **Información sobre Técnicos:**
  - Se pueden obtener informes sobre el técnico con más incidentes resueltos en los últimos N días, el técnico con más incidentes resueltos de una especialidad específica en los últimos N días y el técnico que resolvió los incidentes más rápidamente.

