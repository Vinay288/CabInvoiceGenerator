import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}