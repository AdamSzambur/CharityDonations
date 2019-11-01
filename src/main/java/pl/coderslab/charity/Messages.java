package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private WebMvcProperties mvcProperties;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, mvcProperties.getLocale());
    }
    public String get(String code) {
        return accessor.getMessage(code);
    }
}
