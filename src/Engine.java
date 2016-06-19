import com.rabbitmq.client.*;


public class Engine {
    ConnectionFactory factory;
    Connection connection;
    Channel channel;
	
	private final static String QUEUE_NAME = "msg";
	
	Engine() throws Exception{
		factory = new ConnectionFactory();
		connection = factory.newConnection();
		channel = connection.createChannel();
	}
	
	void sendMessage(String message) throws Exception{
	    factory.setHost("localhost");
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");
	    channel.close();
	    connection.close();
	}
	

}
