package com.heliius.abstractFactory.client;

import com.heliius.abstractFactory.factories.GUIFactory;
import com.heliius.abstractFactory.factories.MacOSFactory;
import com.heliius.abstractFactory.factories.WindowsFactory;

/**
 * @Author jcf
 * @Create 2020-10-29-12:50 上午
 */
public class Demo {
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();;
    }
}

