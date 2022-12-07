package error;

public class DireccionNoValida extends RuntimeException {

	public DireccionNoValida() {
		super();
	}

	public DireccionNoValida(String message) {
		super(message);
	}

	public DireccionNoValida(Throwable cause) {
		super(cause);
	}

	public DireccionNoValida(String message, Throwable cause) {
		super(message, cause);
	}

	public DireccionNoValida(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
