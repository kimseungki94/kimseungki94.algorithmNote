package serializable;

public class TestWriteRead{

    public static void main (String args[]) {

        Human human = new Human();

        human.setName("Obama");
        human.setAge(20);

        HumanUtils.write(human);
        System.out.println("=======Writing Object========");
        System.out.println(human);

        Human readingHuman=HumanUtils.read();
        System.out.println("=======Reading Object========");
        System.out.println(readingHuman);
    }

}

