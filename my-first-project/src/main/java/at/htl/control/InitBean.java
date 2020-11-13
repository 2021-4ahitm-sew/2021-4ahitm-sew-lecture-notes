package at.htl.control;

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
