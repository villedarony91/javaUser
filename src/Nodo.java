
public class Nodo {
	
	private String username = null;
	private String password = null;
	private Nodo next = null;
	private Nodo prev = null;
	private NodeImage fimage = null;
	
	Nodo(String user, String pass, Nodo next, Nodo prev, NodeImage fimage){
		this.setUsername(user);
		this.setPassword(pass);
		this.setNext(next);
		this.setPrev(prev);
		this.setFimage(fimage);
	}
	
	
	protected Nodo getNewNodo(String user,
			String pass, Nodo next, Nodo prev, NodeImage fimage){
		Nodo newNodo = new Nodo(user, pass, next, prev, fimage);
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

	public Nodo getPrev() {
		return prev;
	}

	public void setPrev(Nodo prev) {
		this.prev = prev;
	}


	public NodeImage getFimage() {
		return fimage;
	}


	public void setFimage(NodeImage fimage) {
		this.fimage = fimage;
	}
	
	
	
	
	

}
