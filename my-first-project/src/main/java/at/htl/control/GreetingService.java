package at.htl.control;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@ApplicationScoped
//@RequestScoped
public class GreetingService {
    
    private static final Logger logger = Logger
            .getLogger(GreetingService.class.getSimpleName());
    
    int counter;

    public String greeting(String name) {
        logger.info(String.format("Hello %s (%d x verwendet)", name, ++counter));
        return String.format("Hello %s (%d x verwendet)", name, ++counter);
    }
    
}
