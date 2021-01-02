package com.heliius.abstractFactory.factories;

import com.heliius.abstractFactory.buttons.Button;
import com.heliius.abstractFactory.buttons.WindowsButton;
import com.heliius.abstractFactory.checkboxes.Checkbox;
import com.heliius.abstractFactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}