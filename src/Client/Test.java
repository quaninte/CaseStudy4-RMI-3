/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.SaveFile;
import java.awt.image.*;
import java.io.*;
import java.rmi.*;
import javax.imageio.*;

/**
 *
 * @author quanmt
 */
public class Test {
    
    public static void main(String[] args) throws Exception {
        BufferedImage image = ImageIO.read(new File("/Users/quanmt/a.png"));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(image, "png", baos);
        
        SaveFile service = (SaveFile) Naming.lookup("rmi://localhost:12345/saveImage");
        service.save(baos.toByteArray());
    }
    
}
