public class Pacmain {

    public static void main(){

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        JPacMan test = new JPacMan();
        test.display();

    }
}
