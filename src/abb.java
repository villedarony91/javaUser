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
public class abb {

 

    private class nodoArbol {

        private abb hd;

        private abb hi;

        private NodoHead data;

 

        private void nodoArbol(){

            hd = null;

            hi = null;

            data = null;

        }

    }

 

    public nodoArbol raiz;

 

    public void abb(){

        nodoArbol raiz = new nodoArbol();

    }

 

    public boolean esVacio(){

        return (raiz == null);

    }

 

    public void insertar(NodoHead ortHead){

        if (esVacio()) {

            nodoArbol nuevo = new nodoArbol();

            nuevo.data = ortHead;

            nuevo.hd = new abb();

            nuevo.hi = new abb();

            raiz = nuevo;

        }

        else {

            if (ortHead.getName()
                    .compareToIgnoreCase(raiz.data.getName()) > 0) {

                (raiz.hd).insertar(ortHead);

            }

            if (ortHead.getName()
                    .compareToIgnoreCase(raiz.data.getName()) < 0){

                (raiz.hi).insertar(ortHead);

            }

        }

    }

   public String preOrder(){
       StringBuilder sb = new StringBuilder();
        if (!esVacio()) {
            if(!raiz.hi.esVacio()){
            System.out.println("izq"+raiz.data.getName() + "->");
            sb.append("\"").append(raiz.data.getName()).append("\"")
                    .append(":izq").append("->");
            sb.append(raiz.hi.preOrder2());
            }
            if(!raiz.hd.esVacio()){
                sb.append("\"").append(raiz.data.getName()).append("\"")
                        .append(":der").append("->");
                sb.append(raiz.hd.preOrder2());
            }

        }
        return sb.toString();
   }
    public String preOrder2(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (!esVacio()) {
           System.out.print( raiz.data.getName() + ", "  );
           sb.append(raiz.data.getName()).append(";\n");
            if(!raiz.hi.esVacio()){
            System.out.println("izq"+raiz.data.getName() + "->");
            sb.append("\"").append(raiz.data.getName()).append("\"")
                    .append(":izq").append("->");
            sb.append(raiz.hi.preOrder2());
            }
            if(!raiz.hd.esVacio()){
            System.out.println("der"+raiz.data.getName() + "->");
            sb.append("\"").append(raiz.data.getName()).append("\"")
                    .append(":der").append("->");
            sb.append(raiz.hd.preOrder2());
            }

        }
        return sb.toString();
    }



    public abb buscar(String a){

        abb tmp = null;

        if (!esVacio()) {

            if (a.equals(raiz.data.getName())) {

            return this;

            }

            else {

                if (a.compareToIgnoreCase(raiz.data.getName()) < 0) {

                    tmp = raiz.hi.buscar(a);

                }

                else {

                    tmp = raiz.hd.buscar(a);

                }

            }

        }

        return tmp;

    }

 

 

     public String buscarMin() {

        abb arbolActual = this;

        while( !arbolActual.raiz.hi.esVacio() ) {

            arbolActual = arbolActual.raiz.hi;

        }

        String devuelvo= arbolActual.raiz.data.getName();

        arbolActual.raiz=null;

        return devuelvo;

    }

    public boolean esHoja() {

        boolean hoja = false;

        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {

            hoja = true;

        }

        return hoja;

    }

 

    public void eliminar(String a) {

        abb paraEliminar = buscar(a);

        if (!paraEliminar.esVacio()) {

            if (paraEliminar.esHoja()) {

                paraEliminar.raiz = null;

            }

            else {

                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) {

                    paraEliminar.raiz.data.getName().equals(paraEliminar.raiz.hd.buscarMin());

                }

                else {

                    if (paraEliminar.raiz.hi.esVacio()) {

                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz;

                    }else{

                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz;

                    }

                }

            }

        }

    }
    
    public String getGraph(nodoArbol node){
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
            
            sb.append(raiz.data.getName()).append("[label = \"<izq> |")
                   .append(raiz.data.getName()).append("|<der> \";]\n");

            sb.append(raiz.hi.getNodes());
            sb.append(raiz.hd.getNodes());
            getPointers();
            return sb.toString();
        }
        return "";
    }
    
    
    
    public String getPointers(){

        if (!esVacio()) {
            StringBuilder sb = new StringBuilder();
            
            if(!raiz.hi.esVacio()){
                System.out.println(raiz.data.getName()+ "->");
            }

            return sb.toString();
        }
        return "";
    }
    
    public String getData(){
        StringBuilder sb = new StringBuilder();
        if (!esVacio()) {
           sb.append(raiz.data.getName()).append(";");
            if(!raiz.hi.esVacio()){
            sb.append(raiz.hi.getData());
            }
            if(!raiz.hd.esVacio()){
                sb.append(raiz.hd.getData());
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
           sb.append(preOrder());
           sb.append("}");
           w.write("tree.dot", sb.toString());
           w.compileDot("tree");
        }
    }

}