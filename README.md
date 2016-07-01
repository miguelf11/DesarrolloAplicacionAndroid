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


Los controles de entrada("Input Controls") estos son los elementos que me van a permitir interactuar con la aplicación hay algunos comunes, otros un poquito más raros, pero todos tienen el mismo objetivo que de cierta forma el usuario me permita escribir algo o apachar un botón o etcétera y con eso la aplicación va a reaccionar.

Entonces los controles de entrada son descritos también en "xml" al igual que los "Layouts" y van a ser contenidos dentro de un "Layout" con "Layout" me refiero no únicamente al archivo sino también al nombre de la vista que a nivel jerárquico está en lo más alto, es decir voy a tener un elemento
raíz por ejemplo un "LinearLayout" y dentro de el, puedo tener un "Button" un "ImageButton"
un "ImagesView"etcétera y todos estos descritos con "xml"
entonces como parte de los controles de entrada hay varios elementos comunes que
podemos consultar en la documentación oficial y hay algunos que se usan muy
seguidos, por ejemplo botones, por ejemplo etiquetas,
esto se llama "TextView" por ejemplo, algo para ingresar texto
esto se llama "EditText" y cada uno va a tener sus diferentes características
todos van a tener, por lo menos ancho y alto, esto es importante tenerlo en
mente, todos los componentes descritos con "xml"
tienen que tener por lo menos ancho y alto y hay un par de palabras reservadas
para indicar dos casos de ancho y alto
por ejemplo si quiere usar todo escribo "match parent" y si quiere usar únicamente
lo que el elemento necesita, utilizó "wrap_content", la alternativa sería escribir con
un tamaño en píxeles independientes dependiente de profundidad, qué tamaño
que utilizar en general se recomienda usar los "DPS" ok vamos a tener entre
todos estos controles de entrada como les mencionaba los "TextFields"
a permitir escribir algo
lo interesante es que de acuerdo a lo que quiere escribir, puedo antes que
de acuerdo a lo que quiero escribir, puedo mostrarle al usuario, un teclado
diferente pues por ejemplo puedo decir a aquí bunny mellon cesc le muestra al
usuario una arroba y un punto para poner el dominio o aquí va un número y le
muestra el teclado numérico con esto estoy ayudando al usuario a que los que
ingrese sea lo que esperaría como desarrollador recibir, sino colocó pues
no hay ningún problema igual funciona pero es una buena práctica y con que en
el curso no discutimos a profundidad temas de interfaz o de interacción del
usuario si platicamos algunas de estas buenas prácticas para irlo manejando
también tenemos botones este se llama "Button" y tenemos botones con los que
podemos cambiar el estado o un "Toggle Button" éstos puede ser deslizables, Cliqueables
o de alguna forma mostrar al usuario que el status cambio, no es una
no es algo, que nos mandan hacer siempre con botones podríamos por ejemplo usar
una imagen cuando le hagan "Click" cambiar la imagen pero sí hay algunos botones que
manejan el control de cambio, el "Toggle" es una buena idea utilizarlos y aquí vamos
a tener un cierto texto, podemos ponerle una imagen de fondo, etcétera
otro de los elementos más comunes es el "spinner" que me permite crear una lista en
base a por una serie de cosas que quiera mostrar al usuario cuando le hago clic
sobre una opción se va a mostrar un estado hacia abajo a veces a éste
también se le llama "Drop Down List" porque tengo una sola línea con la opción
seleccionada y cuando lado clic demuestra todas las demás
el llenado de estas listas, o el contenido que voy a mostrar puede hacerse con
código en "JAVA" o puede especificarse en "xml"
como un arreglo, otro elemento común son los botones de radio "Radio Button"
que voy a agrupar en "Radio Groups" esto me van a permitir a mí seleccionar una opción
de varias por, ejemplo puede ser un sí o un no o puede ser para elegir alguna
opción en donde tengo claramente definidas las opciones, con esto voy a
obtener un valor y saber si está seleccionado o no, algo similar pero
cuando quiero más de una opción me sirve con los "CheckBox" o unas cajitas en
donde voy a poner un cheque para seleccionar estas cajas le permiten
seleccionar más de una
a menos que tenga alguna restricción pero a diferencia de los "Radios Buttons"
no voy a poder seleccionar únicamente uno del grupo, sino puedo seleccionar varias
así como tenía el "spinner" las opciones vamos a tener también el "picker" esto es
común por ejemplo para la hora o para una fecha en donde voy a tener la
opción de seleccionar, dentro de un rango amplio por ejemplo,
cuando quiero seleccionar la fecha, tal vez el mes no es tan complicado son doce opciones pero
el día pueden ser de 28 a 31 o el año dependiendo del rango de año se quiera
mostrar entonces el "Picker" es muy común para este tipo de cosas, y si
queremos leer un poco más hay varios enlaces de interés en la documentación
oficial
tenemos un simulador de vistas que está en web
de los "Labs" de ayuda "Udacity" y tenemos una hoja de ayuda, por ejemplo como
cuando vamos hacer un examen nos acordamos de todo entonces hacemos un
resumen con un listado de cosas, así es esa hoja de ayuda que nos muestra los
elementos más comunes cuales el "xml" que los describe y cómo luce, así que estos
son los elementos más comunes de los controles de entrada, no son todos pero
con ellos vamos a trabajar bastante y es importante que estén familiarizados



