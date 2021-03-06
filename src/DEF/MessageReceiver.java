package DEF;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import Dispersa.ProcessOrto;


public class MessageReceiver {
	Engine eng; 
	ConnectionFactory factory;
	Connection connection;
	Channel channel;
	private final static String QUEUE_NAME = "hello";
	ListaDobleUsuarios lsd = new ListaDobleUsuarios();
        ProcessOrto ort = new ProcessOrto();
        ABB ab = new ABB();
	
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
				//System.out.println(" [x] Received '" + message + "'");
			    try {
					distributeMessage(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
	
	void distributeMessage(String message) throws Exception{
            String tmp = message.replaceAll("\\s+", "");
            String[] result = tmp.split(",");
            String[] usr = tmp.split(",");
                if(result.length == 1){
                    checkInstructions(message);
                }
                if(result.length == 2){
                    deletion(result);
                }
		for(int i = 0; i < result.length; i++)
			System.out.println(i+result[i]);
		if(result.length >= 3){
			switch(result[0]){
			case "LOGIN":
				if(lsd.validate(result[1], result[2])){
                                    if(result[1].equals("admin")){
                                        eng = new Engine();
					eng.sendMessage("ADMIN");
                                    }else{
                                        eng = new Engine();
                                        eng.sendMessage("USER");
                                    }
					
				}else{
					eng = new Engine();
					eng.sendMessage("No");
				}
				break;
			case "UFILE":
				preProcessData(usr);
				break;
                        case "LFILE":
                            ort = new ProcessOrto();
                            ort.breakWhites(message);
                            ort.cm.printY();
                            ab.insert(ort.cm.ortHead);  
                            break;
                        case "NEWUSR":
                            lsd.insertNode(new Nodo(result[1]
                            ,result[2],null, null, null));
                            break;
                        case "MODUSR":
                            lsd.update(result);
                            break;
			}

		}
		System.out.println("********");
	}

	void preProcessData(String [] str){
		if(str.length > 2){
			int subi = 0;
			String subStr[] = new String[15];
			for(int i = 0; i < str.length ; i++){
				if(str[i].equals("*")){
					lsd.insertNode(lsd.processData(subStr));
					subi = 0;
                                        subStr = new String[15];
				}
				subStr[subi]=str[i];
				subi++;
			}
		}
		lsd.printList();
                lsd.graphList();
	}
        
        void checkInstructions(String msg){
            switch(msg){
                case "GRAPH":
                    Writer wtr = new Writer();
                    wtr.write("USERS.dot", lsd.graphList());
                    wtr.compileDot("USERS");  
                    try{
                    eng = new Engine();
                    eng.sendMessage("READY");
                    }catch(Exception ex){                        
                    }
                break;
                case "TGRAPH":
                    ab.graphTree();               
                    break;
                case "TDATA":
                    System.out.println("-------");
                    //System.out.println(ab.getData());
                    try{
                        eng = new Engine();
                        eng.sendMessage(ab.getData());
                    }catch(Exception ex){
                    }
                    break;
                    }
            
                    
            }
        
        void deletion(String[] toDelete){
            switch (toDelete[0]){
                case "LDELETE":
                    ab.delete(toDelete[1]);
                    break;
                case "UDELETE":
                    lsd.delete(toDelete[1]);
                    break;
                case "DGRAPH":
                    ort.cm.graph(ab.search(toDelete[1]).raiz.getData());
                    break;
                    
            }
        }

}

