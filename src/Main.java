import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by m18 on 11.04.2016.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.h2.Driver");
        JFrame jfrm=new JFrame("Author");
        JPanel jpan=new JPanel();
        jpan.setLayout(new GridLayout(1,2,20,20));
        jfrm.setSize(200,400);
        JTextField jtext=new JTextField();
        jtext.setSize(50,40);
        JButton jbutton=new JButton("Find");
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookname=jtext.getText();
                try{
                    Connection connection=DriverManager.getConnection("jdbc:h2:~/test","sa","");
                    connection.prepareStatement("Select from book");
                }catch(SQLException a){
                    a.printStackTrace();
                }

            }
        });



        jpan.add(jtext);
        jfrm.add(jpan);
        jpan.add(jbutton);
        jfrm.setVisible(true);


    }



}