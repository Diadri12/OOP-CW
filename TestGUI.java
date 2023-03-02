package SkinConsultationCenter;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestGUI extends JFrame implements ActionListener {
    //Creating the Doctors Table
    public void TestGUI(){
        String[] columns = {"Name","Contact Number","Specialization","Availability"};
        String[][] data ={
                {"Nicolas Mathew","0779587698","Cosmetic Dermatology","Mondays,Wednesdays and Friday"},
                {"Jaden Wilde","0775967895","Medical Dermatology","Mondays,Tuesdays and Thursday"},
                {"Anne Harris","0756974567","Pediatric Dermatology","Tuesday and Wednesday"},
                {"Josh Simmons","0779458675","Cosmetic Dermatology","Wednesday and Friday"},
                {"Isabel Stevens","0772938459","Pediatric Dermatology","Thursdays and Friday"}
        };
        JTable docTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(data,columns);
        tableModel.setColumnIdentifiers(columns);
        docTable.setModel(tableModel);
        docTable.setBounds(100,100,100,100);
        JScrollPane scrollBar = new JScrollPane(docTable);
        TableRowSorter sorter = new TableRowSorter<>(tableModel);
        docTable.setRowSorter(sorter);
        docTable.setGridColor(Color.BLACK);

        JFrame frame = new JFrame("Skin Consultation Center");
        frame.setBackground(Color.PINK);
        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JLabel introduction = new JLabel();
        introduction.setText("Welcome to Westminster Skin Consultation Center");
        introduction.setFont(new Font("Times New Roman",Font.BOLD,28));
        frame.add(introduction,BorderLayout.NORTH);
        frame.add(scrollBar,BorderLayout.CENTER);
        JButton viewConsult = new JButton("Book Consultation");
        frame.add(viewConsult,BorderLayout.EAST);
        viewConsult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultForm();

            }
        });

    }

    void consultForm(){
        //Creating the Consultation Form
        JFrame consultFrame = new JFrame("Consultations");
        consultFrame.setSize(500,300);
        consultFrame.getContentPane().setLayout(null);
        setResizable(false);

        //Label and Text Field for the Patient ID
        JLabel id = new JLabel("Patient ID");
        id.setFont(new Font("Times New Roman",Font.PLAIN,20));
        id.setSize(100,20);
        id.setLocation(500,100);
        consultFrame.add(id);

        JTextField tID = new JTextField();
        tID.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tID.setSize(200,20);
        tID.setLocation(650,100);
        consultFrame.add(tID);

        //Label and Text Field for the Patient Name
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman",Font.PLAIN,20));
        name.setSize(50,20);
        name.setLocation(500,150);
        consultFrame.add(name);

        JTextField tName = new JTextField();
        tName.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tName.setSize(200,20);
        tName.setLocation(650,150);
        consultFrame.add(tName);

        //Label and Text Field for the Date of Birth
        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setFont(new Font("Times New Roman",Font.PLAIN,20));
        DOB.setSize(200,20);
        DOB.setLocation(500,200);
        consultFrame.add(DOB);

        JTextField tDOB = new JTextField();
        tDOB.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tDOB.setSize(200,20);
        tDOB.setLocation(650,200);
        consultFrame.add(tDOB);

        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        tDOB.setText(sf.format(d));

        //Label and Text Field for the Patient Contact Number
        JLabel mobileNum= new JLabel("Contact Number");
        mobileNum.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mobileNum.setSize(200,20);
        mobileNum.setLocation(500,250);
        consultFrame.add(mobileNum);

        JTextField tContact = new JTextField();
        tContact.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tContact.setSize(200,20);
        tContact.setLocation(650,250);
        consultFrame.add(tContact);

        //Label and Text Field for selecting available doctors
        JLabel consultDoc = new JLabel("Select the day on which you wish to have a consultation");
        consultDoc.setFont(new Font("Times New Roman",Font.PLAIN,20));
        consultDoc.setSize(500,20);
        consultDoc.setLocation(500,300);
        consultFrame.add(consultDoc);

        String [] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        String [] docsOnMonday = {"Nicolas Mathew", "Jaden Wilde"};
        String [] docsOnTuesday = {"Jaden Wilde","Anne Harris"};
        String [] docsOnWednesday = {"Nicolas Mathew","Anne Harris","Josh Simmons"};
        String[] docsOnThursday = {"Jaden Wilde","Isabel Stevens"};
        String [] docsOnFriday = {"Nicolas Mathew","Josh Simmons","Isabel Stevens"};

        JComboBox consultDay = new JComboBox<>(days);
        consultDay.setFont(new Font("Times New Roman",Font.PLAIN,20));
        consultDay.setSize(200,30);
        consultDay.setLocation(650,350);
        consultFrame.add(consultDay);

        DefaultComboBoxModel model = new DefaultComboBoxModel<>(docsOnMonday);
        JComboBox docsAvailability = new JComboBox<>(model);
        docsAvailability.setFont(new Font("Times New Roman",Font.PLAIN,20));
        docsAvailability.setSize(200,30);
        docsAvailability.setLocation(650,400);
        consultFrame.add(docsAvailability);

        consultDay.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED){
                DefaultComboBoxModel comboBoxModel;

                if(consultDay.getSelectedItem().equals("Monday")){
                    comboBoxModel = new DefaultComboBoxModel<>(docsOnMonday);
                    docsAvailability.setModel(comboBoxModel);
                }

                if(consultDay.getSelectedItem().equals("Tuesday")){
                    comboBoxModel = new DefaultComboBoxModel<>(docsOnTuesday);
                    docsAvailability.setModel(comboBoxModel);
                }

                if(consultDay.getSelectedItem().equals("Wednesday")){
                    comboBoxModel = new DefaultComboBoxModel<>(docsOnWednesday);
                    docsAvailability.setModel(comboBoxModel);
                }

                if(consultDay.getSelectedItem().equals("Thursday")){
                    comboBoxModel = new DefaultComboBoxModel<>(docsOnThursday);
                    docsAvailability.setModel(comboBoxModel);
                }

                if(consultDay.getSelectedItem().equals("Friday")){
                    comboBoxModel = new DefaultComboBoxModel<>(docsOnFriday);
                    docsAvailability.setModel(comboBoxModel);
                }
            }
        });


        //Label and Text Field for assigning doctor's name
        JLabel docName = new JLabel("Doctor's Name");
        docName.setFont(new Font("Times New Roman",Font.PLAIN,20));
        docName.setSize(200,20);
        docName.setLocation(500,450);
        consultFrame.add(docName);

        JTextField tDocName = new JTextField();
        tDocName.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tDocName.setSize(200,20);
        tDocName.setLocation(650,450);
        consultFrame.add(tDocName);

        docsAvailability.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    try{
                        String docName = docsAvailability.getSelectedItem().toString();
                        tDocName.setText(docName);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //Label and Text Field for the Consultation Time Period
        JLabel time = new JLabel("Time Period for Consultation");
        time.setFont(new Font("Times New Roman",Font.PLAIN,20));
        time.setSize(200,20);
        time.setLocation(500,500);
        consultFrame.add(time);

        JLabel cost = new JLabel("Consultation Fees");
        cost.setFont(new Font("Times New Roman",Font.PLAIN,20));
        cost.setSize(200,20);
        cost.setLocation(500,600);
        consultFrame.add(cost);

        JTextField timePeriod = new JTextField();
        timePeriod.setFont(new Font("Times New Roman",Font.PLAIN,20));
        timePeriod.setSize(200,20);
        timePeriod.setLocation(650,600);
        consultFrame.add(timePeriod);

        String[] timeAllocatedForConsultation = {"15 minutes","30 Minutes","45 minutes", "1 hour"};
        JComboBox timeDuration = new JComboBox<>(timeAllocatedForConsultation);
        timeDuration.setFont(new Font("Times New Roman",Font.PLAIN,20));
        timeDuration.setSize(200,30);
        timeDuration.setLocation(650,550);
        consultFrame.add(timeDuration);

        timeDuration.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    try{
                        String consultTime = timeDuration.getSelectedItem().toString();
                        timePeriod.setText(consultTime);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //Label and Text Field for Notes
        JLabel note = new JLabel("Notes");
        note.setFont(new Font("Times New Roman",Font.PLAIN,20));
        note.setSize(200,20);
        note.setLocation(500,600);
        consultFrame.add(note);

        JTextArea tNote = new JTextArea();
        tNote.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tNote.setSize(200,20);
        tNote.setLocation(650,600);
        consultFrame.add(tNote);

        //Label and Button to Schedule Consultation
        JButton submit = new JButton("Schedule Consultation");
        submit.setFont(new Font("Times New Roman",Font.PLAIN,20));
        submit.setSize(250,20);
        submit.setLocation(600,700);
        consultFrame.add(submit);
        Object [] row= new Object[4];

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tID.getText().equals("")||tName.getText().equals("")||tDOB.getText().equals("")||tContact.getText().equals("")){
                    JOptionPane.showMessageDialog(submit,"Please enter all the data");
                }else{
                    row[0] = tID.getText();
                    row[1] = tName.getText();
                    row[2] = tDOB.getText();
                    row[3] = tContact.getText();

                    JTable table = new JTable();
                    DefaultTableModel model = new DefaultTableModel();
                    table.setModel(model);
                    model.addRow(row);
                }
                JOptionPane.showMessageDialog(submit,"Data added successfully");
                tID.setText("");
                tName.setText("");
                tDOB.setText("");
                tContact.setText("");

            }
        });

        //Label and Button to go back to previous frame
        JButton goBack = new JButton("Go back");
        goBack.setFont(new Font("Times New Roman",Font.PLAIN,20));
        goBack.setSize(250,20);
        goBack.setLocation(600,750);
        consultFrame.add(goBack);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button = e.getActionCommand();
                if(button.equals("Go back")){
                    consultFrame.dispose();
                }
            }
        });


        consultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestGUI();
    }

    public void addDataIntoConsultForm(){
        JFrame consultForm = new JFrame("Consultation");
        JTable addConsultDetails = new JTable();
        String[] columns = {"Patient ID","Name","Date of Birth","Contact Number","Name of Doctor","Consultation Charges"};
        DefaultTableModel consultTable = new DefaultTableModel();
        consultTable.setColumnIdentifiers(columns);
        addConsultDetails.setModel(consultTable);
        JScrollPane consultTableScroll = new JScrollPane(addConsultDetails);
        consultForm.setLayout(null);
        consultForm.add(consultTableScroll);

        addConsultDetails.setBackground(Color.PINK);
        addConsultDetails.setForeground(Color.WHITE);
        Font font = new Font("Times New Roman",1,22);
        addConsultDetails.setFont(font);
        addConsultDetails.setRowHeight(30);
        Object[] rows = new Object[4];

        consultForm.setSize(500,300);
        consultForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        consultForm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
