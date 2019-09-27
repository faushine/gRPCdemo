import com.faushine.grpc.Greet.APIResponse;
import com.faushine.grpc.Greet.LoginRequest;
import com.faushine.grpc.greetGrpc;
import com.faushine.grpc.greetGrpc.greetBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author Yuxin Fan
 * @create 2019-09-27
 */
public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
    //stubs - generate from proto

    greetBlockingStub userStub =  greetGrpc.newBlockingStub(channel);
    long start = System.currentTimeMillis();
    LoginRequest loginRequest = LoginRequest.newBuilder().setGreetMessage(10).build();
    APIResponse response = userStub.hello(loginRequest);
    long rrt = System.currentTimeMillis()-start;
    System.out.println(response.getResponseMessage());
    System.out.println("Round trip time is "+rrt +" ms");
  }

}
