/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;

/**
 *
 * @author izyde
 */
public class main extends javax.swing.JFrame {

    JFileChooser fc = new JFileChooser();
    
    FileNameExtensionFilter filter = null;    
    
    JScrollBar barraV;
    JScrollBar barraH;
    
    EstadisticasImagen estImg;
    
    class MiListener implements AdjustmentListener{

        @Override
        public void adjustmentValueChanged(AdjustmentEvent arg0) {
            if(!imagePanel.IsImageSet())
                return;
            
            //System.out.println("Posicion: " + ScrollPanel.getViewport().getViewPosition().toString());
            //System.out.println("Tamaño: " + ScrollPanel.getViewport().getExtentSize().toString());
            estImg.calculaEstadisticas(imagePanel.GetImage(), ScrollPanel.getViewport().getViewPosition(), ScrollPanel.getViewport().getExtentSize());
            int[] minimos = estImg.getMinimo();
            int[] maximos = estImg.getMaximo();
            int[] medias = estImg.getPromedio();
            
            for (int i = 0; i < 3; i++) {
                switch(i){
                    case 0:
                        TextFieldBlue.setText("Min: " + minimos[i] + " Max: " + maximos[i] + " Media: " + medias[i]);
                        break;
                        
                    case 1:
                        TextFieldGreen.setText("Min: " + minimos[i] + " Max: " + maximos[i] + " Media: " + medias[i]);
                        break;
                        
                    case 2:
                        TextFieldRed.setText("Min: " + minimos[i] + " Max: " + maximos[i] + " Media: " + medias[i]);
                        break;
                }
            }
        }
        
    }
    
    public main() {
        initComponents();
        
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        barraV = ScrollPanel.getVerticalScrollBar();
        barraH = ScrollPanel.getHorizontalScrollBar();
        
        //ScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        barraV.addAdjustmentListener(new MiListener());
        barraH.addAdjustmentListener(new MiListener());
        
        estImg = new EstadisticasImagen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPanel = new javax.swing.JScrollPane();
        imagePanel = new ui.ImagePanel();
        Panel = new javax.swing.JPanel();
        LabelRed = new javax.swing.JLabel();
        LabelGreen = new javax.swing.JLabel();
        LabelBlue = new javax.swing.JLabel();
        TextFieldRed = new javax.swing.JTextField();
        TextFieldGreen = new javax.swing.JTextField();
        TextFieldBlue = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        OpenFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        CloseApp = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        Help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(710, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ScrollPanel.setViewportView(null);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        ScrollPanel.setViewportView(imagePanel);

        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Porcentajes de Color"));
        Panel.setMinimumSize(new java.awt.Dimension(685, 0));

        LabelRed.setForeground(new java.awt.Color(255, 51, 51));
        LabelRed.setText("Rojo:");

        LabelGreen.setForeground(new java.awt.Color(51, 255, 51));
        LabelGreen.setText("Verde:");

        LabelBlue.setForeground(new java.awt.Color(51, 102, 255));
        LabelBlue.setText("Azul:");

        TextFieldRed.setEditable(false);
        TextFieldRed.setText("Min: 0 Max: 0 Media: 0");
        TextFieldRed.setToolTipText("Componente Rojo de la Imagen");

        TextFieldGreen.setEditable(false);
        TextFieldGreen.setText("Min: 0 Max: 0 Media: 0");
        TextFieldGreen.setToolTipText("Componente Verde de la Imagen");

        TextFieldBlue.setEditable(false);
        TextFieldBlue.setText("Min: 0 Max: 0 Media: 0");
        TextFieldBlue.setToolTipText("Componente Azul de la Imagen");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelGreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelBlue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRed)
                    .addComponent(LabelGreen)
                    .addComponent(LabelBlue)
                    .addComponent(TextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        File.setText("Archivo");

        OpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        OpenFile.setText("Abrir Imagen");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        File.add(OpenFile);
        File.add(jSeparator1);

        CloseApp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        CloseApp.setText("Cerrar");
        CloseApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseAppActionPerformed(evt);
            }
        });
        File.add(CloseApp);

        MenuBar.add(File);

        HelpMenu.setText("Ayuda");

        Help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        Help.setText("Acerca de");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });
        HelpMenu.add(Help);

        MenuBar.add(HelpMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        filter = new FileNameExtensionFilter("Imágenes", "png", "jpg", "jpge");
        fc.addChoosableFileFilter(filter);
        
        int res = fc.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            imagePanel.AddImage(fichero);
        }
    }//GEN-LAST:event_OpenFileActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        JOptionPane.showMessageDialog(rootPane, "En el menú Archivo dispondrá de 2 opciones: Abrir Imagen y Cerrar.\n"
                + "Abrir Imagen permite abrir una imagen para su edición en la aplicación.\n"
                + "Cerrar, cerrará la aplicación.\n\n"
                + "Desarrollado por: Noah Hernández Morales e Isidro Bermúdez Fernández", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_HelpActionPerformed

    private void CloseAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseAppActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_CloseAppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseApp;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Help;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JLabel LabelBlue;
    private javax.swing.JLabel LabelGreen;
    private javax.swing.JLabel LabelRed;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem OpenFile;
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JTextField TextFieldBlue;
    private javax.swing.JTextField TextFieldGreen;
    private javax.swing.JTextField TextFieldRed;
    private ui.ImagePanel imagePanel;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
