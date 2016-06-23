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
public class MatrizNodo {
    
    private XNodo xhead;
    private YNodo yhead;
    private MatrizNodo xnext;
    private MatrizNodo xprev;
    private MatrizNodo ynext;
    private MatrizNodo yprev;
    private String value;

    MatrizNodo(XNodo x ,YNodo y, String value){
        this.setXhead(x);
        this.setYhead(y);
        this.setValue(value);
    }
    
    MatrizNodo(MatrizNodo xprev, MatrizNodo xnext, YNodo yhead, String value){
        this.setXnext(xnext);
        this.setXprev(xprev);
        this.setYhead(yhead);
        this.setValue(value);
    }
    
    MatrizNodo(XNodo x, YNodo y, MatrizNodo xprev, MatrizNodo xnext,
            MatrizNodo yprev, MatrizNodo ynext, String value){
        this.setXhead(x);
        this.setYhead(y);
        this.setXprev(xprev);
        this.setXnext(xnext);
        this.setYprev(yprev);
        this.setYnext(ynext);
        this.setValue(value);
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


    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the xnext
     */
    public MatrizNodo getXnext() {
        return xnext;
    }

    /**
     * @param xnext the xnext to set
     */
    public void setXnext(MatrizNodo xnext) {
        this.xnext = xnext;
    }

    /**
     * @return the xprev
     */
    public MatrizNodo getXprev() {
        return xprev;
    }

    /**
     * @param xprev the xprev to set
     */
    public void setXprev(MatrizNodo xprev) {
        this.xprev = xprev;
    }

    /**
     * @return the ynext
     */
    public MatrizNodo getYnext() {
        return ynext;
    }

    /**
     * @param ynext the ynext to set
     */
    public void setYnext(MatrizNodo ynext) {
        this.ynext = ynext;
    }

    /**
     * @return the yprev
     */
    public MatrizNodo getYprev() {
        return yprev;
    }

    /**
     * @param yprev the yprev to set
     */
    public void setYprev(MatrizNodo yprev) {
        this.yprev = yprev;
    }
    
}
