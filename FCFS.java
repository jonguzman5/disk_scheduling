package disk_scheduling;

import java.util.Random;

public class FCFS {
	public static void main(String[]args){
		System.out.println(FirstComeFirstServe(10));
	}
	public static int FirstComeFirstServe(int head){
		  int totalMovement = 0;
		  Random rand = new Random();
		  int[]arr = new int[1000];

		  for(int i = 0; i < arr.length; i++){
			  arr[i] = rand.nextInt(5000);
		  }
		  for(int i = 0; i < arr.length; i++){
			  totalMovement += Math.abs(arr[i] - head);
			  head = arr[i];
		  }
		  return totalMovement;
	}
}
