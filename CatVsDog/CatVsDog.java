import java.util.Scanner;

public class CatVsDog {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int voters = 0;
		int currentTest = 0;
		int nbrTests = Integer.parseInt(sc.nextLine());
		String[] info;

		String line;
		String[] lineInfo; 

		Vote currentVote;
		VoteBooth booth;
		for(int i = 0; i < nbrTests; i++) {
			booth = new VoteBooth();
			currentTest++;
			info = sc.nextLine().split(" "); 
			voters = Integer.parseInt(info[2]);
			for(int j=0; j < voters; j++) {
				line = sc.nextLine();	
				lineInfo = line.split(" ");
				booth.add(new Vote(lineInfo[0], lineInfo[1]));
			}
			System.out.println(booth.getMax());
		}
	}
}
