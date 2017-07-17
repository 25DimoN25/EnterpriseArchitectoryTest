package archlab.entity;

public enum GroupType {
	UNKNOWN("Неизвестно"), BACHELOR("Бакалавриат"), SPECIALIST("Специалитет"), MASTER("Магистратура");

	private String name;

	GroupType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "GroupType{" +
				"name='" + name + '\'' +
				'}';
	}
}
