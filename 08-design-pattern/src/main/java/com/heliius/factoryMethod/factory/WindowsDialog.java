package com.heliius.factoryMethod.factory;

import com.heliius.factoryMethod.buttons.Button;
import com.heliius.factoryMethod.buttons.WindowsButton;

/**
 * @Author jcf
 * @Create 2020-10-29-12:09 上午
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
