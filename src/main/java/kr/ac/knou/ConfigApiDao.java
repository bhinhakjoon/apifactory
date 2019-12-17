package kr.ac.knou;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigApiDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void create(ConfigApi api) {
		sqlSession.insert("insert", api);
	}

	public ConfigApi retrieve(String id) {
		return sqlSession.selectOne("read", id);
	}

	public int update(ConfigApi api) {
		return sqlSession.insert("update", api);
	}

	public int delete(String id) {
		return sqlSession.delete(id);
	}

	public List<ConfigApi> list() {
		return sqlSession.selectList("selectList");
	}
	
	public Object readAttr(String id){
		return sqlSession.selectOne("selectAttr", id);
	}
	
	public int updateAttr(String id,String obj) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("id", id);
		param.put("attr",obj);
		return sqlSession.insert("updateAttr", param);
	}
}
