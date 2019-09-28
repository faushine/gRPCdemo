package service;


import com.google.protobuf.ByteString;
import com.faushine.grpc.Greet.APIResponse;
import com.faushine.grpc.Greet.Request;
import com.faushine.grpc.greetGrpc.greetImplBase;

import io.grpc.stub.StreamObserver;

/**
 * @author Yuxin Fan
 * @create 2019-09-27
 */
public class GreetService extends greetImplBase {

  @Override
  public void hello(Request request, StreamObserver<APIResponse> responseObserver) {
    System.out.println("Request accepted.");
    ByteString msg = request.getGreetMessage();
    APIResponse.Builder response = APIResponse.newBuilder();
    response.setResponseMessage("The greet data has " + msg.size()+" byte");
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

}
