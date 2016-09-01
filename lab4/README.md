#  CDI

>En este apartado, usando las características de CDI vamos a refactorizar los __Mensajes__ para coprobar la simplicidad de este modelo.
Para documentación puede consultarse el tutorial de Oracle[^1]

<!-- MarkdownTOC depth=3 -->

- [Ejercicio1. Configuración a CDI](#ejercicio1-configuración-a-cdi)
- [Ejercicio2. Refactorización de los Mensajes](#ejercicio2-refactorización-de-los-mensajes)
- [Ejercicio3. Estilo JEE7](#ejercicio3-estilo-jee7)

<!-- /MarkdownTOC -->

## Ejercicio1. Configuración a CDI

> En este ejercicio se procederá a realizar las operaciones necesarias para convertir nuestro proyecto en un proyecto que admita las características CDI


1. Incorpora un fichero de texto plano `beans.xml` vacío en el directorio `WEB-INF`
2. Fin

## Ejercicio2. Refactorización de los Mensajes

> Usando las características de inversión de control vamos a solicitar los recursos necesarios al mismo como colas y factorías para que la clase `EscribirEnCola` pueda seguir trabajando con menos código. 

1. Abre la clase `EscribirEnCola` y añade las siguiente líneas al comienzo de la clase:

```java
     @Resource(name = "jms_tiwConnectionFactory")   
     private  ConnectionFactory connectionFactory;
    
      @Resource(lookup = "jms_mensajes")
      private  Queue queue;
```

2. Modifica el código del método _enviar(mensaje)_ para adaptarlo a la nueva situación.
3. Modifica el código del `MensajesServlet` para que ahora reciba la clase `EscribirEnCola` mediante inyección usando la anotación `@Inject`.
    4. El servidor hará todo el trabajo sucio: buscará la clase, la cargará y la pasará al servlet.

## Ejercicio3. Estilo JEE7

> JEE7 tiene algunas características nuevas que hacen el trabajo más fácil. Vamos a refactorizar de nuevo la clase `EscribeEnCola` usando las novedades de JEE7
> 

1. Abre la clase `EscribeEnCola` y borra todo el código
2. Sustitúyelo por este otro:

```java
      @Inject
      private JMSContext jmsContext;

      public void enviar(Mensaje mensaje)
      {
        jmsContext.createProducer().send(queue, mensaje);
      }
```

3. Listo.


[^1]: [Tutorial CDI](https://docs.oracle.com/javaee/7/tutorial/partcdi.htm#GJBNR)