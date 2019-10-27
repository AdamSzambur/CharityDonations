package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@PropertySources({
        @PropertySource("/application.properties"),
        @PropertySource("/email.properties")
})
public class CharityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    @PostConstruct
    public void init(){
        // bez tego zapisując pole typu LocalDate do bazy otrzymamy datę pomniejszoną o jeden dzień :)
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
