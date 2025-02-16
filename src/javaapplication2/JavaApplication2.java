/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 *
 * @author Chesler John Hamili
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "C:\\Users\\Chesler John  Hamili\\OneDrive\\Documents\\NetBeansProjects\\HAMILI_LAB_2\\src\\main\\java\\doc\\data.csv";
        File file = new File(fileName);
        //List and Array is different list can hold any element at a time while array can't
        ArrayList<double[]> x_list = new ArrayList<>();
        ArrayList<Double> y_list = new ArrayList<>();
        try{
            Scanner inputStream = new Scanner(file); 
            System.out.println("Sleep_Hours");
            while(inputStream.hasNext()){
                // hasNext() and next() is not the same
                String data = inputStream.nextLine();
                //System.out.println(data);               
                //use splitter to separate
                String[] values = data.split(","); 
                System.out.print("test");
                
                int val_0 = Integer.parseInt(values[0]);
                System.out.print("test");
                int val_1 = Integer.parseInt(values[1]);
                int val_2 = Integer.parseInt(values[2]);
                int val_3 = Integer.parseInt(values[3]);
                int val_4 = Integer.parseInt(values[4]);
                double val_5 = Double.parseDouble(values[5]);
                x_list.add(new double[]{1,val_0,val_1,val_2,val_3,val_4});
                y_list.add(val_5);
               
            }
            double[][] x_data = x_list.toArray(new double[0][0]);
                //stackoverflow
            double[] y_data = y_list.stream().mapToDouble(Double::doubleValue).toArray();
        // Sir's code
        
        // Create RealMatrix objects for X and y
        RealMatrix X = MatrixUtils.createRealMatrix(x_data);
        RealVector y = MatrixUtils.createRealVector(y_data);

        // Calculate X^T (transpose of X)
        RealMatrix X_transpose = X.transpose();

        // Calculate (X^T * X) and its inverse
        RealMatrix X_transpose_X = X_transpose.multiply(X);
        RealMatrix X_transpose_X_inv = new LUDecomposition(X_transpose_X).getSolver().getInverse();

        // Convert y to a RealMatrix column vector (n x 1 matrix)
        RealMatrix yMatrix = MatrixUtils.createColumnRealMatrix(y.toArray());

        // Calculate beta (coefficients) using the formula: beta = (X^T * X)^(-1) * X^T * y
        RealMatrix beta = X_transpose_X_inv.multiply(X_transpose).multiply(yMatrix);

        // Extract the coefficients as a RealVector (1D array)
        RealVector betaVector = beta.getColumnVector(0);

        // Display the coefficients (beta values)
        System.out.println("Calculated Beta Coefficients:");
        System.out.println("Beta0 (Intercept): " + betaVector.getEntry(0));
        System.out.println("Beta1 (Study Hours): " + betaVector.getEntry(1));
        System.out.println("Beta2 (Sleep Hours): " + betaVector.getEntry(2));
        System.out.println("Beta4 (Class Attendance (%)): " + betaVector.getEntry(3));
        System.out.println("Beta5 (Assignments Completed (%)): " + betaVector.getEntry(4));
        System.out.println("Beta6 (Extracurricular Hours): " + betaVector.getEntry(5));

        // Allow user to input features for prediction
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the student's study hours: ");
        double study_hours = scanner.nextDouble();

        System.out.print("Enter the student's sleep hours: ");
        double sleep_hours = scanner.nextDouble();

        System.out.print("Enter the student's class attendance: ");
        double class_attendance = scanner.nextDouble();

        System.out.print("Enter the student's assignments completed: ");
        double assignments_completed = scanner.nextDouble();

        System.out.print("Enter the student's extracurricular hours: ");
        double extracurricular_hours = scanner.nextDouble();

        // Create a new feature vector (including the intercept term)
        double[] newTarget = {1, study_hours, sleep_hours, class_attendance, assignments_completed, extracurricular_hours}; // Intercept term + size, bedrooms, location

        // Convert the new house row to a RealVector
        RealVector row = MatrixUtils.createRealVector(newTarget);

        // Calculate the predicted price using the dot product of the feature vector and the beta coefficients
        double predictedFinalExam = row.dotProduct(betaVector);
        
        //answer should be 0-100
        if(predictedFinalExam>100){
            predictedFinalExam = 100;
        }else{
            predictedFinalExam = 0;
        }
        // Output the predicted FinalExam
        System.out.println("\nPredicted Final Exam Score: " + predictedFinalExam);

            
        
        }catch (FileNotFoundException e){
           e.printStackTrace();
        }

    }
}
