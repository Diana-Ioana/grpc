package org.baeldung.grpc;

/*
 * Created by JFormDesigner on Mon Nov 18 22:58:36 EET 2019
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.miginfocom.swing.*;



/**
 * @author unknown
 */
public class secondGUI extends JFrame {
    public secondGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                initComponents();
            }
        });
    }
    private JTable table3;
    private JTable table2;
    private JLabel label1;
    JButton start;
    double time;
    Timer timer;
    JLabel display;
    int resolution = 500;
    static String TIMP = "0";
    static int IDS =0;


    private void initComponents() {

        /***************************************************************************************/
        //setare canal de comunicare
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        //accesare date  din canalul de comunicare prin stub
        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        // transmiterea de request catre client
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setNotification("S-a realizat legatura client-server!")
                .build());
        /**************************************************************************************/

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        table3 = new JTable();
        table2 = new JTable();
        label1 = new JLabel();

        //////////////////////////////////////////////////////////

        display = new JLabel(TIMP);
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (display.getText().equals("Start Medication Time") || time == 0)
                {
                    time = Integer.parseInt(TIMP);
                    display.setText(String.valueOf(time));

                }
                if (start.getText().equals("Start"))
                {
                    timer.start();
                    start.setText("Token");
                }
                else
                {

                    timer.stop();
                    start.setText("Start");
                    if(IDS+1 > 1) {
                        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                                .setNotification("Pacientul si-a luat pastila.Ora: "+display.getText())
                                .build());

                        dtm.removeRow(IDS + 1);
                        if((IDS +1 ) ==2)
                            IDS--;
                        System.out.println("This is ids: " + (IDS + 1));
                        if (IDS + 1 >= 3) {
                            time = Double.parseDouble((String) dtm.getValueAt(IDS, 5));
                            IDS--;
                            System.out.println("Next time would be: " + time);
                            TIMP = String.valueOf(time);

                        }
                    }

                }
            }
        });

        timer = new Timer(resolution, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (time > 0)
                    time -= resolution/1000.0;
                else
                {
                    timer.stop();
                    start.setText("Start");
                }
                display.setText(String.valueOf(time));
                if(time == 0.0){
                    if(IDS+1 > 1) {
                        System.out.println("Nu si-a luat pastila!");
                        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                                .setNotification("Pacientul NU si-a luat pastila.Ora : "+display.getText())
                                .build());
                        dtm.removeRow(IDS + 1);
                        if((IDS +1 ) ==2)
                            IDS--;
                        if (IDS + 1 >= 3) {
                            time = Double.parseDouble((String) dtm.getValueAt(IDS, 5));

                            System.out.println("Next time would be: " + time);
                            TIMP = String.valueOf(time);
                            IDS--;
                        }

                    }
                    timer.stop();
                    start.setText("Start");
                }
            }
        });


        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));


        System.out.println("Response received from server:\n"
                + helloResponse.getName() + "\n"
                + helloResponse.getSurname()  + "\n"
                + helloResponse.getAddress()  + "\n"
                + helloResponse.getBirthDate() + "\n"
                + helloResponse.getGender()  + "\n"
                + helloResponse.getIdMedication() + "\n"
                + helloResponse.getMedicationName() + "\n"
                + helloResponse.getDosage()  + "\n"
                + helloResponse.getSideEffects()  + "\n"
                + helloResponse.getIntakeIntervals() + "\n"
        );

        //---- table3 ----
        table3.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Name", "Surname", "Address", "BirthDate", "Gender"},
                        {helloResponse.getId(),
                                helloResponse.getName(), helloResponse.getSurname(),
                                helloResponse.getAddress(), helloResponse.getBirthDate(), helloResponse.getGender()},
                },
                new String[] {
                        null, null, null, null, null, null
                }
        ));
        {
            TableColumnModel cm = table3.getColumnModel();
            cm.getColumn(6).setResizable(false);
        }
        contentPane.add(table3, "cell 0 1 18 2");




        String header[] = new String[] { "Medication Id", "Name", "Dosage",
                "SideEffects","Intake" };


        dtm.setColumnIdentifiers(header);
        dtm.addRow(new String[]{"Medication Id", "Name", "Dosage","SideEffects","Intoke"});
        table2.setModel(dtm);

        String[] ids = helloResponse.getIdMedication().split("#");
        String[] medNames = helloResponse.getMedicationName().split("#");
        String[] dossages = helloResponse.getDosage().split("#");
        String[] sideEffects = helloResponse.getSideEffects().split("#");
        String[] intokes = helloResponse.getIntokeInterval().split("#");

        label1.setText("Salut!");
        for(int i=0;i<ids.length;i++){
            //  System.out.println("id["+i+"]= "+ids[i]);
            TIMP = intokes[i];
            IDS = i;
            dtm.addRow(new Object[] { ids[i], medNames[i], dossages[i],
                    sideEffects[i] ,intokes[i]});
        }


        start.setText("Start");
        contentPane.add(start, "cell 0 4 15 1");
        pack();
        setLocationRelativeTo(getOwner());
        start.setText("Start");

        //


        contentPane.add(display, "cell 0 4 15 1");
        //   pack();
        // setLocationRelativeTo(getOwner());

        contentPane.add(table2, "cell 0 4 15 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
