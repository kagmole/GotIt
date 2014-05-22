package ch.hearc.gotit.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ch.hearc.gotit.services.impl")
public class ServiceConfig {
}
