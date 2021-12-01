package com.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    private static JTextField jtext;
    static Test t;
    public static void main(String[] args) {
        t = new Test();
        t.Layout();
    }
    public static void Layout(){
        JFrame jf = new JFrame("小爱同学");
        Container con = jf.getContentPane();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        con.add(north,BorderLayout.NORTH);
        con.add(south,BorderLayout.SOUTH);
        JLabel label = new JLabel("你想对小爱说什么:");
        north.add(label);
        jtext= new JTextField(15);
        north.add(jtext);
        JButton jb = new JButton("发送");
        north.add(jb);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t.answer();
            }
        });
        jf.setSize(400, 100);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void answer(){
        String[] love = {"我也爱你","我也爱你哦","我也爱你啊啊啊","我也爱你呢","我也爱你一生一世"};
        String[] fan = {"别烦了","别烦了1","别烦了2","别烦了3"};
        int loveNumber = (int)(Math.random()*5);
        int fanNuber = (int)(Math.random()*3);
        int i = -1;
        String str = jtext.getText();
        if (str.indexOf("爱你")>=0) {
            i = 1;
        }else if (str.indexOf("很烦")>=0) {
            i = 2;
        }
        switch(i){
            case 1:
                JOptionPane.showMessageDialog(null, "小爱同学:"+love[loveNumber]);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "小爱同学:"+fan[fanNuber]);
                break;
            default:
                JOptionPane.showMessageDialog(null, "小爱同学会的不多，请等待我的长大吧");
        }
    }
}
