package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.web.admin.institutions.editAdd.InstitutionDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;
    private DonationService donationService;

    public InstitutionService(InstitutionRepository institutionRepository, DonationService donationService) {
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
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

    public void addUpdateInstitution(InstitutionDTO institutionDTO) {
        Institution institution = new Institution();
        if (institutionDTO.getId() != null) institution = institutionRepository.getOne(institutionDTO.getId());
        institution.setName(institutionDTO.getName());
        institution.setDescription(institutionDTO.getDescription());
        institutionRepository.save(institution);
    }

    public void removeInstitutionById(Long elementId) {
        Institution institution = institutionRepository.getOne(elementId);
        List<Donation> donationList = donationService.getAllDonationsByInstitution(institution);
        donationList.forEach(d->donationService.delete(d));
        institutionRepository.delete(institution);
    }
}
