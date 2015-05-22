import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class DeleteBook extends JFrame implements ActionListener  
{   MainWindow mw=new MainWindow();
	DataBaseManger db=new DataBaseManger();
	ResultSet rs;
	JLabel bno=new JLabel("<html><font color=#000000 size='4'>请输入要删除的图书索引号：</font>",SwingConstants.CENTER);
	JLabel L;
	JTextField tno=new JTextField(10);
	JTable table;
	JButton delbt=new JButton("删除");
	JButton yesbt=new JButton("确定");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	public DeleteBook()
	{   super("删除图书");
		Container c=getContentPane();	
		p1.add(bno);
		p1.add(tno);		
		c.add(p1,BorderLayout.NORTH);
		p2.add(delbt);	
		p2.add(yesbt);
		c.add(p2,BorderLayout.SOUTH);
		delbt.addActionListener(this);
		yesbt.addActionListener(this);
		setSize(400,300);
		setLocation(400,150);
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());	}
	public void actionPerformed(ActionEvent e)
	{   String bno;		
	   if(e.getActionCommand()=="确定")
			this.dispose();
		if(e.getActionCommand()=="删除")
		{   bno=tno.getText();			
			String sqlstr="delete bno from book where bno='"+bno+"'";
	        boolean result=db.updateSql(sqlstr);
	        db.closeConnection();
	        if(result)
	        {JOptionPane.showMessageDialog(null,"删除书籍成功!");}
	        else
	        {JOptionPane.showMessageDialog(null,"删除书籍失败!");
	        }}}}
