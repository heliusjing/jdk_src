package com.heliius.abstractFactory.factories;

import com.heliius.abstractFactory.buttons.Button;
import com.heliius.abstractFactory.buttons.MacOSButton;
import com.heliius.abstractFactory.checkboxes.Checkbox;
import com.heliius.abstractFactory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}