# Guía de SetUp

1- crear un archivo gradle.properties que no se encuentra actualmente dentro del repositorio ya que incluye la API KEY la cual es información "sensible" que no debe ser compartida en un repositorio público en este archivo tiene que ir: 

- FACEBOOK_APP_ID = ""
- FACEBOOK_PROVIDER = "com.facebook.app.FacebookContentProvider"
- FOOD_API_KEY= ""


El primero sirve para resetear el valor del "id" de la "app" que vamos a crear en Facebook.

Luego, está el "FACEBOOK_PROVIDER" que es el que nos ayuda a compartir el contenido cuando ya tenemos nuestra aplicación, este lo podemos definir de una vez y escribimos "com.facebook.app.facebook_contentprovider"

Por último nos pide el "FOOD_IP" que es la clave que nos va a permitir conectarnos al "api".


## FACEBOOK_APP_ID

Para generar el FACEBOOK_APP_ID se debe entrar en la página de desarrolladores de facebook :

Para ello vamos al sitio de "developer" de Facebook, el cual es https://developers.facebook.com y una vez que nos hayamos registrado como "developers", en caso de no tener cuenta, vamos a ingresar a Mis Aplicaciones y vamos a agregar una aplicación.

Vamos a seleccionar que es una aplicación para "android" y vamos a colocarle un nombre.

Vamos a hacer "click" en "Create new Facebook App ID" y luego nos pide un campo de correo electrónico, vamos a ingresar un correo electrónico válido que es un correo a través del cual nos va a contactar para cualquier cosa importante de nuestra aplicación.

También debemos seleccionar una categoría y vamos a seleccionar en este caso, por ejemplo, estilo de vida.

Vamos a ingresar un correo. Luego de haber ingresado el correo y de haber seleccionado la categoría, nos va a presentar una verificación.


Cuando la aplicación se haya creado, nos presentará la guía de inicio rápido para android.

Como primer punto, nos presentará los pasos que son los que debemos agregar para que nuestra aplicación funcione.

Si revisan los pasos pueden ir verificando que ya están implementados en el código.

Vamos a ir a la parte donde dice "Add Facebook App ID". Si recordamos en el ejemplo, agregamos nuestra referencia como que fuera un "string", entonces, lo único que vamos a hacer es seleccionar el "id" de la aplicación y lo vamos a copiar y pegar en nuestro archivo de "graddle.propperties", es decir en nuestro FACEBOOK_APP_ID = ""


Con eso ya estaríamos configurando el "id" pero aún tenemos más pasos que hacer para que esto pueda funcionar. Si seguimos bajando en la guía, nos vamos a dar cuenta que aquí abajo nos pide que debemos de ingresar el paquete de nuestra aplicación. Esto es porque Facebook hace una validación de que las peticiones se estén haciendo desde la aplicación que nosotros estamos configurando para que no se puedan hacer peticiones desde ninguna otra aplicación hacia la aplicación de Facebook.

Entonces, para ello vamos a abrir el archivo "manifest" desde nuestro proyecto y vamos a copiar el paquete para pegarlo dentro de la configuración de la aplicación de Facebook. Entonces, aquí tenemos el paquete que es el principal de nuestra aplicación y lo vamos a pegar acá en nuestro caso es "edu.galileo.android.facebookrecipes"


Luego nos pide que identifiquemos la clase principal. Este es un requerimiento que no es necesario pero lo vamos a poner para mostrar, por ejemplo, lo que se podría poner. Entonces, en este caso vamos a poner la actividad principal, que es la primera que se abre, vamos a copiar la ruta hacia la aplicación a partir del paquete y lo vamos a pegar acá. Entonces nos quedaría "edu.galileo.android.facebookrecipes.login.ui.LoginActivity", esa sería la ruta para nuestra actividad, que es la primera que se muestra al entrar a la aplicación.


Con esto estamos listos y vamos a hacer click en "next", nos va a decir que facebook verificó que nuestra aplicación aún no se encuentra en Google Play, que si está correcto el paquete, le vamos a decir que sí, que use este paquete porque nuestra aplicación aún no está subida en Google Play.

Luego nos va a pedir un paso muy importante, que es el "hash" de nuestra aplicación. Este es un segundo paso de verificación que Facebook utiliza por seguridad, en donde nos pide el "hash" de nuestra aplicación, al momento de ser compilada.

En este caso, como estamos en fase de desarrollo, vamos a ingresar el "hash" de desarrollo. En caso de que nuestra aplicación ya se vaya a subir a un "play store", nosotros necesitamos firmarla y al firmarla con una clave especial, nosotros necesitaríamos generar otro "hash" para que Facebook funcione.

