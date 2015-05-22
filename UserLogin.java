import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
public class UserLogin extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	String name;
	DataBaseManger db=new DataBaseManger();
	MainWindow mainFrame;
	JFrame f=null;
	JPanel panel1,panel2;
	JLabel UserLabel,PasswordLabel;
	JTextField UserTextField;
	JPasswordField PasswordTextField;
	JButton YesBtn,CancelBtn;
	Container c;
	ResultSet rs;
	public UserLogin(MainWindow mainFrame)
	{
		super("用户登录");
		this.mainFrame=mainFrame;
		UserLabel=new JLabel("用户名",JLabel.CENTER);
		PasswordLabel=new JLabel("密码",JLabel.CENTER);
		UserTextField=new JTextField(10);
		PasswordTextField=new JPasswordField(10);
		YesBtn=new JButton("确定");
CancelBtn=new JButton("取消");
YesBtn.addActionListener(this);
CancelBtn.addActionListener(this);
panel1=new JPanel();
panel1.setLayout(new GridLayout(2,2));
panel2=new JPanel();
c=getContentPane();
c.setLayout(new BorderLayout());
panel1.add(UserLabel);
panel1.add(UserTextField);
panel1.add(PasswordLabel);
panel1.add(PasswordTextField);
c.add(panel1,BorderLayout.CENTER);
panel2.add(YesBtn);
panel2.add(CancelBtn);
c.add(panel2,BorderLayout.CENTER);
setSize(300,150);
JLabel JL=new JLabel();
c.add(JL,"North");
c.add(panel1,"Center");
c.add("South",panel2);
panel1.setBackground(new Color(255,255,255));
setLocation(400,200);
}
public void actionPerformed(ActionEvent e)
{if(e.getSource()==CancelBtn)
{this.dispose();}
else
{char[] password=PasswordTextField.getPassword();
String passwordSTR=new String(password);
String strSQL;
strSQL="select * from users where uname='"+UserTextField.getText().trim()+"'and upassword='"+passwordSTR+"'";
rs=db.getResult(strSQL);
boolean isExist=false;
try
{   rs.next();
mainFrame.loginNo=rs.getString(1);
name=rs.getString(1);
mainFrame.loginName=name;
int right;
right=rs.getInt(1);
mainFrame.setenabled(right);
if(name.length()!=0)
isExist=true;
}
catch(Exception pe)
{ pe.printStackTrace(); }
if(UserTextField.getText().trim().equals(""))
{
JOptionPane.showMessageDialog(null,"用户名不可为空!");
return;
}
if(passwordSTR.equals(""))
{
JOptionPane.showMessageDialog(null,"密码不可为空!");
return;
}
if(!isExist)
{ JOptionPane.showMessageDialog(null,"用户名不存在或者密码不正确!");}
else
{JOptionPane.showMessageDialog(null,"登录成功");
this.dispose();}
}}}
