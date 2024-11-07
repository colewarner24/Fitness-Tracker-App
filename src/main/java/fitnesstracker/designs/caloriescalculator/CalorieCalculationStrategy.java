package fitnesstracker.designs.caloriescalculator;

public interface CalorieCalculationStrategy {
    int calculateCalories(int weight, int duration);

        /* DETAILS ON CONSTANTS AND MET USED AT IMPLEMENTED CLASSES CAN BE FOUND AT THE FOLLOWING LINK:
        https://www.ucdenver.edu/docs/librariesprovider65/clinical-services/sports-medicine/
        estimating-energy-expenditure.pdf?sfvrsn=eb335bb9_2#:~:text=Use%20the%20following%20formula
        %20to%20calculate%20how%20many,simply%20divide%20your%20weight%20in%20pounds%20by%202.2.%29*/
}
