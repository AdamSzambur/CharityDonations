package pl.coderslab.charity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }

    @Bean
    LocaleResolver localeResolver() {
        FixedLocaleResolver l = new FixedLocaleResolver();
        l.setDefaultLocale(Locale.ENGLISH);
        return l;
    }


//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//       LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//       lci.setParamName("lang");
//       return lci;
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(localeChangeInterceptor());
//    }

//    @Bean
//    public AcceptHeaderLocaleResolver localeResolver(WebMvcProperties mvcProperties) {
//        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver() {
//            @Override
//            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
//                LocaleContextHolder.setLocale(locale);
//            }
//        };
//
//
//        localeResolver.setDefaultLocale(mvcProperties.getLocale());
//        return localeResolver;
//    }
}