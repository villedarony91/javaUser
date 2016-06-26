/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dispersa;

import DEF.Writer;

/**
 *
 * @author rlopez
 */
public class CreateMatrix {
    public NodoHead ortHead;
    
    void setHead(String head){
        ortHead = new NodoHead(head);
    }
    
    void getInfo(int posX, int posY, String color){
        insertPosx(posX);
        insertPosY(posY);
        insertValue( posX, posY, color);
    }
    
    void insertValue(int posX, int posY , String color){
        XNodo xtmp = ortHead.getXhead();
        YNodo ytmp = ortHead.getYhead();
        MatrizNodo newNode;
        while(xtmp.getxNext() != null && xtmp.getValue() != posX){
            xtmp = xtmp.getxNext();
        }
        while(ytmp.getyNext() != null && ytmp.getValue() != posY){
            ytmp = ytmp.getyNext();
        }
        if(xtmp.getxFmat() == null && ytmp.getyFmat() == null){
            newNode = new MatrizNodo(xtmp, ytmp, color);
            xtmp.setxFmat(newNode);
            ytmp.setyFmat(newNode);
        }

    
       if(ytmp.getyFmat() == null && xtmp.getxFmat() != null){
            if(xtmp.getxFmat().getYhead().getValue() > posY){
               //  newNode = new MatrizNodo(xtmp, ytmp, null, 
               
            }          
        }
//            MatrizNodo tmpMat = xtmp.getxFmat();
//            if(xtmp.getxFmat().getYhead().getValue() < posY &&
//                    xtmp.getxFmat().getYnext() == null){
//                newNode = new MatrizNodo(xtmp.getxFmat(), null, ytmp, color);
//                xtmp.getxFmat().setYnext(newNode);
//                ytmp.setyFmat(newNode);
//            }
//            if(xtmp.getxFmat().getYhead().getValue() < posY &&
//                    xtmp.getxFmat().getYnext() != null &&
//                    xtmp.getxFmat().getYnext().getYhead().getValue() > posY){
//                
//            }
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
    
    XNodo searchX(int value){
        XNodo tmp = ortHead.getXhead();
        while(tmp.getValue() != value && tmp.getxNext() != null){
            tmp = tmp.getxNext();
        }
        return tmp;
    }
    
    YNodo searchY(int value){
        YNodo tmp = ortHead.getYhead();
        while(tmp.getValue() != value && tmp.getyNext() != null){
            tmp = tmp.getyNext();
        }
        return tmp;
    }
    
    public void printX(){
        XNodo tmp = ortHead.getXhead();
        while(tmp != null){
            System.out.println(tmp.getValue());
//            System.out.println(tmp.getxFmat().getValue());
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
    
    private String getxHeaders(NodoHead ortHead){
        StringBuilder sb = new StringBuilder();
        XNodo tmp = ortHead.getXhead();
        while(tmp.getxNext() != null){
            sb.append("X").append(tmp.getValue()).append("->")
                    .append("X").append(tmp.getxNext()
                    .getValue()).append(";\n");
            tmp = tmp.getxNext();
            sb.append("X").append(tmp.getValue()).append("->")
                    .append("X").append(tmp.getxPrev()
                    .getValue()).append(";\n");
        }
        return sb.toString();
    }
    
    private String getyHeaders(NodoHead ortHead){
               StringBuilder sb = new StringBuilder();
        YNodo tmp = ortHead.getYhead();
        while(tmp.getyNext() != null){
            sb.append("Y").append(tmp.getValue()).append("->")
                    .append("Y").append(tmp.getyNext()
                    .getValue()).append(";\n");
            tmp = tmp.getyNext();
            sb.append("Y").append(tmp.getValue()).append("->")
                    .append("Y").append(tmp.getyPrev()
                    .getValue()).append(";\n");
        }
        return sb.toString();
    }
    
    public String getSameY(NodoHead ortHead){
        StringBuilder sb = new StringBuilder();
        YNodo tmp = ortHead.getYhead();
        sb.append("{ rank = same;");
        sb.append(ortHead.getName()).append(";");
        while(tmp != null){
            sb.append("Y").append(tmp.getValue()).append(";");
            tmp = tmp.getyNext();
        }
        sb.append("}");
        return sb.toString();
    }
    
    private String getfMat(NodoHead ortHead){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        XNodo xtmp = ortHead.getXhead();
        while(xtmp.getxNext() != null){
           if(xtmp.getxFmat()!= null){
               String name = "nodo" + count;
               sb.append("{rank = same;").append("X")
                       .append(xtmp.getValue()).append(";")
                       .append(name).append("}\n");
               sb.append(name).append("[label = \"")
                       .append(xtmp.getxFmat().getValue()).append("\"];\n");
               sb.append("X").append(xtmp.getValue()).append("->");
               sb.append("nodo").append(count).append(";\n");
               sb.append(name).append("->");
               sb.append("Y").append(xtmp.getxFmat().getYhead().getValue())
               .append(";\n");
               sb.append(name).append("->").append("X")
                       .append(xtmp.getValue())
                       .append(";\n");
               sb.append(name).append("->")
                       .append("Y")
                       .append(xtmp.getxFmat().getYhead().getValue())
                       .append(";\n");
               count ++;
           }
           xtmp = xtmp.getxNext();
           
        }
        return sb.toString();
    }
    
    public void graph(NodoHead ortHead){
        String disHead = ortHead.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G { \n");
        sb.append(getSameY(ortHead));
        sb.append(disHead).append("->").append("X")
                .append(ortHead.getXhead().getValue()).append(";\n");
        sb.append(disHead).append("->").append("Y")
                .append(ortHead.getYhead().getValue()).append(";\n");
        sb.append(getfMat(ortHead));
        sb.append("subgraph cluster0{\n");
        sb.append(getxHeaders(ortHead));
        sb.append("}");
        sb.append("subgraph cluster1{\n");
        sb.append(getyHeaders(ortHead));
        sb.append("}");
        sb.append("\n}");
        Writer w = new Writer();
        w.write("matriz.dot", sb.toString());
        w.compileDot("matriz");
        
    }
}
