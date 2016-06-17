import com.rabbitmq.client.*;


public class Engine {
	
	private final static String QUEUE_NAME = "return";

	void sendMessage(String message) throws Exception{
		    ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		    System.out.println(" [x] Sent '" + message + "'");
		    channel.close();
		    connection.close();
	}
	

}
