package OOPs;

class ReadOnly{
    private int age;

    private String name;

    ReadOnly(){
        this.age = 23;
        this.name = "Shashwat";
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }
}

class WriteOnly{
    private int age;

    private String name;

    WriteOnly(){
        this.age = 23;
        this.name = "Shashwat";
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}

class ReadWrite{
    private int age;

    private String name;

    ReadWrite() {
        this.age = 1;
        this.name = "Shashwat";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}


public class OOPs_Lecture_6 {
    public static void main(String[] args) {
        ReadWrite rw = new ReadWrite();
        rw.setName("Pranav");
        System.out.println(rw.getName());
        System.out.println(rw.getAge());

        ReadOnly ro = new ReadOnly();
        System.out.println(ro.getName());

        WriteOnly wo = new WriteOnly();
        wo.setAge(36);

    }
}
