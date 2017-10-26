package View.DeleteDialogs;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by y50-70 on 25.10.2017.
 */
public class DeleteProductDialog {
    Controller controller;

    public DeleteProductDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 150);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelSearchName = new JLabel("Удаление: Название");
        JTextField deleteName = new JTextField(20);


        JButton button = new JButton("Удалить");
        button.addActionListener(e -> {
            String searchNameString = deleteName.getText();
            controller.deleteProduct(searchNameString);
        });

        panel.add(labelSearchName);
        panel.add(deleteName);
        panel.add(button);
    }
}
