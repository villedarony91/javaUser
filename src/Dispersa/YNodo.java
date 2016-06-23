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
public class YNodo {
   
    private NodoHead head;
    private YNodo yPrev;
    private YNodo yNext;
    public MatrizNodo yFmat;
    private int value;
    
    YNodo(NodoHead head, YNodo next, int value){
        this.setHead(head);
        this.setyNext(next);
        this.setValue(value);
    }
    
    YNodo(YNodo prev, YNodo next, int value){
        this.setyPrev(prev);
        this.setyNext(next);
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
     * @return the yPrev
     */
    public YNodo getyPrev() {
        return yPrev;
    }

    /**
     * @param yPrev the yPrev to set
     */
    public void setyPrev(YNodo yPrev) {
        this.yPrev = yPrev;
    }

    /**
     * @return the yNext
     */
    public YNodo getyNext() {
        return yNext;
    }

    /**
     * @param yNext the yNext to set
     */
    public void setyNext(YNodo yNext) {
        this.yNext = yNext;
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
     * @return the yFmat
     */
    public MatrizNodo getyFmat() {
        return yFmat;
    }

    /**
     * @param yFmat the yFmat to set
     */
    public void setyFmat(MatrizNodo yFmat) {
        this.yFmat = yFmat;
    }
}
