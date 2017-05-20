package recover;


public final class Undo extends Recover{

	public Undo(String transaction){
		this.transaction = transaction;
	}
	
	public void run() {

		System.out.println("Make Undo on " + transaction);
	}
}
