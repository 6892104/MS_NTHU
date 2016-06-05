package role;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import MapleStory.Control;
import MapleStory.MapWithObsticle;
import display.DisplayPanel;


public class NPC extends Role{
	protected Control parent;
	protected JButton button;
	protected MouseAdapter mouseListen;
	protected int ScreenX, ScreenY;
	private Task task;
	
	public NPC(String name, DisplayPanel display,MapWithObsticle map, Control control){
		super(name, display, map);
		this.parent = control;
		width = 200;
	    height = 100;
	    x = 1000;
	    y = 1000;
	    /*shift = 0;
	    move_range_left=0;
	    move_range_right=map.getMax_x();*/


	    move_pace=1;
	    level=1;

	    money = 0;
	    
	    button = new JButton();
	    button.setContentAreaFilled(false);
	    button.setFocusable(false);
	    button.setBorderPainted(false);
	    mouseListen = new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	/*JOptionPane.showMessageDialog(null, "���ƶܡH", "ToolMan :", JOptionPane.INFORMATION_MESSAGE );
	        	int option = JOptionPane.showConfirmDialog(null, "�Q�Q�z�H", "ToolMan :", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        	if(option == JOptionPane.YES_OPTION)
	        		System.exit(0);*/
	        	if(e.getClickCount() == 2){
	        		if(task == null)
	        			createTask();
	        		else
	        			task.check();
	        	}
	        }
        };
	    button.addMouseListener(mouseListen);
        display.add(button);
	}
	
	public void set(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		button.setIcon(new ImageIcon(display.getNPCImage(name).getScaledInstance( width - 2, height - 2,  java.awt.Image.SCALE_SMOOTH )));
	}
	
	public void move(int x, int y){
		//System.out.println(x + " " + y);
		this.ScreenX = x;
		this.ScreenY = y;
		button.setBounds(ScreenX, ScreenY, width, height);
	}
	
	public boolean checkBag(String name, int number){
		return parent.checkBag(name, number);
	}
	
	public void reward(int exp, int money){
		parent.rewardCharacter(exp, money);
	}
	
	public void removeTask(){
		task = null;
	}
	
	public void removeButton(){
		display.remove(button);
	}
	
	private void createTask(){
		task = new Task(name, this);
	}
}
