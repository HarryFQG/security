package m.itiandou.springsecurity2.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fengqigui
 * @description 用户实体
 * @date 2018/05/02 09:39
 */
public class User implements UserDetails {

    private static String defaultRolePrefix = "ROLE_";

    private static final long serialVersionUID = 6095384564471868081L;

    private Integer id;

    private String name;

    private  String pwd;


    private Set<String> authentications;

    private List<Authentication> authenticationList;

    public User() {
    }


    public User(Integer id, String name, String pwd, Set<String> authentications, List<Authentication> authenticationList) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.authentications = authentications;
        this.authenticationList = authenticationList;
    }

    public Set<String> getAuthentications() {
        return authentications;
    }

    public void setAuthentications(Set<String> authentications) {
        this.authentications = authentications;
    }

    public List<Authentication> getAuthenticationList() {
        return authenticationList;
    }

    public void setAuthenticationList(List<Authentication> authenticationList) {
        this.authenticationList = authenticationList;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authenticationList != null){
            authentications = new HashSet<>();
            for(Authentication a:authenticationList){
                if(!authentications.contains(a.getName())){
                    authentications.add(a.getName());
                }
            }
        }
        // 默认访客权限
        if (authentications == null) {
            authentications = Collections.singleton(defaultRolePrefix+"guest");
        }
        List<SimpleGrantedAuthority> collect = authentications.stream()
                .map(p -> new SimpleGrantedAuthority(defaultRolePrefix + p))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
