package ch.hearc.gotit.configurers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "ch.hearc.gotit.services.impl")
public class ServiceConfigurer {
}
