package com.heliius.abstractFactory.factories;

import com.heliius.abstractFactory.buttons.Button;
import com.heliius.abstractFactory.checkboxes.Checkbox;

/**
 * @Author jcf
 * @Create 2020-10-29-12:47 上午
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
