# integradormarielagcw
Trabajo integrador para Backend 1 (Certified Tech Developer • Digital House) 

Aclaraciones (✿◡‿◡)

* La relación paciente / domicilio es unidireccional

* Los métodos CRUD están realizados para las tres entidades más importantes (Odontólogos, Pacientes y Turnos)

* Se está utilizando una versión de Java 11

* La URL de la base de datos en H2 es:


        jdbc:h2:~/db_clinicaOdontologicaMarielagcw

* La base de datos tiene un ddl-auto que es create-drop

* El puerto utilizado para todo es el 8080:


         http://localhost:8080/

* Los usuarios y contraseñas para acceder son:


        ADMINISTRADOR
        userName: 
            admin 
        password:
            adminPassword
        email:
            admin

        USER
        userName:
            user
        password:
            userPassword
        email:
            user

* Endpoints:
  

        http://localhost:8080/odontologos
        http://localhost:8080/pacientes
        http://localhost:8080/turnos

* Las colecciones de Postman tienen simulados los métodos post, getAll, getById, put y delete para las entidades Odontólogos, Pacientes y Turnos. Están probados los casos bases que devuelven respuestas 200ok. Pero también hay casos simulados para ver desde el front el mensaje que se muestra en caso de los siguientes errores:


    * Guardar Odontólogo sin nombre (nulo)
    * Guardar Odontólogo sin apellido (nulo)
    * Guardar Odontólogo sin matrícula (nulo)
    * Buscar Odontólogo con ID inexistente
    * Modificar Odontólogo con ID negativo
    * Modificar Odontólogo con los datos incompletos en el body
    * Eliminar Odontólogo con ID igual o menor a cero
    * Eliminar Odontólogo con ID inexistente
    * Buscar Paciente con ID negativo
    * Buscar Paciente con ID inexistente
    * Eliminar Paciente con ID inexistente
    * Guardar Turno con fecha y hora que ya fue ocupada
    * Guardar Turno sin fecha
    * Guardar Odontólogo / Paciente cuyo ID es inexistente
    * Buscar un Turno con ID inexistente


* Los Tests están planteados para revisar los métodos CRUD en las clases Service por cada entidad relevante, pero también se hace una testeo de ciertos campos importantes como nombre y apellido de las entidades. 


* Está desarrollada la vista en HTML usando JavaScript y Bootstrap, con ventanas de alerta para los casos en que se guarda o elimina exitosamente o alertando por un error en caso de que esté fallando el pedido a la aplicación. Desde el front se aplicaron campos requeridos para evitar modificaciones en los campos ID, a modo de ejemplo, pero no era el objetivo principal hacer énfasis en las validaciones de los formularios normalizando los objetos, sino que el objetivo principal es mostrar el funcionamiento de la aplicación desde el backend.  

* Repositorio GitHub → https://github.com/marielagcw/integradormarielagcw
