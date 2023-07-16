package ru.iskandertabaev;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import iskander.tabaev.grpc.CrewInfoServiceGrpc;
import iskander.tabaev.grpc.CrewInfoServiceOuterClass;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        CrewInfoServiceGrpc.CrewInfoServiceBlockingStub stub
                = CrewInfoServiceGrpc.newBlockingStub(channel);

        com.google.protobuf.Empty request = com.google.protobuf.Empty.newBuilder().build();

        CrewInfoServiceOuterClass.CrewInfoResponse response = stub.crewInfo(request);

        channel.shutdown();
        System.out.println(response.getBeginWeight());
        System.out.println(response.getCoffeeSort());
        System.out.println(response.getEndWeight());
        System.out.println(response.getOriginCountry());




    }
}
