#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties","classpath:application-${spring.profiles.active}.properties"})
@ComponentScan({"${package}", "com.budwhite.studying.framework"})
@EntityScan("${package}.model.entity")
public class ${camelApplicationName}Application {

    public static void main(String[] args) {
        SpringApplication.run(${camelApplicationName}Application.class, args);
    }

}
