package systemdesign.lld.designpattern.singleton.service.impl;

import systemdesign.lld.designpattern.singleton.Logger;
import systemdesign.lld.designpattern.singleton.model.Employee;
import systemdesign.lld.designpattern.singleton.service.IEmployeeService;

import java.util.HashMap;

public class EmployeeServiceImpl implements IEmployeeService {
    private static HashMap<String, Employee> employeeRepo = new HashMap<>();

    public static final Logger logger = Logger.getLogger();

    @Override
    public void saveEmployeeInDB(Employee employee) {
       employeeRepo.put(employee.getId(), employee);
       System.out.println("Logger Object: " + logger);
       logger.log(new EmployeeServiceImpl(), "Employee saved in database");
    }

    @Override
    public Employee fetchEmployee(String id) {
        System.out.println("Logger Object: " + logger);
        logger.log(new EmployeeServiceImpl(), "Fetching employee with id: " + id);
        return employeeRepo.get(id);
    }
}
