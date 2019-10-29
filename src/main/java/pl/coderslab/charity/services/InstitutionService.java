package pl.coderslab.charity.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.dto.InstitutionDTO;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;
    private DonationService donationService;
    private ModelMapper mapper = new ModelMapper();
    private Type targetListInstitutionDTO = new TypeToken<List<InstitutionDTO>>() {}.getType();

    public InstitutionService(InstitutionRepository institutionRepository, DonationService donationService) {
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
    }

    public List<InstitutionDTO> getAllInstitutions() {
        return mapper.map(institutionRepository.findAll(),targetListInstitutionDTO);
    }

    public List<InstitutionDTO> getAllCategories() {
        return mapper.map(institutionRepository.findAll(),targetListInstitutionDTO);
    }

    public InstitutionDTO getInstitutionById(long institutionId) {
        return mapper.map(institutionRepository.getOne(institutionId), InstitutionDTO.class);
    }

    public void addUpdateInstitution(InstitutionDTO institutionDTO) {
        Institution institution = mapper.map(institutionDTO,Institution.class);
        institutionRepository.save(institution);
    }

    public void removeInstitutionById(Long elementId) {
        Institution institution = institutionRepository.getOne(elementId);
        List<DonationDTO> donationList = donationService.getAllDonationsByInstitution(institution);
        donationList.forEach(d->donationService.delete(d.getId()));
        institutionRepository.delete(institution);
    }
}
