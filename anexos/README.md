# ANEXOS

<!-- MarkdownTOC -->

- [Git](#git)
- [MySql](#mysql)
- [Cliente JQuery y REST](#cliente-jquery-y-rest)
- [Cliente AngularJS y REST](#cliente-angularjs-y-rest)
- [Cliente Java REST](#cliente-java-rest)

<!-- /MarkdownTOC -->


## Git

- [Resumen comandos Git](comandos-git.md)
- [Referecia Git](refcardz-git_2.pdf)
- [Resolver diferencias con Git y eclipse](http://www.avajava.com/tutorials/lessons/how-do-i-use-the-team-synchronizing-perspective-in-eclipse.html?page=1)

## MySql

- [Resumen comandos MySql](comandos-mysql.md)

## Cliente JQuery y REST

- [Jquery y Spring REST](https://spring.io/guides/gs/consuming-rest-jquery/)
- [Jquery y REST](
http://coenraets.org/blog/2011/12/restful-services-with-jquery-and-java-using-jax-rs-and-jersey/)
- [Más info](http://bfy.tw/8mmJ)

## Cliente AngularJS y REST

- [AngularJS y Spring](https://spring.io/guides/gs/consuming-rest-angularjs/)
- [Más info](http://bfy.tw/8mme)

## Cliente Java REST

- [Cliente Java con Jersey](http://www.vogella.com/tutorials/REST/article.html#firstclient)
- [Cliente Java con JAX-RS](http://docs.oracle.com/javaee/6/tutorial/doc/gkoib.html#gkqjq)

## Subir imagenes

Hay varias formas de subir imágenes:

- __Con springboot__:  [https://github.com/spring-guides/gs-uploading-files/blob/master/complete/src/main/java/hello/FileUploadController.java#L54L55](https://github.com/spring-guides/gs-uploading-files/blob/master/complete/src/main/java/hello/FileUploadController.java#L54L55). Repositorio de ejemplo: [https://github.com/spring-guides/gs-uploading-files](https://github.com/spring-guides/gs-uploading-files)
- __Con Servlet 3.0__: [https://github.com/dpalomar/demoTIW/blob/master/demo/demo-web/src/main/java/es/uc3m/tiw/web/controladores/FileController.java#L18L21](https://github.com/dpalomar/demoTIW/blob/master/demo/demo-web/src/main/java/es/uc3m/tiw/web/controladores/FileController.java#L18L21)

> Un problema que puede surgir con springboot y REST es que la codificación por defecto será base64 al enviar código binario, por lo que hay dos opciones:

1. Almacenar en la base de datos la imagen como String codificada con base64
  1. Esta opción permite usar css3 para decodificar directamente el base 64: [https://css-tricks.com/data-uris/](https://css-tricks.com/data-uris/)
2. Codificar y decodificar base64 dentro de los controllers para obtener el código binario:
  1. Con la librería `org.apache.commons.codec`: [http://javainutil.blogspot.com.es/2013/02/java-codificar-archivos-y-cadenas-base64.html](http://javainutil.blogspot.com.es/2013/02/java-codificar-archivos-y-cadenas-base64.html)
  2. Directamente con Java8: [http://jagonzalez.org/codificar-y-decodificar-en-base64-en-java-8/](http://jagonzalez.org/codificar-y-decodificar-en-base64-en-java-8/)
