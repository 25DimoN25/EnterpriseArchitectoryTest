package archlab.entity;

/**
 * Created by Dima on 22.04.2017.
 */
public enum Post {
	UNKNOWN("Неизвестно"), ASSISTANT("Ассистент"), TEACHER("Преподаватель"), HIGHT_TEACHER("Старший преподаватель"), DOCENT("Доцент"), PROFESSOR("Профессор");

	private String name;

	Post(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Post{" +
				"name='" + name + '\'' +
				'}';
	}
}
