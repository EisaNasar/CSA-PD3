import java.util.Random;

public class Feeder {
    private int currentFood;

    public Feeder(int initialFood) {
        this.currentFood = initialFood;
    }

    public void simulateOneDay(int numBirds) {
        Random rand = new Random();
        int condition = rand.nextInt(100);
        if (condition < 95) { 
            int foodPerBird = rand.nextInt(41) + 10; 
            int totalFoodConsumed = numBirds * foodPerBird;
            currentFood = Math.max(0, currentFood - totalFoodConsumed);
        } else { 
            currentFood = 0; 
        }
    }

    public int simulateManyDays(int numBirds, int numDays) {
        int daysWithFood = 0;
        for (int i = 0; i < numDays; i++) {
            if (currentFood > 0) {
                daysWithFood++;
                simulateOneDay(numBirds);
            } else {
                break; 
            }
        }
        return daysWithFood;
    }
}
