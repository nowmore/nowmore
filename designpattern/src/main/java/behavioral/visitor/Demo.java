package behavioral.visitor;

public class Demo {
    public static void main(String[] args) throws Exception {
        exec();
    }

    private static void exec() throws Exception {
        System.out.println("Making root entries...");

        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        bin.add(new File("vi", 1000))
                .add(new File("latex", 2000));

        root.add(bin)
                .add(tmp)
                .add(usr)
                .accept(new ListVisitor());

        System.out.println("Making usr entries...");
        Directory x = new Directory("a");
        Directory y = new Directory("b");
        Directory z = new Directory("c");

        x.add(new File("x.html", 100))
                .add(new File("test.java", 200));
        y.add(new File("y.txt", 40));
        z.add(new File("z.doc", 500))
                .add(new File("z.jpg", 10));

        usr.add(x).add(y).add(z);
        root.accept(new ListVisitor());
    }

}
