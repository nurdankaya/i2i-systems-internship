import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class RunActor {
    public static void main( String[] args )
    {
        ActorSystem system = ActorSystem.create("actor-system");


        ActorRef master = system.actorOf(Props.create(MasterActor.class));
        ActorRef secondActor = system.actorOf(Props.create(SecondActor.class));

        master.tell("masterActor message ", Actor.noSender());
        secondActor.tell("master to secondActor message ", master );
        secondActor.tell("secondActor message ",  Actor.noSender() );

        system.terminate();
    }
}
