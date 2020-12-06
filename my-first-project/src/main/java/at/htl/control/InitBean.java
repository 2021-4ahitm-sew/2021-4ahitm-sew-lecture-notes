package at.htl.control;

import at.htl.entity.Node;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InitBean {

    @Inject
    GreetingService greetingService;

    @Inject
    Logger LOG;

    public InitBean() {
        runPrototype();
    }

    private void runPrototype() {
        Node turnier = new Node();

    }

    @PostConstruct
    private void init() {
        greetingService.greeting("Jonas 1");
    }

    // vergleichbar mit main()-MEthode
    void onStart(@Observes StartupEvent event) {
        LOG.info("The application is starting ...");
    }

}
