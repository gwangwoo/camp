import java.io.*;
import java.util.*;

public class _1766_������ {
	static int in[];
	static int N,M;
	static ArrayList<Integer> adj[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		in = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v);
			in[v]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =1 ; i <= N ; i++) {
			if(in[i] == 0) pq.add(i);
		}

		while(!pq.isEmpty()) {
			int now = pq.poll();
			System.out.println(now);
			for(int y : adj[now]) {
				in[y]--;
				if(in[y] == 0) pq.add(y);
			}
		}

	}

}
