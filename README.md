# DesarrolloAplicacionAndroid

Curso sobre desarrollo android , aquí incluiré todo lo relevante del curso dictado por la Univ de Galileo mediante la plataforma edX,
además de todos los códigos que realice.


# Documentacion Oficial

https://developer.android.com/guide/index.html



# Lección 0

## Clase0_1 Características Generales

Componentes de android
	1- Activity
	2- Services
	3- Broadcast receivers	
	4- ContentProvider

- 1,2 y 3  son activados por "intent"

- ContentProvider : maneja datos y es activado con "Content Resolver", no es tan común a menos que quiera exponer datos, no hay necesidad de usarlo si usas una BD SQL , pero es necesario usarlo si vas a exponer datos a terceros

2 tipos de "intent"
- definido por nosotros
- definido por el sistema


## Clase0_2 Fragmentos

Un fragmento va a representar un cierto comportamiento o una porción de interfaz gráfica y SIEMPRE un fragmento pertenece  a una actividad 
 
Métodos dentro de los fragmentos

- onActivityCreated : se llama cuando la actividad es creada

- onCreateView : se tiene que "convertir" el archivo xml hacia algo que pueda visualizar de tal forma que tenga contenidos


Formas de crear fragmento

- forma estática : en donde del xml yo agrego un componente y le coloco "FragmentName" y el nombre de la clase de mi fragmento y pongo todas las propiedas del fragmento

- forma dinámica: es cuando lo agrego con código en tiempo de ejecución por alguna razón necesito el fragmento y allí coloco los valores, se necesita un constructor vacío 

Dependiendo del caso de uso va a cambiar cual debemos usar.


Opciones para desarrollar

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

- una alternativa a ello sería usar una librería como "Event Bus"

- programación reactiva (?)


## Clase0_3 Butterknight

