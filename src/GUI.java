import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends javax.swing.JFrame implements ActionListener {
    private JPanel panel;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelLoginButton;
    private JLabel labelMain;
    private JButton button1;
    private JButton button2;
    private JButton loginButton;
    UserManager userManager;
    PublicDashboard publicDashboard;
    CardLayout cardLayout;
    JPanel mainContainer;
    JTextField signInUserField;
    JPasswordField signInPassField;

    // The constructor for holding the main frame
    public GUI(){
        userManager = new UserManager();
        publicDashboard = new PublicDashboard();
        mainContainer = new JPanel();
        cardLayout = new CardLayout();
        mainContainer.setLayout(cardLayout);
        this.add(mainContainer,  BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Social Media Platform");
        JPanel welcome = createWelcomeScreen();
        JPanel signIn = createSignInCard();
        JPanel signUp = createSignUpCard();
        mainContainer.add(welcome, "WelcomeCard");
        mainContainer.add(signIn, "SignInCard");
        mainContainer.add(signUp, "SignUpCard");
        this.pack();
        this.setVisible(true);
    }
    public JPanel createWelcomeScreen(){
        panel = new JPanel();
        labelMain = new JLabel("Social Media App");
        button1 = new JButton("Sign In");
        button1.addActionListener(this);
        button2 = new JButton("Sign Up");
        button2.addActionListener(this);
        panel.add(labelMain);
        panel.add(button1);
        panel.add(button2);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        return panel;
    }
    public JPanel createSignInCard(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        signInUserField = new JTextField();
        signInPassField = new JPasswordField();
        labelUsername = new JLabel("Username");
        labelPassword = new JLabel("Password");
        labelLoginButton = new JLabel("Submit");
        loginButton = new JButton("Submit");
        loginButton.addActionListener(this);
        loginButton.add(labelLoginButton);
        panel.add(labelUsername);
        panel.add(signInUserField);
        panel.add(labelPassword);
        panel.add(signInPassField);
        panel.add(loginButton);
        return panel;
    }
    public JPanel createSignUpCard(){
        panel = new JPanel();
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("DEBUG: Button clicked was -> " + command);
        if(command.equals("Sign In")){
            cardLayout.show(mainContainer, "SignInCard");
        } else if (command.equals("Sign Up")) {
            cardLayout.show(mainContainer, "SignUpCard");
        } else if (command.equals("Submit")) {
            String user = signInUserField.getText();
            String pass = new String(signInPassField.getPassword());
            if(userManager.signInManager(user, pass)){
                JOptionPane.showMessageDialog(this, "Login Successful!");
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    public static void main (String[] args){
        new GUI();
    }
}