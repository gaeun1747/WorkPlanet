import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		try{
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			//db연결
			Connection con = null;
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="hr";
			String password="hr";
			con = DriverManager.getConnection(url, user, password);

			String updateSQL="UPDATE product SET prod_price=prod_price*1.1 WHERE cate_no='M'";
			Statement stmt=null;
			stmt= con.createStatement();
			
			int rowcnt=stmt.executeUpdate(updateSQL);//DML,DDL 처리가능
			System.out.println(rowcnt);
			stmt.close();
			con.close();
			*/
			
			Connection con = null;
			con = com.my.sql.Myconnection.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("상품번호");
			String no = sc.nextLine();
			
			System.out.println("상품명");
			String name = sc.nextLine();
			
			System.out.println("가격");
			int price = sc.nextInt();
			
//			String insertSQL="INSERT INTO product(prod_no, prod_name, prod_price)"
//			+" VALUES ('"+no+"','"+name+"',"+price+")";
//			System.out.println(insertSQL);
//			Statement stmt=null;
//			stmt=con.createStatement();
//			stmt.executeUpdate(insertSQL);
//			System.out.println("상품등록 성공!");

			
			String insertSQL="INSERT INTO product(prod_no, prod_name, prod_price)"
				+" VALUES (?,?,?)";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(insertSQL);
			pstmt.setString(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.executeUpdate();
			
			 
			System.out.println("상품등록 성공!");
			//com.my.sql.Myconnection.close(stmt,con);
			//com.my.sql.Myconnection.close(rs,stmt,con);
			/*
			String selectSQL = "SELECT count(*) cnt FROM product";
			Statement stmt = null;
			stmt=con.createStatement();
			ResultSet rs = null;
			rs=stmt.executeQuery(selectSQL);
			rs.next();
			int cnt=rs.getInt("cnt");
			System.out.println("상품수:"+cnt);
			*/
			/*
			//sql구문 송신
			String selectSQL= "SELECT prod_no, prod_name, prod_price, prod_reg_dt"+" FROM product";
			Statement stmt=null;
			ResultSet rs = null;
			stmt=con.createStatement();
			rs=stmt.executeQuery(selectSQL);
			
			while(rs.next()){
			String no = rs.getString("prod_no");
			String name = rs.getString("prod_name");
			int price = rs.getInt(3);
			java.sql.Date reg_dt = rs.getDate("prod_reg_dt");
			System.out.println(no+":"+name+":"+price+":"+reg_dt);
			}
			//db 연결닫기
			rs.close();
			stmt.close();
			con.close();
			*/
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
