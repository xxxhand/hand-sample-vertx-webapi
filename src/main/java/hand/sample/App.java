package hand.sample;

import io.vertx.core.Vertx;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Vertx vx = Vertx.vertx();
        vx.deployVerticle(ServerVerticle.class.getName(), res -> {
            if (res.succeeded()) {
                System.out.println("Http server deploy success, deploy id: " + res.result());
                return;
            }
            res.cause().printStackTrace();
            System.out.println("Http server deploy fail");
        });
    }
}
