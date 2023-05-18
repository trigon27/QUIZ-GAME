import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score implements ActionListener {
    JFrame frame;
    public static int score;
    Button again;
    Button exit;
    Score(int score ,String name)
    {
        frame=new JFrame("Score");
        //heading
        this.score=score;
        JLabel points=new JLabel("Your score is : "+score);
        points.setForeground(new Color(255,255,255));
        points.setBounds(40,100,500,50);
        points.setFont(new Font("Comic Sans MS",Font.BOLD,25));

        //thanks
        JLabel thanks=new JLabel(" Thanks "+ name + " for playing quiz game! ");
        thanks.setForeground(new Color(255,255,255));
        thanks.setBounds(30,15,500,50);
        thanks.setFont(new Font("Comic Sans MS",Font.BOLD,25));

        //Button
        again =new Button("Play again");
        again.setForeground(new Color(135,206,235));
        again.setFont(new Font("Times Now Roman",Font.PLAIN,14));
        again.setBackground(new Color(25,25,112));
        again.setBounds(30,180,100,40);
        again.setFocusable(false);
        again.addActionListener( this);

        exit =new Button("EXIT");
        exit.setForeground(new Color(135,206,235));
        exit.setFont(new Font("Times Now Roman",Font.PLAIN,14));
        exit.setBackground(new Color(25,25,112));
        exit.setBounds(30,250,100,40);
        exit.setFocusable(false);
        exit.addActionListener( this);

        //background
        ImageIcon background=new ImageIcon(ClassLoader.getSystemResource("img/Bg.jpg"));
        JLabel bg=new JLabel(background);
        bg.setBounds(0,0,768,360);
        bg.add(points);
        bg.add(thanks);
        bg.add(again);
        bg.add(exit);

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(768,360);
        frame.setLocation(350,250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(bg);
//        frame.add(points);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==again)
        {
            new Login();
        }
        if(e.getSource()==exit)
        {
           frame.setVisible(false);
        }

    }
    public static void main(String[] args)
    {
        new Score(99,"user");
    }
}
