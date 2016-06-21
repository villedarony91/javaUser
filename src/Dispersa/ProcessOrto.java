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
public class ProcessOrto {
    
    public CreateMatrix cm = new CreateMatrix();
    
    public void breakWhites(String input){
        String[] whites = input.split(",|\\s+|:");
        String[] substr = new String[3];
        cm.setHead(whites[1]);
        int j = 0;
        for(int i = 2 ; i < whites.length ; i++){
            j++;
            substr[j-1] = whites[i];
            if(j == 3){
                sendingToMatrix(substr);
                j = 0;
            }
            System.out.println(whites[i]+  " *** " + i );
        }
    }
    
    public void sendingToMatrix(String[] str){
        int x;
        int y;
        String color;
       if(str.length == 3){
           x = Integer.parseInt(str[0]);
           y = Integer.parseInt(str[1]);
           color = str[2];
           cm.getInfo(x, y, color);
       }
    }
}
