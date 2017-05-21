package recover;

public final class Redo extends Recover {

	public Redo(String transaction){
		this.transaction = transaction;
	}
	
	public void run() {
		
		System.out.println("Starting Redo on " + transaction);
		
		
	}
}