## Clase0_6 Recycler View

Vamos a platicar ahora del "Recycler View" usualmente vamos a
presentar contenido en forma de un listado, ya sea un listado con un elemento detrás
de otro o incluyendo columnas, cuando incluimos columnas usualmente a esto se
le llama "Grilla" o "Grid" en inglés y antiguamente teníamos para manejarlo
un "List View" y un "Read View" ambos han sido reemplazados en la versión más nueva
por el "Recycler View" que permite mostrar el contenido de las dos formas y con un
poco más de opciones
el listado luce, asi verdad, un elemento detrás de otro y el "Grid" pues tiene
varias columnas puede ser ordenado de diferentes maneras
ahora a partir de de "Material Design" y de la versión "Lollipop" de "Android" se
introdujo el "Recicler View" para mostrar contenido, en una forma más sencilla en
el "List View" y el "Grid View" todavía son soportados pero eventualmente van a caer
en desuso
entonces por eso nos enfocamos en cómo funciona el "Recycler View" tal vez el
punto más importante del "Recycler View" es que no se encarga de muchas cosas
tanto "List View" como "Grid View" tenía demasiadas responsabilidades
"Recycler View" tiene poca responsabilidad, entonces no se encarga de posicionar los
elementos en la pantalla eso lo va a ser un "LayoutManager" no se encarga de animar
cuando queremos cierta animación para agregar elementos o quitarlos, etcétera
eso lo va hacer "Item Animator", no se encarga tampoco de manejar ningún
evento asociado con el listado o con el "Grid"a excepción del "Scroll" es el
único evento que va a manejar, para esto podemos hacer una interfaz, podemos
obtener la posición en el "ViewHolder"
hay diferentes formas de hacerlo sin embargo el "RecyclerView" no se va
encargar de nada de esto, entonces ¿Qué hace? únicamente para mostrar el
contenido y como tiene tan poca responsabilidad
les puedo personalizarlo de una forma sencilla y esto se ha vuelto como un
Modulo, entonces el formato o la forma en que vamos a trabajar el "Recycler View"
va a requerir de un "LayoutManager" podría ser "Linear Layout Manager"
o un "Grid Layout Manager" que va a conectarse a una fuente de datos
estos datos podrían ser, una base de datos, podría hacer un arreglo, podría
ser un cursor, etcétera y en medio hay un vínculo, ese vínculo lo logramos con
un adaptador, el adaptador no hace más que tomar una fuente de datos y
mostrarla de cierta forma, entonces el elemento que lo muestra por un lado el
"UI" hay es el "RecyclerView" y por otro lado la fuente de datos puede venir de
muchos lugares, es importante tener en cuenta que el "Recycler View" va
requerir que el adaptador lo implemente, en decir el desarrollador para tener que
implementar el adaptador de acuerdo a sus necesidades
entonces para empezar el "LayoutManager" éste va a posicionar el contenido
repito no lo hace el "Recycler View" lo hace "LayoutManager" y va determinar cuándo
vamos a poder reutilizar elementos que no son visibles para ello vamos a usar un "View Holder"
platicamos en un momento entonces "LayoutManager" podría ser
de tipo listado con un "LinearLayoutManager" podría ser "Grid" con un "Grid Layout Manager"
Podría ser una "Grilla" escalonada, con celdas de diferente
tamaño éste se llama "StaggeredGridLayoutManager" o bien podría
personalizarlo, conforme hay actualizaciones de la librería de
diseño van habiendo cambios sobre que soporta que se agrega que casi en desuso
etcétera y en la mayoría de casos, nos la vamos a agreglar con un "LinearLayout" o con un
"GridLayout" algunos casos puntuales
ban ha requerido algo diferente pero por lo demás es relativamente fácil
trabajar dentro del adaptador hay una parte muy importante
voy a tener que construir un adaptador heredando del "Recycler View" punto
"adapter" sin embargo además de ello voy a tener
la obligación de implementar un "View Holder" el "View Holder" lo que me permite es
reutilizar "R" elementos, entonces voy a tener una clase que tiene referencia a
cada una de las filas del listado o de las celdas si fuera un grid
entonces cómo estoy llamando "FindViewById" constantemente esto tiende a ser
ineficiente y como quiero rehusar estos elementos para no llenar la memoria
entonces el "ViewHolder" es un patrón que permite a través de un objeto simple
mantener una referencia a los identificadores de la vista estos
identificadores me van a permitir mostrar renderizar el contenido de cada
una de las celdas sea uno de los elementos del listado una de las celdas
del "Grid" y vamos a incluirlo dentro de la "Adaptador" entonces vamos a tener que
escribir una clase personalizadas que herede del "Adapter" del "Recycler View"
y vamos a necesitar un "View Holder" que va a tener que ser inflado en el adaptador en
un método que se llama "onCreate View Holder" y en otro método va a ser
vinculados los datos de la fuente de datos con el "View Holder" este método
que se llama "OnBindViewHolder" me permite hacer eso ahora cuando quiero manejar el
"click"
todavía no hay una forma estandarizada lo que vamos a estar haciendo usualmente
es manejarlo con "View Holder"
entonces vamos usar una interfaz que defina cómo actuar ante ese clic ese
interfaz la vamos a recibir en el adaptador y la vamos a asignada al "ViewHolder"
entonces vamos a manejar el clic sobre el "View" que tiene el "ViewHolder" y con la
interfaz que recibimos y reaccionar de alguna manera.



