import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JMenu;
public class MainWindow extends JFrame implements ActionListener
{   private static final long serialVersionUID = 1L;
	static String loginName;
	static String loginNo;
	JLabel mlabel;
	JPanel jp=new JPanel();      
 	//建立菜单栏
	JMenuBar menu=new JMenuBar();
    JMenu a=new JMenu();
	JMenu b=new JMenu();
	JMenu c=new JMenu();	
    //建立系统管理菜单组
	JMenuItem aa=new JMenuItem();
	JMenuItem ab=new JMenuItem();
	JMenuItem ac=new JMenuItem();
    //建立读者管理菜单组
	JMenuItem bb=new JMenuItem();
	//建立书籍管理菜单组
	JMenuItem ca=new JMenuItem();
	JMenuItem cb=new JMenuItem();
	JMenuItem cc=new JMenuItem();
	JMenuItem cd=new JMenuItem();
public MainWindow(){
    super("图书管理系统");
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);}});
			Container d=getContentPane();
			this.setSize(300,200);
			this.setTitle("图书管理系统");
			d.add(menu);
			menu.add(a);
			menu.add(b);
			menu.add(c);
			//添加菜单组
			a.setText("系统管理");
			a.setFont(new Font("Dialog",0,12));
			b.setText("读者管理");
			b.setFont(new Font("Dialog",0,12));
			c.setText("书籍管理");
			c.setFont(new Font("Dialog",0,12));
			//生成系统管理菜单组的选项
			aa.setText("登录");
			aa.setFont(new Font("Dialog",0,12));
			ab.setText("退出登录");
			ab.setFont(new Font("Dialog",0,12));
			ac.setText("退出系统");
			ac.setFont(new Font("Dialog",0,12));
			//生成读者管理菜单组的选项
			bb.setText("查询读者信息");
			bb.setFont(new Font("Dialog",0,12));
			//生成书籍管理菜单组的选项
			ca.setText("添加书籍");
			ca.setFont(new Font("Dialog",0,12));
			cb.setText("删除书籍");
			cb.setFont(new Font("Dialog",0,12));
			cc.setText("查询读书信息");
			cc.setFont(new Font("Dialog",0,12));
			cd.setText("更新书籍");
			cd.setFont(new Font("Dialog",0,12));
			//添加系统管理菜单组
			a.add(aa);
			a.add(ab);
			a.add(ac);
			//添加读者管理菜单组
			b.add(bb);
			//添加书籍管理菜单组
			c.add(ca);
			c.add(cb);
			c.add(cc);
			c.add(cd);
			//添加事件侦听
			aa.addActionListener(this);
			ab.addActionListener(this);
			ac.addActionListener(this);
			bb.addActionListener(this);
			ca.addActionListener(this);
			cb.addActionListener(this);
			cc.addActionListener(this);
			cd.addActionListener(this);
			setJMenuBar(menu);}
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==aa){

					UserLogin login=new UserLogin(this);
					login.setVisible(true);}
					if(e.getSource()==ab){

					setVisible(false);
					MainWindow mainFrame=new MainWindow();
					mainFrame.setLocation(400,150);
					mainFrame.setVisible(true);
						}
			if(e.getSource()==ac)
			{System.exit(0);}
			if(e.getSource()==cc)
			{FindBook findbook=new FindBook();
			findbook.setVisible(true);
			}
			if(e.getSource()==bb)
			{
			FindReader findreader=new FindReader();
			findreader.setVisible(true);
			}
			if(e.getSource()==ca)
			{
			AddBook addBook=new AddBook();
			addBook.setVisible(true);
			}
			if(e.getSource()==cb)
			{
			DeleteBook delBook=new DeleteBook();
			delBook.setVisible(true);
			}
			if(e.getSource()==cd)
			{
			UpdateBook updBook=new UpdateBook();
			updBook.setVisible(true);
			}}
			public void setenabled(int right)
			{if(right==1)
			{
			b.setEnabled(true);
			c.setEnabled(true);}
			if(right==2)
			{
			b.setEnabled(true);
			c.setEnabled(true);}
			}
			public static void main (String[] args){
				MainWindow mainFrame=new MainWindow();
				mainFrame.setLocation(400,200);
				mainFrame.setVisible(true);
			}
			}
