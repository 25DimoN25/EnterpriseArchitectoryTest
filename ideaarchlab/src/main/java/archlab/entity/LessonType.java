package archlab.entity;

public enum LessonType {
	UNKNOWN("Неизвестно"), SEMINAR("Cеминар"), LECTURE("Лекция"), PRACTICE("Практика"), LABORATORY_WORK("Лабораторная работа");

	private String name;

	LessonType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "LessonType{" +
				"name='" + name + '\'' +
				'}';
	}
}
