package ig.bootcamp.com


class Task {

    String name

    static belongsTo = [project: Project]

    static constraints = {
    }
}