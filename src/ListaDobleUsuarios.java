
public class ListaDobleUsuarios{
	

	Nodo head;

	
	void sendOkMessage(){
		
	}
	
	
	void createNewList(){
		Nodo newNodo= new Nodo("admin", "123", null, null);
		head = newNodo;
	}
	
	Nodo searchNodo(String user, String pass){
		Nodo temp = head;
		System.out.println("-----");
		if(temp.getUsername().equals(user) && 
				temp.getPassword().equals(pass)){
			System.out.println("entered");
			return temp;
		}
		else if(temp.getNext() != null){
			temp = temp.getNext();
		}
		while(temp.getNext() != null){
			System.out.println(temp.getUsername());
			if(temp.getUsername().equals(user) && 
					temp.getPassword() == pass){
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
	
	
}
