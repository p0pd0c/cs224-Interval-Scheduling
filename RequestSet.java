import java.util.ArrayList;
import java.util.Collections;

/**
 * Collection of Intervals with functionality to obtain the optimal schedule 
 * @author jdiscipi
 * @author dbrown20 (thought about the greedy scheduling algorithm together)
 * @author jpage9 (discussed refactor to the sort function, went with Collections.sort instead of a hand-coded bubble sort)
 *
 */
public class RequestSet {
	/**
	 * Internal storage for Intervals
	 */
	public ArrayList<Interval> requests;
	
	/**
	 * Control printing of detailed execution statements
	 */
	public static final boolean DEBUG = false;
	
	/**
	 * Test RequestSet (initialize, fill, and schedule)
	 * This is for testing purposes only, please consume RequestSet from Main
	 */
	public static void main(String[] args) {
		System.out.println("Running Main From RequestSet");
		
		// Create the request set collection
		RequestSet rqst = new RequestSet();
		
		// Fill the set with test request intervals (predetermined by assignment specifications)
		rqst.setup();
		
		// Report the optimum schedule
		System.out.println(rqst.schedule());

	}
	
	/**
	 * Initialize the request set
	 */
	public RequestSet() {
		// Initialize requests set
		requests = new ArrayList<Interval>();
	}
	
	/**
	 * Use a greedy algorithm to pick the optimal set of intervals
	 * By sorting the request list in order of ascending 
	 * @return Optimal set of intervals to schedule
	 */
	public ArrayList<Interval> schedule() {
		// Sort intervals by finishTime
		// Algorithm for sorting is abstracted from the algorithm for optimal schedule 
		sort();
		
		// Make a copy of requests
		ArrayList<Interval> requestSet = new ArrayList<Interval>(requests);
		
		/*
		 *  Pick the intervals in order by finishTime starting with the first interval in the sorted list
		 *  Then mark all intervals that conflict with the select interval
		 *
		 */
		if(DEBUG) System.out.println("Scheduling Intervals...");
		// Keep track of the optimal set
		ArrayList<Interval> optimalSet = new ArrayList<Interval>();
		
		// While the set of requests is non-empty
		while(requestSet.size() != 0) {
			// Get the minimum interval from the set of sorted requestSet
			Interval minInterval = requestSet.get(0);
			optimalSet.add(minInterval);
			requestSet.remove(0);
			// Remove all conflicting intervals from requestSet
			for(int index = 0; index < requestSet.size(); ++index) {
				if(minInterval.conflictsWith(requestSet.get(index))) {
					requestSet.remove(index);
				}
			}
		}
		
		return optimalSet;
	}
	
	/**
	 * Sort intervals by finishTime in increasing order
	 *
	 * In-place sort
	 * Implemented using Java's built in Collections sort function
	 * 
	 * Suppress the generic type mismatch, because Interval implements compareTo
	 * 
	 * @return The list of requests sorted
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Interval> sort() {
		// This could be swapped out with another sorting method like mergesort/quicksort/bogosort 
		if(DEBUG) System.out.println("Sorting the requests...");
		Collections.sort(requests);
		return requests;
	}
	
	/**
	 * Create test intervals from the assignment to evaluate the correctness of the algorithm
	 */
	public void setup() {
		if(DEBUG) System.out.println("Creating test intervals...");
		Interval i1 = new Interval(0, 15);
		Interval i2 = new Interval(18, 21);
		Interval i3 = new Interval(0, 2);
		Interval i4 = new Interval(4, 8);
		Interval i5 = new Interval(10, 14);
		Interval i6 = new Interval(17, 22);
		Interval i7 = new Interval(0, 5);
		Interval i8 = new Interval(7, 9);
		Interval i9 = new Interval(11, 16);
		
		if(DEBUG) System.out.println("Adding test intervals to requests...");
		requests.add(i1);
		requests.add(i2);
		requests.add(i3);
		requests.add(i4);
		requests.add(i5);
		requests.add(i6);
		requests.add(i7);
		requests.add(i8);
		requests.add(i9);
	}
	
	/**
	 * Add an interval to the request set
	 * @param i Interval to add to the request set
	 */
	public void add(Interval i) {
		requests.add(i);
	}
	
	/**
	 * Remove an interval from the request set by index
	 * @param index
	 */
	public void remove(int index) {
		if(index >= 0 && index < requests.size()) requests.remove(index);
	}
	
	/**
	 * Removes the first occurrence of i from request set
	 * @param i Interval to remove from the request set
	 */
	public void removeInterval(Interval i) {
		for(int index = 0; index < requests.size(); ++index) {
			if(requests.get(index).startTime == i.startTime && requests.get(index).finishTime == i.finishTime) {
				requests.remove(index);
			}
		}
	}
	
}
