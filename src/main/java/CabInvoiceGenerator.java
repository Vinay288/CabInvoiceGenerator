import java.util.Arrays;
import java.util.HashMap;

public class CabInvoiceGenerator {
    private static final int NORMAL_PER_KILOMETER_FARE = 10;
    private static final int NORMAL_PER_MINUTE_FARE = 1;
    private static final int NORMAL_MINIMUM_FARE = 5;
    private static final int PREMIUM_PER_KILOMETER_FARE = 15;
    private static final int PREMIUM_PER_MINUTE_FARE = 2;
    private static final int PREMIUM_MINIMUM_FARE = 20;

    public double calculateTotalJourneyFare(double totalKilometer, double totalTimeInMinutes,RideType type) {
        if(type==RideType.NORMAL_RIDE) {
            double totalFare = (totalKilometer * NORMAL_PER_KILOMETER_FARE) + (totalTimeInMinutes * NORMAL_PER_MINUTE_FARE);
            return totalFare > NORMAL_MINIMUM_FARE ? totalFare : NORMAL_MINIMUM_FARE;
        }
        double totalFare = (totalKilometer * PREMIUM_PER_KILOMETER_FARE) + (totalTimeInMinutes * PREMIUM_PER_MINUTE_FARE);
        return totalFare > PREMIUM_MINIMUM_FARE ? totalFare : PREMIUM_MINIMUM_FARE;
    }

    public Invoice calculateTotalJourneyFare(Ride[] rides,RideType type) {
        double totalFare = Arrays.stream(rides).mapToDouble(ride -> calculateTotalJourneyFare(ride.getTotalDistance(), ride.getTotalMinutes(),type)).sum();
        int totalRides = rides.length;
        double averageFarePerRide = totalFare / totalRides;
        return new Invoice(totalRides, totalFare, averageFarePerRide);
    }

    public Invoice calculateTotalJourneyFare(Integer userId, HashMap<Integer, Ride[]> rideRepository,RideType type) {
        return calculateTotalJourneyFare(rideRepository.get(userId),type);
    }
}
