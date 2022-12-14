package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.CacheRequest;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class CustomWebApp {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApp.class);

    public CustomWebApp(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[CustumWebApplicationServer] started {} port ", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");
            while ((clientSocket = serverSocket.accept())!=null){
                logger.info("[CustomWebApplicationServer] client connected!");



                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader((new InputStreamReader(in,StandardCharsets.UTF_8)));
                    DataOutputStream dos = new DataOutputStream(out);
                    HttpRequest httpRequest = new HttpRequest(br);
                    if(httpRequest.isGetRequset() && httpRequest.matching("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 =Integer.parseInt(queryStrings.getValue("operand2"));
                    }
                    /*
                    String line;
                    while((line = br.readLine()) !=""){
                        System.out.println(line);
                    }*/


                }
            }
        }
    }
}
