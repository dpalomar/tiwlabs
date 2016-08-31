/**
 * 
 */
package es.uc3m.tiw.lab3.util;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import es.uc3m.tiw.lab3.dominios.Mensaje;

/**
 * @author David Palomar
 *
 */
public class EscribeEnCola {

	//FIXME: Codigo legado  de acceso  tradicional via JNDI
public void enviar(Mensaje mensaje){

	  
   MessageProducer messageProducer;
   ObjectMessage messge;
   
   try
   {
       ConnectionFactory connectionFactory = null;
       
      // Get the JNDI Context
 
           Context jndiContext = new InitialContext();
            
      //   Create the Connection Factory
           connectionFactory = (ConnectionFactory) jndiContext.lookup("jms_tiwConnectionFactory");
           Queue queue = (Queue) jndiContext.lookup("jms_mensajes"); 

     Connection connection = connectionFactory.createConnection();
     Session session = connection.createSession(false,
       Session.AUTO_ACKNOWLEDGE);
     

     messageProducer = session.createProducer(queue);
     messge = session.createObjectMessage();
     messge.setObject(mensaje);


     messageProducer.send(messge);
     messageProducer.close();
     session.close();
     connection.close();
   
   }
   catch (JMSException | NamingException e)
   {
     e.printStackTrace();
   }
}
}
