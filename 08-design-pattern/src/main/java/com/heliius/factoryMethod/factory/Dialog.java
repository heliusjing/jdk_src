package com.heliius.factoryMethod.factory;

import com.heliius.factoryMethod.buttons.Button;

/**
 * @Author jcf
 * @Create 2020-10-29-12:07 上午
 */
public abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();

    }
    public abstract Button createButton();
}
