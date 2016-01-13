package ig.bootcamp.com

class Employee {

    String firstName
    String lastName
//    String password
//    Float salary
//    Date dateCreated
//    Date lastUpdated
//    String name
//    static belongsTo = [Project]
//
    static hasMany = [projects: Project]

//    static transients = ['name']
//
//    String getName() {
//        return firstName + lastName
//    }
    static constraints = {
//        name(minSize: 8)
//        firstName(nullable: true,blank: false)
    }


}
