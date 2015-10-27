/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sasmito
 */
public class UTS {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String host = "10.151.34.155";
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            socket = new Socket (host, 6666);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(UTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               
        BufferedReader userIn;
        userIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        userInput = "USERNAME:" + userIn.readLine() + "\n";
        out.println(userInput);
        out.flush();
        userIn.close();
        String o;
        
        while(!(o = in.readLine()).equals("666")){
            String x;
            String delim = "[ ]+";
            String[] token;
            int y;
            int a;
            int b;
            int c=0;
            for(int i = 1; in.ready(); i++) {
                x = in.readLine();
                System.out.println(x);
                token = x.split(delim);
                y = token.length - 1;
                
                if(token[y].equals("?")){
                    a = Integer.parseInt(token[0]);
                    b = Integer.parseInt(token[2]);
                    if(token[1].equals("+")){
                        c = a + b;
                    }
                    else if(token[1].equals("-")){
                        c = a - b;
                    }
                    else if(token[1].equals("*")){
                        c = a * b;
                    }
                    else if(token[1].equals("mod")){
                        c = a % b;
                    }
                    userInput = "Result:" + Integer.toString(c) + "\n";
                    out.println(userInput);
                    out.flush();
                }
                
                if(x.equals("Hash:")){
                    in.readLine();
                    userInput = "Hash:" + in.readLine() + "\n";
                    out.println(userInput);
                    out.flush();
                }
                
            }
        }
        System.out.println(o);
        in.close();
        out.close();
        socket.close();
        
            
        
    }
    
}
