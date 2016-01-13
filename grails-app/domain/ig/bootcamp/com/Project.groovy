package ig.bootcamp.com

class Project {

    String name

    static constraints = {
    }

//    static hasMany = [tasks: Task]
    static belongsTo = [Employee]
    static hasMany = [employees: Employee]

//    static hasMany = [tasks: Task, employees: Employee]
}
