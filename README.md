# Botfluencer
Botfluencer es un robot web para la red social instagram

# Funcionamiento base de la aplicación
La aplicación necesitará 9 perfiles existentes en Instagram. La aplicación se centrara en hacer follow/unfollow a los últimos 110 seguidores de cada una de las cuentas que tu hayas indicado.

# Modo de uso
* Run configuration => Run As Server Application
![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura1.PNG?raw=true)
* Al inicial la aplicación acceder a la URL:
```
localhost:8080/Botfluencer
```
* Una vez dentro podrás indicar tus credenciales para acceder a instagram a través de la aplicación
![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura2.PNG?raw=true)
* Cuando hayas accedido la aplicación intentará asegurarse de que las credenciales son válidas iniciando sesión
![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura3.PNG?raw=true)
* Cuando la sesión se haya iniciado correctamente accederás a un panel de configuración para configurar el uso de la cuenta
![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura4.PNG?raw=true)
  * La lista de 9 inputs es donde debes indicar los usuarios que quieres usar para el proceso de automatización de esta aplicación
  * El checkbox 'Hacer unfollow' marcará si la aplicación debe tambuén realizar unfollow en su proceso
  * El checkbox 'Perfiles privados' indicará si la aplicación seguirá también a cuentas de usuario privadas o no
 * Una vez que todo esté configurado bastará con pulsar el botón bajo el formulario para cargar esa configuración en la aplicación y aparecerá esta ventana en el navegador
 ![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura5.PNG?raw=true)
 * Al clicar el botón de dicha página el robot comenzará a realizar todas las tareas de automatización
 ![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura6.PNG?raw=true)
 ![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura7.PNG?raw=true)
 ![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura8.PNG?raw=true)
 ![Alt Text](https://github.com/JorgeRZT/Botfluencer/blob/master/WebContent/captura9.PNG?raw=true)




# Tecnologías y Lenguajes utilizados
* Java
* HTML
* Java Server Pages
* Maven
* Servlet
* Apache TomCat 9.0
