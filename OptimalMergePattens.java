import java.util.PriorityQueue;

import java.util.*;



public class OptimalMergePattens {



    public static int mergeCost(int[] files) {

        int cost = 0;



        // Create a min-heap (PriorityQueue) to store the sizes of files

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();



        // Add all the file sizes to the min-heap

        for (int file : files) {

            minHeap.add(file);

        }



        // Perform the merging until there is only one file left

        while (minHeap.size() > 1) {

            // Extract the two smallest files from the min-heap

            int file1 = minHeap.poll();

            int file2 = minHeap.poll();



            // Calculate the cost of merging these two files

            int mergeCost = file1 + file2;



            // Add the mergeCost to the total cost

            cost += mergeCost;



            // Add the merged file size back to the min-heap

            minHeap.add(mergeCost);

        }



        return cost;

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        // Get the number of files

        System.out.print("Enter the number of files: ");

        int n = scanner.nextInt();



        // Create an array to store the sizes of files

        int[] files = new int[n];



        // Get the file sizes input

        System.out.println("Enter the sizes of files:");

        for (int i = 0; i < n; i++) {

            files[i] = scanner.nextInt();

        }



        // Calculate the optimal merge cost

        int cost = mergeCost(files);



        // Print the result

        System.out.println("Optimal Merge Cost: " + cost);



        // Close the scanner

        scanner.close();

    }

}









