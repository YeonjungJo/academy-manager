package zoe.academymanager.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zoe.academymanager.AcademyApps;
import zoe.academymanager.domain.AcademyDomains;

@ComponentScan(basePackageClasses = {AcademyDomains.class, AcademyApps.class})
@EntityScan(basePackageClasses = AcademyDomains.class)
@EnableAsync
@EnableCaching
@SpringBootApplication
@RestController
public class AcademyManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademyManagerApplication.class, args);
    }

    @GetMapping(value = "/")
    public String test() {
        return "hello";
    }

}
