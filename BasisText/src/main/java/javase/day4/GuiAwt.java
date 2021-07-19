package javase.day4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 15:57
 */
public class GuiAwt {
    public static void main(String[] args) {
        Frame frame = new Frame();

        TextField textField = new TextField("我是文本框");
        textField.setBounds(100,100,200,100);

        Button button1 = new Button("我是no.1按钮");
        button1.setBounds(100,300,100,100);
        button1.addActionListener(new ButtonEvent(textField));

        Button button2 = new Button("我是no.2按钮");
        button2.setBounds(300,300,100,100);
        button2.addActionListener(new ButtonEvent(textField));

//        FlowLayout flowLayout = new FlowLayout(FlowLayout.TRAILING);
//        flowLayout.setHgap(200);

        frame.setLayout(null);
        frame.setLocation(400,300);
        frame.setSize(400,400);
        frame.addWindowListener(new windowEvent());
        frame.add(button1);
        frame.add(button2);
        frame.add(textField);
        frame.setVisible(true);
    }
}
class ButtonEvent implements ActionListener{
    TextField textField;

    public ButtonEvent(TextField textField) {
        this.textField = textField;
    }

    public ButtonEvent() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button button = (Button)e.getSource();
        String string = button.getLabel();
        textField.setText(string);
    }
}

class windowEvent implements WindowListener{
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}