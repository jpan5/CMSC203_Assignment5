/* This program is to find lowest and highest sales, calculate the total sale, and
 * holiday bonus based on how much the store sold in each category.
 * Date: 11/12/2020
 * Programmer: Jie Pan
 */

public class HolidayBonus {

	//Calculate holiday bonus
	public static double[] calculateHolidayBonus(double[][] data, double high,
            double low, double other){

        double[][] holidayBonus = new double[data.length][];

        for (int i = 0; i < data.length; i++){
        	holidayBonus[i] = new double[data[i].length];
        }

        for (int i = 0, j = 0; i < holidayBonus.length; i++, j++){
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);

            if (i < holidayBonus[j].length){
                 holidayBonus[highIndex][i] = high;
                 holidayBonus[lowIndex][i] = low;
                 if (j == highIndex || j == lowIndex)
                      continue;
                 else{
                      holidayBonus[j][i] = other;
                 }
            }
        }

        double[] bonusPerStore = new double[data.length];
        for (int i = 0; i < holidayBonus.length; i++){
            for (int j = 0; j < holidayBonus[i].length; j++){
                 bonusPerStore[i] = holidayBonus[i][j];
            }
        }
        return bonusPerStore;
   }
	
	//Calculate total bonus
    public static double calculateTotalHolidayBonus(double[][] data,
            double high, double low, double other){
    	double[][] holidayBonus = new double[data.length][];
    	
        for (int i = 0; i < data.length; i++){
            holidayBonus[i] = new double[data[i].length];
        }
        for (int i = 0, j = 0; i < holidayBonus.length; i++, j++){
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);

            if (i < holidayBonus[j].length){
                 holidayBonus[highIndex][i] = high;
                 holidayBonus[lowIndex][i] = low;
                 if (j == highIndex || j == lowIndex)
                      continue;
                 else{
                      holidayBonus[j][i] = other;
                 }
            }
        }

        double holidayTotal = 0.0;
        
        for (int i = 0; i < holidayBonus.length; i++){
            for (int j = 0; j < holidayBonus[i].length; j++){
                 holidayTotal += holidayBonus[i][j];
            }
        }
        return holidayTotal;
   }
}