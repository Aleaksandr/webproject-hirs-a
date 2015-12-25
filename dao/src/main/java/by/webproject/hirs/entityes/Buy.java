package by.webproject.hirs.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "buy")
public class Buy implements Serializable {

    private static final long serialVersionUID = -4304667542542813169L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private Double prise;

    public Buy() {

    }

    public Buy(String name, Double prise) {
        this.name = name;
        this.prise = prise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prise=" + prise +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buy buy = (Buy) o;

        if (id != buy.id) return false;
        if (name != null ? !name.equals(buy.name) : buy.name != null) return false;
        return !(prise != null ? !prise.equals(buy.prise) : buy.prise != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (prise != null ? prise.hashCode() : 0);
        return result;
    }
}
