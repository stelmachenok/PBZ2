package View;

import View.AddDialogs.AddProductDialog;
import View.AddDialogs.AddProviderDialog;
import View.AddDialogs.AddRecipeDialog;
import Controller.Controller;
import View.DeleteDialogs.DeleteProductDialog;
import View.DeleteDialogs.DeleteProviderDialog;
import View.DeleteDialogs.DeleteRecipeDialog;
import View.UpdateDialogs.UpdateProductDialog;
import View.UpdateDialogs.UpdateProviderDialog;
import View.UpdateDialogs.UpdateRecipeDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by y50-70 on 17.10.2017.
 */
public class MainFrame {
    private JFrame frame;
    private JPanel panel;
    private JTabbedPane tabbedPane;
    private Controller controller;
    private JTextField date = new JTextField(20);
    private JTextField provider = new JTextField(20);

    public JTextField getDate() {
        return date;
    }

    public JTextField getProvider() {
        return provider;
    }

    private MainFrame() {
        createFrame();
        createController();
        createTabbedPane();
    }

    private void createController() {
        controller = new Controller(this);
    }

    private void createFrame() {
        frame = new JFrame("Предприятие");
        panel = new JPanel(new BorderLayout());
        frame.add(panel);
        frame.setSize(1920, 1030);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();

        JPanel tabPanel;
        JPanel buttonPanel;
        JScrollPane scrollPane;
        JTable table;
        JButton buttonAdd;
        JButton buttonDelete;
        JButton buttonUpdate;
        String columnNames[];
        String columnData[][];

        columnNames = new String[]{"Название", "Список ингридиентов", "Рецепт:код", "Группа:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(e -> {
            new AddProductDialog(controller);
        });
        buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(e -> {
            new DeleteProductDialog(controller);
        });
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
            new UpdateProductDialog(controller);
        });
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonUpdate);
        buttonPanel.add(buttonDelete);
        tabPanel.add(buttonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Продукты", tabPanel);





        columnNames = new String[]{"Код", "Название", "Описание рецепта:код", "Автор:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(e -> {
            new AddRecipeDialog(controller);
        });
        buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(e -> {
            new DeleteRecipeDialog(controller);
        });
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
            new UpdateRecipeDialog(controller);
        });
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonUpdate);
        buttonPanel.add(buttonDelete);
        tabPanel.add(buttonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Рецепт", tabPanel);





        columnNames = new String[]{"Код", "Название", "Адрес", "Телефон"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(e -> {
            new AddProviderDialog(controller);
        });
        buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(e -> {
            new DeleteProviderDialog(controller);
        });
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
            new UpdateProviderDialog(controller);
        });
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonUpdate);
        buttonPanel.add(buttonDelete);
        tabPanel.add(buttonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Поставщик", tabPanel);




        columnNames = new String[]{"Название", "Список ингридиентов", "Рецепт:код", "Группа:код"};
        columnData = new String[][]{{"a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Малокалорийные блюда", tabPanel);




        columnNames = new String[]{"Дата","Код поставщика","Название поставщика","Адрес поставщика","Телефон","Цена"};
        columnData = new String[][]{{"a", "a", "a", "a", "a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        buttonPanel = new JPanel(new FlowLayout());
        buttonUpdate = new JButton("Обновить");
        buttonUpdate.addActionListener(e -> {
            controller.updatePriceList();
        });
        buttonPanel.add(date);
        buttonPanel.add(provider);
        buttonPanel.add(buttonUpdate);
        tabPanel.add(buttonPanel, BorderLayout.SOUTH);
        tabbedPane.addTab("Прайс-лист", tabPanel);


        columnNames = new String[]{"Название блюда", "Название рецепта"};
        columnData = new String[][]{{"a", "a"}};
        table = new JTable(columnData, columnNames);
        scrollPane = new JScrollPane(table);
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Блюдо-рецепт", tabPanel);

        tabbedPane.addChangeListener(e -> {
            String tabName = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
            switch (tabName) {
                case "Продукты": {
                    controller.showAllProducts();
                    break;
                }
                case "Поставщик": {
                    controller.showAllProviders();
                    break;
                }
                case "Рецепт": {
                    controller.showAllRecipe();
                    break;
                }
                case "Малокалорийные блюда": {
                    controller.showAllMinimalcalories();
                    break;
                }
                case "Блюдо-рецепт": {
                    controller.showAllProductsWithRecipe();
                    break;
                }
//                case "Прайс-лист": {
//                    controller.showPriceList();
//                    break;
//                }
            }
        });
        panel.add(tabbedPane, BorderLayout.CENTER);
        controller.showAllProducts();
        panel.updateUI();
    }

    public JTable getTable() {
        JPanel panel = (JPanel) tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
        Component components[] = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) components[i];
                Component scrollPaneComponents[] = scrollPane.getComponents();
                for (int j = 0; j < scrollPaneComponents.length; j++) {
                    if (scrollPaneComponents[i] instanceof JViewport) {
                        Component viewPortComponents[] = ((JViewport) scrollPaneComponents[i]).getComponents();
                        for (int k = 0; k < viewPortComponents.length; k++) {
                            if (viewPortComponents[i] instanceof JTable)
                                return (JTable) viewPortComponents[0];
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
