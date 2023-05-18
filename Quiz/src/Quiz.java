import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {
    String name;
    String[][] questions;
    String[][] answers;
    String[][] userAnswers=new String[10][1];
    JLabel Sno;
    JLabel question;
    JRadioButton option1,option2,option3,option4;
    JButton nextq;
    JButton summit;
    ButtonGroup group;
    public static int score=0;
    public static int count=0;
    JFrame frame;

    Quiz(String name)
    {
        this.name=name;


        frame=new JFrame("Quiz");

        //array
         questions=new String[10][5];
         answers=new String[10][2];

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        //heading img
        ImageIcon BgImg=new ImageIcon(ClassLoader.getSystemResource("img/QuizBg.jpg"));
        JLabel Bg=new JLabel(BgImg);
        Bg.setBounds(0,0,1300,300);

        //heading
        JLabel heading=new JLabel("WELCOME "+name+" TO QUIZ GAME ");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        heading.setBounds(30,30,800,200);
        Bg.add(heading);

        //questions
         Sno =new JLabel("");
        Sno.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        Sno.setBounds(80,380,30,30);

         question =new JLabel("");
        question.setFont(new Font("Times Now Roman",Font.PLAIN,25));
        question.setBounds(120,380,1000,30);

        //options
         option1=new JRadioButton("");
        option1.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        option1.setBounds(150,430,800,30);

        option2=new JRadioButton("");
        option2.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        option2.setBounds(150,490,800,30);

         option3=new JRadioButton("");
        option3.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        option3.setBounds(150,550,800,30);

         option4=new JRadioButton("");
        option4.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        option4.setBounds(150,610,800,30);

        group=new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        //button

        nextq=new JButton("NEXT");
        nextq.setForeground(Color.white);
        nextq.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        nextq.setBackground(new Color(128,0,129));
        nextq.setBounds(1100,550,100,50);
        nextq.setFocusable(false);
        nextq.addActionListener( this);

        summit=new JButton("SUMMIT");
        summit.setForeground(Color.white);
        summit.setFont(new Font("Times Now Roman",Font.PLAIN,18));
        summit.setBackground(new Color(128,0,129));
        summit.setBounds(1100,620,140,50);
        summit.setFocusable(false);
        summit.setEnabled(false);
        summit.addActionListener(this);




        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocation(100,40);
        frame.setSize(1310,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(Bg);
        frame.add(Sno);
        frame.add(question);
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);
        frame.add(nextq);
        frame.add(summit);
         Start(count);
    }


    public void Start(int count)
    {
        Sno.setText(String.valueOf(count+1));
        question.setText(questions[count][0]);

        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        option1.setFocusable(false);

        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        option2.setFocusable(false);

        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        option3.setFocusable(false);

        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        option4.setFocusable(false);

        group.clearSelection();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == nextq)
        {
                if(group.getSelection()==null)
                {
                    userAnswers[count][0]="";
                }
                else
                {
                    userAnswers[count][0]=group.getSelection().getActionCommand();
                }
            if(count==8)
            {
                nextq.setEnabled(false);
                summit.setEnabled(true);
            }
            count++;
            Start(count);
        }
        if (e.getSource()== summit )
        {
            if(count==9)
            {
                if (group.getSelection() == null) {
                    userAnswers[count][0] = "";
                } else {
                    userAnswers[count][0] = group.getSelection().getActionCommand();
                }
            }
            for (int i = 0; i<userAnswers.length; i++)
            {
                if(userAnswers[i][0].equals(answers[i][1]))
                {
                    score+=10;
                }
            }
            frame.setVisible(false);
            new Score(score,name);
        }
    }
    public static void main(String[] args)
    {
        new Quiz("user");

    }
}
