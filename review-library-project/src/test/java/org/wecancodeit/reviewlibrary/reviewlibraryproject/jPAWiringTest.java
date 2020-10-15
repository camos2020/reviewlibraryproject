package org.wecancodeit.reviewlibrary.reviewlibraryproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class jPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReviewLibraryRepository reviewLibraryRepo;

    @Autowired
    private PlateRepository plateRepo;



    @Test
    public void catalogShouldHaveAListOfReviews() {
        ReviewLibrary testReviewLibraryTitle = new ReviewLibrary("Test reviewTitle");
        Plate testPlate1 = new Plate("Test reviewName", "Test reviewCategory");
        ReviewLibrary retrievedReviewLibrary = null;
        assertThat(retrievedReviewLibrary.getReviews()).contains(testPlate1);

        reviewLibraryRepo.save(testReviewLibraryTitle);
        plateRepo.save(testPlate1);

        entityManager.flush();
        entityManager.clear();

        Optional<ReviewLibrary> retrievedReviewLibraryOpt = reviewLibraryRepo.findById(testReviewLibraryTitle.getId());
        retrievedReviewLibrary = retrievedReviewLibraryOpt.get();
        Plate retrievedPlate = retrievedPlateOpt.get();


    }
}
