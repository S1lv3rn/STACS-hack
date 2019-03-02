public class Pacmain {

    public static void main(String[] args){

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        JPacMan test = new JPacMan();
        test.display();

    }
}
