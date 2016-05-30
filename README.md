# DesarrolloAplicacionAndroid

Curso sobre desarrollo android , aquí incluiré todo lo relevante del curso dictado por la Univ de Galileo mediante la plataforma edX,
además de todos los códigos que realice.



## Clase 1 - Carácterísticas Generales

### Componentes de android
	1- Activity
	2- Services
	3- Broadcast receivers	
	4- ContentProvider

- 1,2 y 3  son activados por "intent"

- ContentProvider : maneja datos y es activado con "Content Resolver", no es tan común a menos que quiera exponer datos, no hay necesidad de usarlo si usas una BD SQL , pero es necesario usarlo si vas a exponer datos a terceros

2 tipos de "intent"
- definido por nosotros
- definido por el sistema



## Clase1 - Fragmentos

#### definicion
Un fragmento va a representar un cierto comportamiento o una porción de interfaz gráfica y SIEMPRE un fragmento pertenece  a una actividad 

#### Métodos dentro de los fragmentos

-onActivityCreated : se llama cuando la actividad es creada

- onCreateView : se tiene que "convertir" el archivo xml hacia algo que pueda visualizar de tal forma que tenga contenidos


### Formas de crear fragmento

- forma estática : en donde del xml yo agrego un componente y le coloco "FragmentName" y el nombre de la clase de mi fragmento y pongo todas las propiedas del fragmento

-forma dinámica: es cuando lo agrego con código en tiempo de ejecución por alguna razón necesito el fragmento y allí coloco los valores, se necesita un constructor vacío 

Dependiendo del caso de uso va a cambiar cual debemos usar.


### Opciones para desarrollar

- Usamos fragmentos y nos "sometemos" a este ciclo de vida tan complejo

- Decidimos no usarlos y nos quedamos sin ese apoyo de modularización

¿Qué otras cosas podemos elegir?

Ejemplos:

- 1 sola actividad y todo controlarlo por fragmento , para que sea más fácil este control usamos "Navigation manager"

"Navigation manager" sirve para saber de dónde vengo , a dónde voy , por qué estoy haciendo ese cambio


- Muchas actividades con vistas reutilizables que van a ir dentro de un fragmento que a su vez van a ir dentro de las actividades

- Puede incluir los fragmentos, pero para la comunicación haga uso de algo diferente a lo que el fragmento provee
¿cómo se comunica el fragmento con una actividad?
usualmente dentro del fragmento puedo ser un "getActivity" y dentro de la actividad, tengo mi listado de fragmentos o puedo obtener alguno dependiendo si es estático y dinámico y entonces usualmente defino una interfaz código de "JAVA" que uno de los dos componentes va a tener una instancia y el otro componente lo va implementar a través de esta interfaz, puedo enviar eventos de uno a otro,

-una alternativa a ello sería usar una librería como "Event Bus"

- programación reactiva (?)


## clase 1 - butterknight

- libreria butterknife : sirve para inyectar vistas(ya no se le llama "inyección si no vínculo("bain"))

- libreria dagger : sirve para inyectar dependencias 


existe un plugin en androidEstudio llamado "butterknife-zelezny" que permite crear estas "inyecciones" de forma automática


