package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.Institution;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(nativeQuery = true, value = "SELECT sum(quantity) FROM donations")
    Integer sumOfQuantityForAllDoantions();

    @Query(value = "SELECT count(*) FROM (SELECT institution_id FROM donations GROUP BY institution_id) as institutions;", nativeQuery = true)
    Integer countAllDonatedInstitutions();

    List<Donation> findAllByUserIdOrderByStatusAscPickUpDateAscCreatedAsc(Long userId);

    List<Donation> findAllByInstitution(Institution institution);

}