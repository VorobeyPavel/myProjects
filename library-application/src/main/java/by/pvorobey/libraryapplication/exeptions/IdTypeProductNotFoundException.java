package by.pvorobey.libraryapplication.exeptions;


public class IdTypeProductNotFoundException extends RuntimeException{

    public IdTypeProductNotFoundException(String message) {
        super(message);
    }
}
