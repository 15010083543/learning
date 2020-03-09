package com.designPattens.prototypePatten;

import lombok.Data;

/*
   原形模式
 */
@Data
public class StudentPrototype implements Cloneable {

    private int age;
    private String name;
    private byte[] bytes = new byte[1000];
    private TeacherPrototype teacherPrototype = new TeacherPrototype();

    @Override
    public String toString() {
        return "StudentPrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacherPrototype=" + teacherPrototype +
                '}';
    }

    @Override
    protected Object clone() {
        StudentPrototype studentPrototype = null;
        try {
            studentPrototype = (StudentPrototype)super.clone();
            TeacherPrototype teacherPrototype = (TeacherPrototype) this.teacherPrototype.clone();
            studentPrototype.setTeacherPrototype(teacherPrototype);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return studentPrototype;
    }
}
