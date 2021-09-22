import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_WhenCorrect_ShouldReturnTotalFare() {
        int totalKilometer = 2, totalTimeInMinutes = 5;
        CabInvoiceGenerator generateInvoice = new CabInvoiceGenerator();
        double totalFare = generateInvoice.calculateTotalJourneyFare(totalKilometer, totalTimeInMinutes);
        Assertions.assertEquals(25, totalFare);
    }

    @Test
    public void givenDistanceAndTime_WhenLess_ShouldReturnMinimumFare() {
        double totalKilometer = 0.1, totalTimeInMinutes = 1;
        CabInvoiceGenerator generateInvoice = new CabInvoiceGenerator();
        double totalFare = generateInvoice.calculateTotalJourneyFare(totalKilometer, totalTimeInMinutes);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
    public void givenDistanceAndTimeMultipleRides_WhenCorrect_ShouldReturnTotalAggregatedFare() {
        CabInvoiceGenerator generateInvoice = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(5, 5), new Ride(10, 20), new Ride(0.2, 1)};
        Invoice actualInvoice = generateInvoice.calculateTotalJourneyFare(rides);
        Invoice expectedInvoice = new Invoice(3, 180, 60);
        Assertions.assertEquals(expectedInvoice.toString(), actualInvoice.toString());
    }

    @Test
    public void givenUserId_WhenCorrect_ShouldReturnInvoiceFromRideRepository() {
        CabInvoiceGenerator generateInvoice = new CabInvoiceGenerator();
        HashMap<Integer, Ride[]> rideRepository = new HashMap<>();
        rideRepository.put(100, new Ride[]{new Ride(5, 5), new Ride(10, 20), new Ride(0.2, 1)});
        rideRepository.put(200, new Ride[]{new Ride(10, 20), new Ride(0.2, 5)});
        Invoice actualInvoice = generateInvoice.calculateTotalJourneyFare(100, rideRepository);
        Invoice expectedInvoice = new Invoice(3, 180, 60);
        Assertions.assertEquals(expectedInvoice.toString(), actualInvoice.toString());
    }

}