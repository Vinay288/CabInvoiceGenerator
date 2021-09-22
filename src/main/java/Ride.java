public class Ride {
    private final double totalDistance;
    private final double totalMinutes;

    Ride(double totalDistance, double totalMinutes) {
        this.totalDistance = totalDistance;
        this.totalMinutes = totalMinutes;
    }

    public double getTotalMinutes() {
        return totalMinutes;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
