import java.sql.*;
import java.io.*;
public class DataBaseManger
{      
		String name;
		Connection con;
		Statement stmt;
		ResultSet rs;
		public DataBaseManger(){
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
				System.out.println("驱动加载完成");
				System.out.println("已建立链接");
con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=library","sa","sqlserver2005");
	        	stmt=con.createStatement();  
	        }catch (Exception e){
				 e.printStackTrace(); 
			 } 
		}
			public ResultSet getResult(String strSQL)
		{   try
			{ rs=stmt.executeQuery(strSQL);
			return rs;	}
			catch(SQLException sqle)
			{System.out.println(sqle.toString());
			return null;	}}
	        public boolean updateSql(String strSQL)
        {  try
        	{stmt.executeUpdate(strSQL);
        	con.commit();
                return true;	}
       		 catch(SQLException sqle)
        	{System.out.println(sqle.toString());
        	return false; }  }
        public void closeConnection()
        {  try
        	{con.close(); }
        	catch(SQLException sqle)
        	{System.out.println(sqle.toString());} }}
