package transitioning;

import states.IStateAction;

class PrintingAction implements IStateAction {
	int dummyActionTime;
	String stateName;

	PrintingAction(String stateName, int dummyActionTime) {
		this.stateName = stateName;
		this.dummyActionTime = dummyActionTime;
	}

	@Override
	public void execute() {
		long start = System.currentTimeMillis();
		try {
			while ((System.currentTimeMillis() - start) < dummyActionTime) {
				System.out.println("doing something in state: " + this.stateName + ". -- Thread " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Printing Action interrupted in State " + this.stateName);
		}
	}

}
