package exceptions;

/**
 * Created by Deni on 03/04/2018.
 */
public class InvalidIdException extends Exception {
    private static final long serialVersionUID = -69637829093235855L;

    public InvalidIdException(String s) {
        super(s);
    }

    public void validate(int id) throws InvalidIdException{
        if (id < 0)
            throw new InvalidIdException("Id must be positive.");


    }

}
