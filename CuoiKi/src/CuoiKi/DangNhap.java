package CuoiKi;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DangNhap() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo\\Downloads\\logo.png"));
		setTitle("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 387);
		setLocation(550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Login to DVIM");
		titleLabel.setForeground(new Color(0, 0, 0));
		titleLabel.setBounds(10, 26, 341, 70);
		titleLabel.setFont(new Font("Stencil", Font.PLAIN, 47));

		contentPane.add(titleLabel);
		
		JLabel userLabel = new JLabel("username:");
		userLabel.setForeground(new Color(0, 0, 0));
		userLabel.setBounds(44, 128, 116, 20);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("password:");
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passLabel.setBounds(44, 206, 106, 20);
		contentPane.add(passLabel);
		
		userField = new JTextField();
		userField.setBounds(160, 123, 191, 31);
		userField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(160, 199, 191, 31);
		contentPane.add(passField);
		
		JButton logButton = new JButton("Login");
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = userField.getText();
				String pass = passField.getText();
				
				if(user.equals("java") && pass.equals("cuoiki")) {
					
					GiaoDien gui = new GiaoDien();
					gui.show();
					dispose();
					
					
				} else {
				    JOptionPane.showMessageDialog(null, "Wrong account!", "Warning", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		logButton.setForeground(new Color(255, 255, 255));
		logButton.setBackground(new Color(0, 0, 0));
		logButton.setBounds(160, 274, 113, 44);
		logButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(logButton);
		
		JLabel hint1 = new JLabel("hint: java");
		hint1.setBounds(207, 165, 66, 13);
		hint1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(hint1);
		
		JLabel hint2 = new JLabel("hint: cuoiki");
		hint2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		hint2.setBounds(197, 240, 76, 13);
		contentPane.add(hint2);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\logo.png"));
		bgLabel.setBounds(-65, 0, 481, 370);
		contentPane.add(bgLabel);
	}
}
