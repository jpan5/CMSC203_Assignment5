/* This program is to find lowest and highest sales, calculate the total sale, and
 * holiday bonus based on how much the store sold in each category.
 * Date: 11/12/2020
 * Programmer: Jie Pan
 */

import java.util.*;
import java.io.*;
import java.lang.*;

class TwoDimRaggedArrayUtility{

	 //Get the total
     public static double getTotal(double[][] data){
          double total = 0.0;

          for (int i = 0; i < data.length; i++){
              for (int j = 0; j < data[i].length; j++){
                   total += data[i][j];
              }
          }
          return total;
     }

     //Get the average
     public static double getAverage(double[][] data){
    	  double total = 0.0;
          int numOfElements = 0;

          for (int i = 0; i < data.length; i++){
              for (int j = 0; j < data[i].length; j++) {
            		  total += data[i][j];
            		  numOfElements += 1;
              }
          }
          //Return the average
          return new Double(total / numOfElements);

     }

     
     //Get the row total
     public static double getRowTotal(double[][] data, int row){
    	  double total = 0;
          for (int j = 0; j <data[row].length; j++){
              total += data[row][j];
          }
          return total;
     }

     //Get the column total
     public static double getColumnTotal(double[][] data, int col){
          double total = 0;
          
          for (int i = 0; i < data.length; i++){
              if (col <= data[i].length - 1) {
               total += data[i][col];
              }
          }
          return total;
     }

     //Get the highest value in row
     public static double getHighestInRow(double[][] data, int row){
    	  double highest = data[row][0];
    	  
          for (int j = 0; j < data[row].length; j++){
              if (data[row][j] > highest) {
                   highest = data[row][j];
              }
          }
          return highest;
     }

     //Get the highest index in row
     public static int getHighestInRowIndex(double[][] data, int row){
    	  int index = 0;

          for (int i = 0; i < data[row].length; ++i){
              if (data[row][i] > data[row][index]){
                   index = i;
              }
          }
          return index;
     }

     //Get the lowest value in row
     public static double getLowestInRow(double[][] data, int row){
    	  double lowest = data[row][0];

          for (int j = 0; j < data[row].length; j++){
              if (data[row][j] < lowest) {
                   lowest = data[row][j];
              }
          }
          return lowest;
     }

     //Get the lowest index in row
     public static int getLowestInRowIndex(double[][] data, int row){
    	  int index = 0;
    	  
          for (int i = 0; i < data[row].length; ++i){
              if (data[row][i] < data[row][index]){
                   index = i;
              }
          }
          return index;
     }

     //Get the highest value in column
     public static double getHighestInColumn(double[][] data, int col){
    	  double highest = data[0][col];

          for (int i = 0; i < data.length; i++){
              if (col <= data[i].length - 1){
                   if (data[i][col] > highest) {
                        highest = data[i][col];
                   }
              }
          }
          return highest;
     }

     //Get the highest index in column
     public static int getHighestInColumnIndex(double[][] data, int col){
          int highest = 0;

          for (int i = 0; i < data.length; i++){
              if (data[i].length > col){
                   if (data[i][col] > data[highest][col]) {
                        highest = i;
                   }
              }
          }
          return highest;
     }

     //Get the lowest value in column
     public static double getLowestInColumn(double[][] data, int col){
          double lowest = data[0][col];
          
          for (int i = 0; i < data.length; i++){
              if (col <= data[i].length - 1) {
                   if (data[i][col] < lowest) {
                        lowest = data[i][col];
                   }
              }
          }
          return lowest;
     }

     //Get the lowest index in column
     public static int getLowestInColumnIndex(double[][] data, int col){
          int highest = 0;

          for (int i = 0; i < data.length; i++) {
              if (data[i].length > col){
                   if (data[i][col] < data[highest][col]) {
                        highest = i;
                   }
              }
          }
          return highest;
     }

     //Get the highest value in array
     public static double getHighestInArray(double[][] data) {
          double highest = data[0][0];
          
          for (int i = 0; i < data.length; i++) {
              for (int j = 0; j < data[i].length; j++){

                   if (data[i][j] > highest) {
                        highest = data[i][j];
                   }
              }
          }
          return highest;
     }

     //Get the lowest value in array
     public static double getLowestInArray(double[][] data){
          double lowest = data[0][0];

          for (int i = 0; i < data.length; i++){
              for (int j = 0; j < data[i].length; j++){
                   if (data[i][j] < lowest) {
                        lowest = data[i][j];
                   }
              }
          }
          return lowest;

     }
     
     //Read a file
 	public static double[][] readFile(File file) {
 		double[][] data = new double[6][];
 		String strings;
 		
 		 try {
 			 //Open a file
 			 BufferedReader input = new BufferedReader(new FileReader(file));
 			 int i = 0;
             
 			 while ((strings = input.readLine()) != null){
                   String[] temp = strings.split(" ");
                   int size = temp.length;
                   data[i] = new double[size];
                   
                   for (int j = 0; j < size; j++){
                 	  data[i][j] = Double.parseDouble(temp[j]);
                   }
                   i++;

              }
              input.close();
           
           //Throw an exception
          }catch (Exception e){
              e.printStackTrace();
          }
 		return data;
 	}

      //Write a file
 	public static void writeToFile(double[][] data, File outputFile) {
         try{
             BufferedWriter input = new BufferedWriter(new FileWriter(outputFile));
             for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++){
             	   input.write(data[i][j] + " ");
                }
                    input.newLine();
             }
             input.close();
         }catch (Exception e){
             e.printStackTrace();
         }
 	}

}
