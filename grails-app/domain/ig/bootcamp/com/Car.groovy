package ig.bootcamp.com

class Car {

    String name
    Engine engine

    static constraints = {
        engine(nullable: true,blank:true)
        name(nullable: true,blank:true)
//
    }
}