## Clase0_7 Implementación de los componentes


Vamos a platicar un poco acerca de la implementación del "ReciclerView"
hemos visto la teoría que necesitamos un adaptador, un "ViewHolder" un "LayoutManager"
pero como se ve esto en la práctica ya en el código en "Android"
"Studio"como lo voy importar, el primer paso y eso es importante tenerlo en
mente es que como "RecyclerView" se introdujo en "Lollipop" en la versión cinco
hay muchas otras versiones anteriores que no lo soportan de forma nativa
entonces debo agregar, una referencia en el archivo "Build" puntos "Grade" para esta
librería, entoces vamos a incluir allí dentro de dependencias un "compile" el
nombre de la biblioteca y también de la versión, una vez que ya lo tengo
aquí ya dispongo del componente aunque no esté produciendo algo para "Lollipop"
o versiones más nuevas, entonces ya puedo escribir en el "Layout" un elemento
"RecyclerView" que es parte de "android.support.v7.widget" donde estaban
varios elementos de soporte y le tengo que especificar ancho y alto como a
todos los elementos le tengo que usualmente poner un identificador porque
de esta manera le voy a poder vincular un "adapter" y además opcionalmente
podría ponerle más atributos incluso indicarle si va a tener "ScrollBars"
para que el contenido lo muestre cierta manera podría hacer "Linear Layout Manager"
horizontal o vertical y desde aquí desde "Layout" indicar cómo van a
ser estos "ScrollBars" ahora cómo voy a ser un "Adaptador" personalizado
también necesito especificar el "Layout" para cada uno de los elementos, en el
caso del ejemplo básico
vamos a tener únicamente un "TextView" y ese "TextView" es el que va a renderizado
a mostrar el contenido de cada elemento pero sí es importante que son dos
archivos de "xml"
diferentes para el "Adaptador" voy a heredar de
del "Adaptador" de "RecyclerView" voy a tener algunas algunos métodos que va a
ser forzoso implementarlos en relación al "ViewHolder" cuando lo estamos
vinculando cuando lo estamos creando y además el método que me devuelva el
conteo de cuántos elementos tengo usualmente cuando voy a trabajar cierta
clase en el mismo adaptador incluyó el "ViewHolder" el "ViewHolder" es una clase
relativamente sencilla que tiene como características que va a heredar
también de un objeto de "Recycler View" y tiene que tener un constructor que
sobrecargue perdon es un constructor que referencie a su ancestro
solucionamos sin ningún problema y además vamos a incluir aquí todo lo
que necesite para referenciar a las vistas dentro del elemento que voy a
estar utilizando para mostrar contenidos en nuestro caso el "ViewHolder" va
tener únicamente un "TextView" porque ese es el contenido y a través del "ViewHolder"
también voy a colocar el manejo de "click"
entonces eventualmente pues aquí vamos a poner cuál es el, la forma en
que vamos a actuar cuando ocurra un "click" sobre está vista que representa al
"Holder"
entonces para manejar el "click" vamos a crear una interfaz, esta interfaz la va a
recibir el adaptador como un parámetro boy a también eventualmente importarla
implementarla dentro del elemento que está trabajando con ese adaptador
usualmente es una actividad o un fragmento y entonces ahí voy a tener
este método implementado y en el adaptador voy a tener la el uso de este
método de la interfaz del "click" para ello entonces vamos a por ejemplo poner
"onItemClick" en la actividad lo vamos a implementar y dentro del
fragmento vamos a, perdón dentro del adaptador vamos a colocarlo hacia el
"ViewHolder"
ok, que debería tener mi "Adaptador" pues por lo menos debería tener un, una
referencia hacia una fuente de datos, un listado, funciona y entonces desde la
actividad o fragmento que va hacer uso del "Recycler View" tengo que especificarle
los datos
podría hacer un arreglo por ejemplo un arreglo de "Strings" y que mi "Adaptador"
tenga este esta estructura también como fuente de datos
tengo que especificarle la interfaz que va manejar el clic y lo demás es
opcional al estar haciendo la configuración del "RecyclerView" vamos
también a especificar cuál es el "manager" o quién va administrar el
contenido
usualmente nos las arreglamos con un "LinearLayoutManager" y esto nos
basta y luego lo asignamos, entonces "SetAdapterView" sobre el "RecyclerView"
ya tenemos listo todo y podemos trabajar con este "RecyclerView" utilizando estos
datos
recapitulando un poco voy a necesitar importar la librería utilizando el
archivo de "Gradle" escribir una clase del "Adaptador" y esta clase del adaptador
va a utilizar un "Layout" entonces necesito dos "Layout" necesito un "Llayout" para donde
va el "Recycler View" otro "Layout" para el elemento personalizado en el adaptador
voy a tener un "ViewHolder" que usa lo que sea que tengo en mi elemento
personalizado
en este caso pues era un "TextView" y voy a definir algunos métodos como un "CreateViewHolder"
y "onBindViewHolder" y "get Item.Count" luego para el "Click" lo voy a
manejar sobre el "View" que tiene el "ViewHolder" y en la actividad o fragmento
que hagan uso de este "RecyclerView"
vamos a colocarle el "LayoutManager" a colocarle el adaptador y listo
ya tenemos nuestro "RecyclerView" funcionando.








