package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class project {

	    public static void main(String[] args) {
	        String filePath = "C:\\Users\\s554047\\eclipse-workspace\\BigDataProject\\online_paymet.txt"; 

	        List<Double> list = new ArrayList<>(); 

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split("\\s+"); 

	                for (String part : parts) {
	                    try {
	                        double number = Double.parseDouble(part);
	                        list.add(number); // Add integers to the list
	                    } catch (NumberFormatException ignored) {
	                        // Handle parsing exception if needed
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	       
	        long startTime = System.currentTimeMillis();

	        double[] list1 = list.stream().filter(e -> e > 0).sorted().limit(5).mapToDouble(i -> i).toArray();
	        System.out.println(Arrays.toString(list1));
	        long endTime = System.currentTimeMillis();
	        System.out.println("Sequential execution time is " + (endTime - startTime) + " milliseconds");

	        startTime = System.currentTimeMillis();
	        double[] list2 = list.parallelStream().filter(e -> e > 0).sorted().limit(5).mapToDouble(i -> i).toArray();
	        System.out.println(Arrays.toString(list2));
	        endTime = System.currentTimeMillis();
	        System.out.println("Parallel execution time is " + (endTime - startTime) + " milliseconds");
	    }

}
