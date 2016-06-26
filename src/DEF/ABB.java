package DEF;

import Dispersa.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rlopez
 */
public class ABB {

 
    public class Node {
        private NodoHead data;
        private ABB der;
        private ABB izq;


        private void node(){
            setDer(null);
            setIzq(null);
            setData(null);
        }

        /**
         * @return the data
         */
        public NodoHead getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(NodoHead data) {
            this.data = data;
        }

        /**
         * @return the der
         */
        public ABB getDer() {
            return der;
        }

        /**
         * @param der the der to set
         */
        public void setDer(ABB der) {
            this.der = der;
        }

        /**
         * @return the izq
         */
        public ABB getIzq() {
            return izq;
        }

        /**
         * @param izq the izq to set
         */
        public void setIzq(ABB izq) {
            this.izq = izq;
        }
    }

    public Node raiz;
    
    public void abb(){
        Node raiz = new Node();
    }

     public void delete(String a) {
        ABB toDelete = search(a);
        if (!toDelete.esVacio()) {
            if (toDelete.isLast()) {
                toDelete.raiz = null;
            }
            else {
                if (!toDelete.raiz.izq.esVacio() && !toDelete.raiz.der.esVacio()) {
                    toDelete.raiz.getData().getName().equals(toDelete.raiz.getDer().getMin());
                }
                else {
                    if (toDelete.raiz.getIzq().esVacio()) {
                        toDelete.raiz = toDelete.raiz.getDer().raiz;
                    }else{
                        toDelete.raiz = toDelete.raiz.getIzq().raiz;
                    }
                }
            }
        }
    }

    public boolean esVacio(){
        return (raiz == null);
    }

 

    public void insert(NodoHead ortHead){
        if (esVacio()) {
            Node newNode = new Node();
            newNode.setData(ortHead);
            newNode.setDer(new ABB());
            newNode.setIzq(new ABB());
            raiz = newNode;
        }
        else {
            if (ortHead.getName()
                    .compareToIgnoreCase(raiz.getData().getName()) > 0) {
                (raiz.getDer()).insert(ortHead);
            }
            if (ortHead.getName()
                    .compareToIgnoreCase(raiz.getData().getName()) < 0){
                (raiz.getIzq()).insert(ortHead);
            }
        }
    }

   public String getToGraph(){
       StringBuilder sb = new StringBuilder();
        if (!esVacio()) {
            if(!raiz.izq.esVacio()){
            System.out.println("izq"+raiz.getData().getName() + "->");
            sb.append("\"").append(raiz.getData().getName()).append("\"")
                    .append(":izq").append("->");
            sb.append(raiz.getIzq().getToGraph2());
            }
            if(!raiz.der.esVacio()){
                sb.append("\"").append(raiz.getData().getName()).append("\"")
                        .append(":der").append("->");
                sb.append(raiz.getDer().getToGraph2());
            }

        }
        return sb.toString();
   }
   
    public String getToGraph2(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (!esVacio()) {
           System.out.print(raiz.getData().getName() + ", "  );
           sb.append(raiz.getData().getName()).append(";\n");
            if(!raiz.izq.esVacio()){
            System.out.println("izq"+raiz.getData().getName() + "->");
            sb.append("\"").append(raiz.getData().getName()).append("\"")
                    .append(":izq").append("->");
            sb.append(raiz.getIzq().getToGraph2());
            }
            if(!raiz.der.esVacio()){
            System.out.println("der"+raiz.getData().getName() + "->");
            sb.append("\"").append(raiz.getData().getName()).append("\"")
                    .append(":der").append("->");
            sb.append(raiz.getDer().getToGraph2());
            }

        }
        return sb.toString();
    }



    public ABB search(String a){
        ABB tmp = null;
        if (!esVacio()) {
            if (a.equals(raiz.getData().getName())) {
            return this;
            }
            else {
                if (a.compareToIgnoreCase(raiz.getData().getName()) < 0) {
                    tmp = raiz.getIzq().search(a);
                }
                else {
                    tmp = raiz.getDer().search(a);
                }
            }
        }
        return tmp;
    }
 
     public String getMin() {
        ABB tmp = this;
        while( !tmp.raiz.izq.esVacio() ) {
            tmp = tmp.raiz.getIzq();
        }
        String min= tmp.raiz.getData().getName();
        tmp.raiz=null;
        return min;
    }
    
    public String getGraph(Node node){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        
            
        /*else{return sb.toString();}
        if(!node.hi.esVacio()){
            sb.append("\"").append(node.data.getName()).append("\"")
                    .append(":izq ->").append(raiz.hi.raiz.data.getName())
                    .append(";\n");
            sb.append("");
        }
        if(!raiz.hd.esVacio()){
             sb.append("\"").append(node.data.getName()).append("\"")
                    .append(":der ->").append(raiz.hd.raiz.data.getName())
                     .append(";\n");
             sb.append(getGraph(node.hi.raiz));
        }*/
        return sb.toString();
    }
    
    public String getNodes(){

        if (!esVacio()) {
            StringBuilder sb = new StringBuilder();
            
            sb.append(raiz.getData().getName()).append("[label = \"<izq> |")
                   .append(raiz.getData().getName()).append("|<der> \";]\n");

            sb.append(raiz.getIzq().getNodes());
            sb.append(raiz.getDer().getNodes());
            getPointers();
            return sb.toString();
        }
        return "";
    }
    
    public boolean isLast() {
        boolean last = false;
        if( (raiz.getDer()).esVacio() && (raiz.getIzq()).esVacio()) {
            last = true;
        }
        return last;
    }
    
    public String getPointers(){

        if (!esVacio()) {
            StringBuilder sb = new StringBuilder();
            
            if(!raiz.izq.esVacio()){
                System.out.println(raiz.getData().getName()+ "->");
            }

            return sb.toString();
        }
        return "";
    }
    
    public String getData(){
        StringBuilder sb = new StringBuilder();
        if (!esVacio()) {
           sb.append(raiz.getData().getName()).append(";");
            if(!raiz.izq.esVacio()){
            sb.append(raiz.getIzq().getData());
            }
            if(!raiz.der.esVacio()){
                sb.append(raiz.getDer().getData());
            }
        }
        return sb.toString();
    }
    
    public void graphTree(){
        if(esVacio()){return;}
        else{
           StringBuilder sb = new StringBuilder();
           Writer w = new Writer();
           sb.append("digraph G {\n");
           sb.append("node [shape = record, height=.1];\n");
           sb.append(getNodes());
           sb.append(getToGraph());
           sb.append("}");
           w.write("tree.dot", sb.toString());
           w.compileDot("tree");
        }
    }

}