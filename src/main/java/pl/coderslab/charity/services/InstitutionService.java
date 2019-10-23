package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public List<Institution> getAllCategories() {
        return institutionRepository.findAll();
    }

    public Institution getInstitutionById(long institutionId) {
        return institutionRepository.getOne(institutionId);
    }
}
