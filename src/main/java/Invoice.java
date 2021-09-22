public class Invoice {

    private final int totalRides;
    private final double totalFare;
    private final double averageFarePerRide;

    public Invoice(int totalRides, double totalFare, double averageFarePerRide) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = averageFarePerRide;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalRides=" + totalRides +
                ", totalFare=" + totalFare +
                ", averageFarePerRide=" + averageFarePerRide +
                '}';
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }
}
