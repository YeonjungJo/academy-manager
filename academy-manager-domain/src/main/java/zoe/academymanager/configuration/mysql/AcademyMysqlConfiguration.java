package zoe.academymanager.configuration.mysql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import zoe.academymanager.domain.AcademyDomains;


@Configuration
@EnableJpaRepositories(
        basePackageClasses = {AcademyDomains.class})
public class AcademyMysqlConfiguration {
   
}
