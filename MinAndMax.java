import java.util.*;

public class MinAndMax {
	 
	    int min;
	    int max;

	    MinAndMax(int min, int max) {
	        this.min = min;
	        this.max = max;
	    }
	

	public static MinAndMax FindMinMax(int a[], int lb, int ub) {
	    // Base case: If there's only one element
	    if (lb == ub) {
	        return new MinAndMax(a[lb], a[lb]);
	    }

	    // Base case: If there are two elements
	    if (ub - lb == 1) {
	        return a[lb] < a[ub] ? new MinAndMax(a[lb], a[ub]) : new MinAndMax(a[ub], a[lb]);
	    }

	    // Divide the array into two halves and find min/max in each half
	    int mid = (lb + ub) / 2;
	    MinAndMax leftPair = FindMinMax(a, lb, mid);
	    MinAndMax rightPair = FindMinMax(a, mid + 1, ub);

	    // Compare min/max from left and right halves
	    int minVal = Math.min(leftPair.min, rightPair.min);
	    int maxVal = Math.max(leftPair.max, rightPair.max);

	    return new MinAndMax(minVal, maxVal);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of elements");
		int n=sc.nextInt();
		System.out.println("Enter the elements:");
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
	    
	    MinAndMax result = FindMinMax(a, 0, n - 1);
	    System.out.println("The minimum and maximum pair");
	    System.out.println("(" + result.min + ", " + result.max + ")");
	}


	

}
