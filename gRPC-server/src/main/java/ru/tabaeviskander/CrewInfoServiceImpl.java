package ru.tabaeviskander;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import iskander.tabaev.grpc.CrewInfoServiceGrpc;
import iskander.tabaev.grpc.CrewInfoServiceOuterClass;

public class CrewInfoServiceImpl extends CrewInfoServiceGrpc.CrewInfoServiceImplBase {

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void crewInfo(Empty request, StreamObserver<CrewInfoServiceOuterClass.CrewInfoResponse> responseObserver) {
        CrewInfoServiceOuterClass.CrewInfoResponse response = CrewInfoServiceOuterClass.CrewInfoResponse
                .newBuilder()
                .setBeginWeight(228)
                .setCrewNumber(56)
                .setCoffeeSort("Арабика")
                .setEndWeight(220)
                .setOriginCountry("Чичня")
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
