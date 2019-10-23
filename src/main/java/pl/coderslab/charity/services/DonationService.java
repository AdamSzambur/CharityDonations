package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.web.donations.DonationDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class DonationService {

    private DonationRepository donationRepository;

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
        Donation donation = new Donation();
        donation.setCategories(donationDTO.getCategories());
        donation.setCity(donationDTO.getCity());
        donation.setInstitution(donationDTO.getInstitution());
        donation.setPhone(donationDTO.getPhone());
        donation.setPickUpComment(donationDTO.getPickUpComment());
        donation.setPickUpTime(donationDTO.getPickUpTime());
        donation.setQuantity(donationDTO.getQuantity());
        donation.setStreet(donationDTO.getStreet());
        donation.setZipCode(donationDTO.getZipCode());
        donation.setPickUpDate(donationDTO.getPickUpDate());
        donationRepository.save(donation);
    }
}