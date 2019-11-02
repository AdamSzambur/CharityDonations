package pl.coderslab.charity.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.InstitutionService;

@Component
public class InstitutionConverter implements Converter<String, Institution> {
    @Autowired
    private InstitutionService institutionService;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public Institution convert(String s) {
        return mapper.map(institutionService.getInstitutionById(Long.parseLong(s)),Institution.class);
    }
}
