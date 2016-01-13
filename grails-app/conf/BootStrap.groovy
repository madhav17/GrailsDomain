import ig.bootcamp.com.Car
import ig.bootcamp.com.Company
import ig.bootcamp.com.Employee
import ig.bootcamp.com.Engine
import ig.bootcamp.com.Project
import ig.bootcamp.com.Task

class BootStrap {

    def init = { servletContext ->
//        oneToOne()
//        oneToManyNoOwner()
//        oneToManyOwner()
        manyToMany()
//        oneToManyOwner1()
//        trainsientEx()
    }

    void getter() {
        Company company = createCompany()
        println "########################################################"
        println "getter ${company.getName()} property ${company.name}"
        println "########################################################"
    }

    void companyToString() {
        println "########################################################"
        println "toString of company ${createCompany()}"
        println "########################################################"
    }

    void transientExample() {
        println "########################################################"
        println new Employee(firstName: "Ankur", lastName: "Tripathi").fullName
        println "########################################################"
    }

    void timestampExample() {
        Employee employee = new Employee(firstName: "Ankur", lastName: "Tripathi")
        println "########################################################"
        println "Timestamps before save Datecreated: ${employee.dateCreated} -- lastUpdated: ${employee.lastUpdated}"
        println "########################################################"
        employee.save()
        println "Timestamps after save Datecreated: ${employee.dateCreated} -- lastUpdated: ${employee.lastUpdated}"
        println "########################################################"
    }

    void validation() {
        Company company = createCompany()
        Employee employee = new Employee(firstName: "Ankur", lastName: "Tripathi", company: company, email: 'ankur+1@intelligrape.com', salary: 2000000F)
        println "Validate employee ${employee.save()}"
        println "########################################################"
        employee.errors.allErrors.each {
            println it
        }
        println "########################################################"

        //For more validation examples go through the classes and documentation
    }

    void oneToOne() {
        println "########################################################"
        Car car = new Car(name: "Maruti")
        println car.save(flush: true, failOnError: true)
        Engine engine = new Engine(car: car)
        println engine.save(flush: true, failOnError: true)

        println "########################################################"
//        println "Engine of Car -: ${car.engine}"
        println "Car of Engine -: ${engine.car}"
        println "########################################################"

        println "Version"

        println car.name
        println car.version

        car.name = "Honda"

        car.save(flush: true)

        println car.name
        println car.version
        println "Version"

    }

    void oneToManyNoOwner() {
        println "########################################################"
        println "Project count before save  ${Project.count()}"
        Project project = new Project(name: "Project")
        project.save(flush: true)
        project.refresh()
        Task task = new Task(name: "Test")
        task.save(flush: true)

        println "Task count before save  ${Task.count()}"
        println "Project tasks before adding task -: ${project.tasks}"
        project.addToTasks(task)
        project.save(flush: true)
        println "Project tasks after save -: ${project.tasks}"
        println "####################   ####################################"
        project.delete(flush: true)
        println "Project count after delete -: ${Project.count()}"
        println "Task count after project delete  -: ${Task.count()}"
        println "########################################################"

    }

    void oneToManyOwner() {
        println "########################################################"
        println "Project count before save  ${Project.count()}"
        Project project = new Project(name: "Project")
        Task task = new Task(name: "Test")

        println "Task count before save  ${Task.count()}"
        println "Project tasks before adding task -: ${project.tasks}"
        project.addToTasks(task)
        project.save(flush: true, failOnError: true)
        println "Project tasks after save -: ${project.tasks}"
        println "########################################################"
        project.delete(flush: true)
        println "Project count after delete -: ${Project.count()}"
        println "Task count after project delete  -: ${Task.count()}"
        println "########################################################"

    }

    void oneToManyOwner1() {
        println "########################################"
        println "Company Count Before Save = ${Company.count}"
        println "Employee Count Before Save = ${Employee.count}"
        Company company = createCompany()
        Employee emp1 = createEmployee(company)
        company.addToEmployees(emp1)
        company.save(flush: true)

        println "Company Count After Save = ${Company.count}"
        println "Employee Count After Save = ${Employee.count}"
        println "Compnay of Employee = ${emp1.company}"
        println "Compnay of Employee = ${company.employees}"

        company.delete(flush: true)

        println "Company Count After delete = ${Company.count}"
        println "Employee Count After delete = ${Employee.count}"

        println "########################################"
    }

    void manyToMany() {
        println "########################################################"
        Employee employee = new Employee(firstName: "Ankur", lastName: "Tripathi")
        println employee.validate()
        Project project = new Project(name: "Project 1")
        println project.save(flush: true,failOnError: true)
        println "Before adding project to employee ${employee.projects}"
        println "Before adding project to employee ${project.employees}"
        employee.addToProjects(project)
        employee.save(flush: true, failOnError: true)
        println "After adding project to employee ${employee.projects}"
        println "After adding project to employee ${project.employees}"

//        println project.delete(flush: true)
        println employee.delete(flush: true)


        println "########################################################"
    }

    Company createCompany() {
        return new Company(name: "Intelligrape").save(flush: true, failOnError: true)
    }

    void trainsientEx() {
        println "####################################EX######################"
        Employee employee = new Employee(firstName: "Madhav", lastName: "Khanna")
        employee.save(flush: true)
        employee.save(flush: true, failOnError: true)
        println employee.name
        println employee.validate()
        println employee.errors
        println "####################################EX######################"
    }

    Employee createEmployee(Company company) {
        new Employee(firstName: "Madhav", lastName: "Khanna", company: company).save(flush: true)
    }


    def destroy = {
    }
}
