static void SSTF(int[] requests, int initialHeadPosition) {
		int size = requests.length - 1;
		int seekTime = 0;
		int left = 0,right = 0,index = 0;
		boolean[] visited = new boolean[requests.length];
		Arrays.sort(requests);
		
		// Get the i from initialHeadPosition
		for(int i = 0; i < size; i++) {
			if(i == 0 && requests[i] > initialHeadPosition) {
				index = 0;
				break;
			}
			
			if(requests[i] == initialHeadPosition) {
				index = i;
				visited[index] = true;
				break;
			}
			
			if(requests[i+1] > initialHeadPosition) {
				index = i;
				break;
			} 
		}
		
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

