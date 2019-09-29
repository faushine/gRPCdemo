import com.google.protobuf.ByteString;

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
public class GreetClient {

  private ManagedChannel channel;
  private greetBlockingStub stub;
  public long rrt;

  public GreetClient(String host, int port){
    channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext().build();
    stub = greetGrpc.newBlockingStub(channel);
  }

  public void run(int size){
    long start = System.currentTimeMillis();
    byte[] buff = new byte[size];
    LoginRequest loginRequest = LoginRequest.newBuilder().setGreetMessage(ByteString.copyFrom(buff)).build();
    APIResponse response = stub.hello(loginRequest);
    rrt = System.currentTimeMillis()-start;
    System.out.println(response.getResponseMessage());
    System.out.println("Round trip time is "+rrt +" ms");
  }

//  public static void main(String[] args) {
//    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
//    greetBlockingStub userStub =  greetGrpc.newBlockingStub(channel);
//    long start = System.currentTimeMillis();
////    byte[] buff = new byte[1];
//    byte[] buff = new byte[1024*1024];
//    LoginRequest loginRequest = LoginRequest.newBuilder().setGreetMessage(ByteString.copyFrom(buff)).build();
//    APIResponse response = userStub.hello(loginRequest);
//    long rrt = System.currentTimeMillis()-start;
//    System.out.println(response.getResponseMessage());
//    System.out.println("Round trip time is "+rrt +" ms");
//  }

}