En este caso, vamos a ingresar el de "development", pues es el entorno en que lo estamos ejecutando y para ello Facebook ya nos brinda la ayuda. Si le damos en "show" nos va a mostrar cuál es el comando que debemos ejecutar para obtener el "hash".Entonces, copiamos este comando y nos vamos a abrir una línea de comandos y lo vamos a pegar ahí. Puedes abrirlo en una línea de comandos o puedes abrirlo dentro del "AndroidStudio", también trae dentro una terminal, la puedes abrir y pegar ahí tu comando.

Entonces, al ejecutarlo, nos va a pedir un password entonces ingresamos a Android, enter y nos a a dar el "hash" de nuestra aplicación. Lo copiamos y volvemos a la configuración de Facebook y lo pegamos en "key hashes".

IMPORTANTE EN WINDOWS: 

http://stackoverflow.com/questions/4388992/key-hash-for-android-facebook-app 

la primera solución FUNCIONA , el keytool.exe se debería encontrar en C:/ArchivosdePrograma/Java/jdk/bin , se deben ubicar en ese directorio dentro de la terminal de windows o dentro de la terminal de android studio, recuerde que para moverse entre directorios en windows use los comandos "cd" y "dir".

DE TODAS MANERAS COPIO LA SOLUCIÓN (en caso de que quiten el link)

Here are the steps-

- 1- Download openssl from Google code (If you have a 64 bit machine you must download openssl-0.9.8e X64 not the latest version)
- 2- Extract it. create a folder- OpenSSL in C:/ and copy the extracted code here.
- 3- detect debug.keystore file path. If u didn't find, then do a search in C:/ and use the Path in the command in next step.
- 4- detect your keytool.exe path and go to that dir/ in command prompt and run this command

		$ keytool -exportcert -alias androiddebugkey -keystore "C:\Documents and Settings\Administrator.android\debug.keystore" | "C:\OpenSSL\bin\openssl" sha1 -binary |"C:\OpenSSL\bin\openssl" base64

- 5- it will ask for password, put android
- 6- that's all. u will get a key-hash



Con esto tendremos listo lo necesario para ejecutar nuestra aplicación. Como luego nos sugiere que sobre escribamos el método "on create" y que agreguemos el "initialize", esto ya lo hicimos desde nuestra clase "application" y también nos sugiere que activemos un "logger event" pero esto es para los "analitics".

Entonces, con esto, completamos todo esto, si queremos podemos volver y darle "skip quick start" para ver cómo está configurada nuestra aplicación.

Con esto estamos listos, entonces volvemos a nuestro proyecto y lo ejecutamos, luego de haber agregado nuestro "app id" en nuestro archivo de "graddle.propperties".



## Configurar FOOD API KEY

Luego hay que crear  nuestra propia cuenta para utilizar el API de Food2Fork.

Entonces, para ello vamos a ingresar al sitio y para comenzar, debemos de crear una cuenta.

Para que crees tu cuenta, debes ir a "Browse" y entra a la sección que dice "Recipe API".

En esta sección habrá un botón que dice "Sign Up",pero te recomiendo que cuando crees tu cuenta, hazlo a través de un correo y no lo hagas a través de Facebook,se me presentaron un poco de problemas por haberlo hecho a través de Facebook pues Food2Fork tiene un problema ahí.

Entonces crea la cuenta y luego  puedes irte ya a la parte donde dice "Likes" y entra a "API Admin".

Una vez que entres a "API Admin" te saldrá el "API Key".

Si creaste la cuenta con Facebook seguramente te puede pasar el mismo problema que a mí y saldrá "API Key none" entonces no podrás utilizarlo para ejecutar el proyecto, pero si lo creamos con nuestra cuenta de correo, todo estará bien.

Entonces, entramos aquí y copiamos el "API Key".

Como podemos ver, Food2Fork nos limita a una cierta cantidad de llamadas porque es la versión gratuita. Si tu deseas hacer algo más grande, podrías darle "Upgrade Plan" y pues ya a cambio de un costo, podrías hacer más llamadas al "API".

Entonces, copiamos el "API key" y regresamos y lo pegamos en nuestro archivo de "graddle.propperties" en FOOD_API_KEY= ""

 Otro consejo que puedo darte es que cuando cambias esta llave, en ocasiones, si le damos ejecutar al "autorun", en ocasiones no se realiza el cambio y puede darnos algún problema, puede que siga igual que como estaba antes, que como no tuviera llave y puede que no nos funcione. Entonces, para estar seguros de que va a funcionar, abrimos el menú de "Build" y le damos a "Clean Project".



