import akka.actor.AbstractActor;

import java.time.Duration;

public class SecondActor extends AbstractActor {
    @Override
    public void preStart(){
        System.out.println("SecondActor starting...");
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, msg -> {
            System.out.println(msg+ sender());
        }).build();
    }
}
