package m.itiandou.springsecurity2.entity;

/**
 * @author fengqigui
 * @description 权限实体
 * @date 2018/05/02 09:40
 */
public class Authentication {


    private Integer id;
    /**
     * 权限名字
     */
    private String name;

    public Authentication() {
    }

    public Authentication(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
