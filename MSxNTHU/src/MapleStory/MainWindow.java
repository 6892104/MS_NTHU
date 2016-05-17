package MapleStory;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	/*private slots:
	    void handleButton();
	    void back_to_menu();
	    void gameStart();
	    void keyaction();
	    void tcreator(int,int,std::string);
	    void deadinfor(int);
	    void deadanima();
	    void green_mode();*/
	//private ModForGame gameMod;
	//private Menu *menu;
	private Control control;
	private KeyControl keyControl;

	private MapWithObsticle map;
	private DisplayPanel display;
	private Beginner role;

	    /*enum Monster{pig,green};
	    Monster which;
	    Pig * piggy[20];
	    int pig_num;
	    Green * greens[20];
	    int green_num;

	    Status *status;
	    QPushButton * button , *button2 , *deadbutton;
	    std::vector <Item *> treasure;
	    Item * item[9];
	    Bag *bag;
	    int have_item[9];
	    std::string str[9];
	    std::map <std::string,bool> key;

	    easyMusic *start_bgm;

	    easyMusic *drop,*picks,*tombfall;*/
	    //add the sound effect here

	public MainWindow(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setPreferredSize(new Dimension(1240, 760));
	    this.setSize(1240, 760);
	    this.setLayout(null);
		this.setLocation(300, 100);
		//read picture
		try {
			Image backGround = ImageIO.read(this.getClass().getResourceAsStream("/attack.0.png"));
			this.setIconImage(backGround);
		}catch (IOException ie){
			javax.swing.JOptionPane.showMessageDialog(null, "���J���ɿ��~");
		}
	    this.setTitle("MapleStory");
	    this.setUndecorated(true); //no border
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
	    //this.setResizable(false);
	    //this.pack();
	    //this.setex
	    
	    display = new DisplayPanel();
	    
	    
	    this.add(display);
	    keyControl = new KeyControl();
	    this.addKeyListener(keyControl);
	    this.setVisible(true);
	    display.setBounds(0, 0, this.getWidth(), this.getHeight());
	System.out.println("ass " + this.getWidth() + " "+ this.getHeight());
	    //which = pig;
	
	    /*play_bgm = true;
	    play_soundEffect = true;
	    char startBG[30] = "Sound/bgm.mp3";
	    char sdrop[30]="Sound/DropItem.mp3";
	    char spick[30]="Sound/PickUpItem.mp3";
	    char stombfall[30]="Sound/dead.mp3";
	    picks = new easyMusic(spick,80,0);
	    drop = new easyMusic(sdrop,80,0);
	    tombfall = new easyMusic(stombfall,80,0);
	
	
	    start_bgm = new easyMusic(startBG,80,1);
	    start_bgm->stop();
	
	    this->gameMenu();*/
	    gameStart();
	}
	    //~MainWindow();

	private void gameMenu(){
		
	}
	
	private void gameStart()
	{
	    //menu->hide();
	    //gameMod = StartMod;
	    //if(play_bgm) start_bgm->play();

	    /*Timer = new QTimer(this);
	    Timer->start(40);*/

	    map = new MapWithObsticle(this);
	    display.setMap(map);
	    //map->show();
	    //connect(Timer,SIGNAL(timeout()),map,SLOT(update()));

	    role = new Beginner(this, display, map);
	    display.setCharacter(role);
	    /*role->show();
	    connect(Timer,SIGNAL(timeout()),role,SLOT(update()));
	    connect(Timer,SIGNAL(timeout()),role,SLOT(RoleAction()));
	    connect(role,SIGNAL(dead(int)),this,SLOT(deadinfor(int)));*/

	    control = new Control();
	    control.setCharacter(role);
	    control.setDisplay(display);
	    control.setKeyControl(keyControl);
	    control.start();


	    //create monster
	    /*createmonster();

	    bag = new Bag(this);
	    bag->move(1000,100);
	    bag->hide();

	    for(int i=0;i<9;i++)
	    have_item[i]=0;

	    str[1]="apple";
	    str[2]="red_medicine";
	    str[3]="blue_snail_shell";
	    str[4]="full_medicine";
	    str[5]="orange_medicine";
	    str[6]="blue_medicine";
	    str[7]="mushroom_cap";
	    str[8]="green_wet_fairy";
	    status = new Status(bag,this);
	    status->show();
	    status->move(0,620);
	    connect(Timer,SIGNAL(timeout()),status,SLOT(update()));
	    connect(role,SIGNAL(state_change(int,int,int,int)),status,SLOT(get_state(int,int,int,int)));    //bug,use item will change back

	    button=new QPushButton("", this);
	    //button->setGeometry(QRect(QPoint(100, 100),QSize(200, 50)));
	    button->setFixedSize(50 , 50);
	    button->move(860,645);
	    QPixmap pix(QString(":/Image/bag_button.png"));
	    button->setIcon( QIcon(pix) );                     // set Icon picture
	    button->setIconSize( pix.rect().size() );          // set Icon size to the size of picture
	    button->setFlat(true);                             // hide the frame
	    button->show();

	    connect(button, SIGNAL (pressed()), this, SLOT (handleButton()));

	    //button2
	    button2 = new QPushButton("EXIT", this);
	    button2->setFixedSize(50 , 50);
	    button2->move(930,660);

	    button2->show();
	    connect(button2, SIGNAL (pressed()), this, SLOT (back_to_menu()));
	    //button2->setFocusPolicy( Qt::StrongFocus );

	    //deadbutton
	    deadbutton = new QPushButton("", this);
	    deadbutton->setFixedSize(280 , 140);
	    deadbutton->move(500 , 150);
	    deadbutton->hide();
	    pix.load(QString(":/Image/back_to_menu.png"));
	    deadbutton->setIcon( QIcon(pix) );
	    deadbutton->setIconSize( pix.rect().size() );
	    connect(deadbutton, SIGNAL (pressed()), this, SLOT (back_to_menu()));

	    this->setFocus();

	    key["right"]=false;
	    key["left"]=false;
	    connect(Timer,SIGNAL(timeout()),this,SLOT (keyaction()));

	    connect(Timer,SIGNAL(timeout()),this,SLOT (update()));*/
	    //display.repaint();
	}
	    /*void pick();
	    void createmonster();

	    enum{left=0,right=1};
	    enum{up=0,down=1};
	    QTimer *Timer;
	protected:
	    void paintEvent(QPaintEvent*);  
	    void keyPressEvent(QKeyEvent *); 
	    void keyReleaseEvent(QKeyEvent *);
	    void mouseReleaseEvent(QMouseEvent *);*/

	
	public static void main(String[] args) {
		new MainWindow();
	}

}
