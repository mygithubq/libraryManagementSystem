import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.lang.String;
public class FindReader extends JFrame implements ActionListener
{   DataBaseManger db=new DataBaseManger();
	MainWindow mw=new MainWindow();
	ResultSet rs;
	JLabel select=new JLabel("请输入证件号");
	JTextField jtf=new JTextField(10);
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel(); 
	JLabel lb=new JLabel("读者信息");
	JButton findbt=new JButton("查询");
	JButton yesbt=new JButton("确定");
	JTextArea jta=new JTextArea(10,10);
	public FindReader()
	{   super("查询读者信息");
	Container c=getContentPane();
		p1.add(select);
		p1.add(jtf);
		p1.add(findbt);
		c.add(p1,BorderLayout.NORTH);
		p2.add(lb);p2.add(jta);
       c.add(p2,BorderLayout.CENTER);
		p4.add(yesbt);
        c.add(p4,BorderLayout.SOUTH);
		yesbt.addActionListener(this);
		findbt.addActionListener(this);
		setSize(500,300);
		setVisible(true);
		setLocation(400,150);
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getActionCommand()=="确定")
			this.dispose();
		if(e.getActionCommand()=="查询")
		{
			String sno=jtf.getText();
			String sqlstrR;
if((mw.loginNo.trim().equals(sno))||(mw.loginName.trim().equals("admin")))
			{   sqlstrR="select * from reader where sno='"+sno+"'";
				rs=db.getResult(sqlstrR);
				try
				{    rs.next();
					jta.setText("");
jta.append("学号为:"+rs.getString(1)+"， "+"姓名为:"+rs.getString(2)+"，"+"性别为:"+rs.getString(3)+"\n");
jta.append("年龄为:"+rs.getString(4)+"，  "+"密码为:"+rs.getString(5)+"，"+" 学院为:"+rs.getString(6)+"\n");
		       	    String sqlstr="select * from lendbook where sno='"+sno+"'";
			    	rs=db.getResult(sqlstr);}
				catch(Exception pe) 
				{   pe.printStackTrace();  } }
			else
			{
				JOptionPane.showMessageDialog(null,"请输入正确的证件号!");
	}}}}
