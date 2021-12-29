class Cat extends Animal {

    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
    
    Cat(int runLimit) {                                 // перегрузка конструктора
        super(runLimit, 0);
    }

    @Override
    public String swim(int distance) {                  //переопределение метода суперкласса
        return getClassName() + " can't swim";
    }

}