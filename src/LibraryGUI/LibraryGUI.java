package LibraryGUI;

import Account.Account;
import Library.Library;

public class LibraryGUI extends javax.swing.JFrame {
    private int libacct_id = 1;
    /**
     * Creates new form LibraryGUI
     */
    public LibraryGUI() {
        initComponents();
        Account acct = new Account();
        String[] name = acct.getAccountName(libacct_id);
        currentUser.setText("Current Library Admin: " + name[0] + " " + name[1]);
        
        // 
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            
            String[] strings = { "Please click refresh the library."};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);
    }
    public LibraryGUI(int id){
        initComponents();
        this.libacct_id = id;
        Account acct = new Account();
        String[] name = acct.getAccountName(id);
        currentUser.setText("Current Library Admin: " + name[0] + " " + name[1]);
        
        // 
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            
            String[] strings = { "Please click refresh the library."};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        refreshLibrary = new javax.swing.JButton();
        borrowBook = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        currentUser = new javax.swing.JLabel();
        restartLibrary = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        accountMenu = new javax.swing.JMenu();
        changeName = new javax.swing.JMenuItem();
        changeEmail = new javax.swing.JMenuItem();
        changePassword = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        booksMenu = new javax.swing.JMenu();
        addGenre = new javax.swing.JMenuItem();
        deleteGenre = new javax.swing.JMenuItem();
        addBook = new javax.swing.JMenuItem();
        editBook = new javax.swing.JMenuItem();
        deleteBook = new javax.swing.JMenuItem();
        studentMenu = new javax.swing.JMenu();
        registerStudent = new javax.swing.JMenuItem();
        deleteStudent = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System - Books");

        jPanel2.setBackground(new java.awt.Color(75, 75, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        refreshLibrary.setText("Refresh");

        borrowBook.setText("Borrow Book");

        appointmentsButton.setText("Appointments");

        currentUser.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        currentUser.setForeground(new java.awt.Color(255, 255, 255));
        currentUser.setText("Current Library Admin: ");

        restartLibrary.setText("Restart Library");
        restartLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartLibraryActionPerformed(evt);
            }
        });

        accountMenu.setText("Account");

        changeName.setText("Change Name");
        changeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameActionPerformed(evt);
            }
        });
        accountMenu.add(changeName);

        changeEmail.setText("Change Email");
        changeEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeEmailActionPerformed(evt);
            }
        });
        accountMenu.add(changeEmail);

        changePassword.setText("Change Password");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        accountMenu.add(changePassword);

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        accountMenu.add(logOut);

        jMenuBar1.add(accountMenu);

        booksMenu.setText("Books");

        addGenre.setText("Add Genre");
        addGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGenreActionPerformed(evt);
            }
        });
        booksMenu.add(addGenre);

        deleteGenre.setText("Delete Genre");
        deleteGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGenreActionPerformed(evt);
            }
        });
        booksMenu.add(deleteGenre);

        addBook.setText("Add Book");
        booksMenu.add(addBook);

        editBook.setText("Edit Book");
        editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookActionPerformed(evt);
            }
        });
        booksMenu.add(editBook);

        deleteBook.setText("Delete Book");
        booksMenu.add(deleteBook);

        jMenuBar1.add(booksMenu);

        studentMenu.setText("Student");

        registerStudent.setText("Register Student");
        registerStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStudentActionPerformed(evt);
            }
        });
        studentMenu.add(registerStudent);

        deleteStudent.setText("Delete Student");
        deleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentActionPerformed(evt);
            }
        });
        studentMenu.add(deleteStudent);

        jMenuBar1.add(studentMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(borrowBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshLibrary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointmentsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restartLibrary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(currentUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(borrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(appointmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(restartLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        super.dispose();
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void addGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGenreActionPerformed
        new Genre_AddGenreGUI().setVisible(true);
    }//GEN-LAST:event_addGenreActionPerformed

    private void deleteGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGenreActionPerformed
        new Genre_DeleteGenreGUI().setVisible(true);
    }//GEN-LAST:event_deleteGenreActionPerformed

    private void editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBookActionPerformed

    private void changeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameActionPerformed
        new Acct_ChangeNameGUI(libacct_id).setVisible(true);
    }//GEN-LAST:event_changeNameActionPerformed

    private void restartLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartLibraryActionPerformed
        super.dispose();
        new LibraryGUI(libacct_id).setVisible(true);
    }//GEN-LAST:event_restartLibraryActionPerformed

    private void changeEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeEmailActionPerformed
        new Acct_ChangeEmailGUI(libacct_id).setVisible(true);
    }//GEN-LAST:event_changeEmailActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        new Acct_ChangePasswordGUI(libacct_id).setVisible(true);
    }//GEN-LAST:event_changePasswordActionPerformed

    private void registerStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerStudentActionPerformed
        new Student_RegisterGUI().setVisible(true);
    }//GEN-LAST:event_registerStudentActionPerformed

    private void deleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentActionPerformed
        new Student_DeleteGUI().setVisible(true);
    }//GEN-LAST:event_deleteStudentActionPerformed

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
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu accountMenu;
    private javax.swing.JMenuItem addBook;
    private javax.swing.JMenuItem addGenre;
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JMenu booksMenu;
    private javax.swing.JButton borrowBook;
    private javax.swing.JMenuItem changeEmail;
    private javax.swing.JMenuItem changeName;
    private javax.swing.JMenuItem changePassword;
    private javax.swing.JLabel currentUser;
    private javax.swing.JMenuItem deleteBook;
    private javax.swing.JMenuItem deleteGenre;
    private javax.swing.JMenuItem deleteStudent;
    private javax.swing.JMenuItem editBook;
    private javax.swing.JList<String> jList2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JButton refreshLibrary;
    private javax.swing.JMenuItem registerStudent;
    private javax.swing.JButton restartLibrary;
    private javax.swing.JMenu studentMenu;
    // End of variables declaration//GEN-END:variables
}
