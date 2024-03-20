package labirints;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Labirints extends javax.swing.JFrame {

    int m, n; //labirinta rindu un kolonnu skaits
    ArrayList<Integer>[] labirints;

    public Labirints() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lasa = new javax.swing.JButton();
        zime = new javax.swing.JButton();
        panelis = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lasa.setText("Uzzīmēt labirintu");
        lasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasaActionPerformed(evt);
            }
        });

        zime.setText("Uzzīmēt ceļu");
        zime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisLayout = new javax.swing.GroupLayout(panelis);
        panelis.setLayout(panelisLayout);
        panelisLayout.setHorizontalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        panelisLayout.setVerticalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(776, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zime)
                .addGap(18, 18, 18)
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasaActionPerformed
        try {
            BufferedReader bufRdr = new BufferedReader(new FileReader("labirints.txt"));
            String failaRinda = bufRdr.readLine(); //nolasa no faila vienu teksta rindu
            String[] tmp = failaRinda.split(" ");    //sadala to atsevišķos gabaliņos, kurus saliek masīvā tmp
            m = Integer.parseInt(tmp[0]);            //iegūst rindu skaitu
            n = Integer.parseInt(tmp[1]);            //iegūst kolonnu skaitu
            //System.out.println(m + " " + n);           //izvada rindu un kolonnu skaitu testa nolūkiem
            Graphics2D g = (Graphics2D) panelis.getGraphics();
            g.setStroke(new BasicStroke(5));
// jāraksta cikls, kas uzzīmēs m reiz n labirinta rūtiņas
            for (int i = 0; i < m + 1; i++) {
                g.drawLine(100, 100 + 40 * i, 100 + 40 * n, i * 40 + 100);
            }
            for (int i = 0; i < n + 1; i++) {
                g.drawLine(100 + 40 * i, 100, i * 40 + 100, 100 + m * 40);
            }
              g.setColor(panelis.getBackground());
            g.setColor(black);
            g.setStroke(new BasicStroke(5));

            labirints = new ArrayList[m * n];
            for (int i = 0; i < labirints.length; i++) {
                failaRinda = bufRdr.readLine();
                tmp = failaRinda.split(" ");
                labirints[i] = new ArrayList<Integer>();
                  g.setColor(panelis.getBackground());
                for (int j = 1; j < tmp.length; j++) {
                    labirints[i].add(Integer.parseInt(tmp[j]) - 1);
                    int kaimins = labirints[i].get(j - 1);
                     
                    int r0 = kaimins / n;
                    int k0 = kaimins % n;
                    int k1 = i % n;
                    int r1 = i / n;
                     //System.out.println(i+" "+r1+":"+k1+" "+kaimins+" r0->"+r0+":"+k0);
                    if (k1 == k0) {
                        if (r1 < r0) {
                           g.drawLine(105+k0*40,100+ r0*40, 95+(k0+1)*40, 100+r0*40);
                        }else if(r1 > r0) {
                            //g.drawLine(100 + 40 * k0, 100+40*r0, 100 + 40 * (k0+1), 100+40*(r0+1));
                        }
                    }
                    if (r0 == r1) {
                        if (k1 < k0) {
                            g.drawLine(100 + 40 * k0, 105+40*r0, 100 + 40 * k0, 95+40*(r0+1));
                        }
                        else if(k1<k0){
                            g.drawLine(100 + 40 * (k0 + 1), 105 + 40 * r0, 100 + 40 * (k0 + 1), 95 + 40 * (r0 + 1));
                        }
                    }
                }
            }

// te jāraksta cikls, kas lasa katru no m reiz n faila rindām un izmanto datus, 
// lai dzēstu sienas starp kaimiņu rūtiņām. Dzēšana notiek, pārvelkot līniju fona krāsā
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
       // bfs(1);

    }//GEN-LAST:event_lasaActionPerformed

    private void zimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zimeActionPerformed
        // te jānolasa lietotāja vēlmes no kuras uz kuru rūtiņu jāmeklē ceļš
        zimetCelu(13, 2);
         
    }//GEN-LAST:event_zimeActionPerformed
    public void zimetCelu(int vs, int ve) {
        
        Stack<Integer> cels = mekletCelu(vs, ve);
        Graphics g = panelis.getGraphics();
     g.setColor(Color.red);
         
          
     
        while(cels.size()>1){
         
          int z= cels.pop();
          int y =cels.peek();
            int r0 = z%n; 
            int k0=z/n; 
            int r1=y%n;
            int k1=y/n;
            
            g.drawLine(120+ 40 * r0, 120 + 40 * k0 , 120 + 40 * r1, 120 + 40 * k1);
            System.out.println(k0+"k0 "+k1+"k1 "+r0+"r0 "+r1+"r1");
           
            
                
        }
        
    }

    public void bfs(int v) {
        Queue<Integer> rinda = new LinkedList();
        boolean apmeklets[] = new boolean[n * m];

        rinda.add(v - 1);
        apmeklets[v - 1] = true;
System.out.println(v);
        while (!(rinda.isEmpty())) {
            int p = rinda.remove();
            for (int j = 0; j < labirints[p].size(); j++) {
                int u = labirints[p].get(j);
                if (apmeklets[u] == false) {
                    rinda.add(u);
                    apmeklets[u] = true;
                   // System.out.println(u + 1);
                }
            }
        }
    }

    public Stack<Integer> mekletCelu(int vs, int ve) {
        Stack<Integer> cels = new Stack();
        Queue<Integer> rinda = new LinkedList();
        int no[] = new int[n * m];
        no[vs-1] = -1;
        boolean apmeklets[] = new boolean[n * m];
        rinda.add(vs - 1);
        apmeklets[vs - 1] = true;
        boolean atrasts=false;
        while (!rinda.isEmpty()&&!atrasts) {
            int p = rinda.remove();
            for (int j = 0; j < labirints[p].size(); j++) {
                int u = labirints[p].get(j);
                if (apmeklets[u] == false) {
                    
                    rinda.add(u);
                    apmeklets[u] = true;
                    no[u] = p;
                    if (u == ve-1) {
                        atrasts=true;
                        
                    }
                }
            }
        }
         int u= ve-1;
        while (u>-1) {
            
            cels.push(u);
             System.out.println(u);
            u=no[u];
           
        }
       
        return cels;
    }

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
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Labirints().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton lasa;
    private javax.swing.JPanel panelis;
    private javax.swing.JButton zime;
    // End of variables declaration//GEN-END:variables
}
