package LibraryGUI;

import Account.Account;
import Library.Library;
import Display.Display;

public class LibraryGUI extends javax.swing.JFrame {
    private int libacct_id = 1; // must be set with no value in actual use
    private String[] bookList;
    private String[][] bookTable;
    /**
     * Creates new form LibraryGUI
     */
    
    // gui initializer for testing (running this file directly)
    public LibraryGUI() {
        initComponents();
        Account acct = new Account();
        Library lib = new Library();
        String[] name = acct.getAccountName(libacct_id);
        currentUser.setText("Current Library Admin: " + name[0] + " " + name[1]);
        initBookTable("");
    }
    // gui initializer for actual use (to be access from LoginGUI.java
    public LibraryGUI(int id){
        initComponents();
        this.libacct_id = id;
        Account acct = new Account();
        Library lib = new Library();
        String[] name = acct.getAccountName(id);
        currentUser.setText("Current Library Admin: " + name[0] + " " + name[1]);
        initBookTable("");
    }
    public void initBookTable(String toSearch){
        Library lib = new Library();
        bookTable = lib.getBookListForTable(toSearch);
        tableOfBooks.setModel(new javax.swing.table.DefaultTableModel(
            bookTable,
            new String [] {
                "Book", "Author", "Genre", "Quantity", "Availability"
            }
        ));
        jScrollPane3.setViewportView(tableOfBooks);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOfBooks = new javax.swing.JTable();
        refreshLibrary = new javax.swing.JButton();
        borrowBook = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        currentUser = new javax.swing.JLabel();
        restartLibrary = new javax.swing.JButton();
        searchBook = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        editBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));

        jScrollPane3.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        tableOfBooks.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        tableOfBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Book", "Author", "Genre", "Quantity", "Availability"
            }
        ));
        jScrollPane3.setViewportView(tableOfBooks);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        refreshLibrary.setBackground(new java.awt.Color(60, 110, 113));
        refreshLibrary.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        refreshLibrary.setForeground(new java.awt.Color(255, 255, 255));
        refreshLibrary.setText("Refresh");
        refreshLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshLibraryActionPerformed(evt);
            }
        });

        borrowBook.setBackground(new java.awt.Color(60, 110, 113));
        borrowBook.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        borrowBook.setForeground(new java.awt.Color(255, 255, 255));
        borrowBook.setText("Borrow Book");
        borrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookActionPerformed(evt);
            }
        });

        appointmentsButton.setBackground(new java.awt.Color(60, 110, 113));
        appointmentsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        appointmentsButton.setForeground(new java.awt.Color(255, 255, 255));
        appointmentsButton.setText("Appointments");
        appointmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentsButtonActionPerformed(evt);
            }
        });

        currentUser.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        currentUser.setForeground(new java.awt.Color(0, 0, 0));
        currentUser.setText("Current Library Admin: ");

        restartLibrary.setBackground(new java.awt.Color(60, 110, 113));
        restartLibrary.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        restartLibrary.setForeground(new java.awt.Color(255, 255, 255));
        restartLibrary.setText("Restart Library");
        restartLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartLibraryActionPerformed(evt);
            }
        });

        searchBook.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        searchButton.setBackground(new java.awt.Color(60, 110, 113));
        searchButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        editBookButton.setBackground(new java.awt.Color(60, 110, 113));
        editBookButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        editBookButton.setForeground(new java.awt.Color(255, 255, 255));
        editBookButton.setText("Edit Book");
        editBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setBackground(new java.awt.Color(60, 110, 113));
        deleteBookButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        deleteBookButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteBookButton.setText("Delete Book");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Book Operations:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(borrowBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(refreshLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(appointmentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(restartLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editBookButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteBookButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(80, 80, 80))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(currentUser)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addGap(18, 18, 18)
                        .addComponent(refreshLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(appointmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(restartLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        accountMenu.setText("Account");
        accountMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        changeName.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        changeName.setText("Change Name");
        changeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameActionPerformed(evt);
            }
        });
        accountMenu.add(changeName);

        changeEmail.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        changeEmail.setText("Change Email");
        changeEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeEmailActionPerformed(evt);
            }
        });
        accountMenu.add(changeEmail);

        changePassword.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        changePassword.setText("Change Password");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        accountMenu.add(changePassword);

        logOut.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        accountMenu.add(logOut);

        jMenuBar1.add(accountMenu);

        booksMenu.setText("Books");
        booksMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        addGenre.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        addGenre.setText("Add Genre");
        addGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGenreActionPerformed(evt);
            }
        });
        booksMenu.add(addGenre);

        deleteGenre.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        deleteGenre.setText("Delete Genre");
        deleteGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGenreActionPerformed(evt);
            }
        });
        booksMenu.add(deleteGenre);

        addBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        addBook.setText("Add Book");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });
        booksMenu.add(addBook);

        editBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        editBook.setText("Edit Book");
        editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookActionPerformed(evt);
            }
        });
        booksMenu.add(editBook);

        deleteBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        deleteBook.setText("Delete Book");
        deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookActionPerformed(evt);
            }
        });
        booksMenu.add(deleteBook);

        jMenuBar1.add(booksMenu);

        studentMenu.setText("Student");
        studentMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        registerStudent.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        registerStudent.setText("Register Student");
        registerStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStudentActionPerformed(evt);
            }
        });
        studentMenu.add(registerStudent);

        deleteStudent.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        super.dispose();
        new LoginGUI1().setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void addGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGenreActionPerformed
        new Genre_AddGenreGUI().setVisible(true);
    }//GEN-LAST:event_addGenreActionPerformed

    private void deleteGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGenreActionPerformed
        new Genre_DeleteGenreGUI().setVisible(true);
    }//GEN-LAST:event_deleteGenreActionPerformed

    private void editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookActionPerformed
        new Books_EditBookGUI().setVisible(true);
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

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        new Books_AddBookGUI().setVisible(true);
    }//GEN-LAST:event_addBookActionPerformed

    private void deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookActionPerformed
        new Books_DeleteBookGUI().setVisible(true);
    }//GEN-LAST:event_deleteBookActionPerformed

    private void refreshLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshLibraryActionPerformed
        Library lib = new Library();
        searchBook.setText("");
        initBookTable("");
    }//GEN-LAST:event_refreshLibraryActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        Library lib = new Library();
        initBookTable(searchBook.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

    private void borrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookActionPerformed
        new Appt_BorrowBook().setVisible(true);
    }//GEN-LAST:event_borrowBookActionPerformed

    private void appointmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsButtonActionPerformed
        new Appt_Appointments().setVisible(true);
    }//GEN-LAST:event_appointmentsButtonActionPerformed

    private void editBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookButtonActionPerformed
        try {
            int index = tableOfBooks.getSelectedRow();
            new Books_EditBookGUI(Integer.parseInt(bookTable[index][5])).setVisible(true);
        } catch (Exception e){
            Display.noSelectedBookTo("edit");
        }
    }//GEN-LAST:event_editBookButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        try {
            int index = tableOfBooks.getSelectedRow();
            if(Display.confirmBookDelete() == 0){
                Library lib = new Library();
                int bookId = Integer.parseInt(bookTable[index][5]);
                String book_name = bookTable[index][0];
                System.out.println(bookId + " " + book_name);
                lib.deleteBook(bookId, book_name);
            }
        } catch (Exception e){
            Display.noSelectedBookTo("delete");
        }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

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
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JMenuItem deleteGenre;
    private javax.swing.JMenuItem deleteStudent;
    private javax.swing.JMenuItem editBook;
    private javax.swing.JButton editBookButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JButton refreshLibrary;
    private javax.swing.JMenuItem registerStudent;
    private javax.swing.JButton restartLibrary;
    private javax.swing.JTextField searchBook;
    private javax.swing.JButton searchButton;
    private javax.swing.JMenu studentMenu;
    private javax.swing.JTable tableOfBooks;
    // End of variables declaration//GEN-END:variables
}
