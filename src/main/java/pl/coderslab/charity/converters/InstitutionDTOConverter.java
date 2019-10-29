package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.InstitutionService;

@Component
public class InstitutionDTOConverter implements Converter<String, InstitutionDTO> {
    @Autowired
    private InstitutionService institutionService;

    @Override
    public InstitutionDTO convert(String s) {
        return institutionService.getInstitutionById(Long.parseLong(s));
    }
}
