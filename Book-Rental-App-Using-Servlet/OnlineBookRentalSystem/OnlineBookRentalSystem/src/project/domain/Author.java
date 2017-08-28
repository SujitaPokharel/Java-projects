package project.domain;

public class Author {

	private Name name;

	public Author(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {

		return "[Author: " + name.toString() + " ]";
	}
}
