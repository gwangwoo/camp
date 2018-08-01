import java.util.*;

public class _1735_ºÐ¼öÇÕ {
	static int gcd(int a,int b) {
		if(b > a) return gcd(b,a);
		if(a % b == 0) return b;
		else return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c,d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		int top = a*d + b*c;
		int bottom = b*d;
		System.out.println(top / gcd(bottom,top) + " " + (bottom / gcd(bottom,top)));
	}

}