# Lección 1:

## Código de Android Chat (cambian algunas cosas)
https://github.com/ykro/android-chat-firebase


# Lección 2:

## Código de Twitter app hecho por el presentador
https://github.com/ykro/android-twitter



# Lección 3


## Tabla de contenidos

* [Regresar al Inicio](#desarrolloaplicacionandroid)
* [Código del Presentador](#código)
* [Retrofit](#clase3_1-retrofit)
* [DBFlow](#clase3_2-dbflo)
* [Food2Fork](#clase3_3-food2fork)
* [Swipe](#clase3_4-swipe)


## Código
https://github.com/ykro/android-recetas


## Clase3_1 Retrofit

* [Regresar a la lección](#lección-3)

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

Para la aplicación que vamos a construir necesitamos recetas que mostrar. Podríamos usar un "backend" propio, podríamos desarrollar nuestrar propias recetas, o podríamos usar el de alguien más; que eso es lo que vamos a hacer.

Hay muchos "APIs" que ofrecen acceso a comida, ingredientes. 

¿Por qué lo elegí? Porque me permite indicarle en la petición el identificador de una receta, y permite también que le indique el conteo de recetas que quiero. Entonces, si le envío un uno en ese conteo, y le envío un identificador que es un número aleatorio, voy a poder obtener una receta aleatoria.

El "API" que me va a dar estas recetas, requiere registrarme y  tiene un cierto número de peticiones diarias que van a ser suficientes para nuestro caso y devuelve esta respuesta en un formato "json", encontramos en su documentación oficial cuál es el formato y bueno, con este formato vamos a establecer un objeto que nos de esa respuesta, que tiene el conteo y el listado de recetas, ese listado va a tener únicamente un elemento y sobre ese elemento voy a trabajar para mostrarlo en la aplicación.

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

