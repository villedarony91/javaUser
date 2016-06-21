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
public class XNodo {
    
    private NodoHead head;
    private XNodo xPrev;
    private XNodo xNext;
    private MatrizNodo xFmat;
    private int value;
    
    XNodo(NodoHead head, XNodo next, int value){
        this.setHead(head);
        this.setxNext(next);
        this.setValue(value);
    }

    XNodo(XNodo prev, XNodo next, int value){
        this.setxPrev(prev);
        this.setxNext(next);
        this.setValue(value);
    }
    /**
     * @return the head
     */
    public NodoHead getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(NodoHead head) {
        this.head = head;
    }

    /**
     * @return the xPrev
     */
    public XNodo getxPrev() {
        return xPrev;
    }

    /**
     * @param xPrev the xPrev to set
     */
    public void setxPrev(XNodo xPrev) {
        this.xPrev = xPrev;
    }

    /**
     * @return the xNext
     */
    public XNodo getxNext() {
        return xNext;
    }

    /**
     * @param xNext the xNext to set
     */
    public void setxNext(XNodo xNext) {
        this.xNext = xNext;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the xFmat
     */
    public MatrizNodo getxFmat() {
        return xFmat;
    }

    /**
     * @param xFmat the xFmat to set
     */
    public void setxFmat(MatrizNodo xFmat) {
        this.xFmat = xFmat;
    }
    
}
