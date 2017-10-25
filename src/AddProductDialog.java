import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by y50-70 on 24.10.2017.
 */
public class AddProductDialog {
    Controller controller;

    public AddProductDialog(Controller controller) {
        this.controller = controller;
        JDialog dialog = new JDialog();
        dialog.setVisible(true);
        dialog.setSize(300, 300);
        JPanel panel = new JPanel(new FlowLayout());
        dialog.add(panel);

        JLabel labelName = new JLabel("Название");
        JTextField name = new JTextField(20);
        JLabel labelIngredients = new JLabel("Ингридиент");
        JTextField ingredient = new JTextField(20);
        JLabel labelRecipe = new JLabel("Рецепт:код");
        JTextField recipe = new JTextField(20);
        JLabel labelGroup = new JLabel("Группа:код");
        JTextField group = new JTextField(20);

        JButton button = new JButton("Добавить");
        button.addActionListener(e -> {
            String nameString = name.getText();
            String ingredientString = ingredient.getText();
            String recipeString = recipe.getText();
            String groupString = group.getText();

            controller.addProduct(nameString, ingredientString, recipeString, groupString);
        });
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
