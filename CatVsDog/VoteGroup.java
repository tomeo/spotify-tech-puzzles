import java.util.HashSet;

public class VoteGroup {
	private HashSet<String> yes;
	private HashSet<String> no;
	private int size;
	
	public VoteGroup(Vote vote) {
		this.no = new HashSet<String>();
		this.yes = new HashSet<String>();
		this.size = 0;
		this.add(vote);
	}

	public VoteGroup(Vote vote, VoteGroup group) {
		this.no = group.no;
		this.yes = group.yes;
		this.size = group.size;
		this.add(vote);
	}

	public boolean compatible(Vote vote) {
		return !this.no.contains(vote.getYes()) &&
		   	   !this.yes.contains(vote.getNo());
	}

	private void add(Vote vote) {
		this.yes.add(vote.getYes());
		this.no.add(vote.getNo());
		this.size++;
	}

	public int size() {
		return this.size;	
	}
}
