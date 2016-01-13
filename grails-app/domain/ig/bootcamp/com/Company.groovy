package ig.bootcamp.com

class Company {

    String name
    static hasMany = [employees:Employee]

    String toString() {
        name
    }
}