package user;


import com.faushine.grpc.Greet.APIResponse;
import com.faushine.grpc.Greet.LoginRequest;
import com.faushine.grpc.greetGrpc.greetImplBase;

import io.grpc.stub.StreamObserver;

/**
 * @author Yuxin Fan
 * @create 2019-09-27
 */
public class GreetService extends greetImplBase {

  @Override
  public void hello(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
    System.out.println("Request accepted.");
    int msg = request.getGreetMessage();
    APIResponse.Builder response = APIResponse.newBuilder();
    response.setResponseMessage("The greet message is " + msg);
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }
}
