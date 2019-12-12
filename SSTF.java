//edits by KatKoder
import java.util.*; //added so Arrays.sort() can work
public class SSTF{


static private int findIndex(int[] array, int number) {	
		int i;
		
		if(array[0] >= number)
			return 0;
		
		for(i = 1; i < array.length - 2; i++) {
			if(array[i+1] >= number)
				return i;
		}
		return i;
	}

private static int clipper(int number, int threshold) {
		if(number > threshold)
			number = 0;
		if(number < 0)
			number = threshold;

		return number;
	}


static void algorithmSSTF(int[] requests, int initialHeadPosition) { //added "algorithm" to name SSTF so would not appear as constructor
		int size = requests.length - 1;
		int seekTime = 0;
		int left = 0,right = 0,index = 0;
		boolean[] visited = new boolean[requests.length];
		Arrays.sort(requests);
		
		// Get the i from initialHeadPosition
		index = findIndex(requests, initialHeadPosition);

		
		System.out.printf("%d-> ", initialHeadPosition);
		
		while(size >= 0) {
			
			// Find non visited number on the left
			for(int i = clipper(index-1, requests.length -1); i >= 0; i--) {
				if(!visited[i]) {
					left = i;
					break;
				}
			}
			
			// Find non visited number on the right
			for(int i = clipper(index+1, requests.length-1); i < requests.length; i++) {
				if(!visited[i]) {
					right = i;
					break;
				}
			}
			
			
			int a = Math.abs(requests[left] - initialHeadPosition);
			int b = Math.abs(requests[right] - initialHeadPosition);
			
			
			if(a < b)
				index = left;
			else
				index = right;
			
			seekTime += Math.abs(initialHeadPosition - requests[index]);
			
			if(size > 0)
				System.out.printf("%d-> ", requests[index]);
			else
				System.out.printf("%d\n", requests[index]);
			
			visited[index] = true;
			initialHeadPosition = requests[index];
			size--;
		}
		System.out.printf("Seek Time: %d\n", seekTime);
	}
	
	public static void main(String [] args) { //added main method and body to execute above code
		
		Random rand = new Random(); //recycled from Jonathan's FCFS code
		int arrayOfRequests [] = new int [1000];
		
		for(int i = 0; i < arrayOfRequests.length; i++){
			  arrayOfRequests[i] = rand.nextInt(5000);
		}
		algorithmSSTF(arrayOfRequests, rand.nextInt(5000));
}
