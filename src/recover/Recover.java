package recover;

import globals.GlobalInfo;

public abstract class Recover implements Runnable{
	
	protected String transaction;
	
	public static Recover decide(String transaction){
		
		if(GlobalInfo.getInstance().geCommitedTransactions().contains(transaction))
			return new Redo(transaction);
		return new Undo(transaction);
	}
}
