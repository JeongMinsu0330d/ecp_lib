package lib_dijkstra;

public class lib_dijk {
	
	

}

class Graph{
	private int n;			//노드들의 수 
	private int maps[][];	//노드들간의 가중치 저장할 변수
	
	public Graph( int n) {
		this.n = n;
		maps = new int[n +1][n+1];
	}
	
	public void input(int i,int j , int w) {
		maps[i][j] = w;
		maps[j][i] = w;
		
	}	
	
	public void dijkstra(int v) {
		int distance[] = new int [n+1];			//최단 거리를 저장할 변수
		boolean[] check = new boolean[n+1];		//해당 노드를 방문했는지 체크할 변수
			
		for(int i =1 ; i <n+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		//시작 값 초기화
		distance[v] = 0;
		check[v] = true;
		
		//연결 노드 distance 갱신
		
		for(int i=1;i<n+1;i++) {
			if(!check[i] && maps[v][i] !=0) {
				distance[i] = maps[v][i];
			}
		}
		
		for(int a = 0; a<n-1; a++) {
			
			
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			
				//최솟값 찾기 
			for(int i=1;i<n+1;i++) {
				if(!check[i] && distance[i] != Integer.MAX_VALUE) {
					if(distance[i]<min) {
						min = distance[i];
						min_index = i;
					}
					
				}
				}
			check[min_index] = true;
			for(int i=1;i<n+1;i++) {
				if(!check[i] && maps[min_index][i] !=0) {
					if(distance[i] > distance[min_index] + maps[min_index][i]) {
						distance[i] = distance[min_index] + maps[min_index][i];
					}
				}
			}
		}
				
		for(int i=1;i<n+1;i++) {
			
			System.out.println(distance[i]+ " ");
			
		}
			System.out.println("");
			
			
		
	}
		
		
	
	
	
}//class_graph












/*다익스트라 구조 
 * 
 * 1. distance는 처음에 나올 수 있는 가장 큰 값으로 초기화 해준다.
 * 2. 시작노드의 거리를 0 으로 표시합니다.(자기자신까지 거리는 0이므로)
 * -시작노드의 check값을 true로 변경 ( 방문 유무 분류)
 * 3. 시작노드와 연결되어 있는 노드들의 distance값을 갱신합니다.
 * 4. 반문하지 않은 노드중 distance값이 최소인 노드 min_node를 찾습니다.
 * 5. min_node의 check값을 true로 변셔합니다.
 */