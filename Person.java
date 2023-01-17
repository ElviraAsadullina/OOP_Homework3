import java.util.LinkedHashSet;
import java.util.Set;


public class Person extends Human {
    Human spouse;
    LinkedHashSet<Human> brothers_sisters;
    LinkedHashSet<Human> children;
    LinkedHashSet<Human> parents;

    public Person(Integer id, String name, String sex, Human spouse,
                  LinkedHashSet<Human> brothers_sisters,
                  LinkedHashSet<Human> children, LinkedHashSet<Human> parents) {
        super(id, name, sex);
        this.spouse = spouse;
        this.brothers_sisters = brothers_sisters;
        this.children = children;
        this.parents = parents;
    }

    public Integer getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Human getSpouse() {
        return spouse;
    }

    public LinkedHashSet<Human> getBrothers_sisters() {
        return brothers_sisters;
    }

    public LinkedHashSet<Human> getChildren() {
        return children;
    }

    public LinkedHashSet<Human> getParents() {
        return parents;
    }

    public void setParents(LinkedHashSet<Human> parents) {
        this.parents = parents;
    }

    public void setChildren(LinkedHashSet<Human> children) {
        this.children = children;
    }
    public String getNamesFromSetOnly(Set<Human> hum) {
        String s = "";
        if (hum == null) {
            s = "Нет";
        }
        else {
            for (Human item : hum) {
                s += item.getName() + ", ";
            }
        }
        return s;
    }
    public String getNamesFromHumanOnly(Human hum) {
        String s = "";
        if (hum == null) {
            s = "Нет";
        }
        else {
            s = hum.getName();
        }
        return s;
    }

    @Override
    public String toString() {
        String human = "\n" + "=".repeat(47) +
                "\nID:            \t" + id +
                "\nИмя:           \t" + name +
                "\nПол:           \t" + sex +
                "\nСупруг:        \t" + getNamesFromHumanOnly(spouse) +
                "\nБратья/Сестры: \t" + getNamesFromSetOnly(brothers_sisters) +
                "\nДети:          \t" + getNamesFromSetOnly(children) +
                "\nРодители:      \t" + getNamesFromSetOnly(parents) + "\n";
        return human;
    }
}