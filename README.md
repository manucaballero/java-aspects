# Programación orientada a aspectos en Java

La idea detrás de la programación orientada a aspectos (AOP) es separar aspectos transversales de la aplicación de la propia lógica de negocio, llevando a aspectos funcionalidades como auditoría, seguridad... evitando tener que gestionarlas a lo largo de la lógica del negocio.

ej: En la aplicación de CPA usamos aspectos para que antes de entrar a los métodos anotados con @FilteredOperation se ejecute un aspecto.
Este aspecto mira en el token del usuario que realiza la petición si es una persona que tiene acceso a toda la aplicación. Si no es así, buscamos los bloques logísticos a los que tiene acceso y se los añadimos a los filtros que usará la aplicación a la hora de traer datos de la DB.

Conceptos y como implementar un aspecto en Spring:

Para poder crear un aspecto tendremos que etiquetar una clase con @Aspect y @Component.
La clase contiene 'advices', que son los bloques de código que se ejecutan en los flujos de la aplicación que les especifiquemos.

```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class MiAspecto {

    @Before("execution(* com.tfoc.MiClase.miMetodo())")
    public void antesDeMiMetodo() {
        // Código a ejecutar antes de miMetodo
    }
}
```
En el fragmento de código anterior se declara una clase como aspecto y el advice llamado antesDeMiMetodo se ejecuta antes de empezar el método (Por la anotación @Before) de la aplicación miMetodo de la clase MiClase.

Algunos tipos de advices:

* @Before: Se ejecuta antes de empezar el método.
* @AfterReturning: Se ejecuta cuando termina el método correctamente.
* @AfterThrowing: Se ejecuta cuando termina el método al lanzar una excepción.
* @After: Se ejecuta cuando termina el método, da igual como haya terminado.
* @Around: Permite en el mismo advice ejecutar código antes de empezar el método y tras terminar este.

En el aspecto visto anteriormente tenemos lo siguiente dentro de la etiqueta before (execution(* com.tfoc.MiClase.miMetodo())). A esta expresión se la conoce como pointcut y nos indica en que lugares del código de nuestra aplicación aplica el aspecto, esto es, donde salta. En el caso del ejemplo vemos como es dentro del paquete com.tfoc, en la clase MiClase y en el método miMetodo. Las posibilidades son muy amplias, desde usar anotaciones, que se ejecute si tiene un parámetro de algún tipo, etc.

En algunos advices se pasa como parámetro un objeto de tipo Joinpoint. Este objeto almacena información sobre el contexto que tiene la aplicación en el momento en el que salta el advice.

Algunos de los métodos que contiene el JoinPoint son los siguientes:

* getArgs(): Devuelve los argumentos del método sobre el que se está trabajando. Permite acceder a los valores con los que se invocó el método.
* getKind(): Retorna de que tipo es el joinpoint.
* getSignature(): Proporciona una descripción detallada del método sobre el que se está trabajando.
* getSourceLocation(): Devuelve información sobre la localización física del método sobre el que se está trabajando.


#### Anotaciones

En el código de ejemplo hemos creado anotaciones que se usarán como pointcut en alguno de los advices. 

```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterOperation {

}
```

* @Target: Indica sobre que tipo de elemento se puede colocar la anotación. En este caso sobre métodos.
* @Retention: Indica cuando está disponible la anotación. En este caso estará disponible en tiempo de ejecución.

Retention puede tener los siguientes valores:

* SOURCE: El compilador las descarta, por lo que no aparecerán ni en el fichero .class. Sirven para dar información durante el desarrollo (marcando algún método por ejemplo).
* CLASS: Estas anotaciones si estarán en el fichero .class, pero no estarán disponibles en tiempo de ejecución.
* RUNTIME: Estas anotaciones estarán disponibles tanto en el fichero .class como en tiempo de ejecución, por lo que podrán ser usada por el programa (son las usadas como pointcut en el ejemplo).

