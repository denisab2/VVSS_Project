package exceptions;

public class InvalidNameException extends Exception {
	private static final long serialVersionUID = -69637829093235855L;

	public InvalidNameException(String s) {
		super(s);
	}

	public void validate(String name) throws InvalidNameException{
		if (name.length() == 0)
			throw new InvalidNameException("Name can not be empty.");
		if(name.matches("[a-zA-Z]+") == false)
			throw new InvalidNameException("Name must contain only letters.");
	}
	
}
