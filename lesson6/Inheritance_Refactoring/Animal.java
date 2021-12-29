abstract class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    protected static int countOfAnimals;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();         //reflection API 
        countOfAnimals++;
    }
    
    public String getClassName() {
        return className;
    }
    public static int getCountOfAnimals() {
        return countOfAnimals;
    }
    
    @Override
    public String run(int distance) {                   //переопределение метода интерфейса
        if (distance > runLimit) {
            return className + " couldn't run " + distance + " m";
        } else {
            return className + " successfully run " + distance + " m";
        }
    }
    
    @Override
    public String swim(int distance) {                   //переопределение метода интерфейса
        if (distance > swimLimit) {
            return className + " couldn't swim " + distance + " m";
        } else {
            return className + " successfully swim " + distance + " m";
        }
    }

    @Override
    public String toString() {                            //переопределение метода класса Object
        return className + " can run " + runLimit + " m and can swim " + swimLimit + " m";
    }

}