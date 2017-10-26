package View.UpdateDialogs;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class UpdateProviderDialog {
    Controller controller;

    public UpdateProviderDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 400);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelSearchCode = new JLabel("Поиск: Код поставщика");
        JTextField searchCode = new JTextField(20);
        JLabel labelCode = new JLabel("Код поставщика");
        JTextField code = new JTextField(20);
        JLabel labelName = new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelAddress = new JLabel("Адрес поставщика");
        JTextField address = new JTextField(20);
        JLabel labelTelephone = new JLabel("Телефон");
        JTextField telephone = new JTextField(20);

        JButton button = new JButton("Обновить");
        button.addActionListener(e -> {
            String searchCodeString = searchCode.getText();
            String codeString = code.getText();
            String nameString = name.getText();
            String addressString = address.getText();
            String telephoneString = telephone.getText();

            controller.updateProvider(searchCodeString, codeString, nameString, addressString, telephoneString);
        });

        panel.add(labelSearchCode);
        panel.add(searchCode);
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
