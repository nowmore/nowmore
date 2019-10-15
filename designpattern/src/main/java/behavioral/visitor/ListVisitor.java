package behavioral.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String pwd = "";

    @Override
    void visit(File file) {
        System.out.println(pwd + "/" + file);
    }

    @Override
    void visit(Directory dir) {
        System.out.println(pwd + "/" +dir);
        String tmp = pwd;
        pwd = pwd + "/" +dir.getName();

        Iterator it = dir.iterator();

        while (it.hasNext()) {
            Entry e = (Entry)it.next();
            e.accept(this);
        }
        pwd = tmp;
    }
}
