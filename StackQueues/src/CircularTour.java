public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, currPetrol = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];

            currPetrol += petrol[i] - distance[i];

            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
            }
        }

        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPoint(petrol, distance);
        if (startIndex != -1) {
            System.out.println("Start at petrol pump: " + startIndex);
        } else {
            System.out.println("No valid starting point exists.");
        }
    }
}