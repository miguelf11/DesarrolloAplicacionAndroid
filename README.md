# DesarrolloAplicacionAndroid

Curso sobre desarrollo android , aquí incluiré todo lo relevante del curso dictado por la Univ de Galileo mediante la plataforma edX, además de todos los códigos que realice.


## Tabla de contenidos

* [Documentación Oficial](#documentación-oficial)
* [Genymotion](#configurar-genymotion)
* [Semana 0](#lección-0)
* [Semana 1](#lección-1)
* [Semana 2](#lección-2)
* [Semana 3](#lección-3)
* [Semana 4](#lección-4)



## Documentación Oficial
https://developer.android.com/guide/index.html


## Configurar Genymotion
http://aegis.pe/como-configurar-genymotion-con-android-studio



# Lección 0

## Tabla de contenidos

* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Características Generales](#clase0_1-características-generales)
* [Fragmentos](#clase0_2-fragmentos)
* [Butterknight](#clase0_3-butterknife)
* [Layouts](#clase0_4-layouts)
* [Inputs Controls](#clase0_5-inputs-controls)
* [Recycler View](#clase0_6-recycler-view)
* [Implementación de los componentes](#clase0_7-implementación-de-los-componentes)



## Clase0_1 Características Generales


* [Regresar a la lección](#lección-0)

Es importante cuando empezamos, considerar los recursos, incluyendo el poder de procesamiento, la memoria, los diferentes tipos de pantalla, y las resoluciones que se tienen, nos van a permitir explorar las diferentes opciones que el Hardware tiene.Otros aspectos importantes, son por ejemplo, la transferencia de datos y la batería.

Android tiene cierta anatomía que arranca desde el "kernel" de "Linux" esta es la base, no tenemos un gestor de ventanas, no tenemos por ejemplo: librerías, estándar que soporta "Linux" únicamente toda la parte de administración, los componentes principales, y esto se complementa con algunas otras cosas desarrolladas específicamente para móviles.

Luego sobre esta parte del "kernel de Linux" vamos a tener librerías y el "RunTime", "RunTime" que solía ser "Dalvik" y desde hace un par de versiones se modificó, actualmente  es "ART"(Aged of Time RunTime) que compila todo, antes de que se ejecute, esto provoca que cuando estamos actualizando sea mucho más lento.

A veces talvez han visto teléfonos que tienen "ART" que dice optimizando aplicación uno de ciento cincuenta, dos de ciento cincuenta, etcétera, pero al ejecutar es mucho más rápido, porque esta previamente compilado, a diferencia que "Dalvik" lo compilaba en el momento, otra cosa es que esto va ocupar más espacio, sobre este "RunTime" vamos a tener un conjunto de aplicaciones que el "Framework" provee, últimamente mucho de esto se ha centrado se ha centrado sobre "GooglePlay Services" y en "GooglePlay Services" lo que ha hecho "Google" es intentar reducir la fragmentación, que están conscientes que existe, entonces no necesitamos actualizar la versión de "Android" por completo, sino únicamente una parte, el componente de "Play Services" y en la parte superior de esta anatomía que es como una pirámide vamos a tener las aplicaciones, allí es donde vamos a trabajar nosotros como desarrolladores de "Android" y vamos hacer
uso de todo lo que esta hacia abajo.

Por ejemplo cuando utilizo un "Intent" este "Intent" eventualmente tiene, como una conexión con la parte más baja del "kernel de Linux" en donde hace uso
de la comunicación entre procesos y eventualmente permite que el usuario, arranque con una actividad diferente ya sea de la misma aplicación o de otra.

Componentes de android
	1- Activity
	2- Services
	3- Broadcast receivers	
	4- ContentProvider

Las actividades(activity) son las pantallas que el usuario ve dentro de la aplicación, una actividad se va mostrar a la vez y nada más que una, pero la aplicación puede tener múltiples actividades.

Además es posible, que tenga una porción de mi aplicación que no requiere de una interfaz gráfica que no se ve, esto se llama un servicio("Service") de forma intuitiva a veces creemos que los servicios tienen su propio hilo de ejecución y esto no es así, vale la pena tener en mente, que los servicios, no tienen su propio "Thread ", va a ejecutarse en el "Main Thread" sin embargo eso no quiere decir que, implique que van a tener una parte visible.Por ejemplo, el reproductor musical es un ejemplo de un servicio.

Además de estos dos, vamos a tener los receptores de difusión o "Broadcast receivers" que van a capturar en el momento del que se emita, una difusión o un "Broadcast".

Los tres "Activity" "Broadcast receivers" y "Services" son activados con "Intents".

Un "Intent" es la intensión de hacer algo, a través de los "Intents" vamos a poder decir, ok, este "Activity" ahora va ser uso de este servicio o este "Activity" va iniciar este otro "Activity" o vamos a enviar un "Broadcast" todo esto se hace a través de los "Intent".

Las actividades tiene un ciclo de vida, desde que son creadas hasta que son destruidas, el método más importante de este ciclo de vida, es cuando la Actividad es creada, cada uno de los pasos del ciclo de vida, se refleja en un método de código de "JAVA" vamos a necesitar forzosamente implementar por lo menos uno de estos métodos que es "onCreate" cuando la Actividad es creada. 

Sin embargo, para poder mantener al usuario, informado y poder realizar diferentes cambios de mi aplicación, en conjunto con lo que el usuario está haciendo, necesitamos muchas veces, implementar más de algunos métodos.

Por ejemplo "onPause" y "onResume" cuando la actividad se va a pausa y cuando regresa de esa pausa, porque estoy cambiando de actividad, incluso puede ser que esté cambiando de aplicación.

Cuando va ser destruida la actividad, utilizamos el método "onDestroy"

Este ciclo de vida es bastante útil de conocerlo, aunque no lo estemos usando por completo, en todas las aplicaciones y en todas las actividades, platicábamos antes de la activación de los componentes.

El "Intent" me va permitir registrarme de cierta forma, para poder hacer algunas acciones comunes a través de filtros, entonces voy a definir "Intent Filter" que van a de cierta forma, indicar cómo reacciona, ante algún evento.

Por ejemplo el más común de esto es cuando le pongo un "Intent Filter" de "Launcher" a una actividad, para que cuando se abre la aplicación sea esta actividad la que se lance.

Con los "intents" podemos instanciar de varias formas, y principalmente tenemos dos tipos de "intents" cuando vamos a tener algo que está definido por nosotros o cuando es definido por el sistema.Puede ser implícito o explicito

Por ejemplo, si yo tomo un "intent" y le digo que la acción es una constante, definida por "Android" es "ActionView" y le envío un "URL" el sistema sabe lo que quieres es visualizar este "URL" y abre el navegador o alguna de las aplicaciones que tengamos instalas, para poder responder ante este evento.

También por otro lado podría ser, que quiero empezar una actividad de mi aplicación, que yo mismo definí, entonces allí defino de forma explícita, vamos a iniciar esta clase de "JAVA" que representa una actividad.

El último de los componentes, es el "Content Provider" este maneja datos y es activado no con "Intent" sino con "Content Resolver" este componentes no es tan común, a menos a que yo quiera poner datos, no tengo una necesidad de usar un "Content Provider".

Si voy a usar una base de datos "SQL" tengo necesidad de usarlo si voy a exponer datos a terceros, yo puedo usar un "Content Provider"

Por ejemplo: para la galería, para los contactos, para diferentes cosas, pero en la mayoría de casos, no voy a tener necesidad de hacerlo, sino más bien voy a consumir de otros "Content Provider" existentes, algunos que provee el mismo sistema, otros que provee hacia terceros, ahora todo esto entra en funcionar en conjunto.

Por ejemplo tengo una actividad y voy a pasar de una actividad que tiene un listado a una actividad que tiene un detalle de uno de estos elementos, haciendo un clic, esto requiere un "Intent" puede ser que al ver el detalle, necesite actualizar, entonces voy a tener un servicio que se encargue de eso, el servicio va hacer uso de un "Broadcast" para avisar que ocurrió algo, la actualización y voy a traer datos usando un "Content Provider", allí están los bloques básicos interactuando, y además de los bloques básicos voy a tener un archivo de configuración.

Es el "Android Manifest" es un archivo "xml" donde voy a colocar por ejemplo los permisos, voy a colocar metadata, voy a colocar una descripción de las actividades que tengo, voy a colocar que filtros de "intent" voy a estar utilizando y en general toda la configuración necesaria.

Recapitulando, los bloque básicos para "Android" son "ACTIVIDADES","SERVICIOS","RECEPTORES DE DIFUSION" y "CONTENT PROVIDER" los primeros tres: actividades, receptores de difusión y servicios, son activados con "intents", el ultimo el "Content Provider" es activado con un "Content Resolver" y todo dentro de la aplicación lo voy a configurar con un archivo "xml" que se llama "Android Manifest"





## Clase0_2 Fragmentos

* [Regresar a la lección](#lección-0)

Los fragmentos representan un cierto comportamiento,una porción de interfaz gráfica de alguna forma con la que el usuario está interactuando y surgen con el objetivo de brindarnos flexibilidad

Podría tener múltiples fragmentos dentro de una misma actividad y es importante aclarar que siempre un fragmento tiene que pertenecer a una actividad.

Los fragmentos son muy conveniente y se usa para diferentes cosas, hay cuestiones de navegación de "Android" que utilizan fragmentos por ejemplo: "Navegation View" o por ejemplo un "View Page",  hay cosas como los mapas que el soporte viene también en fragmentos y cada vez es más común que muchas cosas de "Android" se encuentren como fragmentos.

Dentro de los fragmentos hay varios métodos que son muy importantes

Por ejemplo "onActivityCreated" que este método se manda llamar cuando la actividad es creada recordemos el fragmento va a ser parte de una actividad por lo tanto necesito controlar cuando hay un evento en el ciclo de vida de la actividad,

Otro método importante  es "onCreateView" a diferencia de la actividad que tiene un método "onCreate" en donde hacemos un "SetContentView" en el caso de los fragmentos cuando se ejecuta "onCreateView" voy a tener que convertir el archivo xml hacia algo que pueda visualizar, de tal forma que tenga contenido

Entonces hay varios métodos y todos ellos se describen en el ciclo de vida del fragmento.

Hay varias formas de crear un fragmento esto se puede hacer en código podríamos llamarle esto:

Forma Estática en donde del "xml" yo agrego un componente y le pongo "FragmentName" y el nombre de la clase de mi fragmento y pongo todas las propiedades del
fragmento eso es una forma estática.

Forma dinámica es cuando lo agrego con código en tiempo ejecución por alguna razón necesito el fragmento y allí colocó los valores, cuando va a ser de forma dinámica necesito que el fragmento tenga un constructor vacío y voy a usar un "FragmentManager" que esto me lo provee la actividad para poder administrar.

Dependiendo del caso de uso va a cambiar un poco cuál es más conveniente

Recordemos la actividad tiene un ciclo de vida y en base a este ciclo de vida tenemos varios eventos con los que vamos a ir teniendo una interacción por ejemplo "onCreated","onResume","onStart",etcétera y el fragmento a su vez, va a tener también un ciclo de vida para permitirnos saber en qué estado se encuentra de todo lo
que está ocurriendo.

Si tenemos el ciclo de vida del fragmento dentro del ciclo de la actividad esto puede llegar a ser muy complicado ya que tiende a crecer el ciclo de vida y ha llegado un punto en donde no es algo de fácil comprensión es muy complejo y tenemos la disyuntiva de qué hacer

Usamos fragmentos y nos sometemos a este ciclo de vida tan complejo

Por otro lado decidimos no usarlos y nos quedamos sin ese apoyo de modularización.

La recomendación es, elegir una opción entre todos los que hay que podríamos hacer por ejemplo podríamos ver una sola actividad y todos controlarlo con fragmentos para que sea más fácil este control utilizamos un "Navigation Manager",básicamente lo que hace el "Navigation Manager" es saber de dónde vengo y a dónde voy y por qué estoy haciendo ese cambio.

Otra opción es usar muchas actividades con vistas reutilizables, estas vistas reutilizables van a ir dentro de un fragmento que a su vez van a ir dentro de las actividades

Una tercera opción, es que puede incluir los fragmentos, pueda usar este ciclo de vida tan complejo pero para la comunicación haga uso de, algo diferente a lo que el fragmento provee.

¿Cómo se comunica el fragmento con una actividad?

Usualmente dentro del fragmento puedo ser un "getActivity" y dentro de la actividad, tengo mi listado de fragmentos o puedo obtener alguno dependiendo si es estático y dinámico y entonces usualmente defino una interfaz código de "JAVA" que uno de los dos componentes va a tener una instancia y el otro componente lo va implementar a través de esta interfaz, puedo enviar eventos de uno a otro.

Una alternativa a ello sería usar una librería como "Event Bus".

Otra alternativa podría ser usar programación reactiva y de cierta forma reaccionar ante los eventos del fragmento.

Recapitulando un poco los fragmentos nos permiten modularizar el contenidos, están en "Android" desde la versión cuatro (ya que la 3 es de tablets), hay algunos desarrolladores que abogan por no usar fragmentos por lo complicado que tiende a ser el ciclo de vida para comunicarnos con fragmentos usamos interfaces con "CallBacks" y hay algunas alternativas para que él trabajar con fragmentos no sea tan doloroso entre ellas va estar el trabajar con una arquitectura bien definida y que esto nos va a imponer una forma de acceder al "UI"al final del día va a ser una decisión de cada desarrollador, decidir si quiere usar fragmentos o no.





## Clase0_3 Butterknife

* [Regresar a la lección](#lección-0)

Una librería que es de uso común se llama "BUTTERKNIFE"  y tiene que ver con otra librería muy común que se llama "DAGGER"

"DAGGER" nos sirve para inyectar dependencias y "BUTTERKNIFE" nos va a servir para inyectar vistas, dee hecho desde hace un par de versiones ya no se le llame inyección sino se le llama vínculo("bind")

Entonces lo que va a permitir "BUTTERKNIFE" es que tenga una forma más sencilla de trabajar las vistas dentro de la aplicación si lo tenemos que resumir podríamos decir que por "BUTTERKNIFE" lo que va a provocar es que nos olvidemos de hacer uso de "FindViewByID".

Al trabajar con vistas en "Android" constantemente tengo que hacer una llamada a "FindViewbyID" para obtener los elementos describo "FindViewByID()" y el identificador que le puse esto tiende a hacer trabajoso o no es difícil, pero puede llegar a ser muy tedioso.

Lo que me permite "BUTTERKNIFE" es crear un vínculo ,voy a escribir una línea para este vínculo y luego voy a usar una anotación de esas que se usan bastante en JAVA y voy a usar la notación para indicar que se haga este vínculo entonces la clase de la librería "BUTTERKNIFE" lo que va a hacer es al compilar va generar estos vínculos y lo va a reemplazar con "FindViewByID".

De cierta forma permite que sea más fácil para el desarrollador escribir código,que el código sea un poco más legible y podríamos poner la categoría es que va a tener sin "Syntactic sugar" es decir no es que va a ser más eficiente o menos sino que va a ser más legible el CÓDIGO.

Para hacerlo tenemos que agregar soporte con el archivo "build.gradle" igual que muchas librerías el archivo de "gradle" de nuestra aplicación va a tener una parte de dependencias aquí incluimos cual es la dependencia para "butterknife" y luego ya la podemos utilizar.

Para usarla dentro de el método "onCreated" de la aplicación vamos a hacer un "butterknife.void" indicándole cuál es el target , es importante que lo hagamos después de un "setContentView" sino no vamos a tener con qué hacer vínculo y también es importante que definamos los "ID" con los "ID" correspondientes a la vista.
entonces una vez hacemos esta llamada "Bind".

Yo ya puedo escribir un ejemplo un "EditText" o un "TextView" únicamente lo defino como una variable global y le agregó la anotación @Bind de tal forma que con esto se va a crear el vínculo además del "binding".

Butterknife me permite manejar el "Click" de una manera sencilla en vez de escribir una clase anónima o escribir algún "Listener" únicamente para soportar el click de un botón lo que va a permitir "butterknife" es que pueda declarar un método cualquiera, escribir una anotación @onClick con el identificador de un elemento cliqueable que yo le pueda hacer "Click" y en el momento en que se presione el "tap" o "Click" sobre este elemento se va mandar a llamar este método
eso me permite, en términos generales que pueda mejorar la la forma en que ordeno la funcionalidad del código y también estandarizar un poco.

Luego hay un plugin para "AndroidStudio"que se llama "Butterknife - Zelezny" que me va a permitir crear estos inyecciones de forma automática de tal forma que ni siquiera voy a tener que escribir las inyecciones(o vínculos) a mano, sino voy a tomar el "xml" hacer un click para generar, luego esto me genera un cuadro de texto en donde está todo lo que tiene el "xml" voy a decir, si, éste lo quiero, éste no lo quiero, éste sí, éste no y luego al
presionar a aceptar entonces se van a crear todas estas inyecciones o este "Binding".

Este vínculo dentro de mi actividad, fragmento, "ViewHolder" o el tipo de vista que esté usando este plugin, nos está soportado por la del mismo grupo hace la librería pero es muy conveniente y recomiendo que lo puedan utilizar en en los enlaces van a encontrar un poco más de información acerca de el sitio oficial de "butterknife" y de donde se puede obtener este plugin.



Instalar plugin Butterknife - Zelezny

Simplemente ve a la pestaña File desde AndroidStudio, seleccionas de la lista donde dice Settings, te aparece una nueva ventana te ubicas en el listado de la parte izquierda donde dice Pluggins. Si te fijas en la parte de abajo te aparecerán tres botones selecciona el que dice Browse repositories.., luego en el buscador escribes Android ButterKnife Zelezny en la parte derecha te da una opción para instalar, lo instalas y luego te pide que reinicies el programa ya con eso lo tienes instalado.



## Clase0_4 Layouts

* [Regresar a la lección 0](#lección-0)

Una parte importante del desarrollo para "Android" son los "Layouts", el "Layout" me va a permitir que mi actividad tenga cierta visualización y que pueda
exponer los elementos que quiera, dentro de esta visualización y los "Layout" van a estar construidos en "xml".

Ahora algo curioso es que el "Layout" es decir la palabra "Layout" se va a usar para:

- Describir un archivo en "xml" que va a estar dentro de una carpeta específica en la estructura del proyecto

- Describir el contenedor que va de cierta forma a ordenar el contenido

Entonces es importante, saber que al mencionar un "Layout" dependiendo del contexto podría ser uno o u otro, entonces cuando tenemos el manejo de vistas dentro de "Android" vamos sobre todo a basarnos en componentes re utilizables estos componentes van a estar descritos en "XML" y van a reaccionar de alguna forma, ante un evento

Ese evento podría hacer algo en código o podría ser algo con el que el usuario está provocándolo a través de una interacción.

Estos elementos reutilizables van a agruparse, entonces vamos a colocar una estructura jerárquica con contenedores que van a describir cómo se ordenan los elementos usualmente a esto le llamamos "ViewGroups" y los grupos van a definir, una posición un tamaño, una ubicación, como se va a ordenar, etcétera de todos los elementos hijos.

Por eso hablamos de una jerarquía porque el contenedor para tener varios elementos entonces podemos imaginarnos esto como un elemento raíz bajo el podrían haber otros elementos del mismo tipo anidados y al final tal vez pensar como hojas de un árbol y al final vamos a tener después de todas las ramas una hoja en donde tenemos por ejemplo un "TextView" un "EditText" y estos diferentes controles que son los que permiten al usuario interactuar con la aplicación entonces los contenedores o los que van a imponer la jerarquía tienen ciertas características.

Pero todos tanto los contenedores como también los elementos van a describirse usando "xml" por eso es importante tenerlo en mente eventualmente ese "xml" va a ser tan formados para ser visualizado, si por alguna razón vienen del mundo web podrán hacer una analogía muy sencilla, con la forma en que se pueden usar hojas de estilo para darle una visualización mucho más agradable al contenido podemos hacer una analogía con eso y decir que las vistas que van a tener el "xml"
van a ser como él mismo, un equivalente para usar las hojas de estilo, dentro de la forma en que estilizamos este contenido

Ahora hablando de los "Layout" pero ya no de los archivos, sino de los contenedores tenemos varios, pero principalmente usamos dos, un tercero, aparece de vez en cuando y vamos a mencionarlo por eso ese terceros es un "FrameLayout".

Un "FrameLayout" básicamente lo que nos permite es tener un encuadre cierto contenido lo vemos mucho con los fragmentos.

los dos que más se usan son "LinearLayout" y "RelativeLayout" como su nombre lo indica, van a ordenar los elementos de una forma lineal, "LinearLayout" es decir uno después de otro ya sea de forma horizontal o vertical pero uno después de otro o en el caso del "Relative" lo van a ser unos respecto a otro, entonces vamos a usar algún elemento de ancla y los demás van a ir colocados respecto a este elemento, no necesariamente sólo uno es que van unos respecto a otros entonces podemos colocar las posiciones de cuál de los elementos de cualquiera de ellos a través de la posición de otro elemento previamente existente

Por ejemplo si tenemos no se, un "EditText" que va a permitir el "Input" de algo y luego otro "EditText" y luego otro botón y los queremos colocar uno detrás de otro el "LinearLayout" es una mejor solución por el contrario, si lo que queremos es colocar con una alineación, en donde voy a decir está el elemento
aquí arriba y abajo voy a tener un botón y este botón va estar abajo pero flotando hacia alguno de los lados allí me quedaba con un "Relative Layout".

Es decir si quiero flexibilidad mejor un "RelativeLayout" sino quiero preocuparme por como ordenarlos y si sólo quiero que vayan uno detrás de otro "LinearLayout".

Además puedo anidar uno dentro de otro podría tener un elemento en la jerarquía hasta arriba un elemento raíz línear y adentro un "Relative" y a la par un "TextView",etcétera o al revés, esto lo que permite es que pueda colocar los elementos en el orden que más me convenga

Para hacerlo vamos a trabajar con "AndroidStudio" es un "IDE" que me permite acceder a muchas cosas al desarrollar entre ellas al trabajar con archivos "xml" voy a tener una paleta de estilos y de esta paleta de estilos voy a poder arrastrar y soltar(Drag & Drop) tomando por ejemplo un "LinearLayout" y lo arrastramos hacia la pantalla del teléfono que es una simulación pero así lo vamos a ir viendopermitiendo colocar el contenido con un mayor orden.

Antiguamente se usaba "Eclipse" y tal vez, algunos todavía usen "Eclipse" también tiene un soporte para ello con un plugin de "Android" pero "AndroidStudio" lo soporta de una mejor forma y vamos a poder consultar, cómo estos elementos se ordenan, que propiedades utiliza a través de varios enlaces.

Resumiéndolo un poco los elementos que utilizamos más comúnmente son "RelativeLayout" y "LinearLayout"

"RelativeLayout" ordena a los elementos, bajo la jerarquía, los elementos hijos, uno respecto a otro

"LinearLayout" pone uno detrás de otro, ya sea de forma horizontal o de forma vertical

Tambien esta el "FrameLayout" que es un poco menos común que solo me va a permitir un encuadre para colocar alla adentro los elementos

"Material Design" introduce un "Layout" nuevo que coordina llamado "CoordinatorLayout"



## Clase0_5 Inputs Controls

* [Regresar a la lección 0](#lección-0)

Los controles de entrada("Input Controls") estos son los elementos que me van a permitir interactuar con la aplicación hay algunos comunes, otros un poquito más raros, pero todos tienen el mismo objetivo,que de cierta forma el usuario me permita escribir algo o apachar un botón o etcétera y con eso la aplicación va a reaccionar.

Entonces los controles de entrada son descritos también en "xml" al igual que los "Layouts" y van a ser contenidos dentro de un "Layout", con "Layout" me refiero no únicamente al archivo sino también al nombre de la vista que a nivel jerárquico está en lo más alto, es decir voy a tener un elemento raíz por ejemplo un "LinearLayout" y dentro de el, puedo tener un "Button",un "ImageButton",un "ImagesView"etcétera y todos estos descritos con "xml".

Entonces como parte de los controles de entrada hay varios elementos comunes que podemos consultar en la documentación oficial y hay algunos que se usan muy seguidos, por ejemplo botones, por ejemplo etiquetas, esto se llama "TextView" por ejemplo, algo para ingresar texto esto se llama "EditText" y cada uno va a tener sus diferentes características todos van a tener, por lo menos ancho y alto, esto es importante tenerlo en mente, todos los componentes descritos con "xml" tienen que tener por lo menos ancho y alto y hay un par de palabras reservadas para indicar dos casos de ancho y alto por ejemplo si quiere usar todo escribo "match parent" y si quiere usar únicamente lo que el elemento necesita, utilizó "wrap_content".

La alternativa sería escribir con un tamaño en píxeles,independientes o  dependiente de profundidad, qué tamaño que utilizar, en general se recomienda usar los "DPS" 

Los "TextFields"  nos va a permitir escribir algo, lo interesante es que de acuerdo a lo que quiere escribir, puedo antes que de acuerdo a lo que quiero escribir, puedo mostrarle al usuario, un teclado diferente pues por ejemplo puedo decir aquí va un "email" le muestra al usuario un arroba(@) y un punto(.) para poner el dominio o aquí va un número y le muestra el teclado numérico, sino lo coloco pues no hay ningún problema igual funciona pero es una buena práctica.

También tenemos botones este se llama "Button" y tenemos botones con los que podemos cambiar el estado o un "Toggle Button" éstos puede ser deslizables, Cliqueables o de alguna forma mostrar al usuario que el status cambió, podríamos por ejemplo usar una imagen cuando le hagan "Click" cambiar la imagen pero sí hay algunos botones que manejan el control de cambio es mejor usar el "Toggle" y aquí vamos a tener un cierto texto, podemos ponerle una imagen de fondo, etcétera

Otro de los elementos más comunes es el "spinner" que me permite crear una lista en base a por una serie de cosas que quiera mostrar al usuario cuando le hago clic sobre una opción se va a mostrar un estado hacia abajo a veces a éste también se le llama "Drop Down List" porque tengo una sola línea con la opción seleccionada y cuando lado clic demuestra todas las demás el llenado de estas listas, o el contenido que voy a mostrar puede hacerse con código en "JAVA" o puede especificarse en "xml" como un arreglo.

Otro elemento común son los botones de radio "Radio Button" que voy a agrupar en "Radio Groups" esto me van a permitir a mí seleccionar una opción de varias por, ejemplo puede ser un sí o un no o puede ser para elegir alguna opción en donde tengo claramente definidas las opciones, con esto voy a obtener un valor y saber si está seleccionado o no.

Algo similar pero cuando quiero más de una opción me sirve con los "CheckBox" ,estas cajas le permiten seleccionar más de una opción a menos que tenga alguna restricción.

Así como tenía el "spinner" las opciones vamos a tener también el "picker" esto es común por ejemplo para la hora o para una fecha en donde voy a tener la opción de seleccionar, dentro de un rango amplio por ejemplo, cuando quiero seleccionar la fecha, tal vez el mes no es tan complicado son doce opciones pero el día pueden ser de 28 a 31 o el año dependiendo del rango de año se quiera mostrar entonces el "Picker" es muy común para este tipo de cosas, y si queremos leer un poco más hay varios enlaces de interés en la documentación oficial.



## Clase0_6 Recycler View 

* [Regresar a la lección 0](#lección-0)

"Recycler View" sirve  para presentar contenido en forma de un listado, ya sea un listado con un elemento detrás
de otro o incluyendo columnas.

cuando incluimos columnas usualmente a esto se le llama "Grilla" o "Grid" en inglés y antiguamente teníamos para manejarlo un "List View" y un "Read View",ambos han sido reemplazados en la versión más nueva por el "Recycler View" que permite mostrar el contenido de las dos formas y con un
poco más de opciones.


El "Grid" pues tiene varias columnas puede ser ordenado de diferentes maneras

Ahora a partir de de "Material Design" y de la versión "Lollipop" de "Android" se introdujo el "Recicler View" para mostrar contenido, en una forma más sencilla.

Tal vez el punto más importante del "Recycler View" es que no se encarga de muchas cosas, tanto "List View" como "Grid View" tenía demasiadas responsabilidades "Recycler View" tiene poca responsabilidad entonces:

No se encarga de posicionar los elementos en la pantalla, eso lo va a ser un "LayoutManager"

No se encarga de animar ,cuando queremos cierta animación para agregar elementos o quitarlos, etcétera.Eso lo va hacer un "Item Animator".

No se encarga tampoco de manejar ningún evento asociado con el listado o con el "Grid".

A excepción del "Scroll", es el único evento que va a manejar, para esto podemos hacer una interfaz, podemos obtener la posición en el "ViewHolder", hay diferentes formas de hacerlo sin embargo el "RecyclerView" no se va encargar de nada de esto. 

Entonces,¿Qué hace? 

Únicamente va mostrar el contenido y como tiene tan poca responsabilidades puedo personalizarlo de una forma sencilla y esto se ha vuelto como un
Modulo.

Entonces el formato o la forma en que vamos a trabajar el "Recycler View" va a requerir de un "LayoutManager" ,podría ser "Linear Layout Manager" o un "Grid Layout Manager" que va a conectarse a una fuente de datos estos datos podrían ser, una base de datos, podría hacer un arreglo, podría ser un cursor, etcétera y en medio hay un vínculo, ese vínculo lo logramos conun adaptador.

El adaptador no hace más que tomar una fuente de datos y mostrarla de cierta forma, entonces el elemento que lo muestra por un lado el
"UI" es el "RecyclerView" y por otro lado la fuente de datos puede venir de muchos lugares.

Es importante tener en cuenta que el "Recycler View" va requerir que el adaptador lo implemente, en decir el desarrollador va tener que implementar el adaptador de acuerdo a sus necesidades.


Entonces para empezar el "LayoutManager"(éste va a posicionar el contenido) y va determinar cuándo vamos a poder reutilizar elementos que no son visibles, para ello vamos a usar un "View Holder"

"LayoutManager" podría ser de tipo listado con un "LinearLayoutManager", podría ser "Grid" con un "Grid Layout Manager"
Podría ser una "Grilla" escalonada, con celdas de diferente
tamaño,éste se llama "StaggeredGridLayoutManager" o bien podría
personalizarlo.

Conforme hay actualizaciones de la librería de diseño van habiendo cambios sobre que soporta,que se agrega,que cae en desuso ,etcétera y en la mayoría de casos, nos la vamos a agreglar con un "LinearLayout" o con un "GridLayout" algunos casos puntuales ban ha requerido algo diferente pero por lo demás es relativamente fácil trabajar.

Dentro del adaptador hay una parte muy importante voy a tener que construir un adaptador heredando del "RecyclerView.adapter" sin embargo además de ello voy a tener la obligación de implementar un "View Holder".

El "View Holder" lo que me permite es reutilizar "R" elementos.

Entonces voy a tener una clase que tiene referencia a cada una de las filas del listado o de las celdas si fuera un grid.

Entonces cómo estoy llamando "FindViewById" constantemente esto tiende a ser ineficiente y como quiero rehusar estos elementos para no llenar la memoria, entonces el "ViewHolder" es un patrón que permite a través de un objeto simple mantener una referencia a los identificadores de la vista estos identificadores me van a permitir mostrar,renderizar el contenido de cada una de las celdas, sea uno de los elementos del listado o una de las celdas del "Grid" y vamos a incluirlo dentro del "Adaptador".

Entonces vamos a tener que escribir una clase personalizadas que herede del "Adapter" del "Recycler View" y vamos a necesitar un "View Holder" que va a tener que ser inflado en el adaptador, en un método que se llama "onCreate View Holder" y en otro método va a ser vinculados los datos de la fuente de datos con el "View Holder" este método que se llama "OnBindViewHolder" me permite hacer eso.

Ahora cuando quiero manejar el "click" todavía no hay una forma estandarizada lo que vamos a estar haciendo usualmente es manejarlo con "View Holder" entonces vamos usar una interfaz que defina cómo actuar ante ese click ,esa interfaz la vamos a recibir en el adaptador y la vamos a asignar al "ViewHolder" entonces vamos a manejar el click sobre el "View" que tiene el "ViewHolder" y con la interfaz que recibimos y reaccionar de alguna manera.



## Clase0_7 Implementación de los componentes

* [Regresar a la lección 0](#lección-0)

Acerca de la implementación del "ReciclerView" hemos visto la teoría que necesitamos un adaptador, un "ViewHolder" y un "LayoutManager" pero como se ve esto ya en el código en "AndroidStudio", cómo lo voy importar.

El primer paso y eso es importante tenerlo en mente es que como "RecyclerView" se introdujo en "Lollipop" en la versión cinco,hay muchas otras versiones anteriores que no lo soportan de forma nativa entonces debo agregar, una referencia en el archivo "Build.gradle" para esta librería:

```java
dependencies{
	compile 'com.android.support:recyclerview-v7:+'
}
```

Entoces vamos a incluir allí dentro de dependencias un "compile", el nombre de la biblioteca y también de la versión.Una vez que ya lo tengo,ya dispongo del componente aunque no esté produciendo algo para "Lollipop" o versiones más nuevas.

Entonces ya puedo escribir en el "Layout", un elemento "RecyclerView" que es parte de "android.support.v7.widget" donde estaban varios elementos de soporte y le tengo que especificar ancho y alto como a todos los elementos le tengo que usualmente poner un identificador porque de esta manera le voy a poder vincular un "adapter" y además opcionalmente, podría ponerle más atributos,incluso indicarle si va a tener "ScrollBars" para que el contenido lo muestre cierta manera, podría hacer un "Linear Layout Manager" horizontal o vertical y desde aquí desde "Layout" indicar cómo van a ser estos "ScrollBars".

Ahora cómo voy a hacer un "Adaptador" personalizado,también necesito especificar el "Layout" para cada uno de los elementos, en el caso del ejemplo básico vamos a tener únicamente un "TextView" y ese "TextView" es el que va a renderizar, a mostrar el contenido de cada elemento pero sí es importante que son dos archivos de "xml" diferentes.

Para el "Adaptador" voy a heredar del "Adaptador" de "RecyclerView",voy a tener algunas algunos métodos que va a ser forzoso implementarlos en relación al "ViewHolder",  cuando lo estamos vinculando,cuando lo estamos creando y además el método que me devuelva el conteo de cuántos elementos tengo.

Usualmente cuando voy a trabajar cierta clase en el mismo adaptador incluyó el "ViewHolder".

El "ViewHolder" es una clase relativamente sencilla que tiene como características que va a heredar también de un objeto de "Recycler View" y tiene que tener un constructor que referencie a su ancestro.

Además vamos a incluir aquí todo lo que necesite para referenciar a las vistas dentro del elemento que voy a estar utilizando para mostrar el contenido.

En nuestro caso el "ViewHolder" va tener únicamente un "TextView" porque ese es el contenido y a través del "ViewHolder" también voy a colocar el manejo de "click" entonces eventualmente pues aquí vamos a poner cuál es la forma en que vamos a actuar cuando ocurra un "click" sobre está vista que representa al "Holder"

Entonces para manejar el "click" vamos a crear una interfaz, esta interfaz la va a recibir el adaptador como un parámetro, voy a también eventualmente importarla e implementarla dentro del elemento que está trabajando con ese adaptador, usualmente es una actividad o un fragmento y entonces ahí voy a tener este método implementado y en el adaptador voy a tener la el uso de este método de la interfaz del "click" para ello entonces vamos a por ejemplo poner "onItemClick" en la actividad lo vamos a implementar y dentro del adaptador vamos a colocarlo hacia el "ViewHolder".

Mi "Adaptador" debería tener por lo menos una referencia hacia una fuente de datos, un listado y entonces desde la actividad o fragmento que va hacer uso del "Recycler View" tengo que especificarle los datos podría hacer un arreglo por ejemplo un arreglo de "Strings" y que mi "Adaptador" tenga este esta estructura también como fuente de datos, tengo que especificarle la interfaz que va manejar el clic y lo demás es opcional.

Al estar haciendo la configuración del "RecyclerView" vamos también a especificar cuál es el "manager" o quién va administrar el contenido usualmente nos las arreglamos con un "LinearLayoutManager" y esto nos basta y luego lo asignamos.

Entonces con un "SetAdapterView" sobre el "RecyclerView" ya tenemos listo todo y podemos trabajar con este "RecyclerView" utilizando estos datos.

Recapitulando un poco voy a necesitar importar la librería utilizando el archivo de "Gradle" escribir una clase del "Adaptador" y esta clase del adaptador va a utilizar un "Layout" entonces necesito dos "Layout" necesito un "Layout" para donde va el "Recycler View", otro "Layout" para el elemento personalizado, en el adaptador voy a tener un "ViewHolder" que usa lo que sea que tengo en mi elemento personalizado en este caso pues era un "TextView" y voy a definir algunos métodos como un "CreateViewHolder" y "onBindViewHolder" y "getItemCount" luego para el "Click" lo voy a manejar sobre el "View" que tiene el "ViewHolder" y en la actividad o fragmento que hagan uso de este "RecyclerView" vamos a colocarle el "LayoutManager" a colocarle el adaptador y listo, ya tenemos nuestro "RecyclerView" funcionando.



# Lección 1:


* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Código del presentador del curso](https://github.com/ykro/android-chat-firebase)
* [Arquitectura de una Aplicación](#clase1_1-arquitectura-de-una-aplicación)
* [MVP](#clase1_2-mvp)
* [Clean](#clase1_3-clean)
* [Firebase](#clase1_4-firebase)
* [Firebase y Android](#clase1_5-firebase-y-android)
* [Escribir y Leer Datos de Firebase](#clase1_6-escribir-y-leer-datos-de-firebase)
* [Snackbar](#clase1_7-snackbar)
* [TextInputLayout](#clase1_8-textinputlayout)
* [AppBar y ToolBar](#clase1_9-appbar-y-toolbar)
* [Coordinator Layout](#clase1_10-coordinatorlayout)
* [Floatin Action Button ](#clase1_11-floating-action-button)
* [Circle Image View](#clase1_12-circle-image-view)
* [EventBus](#clase1_13-eventbus)
* [Glide](#clase1_14-glide)


## Clase1_1 Arquitectura de una Aplicación

* [Regresar a la lección 1](#lección-1)

¿Por qué deberíamos preocuparnos en general por la arquitectura de una aplicación?

El primer punto importante aquí en la mantenibilidad,es decir que el software va ser escrito en cierto momento del tiempo y hacia el futuro nuestra expectativa, es que podamos seguir utilizando el mismo software.

Si vemos las cosas desde un punto de vista financiero, el software no es barato,sobre todo porque depende de personas que van a estar produciéndolo, que requiere cierta formación, lo que implica que va tener cierto costo,entonces nos interesa que a largo plazo, el mismo software se pueda actualizar y mantener.

Desde el punto de vista técnico y de implementación, si cierto software no tiene arquitectura,entonces va ser muy difícil darle mantenimiento al futuro, va ser un gran reto, y como es mas fácil, pensar en una solución nueva, que entender lo que alguien más hizo, constantemente, vamos a estar implementando toda la base de código

Nos interesa la escalabilidad, porque vamos a planificar, con cierto segmento de clientes en mente, pero este segmento de clientes puede crecer mucho, pero si construimos para algo que va atender a muchos usuarios y no los tenemos es un desperdicio, por eso es mejor construir algo que atiende un número menor de usuarios, pero que puede crecer, sin necesidad de implementar desde cero, eso es escalabilidad y una aplicación con arquitectura me va permitir escalar.

Otro punto importante son las pruebas, en muchas empresas se hacen procesos de (QA) o aseguramiento de calidad, manuales, en donde hay una persona que está revisando que el software funcione, esto se puede hacer, pero a largo plazo no va ser escalable.

Es mucho mejor escribir pruebas automatizadas, más código que pruebe el código y que nos diga si funciona o no funciona.

A la vez hay un vínculo cercano, entre todas estas características, es decir que algo sea testeable que se pueda probar, me va permitir que sea escalable, y a la vez, que sea mantenible, una aplicación con una arquitectura bien definida, me va permitir que el proceso de pruebas sea más sencilla, a pesar de que las prueba han venido haciendo hace tiempo, no es tan común en todos los tipos de aplicaciones sino en cierto, desarrollo se ha vuelto un poco más fácil acercarse a las pruebas que otro, y bueno todo esto lo estamos haciendo porque a largo plazo queremos confiabilidad.

Hay diferentes tipos de software, algunos sistemas de tiempo real, que tienen características específicas, pero en general queremos que el software sea confiable, no queremos que si algo falla, tengamos que reiniciar el equipo, no queremos que si vamos a una institución que nos preste un servicio nos diga, que no se puede, que el software fallo, sino queremos confiabilidad a largo plazo, ahora esto también está vinculado con el desacoplamiento, porque no hay arquitectura, los módulos están conectados unos con otros sin una división clara, entonces tenemos acoplamiento.

Queremos lo opuesto, queremos que sea modular, queremos que no haya unión entre los diferentes módulos, para poder conectar y desconectar, mantener, actualizar y enfocarnos en cierta tarea.

Al final de día, es importante tener en mente que el software se trata de las personas, es decir yo no escribo código para una computadora, a pesar de que la computadora lo va a ejecutar, sea un móvil una tablet o una desktop, etcétera, yo escribo código, para mis compañeros de trabajo, que van a interpretar ese código, agregarle a quitarle funcionalidad o modificarlo de alguna forma, yo escribo código para que sea legible por otros seres humanos, tengamos eso en mente, el software se trata de personas, y por eso es que la arquitectura va ser tan importante para a implementar para nosotros porque a través de ella vamos a producir software de mejor calidad, siempre teniendo en mente a las personas.



## Clase1_2 MVP

* [Regresar a la lección 1](#lección-1)

Puntualmente vamos a discutir la arquitectura "MVP" y la arquitectura "CLEAN" vamos a ver cómo trabajar con ambas en conjunto, pero es importante tener en mente, que por el estado que se encuentra Android está alcanzando cierto, punto de madurez, hay mucha discusión alrededor de esto, y alguien me decía de broma recientemente, que no ha vista dos aplicaciones de Android con la misma arquitectura, aunque los cambios sean pequeños, si hay variantes, si hay muchas aproximaciones, nosotros, elegimos esta porque creo que es una de las mejores  que existen, pero sobre todo en el momento que entendemos la necesidad de implementar una arquitectura, no importa que patrón de desarrollo de software utilicemos, vamos a poder hacer algo muy bueno, entonces más allá de los específicos que vamos a ver, es importante tener en mente la razón de la arquitectura y dejar a un lado las actividades y fragmentos, aquí hablo específicamente de Android, que se encarga de todo, un "GoActivity" que accede a la base de datos, muestra elementos, oculta elementos, tiene lógica, etcétera,

Para esto, vamos a partir de un modelo bastante conocido, que ya tiene años, de estarse utilizando, que es el "ModelViewController" o el "MVC" en el caso del "Model View Controller" que tuvo un apogeo fuerte en web y todavía se utiliza bastante. 

Tenemos tres capas, tenemos una capa de vista que es con la que interactúa el usuario, una capa de controlador que va conectar con la vista y luego va ir con el modelo, y en el modelo voy a tener los datos, la lógica de negocios, etcétera, y de regreso le notifica al controlador de algo, y el controlador actualiza la vista, entonces más o menos ese es el flujo de trabajo en "MVC" esta arquitectura se usa desde hace un poco de tiempo, en algunas plataformas de móviles, en Android, no hay algo que nos forcé a utilizarla, un par de personas decían, si es que estoy utilizando "MVC" la vista, es el "xml" el controlador es la actividad y el modelo es un "Plain JavaObject" en realidad no es tan sencillo, porque tiene que haber una comunicación clara.

"MVP" es una variante de "MVC" en donde nos vamos a enfocar, principalmente en el contenido que ve el usuario, por ejemplo, como es lo correcto de "MVC" que tanto debe hacer el modelo, hay mucha discusión alrededor de la arquitectura, y nos va presentar un reto interesante de saber cómo abordarlo.

Ahora con "MVP" lo que vamos hacer, es que vamos a partir en tres capas, que son bastante notorias:

el usuario va interactuar con la vista, la vista, es totalmente pasiva, la vista no debería tener lógica, en cuanto a lo que está mostrando y en general, la vista va ser, la actividad, ahora la vista cuando necesita algo, va a acudir al presentador

el presentador le da formato, el presentador accede a métodos tanto de la vista, como del modelo, cuando el presentador necesita de estos datos, va a traerlos al modelo,

el modelo tiene la lógica del negocio, obtiene estos datos de alguna forma, los devuelve al presentador y el presentador lo devuelve a la vista para poderlo implementar, vamos a tener diferentes métodos.

Entonces para resumir un poco, la vista va mostrar la información de el contenido de una característica o un módulo, el presentador se va encargar de acceder al modelo y llamar los métodos de la vista cuando corresponde y el modelo va manejar la lógica de negocios. 

Entonces implementando esto en Android, cada uno de los componentes va tener una interfaz de JAVA, en donde va ser una especie de contrato y se va definir cuáles son los métodos que tiene.

Por ejemplo, en la vista, si estamos manejando un inicio de sesión, vamos a tener algo que habilite y deshabilite los controles de entrada, que habilite o que oculte o que muestre una barra de progreso y de cierta forma, que vamos hacer cuando ya esté la sesión iniciada, o haya un inicio de sesión valido y qué hacer si ocurre un error, en la implementación que usualmente es una actividad, lo que vamos hacer es tomar estos método e implementarlos, por ejemplo si estamos mostrando un "ProgressBar" vamos a decir que el "Visibility" es "VISIBLE" si lo estamos ocultando que el "Visibility es" "View.GONE" esta implementación es parte de lo que maneja la actividad, es decir que la actividad tiene más carga que la vista, pero claramente definimos que puede hacer la vista, y, la vista, va tener este vínculo con el presentador es decir el presentador va tener una instancia de la vista, así como una instancia del modelo, además que el presentador va tener algo que va poder hacer alguna acción para que la vista la invoque, entonces por ejemplo desde la vista voy a tener un botón de "Login" cuando presiono ese botón llamo al método del presentador, y el presentador se encarga de decirle a la vista, Hey! si está llamando este método, entonces tienes que deshabilitar est e botón y mostrar un "ProgressBar" pero la vista no tiene esa lógica, la vista lo único que sabe es que el presentador va ser algo y elpresentador al recibir esta llamada allí si tiene lógica, allí se hace un cierto procesamiento y se le dice a la vista que actué a cierta manera, además de eso, además de lo que haga la vista, va tener un vínculo con el modelo, entonces al implementar el presentador, vamos a incluir una instancia del modelo, sobre la cual, vamos a ejecutar algún método, para tener datos y que podamos devolver a la vista, ahora todo esto lo estamos haciendo en una vía, eventualmente, el modelo va concluir, ya sea de forma síncrona o asíncrona, y tiene que reportarle de regreso al presentador y el presentador a su vez a la vista, para poder hacer, podriamos trabajar con una interfaz, con un "CallBack" que vamos a tener implementado en el presentador y que vamos a tener una instancia en el modelo, entonces el modelo va tener una instancia, de esta interfaz, por ejemplo va tener un método "Success" o "Error" que lo manda a llamar, cuando sucede el evento correspondiente y el presentador implementa estos métodos y en ellos se comunica con la vista, a través de esta comunicación, entonces logramos regresar en el "Stack" de las capas de la arquitectura, ahora el modelo es el que trabajo es el que va a tener la lógica de negocios, en el mismo ejemplo del inicio de sesión, aquí es donde tendríamos un método que accede al "API" hace alguna validación y en base a esa validación tiene éxito o no, y esa validación es la que reporta, con este reporte, entonces lo tenemos de vuelta en la vista, y eso es "MVP" ahora si por alguna razón yo no quiero utilizar esta interfaz, para comunicación, una alternativa común, es usar una librería, "Event Bus" con esta librería, podemos reemplazar el "CallBack" y usarla para poder comunicarnos desde el modelo hacia el presentador, el modelo emite un evento y el presentador captura ese evento, y ante la captura va realizar alguna acción dentro de la vista.

Recapitulando un poco, lo que queremos aquí es dividir en diferentes capas, "MVP" tiene tres. "Model" "View" "Presenter", el modelo, la vista y el presentador,

La vista va ser totalmente pasiva, va mostrar el contenido únicamente,

El presentador va a llamar a los métodos de la vista y va llamar a los métodos del modelo y entonces va tener referencia hacia ambos

El modelos va tener la lógica del negocio, es el que ejecuta algo, eventualmente se comunica con el presentador, que a su vez , se comunica con la vista.

entonces de esta forma logramos desacoplar y dividir en capas, la vista usualmente es una actividad, tenemos también implementaciones tanto para modelo como presentador y si no queremos usar la interfaz, podemos usar "Event Bus" para la comunicación, así que eso es "MVP".





## Clase1_3 Clean

* [Regresar a la lección 1](#lección-1)

"Clean" el "Clean Architecture" es una propuesta del "Uncle Bob" una de las personas que más aportes ha hecho a la ingeniería de software como disciplina, y lo que busca es desacoplar, entonces vamos a tener diferentes pasos, en los que podemos interactuar con diferentes componentes de nuestra aplicación

La arquitectura "Clean" lo que me permite es tener una interfaz gráfica, con la que voy a interactuar, esta interfaz va a conectarse de cierta forma con un repositorio que tiene los datos a través de un "interactor" el interactuador lo que va ser es conectar a la interfaz con el repositorio, el repositorio eventualmente podría tener datos haciendo uso de cierta lógica de dominio, alguna base de datos, etcétera, haciendo uso de entidades, que son los objetos que modelan el contenido, esto de cierta forma regresa hacia la interfaz, para mostrar el contenido.

Entonces vamos a de cierta forma combinar "Clean" con "MVP" vamos a usar "MVP" para la parte frontal, vamos a tener una vista y un presentador pero no vamos a tener un modelo, en vez de tener un modelo en donde toda la lógica de negocios, esta acoplada, vamos a usar un interactuador.

El interactuador es invocado por el presentador y a su vez invoca al repositorio, entonces la ventaja de esto, es que el interactuador no tiene que saber mucho de ninguno de los dos casos, solo tiene que saber que alguien lo llamar y que cuando lo llamen, tiene que llamar a su vez al repositorio, lo que nos facilita mucho el proceso, ya que solo es un elemento de conexión, y el repositorio va realizar las tareas de devolver los datos, o algún acceso que sea necesario.

Entonces una vista, que se conecta con un presentador que a su vez el presentador podría tener más de un interactuador, el interactuador va con el repositorio, que a su vez va con la fuente de datos y entonces el interactuador lo que va ser es conectar con el repositorio acceder a esta lógica de negocios y las fuentes de datos, van a estar disponibles.

Entonces tengo ahora más capas en mi implementación, porque voy a tener un contrato una interfaz, que define al interactor y que define al "repository" entonces va ver un punto donde esa separación de componentes y se va notar si esta acoplado o no, ese acoplamiento usualmente se da ahora, ya no en el modelo ya no va ser una clase, que hace mucho el modelo sino entre el repositorio y la fuente de datos.

por ejemplo podriamos tener muchos interactuadores, que nos presente un contenido, que, no sé, uno muestra palabras, otro muestra números, en el presentador invocamos a cualquiera de los dos.

Ahora ya que conocemos un poco más de "Clean" y que podemos combinar con "MVP" vamos a tomar esa aproximación, la ventaja es que vamos a tener múltiples capas de la arquitectura, por lo tanto va estar claramente segmentado y lo podemos implementar de una forma, en la que no nos provoque acoplamiento, la desventaja, es que vamos a tener varias capas de abstracción adicionales, es importante comprender claramente cuáles son los principios de la arquitectura que estamos utilizando.

Cada capa va aumentar una carga en la complejidad de la aplicación,pero a la vez, va aportar en simplificar, porque va ser más ordenado y voy a saber a dónde dirigirme, estas no son en absoluto, las únicas, en aproximaciones que hay para la arquitectura, pero son las que he encontrado en mi experiencia, con un poco mayor de facilidad y tiene un buen "Trade Off" entre la facilidad que tienen para aproximarse y los resultados buenos que nos van a dar a largo plazo, en la mantenibilidad, en el testing, en la confiabilidad, etcétera.

En la mayoría de casos vamos a ver que el interactuador es una capa que solo conecta, y hay que ser cuidadosos en decidir cuándo, implementar un solo interactuador o más de uno, usualmente va tener solo un método por ejemplo que se llama ejecutar o "execute", cuando tengo varias tareas, tengo que saber cómo separarlo, y sobre todo tengamos en mente que esto es una guía, no son mandamientos escritos en piedra.


## Clase1_4 Firebase

* [Regresar a la lección 1](#lección-1)

"FireBase" es una herramienta muy interesante que surgió a partir de una "StartUp" que eventualmente fue adquirida por "Google"

La idea detrás de "FireBase" desde el inicio ha sido proveer, una base de datos de tiempo real, pero además de esto,la documentación es muy buena y es una documentación viva, de la cual podemos tomar del código, directamente para nuestro proyecto, entonces además de proveer el servicio, es un servicio que es exageradamente fácil.

"FireBase" entra en la categoría de "backend as a service" es decir lo que busca, es que cuando estamos desarrollando un APP nos enfoquemos en todo lo que el usuario, ve y con lo que el usuario interactúa, no en el servidor que está detrás, tiene varios kit de desarrollo para las principales plataformas, incluyendo "web" y móviles y los principales "FrameWorks"

Entonces de "FireBase" lo más conocido es la base de datos en tiempo real, para empezar esto es clave, el hecho que sea de tiempo real nos permite hacer muchas aplicaciones que otro tipo de Backend no permitiría, y esta base de datos, es de formato no relacional, esto quiere decir que no vamos a tener tablas con filas y columnas, como por ejemplo, en un gestor de base datos relacional como "Postgresql" o "MySQL" sino vamos a tener un árbol, que tiene diferentes ramas para representar los datos.

Ahora la base de datos de tiempo real, es la característica más conocida, pero no es la única, actualmente otra característica que se está aprovechando bastante es la autenticación, "FireBase" me permite manejar la autenticación con usuario y contraseña, de forma anónima, pero pasando por el proceso de autenticación aunque no tenga credenciales, o con los principales proveedores como las credenciales de "Google" "Twitter" "Facebook" etcétera, esto lo que permite es que integremos, la autenticación de un kit de desarrollo de cualquiera de estos proveedores junto con "FireBase"y "FireBase" va manejar todo el flujo dentro del APP

Aparte hay una librería que se llama "FireBaseUI" que nos facilita la vida en varios aspectos de interactuar con la herramienta incluyendo la autentificación, entonces esta es otra característica importante.

Además de la autenticación posee almacenamiento estático, esto quiere decir que yo voy a poder publicar "FireBase" como almacenamiento como "Hosting" archivos que no requieran de un procesamiento del lado del servidor sino archivos de "HTML" que tienen algún tipo de código de JAVASCRIPT que corre del lado del cliente, esto eventualmente pues me permite provocar una desconexión, en el sentido que ya no voy a necesitar un servidor donde publicar todo esto, sino voy a estar trabajando, únicamente con código del cliente.

Además de estas características, está en activo desarrollo, entonces ahora que es parte de Google que adquirió la empresa, hay muchas cosas que se están trabajando, que eventualmente van a ir enriqueciendo la herramienta.



## Clase1_5 Firebase y Android

* [Regresar a la lección 1](#lección-1)

Para trabajar con "Firebase" independientemente de la plataforma que utilicemos necesitamos crear una aplicación, entonces vamos a entrar en el sitio y nos aparece, una parte en donde podemos ingresar el nombre de la aplicación y esto nos va generar un URL único, este URL es el "EndPoint" o hacia dónde vamos a apuntar las peticiones o el envío de datos de nuestro "BackEnd".

"Firebase" provee kits para que esto sea más fácil, pero también podriamos manejar como un "REST API" como cualquier otro.

La facilidad de que sea una base de datos de tiempo real, nos permite tener varias ventajas, entonces vamos a entrar a esta plataforma, vamos a registrarnos, a crear una aplicación nueva, y luego nos lleva a un "DashBoard" en donde tenemos todo lo que nos provee a partir de las características, entre ellos, pues están los datos, hay algo de analítica, hay autenticación, como es una base datos, puedo escribirle, ciertas reglas de seguridad, para condicionar quien puede escribir, quien puede leer, o si es de acceso libre, y con este "DashBoard" vamos a poder administrar en general todo.

Dentro del "DashBoard" hay una parte de autenticación donde eventualmente podemos habilitarlo, colocar las credenciales, si es con un tercero la autenticación, no con usuario o contraseña, con email contraseña, etcétera.

Ahora la parte de los datos, es un tema importante con "Firebase", hay que tener en mente que esto es no relacional, entonces vamos a tener una estructura con un formato similar al de "JSON" el "Java Script Object Notation" que es muy común para APIS modernos y permiten enviar datos de una forma, bastante clara, concisa y que no sea muy pesada.

Cada elemento dentro de "Firebase" va tener un URL asignado, entonces por ejemplo yo voy a tener una raíz del árbol que va ser el URL completo y sobre esa raíz voy a tener elementos, digamos voy a tener un, para el manejo de un listado de cosas por hacer, entonces cada elemento dentro de ese listado de cosas, va tener a su vez una URL y digamos que voy a guardar, quien lo agrego, que texto tiene, etcétera, entonces también cada parte de este elemento va tener su propio URL, es importante aunque se permiten muchos niveles para anidar datos, no abusemos de esto, porque eventualmente, esto tendría una repercusión en nuestro manejo de datos, entonces el modelo de cómo vamos a representar los datos es muy importante, y en la misma documentación de "Firebase" tenemos varias indicaciones de que hacer y qué no hacer.

Por ejemplo una práctica común es manejar índices, en los que voy a tener un valor que voy a representar el identificador y con ese identificador puedo ir a traer a otro nodo del árbol los datos.

Si yo hago la requisición sobre cierto nodo, digamos sobre la raíz, voy a traer todo lo que está debajo de ese nodo, que eventualmente, en un momento podría ser más de lo que el usuario necesita, entonces el modelo de datos hay que tenerlo en mente, recordemos que como es no relacional tengo esta estructura con varias ramas y que eventualmente al final voy a tener en formato de diccionario un "KEY" y un "VALUE" es decir un identificador o una llave de un lado y un valor asociado , del otro, que me va permitir guardar estos datos, ahora para trabajar esto con Android, tenemos varios pasos a seguir, el primero de ellos, es que podamos importar la librería, ya sea únicamente el cliente o algo adicional como por ejemplo "Firebase UI" para el manejo de interfaz, dentro del archivo de "GRADLE" en las dependencias, en algunos casos tenemos un problema de que hay duplicados entonces vamos a agregar dentro de Android, me refiero dentro del grupo Android, una opción de paquetes en donde excluimos algunos para evitar estos duplicados, una vez ya tenemos esto listo, entonces podemos trabajar con la inicialización, usualmente esto lo hacemos en un "ApplicationClass".

El "ApplicationClass" que es la clase que hereda de "Application" y que hay que indicar en el "Manifest" entonces en el "ApplicationClass" en el método "OnCreate" vamos hacer esta inicialización, es necesario únicamente inicializar la librería, es un método estático, también podría allí mismo indicarle a "Firebase" obtener una referencia a partir de un URL, el manejo de esto pues es un poco más abierto a discusión, creo que es una buena costumbre tener la URL en un solo lugar y conocer cuáles son los nodos, sobre los que vamos a estar trabajando, entonces cuando esto está listo, ya puedo proceder a acceder a "Firebase" y tanto leer como escribir datos.



## Clase1_6 Escribir y Leer Datos de Firebase

* [Regresar a la lección 1](#lección-1)

Para hacer una prueba de concepto, es decir algo de lo más simple y poder interactuar con la base de datos, leyendo y escribiendo datos, no necesitamos más que algo que envíe esos datos y un "Listener" algo que este escuchando para cuando haya datos nuevos.

Es importante que más que hacer consultas permanentes, lo que voy a utilizar es una suscripción, para obtener actualizaciones de tal forma que me quito la carga pesada, de estar constantemente pidiendo datos, y se las doy al servidor, y el servidor me va avisar cuando hay datos nuevos, ahora esto implica varias cosas, talvez la más importante es la que vamos a tener un canal abierto al servidor para recibir esos datos nuevos, entonces hay que tenerlo en mente, al construir nuestra aplicación.

Entonces que vamos hacer para probarlo, el diseño es muy sencillo, tenemos un "Input" un "EditText" en el que vamos a colocar algo, y un botón el que va provocar que ese algo se envíe, al servidor y vamos a tener un suscriptor, escuchando por el servidor, que nos va mostrar esos datos, una vez, que se haya actualizado.

Entonces para escribir si lo tenemos que resumir lo que vamos hacer es , elegir un nodo, descendiente, usualmente a estos en ingles les llamamos "Children" entonces vamos a elegir un "Child" sobre estos nodos, y vamos agregar información.

Para agregar información hay dos métodos que puedo utilizar "Push" y "SetValue" e incluso los puedo combinar, la diferencia básica es que con "SetValue" voy a indicar el valor que quiero colocar sobre el nodo, y con "Push" voy a pedir a "FireBase" que genere un identificador único, basado en la fecha y hora, entonces con "Push" la facilidad que tenemos, es que "FireBase" va generar este identificador, yo no me tengo que preocupar por ejemplo, de una llave primaria, con "setValue" ya envío los datos, una vez tengo ese modo de identificar.

Si quisiera manejar el "Key" que va controlar el "value" asociado, entonces puedo colocarlo manualmente.

Entonces para hacerlo, todo lo que necesito es una referencia, sobre el nodo que voy a escribir, podría ser la raíz, podría ser algún nodo descendiente, depende mucho del caso,

Entonces para la prueba, simplemente tomamos esa referencia, y hacemos una llamada, a alguno de estos métodos, definiendo cual es el nodo que quiero escribir y listo.

Entonces en el momento en que presiono click sobre el botón, voy a escribir esos datos hacia la referencia, y bueno, para que sea un poquito más "usable", vamos a borrar el contenido de lo que el usuario escribió, eso provoca que se envíe hacia el "Backend" hacia "FireBase" en este caso y podemos ver en tiempo real como se actualiza, como aquí estamos un nodo de prueba, es el caso básico, entonces no va ver tanto un problema en cuanto a buscar en donde esta sino que el mismo nodo, se va actualizar, y con eso escribimos.

Ahora para <em>obtener datos</em> lo que vamos hacer es un suscriptor que escuche por los eventos y modifique la información en base a los eventos que estamos recibiendo, para ello hay varias formas de hacerlo:

Entonces podemos hacer un "Listener" de eventos, para la referencia, y este puede ser de tipo <em>valor</em> : cuando está cambiando directamente de un nodo especifico o <em>descendientes</em> entonces tenemos un "ValueEventListener" para que cuando cambie el valor y un "ChildEventListener"

Por ejemplo si yo estoy haciendo un listado de cosas por hacer, voy a tener un nodo, que se llame,tal vez elementos, y debajo de ese nodo voy a poner todos los elementos, entonces para mostrar esos elementos en un listado en la aplicación, voy a tener una suscripción sobre ese nodo.

Por otro lado si tal vez, quiero mantener una actualización del estado de conexión, aunque esto "FireBase" ya lo maneja por su lado, pero si quisiera mantener un evento que sucede cada cierto tiempo, que no tiene descendientes, entonces podría ser un nodo que tenga estatus online/offline, y sobre ello manejar el "Listener".

Es importante que "FireBase" no va manejar un conteo de la cantidad de "Listener" entonces yo tengo que tener un código ordenado y saber cuándo agregar y quitar esos "Listeners".

El caso básico, pues lo puedo agregar en un "onCreate" o en un "onResume" y quitarlo en un "onPost" o un "onDestroy" dependiendo qué carga representa para el usuario tener este "Listener".

Ahora por si alguna razón me interesa un solo valor, y no me interesan las actualizaciones, entonces tengo un método disponible para ellos, se llama "addListenerForSingleValueEvent" entonces ese se va disparar una sola vez, no lo tengo que manejar como manejo los otros dos, sino va a implicar que no escucho por actualizaciones.

Entonces para recibir información, vamos hacer una suscripción sobre el nodo, como no tenemos un listado de cosas, entonces esperamos únicamente que sea un elemento, el que está cambiando, un valor, para este ejemplo, si tuviera una suscripción el "ChildEventListener" tiene varios métodos, cuando el descendiente, se agrega, cuando borra, cuando se mueve de un nodo a otro, y en los dos casos tenemos cuando hay un error, cuando se cancela la requisición para manejar ese error.

Entonces en el ejemplo básico pues lo agregamos a que escuche y cuando hay un cambio, entonces nos muestra un mensaje un "TOAST" el cambio no necesariamente tiene que ser del APP de Android, o del APP de Android corriendo en mi dispositivo, sino podría tener más de un dispositivo o provocar ese cambio en el navegador, que tiene ese DASHBOARD, en donde puedo manipular sin ningún problema, y me lo va mostrar para el ejemplo en el "Load" o en el emulador.

Resumiendo un poco, entonces para leer, voy a tener un suscriptor, ya sea para un solo evento, o para múltiples actualizaciones, puede ser por un solo valor o por todos los descendientes de un nodo, y para escribir voy a usar "setValue" o "Push" o ambos, y "Push" tiene la diferencia que me genera un identificador único en base a la fecha y hora, así que , así es como interactuamos con "FireBase".



## Clase1_7 Snackbar

* [Regresar a la lección 1](#lección-1)

Otro elemento de Material Design que tenemos,es el <em>"SnackBar"</em> que me permite comunicarme con el usuario de una forma que sea un poco más eficiente, que lo que existía hasta el momento,  en algún momento, seguro hemos trabajado con un "Toast" que sale en la parte inferior con una tonalidad gris y se desaparece, el "Toast" nos tiene mucha flexibilidad, aparece con una cierta duración corta o larga de acuerdo a como hayamos escrito el código y desaparece.

Algunas veces al querer comunicar al usuario cierta acción, es complicado saber que usar, por ejemplo, interrumpirlo y mostrarle un dialogo, tal vez, no sea la mejor idea,  un "Toast" tampoco, porque talvez, quiera deshacer la acción o poder deshacer algo más.

Entonces el "SnackBar" es la extensión del "Toast", es un aviso, pero es más flexible.

Para empezar necesita una vista que va ser el "Host" porque en esta vista va aparecer en la parte inferior mostrando un mensaje con cierta duración, <em>pero adicional a esto le voy a poder agregar una acción.</em>.

Por ejemplo, si estoy haciendo, no sé, eliminar de algo, es posible que se haya equivocado, entonces casi siempre se agrega aquí, una acción de deshacer, no es obligatorio agregar la acción, pero me lo permite,solo el hecho de tener la posibilidad de hacerlo me ayuda bastante.

Este elemento no es complejo, no tenemos que pensar, que el "Toast" cambio, pero a la vez, si tengo que considerar como utilizarlo, y hay varias referencias, entre las que pueden ir a leer más, por ejemplo la documentación oficial, la guía de Material Design y de parte de Google pues nos han contado un poquito más de como esperarían ellos que lo usemos, de nuevo, todo esto son buenas practicas que podemos poner en aplicación al desarrollar cualquier tipo de App.



## Clase1_8 TextInputLayout

* [Regresar a la lección 1](#lección-1)

Vamos a platicar de algunos elementos de "ui" y entre estos elementos de "ui" que se incluyeron en Materials Desing está el "TextImputLayout" este elemento si lo tuviéramos que resumir , pues es un envoltorio sobre un elemento ya existente, "EditText" y a este le agrega mayor funcionalidad.

El "Text Input Layout" le agrega características, por ejemplo permite "hint" o la sugerencia de texto que el "Edit Text" ha tenido siempre, no se borre al momento de escribir, sino se muestre un poco más pequeña arriba y de otro color, también permite reportar errores, entonces en el momento de que algo ocurrió, aparece un símbolo de error y me va mostrar un error que yo mismo, puedo configurar con un método "setter" un "setError" sobre el campo de texto, para que sea mucho más fácil de manejar.

Para que podamos usar "Text Input Layout" esto viene de la librería de diseño, entonces tenemos que agregar el soporte en las dependencias en el archivo "build.gradle" de el proyecto  en AndroidStudio :

```java
dependencies {
   compile 'com.android.support:design:23.+'
}
```
Luego en el "Layout" vamos a agregarle propiedades a este elemento.Al igual que todos los elementos tiene que tener ancho y alto, y la característica especifica de este elemento es que va estar anidado dentro de el, un "Edit Text" es decir puesto de otra forma "Text Input Layout" es un envoltorio para el "Edit Text" una vez, ya lo tengo así, lo puedo obtener en código, y puedo trabajar sobre cualquiera de los dos, ya sea sobre el "Text Input Layout" o sobre el "Edit Text" y puedo colocar lo que considere necesario, entre ello pues el "hint" y los errores para reportárselo al usuario es lo más común.


Cuando trabajamos Materials Design, evaluamos un poco de estos elementos nuevos que tenemos, hay una en particular que llama la atención, porque la barra de acceso, ha sufrido varias modificaciones a lo largo del camino, actualmente pues lo que tenemos es "App Bar" y "Tool Bar".

Entonces en base a esto, hay varias partes importantes del menú, en la parte superior de un APP.

Por ejemplo puedo tener un icono de navegación, para mostrar un "Navigation View", puedo tener un título, para mostrar cierto contenido relevante al usuario, que tiene que ver con lo que está visualizando en ese momento, y además puedo tener botones de acción, estos botones tienen un icono, y aparte aparece a su lado, un icono de menú, bajo el icono de menú, tengo más acciones, pero ellas no tienen un icono asociado sino solamente es texto, en base a que tanto se use esta acción, puedo tomar la decisión de colocarlo en uno u otro.

Entonces para <em>utilizar el "Tool Bar"</em>que es esta extensión, sobre el App Bar que teníamos antes, necesito varias, cosas, necesito primero agregar la librería de "AppCompat" en "gradle" y que mi actividad herede de "AppCompat" luego necesito especificar que colores, voy a estar utilizando, entonces hay varios sitios que me ayudan a elegir estos colores, o puedo tomar algún tema, generado por AndroidStudio, que este especificado.

```java
dependencies {
   compile 'com.android.support:appcompat:v7:23.+'
}
```

Luego como el "Tool Bar" reemplaza, al "Action Bar" que teníamos antes, tengo que especificar que la aplicación o la actividad que esté usando, dependiendo que tanto es usado mi "Tool Bar" no tenga un "Action Bar" esto lo puedo hacer especificando el estilo en donde voy a modificar el estilo del window(ventana) en "style.xml" y luego en el "manifest" indicar que mi actividad o la aplicación completa, va estar utilizando este tema, que no tienen "Action Bar" y luego especificar en la actividad que , vamos a mostrar ese, contenido en vez del "Action Bar" tradicional.

Con esto especificado y agregando los tamaños necesarios, ya lo puedo incluir dentro de mis estilos.

Ahora es común, que este estilo, que el "Tool Bar" vaya dentro del "Action Bar" y a su vez, esto vaya dentro de un "Coordinator Layout".

Cuando trabajamos, "Tabs" y navegación con este tipo de elementos, también va dentro del "APP Bar" va junto al "Tool Bar" y todo reemplaza al antiguo "Action Bar".

Entonces es otro elemento de Material Design que tenemos que explorar, nos permite una personalización, bastante amplia, por ejemplo agregar imágenes, agregar texto, etcétera, podemos poner un "Layout" dentro del APP Bar, podemos manipular el "Tool Bar" y vale la pena explorar, desde el lado de diseño, como han cambiado las guías, hasta el lado de código de como implementamos esto en nuestra aplicación.

El menú ha cambiado en las diferentes versiones de Android, actualmente, pues tenemos un icono de navegación, que nos lleva al "navigation view",un título, iconos de acción y el icono del menú, ambos los vamos a trabajar como elementos del menú.

Para ello definimos los elementos dentro de un "xml" entonces vamos agregar un recurso dentro del folder del menú, y le ponemos algún nombre por ejemplo menú_ y la actividad en la que lo vamos a estar utilizando, y dentro de este archivo agregamos elementos usando el tag de "Items" y allí podemos especificar si queremos que se muestre como una acción, si hay espacio, nunca o siempre si tiene un icono asociado, si tiene un identificador asociado(esto es  necesario para validar que acción vamos a realizar), etcétera.

Una vez que ya tenemos este archivo, entonces en la actividad tenemos que indicar que hay un menú, para ello sobrecargamos un método "onCreateOptionsMenu":

```java
@Override
public boolean onCreateOptionsMenu(Menu menu){
	getMenuInflater().inflate(R.menu.menu_main,menu);
	return true;
}
```
En este método inflamos con un "Layout Inflater" el "xml" que definimos en el paso anterior, y usualmente devolvemos una llamada a su ancestro con "Super".

Ahora cuando el usuario selecciona algo, se manda a llamar otro método este método es "onOptionItemSelection" y sobre el vamos a tener un menú "Item" sobre este "Item" podemos obtener un identificador y comparar con los identificadores, que definimos en el archivo, donde describíamos el comportamiento del menú, en base a eso realizamos algún acción, por ejemplo cerrar sesión, cambiar de actividad o una búsqueda o lo que corresponda, pero lo hacemos bajo el concepto de menú, si queremos saber más información de esto, la documentación oficial de Android, también incluye una especificación, bastante completa del menú, así que este es, otro elemento más de "ui" que debemos conocer



## Clase1_10 CoordinatorLayout

* [Regresar a la lección 1](#lección-1)

Un elemento de Material Design tiene características bastante interesantes es el "Coordinator Layout", lo que hace es coordinar todo, es decir la interacciones que tienen los elementos hijos que están en la jerarquía bajo este elemento.

En general esa coordinación puede realizarse en base a código que nosotros coloquemos.

Pero hay algunas cosas que ya coordina de caja, por ejemplo, va coordinar la forma en que interactúa un "Recycler View" con un "Tool Bar" cuando hay un Scroll.

Hay un efecto muy bonito que se llama "parallax" en el que un encabezado cambia de tamaño o se oculta, en base al scroll del usuario, esto lo podemos lograr con el "Coordinator Layout".

También maneja el anclaje del "Floating Action Button" y muestra los "SnackBars" a que me refiero con esto, no es que no pueda mostrar un "SnackBar" sino tengo un "Coordinator Layout" pero si lo tengo, los elementos hijos de este Layout, van a responder ante los eventos.

Digamos por ejemplo que tengo un "Floating Action Button" y que quiero mostrar un "SnackBar" lo que hace el "Coordinator Layout" dice, "Ah ok", aquí está el botón y ahora vamos a poner un mensaje abajo, entonces movamos ligeramente el botón hacia arriba, para que no quede el mensaje por encima, es un detalle muy pequeño, pero es un detalle de usabilidad que resulta muy conveniente y que no tenemos que hacer nada para implementarlo, es parte de la funcionalidad que ya incluye el "Coordinator Layout" a partir de cómo está construido.

Entonces en base a esto, podemos elegir como trabajar todos los elementos, dentro de una pantalla de una actividad, teniendo "Coordinator Layout" como coordinador,teniendo un "AppBar" y dentro un "Tool Bar" y luego presentando el contenido, este contenido usualmente puede ir con un "Relative Layout" que ya me va permitir ordenar o bien con un "Linear Layout", si yo quisiera algún tipo de interacción avanzada entre los múltiples elementos, lo puedo implementar sin ningún problema con el "Coordinator Layout" así que además de conocer los elementos específicos, es necesario conocer como funciona el elemento que los coordina todos, y este es este "Layout" nuevo llamado "Coordinator Layout".




## Clase1_11 Floating action button

* [Regresar a la lección 1](#lección-1)

Otro elemento de "ui" que introdujo Material Design es el <em>"Flouting Action Button"</em> este es un botón que tiene una forma circular, y usualmente va en la esquina inferior derecha, la guía de especificación de Material Design nos da a conocer un poco sobre el tamaño que debería tener, el realce que debería tener, la sombra que debería tener y donde se ubica, hay una versión mini y una versión tradicional digamos.

La versión mini, usualmente va en la parte superior junto a un encabezado.

La versión tradicional, pues va en la esquina inferior derecha.

Si tomamos esto como referencia la intención, es que me permita ejecutar, una acción que sea común y que sea importante para mi App, no es un requisito, esto hay que tenerlo en mente, si mi App tiene muchas acciones o no hay una que sobresalga entre todas, entonces talvez no necesito un "Floating Action Button" .pero para citar algunos ejemplos:

Si tengo un listado y quiero agregar un elemento al listado, podría ser una buena opción, por ejemplo en un cliente de correo electrónico, ese botón, me permite escribir un evento nuevo, y si tengo un calendario, podría agregar un evento nuevo o un recordatorio, entonces es posible que al hacer click sobre este elemento o al presionarlo me muestre un segundo menú, sobre de que podría ser.

La regla de esto, esta en la especificación de Materials Design entonces vale la pena ir a leerlo, para saber cuál es la forma correcta de implementarlo, los colores, el realce, etcétera.

Para agregarlo en nuestro proyecto, necesitamos la librería de diseño que incluye varios elementos y la vamos a agregar en "gradle".Luego, especifico cual es el "Layout" del botón al igual que otros elementos, tienen nombres un poquito largo, que pertenece a un paquete de "widget" pero no tiene una característica que sea muy distinta de otros elementos, tiene que tener un ancho y un alto, le vamos a poder poner una ubicación usualmente esto lo hacemos con un anclaje, para indicarle en que parte se encuentra, y la funcionalidad me va permitir manejar un click al igual que lo manejo sobre otros elementos, lo puedo manejar con una clase anónima, o lo puedo manejar usando una librería como "ButterKnife".


## Clase1_12 Circle Image View

* [Regresar a la lección 1](#lección-1)

"Circle Image View"  es una librería que presenta una adición al "Image View" tradicional de Android y permite colocar de manera sencilla una imagen redonda y un borde.

Para usarla igual que la librería de librerías, tengo que modificar mi archivo "build.gradle" en dependencias y agregar el soporte para esta librería:

 ```java
dependencies {
	compile 'de.hdodenhof:circleimageview:2.0.0'

```

## Clase1_13 EventBus

* [Regresar a la lección 1](#lección-1)

Ya vimos que la comunicación desde el modelo o el repositorio hacia el presentador podría ser, con una interfaz o haciendo uso de una librería como "EventBus".

<em>EventBus </em> permite centralizar la comunicación y a través de esta centralización y simplificación de comunicación, vamos a desacoplar el código.

Entonces en una aproximación tradicional podría tener por ejemplo una actividad, que le hable a un servicio, que le hable a un fragmento, que le hable a una actividad y entonces allí es cuando sufrimos con ese ciclo de vida tan complicado, en vez de eso, lo que permite "EventBus" es que por ejemplo una actividad le hable al bus, y otra actividad escucha ese bus, y reciba los resultados.

En nuestro caso especifico, pues el repositorio, va a emitir eventos y el presentador va a capturarlo, entonces va ser mucho más sencillo esto, no vamos a usar una clase adicional, sino a través del bus de datos vamos a enviar esta comunicación.

Podríamos crear múltiples instancias, nosotros vamos a usar únicamente una, y a través de esta instancia de "EventBus" vamos a enviar los mensajes necesarios para la comunicación.

Hay más de una librería, vamos a trabajar con "EventBus" así se llama el patrón, así se llama la librería, es hecha por "GreenRobot" y una alternativa sería trabajar con "Otto" que es hecha por "Square", podemos compararlos, en realidad hay varios beneficios que se obtiene con la aproximación de "GreenRobot"(un poco más rápido , más opciones , etc).

Es importante entender que existen <em>alternativas</em>y sobre todo que al implementar una librería vamos a hacer un envoltorio o un "wraper" de tal forma que tengamos una interfaz  base, con los métodos necesarios, y una implementación concreta lo que nos va permitir no depender exactamente de esa librería.Aunque si dependamos del uso de ciertos métodos, porque si en algún momento, la librería se deja de utilizar, o se vuelve obsoleta o pasa algo, voy a poder buscar un reemplazo e integrarlo en mi aplicación sin sufrir con que este acoplado con las llamadas especificas hacia esta librería.

Entonces para usar "GreenRobot EventBus" vamos a agregarlo en "gradle" en el archivo de la aplicación en las dependencias le agregamos la referencia, vamos a trabajar con la versión 3.0 y para utilizarla definimos un evento.

Este evento, es un objeto de JAVA no tiene mayor especificación rígida que tenemos que hacer, usualmente lo que vamos hacer nosotros durante el curso, es colocarle, un error o un mensaje para reportarlo y a veces cuando hay más de un tipo de evento, le agregamos también una variable que lo especifique y constantes que describan cuales son las opciones, este evento va tener "getters" y "setters" y para usarlo vamos a emitirlo, previo a emitirlo, necesito que haya algún Suscriber, alguien escuchando por eventos, usualmente ese va ser nuestro presentador y usualmente en el presentador vamos a tener un método "OnCreate" y "onDestroy" en el que nos suscribimos y desuscribimos de "EventBus" van a ir asociados con el método "onCreate" y "onDestroy" de la actividad, pero la lógica de esto, va en el presentador luego, en la misma clase que se suscribió, vamos a escribir un método usualmente este es "onEventMainThread" porque podemos manejar "Treading" con los eventos nosotros vamos a estar trabajando con la vista, por eso vamos a estar trabajando directamente con el "MainThread" y le vamos a agregar una anotación de suscripción "@subscribe" para indicar que ese método va ser invocado en el momento en que ese evento sea emitido, luego en el lugar donde emitimos, por ejemplo en el repositorio, vamos a usar un "Post" instanciando esta clase y nuestro presentador lo va recibir sin ningún problema.

Esto lo vamos a tener en diferentes partes del curso, en la parte de arquitectura para que el repositorio hable con el presentador, pero no hay ninguna restricción que sea únicamente allí, lo podemos implementar en muchos lugares, y es importante tener en cuenta, que debido a que es tan flexible, y nos facilita la vida, en algún momento podriamos caer en un anti patrón, por ello algunas personas abogan por la programación reactiva, es una opción que vale la pena aprender, hay que leer un poco más de ella, por el momento vamos a trabajar directamente en "EventBus" y en el enlace oficial encuentran más información.


## Clase1_14 Glide

* [Regresar a la lección 1](#lección-1)

"Glide" es una librería para cargar imágenes en base a un URL, descargar esa imagen y poder mostrar desde un "ImageView".

Glide es una de varias opciones, disponemos de algunas otras, como tal vez la más popular Picaso, u opciones ligeramente diferentes como Fresco, en el caso de nuestro curso, hemos elegido "Glide" porque el manejo es bastante eficiente, de hecho he le dio un par de "Post" donde ingenieros de Google recomiendan que esta sea la librería que usamos y tiene decodificación, Caching, manejo de memoria y centrado, tiene varias opciones interesantes.

Para poder agregarla vamos a modificar "gradle" y esta librería requiere la librería de soporte de Android, entonces podemos incluirla, sola y esperar que el IDE lo haga por nosotros o podemos agregar las dos, ambas en dependencia y en los repositorios necesitamos el repositorio central de "maven"


 ```java
 repositories{
 	mavenCentral()
 }

 dependencies {
	compile 'com.github.bumptech.glide:glide:3.7.0'
	compile 'com.android.support:support-v4:19.1.0'
 }

```

Mucho de la gracia de estas librerías es que administran por mí el ciclo de vida, de la carga de imágenes, una de las librerías más comunes de acceso a red, que es "Bundle" también me permite cargar imágenes, sin embargo como no está especializada, no va tener el mismo desempeño.

Para usarla como mencionaba lo que vamos hacer es leer de una fuente de datos, entonces voy a usar un "Glide Request Manager".

Para usar "Glide" entonces voy a tener un "Manager" que va iniciar la requisición, y tengo que inicializar esto con un contexto, lo interesante de "Glide" se pega al contexto del objeto que tenga, siguiendo el ciclo de vida, entonces puedo enviarle un "Application Context" y desaprovecharlo o enviarle un "Activity" que tenga el "ImageView" que Glide va a llenar con la carga de datos, luego le indico cuál es el URL y cuál es el target o el objetivo donde voy a cargar esta imagen, este es el caso más fácil.

Tengo algunas otras opciones, como por ejemplo, manejar un centrado, manejar un tamaño fijo, que sobrescriba el tamaño que recibió de la librería, manejar también por ejemplo un listener, para que cuando se terminaron de cargar los datos, es otro caso común y en general al igual que muchas librerías es recomendable envolverla dentro de una librería propia, con la que podamos trabajar, entonces podemos trabajar una clase base que tenga todas estas características, podemos leer mas de "Glide" en "GitHub".

Los casos de uso que vamos a tener durante el curso va ser únicamente, ir por las imágenes, en algunos casos, mostrar la imagen, o reaccionar hasta que la imagen, hasta que esta haciendo mostrada, para lo que nos va servir un "Listener" de que haya terminado y en algunos otros casos, cortar el tamaño, para que quede bien dentro de nuestro contenido, pero la librería permite mucho, por lo tanto, creo que si les sirve bastante en su día día y están trabajando con muchas imágenes, vale la pena que conozcan qué aporta Glide y como se distingue de Picaso y como se distingue también de Fresco y cualquier otra librería que pueda salir en el futuro, así que por el momento para la carga de imágenes esta es la recomendación de librería.



# Lección 2:

## Tabla de contenidos

* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Código del Presentador](https://github.com/ykro/android-twitter)
* [Inyección de Dependencias](#clase2_1-inyección-de-dependencias)
* [ViewPager y tabs](#clase2_2-viewpager-y-tabs)
* [Recycler Aninado y CardView](#clase2_3-recycler-anidado-y-cardview)
* [Swipe](#clase2_4-swipe)


## Clase2_1 Inyección de Dependencias

* [Regresar a la lección 2](#lección-2)

El <em>principio de inversión de control (IoC)</em> básicamente indica que el control no lo va tener el software que estoy escribiendo si no el control lo va a tener un Framework que va ceder ese control para que yo lo tome y con él pueda hacer algo.

Esto provoca que tengamos que definir claramente un ciclo de vida, en el cual vamos a especificar cómo interactua  mi software con el Framework.

Ahora el principio de inversión de control, me permite que eventualmente pueda definir cuáles son las dependencias de una parte de un módulo de mi software, y con eso también invierta las dependencias.

La parte de <em>inversión de dependencias</em>, es una forma de ejecutar esta inversión de control y para ello, me baso en uno de los principios de SOLID.

SOLID es un acrónimo que especifica, principios básicos de programación orientada a objetos, principios de responsabilidad única, cerrado o abierto, nos interesa principalmente la D, porque la D, es el principio de inversión de dependencias.

Tenemos que comprender que el objetivo, es que dependamos de abstracciones, no dependamos de los detalles específicos, de cómo lo llegamos a implementar, sino de todo lo genérico, porque de lo contrario, si dependemos de cosas concretas el código va a acoplarse, es decir va a quedar una dependencia invisible.
 
Entonces si violamos este principio dentro de SOLID, el principio de inversión de dependencias, nos complicamos en cuanto a Testing, el código va funcionar, vamos a tener un resultado, pero cuando queramos hacer cierta modificación, va ser muy difícil, es similar a discusión sobre la arquitectura, no hay algo que me imponga que tengo que usar Inversion de Dependencias, pero si lo hago, y si dependo de abstracciones va ser mucho más fácil manejar los módulos, extenderlos, agregar mayor funcionalidad y va ser mucho más fácil hacer testing.

 <em>La inyección de dependencias, va ser una forma de manejar el principio de inyección de dependencias </em>.

Lo más importante es que tengamos en mente el principio de Hollywood, que es no nos llames, nosotros te vamos a llamar a ti.Lo mismo es aquí, únicamente que con software.

Es importante que esto se va ejecutar, con que no vamos a estar haciendo "new", las instancias no las vamos a realizar dentro de la clase, que va tener esa inyección, sino que van a llegar de alguna forma.

¿Cómo van a llegar en el momento que se requiera?. Se usa cierto software, que es una librería, que es un inyector de dependencias, NO es un requerimiento PERO nos facilita bastante la vida.

Ahora esto es común que haya inyección de dependencias, yo creo que básicamente lo encontramos de alguna forma en todo el software, lo que pasa es que si no lo conocíamos , tal vez no lo veamos tan fácil, tiene varios beneficios:

<ul>
	<li>El principal es que vamos a desacoplar</li>
	<li>Vamos a tener una modularización mucho más obvia  </li>
	<li>Nos va permitir hacer testing automatizado de una manera muy sencilla</li>
</ul>

Muchas de las decisiones en software,se hace en base a cómo vamos hacer las pruebas de los componentes, incluso hay metodologías, en las que se escriben primero las pruebas y esto guía las pruebas del desarrollo, como "TDD" o "OVDD" la diferencia entre ellos es como manejamos el origen, ya sea con pruebas o con comportamientos que se pueden reflejar en esas pruebas, aterrizando en eso con cosas concretas.

Llevándolo a algo que podemos aplicar,nosotros hemos construido aplicaciones hasta el momento con la arquitectura MVP para la parte que se ve, y CLEAN para el repositorio y los interactors.

En MVP, por ejemplo tenemos al presentador, y va ser bastante obvio una vez, que ya entendimos esto, el presentador tiene una dependencia de los componentes, que son el modelo y la vista, entonces el presentador va tener una instancia del modelo y la vista.

<em> Al trabajar con interfaces, ya estamos empezando a poner en práctica, el principio de inversión de dependencias</em>, pero esas dependencias en muchos casos vienen de forma manual.

Entonces por ejemplo sin inversión de dependencias, yo voy a tener un presentador que requiere de un View, y requiere de un MODEL, pero además como voy a estar trabajando con EventBus, requiere de una instancia de EventBus, entonces hay dependencias allí.

¿Cómo lo hago sin inversión de dependencias?.

Voy a tener instancias, la vista, tal vez no lo voy a instanciar, porque es una actividad, esa si la recibo en un constructor pero por ejemplo el modelo lo voy a instanciar, el modelo el interactuador, y tal vez EventBus no voy a tener una instancia, sino voy a tener un Singleton, de cualquier forma, voy a tener ciertas llamadas, que van a estar encapsuladas dentro del constructor, eso es una mala idea.

En vez de eso con inversión de dependencias, vamos a recibir todo lo que depende de la clase, en el constructor, ahora si yo tengo algo estático que no va cambiar, y que el objeto no va estar construido en función de esto, entonces no lo voy a agregar aquí, <em>sin embargo todo lo que dependa, lo voy a declarar como una variable global, o como un campo y lo voy a recibir dentro del constructor</em>.

Eso lo que eventualmente da lugar, es que esté recibiendo varios parámetros en la construcción de mis objetos, y que toda esa serie de instancias la tenga que hacer en algún lugar, ahora ese, conjunto de instancias, es en lo que me va ayudar el inyector de dependencias, entonces ya llevando esto a la práctica, hay varias opciones, pero probablemente la mejor en Android es DAGGER, y recientemente, hace un par de meses, salió DAGGER 2, es la evolución de Dagger, la primera fue construido por SQUARE y DAGGER"  y la segunda fue construido por GOOGLE en apoyo con SQUARE, y tiene varias mejoras.

El inyector de dependencias va requerir de anotaciones, va requerir de código, que vaya ser generado, entonces en la versión mas nueva, los errores son mucho más específicos, no tengo tanto problemas para detectarlos.

Ahora al trabajar DAGGER2 voy a tener dos cosas, voy a tener componentes por un lado y módulos por otro.

<em>El componente</em> va exponer la forma en que se inyectan las dependencias, cuál es el objetivo, cuál es el target sobre el que voy a inyectar, o a través de que métodos voy a realizar esta inyección, y a la vez va permitir unir múltiples módulos, cuando unos requieran dependencias que otros están proveyendo.

<em>El modulo</em> es la inyección especifica que vamos a tener en donde allí sí instanciamos los objetos, para que los use el TARGET de la inyección.

Para trabajar con DAGGER2, hay varios pasos que debemos seguir, entre ellas pues tenemos que agregar las dependencias y aunque agreguemos únicamente una línea dentro del archivo GRADLE este requiere de otras cosas adicionales, entonces en el archivo raíz, vamos a tener que agregar un "classpath" para APT, lo que hacer APT, manejar las anotaciones para que sean reconocidas, además de agregarlo allí, vamos a tener que ir al archivo del APP de GRADLE también y allí vamos agregar el plugin de APT y especificar la referencia hacia DAGGER, luego de ello, ya podemos proceder a escribir nuestro componente.

Usualmente al componente le ponemos la anotación de Singleton con un @Singlenton, le agregamos también la anotación más bien de componente @Component, y especificamos que modulo va estar usando el componente.

Como este es un API sobre el que voy a estar accediendo a ciertos métodos, es una interfaz, no es una clase, y tengo dos formas de especificar esto, una de ellas es con un método "void inject" o "void" como le quieran llamar, lo importante es que sea "void" y como parámetro cual es el target sobre sobre la inyección.

Por ejemplo si voy a usar una actividad o un fragmento o algún tipo de target, esa es una forma.

La otra, es un poco más explícita, va permitir devolver un objeto cualquiera, con un nombre de método cualquiera, pero el modulo asociada a este componente tiene que tener un método que provea ese tipo de objeto que estoy devolviendo, por ejemplo si voy y a tener un "LoginPresenter getPresenter" siendo esa la firma del método, tengo que tener en un módulo asociado a este componente algún método "provides" que regrese ese LoginPresenter, si no lo tengo, pues me va mostrar ese error a la hora de compilar.

En el módulo voy a especificar métodos para proveer esas dependencias, usualmente esos métodos van con la anotación también de Singleton, y vamos a indicarle también en él, en la anotación que provee, ponemos el tipo de datos que está proveyendo y un nombre usualmente lleva "provides" y el objeto que está proveyendo, si quiero devolver dos objetos que tengan el mismo tipo, pero son diferentes, puedo usar una anotación para ponerle nombre @name, esto lo voy a manejar para todas las inyecciones que quiero hacer.

En el caso de la arquitectura vamos a inyectar en el presentador, las referencias hacía, el interactuador o los interactuadores, hacia a EventBus y hacia lo que necesite como librerías, en el caso de, por ejemplo el interactuador, vamos a inyectar allí, la referencia hacia el repositorio, en el caso del repositorio una referencia hacia la lógica del dominio, de esta forma puedo realizar también la inyección de todo lo que necesito, ahora esto es un concepto que requiere mucha práctica, entonces hay que tener en mente, que en la primera parte de la inyección talvez, no nos sea tan fácil, pero conforme lo vamos haciendo se va volviendo más sencillo.


## Clase2_2 Viewpager y Tabs

* [Regresar a la lección 2](#lección-2)

El ViewPager me permite tener como su nombre lo indica una serie de páginas sobre las que puedo cambiar, este cambio usualmente se hace con el gesto de Swipe, o de arrastrar sobre la pantalla

El ViewPager, esta como parte de la librería de diseño y el Layout va especificar cosas muy simples, como por ejemplo, el tamaño, el ancho y alto y el identificador, luego además de especificar eso, voy a necesitar, que cada página de lo que voy a mostrar, sea un fragmento y para manipular todas esas paginas voy a utilizar un adaptador, entonces vamos a colocar una aunque la especificación sea únicamente un componente pequeño del layout.

Usualmente este adaptador hereda de un objeto ya existente, para controlar esas secciones y tiene un par de métodos necesarios, ahora al construirlo tengo varios métodos que sobrecargar, por ejemplo, voy a tener un FragmentPagerAdapter, y necesito sobrecargar un constructor, que va recibir un FragmentManager y luego lo demás es disponible para que yo lo pueda personalizar, voy a tener un GetItem para obtener el fragmento correspondiente en base a la posición y un getCount donde voy a tener el conteo total, usualmente esta implementación cuando no es muy compleja, la realizo con un arreglo o un listado de fragmentos y también con un arreglo o listado de títulos cuando tenemos tabs y sobre ellos realizamos las opciones para obtener algo en base a la posición.

Ahora si lo que tengo es un contenido que va usar el mismo fragmento, pero cambia lo que va adentro, entonces me conviene mejor modificar únicamente eso, en base a la posición podría mostrar un contenido, por ejemplo un texto, una imagen, etcétera, de acuerdo a eso va cambiar como se implementa, si yo espero tener por ejemplo 10 imágenes no vale la pena, un fragmento diferente por cada una de ellas, voy a tener un solo fragmento y en base a la posición voy ir a traer la imagen que toca, ahora en este caso vamos a tener dos pestañas únicamente, o dos elementos del ViewPager, uno va tener las imágenes y otro el Hashtag y van a ser distintos.

Entonces voy a manejar dos fragmentos diferentes, dependiendo el caso, el contenido del adaptador puede variar, luego lo que tengo que hacer en el código de la actividad es obtener este ViewPager y le voy a indicar cuál va ser el adaptador que lo va manipular entonces, tengo que tener una instancia del adaptador y eso es todo.

Entonces la navegación es relativamente sencilla una vez, que tenga claro que cada página es un fragmento y que por lo mismo necesito un adaptador que vincule a los fragmentos, que en este caso son la fuente de información con la vista, que es el ViewPager que voy a estar visualizando, hay más información de esto en la documentación oficial, la podemos ir a consultar sin ningún problema incluso hay algunas guías de cómo implementarlo, mencionaba al inicio que esto estaba vinculado tabs, porque voy a poder además del gesto de arrastrar en el que decía que puedo mover de un lado a otro, voy a poder tener pestañas o encabezado, que me van a permitir también hacer un clic, sobre esto, para implementarlo, necesito que en el layout exista una referencia, tal vez lo mejor sería tener un AppBar una BarLayout y sobre el tengo una referencia a un TabLayout, este TabLayout lo unico que va colocar es un elemento de UI adicional a la barra, ya sea un Tolva o un AppBar voy a tener ese elemento adicional y luego en código, voy a decir obtengamos ese TabLayout y le decimos únicamente una llamada SetupWithViewPager y le enviamos el ViewPager, va usar el mismo adaptador, va usar todo igual, los eventos van a estar asociados

Aahora ese método permite que los dos elementos estén funcionando juntos, y que usen, todo lo mismo, entonces nosotros vamos a usar los dos, vamos a tener los tabs, y por eso es que mencionaba que en el adaptador enviamos títulos, entonces en nuestra implementación vamos a tener un arreglo de fragmentos y vamos a tener un arreglo de Strings, para los títulos y así como tenemos un método que devuelve el fragmento actual, vamos a tener otro método que devuelve el titulo actual en base a la posición, como lo construimos, está abierto a discusión pero hay algunas cosas que son comunes en las diferentes implementaciones.

Resumiendo un poco, tengo el ViewPager que es para usar el gesto Swipe y cambiar entre páginas y tengo el TabLayout que lo que me va permitir es tener pestañas y voy a poder cambiar haciendo click sobre ellas, tal vez la mejor idea es que estén trabajando juntas, es una buena sugerencia que podrían implementar, y por lo mismo cuando configuro Tabs usando el ViewPager lo hago de una forma muy sencilla, aprovechando el mismo adaptador que ya tenía antes, en los dos casos el contenido van a ser fragmentos, y van a ser fragmentos administrados por un adaptador, que pasas si no quiero fragmentos, hay formas de hacerlo, pero en la mayoría de casos me va ser muy útil tener esos fragmentos, el adaptador me va permitir configurar este comportamiento de los fragmentos, en base a que si cambia mucho, como va ser nuestro caso en la aplicación de Twitter, o si no cambia tanto, por ejemplo si tuviera un solo texto, modifico la vista, de cualquier forma esa es la implementación que vamos a seguir.



## Clase2_3 Recycler anidado y CardView

* [Regresar a la lección 2](#lección-2)

Ya conocemos como trabajar con el RecyclerView, es un elemento que se agregó en Material Design en la versión de "Lolipop" de Android

Sin embargo puede darse en caso que yo quiera un RecyclerView anidado, es decir un RecyclerView dentro de una de las filas del RecyclerView, aquí el problema es que no tenemos un Wrapping de forma nativa, entonces tengo que especificar un cierto tamaño específico para el RecyclerView lo que provoca que no sea tan fácil el uso.

Para solucionarlo implementamos un LayoutManager escritos por nosotros mismos, esta implementación, pues la pueden encontrar en referencias de varios sitios de preguntas y respuestas, como StackOverFlow, entonces nosotros para nuestro caso en Twitter vamos usar esta implementación con un Grid y vamos a poder anidar el RecyclerView, hasta el momento en la versión actual de la librería que existe, esto no es posible hacer el Wrapping, es posible que en el futuro lo implementen, porque es bastante conveniente, y la forma de hacerlo requiere conocer cómo se hace la medición para mostrar el contenido, la verdad no es una implementación difícil, así que aunque esto es válido para este momento con esta versión de herramientas que es la versión 23.1, es posible que en el futuro lo cambien y que ya no tengamos que hacer esto, por el momento lo manejamos de forma manual, además del RecyclerView anidado.

Vamos a ver un elemento adicional que se llama <em>CardView</em>, hereda de FrameLayout y su funcionalidad es la representación de un objeto sea uniforme a lo largo de múltiples dispositivo recordemos la consistencia es un componente importante en interfaz y Android está presente en aplicaciones por ejemplo de Televisión, Wearables, en carros o automóviles en el teléfonos, en móviles en tables, en algunas soluciones de internet de las cosas, entonces aunque la interfaz sea diferente en cada caso, esperamos cierta consistencia, entonces el CardView viene a proveer eso, que entre diferentes dispositivos podamos tener cierta consistencia, además de sombras y bordes redondeados, para implementarlo vamos a hacerlo con una librería similar con la que hicimos con RecyclerView, para que soporte todas las versiones y en el Layout, vamos a poder agregarle estas propiedades, como la sombra, como el borde redondeado, etcétera y va a también a envolver a lo que sea que queramos poner, entonces usualmente cuando hacemos un RecyclerView que queremos que tenga cierta consistencia a lo largo de múltiples dispositivos, cada fila va ser un CardView, no hay un requerimiento pero nos ayuda, en nuestro caso en la aplicación de Twitter vamos a usarlo también, para construirla de esa forma, cada elemento, no va ser una fila sino un Grid, va tener un CardView, que nos va mostrar el contenido con cierto formato.



# Lección 3


## Tabla de contenidos

* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Código del Presentador](https://github.com/ykro/android-recetas)
* [Retrofit](#clase3_1-retrofit)
* [DBFlow](#clase3_2-dbflo)
* [Food2Fork](#clase3_3-food2fork)
* [Swipe](#clase3_4-swipe)

## Clase3_1 Retrofit

* [Regresar a la lección](#lección-3)

Retrofit : librería para hacer peticiones a un API, estas peticiones se pueden hacer de muchas maneras pero hacerlas manualmente usando un "Thread" o un "Assign Task" una petición de HTTP y haciendo el reconocimiento manualmente del JSON que nos devolvió,puede llegar a ser altamente ineficiente, hay varias opciones para hacer las peticiones

Actualmente una de las opciones más confiables , sencilla y usadas es retrofit.

La alternativa más conocida es "Volley" que es una librería que ofrece Google sin embargo en algunas estadísticas Retrofit tiene un rendimiento un poco mejor.

Lo que hace retrofit es que toma un API HTTP y lo convierte en una interfaz de java , básicamente tiene 2 partes: servicio y cliente.

Servicio: van a exponer este API, y allí nosotros especificamos, de qué forma, vamos a consumirlo, entonces ponemos el verbo, "GET", "POST" etcétera, el nombre del método y los parámetros

en el CLIENTE vamos a especificar como se realiza ese consumo, entonces allí ponemos un URL base, ponemos si se va parsear con "JSON",con "GSON" o con algún otra librería de reconocimiento de "JSON" y luego fuera de esto, tenemos un cliente, del que obtenemos un servicio, y sobre el servicio realizamos la llamada del método,

entonces el método del API por ejemplo si tengo un método SEARCH, tengo un método GET NAME, tengo un método LIST NAME, etcétera, se convierte en un método de la interfaz, entonces lo puedo acceder de forma local con código de JAVA, y por detrás, Retrofit, va ser esta consulta, y nos va presentar un resultado.

Cuando comparamos con alternativas, podemos ver que el desempeño de Retrofit es mejor, y creo que de cualquier forma es una buena idea usar una librería para esto, al igual que otras librerías, tiene que ir "envuelta", porque en el momento en que cambie eso nos puede afectar.

Para trabajarlo usamos el mismo caso, que en otras librerías usamos GRADLE y agregamos el soporte en las dependencias, una vez que ya lo tenemos agregado, vamos a definir una clase, que va ser el servicio.

Por ejemplo, podemos llamarle a esta clase, GIT HUB SERVICES y obtener un listado de REPORT de GITHUB y aquí especificamos el verbo luego cual es el ENDPOINT después del URL base luego podemos especificar que nos devuelve o podemos especificar si no devuelve nada, también el nombre del método y los parámetros, usualmente lo que va devolver es un CALLBACK con un objeto que nosotros definimos.

Los APIS muchas veces son diseñados por nosotros mismos y otras veces no, entonces de acuerdo a eso, es posible que sea una buena idea hacer un objeto por nosotros para recibir esa respuesta, hay veces que por ejemplo esperamos un listado, y la respuesta que viene del API incluye ese listado, pero en el nivel más alto es un objeto, es un objeto que incluye, no sé, talvez un conteo de elementos y como un elemento incluye el listado, entonces en ese caso no puedo indicarle a Retrofit que va recibir un listado de cosas, porque voy a usar algo, que haga ese reconocimiento.

Si especifico por ejemplo que recibió un listado de repositorios, ese objeto repositorio, es un modelo, una representación, una entidad, usualmente esto es un PLAIN OLD JAVA OBJECT(POJO) y por lo mismo, tiene que tener las propiedades que vienen en las definiciones de API, entonces ese modelo aunque no es parte de Retrofit, se da por hecho que lo tengo implementado, además del modelo, si acaso yo no quisiera todo, puedo agregarle una anotación de JSON IGNORE o dependiendo del procesador que estoy usando, pero además del modelo voy a tener un cliente, en el cliente voy a utilizar un BUILDER de Retrofit, específico cual es la URL base, especifico si quiero convertir de cierta forma, todas las propiedades de la petición y luego en base al servicio que definí, voy a construirlo, para construirlo voy a especificar la clase y uso un método CREATE de la instancia de Retrofit.

Para usarlo, tengo dos formas de hacerlo síncrona o asíncrona:

Síncrona: va correr en el THREAD principal o en el THREADING que le indiquemos , y esto se utiliza, haciendo uso, de este servicio, sobre el que tengo un método, por ejemplo LIST REPOS, que era el que especificaba en mí ejemplos de mi listado de GITHUB entonces puedo decir "servicio.ListRepo" y como el parámetro que tenía allí, era el nombre de usuario, le mando ese nombre de usuario, es un método de JAVA pero Retrofit, lo está convirtiendo en un método que le va pedir algo al API, entonces para hacerlo síncrono ejecuto EXECUTE, entonces sobre este objeto, puedo ejecutar un método, ósea sobre el servicio, voy a obtener LIST REPO y sobre ello voy a hacer la llamada, esto no es tan común porque, yo estoy administrando los THREADS.

Lo común es que la petición sea asíncrona y que quiera que Retrofit, maneje esos THREADS por mí, entonces lo que vamos hacer allí, es construir una llamada, y sobre esa llamada vamos a poner en cola con el método "en queue" un CALLBACK para cuando concluya, la llamada del método que especifiqué, y esto CALLBACK va tener dos métodos, uno cuando funciono y otro cuando no, que se van a ejecutar de forma asíncrona, entonces no lo asigno, no digo por ejemplo, LIST, REPO LIST igual a "instancia.getRepos", porque eso seria síncrono, sino en vez de eso hago un "enqueue", Retrofit lo va manejar por mí.

Podría incluso, manipular un poco como se realiza esto, si acaso tengo muchas peticiones, esto por alguna razón tiende a pasar en aplicaciones empresariales que el BACKEND esta pensado en una forma extraña en la que hay que hacer muchas peticiones una vez cuando se inicializa y luego solo actualizaciones posteriores, con Retrofit.

Puedo además agregar programación reactiva, para realizar un encadenado de peticiones.

Por lo pronto pues la petición básica es la que nos interesa y hay mucha más información de Retrofit de como usarlo en su sitio oficial, lo que vamos a estar trabajando es Retrofit 2, y en base a esto, vamos a usar también un procesador para el reconocimiento de JSON que nos facilita la vida.

Resumiendo un poquito, Retrofit va tener un cliente y un servicio, el servicio expone el API de como hago la llamada, y el cliente ejecuta esa llamada y me permite especificar parámetros, puedo hacerlo de forma síncrona con EXECUTE o asíncrona haciendo un ENQUEUE a hacia la llamada y de cualquier forma voy a tener el resultado esperado o voy a tener algún error que se reporte, pero eso es lo que
hace Retrofit.




## Clase3_2 DBFlow

* [Regresar a la lección](#lección-3)

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

Además de estas anotaciones para la clave primaria y la columna, el resto de funcionalidad va a tener "gets" y "sets" y es un poquito estricto en cuanto al nombre si tengo un campo que se llama "nombre", por ejemplo, "name", voy a esperar o más bien "DBFlow" va a esperar que tenga un "get" y un "set", "name". Si es diferente entonces me da un poquito de problema, lo puedo resolver con anotaciones,pero lo mejor es colocar esos nombres un poquito estandarizados.

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

* [Regresar a la lección](#lección-3)

Para la aplicación que vamos a construir necesitamos recetas que mostrar. Podríamos usar un "backend" propio, podríamos desarrollar nuestrar propias recetas, o podríamos usar el de alguien más, que eso es lo que vamos a hacer.

¿Por qué lo elegí? Porque me permite indicarle en la petición el identificador de una receta, y permite también que le indique el conteo de recetas que quiero. Entonces, si le envío un uno en ese conteo, y le envío un identificador que es un número aleatorio, voy a poder obtener una receta aleatoria.

El "API" que me va a dar estas recetas, requiere registrarme y  tiene un cierto número de peticiones diarias que van a ser suficientes para nuestro caso y devuelve esta respuesta en un formato "json", encontramos en su documentación oficial cuál es el formato y con este formato vamos a establecer un objeto que nos de esa respuesta, que tiene el conteo y el listado de recetas, ese listado va a tener únicamente un elemento y sobre ese elemento voy a trabajar para mostrarlo en la aplicación.

Ese elemento trae varias propiedades, me interesan principalmente un identificador. Me interesa también que pueda tener la imagen, entonces, un URL de la imagen y me interesa también un URL hacia donde llevar al usuario para que vea más detalle. Eso no lo voy a mostrar
en mi app sino lo voy a hacer con una acción asociada.

Entonces, la requisición requieren un "API Key", que lo tengo que ir a pedir a este sitio. Un ordenamiento(sort) que lo vamos a hacer con una letra "r", que es para indicar que son los más recientes, vamos a agregarle un conteo que es uno y en la página(page = random) le vamos a enviar "random". Con esto podemos agregar la funcionalidad del "API".

"Food2Fork" no es que sea el único "API", sino que a través de este "API" puedo hacer las peticiones necesarias, esto es lo que me funciona y vamos a usarlo en conjunto con "retrofit".


## Clase3_4 Swipe

* [Regresar a la lección](#lección-3)

Para la interacción de la aplicación, vamos a manejar los botones y un gesto de "Swipe".

La implementacion del gesto de "Swipe" la podríamos hacer con un "view.pager" y permitirle al "view.pager" que lo maneje, pero como aquí tenemos una sola vista, no tenemos una colección de vistas, un adaptador tal vez es demasiado.

Entonces, en vez de eso, vamos a detectar manualmente el evento de "Swipe".

Ahora, no hay un "unswipe", lo que sí hay es un "SimpleOnGestureDetector" que tiene un evento "OnDown", un evento "OnUp" y un evento "move". En base a eso, automáticamente maneja un evento "OnFling", entonces, yo voy a poder sobrecargar los métodos a partir de una clase que utilice este "SimpleOnGestureDetector" y cuando tenga el método "onDown" devolver "true" para indicar si lo estoy detectando
y luego cuando tenga "onfling" ahí colocar toda la lógica necesaria.

El "action code" que nos interesa es un "action_down", un "action_up" y un "action_move".

Voy a necesitar cierto movimiento y sobre el método "onfling" es que voy a realizar la implementación.

¿Qué voy a validar?

Que hay una distancia para saber que sí existe este "swipe", es decir,
que no sólo un movimiento sobre la pantalla, sino que si hay cierto movimiento y esa validación va a tener un "threshold" que debo superar en cuanto a distancia y en cuanto a velocidad.

Estas variables de la "x" y la "y", de dónde inició y hasta dónde llegó, así como la velocidad las recibo en el método "onFling". Sobrecargándolo, lo voy a poder hacer con una serie de "if" y voy a agregar un "listener" para reaccionar ante ese evento.

Entonces, cuando sucede un "fling" que lleva cierta dirección y estoy haciendo un "swipe" hacia un lado, voy a reaccionar de cierta forma hacia la derecha, me quedo con la receta y hacia la izquierda, la desecho. Con estas dos clases "OnGestureDetector" y una interfaz que voy a eventualmente implementar en la actividad, voy a tener lo necesario para el manejo de "swipe".



# Lección 4

## Tabla de contenidos

* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Código del Presentador]()
* [Ubicación](#clase2_1-inyección-de-dependencias)
* [ViewPager y tabs](#clase2_2-viewpager-y-tabs)
* [Recycler Aninado y CardView](#clase2_3-recycler-anidado-y-cardview)
* [Swipe](#clase2_4-swipe)


## Clase4_1 Ubicación

Vamos a ver como pedir la ubicación del usuario.Para esto necesitamos el GPS o la ubicación de parte de la red o la ubicación de parte de las antenas cuando tenemos un celular, que también obtiene de esa forma la ubicación, lo importante es que hay varias fuentes, pero para que sea más fácil, nos vamos a apoyar en una librería del Framework de Android, lo que ha venido haciendo Android desde hace un poco de tiempo es, tomando algunas funciones propias del sistema, y moverla hacia GooglePlayServices, que es esta librería que me permite hacer muchas cosas, entonces el APP se conecta a PlayServices, que está disponible en el PlayStore, y eventualmente PlayServices, funciona dentro de Android y me devuelve algún resultado. Entre lo que puedo usar es talvez la autenticación con GooglePlus, el control para el manejo de videojuegos, con una especie de Centro de Videojuegos, los mapas, la ubicación, el movimiento, van agregando poco a poco más cosas.

Entonces nosotros vamos a empezar importando, o agregando más bien, la librería de GooglePlayServices a nuestro proyecto, ahora esto lo podemos hacer por completo, con toda la librería, o siendo selectivos con una porción, dependiendo de nuestro proyecto, que tantas librerías tenga, esto tiene sentido que hagamos uno u otro, la porción especifica del usuario para ubicarlo se llama Services Location y vamos a trabajar sobre ello.

Para poder ubicar al usuario tenemos que indicar que va utilizar el permiso de acceso a la ubicación, puede ser un "COASE_LOCATION" o un "FINE_LOCATION" de acuerdo a como lo quiero ubicar, "FINE_LOCATION" va tener el GPS, usualmente eso es lo que nos interesa.

Posteriormente a que definí eso, en el manifest, como permiso, voy a tener que conectarme a PlayServices, usualmente entonces instancio, un objeto GoogleAPIClient, sobre este APIClient, cuando tengo ciertos eventos, me conecto y me desconecto, por ejemplo en OnResume y onPost de la actividad, voy a conectarme y a desconectarme, específicamente para el caso de la ubicación, tengo un método que es parte de los CALLBACKS, podría ser que mi actividad implemente estos CALLBACK, y entonces voy a tener una llamada, cuando se obtuvo una ubicación y el cliente se conectó, allí tengo una garantía de que ya puedo llamar a la ubicación sobre el APIClient, entonces hago uso de este APIClient y obtengo la ubicación.

Una alternativa, es que tenga actualizaciones, podría ser que la ubicación me interese en un solo momento, o podría ser que me interese en los cambios, con las actualizaciones cada vez que se modifica la ubicación del usuario, puedo programar la periodicidad de esas peticiones, pero cuando se modifica, voy a obtener una llamada, y entonces tengo un método a través del cual puedo actualizar la variable, en donde llevo control de la ubicación, puedo enviar al servidor, conservarla en el APP, etcétera, en realidad hay una variedad de cosas que puedo hacer con la ubicación, y eventualmente como esto va consumir mucha batería para el usuario, tengo que ser muy consiente de cómo lo administro, y cuando no lo estoy usando detener las ubicaciones, entonces tengo como un ciclo de vida, a través del cual hay varios eventos, el primero de ellos es la conexión, luego puedo pedir la ubicación, la última conocida, y pedir en el camino, actualizaciones, para el final, detener estas actualizaciones, hay mucha más información de esto, incluyendo estrategias para administrarlo, el código necesario para obtener la ubicación y de qué forma lo debería implementar, para configurarlo en la documentación oficial.


## Clase4_2 Google maps, Markers, Info Window


Hay varias formas de mostrar un mapa al usuario en una aplicación, pero creo que la mas común y más popular es GoogleMaps.

El primer paso, es obtener un API KEY afortunadamente en el sitio oficial, tenemos una guía, para obtener este APIKEY, entonces:

<ol>
	<li>Simplemente le decimos, vamos a obtener un KEY</li>
	<li>Esto nos lleva a una pantalla, donde dice, queremos usar una pantalla existente, de la consola de Proyectos de Google, o queremos hacer un proyecto nuevo </li>
	<li>luego que ya fue creado esto, nos pide SHARE1, a partir de KEY STORE, similar como lo hace otros APIS, como por ejemplo FACEBOOK, además del nombre del paquete  </li>
	<li>Después que le hayamos indicado ya disponemos del acceso para utilizar el mapa  </li>
	<li>  </li>
	<li>  </li>
</ol>

Simplemente le decimos, vamos a obtener un KEY, esto nos lleva a una pantalla, donde dice, queremos usar una pantalla existente, de la consola de Proyectos de Google, o queremos hacer un proyecto nuevo.

Ese KEY, tiene que ir en el manifest, puedo ponerlo al igual que los casos anteriores en el archivo de propiedades de GRADLE, y leerlo en el Manifest.
Aquí lo vamos a colocar con un, elemento de Metadata y una vez, lo tengo listo puedo proceder a la implementación.

De nuevo, vamos a usar GooglePlay Services para esto, entonces voy a colocar la referencia ya sea general o únicamente para los mapas, siendo selectivos, voy a agregar los permisos y necesito un permiso de internet, necesito el permiso, de la ubicación y necesito el permiso de escritura hacia el almacenamiento, porque es posible que se maneje un cierto Caching o una copia local de los elementos del mapa.

Luego en el Layout especifico, que voy a tener un "SupportMapFragment"y en la implementación voy a tener un CALLBACK que tiene un método onMapReady a través del cual voy a poder mostrar ese mapa.

Esto es importante, porque la carga se hace de forma síncrona, entonces si tengo una conexión muy lenta la carga se va ser mientras pueda hacer algunas otras cosas dentro de la aplicación, por lo tanto en el método onCreate, y el método onActivityCreated o onCreateView, o en el que corresponda de acuerdo a la actividad o fragmento, voy a poder empezar esta carga de datos y también, esa misma actividad o fragmento va implementar la interfaz, para tener el CALLBACK cuando el mapa está listo, y sobre ese mapa, ya puedo trabajar.

Luego además de que tengo un mapa, tengo <em>diferentes tipos de mapa</em>, donde tengo uno con satélite, voy a ver el terreno, voy a ver el mapa plano, hay un mapa por defecto, pero puedo agregar una funcionalidad adicional, incluso si el Zoom es muy alto, en algunos casos hay mapas, de cosas que son dentro de un edificio, cuando hay edificios grandes o de este tipo, entonces, usando OnMapReady, puedo colocar esto, y asignarle un Mapa Híbrido, un mapa satelital, etcétera, cuando ya dispongo de esa instancia del mapa, lo puedo hacer en otro momento, pero lo importante es que ya asigné la instancia inicialmente.

Además de esto <em>los marcadores</em> me permiten tener un punto en el mapa, los marcadores tienen por lo menos, la posición, que es obligatorio, además vamos a tener opcional un título, un snippet, si se puede arrastrar o no, si es visible, un icono personalizado, etcétera, y estos marcadores los voy a obtener es decir el objeto Marker lo voy a obtener, luego de que sobre el mapa, llame un método que agregue el marcador con ciertas características y ciertos atributos que voy a especificar.

Cada marcador, puede tener una ventana de información, entonces si le especifico un título y un snippet eso va aparecer en el momento de que le haga un click al marcador, esa ventana puede ser personalizado el contenido, es decir lo que va dentro o puede ser personalizado, el contenedor y el contenido, es decir, todo el marco y lo que va dentro, de acuerdo a esto, nosotros vamos a trabajar con un InfoWindow, personalizado para nuestra aplicación.

Hay dos métodos importantes aquí:

<ul>
	<li>GetInfoContent</li>
	<li>InfoWindows </li>

</ul>

De acuerdo a esto, voy a cambiar, ya sea la ventana completa o únicamente el contenido.

A nosotros nos va interesar en nuestra aplicación cambiar solo el contenido, allí inflamos la vista, colocamos los atributos, algo a tener en cuenta es que lo que hace Maps o lo que hace Android para mostrarlo de una forma más eficiente es, todo eso que se recibe, se coloca como una imagen, entonces , el contenido y las diferentes vistas se procesan, y el OUTPUT, es una sola imagen que se muestra, lo que provoca lo que detectar clicks o un cambio o lo que sea, sobre esa vista, no sea tan fácil.

Resumiendo un poco, vamos a necesitar para los mapas tener un APIKEY, vamos a colocar el APIKEY como metadata en el manifest, así como también, los permisos de:

<ul>
	<li> Ubicación  </li>
	<li> Internet  </li>
	<li> Escritura de almacenamiento </li>
</ul>


Luego la funcionalidad la vamos hacer con un MapFragment, es un elemento de UI, para Layout y además vamos a tener una clase, donde podemos hacer la carga del mapa en base a un CALLBACK, entonces en el evento onMapReady, vamos a tener lo necesario para acceder a ese elemento, luego esto puede tener un mapa, tipo hibrido, de tipo satelital, de tipo solo terreno, etcétera, lo hacemos sobre el objeto mapa, y sobre el mismo objeto mapa, podemos colocar también marcadores, estos marcadores, me van a permitir marcar un punto sobre el mapa, y al hacer click me puede mostrar contenido, lo va mostrar si yo especifico, que tenga por ejemplo un título, un snippet, o bien si especifico un infoWindow personalizado, puedo hacer click sobre el InfoWindow puedo tener una interacción muy simple, pero el contenido como tal no lo puedo acceder, porque se convierte una imagen.



## Clase4_3 Cámara

Vamos a platicar un poco de la cámara y cómo podemos utilizarla dentro de Android. Es importante tener en mente que hay dos caminos a elegir dentro de cómo lo implementa Android. Uno de ellos es a través de un "intent",El otro es personalizar por completo la cámara y tener mucho más control.

En este caso no queremos agregar filtros, no queremos cambiar el comportamiento, entonces, vamos a trabajar con un "intent".

El primer paso es considerar que tenemos que avisar que esta característica del teléfono va a ser usada, de acuerdo a eso vamos a indicar que queremos usar la cámara en el "manifest".

Ahora, el tema es que necesito especificar el permiso de la cámara, y necesito especificar la característica de la cámara, porque es posible que algún dispositivo no la tenga, en base a esto puedo indicar que la aplicación va a ser uso de la cámara y que es fundamental o no.

Cuando no sea fundamental agregamos sobre el "uses feature" dentro del "manifest" una propiedad android:required = "false" porque si no es un requerimiento, entonces la aplicación puede funcionar sin la cámara.

Si fuera un requerimiento y dependemos totalmente de la cámara si es muy importante que se lo digamos al usuario para que no vaya a tener una experiencia mala, en un dispositivo que no tiene  cámara.

Luego si vamos a guardar las imágenes también necesitamos indicar el permiso de que escriba al almacenamiento, en la mayoría de casos si tomamos una fotografía vamos a querer hacer algo con la fotografía y es altamente probable que la queramos guardar. Por eso es importante indicarlo.

Luego, ya que tengo estas considerasiones previas contempladas voy a tener dos pasos que hacer.

<ol>
	<li>Iniciar el "intent" para que la cámara pueda tomar la fotografía,vamos a especificar algunos valores específicos para esto, indicándole cual es el "intent", toma de fotografía, que queremos que esto quede guardado en un archivo y luego le decimos "start activity for result" y va a inicializar en base a ese "intent" la cámara.
  </li>
	<li>Recibir el resultado y luego hacer algo con esa fotografía. </li>
</ol>

El segundo, recibir el resultado requiere de "on activity result", muy parecido a cuando iniciábamos sesión con Facebook o Twitter, la forma de manejarlo es que va a regresar algo a nuestra actividad que trae información, entonces, ahí puedo validar si el resultado es el adecuado, entonces, ejecutamos cierta acción. Además, como puedo tener múltiples llamadas de salida de la actividad y que más de alguna regrese con un "activity result" cuando construyo el "intent" de la cámara o algún otro "intent", necesito especificar un código y al regresar en "on activity result" validamos ese código para asegurarnos que sí sea la cámara.


Con ello ya podemos guardar la imagen, podemos subirla a un "backend", podemos hacer una variedad de cosas. Ahora, es posible que entre esas cosas queramos agregar la fotografía como un elemento en la galería. A partir de las versiones más nuevas la galería desapareció y ahora se usa "Google Photos", podría ser alguna otra aplicación pero esa es la que Google nos sugiere y guarda una copia de seguridad en la Nube.

Por lo tanto, es posible que esa copia de seguridad pueda venir como origen para una fotografía, o si es una versión antigua podría ser una galería. Ahora, agregarlo en Google Photos lo que vamos a hacer es el mismo paso con la galería pero lo que va a hacer es avisarle al usuario nada más: "hey, hay un folder nuevo, ¿lo quieres agregar al backup?".

Por defecto únicamente la cámara está activada y también se puede deshabilitar si el usuario quiere. Entonces, como tiene un mayor control nosotros todo lo que hacemos es volver consciente al usuario de esto.

Con el segundo punto que mencionaba, el origen es algo importante considerar porque si tenemos una fotografía que podemos tomar en ese momento, es muy probable que el usuario también quiera alguna fotografía que ya tomó antes, por lo tanto el origen podría ser la galería o podría ser "Google Photos" o podría ser un sinfín de "apps". 

Para trabajar esto vamos a tomar en consideración algunas cosas adicionales, la primera es el archivo. El archivo lo podemos empaquetar en un método que nos lo devuelva porque vamos a trabajar únicamente con la ruta escribiéndole. Luego que eso ya lo empaquetamos y nos liberó un
poco de carga, vamos a tomar en cuenta también que pueden haber múltiples origenes.

Puedo colocar un diálogo en donde yo le doy elegir al usuario que hay por ejemplo, dos orígenes, la cámara y la galería, o la cámara y Google Photos, o puedo hacer un "chooser" de los "intents" a partir de lo que tiene el usuario disponible. De esta forma, si por ejemplo el usuario tiene la galería y Google Photos y la cámara, van a aparecer los tres. Si sólo tiene Google Photos va a aparecer sólo ese o si tiene Photos y la cámara esos dos.

Entonces, lo que hacemos en un listado vamos agregando estos diferentes orígenes bajo la validación de qué actividades o aplicaciones pueden responder hacia cierto "intent". Luego, tenemos un método que vaya agregando estos "intents" a un listado y por último, creamos un "chooser" a partir de ese resultado.

Luego, cuando regresa puedo validar si el "on activity result" trae datos el resultado, podemos recibir ahí un "intent" entre los parámetros, entonces, si este "intent" trae datos, podría en base a eso decidir si es una fotografía tomada de la cámara o si viene de otra fuente.

También con un "broadcast" puedo avisarle al sistema de que la fotografía ha sido tomada y con esto lo agrego a la galería. Este "broadcast" lo voy a emitir únicamente cuando la fotografía está siendo tomada de la cámara, porque si viene de otro origen el sistema ya sabe que existe.

Por último, si la imagen <em>NO viene de la cámara</em> puede venir de la galería de fotos o de alguna otra fuente y tal vez lo más difícil es que si es de Google Photos va a venir ya sea local o remota. Si está local ningún problema, puedo leer el archivo. Pero si está remoto voy a usar un "content provider" para hacer esta petición que me devuelva un "string" de "bytes", que es el que voy a utilizar para construir el resultado. 

Entonces, al final del día lo que necesito para manipular la imagen es un "URI" y una ruta. Esto lo puedo obtener a partir de varias formas, entonces si la imagen viene de una aplicación local voy a tener que hacer un poquito de manipulación adicional.

Si tiene que ser descargada pues  con una palabra que viene en el "URI", que es el "media key", de cualquier forma lo puedo solucionar y puedo obtener ese URI y luego hacer algo con esa imagen.

 En nuestra aplicación lo que vamos a hacer es publicarla hacia nuestro "backend" y mostrarla en un listado de imágenes. Pero podríamos hacer mucho más, ponerle filtros, compartirla, como nos resulte conveniente. Lo importante es que se puede manejar de varias formas.

 Así que haciendo un resumen, la cámara la puedo manejar de forma manual o la puedo manejar con un "intent". Nosotros vamos a usar un "intent" que en la mayoría de casos es una solución que nos funciona, cuando no queremos mucha personalización. Luego, además de la cámara, con dos pasos a ejecutar voy a tener, uno, levantar el intent; y dos, hacer algo con el resultado, pero es posible que también venga de la galería o de Google Photos. De acuerdo a eso vamos a agregar "intents" a un "intent" que elige. Entonces, no me preocupo yo por hacer un diálogo sino lo hace el mismo sistema de acuerdo a lo que tiene instalado y cuando regresamos y la fotografía no fue tomada por la cámara sino viene de otro lugar, puede ser que esté local o que esté remota, si está local no hay tanto problema, lo podemos obtener de un cursor, pero si está remoto tengo que obtenerlo con un "control resolver", y de esa manera voy a administrar las fotografías de diferentes fuentes para que el usuario las pueda compartir con mi aplicación y ya decido yo que hago pero lo importante es el usuario tiene todas las opciones disponibles.


## Clase4_4 Cloudinary - App de la semana

Para la aplicación de esta semana, lo que vamos a hacer es un Feed de fotos social, en el que todos vamos a poder compartir y ver el resultado de estas fotografías.

Por lo mismo, necesitamos identificarnos. Lo vamos a hacer con un email y una contraseña, de nuevo usando Firebase como en la aplicación del chat.

Posterior al "login", vamos a mostrar dos "tabs". En uno de ellos, lo que vamos a ver es un listado con un "recyclerview" de todas las fotografías compartidas. Si la fotografía la compartí yo, va a tener un icono de Eliminar, pero todas van a tener un icono de Compartir.

Esto va a ser uso del compartir de Android, un "intent" que de acuerdo al contenido, una imagen en este caso, vaa usar las "apps" que tiene el usuario instaladas, para poder compartir.

Además de eso, en la parte superior de cada fotografía, vamos a tener una foto pequeña del usuario, similar al chat, nos vamos a apoyar en "Gravatar" para irlo a conseguir a partir del email y vamos a tener el email mostrándose.

Luego, en la siguiente pestaña, vamos a tener un mapa en donde va a ver un marcador por cada una de las fotografías que hemos tomado. Y al hacer click sobre este marcador, se va a poder visualizar una vista similar a la del listado, sin los iconos de Borrar y Compartir, únicamente qué usuario lo compartió y la fotografía.

En las dos pantallas vamos a tener un "floating action button" que me va a permitir tomar una fotografía nueva y poderla compartir.


Compartir la fotografía implica que tenemos que guardarla en algún lugar. Guardar imágenes en Firebase en este momento no es una buena idea porque Firebase guarda texto. Entonces, podríamos guardarla en Base
64, pero no es la mejor opción.

Para ello entonces, vamos a usar un "back end" que nos apoye únicamente en almacenar las imágenes y va a estar funcionando en conjunto con Firebase.

Entonces, Firebase va a manejar la autenticación y va a manejar también las imágenes pero únicamente un listado. Y en este otro "back end", vamos a tener la imágen como tal, guardada.

Ese otro "back end" va a ser "Cloudinary". Hay varias opciones, podríamos hacer un "backend" propio, podríamos usar "Google Cloud", algún otro "provider" de la nube, pero "Cloudinary" es como una especie de Firebase únicamente para imágenes.Entonces, no es que sea a tiempo real, pero me permite guardar las imágenes de una forma muy sencilla.

Para ello, tenemosun "dashboard", en este "dashboard" nos muestra el "key". El "key" de "Cloudinary" lo tenemos que agregar en nuestra "app" y luego ya podemos ver transformaciones, hacer cualquier cantidad de cosas sobre las imágenes, que en nuestro caso no va a ser necesario.

Entonces, para trabajar con "Cloudinary", lo agregamos también en el archivo de "gradle" y vamos a especificar que lea el "Cloudinary URL" del archivo propiedades, similar a como se leía el "key" del mapa. Entonces, aquí estamos poniendo lo que no queremos que esté en control de
versiones.

Luego, esa variable "Cloudinary URL" la vamos a colocar en el meta-data del "manifest" para que la aplicación lo reconozca.

La funcionalidad lo que va a requerir, son dos cosas; un método "upload" que recibe el archivo y un identificador que vamos a indicarle y un método "get_URL" que a partir de ese identificador, me da la "URL" de la imágen, que está obviamente en el dominio de "Cloudinary". El indicador nos lo va a proveer Firebase. "Cloudinary"lo podría proveer, pero lo más fácil es sincronizarlos.

Entonces vamos a utilizar el método "push" de Firebase y lo vamos a asociar a la imagen. Entonces, además de eso, agregar este método "upload" dentro de un "thread".

una "sintask" que nos permita hacer la publicación.

Por último, necesitamos saber cuál es el modelo de datos dentro de Firebase. Lo que vamos a guardar es un identificador, ese va a ser el "key" generado por Firebase en base a la fecha y la hora , y dentro de cada elemento, vamos a guardar el correo electrónico del usuario que lo está compartiendo, la ubicación con latitud y longitud, es decir, son dos campos y el "URL" de "Cloudinary" y además en "Cloudinary", vamos a usar este identificador de Firebase para guardar las imágenes.
