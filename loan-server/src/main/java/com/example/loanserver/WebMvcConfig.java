package com.example.loanserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public static final String REST_BASE_PATH = "/rest";
    public static final String BASE_PACKAGE = LoanServerApplication.class.getPackageName();

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(REST_BASE_PATH, this::isLoanApplicationController);
    }

    private boolean isLoanApplicationController(Class<?> clazz) {
        return clazz.getPackage().getName().startsWith(BASE_PACKAGE);
    }
}
