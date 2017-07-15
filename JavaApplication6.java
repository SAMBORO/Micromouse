package javaapplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import java.util.*;
/**
 *
 * @author SANJAY
 */

public class JavaApplication6 implements ActionListener{
    JFrame f=new JFrame("Robo Movement");
    JFrame f1=new JFrame("action");
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JButton b1=new JButton("Pick Block");
    JButton b2=new JButton("Select Source");
    JButton b3=new JButton("Build Path");
    JButton b4=new JButton("Select Robo Position");
    JButton b5=new JButton("Move Robo");
    JButton b6=new JButton("Reset");
    public int k=0;
    public int a; 
    public int b;
    public int w,x,y,z;
    
    ButtonCreator[][] buttons=new ButtonCreator[100][100];
    ButtonCreator[] buttons2=new ButtonCreator[6];
    
    public static void main(String[] args){
        new LayoutSize().setVisible(true);
        
    }
    /*public synchronized void slp(){
			try{
				Thread.sleep(2000);
			}catch(Exception e){ }
	}*/
    public JavaApplication6(int a,int b){  
        this.a=a;
        this.b=b;
        f.setSize(510, 510);
        f1.setSize(250, 520);
        f.setResizable(true);
        f1.setResizable(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setBackground(new java.awt.Color(255, 255, 255));
        p.setBounds(5, 5, 500, 500);
        p.setLayout(new GridLayout(a,b));
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                buttons[i][j]=new ButtonCreator();
                buttons[i][j].addActionListener(this);
                buttons[i][j].setText(" ");
                p.add(buttons[i][j]);   
            }
        }
        f.add(p);
        b1.setFont(new Font("null", 1, 18));b2.setFont(new Font("null", 1, 18));b3.setFont(new Font("null", 1, 18));
        b4.setFont(new Font("null", 1, 18));b5.setFont(new Font("null", 1, 18));b6.setFont(new Font("null", 1, 18));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        p1.setBackground(new java.awt.Color(255, 255, 255));
        p1.setBounds(10,1 , 290, 500);
        p1.setLayout(new GridLayout(6, 1));
        p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);p1.add(b5);p1.add(b6);
        f1.add(p1);
        
        f.setLocation(100, 120);
        f1.setLocation(700, 120);
        
        f1.setVisible(true);
        f.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
         
        if(s.equalsIgnoreCase("Pick Block")){
            k=1;
        }
        if(s.equalsIgnoreCase("Select Source")){
            k=2;
        }
        if(s.equalsIgnoreCase("Build Path")){
            k=0;
            Queue<Integer> q1 =
                          new ArrayDeque<Integer>();
            Queue<Integer> q2 =
                          new ArrayDeque<Integer>();
            Queue<Integer> q3 =
                          new ArrayDeque<Integer>();
            q1.add(w); q2.add(x);
            int c=1; q3.add(0);
            while(!q1.isEmpty() && !q2.isEmpty()){
                int i=q1.poll(); int j=q2.poll();
                int q=q3.poll();
                if(c!=q+1){
                    c=c+1;
                }
                if(i>0 && buttons[i-1][j].getText().equalsIgnoreCase(" ")){
                    buttons[i-1][j].setText(Integer.toString(c));
                    q1.add(i-1);q2.add(j);
                    q3.add(c);
                }
                if(i<a-1 && buttons[i+1][j].getText().equalsIgnoreCase(" ")){
                    buttons[i+1][j].setText(Integer.toString(c));
                    q1.add(i+1);q2.add(j); q3.add(c);
                }
                if(j>0 && buttons[i][j-1].getText().equalsIgnoreCase(" ")){
                    buttons[i][j-1].setText(Integer.toString(c));
                    q1.add(i);q2.add(j-1); q3.add(c);
                }
                if(j<b-1 && buttons[i][j+1].getText().equalsIgnoreCase(" ")){
                    buttons[i][j+1].setText(Integer.toString(c));
                    q1.add(i);q2.add(j+1); q3.add(c);
                }
            }
            
        }
        if(s.equalsIgnoreCase("Select Robo Position")){
            k=4;
        }
        if(s.equalsIgnoreCase("Move Robo")){
            k=5;
            int i=y; int j=z;
            while(Integer.parseInt(buttons[i][j].getText())!=0){
                    int m=Integer.parseInt(buttons[i][j].getText());
                    if(i>0 && !buttons[i-1][j].getText().equalsIgnoreCase("X") && m>Integer.parseInt(buttons[i-1][j].getText()) && j>0){
                        --i;
                       buttons[i][j].setBackground(Color.green);
                       continue;
                    }
                    if(i<a-1 && !buttons[i+1][j].getText().equalsIgnoreCase("X") && m>Integer.parseInt(buttons[i+1][j].getText()) && i<a-1){
                        ++i; 
                       buttons[i][j].setBackground(Color.green);
                       continue;
                    }
                    if(j>0 && !buttons[i][j-1].getText().equalsIgnoreCase("X") && m>Integer.parseInt(buttons[i][j-1].getText())){
                        --j;
                       buttons[i][j].setBackground(Color.green);
                       continue;
                    }
                    if(j<b-1 && !buttons[i][j+1].getText().equalsIgnoreCase("X") && m>Integer.parseInt(buttons[i][j+1].getText()) && j<b-1){
                        ++j; 
                       buttons[i][j].setBackground(Color.green);
                       continue;
                    }
            }
        }
        if(s.equalsIgnoreCase("Reset")){
            k=0;
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    buttons[i][j].setText(" ");
                    buttons[i][j].setBackground(Color.white);
                }
            }
            w=0;x=0;y=0;z=0;
        }
        System.out.println(k+" "+s);
        if(k==1 && s.equalsIgnoreCase(" ")){
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    if(buttons[i][j].isFocusOwner()){
                     buttons[i][j].setText("X");
                     buttons[i][j].setBackground(Color.blue);   
                    }
                }
            }
        }
        if(k==2 && s.equalsIgnoreCase(" ")){
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    if(buttons[i][j].isFocusOwner()){
                        buttons[i][j].setText("0");
                        buttons[i][j].setBackground(Color.yellow);
                        w=i; x=j; k=0; break;
                    }
                }
                if(k==0){
                    break;
                }
            }
        }
        if(k==4 && !s.equalsIgnoreCase("X")){
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++){
                    if(buttons[i][j].isFocusOwner()){
                        buttons[i][j].setBackground(Color.green);
                        y=i; z=j; k=0; break;
                    }
                }
                if(k==0){
                    break;
                }
            }
        }
    }
}