package s22678.View.Doctor.Show;

import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

import static s22678.View.Main.MainView.*;

public class ShowDoctorFrame extends JFrame {
    public ShowDoctorFrame(Person doctor) {
        setTitle("Show Details for: dr " + doctor.getFirstName() + " " + doctor.getLastName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        JPanel textPanel = new JPanel(new GridLayout(1, 4));

        GridLayout masterGridLayout = new GridLayout(7 ,1);
        masterGridLayout.setVgap(40);

        // First column label description
        JPanel firstDescriptionLabelColumn = new JPanel(masterGridLayout);

        // Second column label description
        JPanel secondDescriptionLabelColumn = new JPanel(masterGridLayout);

        // First column label data
        JPanel firstDataLabelColumn = new JPanel(masterGridLayout);

        // Second column label data
        JPanel secondDataLabelColumn = new JPanel(masterGridLayout);

        // add firstName label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("Name:", SwingConstants.CENTER));

        // add firstName label data to JPanel
        firstDataLabelColumn.add(new CustomJTextField(doctor.getFirstName(), false));

        // add lastName label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Last Name:", SwingConstants.CENTER));

        // add lastName label data to JPanel
        secondDataLabelColumn.add(new CustomJTextField(doctor.getLastName(), false));

        // add pesel label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("PESEL:", SwingConstants.CENTER));

        // add pesel label data to JPanel
        firstDataLabelColumn.add(new CustomJTextField(doctor.getPESEL(), false));

        // add specialization label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Specialization:", SwingConstants.CENTER));

        // add specialization label data to JPanel
        secondDataLabelColumn.add(new CustomJTextField(doctor.getDoctorSpecialization(), false));

        // add salary label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("Salary:", SwingConstants.CENTER));

        // add salary label data to JPanel
        CustomJTextField salaryTextField = new CustomJTextField(String.valueOf(doctor.getDoctorSalary()));
        firstDataLabelColumn.add(salaryTextField);

        // add fields label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Fields:", SwingConstants.CENTER));

        // fields label data
        EnumSet<DoctorField> doctorFields = doctor.getDoctorFields();
        String tmp = "";
        for (DoctorField field : doctorFields) {
            tmp = tmp + " " + field.toString();
        }
        // add fields label data to JPanel
        secondDataLabelColumn.add(new CustomJTextField(tmp, false));

        if (doctorFields.contains(DoctorField.SURGEON)) {
            // add successful operations label description to JPanel
            firstDescriptionLabelColumn.add(new CustomJLabel("Successful operations:", SwingConstants.CENTER));

            // add successful operations label data to JPanel
            firstDataLabelColumn.add(new CustomJTextField(String.join(", ", doctor.getDoctorSuccessfulOperations()), false));
            secondDescriptionLabelColumn.add(new JPanel());
            secondDataLabelColumn.add(new JPanel());
        }

        firstDescriptionLabelColumn.add(new JSeparator());
        firstDataLabelColumn.add(new JSeparator());
        secondDescriptionLabelColumn.add(new JSeparator());
        secondDataLabelColumn.add(new JSeparator());

        textPanel.add(firstDescriptionLabelColumn);
        textPanel.add(firstDataLabelColumn);
        textPanel.add(secondDescriptionLabelColumn);
        textPanel.add(secondDataLabelColumn);

        add(textPanel, BorderLayout.CENTER);
        add(new ShowDoctorChangeSalaryButton(doctor, salaryTextField), BorderLayout.SOUTH);
        setVisible(true);
    }
}
