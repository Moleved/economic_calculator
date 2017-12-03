package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="application")
public class ApplicationEntity extends ActiveModel {
    @Id @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<ApplicationEntity> getAll() {
        ArrayList<ActiveModel> list = (ArrayList<ActiveModel>) getAll(ApplicationEntity.class);
        ArrayList<ApplicationEntity> result = new ArrayList<ApplicationEntity>();

        for (ActiveModel elem : list) {
            result.add((ApplicationEntity) elem);
        }

        return result;
    }

    public static ApplicationEntity getLast() {
        try {
            return (ApplicationEntity) getLast(ApplicationEntity.class);
        } catch (Exception ex) {
            return null;
        }
    }

    public static ApplicationEntity getById(int id) {
        try {
            return (ApplicationEntity) getById(id, ApplicationEntity.class);
        } catch (Exception ex) {
            return null;
        }
    }
}
