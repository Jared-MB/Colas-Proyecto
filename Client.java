public class Client {
	private int id;
	private int arriveTime;
	private int serviceTime;
	private int waitTime;
	private int currentServiceTime;

	/**
	 * Constructor
	 * @param id - client id
	 * @param arriveTime - client arrive time
	 * @param serviceTime - client service time
	 * 
	 */
	Client(int id, int arriveTime, int serviceTime) {
		this.arriveTime = arriveTime;
		this.serviceTime = serviceTime;
		this.waitTime = 0;
		this.currentServiceTime = 0;
		this.id = id;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public int getId() {
		return id;
	}

	public int getCurrentServiceTime() {
		return currentServiceTime;
	}

	/**
	 * Set the wait time of the client
	 * @param waitTime - wait time of the client of type int
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * Increment the current service time of the client by 1
	 */
	public void incrementCurrentServiceTime() {
		this.currentServiceTime++;
	}

	/**
	 * Decrement the current service time of the client by 1
	 */
	public void decrementServiceTime() {
		if (this.serviceTime > 0) {
			this.serviceTime--;
			// System.out.println("Client " + this.id + " has " + this.serviceTime + " units left");
		}
		else {
			throw new RuntimeException("El cliente " + id +  " ya ha salido de la cola");
		}
	}

}
