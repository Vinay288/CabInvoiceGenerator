import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_WhenCorrect_ShouldReturnTotalFare() {
        int totalKilometer = 2, totalTimeInMinutes = 5;
        CabInvoiceGenerator generateInvoice = new CabInvoiceGenerator();
        int totalFare = generateInvoice.calculateTotalJourneyFare(totalKilometer, totalTimeInMinutes);
        Assertions.assertEquals(25, totalFare);
    }
}