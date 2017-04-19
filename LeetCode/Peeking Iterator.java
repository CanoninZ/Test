// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
//my simple solution, without considering that the null could be an element of iterator.
class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    next = (iterator.hasNext())? iterator.next():null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tmp = next;
	    next = (iter.hasNext())? iter.next():null;
	    return tmp;
	}

	@Override
	public boolean hasNext() {
	    return (next != null);
	}
}



//I used the exactly same solution. But I do feel using null to check if we have reached the end of iterator is not 100% right.
//In theory, null could be a valid element.
//An slightly alternative approach to use boolean indicating end of iterator
// class PeekingIterator implements Iterator<Integer> {
// private Integer next;
// private Iterator<Integer> itr;
// private boolean done = false;

// public PeekingIterator(Iterator<Integer> iterator) {
//     itr = iterator;
//     if (iterator.hasNext())
//         next = itr.next();
//     else
//         done = true;
// }

// // Returns the next element in the iteration without advancing the iterator.
// public Integer peek() {
//     return next;
// }

// // hasNext() and next() should behave the same as in the Iterator interface.
// // Override them if needed.
// @Override
// public Integer next() {
//     Integer result = next;
//     if (itr.hasNext()) {
//         next = itr.next();
//     } else {
//         next = null;
//         done = true;
//     }
//     return result;
// }

// @Override
// public boolean hasNext() {
//     return !done;
// }

// }