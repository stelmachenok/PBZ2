package View.DeleteDialogs;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class DeleteProviderDialog {
    Controller controller;

    public DeleteProviderDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 150);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelSearchCode = new JLabel("Удалить: Код поставщика");
        JTextField searchCode = new JTextField(20);

        JButton button = new JButton("Удалить");
        button.addActionListener(e -> {
            String deleteCodeString = searchCode.getText();

            controller.deleteProvider(deleteCodeString);
        });

        panel.add(labelSearchCode);
        panel.add(searchCode);
        panel.add(button);
    }
}
