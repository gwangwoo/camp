import java.math.*;
import java.util.*;
import java.io.*;

public class _2824_최대공약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger A = BigInteger.valueOf(1);
		BigInteger B = BigInteger.valueOf(1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			A = A.multiply(new BigInteger(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			B = B.multiply(new BigInteger(st.nextToken()));
		}
		String ret = A.gcd(B).toString();
		
		if(ret.length() > 9) {
			System.out.println(ret.substring(ret.length()-9, ret.length()));
		}else {
			System.out.println(ret);
		}
		
	}
}