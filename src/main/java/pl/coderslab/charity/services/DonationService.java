package pl.coderslab.charity.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DonationService {

    private DonationRepository donationRepository;
    private UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();
    private Type targetListDonationDTO = new TypeToken<List<DonationDTO>>() {}.getType();


    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Integer getSumOfQuantity() {
        Integer result = donationRepository.sumOfQuantityForAllDoantions();
        if (result!=null) return result;
        return 0;
    }

    public Integer sumAllDonatedInstitiutions() {
        return donationRepository.countAllDonatedInstitutions();
    }

    public void addDonation(DonationDTO donationDTO) {
        Donation donation = mapper.map(donationDTO,Donation.class);
        donation.setUser(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        donation.setStatus("nieodebrane");
        donationRepository.save(donation);
    }

    public List<DonationDTO> getAllDonationsByUser(Long userId) {
        return mapper.map(donationRepository.findAllByUserIdOrderByStatusAscPickUpDateAscCreatedAsc(userId),targetListDonationDTO);
    }

    public DonationDTO getDonationById(Long donationId) {
        return mapper.map(donationRepository.getOne(donationId), DonationDTO.class);
    }

    public void changeStatusToReceived(Long id) {
        Donation donation = donationRepository.getOne(id);
        donation.setPickUpDate(LocalDate.now());
        donation.setStatus("odebrane");
        donationRepository.save(donation);
    }

    public List<DonationDTO> getAllDonationsByInstitution(Institution institution) {
        return mapper.map(donationRepository.findAllByInstitution(institution),targetListDonationDTO);
    }

    public void delete(Long donationId) {
        donationRepository.delete(donationRepository.getOne(donationId));
    }
}
