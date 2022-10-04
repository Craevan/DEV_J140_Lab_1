package ru.avalon.j140;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties extends Properties {
    private static ApplicationProperties app;

    private ApplicationProperties() {
    }

    public static ApplicationProperties getInstance() {
        if (app == null) {
            app = new ApplicationProperties();
            File file = new File("src/main/resources/Application.properties");
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                app.load(new FileInputStream(file));
            } catch (Exception ex) {
                Logger.getLogger(ApplicationProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return app;
    }
}
