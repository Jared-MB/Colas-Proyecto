public class Utils {
	/**
	 * Generate a random number between min and max
	 * @param min - minimum number
	 * @param max - maximum number
	 * @return int - a random number between min and max
	 */
	public static int generateRandomNumberWithIntervals(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	/**
	 * Generate a new client with a probability
	 * @param id - client id
	 * @param probability - probability of creating a new client
	 * @return Client - new client
	 *
	 */
	public static Client generateClientWithProbability(int id, float probability){
		float random = (float) Math.random();
		if (random <= probability){
			return new Client(
				id, 
				generateRandomNumberWithIntervals(0, 10), 
				generateRandomNumberWithIntervals(1, 10)
			);
		}
		return null;
	}
}
