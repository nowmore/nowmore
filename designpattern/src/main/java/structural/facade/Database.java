package structural.facade;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Database {
    private Database() {
    }

    public static Properties getProperties() throws Exception{
        Properties properties = new Properties();

        List<String> list = Arrays.asList("x@abc.com=X abc",
                "y@abc.com=Y xyz",
                "z@abc.com=Z 123",
                "null@abc.com=A data");

        InputStream inputStream = new ByteArrayInputStream(((String)list.stream().collect(Collectors.joining("\n"))).getBytes());
        properties.load(inputStream);
        return properties;
    }
}
