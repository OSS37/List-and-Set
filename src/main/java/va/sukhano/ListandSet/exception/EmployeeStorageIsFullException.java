package va.sukhano.ListandSet.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException (String s) {
        super(s);
    }
}
