package sign_up;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.MouseInfo;

public class SignUpPanel extends JPanel{

	private BufferedImage image,mouse;
	private JLabel name;
	private SignUpPanel frame;
	private JTextField account,password;//�p�G���A��TextField�A�N����γ]�w����C��
	private JButton signup;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private static final long serialVersionUID = 1L;
	
	public SignUpPanel(SignUpClient f){
		//frame = f;//�ǤJgamestage�A�Ψӧ�ئn������[�Jjframe
		
		setLayout(null);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		account = new JTextField();//���a��J��r���a��
		account.setBounds(440, 233, 150, 23);//�]�w�j�p
		account.setFont(font1);
		
		password = new JTextField();//���a��J��r���a��
		password.setBounds(440, 263, 150, 23);//�]�w�j�p
		password.setBackground(Color.decode("#A44600"));
		account.setBackground(Color.decode("#A44600"));
		password.setFont(font1);
		account.setBorder(null);
		password.setBorder(null);
		
		
	    signup = new JButton("");
	    add(signup);
		signup.setBounds(596, 237, 84, 41);
		signup.setContentAreaFilled(false);
		signup.setFocusable(false);
		//signup.setBorderPainted(false);
	    signup.addActionListener(new ActionListener() {          
	        public void actionPerformed(ActionEvent e) {
	        	//SignUpMain.this.sendMessage( mp.account.getText()  + mp.password.getText());
	       }
	   });
		
		
		try
		{ 
				mouse = ImageIO.read(this.getClass().getResourceAsStream("/mouse.png")); //���J�Ϥ�
                image=ImageIO.read(this.getClass().getResourceAsStream("/signup_image.png")); //���J�Ϥ��I��
                //Cursor cr = Toolkit.getDefaultToolkit().createCustomCursor( mouse , new Point(0,0) ,"MyCursor" );
                Cursor cr = toolkit.createCustomCursor( mouse , new Point(0,0) ,"MyCursor" );
                toolkit.getBestCursorSize(32, 32);
        		frame.setCursor( cr );
        }
		catch(Exception e)
		{ 
                javax.swing.JOptionPane.showMessageDialog(null, "���J���ɿ��~:"); 
        }
		
		this.add(account);
		this.add(password);
	}
	@Override
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setBackground(new Color(141, 216, 252));//�]�w�I���C��  
        g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);//�e�X�I���Ϥ�
    }

}

