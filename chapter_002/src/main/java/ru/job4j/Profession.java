package ru.job4j;

public class Profession {
    String name;
    boolean diploma;
    boolean ill;
    int age;
    String specialization;

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

}



class Doctor extends Profession {
    String hospital;
    public void heal(Profession prof) {
        prof.ill = false;
        System.out.print(this.getName() + " лечит " + prof.getName());
    }
}

class Teacher extends Profession {
    String school;
    public void teach(Profession prof) {
        prof.diploma = true;
        System.out.print(this.getName() + " учит " + prof.getName());
    }
}

class Engineer extends Profession {
    String company;
    public Project design (Data data){
        Project project = (Project) data;
        project.cost = 1000;
        return project;
    }
}

class Data {
    String info;
}

class Project extends Data{
    int cost;
}