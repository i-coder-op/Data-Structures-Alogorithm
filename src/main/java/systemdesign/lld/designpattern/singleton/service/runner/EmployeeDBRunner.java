package systemdesign.lld.designpattern.singleton.service.runner;

import systemdesign.lld.designpattern.singleton.Logger;
import systemdesign.lld.designpattern.singleton.model.Employee;
import systemdesign.lld.designpattern.singleton.service.IEmployeeService;
import systemdesign.lld.designpattern.singleton.service.impl.EmployeeServiceImpl;

public class EmployeeDBRunner {

    public static final Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        logger.log(new EmployeeDBRunner(), "Starting Employee DB Runner Application with instance id: " + logger);

        IEmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.saveEmployeeInDB(new Employee("1", "Shivam Kale", "Burhanpur"));
        employeeService.saveEmployeeInDB(new Employee("2", "Siya Kale", "Pune"));
        employeeService.saveEmployeeInDB(new Employee("3", "Surbhi Kale", "Bangalore"));

        employeeService.fetchEmployee("1");
        employeeService.fetchEmployee("2");
        employeeService.fetchEmployee("3");

        logger.log(new EmployeeDBRunner(), "Stopping Employee DB Runner Application with instance id: " + logger);
    }
}
