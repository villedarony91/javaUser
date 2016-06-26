package DEF;


import DEF.StaticSession;


public class NodeImage {
	
	private String path;
	private NodeImage next;
        private String name = "image";
  

	
        NodeImage(String path, NodeImage next){
            StaticSession.num = StaticSession.num + 1;
            this.setPath(path);
            this.setNext(next);
            this.name = (name + "" + StaticSession.num);
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public NodeImage getNext() {
		return next;
	}
	public void setNext(NodeImage next) {
		this.next = next;
	}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
