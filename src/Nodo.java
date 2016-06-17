
public class Nodo {
	
	private String username;
	private String password;
	private Nodo next;
	private Nodo prev;
	
	Nodo(String user, String pass, Nodo next, Nodo prev){
		this.setUsername(user);
		this.setPassword(pass);
		this.setNext(next);
		this.setPrev(prev);
	}
	
	
	protected Nodo getNewNodo(String user,
			String pass, Nodo next, Nodo prev){
		Nodo newNodo = new Nodo(user, pass, next, prev);
		return newNodo;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	private Nodo getPrev() {
		return prev;
	}

	private void setPrev(Nodo prev) {
		this.prev = prev;
	}
	
	
	
	
	

}
