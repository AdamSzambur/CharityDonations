package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.InstitutionService;

@Component
public class InstitutionConverter implements Converter<String, Institution> {
    @Autowired
    private InstitutionService institutionService;

    @Override
    public Institution convert(String s) {
        return institutionService.getInstitutionById(Long.parseLong(s));
    }
}
