package com.heliius.factoryMethod.buttons;

/**
 * @Author jcf
 * @Create 2020-10-29-12:03 上午
 */
public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
