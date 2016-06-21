/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispersa;

/**
 *
 * @author rlopez
 */
public class NodoHead {
    
    private String name;
    private XNodo xhead;
    private YNodo yhead;
    
    NodoHead(String name){
        this.setName(name);
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

    /**
     * @return the xhead
     */
    public XNodo getXhead() {
        return xhead;
    }

    /**
     * @param xhead the xhead to set
     */
    public void setXhead(XNodo xhead) {
        this.xhead = xhead;
    }

    /**
     * @return the yhead
     */
    public YNodo getYhead() {
        return yhead;
    }

    /**
     * @param yhead the yhead to set
     */
    public void setYhead(YNodo yhead) {
        this.yhead = yhead;
    }
    
}
