package transitioning;

import states.IStateAction;

class DummyAction implements IStateAction {
	int dummyActionTime;
	
	public DummyAction(int dummyActionTime) {
		this.dummyActionTime = dummyActionTime;
	}

	@Override
	public void execute() {
		try {
			Thread.sleep(dummyActionTime);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}

}
