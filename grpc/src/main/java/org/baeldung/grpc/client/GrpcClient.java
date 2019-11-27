package org.baeldung.grpc.client;

import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.baeldung.grpc.secondGUI;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        LocalTime localTime = LocalTime.parse("09:58:01");
        System.out.println("Wait until the time of downloading medication plan,witch is: " +localTime);
        while (i == 1) {


            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            if (localTime.toString().equals(time.format(formatter))) {
                System.out.println("Ore egale");
                i = 0;

                secondGUI f = new secondGUI();
                f.setVisible(true);

                f.isShowing();
            }
        }
    }
}
