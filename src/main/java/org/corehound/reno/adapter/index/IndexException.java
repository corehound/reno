package org.corehound.reno.adapter.index;

public class IndexException extends Exception {

	private static final long serialVersionUID = 9200927052402734410L;

	public IndexException() {
		super();
	}

	public IndexException(String message) {
		super(message);
	}

	public IndexException(String message, Throwable cause) {
		super(message, cause);
	}

	public IndexException(Throwable cause) {
		super(cause);
	}

}
