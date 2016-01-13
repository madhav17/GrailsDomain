package ig.bootcamp.com

class Engine {

    static belongsTo = [car: Car]

    static constraints = {
//        car(unique: true)
    }
}
