package tableviewfx;

import javafx.beans.property.*;

public class Student {
	
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty surname;
	private final SimpleIntegerProperty age;
	
	Student(Integer id, String name, String surname, Integer age) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.age = new SimpleIntegerProperty(age);
	}
	
	public Integer getId() {
		return id.get();
	}
	
	public String getName() {
		return name.get();
	}
	
	public String getSurname() {
		return surname.get();
	}
	
	public Integer getAge() {
		return age.get();
	}
	
}
