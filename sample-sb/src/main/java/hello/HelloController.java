package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Component
@Configuration
public class HelloController {

    @Value("${tag:undefined, define TAG env variable}")
    private String buildTag;

    @RequestMapping("/")
    public String index() {
        log.info("Got a request to greet {} {}", buildTag, System.getProperties());
        return "Greetings from Spring Boot! " + buildTag;
    }

    @RequestMapping("/err")
    public String error() {
        log.error("Got a request to report error {}", buildTag);
        return "Error from Spring Boot! " + buildTag;
    }
}
