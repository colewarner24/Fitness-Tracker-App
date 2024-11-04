package fitnesstracker.designs.caloriescalculator;

public class RunningCalorieStrategy implements CalorieCalculationStrategy {
    @Override
    public int calculateCalories(int weight, int duration) {
        return (int) (0.0175 * 10 * weight * duration);
        // 0.0175 CONSTANT | 10 MET intensity(high) check link for more details
        /*https://www.ucdenver.edu/docs/librariesprovider65/clinical-services/sports-medicine/
        estimating-energy-expenditure.pdf?sfvrsn=eb335bb9_2#:~:text=Use%20the%20following%20formula
        %20to%20calculate%20how%20many,simply%20divide%20your%20weight%20in%20pounds%20by%202.2.%29*/
    }
}
