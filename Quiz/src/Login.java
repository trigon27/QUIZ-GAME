import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener
{
    JFrame frame;
    TextField textField;
    Button next;
    Button exit;
    Login()
    {
        frame=new JFrame("Programming Quiz");

        ImageIcon BgImg=new ImageIcon(ClassLoader.getSystemResource("img/GuiBG.jpg"));
        JLabel Bg=new JLabel("",BgImg,JLabel.LEFT);
        Bg.setBounds(0,0,700,600);
        //Heading
        Label Heading =new Label("Quiz Game");
        Heading.setBounds(740,50,300,40);
        Heading.setForeground(new Color(30,144,254));
        Heading.setFont(new Font("Dialog",Font.BOLD,40));
        //Name
        Label Name=new Label("Enter Your Name");
        Name.setBounds(770,200,160,30);
        Name.setForeground(new Color(30,144,254));
        Name.setFont(new Font("Dialog",Font.BOLD,15));

        //text gfield

        textField=new TextField();
        textField.setForeground(Color.black);
        textField.setFont(new Font("Times Now Roman",Font.PLAIN,14));
        textField.setBounds(700,270,300,30);

        //buttons
        next=new Button("Next");
        next.setFocusable(false);
        next.setForeground(new Color(30,144,254));
        next.setBounds(950,480,60,25);
        next.addActionListener(this);


        exit=new Button("Exit");
        exit.setFocusable(false);
        exit.setForeground(new Color(30,144,254));
        exit.setBounds(700,480,60,25);
        exit.addActionListener(this);




        frame.setLayout(null);
        frame.setLocation(300,150);
        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(Bg);
        frame.setVisible(true);
        frame.add(Heading);
        frame.add(Name);
        frame.add(textField);
        frame.add(next);
        frame.add(exit);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == next)
        {
            String name=textField.getText();
            frame.setVisible(false);
            new Quiz(name);

        }
        if(e.getSource()==exit)
        {
            frame.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }

}
