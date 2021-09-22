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
}