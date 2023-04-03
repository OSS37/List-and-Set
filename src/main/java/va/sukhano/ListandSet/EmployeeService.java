package va.sukhano.ListandSet;


import com.fasterxml.jackson.databind.InjectableValues;
import org.springframework.stereotype.Service;
import va.sukhano.ListandSet.exception.EmployeeAlreadyAddedException;
import va.sukhano.ListandSet.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeBook = new ArrayList<>();

    public Employee add(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        if (employeeBook.contains(person)) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже есть в списке");
        }
        employeeBook.add(person);
        return person;
    }

    public Employee find(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        if (employeeBook.contains(person)) {
            return person;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    public Employee delete(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        if (employeeBook.contains(person)) {
            employeeBook.remove(person);
            return person;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


    public List<Employee> showAll() {
        return Collections.unmodifiableList(employeeBook); // Если мы будем возвращать ссылку на оригинальный объект,
                                                           //внутри которого хранится список сотрудников, это даст возможность
                                                           //другому разработчику использовать этот объект не так, как задумано
                                                           // для этого надо запретить доступ, т.е. создать копию листа
    }


}
