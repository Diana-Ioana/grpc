package org.baeldung.grpc.server;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    private static final Logger LOGGER = Logger.getLogger(GrpcServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {

        //////
        int i = 1;
        LocalTime localTime = LocalTime.parse("09:58:01");
        System.out.println("Wait until the time of downloading medication plan,witch is: " + localTime);
        while (i == 1) {

            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            //System.out.println("Ora curenta: " + time.format(formatter));
            ///////////////////////////////////////////////////////////////

            if (localTime.toString().equals(time.format(formatter))) {
                System.out.println("Ore egale");
                i = 0;


                //////
                Server server = ServerBuilder.forPort(8090)
                        .addService(new HelloServiceImpl()).build();

                System.out.println("Starting server...");
                server.start();
                System.out.println("Server started!");
                server.awaitTermination();
            }
        }
    }
}
