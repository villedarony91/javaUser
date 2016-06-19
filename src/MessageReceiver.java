import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;


public class MessageReceiver {
	Engine eng; 
	ConnectionFactory factory;
	Connection connection;
	Channel channel;
	private final static String QUEUE_NAME = "hello";
	ListaDobleUsuarios lsd = new ListaDobleUsuarios();
	
	MessageReceiver() throws Exception{
		lsd.createNewList();
		factory = new ConnectionFactory();
		factory.setHost("localhost");
		connection = factory.newConnection();
		channel = connection.createChannel();
	}


	void receiveDataUser() throws Exception{
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			    try {
					distributeMessage(message);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
	
		void distributeMessage(String message) throws Exception{
			String[] result = message.split(",");
			for(int i = 0; i < result.length; i++)
				System.out.println(result[i]);
			if(result.length >= 3){
			switch(result[0]){
			case "LOGIN":
				if(lsd.validate(result[1], result[2])){
					eng = new Engine();
					eng.sendMessage("OK");
				}else{
					eng = new Engine();
					eng.sendMessage("No");
				}
				
				System.out.println("********");
			}
			}
		}
}
