package zoe.academymanager.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import zoe.academymanager.application.AcademyApplications;
import zoe.academymanager.domain.AcademyDomains;

@Configuration
@ComponentScan(basePackageClasses = {AcademyApplications.class, AcademyDomains.class})
@EnableAsync
public class AcademyDomainConfiguration { // implements TransactionManagementConfigurer {
//    public static final String PROJECT_NAME = "academy-manager";

//    @Resource
//    private PlatformTransactionManager transactionManager;
//
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return chainedTransactionManager();
//    }
//
//    @Bean
//    public PlatformTransactionManager chainedTransactionManager() {
//        return new ChainedTransactionManager(transactionManager);
//    }
//
    @Bean
    public PathMatcher pathMatcher() {
        return new AntPathMatcher();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
