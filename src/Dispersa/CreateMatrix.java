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
public class CreateMatrix {
    NodoHead ortHead;
    
    void setHead(String head){
        ortHead = new NodoHead(head);
    }
    
    void getInfo(int posX, int posY, String color){
        insertPosx(posX);
        insertPosY(posY);
    }
    
    void insertValue(int posX, int posY, String Color){
        
    }
    
    void insertPosx(int posX){
        NodoHead tmp = ortHead;
        XNodo newNode;
        if(ortHead != null && ortHead.getXhead() == null){
            newNode = new XNodo(ortHead , null, posX);
            ortHead.setXhead(newNode);
        }else{
            if(ortHead.getXhead() != null &&
                    ortHead.getXhead().getValue() > posX){
                newNode = new XNodo(ortHead, ortHead.getXhead(), posX );
                ortHead.getXhead().setxPrev(newNode);
                ortHead.getXhead().setHead(null);
                ortHead.setXhead(newNode);
            }else{
                XNodo aux = ortHead.getXhead();
                while(aux.getxNext() != null && aux.getValue() < posX){
                    aux = aux.getxNext();
                }
                if(aux.getValue() > posX){
                    newNode = new XNodo(aux.getxPrev(), aux, posX);
                    aux.getxPrev().setxNext(newNode);
                    aux.setxPrev(newNode);
                }else{
                    if(aux.getxNext() == null 
                            && aux.getValue() != posX){
                        newNode = new XNodo(aux, null, posX);
                        aux.setxNext(newNode);
                    }
                }
            }
        }
        
    }
    
    void insertPosY(int posY){
        NodoHead tmp = ortHead;
        YNodo newNode;
        if(ortHead != null && ortHead.getYhead() == null){
            newNode = new YNodo(ortHead , null, posY);
            ortHead.setYhead(newNode);
        }else{
            if(ortHead.getYhead() != null &&
                    ortHead.getYhead().getValue() > posY){
                newNode = new YNodo(ortHead, ortHead.getYhead(), posY );
                ortHead.getYhead().setyPrev(newNode);
                ortHead.getYhead().setHead(null);
                ortHead.setYhead(newNode);
            }else{
                YNodo aux = ortHead.getYhead();
                while(aux.getyNext() != null && aux.getValue() < posY){
                    aux = aux.getyNext();
                }
                if(aux.getValue() > posY){
                    newNode = new YNodo(aux.getyPrev(), aux, posY);
                    aux.getyPrev().setyNext(newNode);
                    aux.setyPrev(newNode);
                }else{
                    if(aux.getyNext() == null && 
                            aux.getValue() != posY){
                        newNode = new YNodo(aux, null, posY);
                        aux.setyNext(newNode);
                    }
                }
            }
        }
        
    }
    
    public void printX(){
        XNodo tmp = ortHead.getXhead();
        while(tmp != null){
            System.out.println(tmp.getValue());
            tmp = tmp.getxNext();
        }
    }
    
    public void printY(){
        YNodo tmp = ortHead.getYhead();
        while(tmp != null){
            System.out.println(tmp.getValue());
            tmp = tmp.getyNext();
        }
    }
}
