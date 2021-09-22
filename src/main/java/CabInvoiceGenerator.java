public class CabInvoiceGenerator {
    private static final int perKilometerFare = 10;
    private static final int perMinuteFare = 1;

    public int calculateTotalJourneyFare(int totalKilometer, int totalTimeInMinutes) {
        return ((totalKilometer * perKilometerFare) + (totalTimeInMinutes * perMinuteFare));
    }

}
