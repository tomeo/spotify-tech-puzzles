import java.util.Scanner;

public class ReversedBinary {
	public static void main(String[] args) {
		System.out.println(Integer.parseInt(new
		StringBuffer(Integer.toBinaryString(Integer.parseInt(new
		Scanner(System.in).nextLine()))).reverse().toString(), 2));
	}
}
