import java.util.Scanner;

public class _1834_�������͸��̰����� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long res = 0;

		for(int i = 1 ; i < N ; i++) {
			res += i * N + i;
		}
		System.out.println(res);
	}

}
