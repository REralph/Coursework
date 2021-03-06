import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    static String returnName;
    String Ralph ="Ralph";
    public GUI() {

        ArrayList<String> listOfTeams = new ArrayList<>();
        ArrayList<TaskKotlin> listOfTasks = new ArrayList<>();
        AllTeams allTeams = new AllTeams();
        // Main JFrame
        JFrame frame = new JFrame("Coursework");

        // Main JPanel
        JPanel panel1 = new JPanel(new MigLayout());

        JPanel taskPanel = new JPanel(new MigLayout());
        taskPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Add tasks")));

        JPanel teamPanel = new JPanel(new MigLayout());
        teamPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Add teams")));


        // Task JLabels
        JLabel taskName = new JLabel("Task name");
        JLabel taskTeam = new JLabel("Team");
        JLabel taskPredecessor = new JLabel("Predecessor");
        JLabel taskDuration = new JLabel("Duration in hours");

        // Task TextFields
        JTextField taskNameField = new JTextField();
        taskNameField.setPreferredSize(new Dimension(200, 24));
        JTextField taskTeamField = new JTextField();
        taskTeamField.setPreferredSize(new Dimension(200, 24));

        Object[] items;
        JComboBox teamLists = new JComboBox();

        JTextField taskPredecessorField = new JTextField();
        taskPredecessorField.setPreferredSize(new Dimension(200, 24));
        JTextField taskDurationField = new JTextField();
        taskDurationField.setPreferredSize(new Dimension(200, 24));


        // Team JLabels
        JLabel teamName = new JLabel("Team name");
        JLabel teamDepartment = new JLabel("Department");

        // Team TextFields
        JTextField teamNameField = new JTextField();
        teamNameField.setPreferredSize(new Dimension(200, 24));
        JTextField teamDepartmentField = new JTextField();
        teamDepartmentField.setPreferredSize(new Dimension(200, 24));


        // JTable
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();


        table.setBounds(70, 70, 1000, 1000);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(true);

        model.addColumn("Task name");
        model.addColumn("Team");
        model.addColumn("Task Predecessor");
        model.addColumn("Duration in hours");


        // Task Buttons
        JButton addTask = new JButton("Add task");
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeamKotlin teamKotlin = new TeamKotlin(teamNameField.getText());
                TaskKotlin taskKotlin = new TaskKotlin(taskNameField.getText(), teamKotlin, taskPredecessorField.getText(), taskDurationField.getText());
                AllTasks allTasks = new AllTasks();
                listOfTasks.add(taskKotlin);
                allTasks.setCurrentActiveTasks(listOfTasks);
                System.out.println(allTasks.getCurrentActiveTasks());


                for (int i = 0; i < allTasks.getCurrentActiveTasks().size(); i++) {
                    System.out.println(allTasks.getCurrentActiveTasks().get(i).component1());


                    model.addRow(new Object[]{

                            allTasks.getCurrentActiveTasks().get(i).component1()
                            //taskNameField.getText(),
                            /*
                            teamNameField.getText(),
                            taskPredecessorField.getText(),
                            taskDurationField.getText()
                             */
                    });

                }
                taskNameField.setText("");
                taskTeamField.setText("");
                taskPredecessorField.setText("");
                taskDurationField.setText("");


                teamNameField.setText("");
                teamDepartmentField.setText("");

            }
        });

        // Team Button
        JButton addTeamButton = new JButton("Add team");
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teamLists.addItem(teamNameField.getText());
                listOfTeams.add(teamNameField.getText());
                allTeams.setCurrentActiveTeams(listOfTeams);

                returnName = taskNameField.getText();

            }
        });


        // Adding Task components to panel
        teamPanel.add(teamName, "span");
        teamPanel.add(teamNameField, "span");
        teamPanel.add(teamDepartment, "span");
        teamPanel.add(teamDepartmentField, "span");
        teamPanel.add(addTeamButton, "span");

        panel1.add(new JScrollPane(table));


        taskPanel.add(taskName, "span");
        taskPanel.add(taskNameField, "span");
        taskPanel.add(taskTeam, "span");
        taskPanel.add(teamLists, "span");
        taskPanel.add(taskPredecessor, "span");
        taskPanel.add(taskPredecessorField, "span");
        taskPanel.add(taskDuration, "span");
        taskPanel.add(taskDurationField, "span");
        taskPanel.add(addTask, "span");


        // Adding components to Main Panel
        panel1.add(teamPanel);
        panel1.add(taskPanel);


        // Setting up JPanel
        frame.add(panel1);

        // Setting up frame size, closing behaviour and visibility
        frame.setSize(new Dimension(1920, 1080));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
            }
        });
    }
}

