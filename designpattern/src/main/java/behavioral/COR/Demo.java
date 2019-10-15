package behavioral.COR;

public class Demo {
    public static void main(String[] args) {
        Support s1 = new NoSupport("No1");
        Support s2 = new LimitSupport("Limit1", 100);
        Support s3 = new SpecialSupport("Spec1", 233);
        Support s4 = new OddSupport("Odd1");
        Support s5 = new LimitSupport("Limit2", 200);
        Support s6 = new LimitSupport("Limit3", 300);

        s1.setNext(s2).setNext(s3).setNext(s4).setNext(s5).setNext(s6);

        for (int i=0; i<500; i+=33) {
            s1.support(new Trouble(i));
        }

    }
}
