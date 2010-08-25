package ro.financy.domain;

/**
 * Created by IntelliJ IDEA.
 * User: MacPro
 * Date: Jul 2, 2010
 * Time: 7:22:59 PM
 */
public final class Tag {

    private final String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return !(name != null ? !name.equalsIgnoreCase(tag.name) : tag.name != null);

        }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
