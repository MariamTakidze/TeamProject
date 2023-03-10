package mybatisdao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSessionFactory factory;
	
	static {
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch(IOException e) {
			System.out.println(e.getMessage());		
		}
		
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory () {
		return factory;
	}
}
