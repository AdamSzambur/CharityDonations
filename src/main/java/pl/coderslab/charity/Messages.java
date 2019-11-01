package pl.coderslab.charity;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Messages {

    private MessageSource messageSource;
    private WebMvcProperties mvcProperties;

    public Messages(MessageSource messageSource, WebMvcProperties mvcProperties) {
        this.messageSource = messageSource;
        this.mvcProperties = mvcProperties;
    }

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, mvcProperties.getLocale());
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }
}
