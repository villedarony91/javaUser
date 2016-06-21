
public class ListaDobleUsuarios{
	

	Nodo head;
        NodeImage imageHead;


	void createNewImage(Nodo nodo, String path){
		NodeImage image = new NodeImage(path, null);
		nodo.setFimage(image);		
	}
	
	void createNewList(){
		Nodo newNodo= new Nodo("admin", "123", null, null, null);
		head = newNodo;
	}
	
	void insertNode(Nodo toInsert){
		Nodo tmp = head;
		if(head == null){
			head = toInsert;
		}else{
                    int compare = toInsert.getUsername().compareToIgnoreCase(
                    head.getUsername());
                    if(compare < 0){
                        toInsert.setNext(head);
                        head.setPrev(toInsert);
                        head = toInsert;
                        return;
                    }else{
                        compare = toInsert.getUsername().compareToIgnoreCase(
                        tmp.getUsername());
			while(tmp.getNext() != null && compare > 0){
				tmp = tmp.getNext();
                                compare = toInsert.getUsername().compareTo(tmp
                                        .getUsername());
			}
                        if(compare < 0){
                            toInsert.setPrev(tmp.getPrev());
                            tmp.getPrev().setNext(toInsert);
                            tmp.setPrev(toInsert);
                            toInsert.setNext(tmp);  
                            return;
                        }
                        if(tmp.getNext() == null){
			tmp.setNext(toInsert);
			toInsert.setPrev(tmp);
                        }
                    }
		}				
	}
	
	Nodo searchNodo(String user, String pass){
		Nodo temp = head;
		System.out.println("-----");
		while(temp != null){
                    System.out.println(temp.getUsername());
		
                    if(temp.getUsername().equals(user) && 
					temp.getPassword().equals(pass)){
				System.out.println("entered");
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	Boolean validate(String user, String pass){
		return searchNodo(user,pass) != null;
	}
	
        void insertImage(NodeImage node){
            NodeImage tmp = imageHead;
            if(imageHead == null){
                imageHead = node;
            }else{
                while(tmp.getNext() != null){
                    tmp = tmp.getNext();
                }
                tmp.setNext(node);
            }
        }
	
        Nodo processData(String [] str){
            String username = "";
            String passw = "";
            NodeImage imgTemp = null;
            Nodo tmp = null;
            if(str.length > 2){
                for(int i = 0; i< str.length ; i++){
                    switch(i){
                        case 0:
                            break;
                        case 1:
                            username = str[i];
                            break;
                        case 2:
                            passw = str[i];
                            tmp = new Nodo(username, passw, null, null,null);
                            break;
                        case 3:
                            if(str[i] != null){
                            imgTemp = new NodeImage(str[i],null);
                            insertImage(imgTemp);
                            }
                            break;
                        default:
                            if(str[i] != null && str[i].trim().length() > 0){
                            imgTemp = new NodeImage(str[i],null);
                            insertImage(imgTemp);
                            }
                            break;
                    }
                }
                tmp.setFimage(imageHead);
                imageHead = null;
                return tmp;
            }else{
                return null;
            }
            
        }
        
        String graphList(){
            StringBuilder sb = new StringBuilder();
            Nodo tmp = head;
            sb.append("digraph G { \n");
            int i = 0;
            if(tmp.getNext() == null){
                sb.append(tmp.getUsername()).append(";\n");
            }
            while(tmp.getNext() != null){
                Nodo prev = tmp;
                sb.append(tmp.getUsername());
                sb.append("->");                
                tmp = tmp.getNext();
                sb.append(tmp.getUsername()).append(";\n");
                sb.append(tmp.getUsername());
                sb.append("->");
                sb.append(prev.getUsername()).append(";\n");                
                sb.append(graphImage(prev));
            }
            sb.append(graphImage(tmp));
            sb.append("}");
            System.out.println(sb.toString());
            return sb.toString();
        }
        String graphImage(Nodo aux){
            StringBuilder sb = new StringBuilder();
            NodeImage tmp = aux.getFimage();
            if(tmp != null){
                sb.append(tmp.getName()).append("[label = \"").
                        append(tmp.getName()).append("\\n").append(tmp.getPath()).
                        append("\"];\n");
                sb.append(aux.getUsername());
                sb.append("->");
                sb.append(tmp.getName()).append(";\n");
            }
            
            while(tmp != null && tmp.getNext() != null){
                sb.append(tmp.getNext().getName()).append("[label = \"").
                        append(tmp.getNext().getName()).append("\\n").
                        append(tmp.getNext().getPath()).
                        append("\"];\n");
                sb.append(tmp.getName());
                sb.append("->");
                tmp = tmp.getNext();
                sb.append(tmp.getName()).append(";\n");
            }
            return sb.toString();
        }
        
	void printList(){
		Nodo tmp = head;
		int i = 0;
		while(tmp != null){
			System.out.println(i + tmp.getUsername() + " " + tmp.getPassword());
                        printImage(tmp);
			tmp = tmp.getNext();
			i++;
                        System.out.println("*************");
		}
	}
        
        void printImage(Nodo aux){
            NodeImage tmp = aux.getFimage();
            while(tmp != null){
                System.out.println(tmp.getName()+tmp.getPath());
                tmp = tmp.getNext();
            }
        }
	
}
