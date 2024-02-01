package GUI;

import Account.Account;
import Library.Library;
import Display.Popups;
import Models.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

public class Appointments extends javax.swing.JFrame {
    private String[][] appointments;
    User c_user = new User();
    private int id;
    /**
     * Creates new form Appt_Appointments
     */
    public Appointments() {
        initComponents();
        c_user.setUserId(1);
        Account acct = new Account();
        Library lib = new Library();
        String[] name = acct.getAccountName(c_user);
        currentUser.setText("Welcome, " + name[0] + " " + name[1] + "!");
        initApptTable();
        // Date and Time 
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCurrentTime();
            }
        });
        timer.start();
    }
    public Appointments(int id) {
        this.id = id;
        initComponents();
        c_user.setUserId(1);
        Account acct = new Account();
        Library lib = new Library();
        String[] name = acct.getAccountName(c_user);
        currentUser.setText("Welcome, " + name[0] + " " + name[1] + "!");
        initApptTable();
        // Date and Time 
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCurrentTime();
            }
        });
        timer.start();
    }
    private void updateCurrentTime() {
        // Format the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Update the text of the JLabel
        dateAndTime.setText(formattedDateTime);
    }
    public void initApptTable(){
        Library lib = new Library();
        appointments = lib.getAppointmentsDetails("appt_date_borrow DESC");
        apptTable.setModel(new javax.swing.table.DefaultTableModel(
            appointments,
            new String [] {
                "Book", "Borrower", "Date & Time Borrowed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        apptTable = new javax.swing.JTable();
        finishApptButton = new javax.swing.JButton();
        deleteApptButton = new javax.swing.JButton();
        recordsButton = new javax.swing.JButton();
        libButton = new javax.swing.JButton();
        dateAndTime = new javax.swing.JLabel();
        dateAndTime1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logOutButton = new javax.swing.JButton();
        currentUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Appointments");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));

        apptTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        apptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2020-54321", "Slime", "2023-12-23 13:11:11"},
                {"2020-54321", "C++", "2023-12-23 13:15:15"}
            },
            new String [] {
                "Book", "Borrower", "Date & Time Borrowed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(apptTable);
        if (apptTable.getColumnModel().getColumnCount() > 0) {
            apptTable.getColumnModel().getColumn(0).setResizable(false);
            apptTable.getColumnModel().getColumn(1).setResizable(false);
            apptTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel2);

        finishApptButton.setBackground(new java.awt.Color(60, 110, 113));
        finishApptButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        finishApptButton.setForeground(new java.awt.Color(255, 255, 255));
        finishApptButton.setText("Finish");
        finishApptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishApptButtonActionPerformed(evt);
            }
        });

        deleteApptButton.setBackground(new java.awt.Color(60, 110, 113));
        deleteApptButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        deleteApptButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteApptButton.setText("Delete");
        deleteApptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteApptButtonActionPerformed(evt);
            }
        });

        recordsButton.setBackground(new java.awt.Color(60, 110, 113));
        recordsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        recordsButton.setForeground(new java.awt.Color(255, 255, 255));
        recordsButton.setText("Records");
        recordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordsButtonActionPerformed(evt);
            }
        });

        libButton.setBackground(new java.awt.Color(60, 110, 113));
        libButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        libButton.setForeground(new java.awt.Color(255, 255, 255));
        libButton.setText("Library");
        libButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libButtonActionPerformed(evt);
            }
        });

        dateAndTime.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        dateAndTime.setForeground(new java.awt.Color(0, 0, 0));
        dateAndTime.setText(" ");

        dateAndTime1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        dateAndTime1.setForeground(new java.awt.Color(0, 0, 0));
        dateAndTime1.setText("Date & Time: ");

        jPanel3.setBackground(new java.awt.Color(60, 110, 113));

        logOutButton.setBackground(new java.awt.Color(60, 110, 113));
        logOutButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log Out");
        logOutButton.setBorderPainted(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                logOutButtonMouseMoved(evt);
            }
        });
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
        });
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        currentUser.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        currentUser.setForeground(new java.awt.Color(255, 255, 255));
        currentUser.setText("Welcome, First Name Last Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(currentUser)
                .addGap(252, 252, 252)
                .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(currentUser))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateAndTime1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(libButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(recordsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteApptButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishApptButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dateAndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(finishApptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteApptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(recordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(libButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(dateAndTime1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateAndTime)
                        .addGap(119, 119, 119))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finishApptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishApptButtonActionPerformed
        try {
            Library lib = new Library();
            lib.finishAppointment(Integer.parseInt(appointments[apptTable.getSelectedRow()][3]));
            initApptTable();
        } catch (Exception e) {
            Popups.noSelectedAppt();
        }
    }//GEN-LAST:event_finishApptButtonActionPerformed

    private void deleteApptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteApptButtonActionPerformed
        try {
            Library lib = new Library();
            lib.deleteAppointment(Integer.parseInt(appointments[apptTable.getSelectedRow()][3]));
            initApptTable();
        } catch (Exception e) {
            Popups.noSelectedAppt();
        }
    }//GEN-LAST:event_deleteApptButtonActionPerformed

    private void recordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordsButtonActionPerformed
        super.dispose();
        new Records(this.id).setVisible(true);
    }//GEN-LAST:event_recordsButtonActionPerformed

    private void libButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libButtonActionPerformed
        super.dispose();
        new LibraryGUI(this.id).setVisible(true);
    }//GEN-LAST:event_libButtonActionPerformed

    private void logOutButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseMoved
        logOutButton.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_logOutButtonMouseMoved

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_logOutButtonMouseExited

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apptTable;
    private javax.swing.JLabel currentUser;
    private javax.swing.JLabel dateAndTime;
    private javax.swing.JLabel dateAndTime1;
    private javax.swing.JButton deleteApptButton;
    private javax.swing.JButton finishApptButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton libButton;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton recordsButton;
    // End of variables declaration//GEN-END:variables
}
