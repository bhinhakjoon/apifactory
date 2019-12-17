package kr.ac.knou;

import java.util.List;

public interface ConfigApiService {
	public List<ConfigApi> list();
	public void create(ConfigApi api);
	public ConfigApi retrieve(String id);
	public void update(ConfigApi api);
	public void delete(String id);
	public Object readAttr(String id);
	public void updateAttr(String id,String obj);
}
