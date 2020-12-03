package sppringBootStudy001.com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bean001") //表示和配置文件对应，读取prefix对应的配置相关
public class Bean001 {
	private String name;
	private int age;
	private String[] lovers;
	@Value("${sayMe}")
	private String syame;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getLovers() {
		return lovers;
	}

	public void setLovers(String[] lovers) {
		this.lovers = lovers;
	}

	public String getSyame() {
		return syame;
	}

	public void setSyame(String syame) {
		this.syame = syame;
	}
}
