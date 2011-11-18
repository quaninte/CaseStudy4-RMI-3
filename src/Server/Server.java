/*
 * windows: start rmiregistry
 * unix: rmiregistry &
 */
package Server;

import java.awt.image.BufferedImage;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.imageio.ImageIO;

/**
 *
 * @author quanmt
 */
public class Server extends UnicastRemoteObject implements SaveFile {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public void save(byte[] bytes) throws RemoteException {
        File tmpFile = new File("");
        String localPath = tmpFile.getAbsolutePath();
        
        try {
            File file = new File(localPath + "/image.png");
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) throws Exception {
	
        Server server = new Server();

        LocateRegistry.createRegistry(12345);
        Naming.rebind("rmi://localhost:12345/saveImage", server);
        
        System.out.print("Save image server is running ...");
        
    }
    
}
