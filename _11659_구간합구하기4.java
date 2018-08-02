import java.util.*;
import java.io.*;

public class _11659_구간합구하기4 {
	static final int MAX = 100001;
	static long arr[] = new long[MAX];
	static long seg[] = new long[MAX*4];
	
	static void init(int node, int x,int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x + y) / 2;
		init(node * 2 , x , mid);
		init(node * 2+1, mid+1 , y);
		seg[node] = seg[node*2] + seg[node*2+1];
	}
	
	static long query(int low, int hi, int node, int x,int y) {
		if(hi < x || y < low) return 0;
		if(low <= x && y <= hi) return seg[node];
		
		int mid = (x + y) / 2;
		long l = query(low, hi, node*2 , x , mid);
		long r = query(low , hi, node*2+1 , mid+1 , y);
		return l+r;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1,1,N);
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long sum = query(s,e,1,1,N);
			bw.write(String.valueOf(sum)+"\n");
		}
		bw.flush();
	}

}
