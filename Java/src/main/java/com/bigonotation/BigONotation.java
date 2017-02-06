package com.bigonotation;

// Big O notation

public class BigONotation {
	
	// FIELDS
	private int[] theArray;

	private int sizeOfTheArray;

	private int numOfItemsInTheArray = 0;

	static long startTime;

	static long endTime;
	
	// CONSTRUCTORS
	BigONotation(int size) { // declare a new array of whatever size

		sizeOfTheArray = size;

		theArray = new int[size];

	}

	// METHODS
	public static void main(String[] args) {

		BigONotation testAlgorithmOneThousand = new BigONotation(1000);
		testAlgorithmOneThousand.generateRandomArray();

		startTime = System.currentTimeMillis();
		testAlgorithmOneThousand.quickSort(0, 999);
		endTime = System.currentTimeMillis();

		System.out.println("quickSort Took " + (endTime - startTime));

	}

	// O(1)

	public void addItemToArray(int newItem) {

		theArray[numOfItemsInTheArray++] = newItem;

	}

	// 0(N)

	public void linearSearchForValue(int value) {

		boolean valueInArray = false;
		String indices = "";

		startTime = System.currentTimeMillis();

		for (int i = 0; i < sizeOfTheArray; i++) { // each loop takes N

			if (theArray[i] == value) {
				valueInArray = true;
				indices += i + " ";
			}

		}

		System.out.println("Value Found: " + valueInArray);

		endTime = System.currentTimeMillis();

		System.out.println("Linear Search Took " + (endTime - startTime) + " found " + indices);

	}

	// O(N^2)

	public void bubbleSort() {

		startTime = System.currentTimeMillis();
		// loop through whole size of the array
		for (int i = sizeOfTheArray - 1; i > 1; i--) {
			// loop through the whole size of the array
			for (int j = 0; j < i; j++) { // Nested loops takes n^2
				// if the number in the current index is
				// larger than that of next index
				// swap them
				if (theArray[j] > theArray[j + 1]) {

					swapValues(j, j + 1); // it's going to be slow
					// because you have to keep edging it along until it's
					// in the right position
				}
			}
		}

		endTime = System.currentTimeMillis();

		System.out.println("Bubble Sort Took " + (endTime - startTime));
	}

	// O (log N)

	public void binarySearch(int value) {

		startTime = System.currentTimeMillis();

		int lowIndex = 0; // first item in the array
		int highIndex = sizeOfTheArray - 1; // last item in the array

		int timesThrough = 0; // number of times we have to loop through

		while (lowIndex <= highIndex) { // until we cover the entire array
			// doesn't necessarily mean we've looped through each item

			int middleIndex = (highIndex + lowIndex) / 2; // mid point of the
															// array

			if (theArray[middleIndex] < value) { // assuming array is sorted
				// is the value in the top half?
				lowIndex = middleIndex + 1; // only search the top half
			}

			else if (theArray[middleIndex] > value) { // is the value in the
														// bottom?
				highIndex = middleIndex - 1; // only search the bottom
			} else { // else we found it right in the middle

				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

			timesThrough++; // count how many times the while loop runs

		}

		// This doesn't really show anything because
		// the algorithm is so fast

		endTime = System.currentTimeMillis();

		System.out.println("Binary Search Took " + (endTime - startTime));

		System.out.println("Times Through: " + timesThrough);

	}

	// O (n log n)

	public void quickSort(int left, int right) { // accepts two positions in the
													// array(?)

		if (right - left <= 0) // if there are invalid number of items in the
								// array
			return;

		else {

			int pivot = theArray[right]; // the last value in the array

			int pivotLocation = partitionArray(left, right, pivot); // sort a
																	// partition
																	// at a time
			// recursion
			quickSort(left, pivotLocation - 1); // feed it the unsorted first
												// part
			quickSort(pivotLocation + 1, right); // feed it the unsorted second
													// part

		}

	}

	// HELPER METHODS
	public int partitionArray(int left, int right, int pivot) {

		int leftPointer = left - 1; // start outside the beginning of the array
		int rightPointer = right; // the endpoint

		while (true) { // infinite loop if not broken

			while (theArray[++leftPointer] < pivot) // until we reach an item in
													// the array greater
				// or equal to the value at the pivot (prefix increment)
				;
			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				; // endpoint is greater than zero and value at that index
			// is also greater than the "pivot" value

			if (leftPointer >= rightPointer) {// is the endpoint past
				// the beginning point?
				break; // break out of the loop

			} else {

				swapValues(leftPointer, rightPointer);// swap the two items in
														// the array

			}

		}

		swapValues(leftPointer, right); // swap two items in the array

		return leftPointer; // return the position to which we've progressed
							// after sorting through

	}

	public void generateRandomArray() {

		for (int i = 0; i < sizeOfTheArray; i++) {

			theArray[i] = (int) (Math.random() * 1000) + 10;// fill the array
															// with unsorted
															// numbers, some
															// duplicates(?)

		}

		numOfItemsInTheArray = sizeOfTheArray - 1; // because of index 0

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne]; // store the original value
		theArray[indexOne] = theArray[indexTwo]; // overwrite value @ indexOne
		theArray[indexTwo] = temp; // put it in place of value @ indexTwo

	}

}
