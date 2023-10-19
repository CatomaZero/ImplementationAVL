public class Person implements Comparable<Person>{
    private String name;
    private String id;

    public Person(String id, String name){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person e) {
        return -name.compareTo(e.getName());
    }
}

