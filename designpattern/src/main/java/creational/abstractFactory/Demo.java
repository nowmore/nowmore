package creational.abstractFactory;

public class Demo {

    public static void exec(Factory factory) {
        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

        Link yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com");
        Link yahoo_jp = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp");

        Link excite = factory.createLink("Excite", "http://www.excite.com");
        Link google = factory.createLink("Google", "http://www.google.com");

        Tray news = factory.createTray("日报");
        news.add(people);
        news.add(gmw);

        Tray yahoos = factory.createTray("Yahoo!");
        yahoos.add(yahoo);
        yahoos.add(yahoo_jp);

        Tray search = factory.createTray("搜索引擎");
        search.add(yahoos);
        search.add(excite);
        search.add(google);

        Page page = factory.createPage("LinkPage", "nowmore");
        page.add(news);
        page.add(search);
        page.output();
    }

    public static void main(String[] args) {

        Factory factory = Factory.getInstance("creational.abstractFactory.ListFactory");
        exec(factory);

        factory = Factory.getInstance("creational.abstractFactory.TableFactory");
        exec(factory);
    }
}
