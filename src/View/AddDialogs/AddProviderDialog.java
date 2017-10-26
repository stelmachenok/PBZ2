package View.AddDialogs;

import javax.swing.*;
import java.awt.*;
import Controller.Controller;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class AddProviderDialog {
    Controller controller;

    public AddProviderDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 300);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelCode = new JLabel("Код поставщика");
        JTextField code = new JTextField(20);
        JLabel labelName = new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelAddress = new JLabel("Адрес поставщика");
        JTextField address = new JTextField(20);
        JLabel labelTelephone = new JLabel("Телефон");
        JTextField telephone = new JTextField(20);

        JButton button = new JButton("Добавить");
        button.addActionListener(e -> {
            String codeString = code.getText();
            String nameString = name.getText();
            String addressString = address.getText();
            String telephoneString = telephone.getText();

            controller.addProvider(codeString, nameString, addressString, telephoneString);
        });
        panel.add(labelCode);
        panel.add(code);
        panel.add(labelName);
        panel.add(name);
        panel.add(labelAddress);
        panel.add(address);
        panel.add(labelTelephone);
        panel.add(telephone);
        panel.add(button);
    }
}
