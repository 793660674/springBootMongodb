package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//对应的mongo 的 collection  集合名称
@Document(collection="users")
//复合索引，加复合索引后通过复合索引字段查询将大大提高速度。
@CompoundIndexes({
    @CompoundIndex(name = "age_idx", def = "{'name': 1, 'age': -1}")
})
public class Users  implements Serializable{

    //@Id
    //MongoDB默认会为每个document生成一个 _id 属性，作为默认主键，且默认值为ObjectId,可以更改 _id 的值(可为空字符串)，
    // 但每个document必须拥有 _id 属性。
    //当然，也可以自己设置@Id主键，不过官方建议使用MongoDB自动生成。

    private static final long serialVersionUID = 1L;
    //@Indexed
    //声明该字段需要加索引，加索引后以该字段为条件检索将大大提高速度。
    //唯一索引的话是@Indexed(unique = true)。
    //也可以对数组进行索引，如果被索引的列是数组时，mongodb会索引这个数组中的每一个元素。
    @Indexed
    private String uid;
    //@Field
    //代表一个字段，可以不加，不加的话默认以参数名为列名。
    @Field("name")
    private String name;
    private int age;
    //@Transient
    //被该注解标注的，将不会被录入到数据库中。只作为普通的javaBean属性。
    @Transient
    private String address;
   
    public Users(String uid, String name, int age) {
        super();
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[name='%s', age='%s']",
                 name, age);
    }
}