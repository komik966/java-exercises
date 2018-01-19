package edu.agh.ics.lab6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropTest {

    public static String CONFIG = "sample.properties";

    // property jest final => nie można jej reinstancjonować (referencja do obiektu jest niezmienna, ale sam obiekt może się zmieniać)
    private final Map<String, String> map = new HashMap<String, String>();

    public void loadConfig() throws IOException {
        Properties prop = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG)) {
            if (inputStream != null) {
                prop.load(inputStream);
                for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                    map.put("" + entry.getKey(), "" + entry.getValue());
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            } else {
                throw new FileNotFoundException("property file " + CONFIG + " not found");
            }
        }
    }

    public String getHostname() {
        return map.get("hostname");
    }

    public static void main(String[] args) {
        PropTest p = new PropTest();
        try {
            p.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(p.getHostname());
    }
}
