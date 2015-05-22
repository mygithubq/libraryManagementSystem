import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class FindBook extends JFrame implements ActionListener
{   DataBaseManger db=new DataBaseManger();
	ResultSet rs;
	JLabel select=new JLabel("请输入书名或者索书号");
	JTextField jtf=new JTextField(20);
	JPanel a=new JPanel();
	JPanel b=new JPanel();
	JLabel lb=new JLabel("书籍信息");
	JButton findbt=new JButton("查询");
	JButton yesbt=new JButton("确定");
	JTextArea jta=new JTextArea(10,10);
	public FindBook()
	{   super("查询书籍信息");
		Container c=getContentPane();
		a.add(select);
		a.add(jtf);
		a.add(findbt);
		c.add(a,BorderLayout.NORTH);
		b.add(lb);
		b.add(jta);
		b.add(yesbt);
		c.add(b,BorderLayout.SOUTH);
		yesbt.addActionListener(this);
		findbt.addActionListener(this);
		setSize(500,300);
		setVisible(true);
		setLocation(400,150);
	}
	public void actionPerformed(ActionEvent e)
	{   if(e.getActionCommand()=="确定")
			this.dispose();
		if(e.getActionCommand()=="查询")
		{   String bname=jtf.getText();
			String bno=jtf.getText();
			String sqlstr;
			sqlstr="select * from book where bname='"+bname+"' or bno='"+bno+"'";
			rs=db.getResult(sqlstr);
			try
			{   jta.setText("");
				if(rs.next()){
		jta.append("索书号为:"+rs.getString(1)+"\n");           
        jta.append("书名为:"+rs.getString(2)+"\n");            
        jta.append("现有数量为:"+rs.getString(3)+"\n");            
        jta.append("出版社为:"+rs.getString(5)+"\n");
		jta.append("作者为:"+rs.getString(4)+"\n");   }
				else
				{jta.append("对不起，没有您要找的书籍！"); } }
			catch(Exception pe) 
			{ pe.printStackTrace();        		 	
	} }}}
