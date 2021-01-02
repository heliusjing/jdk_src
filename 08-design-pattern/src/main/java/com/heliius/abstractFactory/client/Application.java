package com.heliius.abstractFactory.client;

import com.heliius.abstractFactory.buttons.Button;
import com.heliius.abstractFactory.checkboxes.Checkbox;
import com.heliius.abstractFactory.factories.GUIFactory;

/**
 * @Author jcf
 * @Create 2020-10-29-12:51 上午
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
