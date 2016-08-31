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
 * Esta clase describe 3 formas de extraer recursos JMS del servidor:
 *  1. Tradicional con jndi
 *  2. Con anotaciones @Resource
 *  3. haciendo uso de CDI y API JEE7
 *  
 * @author David Palomar
 *
 */
public class EscribeEnCola {
	//Estilo JEE 7
    @Inject
    private JMSContext jmsContext;
    
	@Resource(lookup = "jms_mensajes")
	private  Queue queue;
    @Resource(name = "jms_tiwConnectionFactory")	
	private  ConnectionFactory connectionFactory;
	
	public void enviar(Mensaje mensaje)
    {
      jmsContext.createProducer().send(queue, mensaje);
    }
	
	
	
	// Estilo con inyección de recursos
	
//	 @Resource(name = "jms_tiwConnectionFactory")	
//	 private  ConnectionFactory connectionFactory;
//	
//	  @Resource(lookup = "jms_mensajes")
//	  private  Queue queue;
//	// Acceso mediante Inyección de recursos.  
//	public void enviar(Mensaje mensaje) {
//		  try {
//			MessageProducer messageProducer;
//			  ObjectMessage message;
//			  Connection connection = connectionFactory.createConnection();
//			  Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
//			  
//
//			  messageProducer = session.createProducer(queue);
//			  message = session.createObjectMessage();
//			  message.setObject(mensaje);
//
//
//			  messageProducer.send(message);
//			  messageProducer.close();
//			  session.close();
//			  connection.close();
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//FIXME: Codigo legado  de acceso  tradicional via JNDI
//public void enviar(Mensaje mensaje){

	  
//    MessageProducer messageProducer;
//    ObjectMessage messge;
//    
//    try
//    {
//        ConnectionFactory connectionFactory = null;
//        
//       // Get the JNDI Context
//  
//            Context jndiContext = new InitialContext();
//             
//       //   Create the Connection Factory
//            connectionFactory = (ConnectionFactory) jndiContext.lookup("jms_tiwConnectionFactory");
//            Queue queue = (Queue) jndiContext.lookup("jms_mensajes"); 
//
//      Connection connection = connectionFactory.createConnection();
//      Session session = connection.createSession(false,
//        Session.AUTO_ACKNOWLEDGE);
//      
//
//      messageProducer = session.createProducer(queue);
//      messge = session.createObjectMessage();
//      messge.setObject(mensaje);
//
//
//      messageProducer.send(messge);
//      messageProducer.close();
//      session.close();
//      connection.close();
//    
//    }
//    catch (JMSException | NamingException e)
//    {
//      e.printStackTrace();
//    }
//}
}
