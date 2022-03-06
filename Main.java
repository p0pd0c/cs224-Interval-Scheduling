/**
 * Runner for the RequestSet class
 * Schedule several intervals and return the optimal set of intervals
 * @author jareddiscipio
 *
 */
public class Main {
	public static void main(String[] args) {
		RequestSet requestSet = new RequestSet();
		// Call Setup to populate the request set with the intervals from the assignment specifications
		requestSet.setup();
		System.out.println(requestSet.schedule());
	}
}