- libreria butterknife : sirve para inyectar vistas(ya no se le llama "inyección si no vínculo("bain"))

- libreria dagger : sirve para inyectar dependencias 


existe un plugin en androidEstudio llamado "butterknife-zelezny" que permite crear estas "inyecciones" de forma automática


Instalar butterknife

simplemente ve a la pestaña File desde AndroidStudio, seleccionas de la lista donde dice Settings, te aparece una nueva ventana te ubicas en el listado de la parte izquierda donde dice Pluggins. Si te fijas en la parte de abajo te aparecerán tres botones selecciona el que dice Browse repositories.., luego en el buscador escribes Android ButterKnife Zelezny en la parte derecha te da una opción para instalar, lo instalas y luego te pide que reinicies el programa ya con eso lo tienes instalado.


## Configurar Genymotion

http://aegis.pe/como-configurar-genymotion-con-android-studio


# Lección 1:

## Código de Android Chat (cambian algunas cosas)
https://github.com/ykro/android-chat-firebase


# Lección 2:

## Código de Twitter app hecho por el presentador
https://github.com/ykro/android-twitter



# Lección 3

## Clase3_1 Retrofit

Retrofit : librería para hacer peticiones a un API, estas peticiones se pueden hacer de muchas maneras pero hacerlas manualmente usando un "Thread" o un "Assign Task" una petición de HTTP y haciendo el reconocimiento manualmente del JSON que nos devolvió,puede llegar a ser altamente ineficiente, hay varias opciones para hacer las peticiones

Actualmente una de las opciones más confiables , sencilla y usadas es retrofit.

La alternativa más conocida es "Volley" que es una librería que ofrece Google sin embargo en algunas estadísticas Retrofit tiene un rendimiento un poco mejor.

Lo que hace retrofit es que toma un API HTTP y lo convierte en una interfaz de java , básicamente tiene 2 partes: servicio y cliente.

Servicio: van a exponer este API, y allí nosotros especificamos, de qué forma, vamos a consumirlo, entonces ponemos el verbo, "GET", "POST" etcétera, el nombre del método y los parámetros

en el CLIENTE vamos a especificar como se realiza ese consumo,
entonces allí ponemos un URL base, ponemos si se va parsear con "JSON"
con "GSON" o con algún otra librería de reconocimiento de "JSON" y luego fuera de esto, tenemos un cliente, del que obtenemos un servicio, y sobre el servicio realizamos la llamada del método,

entonces el método del API por ejemplo
si tengo un método SEARCH, tengo un método GET NAME, tengo un método
LIST NAME, etcétera, se convierte en un método de la interfaz, entonces lo puedo acceder de forma local con código de JAVA, y por detrás, Retrofit, va ser esta consulta, y nos va presentar un resultado.

Cuando comparamos con alternativas, podemos ver que el desempeño de Retrofit es mejor, y creo que de cualquier forma es una buena idea usar una librería para esto, al igual que otras librerías, tiene que ir "envuelta", porque en el momento en que cambie eso nos puede afectar.

Para trabajarlo usamos el mismo caso, que en otras librerías usamos GRADLE y agregamos el soporte en las dependencias, una vez que ya lo tenemos agregado, vamos a definir una clase, que va ser el servicio.

Por ejemplo, podemos llamarle a esta clase, GIT HUB SERVICES y obtener un listado de REPORT de GITHUB y aquí especificamos el verbo luego cual es el ENDPOINT después del URL base luego podemos especificar que nos devuelve o podemos especificar si no devuelve nada, también el nombre del método y los parámetros, usualmente lo que va devolver es un CALLBACK con un objeto que nosotros definimos.

Los APIS muchas veces son diseñados por nosotros mismos y otras veces no, entonces de acuerdo a eso, es posible que sea una buena idea hacer un objeto por nosotros para recibir esa respuesta, hay veces que por ejemplo esperamos un listado, y la respuesta que viene del API incluye ese listado, pero en el nivel más alto es un objeto, es un objeto que incluye, no sé, talvez un conteo de elementos y como un elemento incluye el listado, entonces en ese caso no puedo indicarle a Retrofit que va recibir un listado de cosas, porque voy a usar algo, que haga ese reconocimiento.

Si especifico por ejemplo que recibió un listado de repositorios, ese objeto repositorio, es un modelo, una representación, una entidad, usualmente esto es un PLAIN OLD JAVA OBJECT(POJO) y por lo mismo, tiene que tener las propiedades que vienen en las definiciones de API, entonces ese modelo aunque no es parte de Retrofit, se da por hecho que lo tengo implementado, además del modelo, si acaso yo no quisiera todo, puedo agregarle una anotación de JSON IGNORE o dependiendo del procesador que estoy usando, pero además del modelo voy a tener un cliente, en el cliente voy a utilizar un BUILDER de Retrofit, específico cual es la URL base, especifico si quiero convertir de cierta forma, todas las propiedades de la petición y luego en base al servicio que definí, voy a construirlo, para construirlo voy a especificar la clase y uso un método CREATE de la instancia de Retrofit.

Ahora para usarlo, tengo dos formas de hacerlo síncrona o asíncrona:

Síncrona: va correr en el THREAD principal o en el THREADING que le indiquemos , y esto se utiliza, haciendo uso, de este servicio, sobre el que tengo un método, por ejemplo LIST REPOS, que era el que especificaba en mí ejemplos de mi listado de GITHUB entonces puedo decir "servicio.ListRepo" y como el parámetro que tenía allí, era el nombre de usuario, le mando ese nombre de usuario, es un método de JAVA pero Retrofit, lo está convirtiendo en un método que le va pedir algo al API, entonces para hacerlo síncrono ejecuto EXECUTE, entonces sobre este objeto, puedo ejecutar un método, ósea sobre el servicio, voy a obtener LIST REPO y sobre ello voy a hacer la llamada, esto no es tan común porque, yo estoy administrando los THREADS.

Lo común es que la petición sea ASÍNCRONA y que quiera que Retrofit, maneje esos THREADS por mí, entonces lo que vamos hacer allí, es construir una llamada, y sobre esa llamada vamos a poner en cola con el método "en queue" un CALLBACK para cuando concluya, la llamada del método que especifiqué, y esto CALLBACK va tener dos métodos, uno cuando funciono y otro cuando no, que se van a ejecutar de forma asíncrona, entonces no lo asigno, no digo por ejemplo, LIST, REPO LIST igual a "instancia.getRepos", porque eso seria síncrono, sino en vez de eso hago un "enqueue", Retrofit lo va manejar por mí.

Podría incluso, manipular un poco como se realiza esto, si acaso tengo muchas peticiones, esto por alguna razón tiende a pasar en aplicaciones empresariales que el BACKEND esta pensado en una forma extraña en la que hay que hacer muchas peticiones una vez cuando se inicializa y luego solo actualizaciones posteriores, con Retrofit.

Puedo además agregar programación reactiva, para realizar un encadenado de peticiones.

Por lo pronto pues la petición básica es la que nos interesa y hay mucha más información de Retrofit de como usarlo en su sitio oficial, lo que vamos a estar trabajando es Retrofit 2, y en base a esto, vamos a usar también un procesador para el reconocimiento de JSON que nos facilita la vida.

Resumiendo un poquito, Retrofit va tener un cliente y un servicio, el servicio expone el API de como hago la llamada, y el cliente ejecuta esa llamada y me permite especificar parámetros, puedo hacerlo de forma síncrona con EXECUTE o asíncrona haciendo un ENQUEUE a hacia la llamada y de cualquier forma voy a tener el resultado esperado o voy a tener algún error que se reporte, pero eso es lo que
hace Retrofit.




## Clase3_2 DBFlow

"DBFlow" es un "ORM", un "ORM" es un "Object Relational Mapper" que me va a permitir representar la base de datos como un objeto en un lenguaje de programación orientado a objetos.

Esto es muy conveniente porque entonces la tabla de mi base de datos relacional se va a representar como una clase dentro de mi lenguaje de programación orientado a objetos.

Una fila de esta tabla se va a representar como una instancia de la clase, y una columna dentro de esa fila se va a representar como una variable global o un campo que va a tener un "get" o un "set", dependiendo del caso que quiera sobre este objeto.

Particularmente en Android hay varias opciones para elegir dentro de los diferentes "ORMs" que se ofrecen:

"DBFLow" es uno que funciona bastante bien y está enfocado en que sea robusto, que sea rápido y que se pueda extender su funcionalidad.

La base del "ORM" son anotaciones, eso lo que va a provocar es que no sea tan sencillo encapsularlo, porque son anotaciones específicas las que va a utilizar.

Al compararlo con otros "ORMs":

"DBFlow" termina siendo más rápido para la mayoría de casos y la forma de utilizarlo es bastante intuitiva.

Para utilizarlo vamos a trabajar con anotaciones de "APT" igual que con "dagger". Ambos están basados fuertemente en anotaciones y lo agregamos en el archivo "gradle" de la raíz. Luego, en el archivo del app, siempre en "gradle" , vamos a agregar la referencia lo que es necesario para manejar todos los módulos de "DBFlow".


Una vez ya tenemos todo esto agregado hay que inicializar y definir la base de datos.
La inicialización y el destruir la referencia lo vamos a hacer en el "application class" usualmente, tenemos un "flow manager", sobre el que podemos inicializar y destruir.

Sobretodo la destrucción es importante cuando estamos trabajando con múltiples referencias hacia el mismo manager.

Entonces, en la aplicación tal vez no se note tanto, pero al hacer testing se va a notar más y luego que ya tengo la inicialización necesito especificar que va a haber una base de datos, entonces puedo tener múltiples, lo especifico con una clase, le coloco el nombre, y le coloco la versión.

Cuando hay cambios en las tablas es una buena práctica cambiar el nombre de la versión y esto permite que se actualice.

Luego así como definí la base de datos con una notación, en una clase de Java, vamos a hacer lo mismo para definir la tabla.
Entonces, necesito una notación para indicar que es una tabla, este objeto y lo voy a vincular con mi entidad o mi modelo o mi "Plain Old Java Object" como le querramos llamar de toda la estructura que estoy trabajando
en "MVP - Clean".

Entonces, además de lo que ya tengo, voy a agregar ciertas anotaciones como "@Column" para especificar una columna o "@PrimaryKey" para especificar cuál es la clave primaria.

Es muy importante que al elegir la clave primaria sepa que si quiero invocar un método del "ORM", es decir, si quiero guardar o actualizar este objeto, esta entidad, tiene que tener la clave primaria colocada, si es "null" simplemente no se va a guardar.

Además de estas anotaciones para la clave primaria y la columna, el resto de funcionalidad va a tener "gets" y "sets" y es un poquito estricto en cuanto al nombre si tengo un campo que se llama "nombre", por
ejemplo, "name", voy a esperar o más bien "DBFlow" va a esperar que tenga un "get" y un "set", "name". Si es diferente entonces me da un poquito de problema, lo puedo resolver con anotaciones,pero lo mejor es colocar esos nombres un poquito estandarizados.

Ya que definí la tabla, podría ser que necesite una asociación, también lo voy a definir con anotaciones, entonces la "foreign key" va a ir colocada de esta forma con anotaciones de una clase hacia otra y voy a poder agregar métodos para esa asociación de tal forma que cuando quiera agregar elementos sobre esta asociación que existe lo pueda agregar en una tabla, pero además agregue la referencia hacia la otra tabla.

Para hacer la consulta de datos puedo utilizar un "flow manager", que este maneja, por ejemplo "cashing", maneja actualización, o puedo utilizar un "select" un objeto "select" colocando las clausulas necesarias. Lo que hace "DBFlow" es me genera una clase de la tabla

Por ejemplo, si tengo un objeto, que voy a guardar un objeto receta de cocina, entonces, me va a generar una clase nueva que se llame "tabla" "guión bajo" "receta de cocina", y sobre este objeto va a tener todos los elementos, las propiedades que yo definí y luego ya puedo hacer estas consultas.


Además, extiende la funcionalidad, porque mi clase además de las anotaciones tiene que heredar de "base model" y entonces eso va a permitir que tenga métodos como "save", "delete", "update","exist" para asegurarme que existe en la base de datos, etcétera.

Al final lo que buscamos es que ese manejo de la base de datos no sea doloroso y algunas veces cuando trabajo SQL manualmente lo que da lugar es que tienda a ser complejo.

Entonces, en vez de eso recomiendo que usemos un "ORM" para agilizar el proceso de desarrollo pero a la vez que el "ORM" que elijamos sea una buena opción.

"Realm" es otro "ORM" que ha estado de moda recientemente y es interesante porque no está basado en "SQL".

La mayoría incluyendo "DBFlow", el de "green robot", "green down" están basados en "SQL" entonces dependen de "SQL" totalmente.

Ahora "Realm" toma un camino nuevo, implementa clases propias en temas más para el almacenamiento, lo que provoca que en algunos casos sea mucho más rápido, pero no tiene toda la implementación de "SQL", entonces si van a elegir "Realm" sepan eso y sepan que es una empresa la que está detrás de esto, entonces si por alguna razón hacen cambios que los pueden hacer cuando quieran, su código se va a ver afectado, tómenlo en cuenta, no es que sea una mala opción sino que implica muchas cosas elegirlo, por eso es que para el curso hemos elegido usar "SQL" con un "ORM" y elegimos "DBFlow".


## Clase3_3 Food2Fork

Para la aplicación que vamos a construir necesitamos recetas
que mostrar. Podríamos usar un "backend" propio, podríamos desarrollar nuestrar propias recetas, o podríamos usar el de alguien más; que eso es lo que vamos a hacer.

Hay muchos "APIs" que ofrecen acceso a comida, ingredientes. 

¿Por qué lo elegí? Porque me permite indicarle en la petición el identificador de una receta, y permite también que le indique el conteo de recetas que quiero. Entonces, si le envío un uno en ese conteo, y le envío un identificador que es un número aleatorio, voy a poder obtener una receta aleatoria.

No tengo ninguna garatía de nada, es decir el "API" no me está manejando que ese número aleatorio sea válido, etcétera.

Entonces, a base de ensayo y error pues determiné un rango más o menos de
donde se podían pedir recetas y con ese rango es con el que vamos a trabajar.

El "API" que me va a dar estas recetas, requiere registrarme y  tiene un cierto número de peticiones diarias que van a ser suficientes para nuestro caso y devuelve esta respuesta en un formato "json",
encontramos en su documentación oficial cuál es el formato y bueno, con este formato vamos a establecer un objeto que nos de esa respuesta, que tiene el conteo y el listado de recetas, ese listado va a tener
únicamente un elemento y sobre ese elemento voy a trabajar para mostrarlo en la aplicación.

Ese elemento trae varias propiedades, me interesan principalmente un identificador. Me interesa también que pueda tener la imagen, entonces, un URL de la imagen y me interesa también un URL hacia donde llevar al usuario para que vea más detalle. Eso no lo voy a mostrar
en mi app sino lo voy a hacer con una acción asociada.

Entonces, la requisición requieren un "API Key", que lo tengo que ir a pedir a este sitio. Un ordenamiento(sort) que lo vamos a hacer con una
letra "r", que es para indicar que son los más recientes, vamos a agregarle un conteo que es uno y en la página(page = random) le vamos a enviar "random". Con esto podemos agregar la funcionalidad del "API".

"Food2Fork" no es que sea el único "API", sino que a través
de este "API" puedo hacer las peticiones necesarias, esto es lo que me funciona y vamos a usarlo en conjunto con "retrofit".


## Clase3_4 Swipe

Para la interacción de la aplicación, vamos a manejar los botones
y un gesto de "Swipe".

La implementacion del gesto de "Swipe" la podríamos hacer con un
"view.pager" y permitirle al "view.pager" que lo maneje, pero como aquí tenemos una sola vista, no tenemos una colección de vistas, un adaptador tal vez es demasiado.

Entonces, en vez de eso, vamos a detectar manualmente el evento de "Swipe".

Ahora, no hay un "unswipe", lo que sí hay es un "SimpleOnGestureDetector" que tiene un evento "OnDown", un evento "OnUp" y un
evento "move". En base a eso, automáticamente maneja un evento "OnFling", entonces, yo voy a poder sobrecargar los métodos a partir de una clase que utilice este "SimpleOnGestureDetector" y cuando tenga el método "onDown" devolver "true" para indicar si lo estoy detectando
y luego cuando tenga "onfling" ahí colocar toda la lógica necesaria.

El "action code" que nos interesa es un "action_down", un "action_up" y un "action_move".

Voy a necesitar cierto movimiento y sobre el método "onfling" es que voy a realizar la implementación.

¿Qué voy a validar?
Que hay una distancia para saber que sí existe este "swipe", es decir,
que no sólo un movimiento sobre la pantalla, sino que si hay cierto movimiento y esa validación va a tener un "threshold" que debo superar en cuanto a distancia y en cuanto a velocidad.

Estas variables de la "x" y la "y", de dónde inició y hasta dónde llegó,
así como la velocidad las recibo en el método "onFling". Sobrecargándolo, lo voy a poder hacer con una serie de "if" y voy a agregar un "listener" para reaccionar ante ese evento.

Entonces, cuando sucede un "fling" que lleva cierta dirección y estoy haciendo un "swipe" hacia un lado, voy a reaccionar de cierta forma hacia la derecha, me quedo con la receta y hacia la izquierda, la desecho. Con estas dos clases "OnGestureDetector" y una interfaz que voy a eventualmente implementar en la actividad, voy a tener lo necesario para el manejo de "swipe".





