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




static void SCAN(int[] requests, int initialHeadPosition, int previousHeadPosition) {
		Arrays.sort(requests);
		int index = findIndex(requests, initialHeadPosition);
		boolean toRight = initialHeadPosition - previousHeadPosition < 0;
		int i, prior = 0, headMovement = 0;

		// If the SCAN is going right
		if(index > 0 && toRight) {
			
			if(requests[index] != initialHeadPosition) {
				System.out.printf("%d->", requests[index]);
				System.out.printf("%d->", initialHeadPosition);
				headMovement += Math.abs(requests[index] - initialHeadPosition);
				prior = initialHeadPosition;
			} else {
				System.out.printf("%d->", requests[index]);
				prior = initialHeadPosition;
			}
			
			for(i = index + 1; i < requests.length; i++) {
				
				// Assuming initialHeadPosition will be a number
				// Between 0 and requests.length which is not 
				// Directly in the requests array
				
				if(i < requests.length-1) {
					System.out.printf("%d->", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				} else {
					System.out.printf("%d\n", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				}
						
			}
			

			for(i = index - 1; i >= 0; i--) {
				if(i > 0) {
					System.out.printf("<-%d", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				} else {
					System.out.printf("<-%d\n", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
				}
			}
			
			
		} else if(index == 0 && toRight) { // Just do FCFS
			
			System.out.printf("%d->", initialHeadPosition);
			for(i = 1; i < requests.length; i++) {
				if(i < requests.length -1) {
					System.out.printf("%d->", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				} else {
					System.out.printf("%d\n", requests[i]);
				}
			}
			
		} else {	// If moving to the left
			
			if(requests[index] != initialHeadPosition) {
				System.out.printf("%d", requests[index]);
				System.out.printf("<-%d", initialHeadPosition);
				headMovement += Math.abs(requests[index] - initialHeadPosition);
				prior = requests[index];
			} else {
				System.out.printf("%d", requests[index]);
				prior = initialHeadPosition;
			}
			
			for(i = index - 1; i >= 0; i--) {
				if(i > 0) {
					System.out.printf("<-%d", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				} else {
					System.out.printf("<-%d\n", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				}
			}
			
			for(i = index + 1; i < requests.length; i++) {
				
				// Assuming initialHeadPosition will be a number
				// Between 0 and requests.length which is not 
				// Directly in the requests array
				
				if(i < requests.length-1) {
					System.out.printf("%d->", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
					prior = requests[i];
				} else {
					System.out.printf("%d\n", requests[i]);
					headMovement += Math.abs(requests[i] - prior);
				}
						
			}
		}
		
		System.out.printf("Seek Time: %d", headMovement);
	}
