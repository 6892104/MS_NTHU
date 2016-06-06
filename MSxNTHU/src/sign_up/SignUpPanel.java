package sign_up;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.*;

import MapleStory.MainWindow;

public class SignUpPanel extends JPanel{

	private BufferedImage image,mouse;
	private JTextField account,password;//�p�G���A��TextField�A�N����γ]�w����C��
	private JButton signup, web, join;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private MainWindow parent;
	
	private static final long serialVersionUID = 1L;
	
	public SignUpPanel(MainWindow parent){
		this.parent = parent;
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
		
		join = new JButton();
		add(join);
		join.setBounds(400, 357, 85, 30);
		join.setContentAreaFilled(false);
		join.setFocusable(false);
		join.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				try {
					String url = "http://s103062217.web.2y.idv.tw/java/index.php";
					Runtime.getRuntime().exec("cmd /c start " + url);
				} 
				catch (MalformedURLException e1) { 
				} 
				catch (IOException e1) {   
				}
			}
		});
		
		web = new JButton();
		add(web);
		web.setBounds(500, 357, 85, 30);
		web.setContentAreaFilled(false);
		web.setFocusable(false);
		web.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				try {
					String url = "http://s103062217.web.2y.idv.tw/java/index.php";
					Runtime.getRuntime().exec("cmd /c start " + url);
				} 
				catch (MalformedURLException e1) { 
				} 
				catch (IOException e1) {   
				}
			}
		});
		
	    signup = new JButton("");
	    add(signup);
		signup.setBounds(596, 237, 84, 41);
		signup.setContentAreaFilled(false);
		signup.setFocusable(false);
		//signup.setBorderPainted(false);
	    signup.addActionListener(new ActionListener() {          
	        public void actionPerformed(ActionEvent e) {
	        	if(account.getText().length() <= 0)
	        		JOptionPane.showMessageDialog(null, "�п�J�b���C", "MapleStory :", JOptionPane.ERROR_MESSAGE);
	        	else if(password.getText().length() <= 0)
	        		JOptionPane.showMessageDialog(null, "�п�J�K�X�C", "MapleStory :", JOptionPane.ERROR_MESSAGE);
	        	else
	        		parent.checkAccount(account.getText(), password.getText());
	       }
	   });
		
		
		try
		{ 
				mouse = ImageIO.read(this.getClass().getResourceAsStream("/mouse.png")); //���J�Ϥ�
                image=ImageIO.read(this.getClass().getResourceAsStream("/signup_image.jpg")); //���J�Ϥ��I��
                //Cursor cr = Toolkit.getDefaultToolkit().createCustomCursor( mouse , new Point(0,0) ,"MyCursor" );
                Cursor cr = toolkit.createCustomCursor( mouse , new Point(0,0) ,"MyCursor" );
                toolkit.getBestCursorSize(32, 32);
        		this.setCursor( cr );
        }
		catch(Exception e)
		{ 
                javax.swing.JOptionPane.showMessageDialog(null, "���Jsignup���ɿ��~"); 
                e.printStackTrace();
        }
		this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		this.setSize(new Dimension(image.getWidth(), image.getHeight()));
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

