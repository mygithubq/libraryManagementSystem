import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class UpdateBook extends JFrame implements ActionListener  
{    MainWindow mw=new MainWindow();
	DataBaseManger db=new DataBaseManger();
	ResultSet rs;
	JPanel a,b,c,d,e,f;
	JLabel bname=new JLabel();
	JLabel bno=new JLabel();
	JLabel bnum=new JLabel();
	JLabel author=new JLabel();
	JLabel publisher=new JLabel();
	JTextField tname=new JTextField(20);
	JTextField tno=new JTextField(20);
	JTextField tnum=new JTextField(20);
	JTextField tauthor=new JTextField(20);
	JTextField tpublisher=new JTextField(20);
	JButton addbt=new JButton("更新");
    JButton yesbt=new JButton("确定");
	JPanel p3=new JPanel();
	public UpdateBook()
	{   super("更新图书");
		a=new JPanel();		
		b=new JPanel();	
		c=new JPanel();		
		d=new JPanel();
		e=new JPanel();
		f =new JPanel();
        bname.setText("书名  ：");
        bname.setFont(new Font("Dialog",0,12));
        bno.setText(" 索书号  ：");
        bno.setFont(new Font("Dialog",0,12));
        bnum.setText("数量：");
        bnum.setFont(new Font("Dialog",0,12));
       author.setText("作者：");
       author.setFont(new Font("Dialog",0,12));
       publisher.setText(" 出版社  ：");
       publisher.setFont(new Font("Dialog",0,12));
       a.add(bname);
        a.add(tname);	
		b.add(bno);
        b.add(tno);		
		c.add(bnum);	
        c.add(tnum);	
		d.add(author);
        d.add(tauthor);
		e.add(publisher);
        e.add(tpublisher);	
		f.add(addbt);
        f.add(yesbt);	
		add(a); 
        add(b);
                add(c);
                add(d);
                add(e);
                add(f);
       setLayout(new GridLayout(8,1));	
		addbt.addActionListener(this);
		yesbt.addActionListener(this);
		setSize(500,300);
		setLocation(400,150);	}
   public void actionPerformed(ActionEvent e)
	{   String bname,bno,author,publisher;
		int bnum;
		if(e.getActionCommand()=="确定")
			this.dispose();
		if(e.getActionCommand()=="更新")
		{   bname=tname.getText();
			bno=tno.getText();
			author=tauthor.getText();
			publisher=tpublisher.getText();
			bnum=Integer.parseInt(tnum.getText());
			String sqlstr1="select bno from book";
			rs=db.getResult(sqlstr1);			
			try{   while(rs.next())
				{     if(rs.getString(1).trim().equals(bno))
					{
		JOptionPane.showMessageDialog(null,"此书号已存在，请重新输入索书号!");}
					else
					{break;}}}
			catch(Exception pe) 
			{ pe.printStackTrace();       		 } 
                                                String sqlstr="update book set bno='"+bno+"',bname='"+bname+"',bnum='"+bnum+"',author='"+author+"',publisher='"+publisher+"'where bno='"+bno+"'";
          Boolean result=db.updateSql(sqlstr);
	        db.closeConnection();
	        if(result)
	        {JOptionPane.showMessageDialog(null,"更新书籍成功!"); }
	        else
	        {	JOptionPane.showMessageDialog(null,"更新书籍失败!");   }  
		}
		}
   }
