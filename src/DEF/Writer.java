package DEF;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rlopez
 */
public class Writer {
    
    public void write(String name, String content ){
        		try {
			File file = new File("/var/www/html/"+name);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void compileDot(String FILE_NAME){
        String path = "/var/www/html/";
        String command = "dot -Tjpg " + path + FILE_NAME + ".dot" + " -o "+
                path + FILE_NAME + ".jpg";
        try {
            Process proc = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
