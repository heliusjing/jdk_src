package com.heliius.factoryMethod.factory;

import com.heliius.factoryMethod.buttons.Button;
import com.heliius.factoryMethod.buttons.HtmlButton;

/**
 * @Author jcf
 * @Create 2020-10-29-12:08 上午
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
