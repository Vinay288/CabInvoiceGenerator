public class CabInvoiceGenerator {
    private static final int PER_KILOMETER_FARE = 10;
    private static final int PER_MINUTE_FARE = 1;
    private static final int MINIMUM_FARE = 5;

    public double calculateTotalJourneyFare(double totalKilometer, double totalTimeInMinutes) {
        double totalFare = (totalKilometer * PER_KILOMETER_FARE) + (totalTimeInMinutes * PER_MINUTE_FARE);
        return totalFare > MINIMUM_FARE ? totalFare : MINIMUM_FARE;
    }

}
