# java-aspects

La idea detrás de la programación orientada a aspectos (AOP) es separar aspectos transversales de la aplicación de la propia lógica de negocio, llevando a aspectos funcionalidades como auditoría, seguridad... evitando tener que gestionarlas a lo largo de la lógica del negocio.

ej: En la aplicación de CPA usamos aspectos para que antes de entrar a los métodos anotados con @FilteredOperation se ejecute un aspecto.
Este aspecto mira en el token del usuario que realiza la petición si es una persona que tiene acceso a toda la aplicación. Si no es así, buscamos los bloques logísticos a los que tiene acceso y se los añadimos a los filtros que usará la aplicación a la hora de traer datos de la DB.

Conceptos y como implementar un aspecto en Spring:

Para poder crear un aspecto tendremos que etiquetar una clase con @Aspect.
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

@Before
@AfterReturning
@AfterThrowing
@After
@Around

SEGUIR CON LAS GUIAS DE SPRING

Joinpoint:

A los advices le podemos pasar un joinPoint como parámetro. 
The JoinPoint interface provides a number of useful methods:

getArgs(): Returns the method arguments.

getThis(): Returns the proxy object.

getTarget(): Returns the target object.

getSignature(): Returns a description of the method that is being advised.

toString(): Prints a useful description of the method being advised.