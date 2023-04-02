package va.sukhano.ListandSet;


import com.fasterxml.jackson.databind.InjectableValues;
import org.springframework.stereotype.Service;
import va.sukhano.ListandSet.exception.EmployeeAlreadyAddedException;
import va.sukhano.ListandSet.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeBook = new ArrayList<>();
    //Employee[] employeeBook = new Employee[10];


    public Employee add(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (Employee employee : employeeBook) {
            if (employee.equals(person)) {
                throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже есть в списке");
            }
            employeeBook.add(person);
        }
        return person;
    }

    public Employee find(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (Employee employee : employeeBook) {
            if (employee.equals(person)) {
                return person;
            }
        }
        throw new EmployeeNotFoundException ("Сотрудник не найден.");
    }


    public Employee delete(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (int i = 0; i < employeeBook.size(); i++) {
            if (employeeBook.get(i).equals(person)) {
                employeeBook.remove(i);
                return person;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    public List<Employee> showAll() {
        return employeeBook;
    }


}
