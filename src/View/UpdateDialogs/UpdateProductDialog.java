package View.UpdateDialogs; /**
 * Created by y50-70 on 25.10.2017.
 */
import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class UpdateProductDialog {
    Controller controller;

    public UpdateProductDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 400);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelSearchName = new JLabel("Поиск: Название");
        JTextField searchName = new JTextField(20);
        JLabel labelName = new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelIngredients = new JLabel("Ингридиент");
        JTextField ingredient = new JTextField(20);
        JLabel labelRecipe = new JLabel("Рецепт:код");
        JTextField recipe = new JTextField(20);
        JLabel labelGroup = new JLabel("Группа:код");
        JTextField group = new JTextField(20);

        JButton button = new JButton("Обновить");
        button.addActionListener(e -> {
            String searchNameString = searchName.getText();
            String nameString = name.getText();
            String ingredientString = ingredient.getText();
            String recipeString = recipe.getText();
            String groupString = group.getText();

            controller.updateProduct(searchNameString, nameString, ingredientString, recipeString, groupString);
        });

        panel.add(labelSearchName);
        panel.add(searchName);
        panel.add(labelName);
        panel.add(name);
        panel.add(labelIngredients);
        panel.add(ingredient);
        panel.add(labelRecipe);
        panel.add(recipe);
        panel.add(labelGroup);
        panel.add(group);
        panel.add(button);
    }
}
